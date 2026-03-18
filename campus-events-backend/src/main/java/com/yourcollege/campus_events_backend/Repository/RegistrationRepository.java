package com.yourcollege.campus_events_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourcollege.campus_events_backend.entity.Registration;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	
	List<Registration> findByUserId(Long userId);

}
