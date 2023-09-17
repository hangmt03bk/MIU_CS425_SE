package edu.mum.cs.cs425.eregistrar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	@Column (nullable = false)
	private String studentNumber;
	@Column (nullable = false)
	private String firstName;
	@Column (nullable = true)
	private String middleName;
	@Column (nullable = false)
	private String lastName;
	@Column (nullable = true)
	private Double cgpa;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dateOfEnrollment;
	Boolean isInternational;
		
	public Student() {
		
	}
	public Student(String _stdNumber, String _firstName, String _middleName, String _lastName, Double _cgpa, Date _date, Boolean _isInternational) {
		studentNumber = _stdNumber;
		firstName = _firstName;
		middleName = _middleName;
		lastName = _lastName;
		cgpa = _cgpa;
		dateOfEnrollment = _date;
		isInternational = _isInternational;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getCgpa() {
		return cgpa;
	}
	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}
	public Date getDateOfEnrollment() {
		return dateOfEnrollment;
	}
	public void setDateOfEnrollment(Date dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}
	public Boolean getIsInternational() {
		return isInternational;
	}
	public void setIsInternational(Boolean isInternational) {
		this.isInternational = isInternational;
	}
	
	
}
