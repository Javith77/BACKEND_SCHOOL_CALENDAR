package com.pca.schoolcalendar.service.implementation;

import com.pca.schoolcalendar.entity.Schedule;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduleImplTest {

    @Autowired
    private ScheduleImpl scheduleImpl;

    @Test
    void propagateDates() {
//        Schedule schedule = new Schedule(1, getStartDate(), getEndDate(), null, null);
//        assertEquals(41, scheduleImpl.propagateDates(schedule).size());
    }

    private Date getStartDate(){
        Calendar calendar =  Calendar.getInstance();
        calendar.set(2022, Calendar.OCTOBER, 30, 8, 30);
        return calendar.getTime();
    }

    private Date getEndDate(){
        Calendar calendar =  Calendar.getInstance();
        calendar.set(2022, Calendar.OCTOBER, 30, 10, 30);
        return calendar.getTime();
    }
}