package com.forum.web.controller;

import com.forum.service.TagService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

        List<String> listOfTags = new ArrayList<String>();
        listOfTags.add("Bangalore");
        listOfTags.add("galore");

        Gson json = new Gson();
        return json.toJson(listOfTags);
    }
}
