package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDao;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
//			createStudent(studentDao);

//			createMultipleStudents(studentDao);

//			readStudent(studentDao);

			queryForStudents(studentDao);


		};
	}

    private void queryForStudents(StudentDao studentDao) {
		// get a list of students
		List<Student> allStudents = studentDao.findAll();

		// display list of students
		for (Student tempStudent : allStudents) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDao studentDao) {
        	// create a  student object
			Student tempStudent = new Student("Daniel","Brooks","daniel.brooks715@gmail.com");
		    // save the student
			studentDao.save(tempStudent);
		    //  display id of the saved student
			int id = tempStudent.getId();
			// retrieve student based on the id : primary key
			Student myStudent = studentDao.findById(id);
			//  display student
			System.out.println("Found a student: " + myStudent);
    }

	private void createMultipleStudents(StudentDao studentDao) {

		// create multiple students
		System.out.println("creating  student objects ... ");
		Student tempStudent1 = new Student("Ethan","Walker","ethan.walker938@gmail.com");
		Student tempStudent2 = new Student("Sophia","Bennett","sophia.bennett271@gmail.com");
		Student tempStudent3 = new Student("Lucas","Carter","lucas.carter564@gmail.com");
		Student tempStudent4 = new Student("Olivia","Hughes","olivia.hughes842@gmail.com");
		// save the student objects
		System.out.println("Saving the students ...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);
		studentDao.save(tempStudent4);
    }


    private void createStudent(StudentDao studentDao) {
        //  create the student object
		System.out.println("creating new student object ... ");
		Student tempStudent = new Student("Percy","Sun","sunpeng.ca@gmail.com");

		//  save the student object
		System.out.println("Saving the student ...");
		studentDao.save(tempStudent);

		//  display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }



}
