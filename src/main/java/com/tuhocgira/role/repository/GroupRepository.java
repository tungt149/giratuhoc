package com.tuhocgira.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tuhocgira.dto.GroupDto;
import com.tuhocgira.role.entity.Group;
@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
	
	@Transactional(readOnly = true)
	@Query("SELECT g FROM Group g")
	List<GroupDto> findAllDto();

	int countByName(String groupName);



	

}
