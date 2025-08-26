package roychan.gill.tmtt.pt1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import roychan.gill.tmtt.pt1.utill.DateTOLong;
import roychan.gill.tmtt.pt1.entity.ProfilEntity;
import roychan.gill.tmtt.pt1.repository.ProfilRepository;
import roychan.gill.tmtt.pt1.repository.impl.ProfilRepositoryImpl;

import java.sql.SQLException;
import java.util.List;


public class TestRepository {

    @Mock
    private   ProfilRepository profilRepository;

    @BeforeEach()
    void setup(){
        profilRepository = new ProfilRepositoryImpl();
    }

    @Test
    void testInsertData(){

        ProfilEntity test1 = new ProfilEntity("GibrantTest3", DateTOLong.convertDateToLong(19, 7,2002),"1209865");
        profilRepository.insert(test1);


    }

    @Test
    void testMethod(){

        Long datas = DateTOLong.convertDateToLong(19,7,2002);
        System.out.println(datas);
    }

    @Test

    void testFindAll(){

        List<ProfilEntity> datas= profilRepository.findAll();
        System.out.println(datas.size());
    }

    @Test
    void findById(){
        ProfilEntity cel = profilRepository.findById(1);
        Assertions.assertNotNull(cel.getId());
    }

    @Test
    void testDelete(){
        Assertions.assertFalse(profilRepository.deleteById(1));
    }


}
