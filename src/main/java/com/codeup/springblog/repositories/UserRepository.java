package com.codeup.springblog.repositories;

import com.codeup.springblog.controllers.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}