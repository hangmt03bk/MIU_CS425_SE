package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;

public class Student {
	private String studentId;
	private String name;
	private LocalDate dateOfAdmission;
	
	public Student() {};
	public Student(String _stId, String _name, LocalDate  _dateOfAdmission) {
		studentId = _stId;
		name = _name;
		dateOfAdmission = _dateOfAdmission;
	};
	public Student(String _stId, String _name) {
		studentId = _stId;
		name = _name;
		dateOfAdmission = LocalDate.now();
	};
	
	@Override
	public String toString() {
		return "Student(studentId: " + studentId + 
				", name: " + name +
				", dateOfAdmission: " + dateOfAdmission + 
				")";
	}
	
	public String getStudentId() {return studentId;}
	public String getName() {return name;}
	public LocalDate getDateOfAdmission() {return dateOfAdmission;}
	
	public void setStudentId(String _stId) {studentId = _stId;}
	public void setName(String _name) {name = _name;}
	public void setDateOfAdmission (LocalDate _date) {dateOfAdmission = _date;}
}
