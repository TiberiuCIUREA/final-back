package com.tiberiu.mentool.exposition.mentor.calendar;

import com.tiberiu.mentool.domain.mentor.calendar.BookTraining;
import com.tiberiu.mentool.domain.mentor.calendar.BookingCommand;
import com.tiberiu.mentool.domain.mentor.calendar.MentorTrainingDetails;
import com.tiberiu.mentool.domain.mentor.calendar.ViewTrainingsBookedByUser;
import com.tiberiu.mentool.domain.user.EmailAddress;
import com.tiberiu.mentool.exposition.MentoolRequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@MentoolRequestMapping
public class CalendarResource {
    private final BookTraining bookTraining;
    private final ViewTrainingsBookedByUser viewTrainingsBookedByUser;

    public CalendarResource(BookTraining bookTraining, ViewTrainingsBookedByUser viewTrainingsBookedByUser) {
        this.bookTraining = bookTraining;
        this.viewTrainingsBookedByUser = viewTrainingsBookedByUser;
    }

    @PutMapping("/calendar/book")
    public ResponseEntity<Boolean> bookTraining(@Valid @RequestBody BookingCommand bookingCommand) {
        return ResponseEntity.ok(bookTraining.bookTrainingForTrainee(bookingCommand));
    }

    @PutMapping("/calendar/cancel-booking")
    public ResponseEntity<Boolean> cancelBookingForTraining(@Valid @RequestBody BookingCommand bookingCommand) {
        return ResponseEntity.ok(bookTraining.cancelBookingTrainingForTrainee(bookingCommand));
    }

    @GetMapping("/calendar/{traineeAddress}/bookings")
    public Set<MentorTrainingDetails> viewBookedTrainingsByUser(@PathVariable EmailAddress traineeAddress) {
        return viewTrainingsBookedByUser.viewTrainingsBookedByUser(traineeAddress);
    }

}
