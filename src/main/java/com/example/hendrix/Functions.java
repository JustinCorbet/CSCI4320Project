package com.example.hendrix;

import java.util.Calendar;

public class Functions {
    static String wishMe() {
        String s = "";
        Calendar c = Calendar.getInstance();
        int time = c.get(Calendar.HOUR_OF_DAY);
        if (time >= 6 && time < 12) {
            s = "Good morning!";
        } else if (time >= 12 && time < 16) {
            s = "Good afternoon!";
        } else if (time >= 16 && time < 22) {
            s = "Good evening!";
        } else if (time >= 22 && time < 6) {
            s = "Good night!";
        }
        return s;
    }
}
