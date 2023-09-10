package edu.mum.cs.cs425.studentmgmt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroomId;
	private String buildingName;
	private String roomNumber; 
	
	public Classroom(String _bldName, String _roomNumber) {
		buildingName = _bldName;
		roomNumber = _roomNumber;
	}
}
