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
public class Transcript {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transcriptId;
	private String degreeTitle;
	
	public Transcript(String _degreeTitle) {
		degreeTitle = _degreeTitle;
	}
}
