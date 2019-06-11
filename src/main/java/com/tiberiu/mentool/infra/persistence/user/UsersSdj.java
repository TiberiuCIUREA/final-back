package com.tiberiu.mentool.infra.persistence.user;

import com.tiberiu.mentool.domain.user.EmailAddress;
import com.tiberiu.mentool.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersSdj extends JpaRepository<User, EmailAddress> {
}
