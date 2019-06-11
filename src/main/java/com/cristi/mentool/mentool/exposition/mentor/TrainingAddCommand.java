package com.cristi.mentool.mentool.exposition.mentor;

import com.cristi.mentool.mentool.domain.UniqueId;
import com.cristi.mentool.mentool.domain.mentor.MentorTraining;
import com.cristi.mentool.mentool.domain.mentor.calendar.MentorCalendar;
import com.cristi.mentool.mentool.domain.user.EmailAddress;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingAddCommand {
    @JsonProperty
    private String facilitiesDesc;

    @JsonProperty
    private UniqueId skillId;

    @JsonProperty
    private String prerequisitesDesc;

    @JsonProperty
    private int noOfTrainingsDone;

    @JsonProperty
    private EmailAddress emailAddress;

    @JsonProperty
    private BigDecimal fee;

    @JsonProperty
    LocalDateTime startDate;

    @JsonProperty
    LocalDateTime endDate;

    public MentorTraining createMentorTraining() {
        return new MentorTraining(new UniqueId(), facilitiesDesc, skillId, prerequisitesDesc, noOfTrainingsDone, emailAddress, fee);
    }

    public MentorCalendar createTrainingCalendar(UniqueId trainingId) {
        return new MentorCalendar(new UniqueId(), trainingId, startDate, endDate, 20, new HashSet<>());
    }
}
