package com.tiberiu.mentool.exposition.mentor;

import com.tiberiu.mentool.domain.mentor.MentorSearchResult;
import com.tiberiu.mentool.domain.mentor.MentorTrainingSearch;
import com.tiberiu.mentool.exposition.MentoolRequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@MentoolRequestMapping
public class MentorSearchResource {
    private final MentorTrainingSearch trainingSearch;

    public MentorSearchResource(MentorTrainingSearch trainingSearch) {
        this.trainingSearch = trainingSearch;
    }

    @PostMapping(path = "/mentors/search", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public List<MentorSearchResult> findMentors(@Valid @RequestBody MentorSearchRequest request) {
        return trainingSearch.searchForMentors(
                request.getSkillNamePattern(), request.startTime(), request.endTime()
        );
    }
}
