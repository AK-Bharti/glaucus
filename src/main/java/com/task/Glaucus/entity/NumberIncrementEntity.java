package com.task.Glaucus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author bharti
 *
 */
@Data
@Entity
@Table(name = "number_incr_table")
public class NumberIncrementEntity {
	
	@Id
	private int id;
	
	private int sequenceCounter;

}