package com.forum.service;

import com.forum.domain.Tag;
import com.forum.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTagsByTerm(String term) {
        return tagRepository.getTagsByTerm(term);
    }

    public void createTag(Tag tag) {
        if (tagRepository.getTagByName(tag.getValue()) == null) {
            tagRepository.createTag(tag);
        }
    }

    public List<Tag> getAllTags() {
        return tagRepository.allTags();
    }
}
