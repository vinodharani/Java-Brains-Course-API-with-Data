package io.javabrains.courseapidata.courses;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// CrudRepository has all methods already for CRUD operations
public interface CourseRepository extends CrudRepository<Course, String> {

//    if we have to get all the courses based on the name or description, follow the below methods
//    method name should start with findBy
//    it should be appended by the name of the field with which you are doing the search
//    spring data jpa automatically parses the method name and generates the method for you. no need to implement the method
    List<Course> findByName(String name);
    List<Course> findByDescription(String description);

//    if you have to search the topic id, use the following way to name the method
//    as usual, method name starts with findBy
//    followed by the the name of the object contained within course, in our case, topic
//    and then the field in the topic that we are using to search, in our case, id
//    spring data jpa automatically parses the method name and generates the method for you. no need to implement the method
    List<Course> findByTopicId(String topicId);
}
