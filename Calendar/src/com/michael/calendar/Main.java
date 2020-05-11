package com.michael.calendar;



import javax.jws.soap.SOAPBinding;
import java.time.*;
import java.util.ArrayList;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

    LocalDate ld = null;
//        System.out.println(ld.now());



//        User user = new User();
//
//        ZoneId zone = user.getZone();
//        System.out.println(zone.toString());

//        YearMonth ym = YearMonth.of();

        Calendar cal = new Calendar(ZoneId.systemDefault());
        cal.generateCalendarMonths();
        cal.generateCurrentDay();
        int days = cal.getDaysInCurrentMonth(1);
        System.out.println(days);
        int currentDay = cal.getCurrentDay();
        System.out.println(currentDay);
//        System.out.println(cal.getWeekDayOfDay1());










//        Set<String> ids = ZoneId. getAvailableZoneIds();
//
//        for (String id : ids) {
//            System.out.println(id);
//        }

//        System.out.println("Current Date: "+java.time.LocalDate.now());
//        System.out.println("Current Time: "+java.time.LocalTime.now());
//        System.out.println("Current Date & Time: "+java.time.LocalDateTime.now());
//        System.out.println(ZoneId.systemDefault());
//        Clock testClock = Clock.fixed(Instant.EPOCH, ZoneOffset.UTC);
//        LocalDate testDate = LocalDate.now(testClock);
//
////        create a calendar
//        Calendar calendar = new Calendar();
//
////        add some tasks to the calendar
//        calendar.addTask(1,0, "AnswerUrgent");
//        calendar.addTask(4,0, "Write Deployment Report");
//        calendar.addTask(4,0, "Plan this stupid shit");
//
////        add some work days to the calendar
//        calendar.addWorkPeriods(Utils.generateWorkPeriods(testDate, 3));
//
////        add an event to the calendar, specifying its time zone
//        ZonedDateTime meetingTime = ZonedDateTime.of(testDate.atTime(8, 30),
//                ZoneId.of(("America/New_York")));
//
//        Schedule schedule = calendar.createSchedule(testClock);
    }
}
