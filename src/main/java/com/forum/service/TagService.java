package com.forum.service;

import com.forum.domain.TagLabel;
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

    public List<TagLabel> getTagsByTerm(String term) {
        return tagRepository.getTagsByTerm(term);
    }

    public Integer createTag(TagLabel tag) {
        if(!isPresent(tag)){
        return tagRepository.createTag(tag);
        }
        return 0;
    }

    boolean isPresent(TagLabel tag) {
        tag = tagRepository.getTagByName(tag.getValue());
        if(tag==null){
            return false;
        }
        return true;
    }
}
