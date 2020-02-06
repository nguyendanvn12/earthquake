package com.nguyendan.earthquake.data.model;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Convert {
    public static String getLocationOffset(String s){
        int i = s.lastIndexOf("of");
        if(i!=-1){
            return s.substring(0,i-1);
        }
        return s;
    }

    public static String getLocation(String s){
        int i = s.lastIndexOf("of");
        if(i!=-1){
            return s.substring(i+3);
        }
        return s;
    }

    public static String getDate(Long i){
        Date date = new Date(i);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        return dateFormatter.format(date);
    }

    public static String getTime(Long i){
        Date date = new Date(i);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("KK:mm aa");
        return dateFormatter.format(date);
    }

}
