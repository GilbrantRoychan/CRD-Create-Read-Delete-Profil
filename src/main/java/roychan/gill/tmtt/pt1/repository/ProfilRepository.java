package roychan.gill.tmtt.pt1.repository;

import roychan.gill.tmtt.pt1.entity.ProfilEntity;

import java.sql.SQLException;
import java.util.List;

public interface ProfilRepository {

    void insert(ProfilEntity profilEntity);
    ProfilEntity findById(Integer id);
    List<ProfilEntity> findAll();

    Boolean deleteById(Integer id);

}
