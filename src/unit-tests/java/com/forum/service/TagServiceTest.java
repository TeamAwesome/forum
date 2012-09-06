package com.forum.service;

import com.forum.domain.Tag;
import com.forum.repository.TagRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TagServiceTest {
    TagRepository tagRepositoryMock;
    TagService tagService;

    @Before
    public void setUp() throws Exception {
        tagRepositoryMock = mock(TagRepository.class);
        tagService=new TagService(tagRepositoryMock);
    }

    @Test
    public void shouldGetTags() throws Exception {
        List<Tag> tagList = new ArrayList<Tag>();
        tagList.add(new Tag(1,"contour",2));
        tagList.add(new Tag(1,"touring",2));


        when(tagRepositoryMock.getTagsByTerm("tour")).thenReturn(tagList);
        List<Tag> expectedListOfTags = tagService.getTagsByTerm("tour");
        assertThat(expectedListOfTags,is(tagList));


    }

    @Test
    public  void  shouldCreateTagIfTagDoesNotExist(){
        Tag tagLabel1 =new Tag(1,"ice cream",2);
        Tag tagLabel2 =new Tag(2,"creamy cake",2);
        when(tagRepositoryMock.createTag(tagLabel1)).thenReturn(1);
        when(tagRepositoryMock.createTag(tagLabel2)).thenReturn(0);
        assertThat(tagService.createTag(tagLabel1), is(1));
        assertThat(tagService.createTag(tagLabel2),is(0));
    }

    @Test
    public void shouldCheckIfATagExists() {
        Tag tag1 = new Tag(1,"corner house",2);
        Tag tag2 = new Tag(2,"house",2);
        when(tagRepositoryMock.getTagByName(tag1.getValue())).thenReturn(tag1);
        when(tagRepositoryMock.getTagByName(tag2.getValue())).thenReturn(null);
        Boolean expectedResultOfIsPresent = tagService.isPresent(tag1);
        assertThat(expectedResultOfIsPresent,is(true));
        assertThat(tagService.isPresent(tag2),is(false));
    }
}
