package com.springexample.common.controllers;

import com.springexample.common.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView testFormMethod() {
        ModelAndView model = new ModelAndView("index", "command", new User());

        //country map
        Map<String,String> country = new LinkedHashMap<String,String>();
        country.put("US", "United Stated");
        country.put("RU", "Russia");
        country.put("UK", "United Kingdom");
        country.put("UA", "Ukraine");

        //programming languages list
        List<String> programmingLanguagesList = new ArrayList<String>();
        programmingLanguagesList.add("Java");
        programmingLanguagesList.add("C#");
        programmingLanguagesList.add("C++");
        programmingLanguagesList.add("Javascript");
        programmingLanguagesList.add("PHP");
        programmingLanguagesList.add("Python");
        programmingLanguagesList.add("Ruby");
        //add objects to model
        model.addObject("programmingLanguageList", programmingLanguagesList);
        model.addObject("countryMap", country);

        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("index") User user, BindingResult result) {
        return new ModelAndView("main","user", user);
    }
}
