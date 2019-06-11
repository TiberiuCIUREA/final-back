package com.tiberiu.mentool.infra.persistence.user;

import com.tiberiu.mentool.domain.user.EmailAddress;
import com.tiberiu.mentool.domain.user.PhoneNumber;
import com.tiberiu.mentool.domain.user.User;

public class ValidUserGenerator {
    public static User gigiUser() {
        return new User(
                new EmailAddress("tiberiu.gigi@test.com"), "Tiberiu", "Gigi",
                new PhoneNumber("0742979020")
        );
    }
}