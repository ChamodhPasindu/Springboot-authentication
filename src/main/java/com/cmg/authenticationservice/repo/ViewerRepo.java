package com.cmg.authenticationservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmg.authenticationservice.entity.Viewers;

public interface ViewerRepo extends JpaRepository<Viewers, Integer>{

}
