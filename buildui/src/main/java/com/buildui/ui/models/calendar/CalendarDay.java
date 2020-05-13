package com.buildui.ui.models.calendar;

import java.util.ArrayList;

public class CalendarDay {
    private int weekday;
    private ArrayList<Event> events;

    public CalendarDay() {}

    public CalendarDay(int weekday, ArrayList<Event> events) {
        this.weekday = weekday;
        this.events = events;
    }

    public int getWeekday() {
        return this.weekday;
    }

    public ArrayList<Event> getEvents() {
        return this.events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }
}