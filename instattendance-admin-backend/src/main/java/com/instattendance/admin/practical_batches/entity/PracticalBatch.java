package com.instattendance.admin.practical_batches.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "batches")
@AllArgsConstructor
@NoArgsConstructor
@Data
 
public class PracticalBatch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String batchName;
	
	
	private String  className;
	
	private  String division;
	
	
	

	
	
	

}
