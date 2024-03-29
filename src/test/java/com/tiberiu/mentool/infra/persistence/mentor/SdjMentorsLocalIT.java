package com.tiberiu.mentool.infra.persistence.mentor;

import com.tiberiu.mentool.domain.UniqueId;
import com.tiberiu.mentool.domain.mentor.Mentor;
import com.tiberiu.mentool.domain.skill.Skill;
import com.tiberiu.mentool.infra.dataset.MentorDataSet;
import com.tiberiu.mentool.infra.dataset.SkillsDataset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

import static java.util.Collections.singleton;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SdjMentorsLocalIT {
    @Autowired
    private MentorsSdj sdj;

    @Autowired
    private SdjMentors sut;


    @Test
    public void should_save_correctly_a_mentor() {
        Mentor aMentor = MentorDataSet.THOR;
        sut.add(aMentor);
        Mentor savedMentor = sdj.getOne(aMentor.getId());
        assertThat(savedMentor).isEqualToComparingFieldByFieldRecursively(aMentor);
    }

    @Test
    public void should_get_correctly_a_mentor() {
        Mentor aMentor = MentorDataSet.THOR;
        sdj.saveAndFlush(aMentor);
        Mentor dbMentor = sut.getOrThrow(aMentor.getId());
        assertThat(dbMentor).isEqualToComparingFieldByFieldRecursively(aMentor);
    }

    @Test
    public void should_get_all_mentors_matching_skills_ids() {
        Set<UniqueId> allSkillIds = SkillsDataset.getAllSkills().stream().map(Skill::getId).collect(toSet());
        List<Mentor> mentorsWithSkills = sut.findAllMentorsTeachingTheSkills(allSkillIds);
        assertThat(mentorsWithSkills).hasSize(MentorDataSet.getAllMentors().size());
    }

    @Test
    public void should_get_only_mentor_matching_php_skill_when_only_php_selected() {
        List<Mentor> mentorsWithSkills = sut.findAllMentorsTeachingTheSkills(singleton(SkillsDataset.PHP.getId()));
        assertThat(mentorsWithSkills).hasSize(1);
    }


}
