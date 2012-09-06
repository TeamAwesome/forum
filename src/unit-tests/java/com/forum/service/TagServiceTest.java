package com.forum.service;

import com.forum.domain.Tag;
import com.forum.repository.TagRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TagServiceTest {
    @Mock
    TagRepository tagRepositoryMock;
    TagService tagService;

    @Before
    public void setUp() throws Exception {
        tagService = new TagService(tagRepositoryMock);
    }

    @Test
    public void shouldGetTags() throws Exception {
        List<Tag> tagList = Arrays.asList(
                new Tag(1, "contour", 2),
                new Tag(1, "touring", 2)
        );
        when(tagRepositoryMock.getTagsByTerm("tour")).thenReturn(tagList);

        List<Tag> expectedListOfTags = tagService.getTagsByTerm("tour");

        assertThat(expectedListOfTags, sameInstance(tagList));
    }

    @Test
    public void shouldReturnAllTagsFromRepository() {
        List<Tag> allTagsFromRepository = Arrays.asList(new Tag(1,"food",10));
        when(tagRepositoryMock.allTags()).thenReturn(allTagsFromRepository);

        List<Tag> allTags = tagService.getAllTags();

        assertThat(allTags, sameInstance(allTagsFromRepository));
    }

    @Test
    public void shouldCreateTagIfTagDoesNotExist() {
        Tag tagLabel = new Tag(1, "ice cream", 2);
        when(tagRepositoryMock.getTagByName("ice cream")).thenReturn(null);

        tagService.createTag(tagLabel);

        verify(tagRepositoryMock).createTag(tagLabel);
    }

    @Test
    public void shouldNotCreateTagIfTagDoesExist() {
        Tag tagLabel = new Tag(1, "ice cream", 2);
        when(tagRepositoryMock.getTagByName("ice cream")).thenReturn(new Tag(1, "test.name", 4));

        tagService.createTag(tagLabel);

        verify(tagRepositoryMock, never()).createTag(any(Tag.class));
    }

}
