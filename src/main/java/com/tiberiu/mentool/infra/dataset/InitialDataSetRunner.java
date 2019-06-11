package com.tiberiu.mentool.infra.dataset;

import com.tiberiu.mentool.domain.mentor.Mentor;
import com.tiberiu.mentool.domain.mentor.Mentors;
import com.tiberiu.mentool.domain.mentor.calendar.MentorCalendar;
import com.tiberiu.mentool.domain.mentor.calendar.MentorCalendars;
import com.tiberiu.mentool.domain.skill.Skills;
import com.tiberiu.mentool.domain.user.Users;
import com.tiberiu.mentool.domain.user.ValidUserGenerator;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Component
@Transactional
@Profile("!NO_DATA_SET")
public class InitialDataSetRunner implements ApplicationRunner {
    private final Mentors mentors;
    private final MentorCalendars mentorCalendars;
    private final Users users;
    private final Skills skills;

    public InitialDataSetRunner(Mentors mentors, MentorCalendars mentorCalendars, Users users, Skills skills) {
        this.mentors = mentors;
        this.mentorCalendars = mentorCalendars;
        this.users = users;
        this.skills = skills;
    }

    @Override
    public void run(ApplicationArguments args) {
        dataSetFromDedicatedDatasets();
    }

    private void dataSetFromDedicatedDatasets() {
        SkillsDataset.getAllSkills().forEach(skills::add);
        MentorDataSet.getAllMentors().forEach(mentors::add);
        MentorDataSet.getAllMentors().stream().flatMap(this::mentorTrainingsProgram).
                forEach(mentorCalendars::add);
        users.add(ValidUserGenerator.TIBERIU);
    }

    private Stream<MentorCalendar> mentorTrainingsProgram(Mentor mentor) {
        return CalendarDataSet.generateMentorCalendarForTrainings(mentor.getTrainings()).stream();
    }
}
