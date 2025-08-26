package roychan.gill.tmtt.pt1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import roychan.gill.tmtt.pt1.repository.ProfilRepository;
import roychan.gill.tmtt.pt1.repository.impl.ProfilRepositoryImpl;
import roychan.gill.tmtt.pt1.service.ProfileService;


public class TestService {

    private  static ProfilRepository profilRepository;

    private  static ProfileService profileService;

    @BeforeEach
    void setup(){
        profilRepository = new ProfilRepositoryImpl();
        profileService = new ProfileService(profilRepository);
    }

    @Test
    @Disabled
    void testInserData(){
    String nama = "Boni Setiawan";
    Integer tangalLahir = 22;
    Integer bulanLahir = 5;
    Integer tahunLahir = 2019;
    String nomor = "12345678";

    profileService.insertData(nama,tangalLahir,bulanLahir,tahunLahir,nomor);
    profileService.showData();
    }

    @Test
    void  testDeleteData(){
        Integer target = 1;
        profileService.deleteData(2);



    }

}
