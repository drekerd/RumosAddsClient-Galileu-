package com.example.galileuClient.courses;

import com.example.galileuClient.messages.MessageListener;
import com.example.galileuClient.messages.MessageTest;
import com.google.gson.GsonBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Data
@Controller
public class CoursesController {

    @Autowired
    CoursesService service;

    @Autowired
    MessageTest messageTest;

    //To test if nothing else is working
    @GetMapping("/test")
    public String getTest(Model model) {
        model.addAttribute("hello", "hello");
        return "test";
    }

    //for debugging
    @GetMapping("/test-message")
    public String getMessageTest(Model model) {
        MessageListener messageListener = new MessageListener();
        model.addAttribute("hello", service.getCourses());
        return "test";
    }


    @RequestMapping("/")
    public String getIndex(Model model) {
        return "index";
    }

    @RequestMapping("/courses")
    public String getCourses(Model model) {

        model.addAttribute("courses", service.getCourses());

        return "courses";
    }

}
