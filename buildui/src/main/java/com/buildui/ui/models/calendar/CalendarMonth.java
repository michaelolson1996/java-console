package com.buildui.ui.models.calendar;

import java.time.ZoneId;

public class CalendarMonth {
    private CalendarDay[] days = new CalendarDay[35];
    private int firstDay;
    private int totalDays;

    public CalendarMonth() {}

    public CalendarMonth(int totalDays) {

    }

}
