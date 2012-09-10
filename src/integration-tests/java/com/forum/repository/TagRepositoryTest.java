package com.forum.repository;

import com.forum.domain.Tag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static com.forum.test.matchers.TagMatcher.aTagWithValue;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TagRepositoryTest extends IntegrationTestBase {
    private static Logger logger = Logger.getLogger(TagRepository.class.getName());
    private TagRepository tagRepository;
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate template;

    @Before
    public void setup() {
        tagRepository = new TagRepository(dataSource);
        template = new JdbcTemplate(dataSource);
    }

    @Test
    public void shouldCreateTag() {
        tagRepository.createTag(new Tag(1, "bangalore", 1));
        verifyTagExists("bangalore");
    }

    @Test
    public void shouldGetTagsByTerm() {
        insertTags(Arrays.asList(
                new Tag(1, "bangalore", 1),
                new Tag(1, "setsdf", 1),
                new Tag(1, "bangle", 2)));

        List<Tag> tags = tagRepository.getTagsByTerm("bang");

        assertThat(tags.size(), is(2));
        assertThat(tags, hasItem(aTagWithValue("bangalore")));
        assertThat(tags, hasItem(aTagWithValue("bangle")));
        //asserting count is another test as counting tag usage is another functionality!!
    }

    @Test
    public void shouldReturnAllTheTags() {
        insertTags(Arrays.asList(
                new Tag(1, "test.tag1", 123),
                new Tag(2, "test.tag2", 456),
                new Tag(3, "test.tag3", 789)
        ));

        List<Tag> tags = tagRepository.allTags();

        /*
         * The tag table contains 10 tags as test data, hence expecting 13.
         */
        assertThat(tags.size(), is(13));
        assertThat(tags, hasItem(aTagWithValue("test.tag1")));
        assertThat(tags, hasItem(aTagWithValue("test.tag2")));
        assertThat(tags, hasItem(aTagWithValue("test.tag3")));
    }

    private void verifyTagExists(String value) {
        int numberOfTags = template.queryForInt("SELECT count(*) FROM TAG WHERE NAME = ?", value);
        assertThat(numberOfTags, is(1));
    }

    private void insertTags(List<Tag> tags) {
        for (Tag tag : tags) {
            template.update("INSERT INTO TAG (NAME) VALUES('" + tag.getValue() + "')");
        }
    }

    @Test
    public void  shouldGetTagByQuestionID() {

        List<Tag> expectedTags = tagRepository.getTagByQuestionId(2);
        assertTrue(expectedTags.contains(new Tag(2,"food",1)  ));

    }


}
