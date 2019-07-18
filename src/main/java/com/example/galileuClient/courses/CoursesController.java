package com.example.galileuClient.courses;

import com.example.galileuClient.messages.MessageListener;
import com.google.gson.GsonBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Data
@Controller
public class CoursesController {

    @Autowired
    CoursesService service;

    @GetMapping("/courses")
    public String getCourses(Model model){

        MessageListener messageListener = new MessageListener();

        model.addAttribute("hello", service.getCourses());
        return "courses";
    }


}
