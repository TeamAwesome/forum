package com.forum.web.controller;

import com.forum.domain.Tag;
import com.forum.service.TagService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TagControllerTest {
    private TagController tagController;
    private TagService tagService;

    @Before
    public void setUp(){
        tagService = mock(TagService.class);
        tagController = new TagController(tagService);
    }

    @Test
    public void shouldGetTagsForGivenTerm() {
        List<Tag> listOfTags = new ArrayList<Tag>();
        String term = "ore";
        when(tagService.getTagsByTerm(term)).thenReturn(listOfTags);

        String tagJSON = tagController.getTagsByTerm("ore");

        Gson json = new Gson();

        assertThat(tagJSON, is(json.toJson(listOfTags)));
    }

    @Test
    public void shouldReturnListOfTagsAsJSON() {
        List<Tag> tags = Arrays.asList(
                new Tag(1,"Lorem",11),
                new Tag(2,"Home",15),
                new Tag(3,"food",20),
                new Tag(4,"java",2));
        when(tagService.getAllTags()).thenReturn(tags);

        String tagsAsJSON = tagController.getAllTags();

        String testResult = "[" +
                "{\"id\":1,\"value\":\"lorem\",\"count\":11}," +
                "{\"id\":2,\"value\":\"home\",\"count\":15}," +
                "{\"id\":3,\"value\":\"food\",\"count\":20}," +
                "{\"id\":4,\"value\":\"java\",\"count\":2}" +
                "]";
        assertThat(tagsAsJSON, is(testResult));
    }
}
