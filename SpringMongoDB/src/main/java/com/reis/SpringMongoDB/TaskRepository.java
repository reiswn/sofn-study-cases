package com.reis.SpringMongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String>{

	public Task findByName(String name);
	
}