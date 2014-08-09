package com.codevisual.Services;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Home on 27/07/2014.
 */
@Service
public class DateConvertServices {

    public String longToDate(Long dateLong) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(dateLong));
    }

    public String intToDate(int dateInt) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date(dateInt * 1000L));

    }

    public Long intToLong(int dateInt){return dateInt * 1000L;}
}
