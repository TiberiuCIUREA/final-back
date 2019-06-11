package com.tiberiu.mentool.infra.persistence.mentor;

import com.tiberiu.mentool.domain.UniqueId;
import com.tiberiu.mentool.domain.mentor.Mentor;
import com.tiberiu.mentool.domain.user.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface MentorsSdj extends JpaRepository<Mentor, EmailAddress> {
    @Query("select m from Mentor m  left join fetch m.trainings as t where t.skillId in :skillIds")
    Set<Mentor> findByTrainingsSkillId(@Param("skillIds") Set<UniqueId> skillIds);
}
