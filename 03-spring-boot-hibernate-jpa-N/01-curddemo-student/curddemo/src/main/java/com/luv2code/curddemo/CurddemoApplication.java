package com.luv2code.curddemo;

import com.luv2code.curddemo.dao.StudentDAO;
import com.luv2code.curddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> { //this is a java lambda expression
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteStudentAll(studentDAO);
		};
	}

	private void deleteStudentAll(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsdeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsdeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;

		System.out.println("Deleteing student id: "+studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id:primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "Scooby"
		System.out.println("Updating Student...");
		myStudent.setFirstName("Scooby");

		//update the student
		studentDAO.update(myStudent);

		//display updated student
		System.out.println("Updated student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("kadam");

		//display that list of students
		for(Student tempStudent:theStudents)
		{
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display that list of students
		for(Student tempStudent:theStudents)
		{
			System.out.println(tempStudent);
		}
	}


	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating new student object..");
		Student tempStudent4 = new Student("Karan","Sajwani","karanSajwani.com");

		//save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent4);

		//display id of the saved student
		int theId = tempStudent4.getId();
		System.out.println("student of the id"+theId);

		//retrieve student based on the id:primary key
		System.out.println("retrieve student by id: "+theId);
		Student Mystudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student : "+Mystudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO)
	{
		System.out.println("Creating student object..");
		Student tempStudent1 = new Student("Kash","kadam","kadamKash.com");
		Student tempStudent2 = new Student("sup","kadam","kadamsup.com");
		Student tempStudent3 = new Student("ash","kadam","kadamash.com");

		System.out.println("Saving");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating student object..");
		Student tempStudent = new Student("Nisha","kadam","kadamnisha.com");

		//save the student object
		System.out.println("Saving");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student,Generated if: "+ tempStudent.getId());
	}

}

















