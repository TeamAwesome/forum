package com.forum.web.controller;

import com.forum.service.TagService;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: twu
 * Date: 4/9/12
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class TagControllerTest {
    private TagController tagController;

    @Test
    public void shouldGetTagsForGivenTerm() {
        TagService tagService = mock(TagService.class);

        List<String> listOfTags = new ArrayList<String>();
        listOfTags.add("Bangalore");
        listOfTags.add("galore");

        String term = "ore";
        when(tagService.getTagsByTerm(term)).thenReturn(listOfTags);
        this.tagController = new TagController(tagService);

        String tagJSON = tagController.getTagsByTerm("ore");

        Gson json = new Gson();

        assertThat(tagJSON, is(json.toJson(listOfTags)));
    }


}
