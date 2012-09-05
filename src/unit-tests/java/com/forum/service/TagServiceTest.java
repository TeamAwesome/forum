package com.forum.service;

import com.forum.repository.QuestionRepository;
import com.forum.repository.TagRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TagServiceTest {
    @Test
    public void shouldGetTags() throws Exception {
        TagRepository tagRepository = mock(TagRepository.class);
        List<String> tagList = new ArrayList<String>();
        tagList.add("hai");
        tagList.add("hai there");
        tagList.add("hai seniora");

        when(tagRepository.getTagsByTerm("hai")).thenReturn(tagList);
        List<String> expectedListOfTags = tagRepository.getTagsByTerm("hai");
        assertThat(expectedListOfTags,is(tagList));


    }
}
