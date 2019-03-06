package com.repository;

import com.entity.javaBrains.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserDetailsRepositoty extends JpaRepository<UserDetails, Long> {
}
