package com.tiberiu.mentool.infra.configurations;

import org.springframework.context.annotation.Profile;

@Profile("ENABLE-H2")
public @interface H2Profile {
}
