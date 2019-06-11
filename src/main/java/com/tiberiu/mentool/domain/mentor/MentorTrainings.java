package com.tiberiu.mentool.domain.mentor;

import com.tiberiu.mentool.domain.UniqueId;

import java.util.Set;

public interface MentorTrainings {
    Set<MentorTraining> findByTrainingIds(Set<UniqueId> trainingIds);
    MentorTraining getOrThrow(UniqueId trainingId);
}
