package com.tuhocgira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuhocgira.role.entity.Group;
@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{

}
