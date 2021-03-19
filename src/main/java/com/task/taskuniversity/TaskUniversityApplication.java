package com.task.taskuniversity;

import com.task.taskuniversity.model.Degree;
import com.task.taskuniversity.model.Department;
import com.task.taskuniversity.model.Lector;
import com.task.taskuniversity.service.DepartmentService;
import com.task.taskuniversity.service.LectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class TaskUniversityApplication{


	private static final Logger log = LoggerFactory.getLogger(TaskUniversityApplication.class);

	private Scanner sc = new Scanner(System.in);
	private List<Lector> lectors;
	
	public static void main(String[] args) {
		System.out.println("One second...");
		SpringApplication.run(TaskUniversityApplication.class);
	}

	@Bean
	public CommandLineRunner demo(DepartmentService departmentService, LectorService lectorService) {
		return (args) -> {
			System.out.println("1. What is head of department: ");
			Department department = departmentService.findByName(sc.nextLine());
			System.out.println("Head of " + department.getName() + " department is " + department.getHead());

			System.out.println("2. Show statistics in department: ");
			lectors = lectorService.findAllByDepartmentName(sc.nextLine());
			System.out.println("assistants: " + lectorService.assistantCount(lectors));
			System.out.println("associate professors: " + lectorService.associateProfessorCount(lectors));
			System.out.println("professors: " + lectorService.professorCount(lectors));

			System.out.println("3. Show the average salary for the department: ");
			lectors = lectorService.findAllByDepartmentName(sc.nextLine());

			System.out.println("The average salary is " + lectorService.averageSalary(lectors));

			System.out.println("4. Show count of employee of: ");
			lectors = lectorService.findAllByDepartmentName(sc.nextLine());
			System.out.println(lectorService.countAll(lectors));

			System.out.println("5. Global search: ");
			String word = sc.nextLine();
			lectors = lectorService.searchByNameLike(word);
			lectors.stream()
					.map(s -> s.getName())
					.forEach(System.out::println);

			List<Department> departments = departmentService.searchByNameLike(word);
			departments.stream()
					.map(s -> s.getName())
					.forEach(System.out::println);
		};
	}


}
