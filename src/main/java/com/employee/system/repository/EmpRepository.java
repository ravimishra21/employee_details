package com.employee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.system.entity.EmpEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, Integer> {

}
