package com.michael.calendar;

import java.time.ZoneId;

public class User {
    private ZoneId zone = ZoneId.systemDefault();

    public ZoneId getZone() {
        return zone;
    }

    public void setZone(ZoneId zone) {
        this.zone = zone;
    }
}
