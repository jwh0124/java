package com.circle.demo.customer.repository;

import com.circle.demo.customer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
