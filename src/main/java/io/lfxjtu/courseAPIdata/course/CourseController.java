package io.lfxjtu.courseAPIdata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.lfxjtu.courseAPIdata.topic.Topic;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "",""));
        courseService.addCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId, "",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
