package com.motors.followup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.motors.followup.model.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
	Visitor findByVisitorId(Long visitorId);
}
