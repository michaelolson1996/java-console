package com.buildui.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EnvironmentBuilderUtil {
    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");

    public String getFormatDate(Long milliseconds) {
        return DATE_TIME_FORMAT.format(new Date(milliseconds));
    }

    public void onApplicationExit() {

    }
}
