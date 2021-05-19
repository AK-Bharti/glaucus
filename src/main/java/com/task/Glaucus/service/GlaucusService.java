package com.task.Glaucus.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.task.Glaucus.entity.NumberIncrementEntity;
import com.task.Glaucus.repo.NumberIncrementRepo;
import com.task.Glaucus.utils.GeneralUtils;

import lombok.Synchronized;

/**
 * @author bharti
 *
 */
@Service
public class GlaucusService {
	
	@Autowired
	private NumberIncrementRepo numberIncrementRepo;
	
	private static int currentIncrementedValue=-1;
	
	/**
	 * @return NumberIncrementEntity
	 */
	@Synchronized
	@Transactional
	public void incrementTheNumber() {

		currentIncrementedValue=currentIncrementedValue+1;
		GeneralUtils.runOnSeperateThread.accept(new Runnable() {
			@Override
			public void run() {
				 List<NumberIncrementEntity> numberIncrementEntityList = numberIncrementRepo.findAll();
				 int id=0;
				 if(numberIncrementEntityList.size() == 0) {
					 try {
						NumberIncrementEntity numberIncrementEntity=new NumberIncrementEntity();
						numberIncrementRepo.save(numberIncrementEntity);
						return;
					 }catch(DataIntegrityViolationException ex) {
						numberIncrementRepo.numberIncrement(currentIncrementedValue,id);
						return;
					 }
				 }else {
					 id=numberIncrementEntityList.get(0).getId();
				 }
				numberIncrementRepo.numberIncrement(currentIncrementedValue,id);
			}
		});
		
	}

}
