package com.tiberiu.mentool.exposition.skill;

import com.tiberiu.mentool.domain.skill.Skill;
import com.tiberiu.mentool.exposition.BaseExpoTest;
import com.tiberiu.mentool.infra.persistence.skill.SkillsSdj;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("NO_DATA_SET")
public class SkillResourceLocalIT extends BaseExpoTest {
    @Autowired
    private SkillsSdj skillsSdj;

    @Test
    public void addSkill_should_add_skill() {
        assertThat(skillsSdj.findAll()).isEmpty();
        String url = format("http://localhost:%d/persons/skills", port);
        SkillCreateCommand command = new SkillCreateCommand("java");
        this.restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(command), Skill.class);
        assertThat(skillsSdj.findAll()).hasSize(1);
        assertThat(skillsSdj.findAll().get(0)).isEqualToIgnoringGivenFields(new Skill("java"), "id");
    }
}