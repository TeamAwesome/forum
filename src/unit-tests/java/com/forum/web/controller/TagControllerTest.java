package com.forum.web.controller;

import com.forum.domain.TagLabel;
import com.forum.service.TagService;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TagControllerTest {
    private TagController tagController;

    @Test
    public void shouldGetTagsForGivenTerm() {
        TagService tagService = mock(TagService.class);

        List<TagLabel> listOfTags = new ArrayList<TagLabel>();
        String term = "ore";
        when(tagService.getTagsByTerm(term)).thenReturn(listOfTags);
        this.tagController = new TagController(tagService);

        String tagJSON = tagController.getTagsByTerm("ore");

        Gson json = new Gson();

        assertThat(tagJSON, is(json.toJson(listOfTags)));
    }


}
