package com.employee.system.service;

import com.employee.system.repository.EmpRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.system.entity.EmpEntity;
import java.util.Optional;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository empRepository;
	
	public void addEmp(EmpEntity e) {
		empRepository.save(e);
	}

	public List<EmpEntity> getAllEmp(){
		return empRepository.findAll();
}
	

	public EmpEntity getEmpById(int id) {
		 Optional<EmpEntity> e = empRepository.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	public void deleteEmp(int id) {
		empRepository.deleteById(id);
	}
	
	

}


















