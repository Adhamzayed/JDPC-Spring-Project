package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Employee;
@Repository
public interface Employeerep extends CrudRepository<Employee,Long>{
	List<Employee> findByName(String name);
}
