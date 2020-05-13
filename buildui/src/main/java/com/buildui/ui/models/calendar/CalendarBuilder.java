package com.buildui.ui.models.calendar;

import java.time.DateTimeException;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.zone.ZoneRulesException;

public class CalendarBuilder {
    private ZoneId timezone;
    private CalendarMonth[] months = new CalendarMonth[3];

    public CalendarBuilder() {
        this.setTimezone(ZoneId.systemDefault().toString());
    }

    public CalendarBuilder(String timezone, Event[] events) {
        this.setTimezone(timezone);
    }

    private void generateCalendar() {
        for (int i = 0; i < months.length; i++) {
            int totalDays = YearMonth.now(this.timezone.normalized()).plusMonths(i).lengthOfMonth();
            this.months[i] = new CalendarMonth();
        }
    }

    private int getDaysInMonth() {
        return 0;
    }

    public void setTimezone(String timezone) {
        try {
            this.timezone = ZoneId.of(timezone);
        } catch (ZoneRulesException e) {
            // inform user we will use default time zone
            e.printStackTrace();
        } catch (DateTimeException e) {
            // inform user we will use default time zone
            e.printStackTrace();
        } finally {
            // if method succeeds or fails
        }
    }
}
