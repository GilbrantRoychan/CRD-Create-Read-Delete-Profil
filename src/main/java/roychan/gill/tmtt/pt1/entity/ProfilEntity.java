package roychan.gill.tmtt.pt1.entity;

import javax.print.attribute.IntegerSyntax;
import java.util.Date;

public class ProfilEntity {

    private  Integer id;
    private  String nama;
    private Long  tanggal_lahir;
    private  String nomor_telepon;

    public ProfilEntity() {
    }

    public ProfilEntity(String nama, Long tanggal_lahir, String nomor_telepon) {
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.nomor_telepon = nomor_telepon;
    }

    public ProfilEntity(Integer id, String nama, Long tanggal_lahir, String nomor_telepon) {
        this.id = id;
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.nomor_telepon = nomor_telepon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Long getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Long tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }
}
