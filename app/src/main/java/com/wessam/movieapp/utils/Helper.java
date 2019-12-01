package com.wessam.movieapp.utils;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class Helper {

    private Helper() {
    }

    public static String formatNumber(Integer number) {
        if (number != null && number != 0) {
            List<String> myNumbers = Arrays.asList(NumberFormat.getNumberInstance(Locale.US).format(number).split(","));
            return myNumbers.toString().replace("]", "").replace("[", "");
        } else return "";
    }

    public static String formatTime(Integer time){
        if (time != null && time != 0) {
            int hours = time / 60;
            int minutes = time % 60;
            return hours + "h" + " " + minutes + "min";
        }else return "";
    }

    public static String returnStringFromBoolean(Boolean b){
        if (b != null && !b.toString().isEmpty()){
            if (b) return "YES";
            else return "NO";
        }
        return "";
    }

}
