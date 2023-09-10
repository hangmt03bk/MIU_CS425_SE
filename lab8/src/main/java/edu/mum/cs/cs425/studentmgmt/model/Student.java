package edu.mum.cs.cs425.studentmgmt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	Date dateOfEnrollment;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "Student_ID")
	List<Classroom> classRoomList = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "Student_ID")
	List<Transcript> transcriptList = new ArrayList<>();
	
	public Student(String _stdNumber, String _firstName, String _middleName, String _lastName, Double _cgpa, Date _date) {
		studentNumber = _stdNumber;
		firstName = _firstName;
		middleName = _middleName;
		lastName = _lastName;
		cgpa = _cgpa;
		dateOfEnrollment = _date;
	}
	
	public void addClassRoom(Classroom _classRoom) {
		classRoomList.add(_classRoom);
	}
	
	public void addTranscript(Transcript _transcript) {
		transcriptList.add(_transcript);
	}
}
