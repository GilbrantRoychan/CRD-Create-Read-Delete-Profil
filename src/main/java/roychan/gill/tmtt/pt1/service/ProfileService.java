package roychan.gill.tmtt.pt1.service;

import roychan.gill.tmtt.pt1.entity.ProfilEntity;
import roychan.gill.tmtt.pt1.repository.ProfilRepository;
import roychan.gill.tmtt.pt1.utill.DateTOLong;

import java.sql.Date;
import java.util.List;

public class ProfileService {

    private  final  ProfilRepository profilRepository;

    public ProfileService(ProfilRepository profilRepository) {
        this.profilRepository = profilRepository;
    }

    public   void showData(){
        List<ProfilEntity> entity = profilRepository.findAll();
        for (var data: entity){
            System.out.println("ID: " + data.getId());
            System.out.println("nama: " + data.getNama());
            System.out.println("tanggal lahir: " + new Date(data.getTanggal_lahir()));
            System.out.println("nomor telepon: " + data.getNomor_telepon());
            System.out.println();
        }
    };

    public  void insertData(String nama, Integer tanggal,Integer bulan, Integer tahun, String nomor){
        ProfilEntity profilEntity = new ProfilEntity(nama, DateTOLong.convertDateToLong(tanggal,bulan,tahun), nomor);
        profilRepository.insert(profilEntity);
    }

    public  void deleteData(Integer id){
            Boolean delete = profilRepository.deleteById(id);
            if (delete){
                System.out.println("Success delete ID: " + id);
            }else {
                throw  new RuntimeException("ID tidak di kenali");
            }
    }
}
