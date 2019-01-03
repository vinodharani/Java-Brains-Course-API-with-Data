package io.javabrains.courseapidata.topic;

import org.springframework.data.repository.CrudRepository;

// CrudRepository has all methods already for CRUD operations
public interface TopicRepository extends CrudRepository<Topic, String> {
}
