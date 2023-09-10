package edu.mum.cs.cs425.studentmgmt;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {
	@Autowired
	private StudentRepository stdRep;
	
	public void saveStudent(Student student) {
		stdRep.save(student);
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student std1 = new Student("000-61-0001","Anna","Lynn","Smith",3.45,new SimpleDateFormat("yyyy/MM/dd").parse("2019/5/24"));
		std1.addTranscript(new Transcript("BS Computer Science"));
		std1.addClassRoom(new Classroom("McLaughlin building", "M105"));
		saveStudent(std1);
	}
}
