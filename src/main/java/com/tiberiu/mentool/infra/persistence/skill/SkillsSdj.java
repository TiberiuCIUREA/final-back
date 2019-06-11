package com.tiberiu.mentool.infra.persistence.skill;

import com.tiberiu.mentool.domain.UniqueId;
import com.tiberiu.mentool.domain.skill.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SkillsSdj extends JpaRepository<Skill, UniqueId> {

    Set<Skill> findSkillBySkillNameContainsIgnoreCase(String pattern);

    boolean existsBySkillNameEqualsIgnoreCase(String skillName);
}
