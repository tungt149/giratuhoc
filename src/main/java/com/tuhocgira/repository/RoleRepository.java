package com.tuhocgira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuhocgira.role.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
