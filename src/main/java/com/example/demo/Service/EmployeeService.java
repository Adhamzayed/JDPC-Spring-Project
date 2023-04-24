package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.Employeerep;

@Service
public class EmployeeService {

	@Autowired
	private Employeerep rep;
	
	public List<Employee> findByName(String name){
		return rep.findByName(name);
	}
}
