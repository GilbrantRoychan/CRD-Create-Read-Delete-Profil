package roychan.gill.tmtt.pt1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import roychan.gill.tmtt.pt1.entity.ProfilEntity;
import roychan.gill.tmtt.pt1.utill.HikariCPConnection;

import java.awt.image.RescaleOp;
import java.sql.*;

public class TestConnection {

    @Test
    @DisplayName("mengecek apakah ada terjadi error antara JDBC ->Driver->Database")
    void testConenction(){
        try(Connection connection = HikariCPConnection.getDataSource().getConnection()) {

            Assertions.assertNotNull(connection);

            DatabaseMetaData cekData = connection.getMetaData();
            System.out.println(cekData.getDatabaseProductVersion());

        }catch (SQLException e){
            Assertions.fail(e);
        }
    }

    @Test
    @DisplayName("ketika sudah connect, lakukan iterasi mengenai tipe data")
    void testGetInformationTables(){
        try(
                Connection connection = HikariCPConnection.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ) {
            String sql = "SELECT * FROM profil";
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData getInfoTables = resultSet.getMetaData();
            for (int x = 1; x<= getInfoTables.getColumnCount(); x++){
                System.out.println(getInfoTables.getTableName(x));
                System.out.println("table: " + getInfoTables.getColumnName(x));
                System.out.println("tipe: " + getInfoTables.getColumnType(x));
                System.out.println("tipe data: " + getInfoTables.getColumnTypeName(x));
            }
        }catch (SQLException e){
            Assertions.fail(e);
        }
    }


}
