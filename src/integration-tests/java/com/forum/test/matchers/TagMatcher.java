package com.forum.test.matchers;

import com.forum.domain.Tag;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class TagMatcher extends BaseMatcher<Tag> {
    private final String value;
    private Tag tag;

    private TagMatcher(String value) {
        this.value = value;
    }

    @Override
    public boolean matches(Object obj) {
        tag = (Tag) obj;
        return tag.getValue().equals(value);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(String.format("Expected tag[value: %s]. Got tag[value: %s]", value, tag.getValue()));

    }

    public static TagMatcher aTagWithValue(String value) {
        return new TagMatcher(value);
    }
}
