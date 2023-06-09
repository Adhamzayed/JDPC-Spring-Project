package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.Employeerep;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private Employeerep rep;

	@Autowired
	public EmployeeController(Employeerep rep) {
		super();
		this.rep = rep;
	}

	@GetMapping("/count")
	public long count() {
		return rep.count();
	}

	@GetMapping("/{id}")
	public Optional<Employee> findById(@PathVariable Long id, @RequestHeader String accept) {
		return rep.findById(id);
	}

	@GetMapping("")
	public List<Employee> findAll() {
		return (List<Employee>) rep.findAll();
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		rep.deleteById(id);
	}

	@DeleteMapping("")
	public void deleteAll() {
		rep.deleteAll();
	}

	@PostMapping("")
	public Employee addEmp(@RequestBody Employee emp) {
		return rep.save(emp);
	}

	@PutMapping("")
	public Employee update(@RequestBody Employee emp) {
		return rep.save(emp);
	}

	public void testJACKSON() throws JsonMappingException, JsonProcessingException {
		// Automatic Generated by Default in Spring

		ObjectMapper map = new ObjectMapper();
		// JSON String
		String json = "{\r\n" + "    \"id\": 1,\r\n" + "    \"name\": \"Hussein\",\r\n" + "    \"salary\": 6500\r\n"
				+ "}";
		// from Object to JSON
		Employee emp = map.readValue(json, Employee.class);
		// from JSON to Object
		json = map.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
	}
}
