package com.forum.service;

import com.forum.domain.TagLabel;
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
        List<TagLabel> tagList = new ArrayList<TagLabel>();
        tagList.add(new TagLabel(1,"contour",2));
        tagList.add(new TagLabel(1,"touring",2));


        when(tagRepositoryMock.getTagsByTerm("tour")).thenReturn(tagList);
        List<TagLabel> expectedListOfTags = tagService.getTagsByTerm("tour");
        assertThat(expectedListOfTags,is(tagList));


    }

    @Test
    public  void  shouldCreateTagIfTagDoesNotExist(){
        TagLabel tagLabel1 =new TagLabel(1,"ice cream",2);
        TagLabel tagLabel2 =new TagLabel(2,"creamy cake",2);
        when(tagRepositoryMock.createTag(tagLabel1)).thenReturn(1);
        when(tagRepositoryMock.createTag(tagLabel2)).thenReturn(0);
        assertThat(tagService.createTag(tagLabel1), is(1));
        assertThat(tagService.createTag(tagLabel2),is(0));
    }

    @Test
    public void shouldCheckIfATagExists() {
        TagLabel tag1 = new TagLabel(1,"corner house",2);
        TagLabel tag2 = new TagLabel(2,"house",2);
        when(tagRepositoryMock.getTagByName(tag1.getValue())).thenReturn(tag1);
        when(tagRepositoryMock.getTagByName(tag2.getValue())).thenReturn(null);
        Boolean expectedResultOfIsPresent = tagService.isPresent(tag1);
        assertThat(expectedResultOfIsPresent,is(true));
        assertThat(tagService.isPresent(tag2),is(false));
    }
}
