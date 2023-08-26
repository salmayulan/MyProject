import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Scanner;


public class TestDate {

public static void main(String[] args) throws ParseException {
//Scanner sc = new Scanner(System.in);
//String tanggal;
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
 //Date date1 = sdf.parse("12-12-18");
 //Date date2 = sdf.parse("13-12-18");

//System.out.println("date1 : " + sdf.format(date1));
 //System.out.println("date2 : " + sdf.format(date2));
//if(tanggal.after(date1))
    //System.out.println("ANDA TERKENA DENDA");
//else
    //System.out.println("ANDA TIDAK TERKENA DENDA");

    System.out.println(sdf.format(date));


}

}
