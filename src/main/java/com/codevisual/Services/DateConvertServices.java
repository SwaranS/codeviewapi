package com.codevisual.Services;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Home on 27/07/2014.
 */
@Service
public class DateConvertServices {

    public String longToDate(Long dateLong) {
        return new Date(dateLong).toString();
    }

    public String intToDate(int dateInt) {
        return new Date(dateInt * 1000L).toString();
    }
}
