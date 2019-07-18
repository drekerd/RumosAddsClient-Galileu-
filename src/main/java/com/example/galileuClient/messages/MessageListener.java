package com.example.galileuClient.messages;

import com.example.galileuClient.courses.Course;
import com.example.galileuClient.courses.CoursesService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class MessageListener {

    private static final Logger LOGGER = Logger.getLogger("MessageListener");

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    CoursesService service;

    String messages;

    @JmsListener(destination = "standalone.queue")
    public void consume(String messages) {

        LOGGER.info("Consumes : started with message " + messages);
        service.setCourses(messages);
    }


    /*private List<Course> setMessage(String message) {
//        List<Course> messageFromJson = new GsonBuilder()
//                .create()
//                .fromJson(message, new TypeToken<List<Course>>(){}.getType());

        Gson gson = new Gson();
        CoursesService messageFromJson = gson.fromJson(message, CoursesService.class);

        LOGGER.info("setMessage : started with message " + message);

        List<Course> coursesFromServer = messageFromJson.getCourses();

        List<Course> returnCourseList = new ArrayList<>();

        for(Course c : coursesFromServer){
            Course course = new Course();

            course.setAddDescription(c.getAddDescription());
            course.setAddId(c.getAddId());
            course.setAddName(c.getAddName());
            course.setAddPrice(c.getAddPrice());

            returnCourseList.add(course);
        }

        return returnCourseList;
    }*/


}
