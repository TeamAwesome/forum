package com.forum.repository;

import com.forum.domain.TagLabel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TagRepositoryTest extends IntegrationTestBase {
    private TagRepository tagRepository;
    @Autowired
    private DataSource dataSource;

    @Before
    public void setup() {
        tagRepository = new TagRepository(dataSource);
    }

    @Test
    public void shouldCreateTag() {
        TagLabel tag = new TagLabel(1, "bangalore", 1);
        assertThat(tagRepository.createTag(tag), is(1));
    }

    @Test
    public void shouldGetTagsByTerm() {
        List<TagLabel> tags ;
        tagRepository.createTag(new TagLabel(1, "bangalore", 1));
        tagRepository.createTag(new TagLabel(1, "bangle", 2));
        tags = tagRepository.getTagsByTerm("bang");

        assertThat(tags.get(0).getValue(), is("bangalore"));
        assertThat(tags.get(1).getValue(), is("bangle"));
        //asserting count is another test as counting tag usage is another functionality!!
    }


}
