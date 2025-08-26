package roychan.gill.tmtt.pt1.utill;


import java.util.Calendar;
import java.util.Date;

public class DateTOLong {

    public  static  Long convertDateToLong(Integer tanggal, Integer bulan, Integer tahun){
        Calendar kalender = Calendar.getInstance();

        // merubah tanggal sesuai input user
        kalender.set(Calendar.DAY_OF_MONTH, tanggal);
        kalender.set(Calendar.MONTH, (bulan - 1));
        kalender.set(Calendar.YEAR, tahun);

        // konvert to Date first
        Date getDate = kalender.getTime();
        return getDate.getTime();
    }
}
