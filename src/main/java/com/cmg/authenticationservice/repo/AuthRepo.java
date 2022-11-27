package com.cmg.authenticationservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmg.authenticationservice.entity.Auth;

public interface AuthRepo extends JpaRepository<Auth, Integer>{

}
