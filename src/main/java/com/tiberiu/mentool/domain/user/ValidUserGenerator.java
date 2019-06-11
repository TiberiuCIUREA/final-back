package com.tiberiu.mentool.domain.user;

public class ValidUserGenerator {

    public static final User TIBERIU = new User(
            new EmailAddress("tiberiu@tiberiu.com"), "Tiberiu", "Cucumber warchief",
            new PhoneNumber("1234567890")
    );
}
