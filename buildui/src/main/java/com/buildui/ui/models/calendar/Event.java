package com.buildui.ui.models.calendar;

public class Event {
    private String color;
    private String title;
    private String description;
    private String time;
    private String date;

    public Event() {}

    public Event(String color, String title, String description, String time, String date) {
        this.color = color;
        this.title = title;
        this.description = description;
        this.time = time;
        this.date = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
