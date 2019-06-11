package com.tiberiu.mentool.infra.persistence.mentor;

import com.tiberiu.mentool.domain.UniqueId;
import com.tiberiu.mentool.domain.mentor.Mentor;
import com.tiberiu.mentool.domain.mentor.Mentors;
import com.tiberiu.mentool.domain.user.EmailAddress;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Primary
public class SdjMentors implements Mentors {

    private final MentorsSdj sdj;

    public SdjMentors(MentorsSdj sdj) {
        this.sdj = sdj;
    }

    @Override
    public Mentor add(Mentor mentor) {
        return sdj.saveAndFlush(mentor);
    }

    @Override
    public Mentor getOrThrow(EmailAddress username) {
        return sdj.findById(username).orElseThrow(() -> new NoSuchElementException(username.toString()));
    }

    @Override
    public Set<Mentor> findAll() {
        return new HashSet<>(sdj.findAll());
    }

    @Override
    public List<Mentor> findAllMentorsTeachingTheSkills(Set<UniqueId> skillIds) {
        return new ArrayList<>(sdj.findByTrainingsSkillId(skillIds));
    }

    @Override
    public List<Mentor> findAll(List<EmailAddress> matchingMentorIds) {
        return sdj.findAllById(matchingMentorIds);
    }

    @Override
    public boolean exists(EmailAddress address) {
        return sdj.existsById(address);
    }
}
