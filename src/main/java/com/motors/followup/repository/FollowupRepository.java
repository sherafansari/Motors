package com.motors.followup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.motors.followup.model.FollowupDetails;

@Repository
public interface FollowupRepository extends JpaRepository<FollowupDetails, Long> {

}
