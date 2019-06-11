package com.tiberiu.mentool.infra.persistence.mentor;

import com.tiberiu.mentool.domain.UniqueId;
import com.tiberiu.mentool.domain.mentor.MentorTraining;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorTrainingsSdj extends JpaRepository<MentorTraining, UniqueId> {
}
