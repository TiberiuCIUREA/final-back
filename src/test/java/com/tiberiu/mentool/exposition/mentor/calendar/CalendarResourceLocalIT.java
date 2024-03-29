package com.tiberiu.mentool.exposition.mentor.calendar;

import com.tiberiu.mentool.domain.UniqueId;
import com.tiberiu.mentool.domain.mentor.calendar.BookingCommand;
import com.tiberiu.mentool.domain.mentor.calendar.MentorCalendar;
import com.tiberiu.mentool.domain.mentor.calendar.MentorCalendars;
import com.tiberiu.mentool.domain.user.EmailAddress;
import com.tiberiu.mentool.exposition.BaseExpoTest;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import java.util.NoSuchElementException;

import static com.tiberiu.mentool.domain.user.ValidUserGenerator.TIBERIU;

public class CalendarResourceLocalIT extends BaseExpoTest {

    @Autowired
    private MentorCalendars calendars;

    private UniqueId trainingId;

    @Test
    public void cancelBookingForTraining() {
        EmailAddress traineeEmail = TIBERIU.getId();
        MentorCalendar trainingCalendar = calendars.findByTraineeAddress(traineeEmail)
                .stream().findFirst().orElseThrow(NoSuchElementException::new);
        BookingCommand cancellationCommand = new BookingCommand(trainingCalendar.getTrainingId(), traineeEmail);
        trainingId = trainingCalendar.getTrainingId();
        restTemplate.exchange(
                "/persons/calendar/cancel-booking", HttpMethod.PUT, new HttpEntity<>(cancellationCommand), Boolean.class
        );
    }

    @After
    public void verifyThatTrainingBookingWasCanceledWithoutCallingRepoSave() {
        MentorCalendar trainingCalendar = calendars.findByTraining(trainingId);
        Assertions.assertThat(trainingCalendar.getTraineesBooked()).doesNotContain(TIBERIU.getId());
    }
}