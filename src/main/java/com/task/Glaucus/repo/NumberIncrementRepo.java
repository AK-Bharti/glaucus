package com.task.Glaucus.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.task.Glaucus.entity.NumberIncrementEntity;

/**
 * @author bharti
 *
 */
@Repository
public interface NumberIncrementRepo extends JpaRepository<NumberIncrementEntity, Integer>{
		
	
	List<NumberIncrementEntity> findAll();
	
	@Transactional
	@Modifying
	@Query("update NumberIncrementEntity p set p.sequenceCounter = ?1 where p.id = ?2")
	void numberIncrement(int newSequenceCounter,int id);
	
}
