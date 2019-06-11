package com.tiberiu.mentool.exposition.user;

import com.tiberiu.mentool.domain.user.EmailAddress;
import com.tiberiu.mentool.domain.user.PhoneNumber;
import com.tiberiu.mentool.domain.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class UserDto {
    @NotNull
    @JsonProperty
    public String username;
    @NotBlank
    @JsonProperty
    public String firstName;
    @NotBlank
    @JsonProperty
    public String lastName;
    @NotNull
    @JsonProperty
    public String phoneNumber;

    public User toUser() {
        return new User(new EmailAddress(username), firstName, lastName, new PhoneNumber(phoneNumber));
    }
}
