package io.github.matheuscarv69.Util;

import ch.qos.logback.core.util.CachingDateFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public final static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static final  Date formataStringData(String data){
        if(data == null || data.equals("")) {
            return null;
        }

        Date date = null;

        DateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

        try {
            date = sdf1.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static final int calculaIdade(Date dataNascimento){
        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(dataNascimento);

        Calendar today = Calendar.getInstance();

        int idade = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

        dateOfBirth.add(Calendar.YEAR, idade);
        if (today.before(dateOfBirth)){
            idade--;
        }

        return idade;
    }

}
