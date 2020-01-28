package com.reis.SpringMongoDB;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMongoDbApplication implements CommandLineRunner {

	@Autowired
	private TaskRepository taskRepository;
	private Scanner reader;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMongoDbApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		reader = new Scanner(System.in);
		//String name = reader.nextLine();
		//System.out.println(name);
		//reader.close();
		
		Integer op = 0;

		do {
			System.out.println("Choose option below");
			System.out.println("-------------------\n");
			System.out.println("1 - Create task");
			System.out.println("2 - List tasks");
			System.out.println("3 - Delete task by name");
			System.out.println("4 - Update task by name");
			System.out.println("0 - Exit");
			System.out.println("Type here: ");
			
			op = reader.nextInt();
			reader.nextLine();
			
			switch (op) {
			case 1: create(); break;
			case 2: list(); break;
			case 3:	delete(); break;
			case 4:	update(); break;
			default:
				System.out.println("Invalid option, try again.");
				break;
			}
			
		}while(op != 0);
		
		reader.close();
	}

	private void list() {
		List<Task> tasks = taskRepository.findAll();
		
		for(Task task : tasks) {
			System.out.println("Task: "+task.toString());
		}
	}

	private void delete() {
		System.out.println("Task name: ");
		String name = reader.nextLine();
		
		Task t = taskRepository.findByName(name);
		taskRepository.delete(t);
		
		System.out.println("Deleted!");
	}

	private void update() {
		System.out.println("Task name: ");
		String name = reader.nextLine();
		
		Task t = taskRepository.findByName(name);
		
		System.out.println("New name ("+name+"): ");
		String newName = reader.nextLine();
		
		t.setName(newName);
		
		taskRepository.save(t);
		
		System.out.println("Updated!");
	}

	private void create() {
		System.out.println("Task name: ");
		String name = reader.nextLine();
		
		taskRepository.insert(new Task(name));
	}

}
