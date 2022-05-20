package com.demoqa.ui.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class Dates {

    public Date getDate(Date testDate,String format)  {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date resDate = new Date();

        try {
            resDate = dateFormat.parse(dateFormat.format(testDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return resDate;
    }

    public int getMonthDate(Date d) {

     //   Date date = new Date();
        LocalDate localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //int year  = localDate.getYear();
        //int month = localDate.getMonthValue();
        return localDate.getDayOfMonth();

    }

    public String getMonth(Date d) {

        LocalDate localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //int year  = localDate.getYear();
        return localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);


    }

    public int getYear(Date d) {

        LocalDate localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return  localDate.getYear();



    }

}
