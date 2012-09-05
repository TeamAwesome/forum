package com.forum.web.controller;

import com.forum.domain.Tag;
import com.forum.service.TagService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TagController {
    private TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }
    @RequestMapping(value="/postQuestion/getTagsByTerm/{term}", method = RequestMethod.GET)
    @ResponseBody
    public String getTagsByTerm(@PathVariable String term) {

        List<Tag> listOfTags = tagService.getTagsByTerm(term);

        Gson json = new Gson();
        return json.toJson(listOfTags);
    }

    @RequestMapping(value="/tags", method = RequestMethod.GET)
    @ResponseBody
    public String getAllTags() {
        return "[{\"text\": \"Lorem\", \"weight\": 11, \"link\":\"fjdkjkl\"}," +
                "{\"text\": \"Home\", \"weight\": 15, \"link\": \"http://localhost:8080/forum/\", \"title\": \"Tags\"}," +
                "{\"text\": \"food\", \"weight\": 200}," +
                "{\"text\": \"java\", \"weight\": 2}]";
    }
}
