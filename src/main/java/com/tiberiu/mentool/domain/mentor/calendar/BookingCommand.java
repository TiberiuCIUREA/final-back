package com.tiberiu.mentool.domain.mentor.calendar;

import com.tiberiu.mentool.domain.UniqueId;
import com.tiberiu.mentool.domain.user.EmailAddress;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingCommand {
    @JsonProperty
    @NotNull
    public UniqueId trainingId;
    @JsonProperty
    @NotNull
    public EmailAddress traineeEmail;
}
