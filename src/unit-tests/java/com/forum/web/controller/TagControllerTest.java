package com.forum.web.controller;

import com.forum.domain.Tag;
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

        List<Tag> listOfTags = new ArrayList<Tag>();
        String term = "ore";
        when(tagService.getTagsByTerm(term)).thenReturn(listOfTags);
        this.tagController = new TagController(tagService);

        String tagJSON = tagController.getTagsByTerm("ore");

        Gson json = new Gson();

        assertThat(tagJSON, is(json.toJson(listOfTags)));
    }

    @Test
    public void shouldReturnListOfTagsAsJSON(){
        tagController =  new TagController(null);
        String tags = tagController.getAllTags();

        String testResult = "[{\"text\": \"Lorem\", \"weight\": 11, \"link\":\"fjdkjkl\"}," +
                "{\"text\": \"Home\", \"weight\": 15, \"link\": \"http://localhost:8080/forum/\", \"title\": \"Tags\"}," +
                "{\"text\": \"food\", \"weight\": 200}," +
                "{\"text\": \"java\", \"weight\": 2}]";
        assertThat(tags, is(testResult));
    }

}
