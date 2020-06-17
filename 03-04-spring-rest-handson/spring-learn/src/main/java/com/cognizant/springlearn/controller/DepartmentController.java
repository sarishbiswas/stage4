package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.service.DepartmentService;
@RestController
@RequestMapping("/departments")
public class DepartmentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	DepartmentService departmentService;

	@GetMapping("/")
	public ArrayList<Department> getAllDepartments(){
		LOGGER.info("START");
		LOGGER.info("END");
		return departmentService.getAllDepartments();
	}
}
