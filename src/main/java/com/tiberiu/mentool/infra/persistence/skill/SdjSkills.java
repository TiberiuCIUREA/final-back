package com.tiberiu.mentool.infra.persistence.skill;

import com.tiberiu.mentool.domain.UniqueId;
import com.tiberiu.mentool.domain.skill.Skill;
import com.tiberiu.mentool.domain.skill.Skills;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class SdjSkills implements Skills {
    private final SkillsSdj sdj;

    public SdjSkills(SkillsSdj sdj) {
        this.sdj = sdj;
    }

    @Override
    public List<Skill> findAllWithPattern(String skillNamePattern) {
        if (skillNamePattern == null) {
            return  new ArrayList<>(sdj.findAll());
        }
        return new ArrayList<>(sdj.findSkillBySkillNameContainsIgnoreCase(skillNamePattern));
    }

    @Override
    public Skill getOrThrow(UniqueId skillId) {
        return sdj.findById(skillId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Skill add(Skill skill) {
        return sdj.saveAndFlush(skill);
    }

    @Override
    public boolean exists(String skillName) {
        return sdj.existsBySkillNameEqualsIgnoreCase(skillName);
    }
}
