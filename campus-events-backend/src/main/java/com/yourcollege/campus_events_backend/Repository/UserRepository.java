package com.yourcollege.campus_events_backend.Repository;

import com.yourcollege.campus_events_backend.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Long> {

    Optional<user> findByEmail(String email);

    boolean existsByEmail(String email);
}
