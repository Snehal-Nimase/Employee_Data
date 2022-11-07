package com.employee.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.data.model.EmployeModel;
import com.employee.data.repositary.EmployeeRepository;

@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository  employeeRepository;
	
	@GetMapping("/helloPeople")
	public String hello() {
		return "Welcome All !!!!";
		
	}
	
	
	@GetMapping(path = "/getEmployeeData",produces = {"application/xml"})
	public List<EmployeModel> employeeData(){
		return employeeRepository.findAll();//will fetch all data from DBMS
		
	}
	
	//add data to employee
	@PostMapping(path = "/getaddedData",produces = {"application/xml"},consumes = {"application/xml"})
	public EmployeModel dataEmployee(@RequestBody EmployeModel employeeData) {
		return employeeRepository.save(employeeData);
	}
	
	//How to fetch particular employee data by id 
	@GetMapping("/getEmpData/{id}")
	public EmployeModel getEmpDataById(@PathVariable Long id) throws Exception {
		return employeeRepository.findById(id).orElseThrow(()-> new Exception("Employe with this is not exist" + id));
		
	}
	//Update Api
	@PutMapping("/updateEmpData/{id}")
	public EmployeModel updateEmpData(@PathVariable Long id,@RequestBody EmployeModel empData) throws Exception {
		EmployeModel empDataFromDB = employeeRepository.findById(id).orElseThrow(()-> new Exception("Emp Data with this id is not there " +id));
		
		empDataFromDB.setCompanyName(empData.getCompanyName());
		empDataFromDB.setDesignation(empData.getDesignation());
		empDataFromDB.setFname(empData.getFname());
		empDataFromDB.setLname(empData.getLname());
	
		return employeeRepository.save(empDataFromDB);
		
	}
	//Delete API
	@DeleteMapping("/deleteEmpData/{id}")
	public String deleteEmpData(@PathVariable Long id) throws Exception {
		String result = "This Data can't be Deleted ";
		EmployeModel empDataFromDB = employeeRepository.findById(id).orElseThrow(()-> new Exception("Emp Data with this id is not there " +id));
		
		employeeRepository.delete(empDataFromDB);
		result = "Data deleted Successfully";
		return result;
		
	}
}
