package roychan.gill.tmtt.pt1.repository.impl;

import roychan.gill.tmtt.pt1.entity.ProfilEntity;
import roychan.gill.tmtt.pt1.repository.ProfilRepository;
import roychan.gill.tmtt.pt1.utill.HikariCPConnection;


import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfilRepositoryImpl  implements ProfilRepository {
    @Override
    public void insert(ProfilEntity profilEntity) {
        try(
                Connection connection = HikariCPConnection.getDataSource().getConnection()
        ) {
            final String SQL_QUERY = """
                    INSERT INTO profil(nama, tanggal_lahir, nomor_telepon)
                    VALUES(?, ?, ?);
                    """;

            try(PreparedStatement statement = connection.prepareStatement(SQL_QUERY, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, profilEntity.getNama());
                statement.setDate(2, new Date(profilEntity.getTanggal_lahir()));
                statement.setString(3, profilEntity.getNomor_telepon());

                // execute
                statement.executeUpdate();

                try(ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()){
                        profilEntity.setId(resultSet.getInt(1));

                        //TODO: hilangkan sout ketika ingin naik ke produksi
                        System.out.println("success Add ID: " + resultSet.getInt(1));
                    }
                }
            }
        }catch (SQLException e ){
            throw  new RuntimeException(e);
        }

    }

    @Override
    public ProfilEntity findById(Integer id) {
       try(Connection connection = HikariCPConnection.getDataSource().getConnection()) {
           String sql = "SELECT * FROM profil WHERE id= ?";
           try(PreparedStatement statement = connection.prepareStatement(sql)) {
               statement.setInt(1, id);
               try(ResultSet resultSet = statement.executeQuery()) {
                   if (resultSet.next()){
                       return  new ProfilEntity(
                               resultSet.getInt("id"),
                               resultSet.getString("nama"),
                               resultSet.getDate("tanggal_lahir").getTime(),
                               resultSet.getString("nomor_telepon")
                       );
                   }else {
                       return  null;
                   }

               }

           }

       }catch (SQLException e){
           throw new RuntimeException(e);
       }
    }

    @Override
    public List<ProfilEntity> findAll() {
        try(Connection connection = HikariCPConnection.getDataSource().getConnection()) {
            final String SQL_QUERY = "SELECT * FROM profil";
            try(Statement statement = connection.createStatement()) {
                try(ResultSet resultSet = statement.executeQuery(SQL_QUERY)) {
                    List<ProfilEntity> profiles = new ArrayList<>();
                    while (resultSet. next()){
                        profiles.add(
                                new ProfilEntity(
                                resultSet.getInt("id"),
                                resultSet.getString("nama"),
                                resultSet.getDate("tanggal_lahir").getTime(),
                                resultSet.getString("nomor_telepon")
                        ));
                    }
                    return profiles;
                }

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteById(Integer id) {

        try (Connection connection = HikariCPConnection.getDataSource().getConnection();){

            final String SQL_QUERY = "DELETE FROM profil WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(SQL_QUERY);) {
                statement.setInt(1,id);

                // execute di DB
                int rowEffected = statement.executeUpdate();
                return rowEffected > 0;
            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }






    }
}
