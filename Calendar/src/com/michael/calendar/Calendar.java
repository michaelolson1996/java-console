package com.michael.calendar;

import java.time.*;
import java.util.ArrayList;

public class Calendar {
    private YearMonth[] months = new YearMonth[3];
    private ArrayList<Event> events;
    private ZoneId zone;
    private int currentDay;

    public Calendar() {}

    public Calendar(ZoneId zone) {
        this.zone = zone;
    }

    public Calendar(ZoneId zone, ArrayList<Event> events) {
        this(zone);
        this.events = events;
    }

    public void generateCalendarMonths() {
        int count = -1;
        if (this.zone.getId().equals(ZoneId.systemDefault())) {
            for (int i = 0; i < this.months.length; i++)
                this.months[i] = YearMonth.now().plusMonths(count++);
        } else {
            for (int i = 0; i < this.months.length; i++)
                this.months[i] = YearMonth.now(this.zone.normalized()).plusMonths(count++);
        }
    }

    public int getDaysInCurrentMonth(int monthIndex) {
        this.verifyInt(0, this.months.length, monthIndex);
        System.out.println(this.months[monthIndex].atDay(1).getDayOfWeek().getValue());
        return this.months[monthIndex].lengthOfMonth();
    }

    public int getCurrentDay() {
        return this.currentDay;
    }

    public void generateCurrentDay() {
        this.currentDay = LocalDate.now(this.zone.normalized()).getDayOfMonth();
    }

    public DayOfWeek getWeekDayOfDay1(YearMonth month) {
        return month.atDay(1).getDayOfWeek();
    }

    private void verifyInt(int min, int max, int val) {
        if (val < min || val > max)
            throw new IllegalStateException("Class : Calendar, Method : VerifyInt : 40");
    }
}
