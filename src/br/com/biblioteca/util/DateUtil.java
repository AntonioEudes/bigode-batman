package br.com.biblioteca.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    //private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public static String dateToString(Date data) {
        return formatter.format(data);
    }

    public static Date stringToDate(String data) {
        try {
            return formatter.parse(data);
        } catch (ParseException ex) {
            return null;
        }
    }
}
