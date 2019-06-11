package com.tiberiu.mentool.infra.dataset;

import com.tiberiu.mentool.domain.UniqueId;
import com.tiberiu.mentool.domain.mentor.MentorTraining;
import com.tiberiu.mentool.domain.mentor.calendar.MentorCalendar;
import com.tiberiu.mentool.domain.user.EmailAddress;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.tiberiu.mentool.domain.user.ValidUserGenerator.TIBERIU;

public class CalendarDataSet {
    private final static LocalDateTime START_TIME = LocalDateTime.now();
    private final static LocalDateTime END_TIME = LocalDateTime.now().plusMonths(1L);
    private final static long LOWER_BOUND = 1L;
    private final static long UPPER_BOUND = 20L;
    public static List<MentorCalendar> generateMentorCalendarForTrainings(Set<MentorTraining> trainings) {
        List<MentorCalendar> program = new ArrayList<>();
        for (MentorTraining training : trainings) {
            LocalDateTime startTime = START_TIME.minusDays(generateRandomLong());
            LocalDateTime endTime = END_TIME.plusDays(generateRandomLong());
            Set<EmailAddress> traineesThatBooked = new HashSet<>();
            makeSomeMentorTrainingHaveBookings(training, traineesThatBooked);
            MentorCalendar trainingProgram = new MentorCalendar(
                    new UniqueId(), training.getId(), startTime, endTime,
                    20, traineesThatBooked
            );
            program.add(trainingProgram);
        }
        return program;
    }

    private static void makeSomeMentorTrainingHaveBookings(MentorTraining training, Set<EmailAddress> traineesThatBooked) {
        if (training.getMentorId().equals(MentorDataSet.HERCULES.getId())) {
            traineesThatBooked.add(TIBERIU.getId());
        }
    }

    private static long generateRandomLong() {
        return LOWER_BOUND + (long) (Math.random() * (UPPER_BOUND - LOWER_BOUND));
    }
}
