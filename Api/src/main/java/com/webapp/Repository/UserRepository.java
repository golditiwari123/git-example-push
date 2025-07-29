package com.webapp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}
