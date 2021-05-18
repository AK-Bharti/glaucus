package com.task.Glaucus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.Glaucus.entity.NumberIncrementEntity;
import com.task.Glaucus.service.GlaucusService;

/**
 * @author bharti
 *
 */
@RestController
@RequestMapping("/glaucus")
public class GlaucusController {
	
	@Autowired
	private GlaucusService glaucusService;
	
	/**
	 * @return ResponseEntity<Object>
	 */
	@PostMapping("/number/increments")
	public ResponseEntity<Object> saveViewImg() {
		
		glaucusService.incrementTheNumber();
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
