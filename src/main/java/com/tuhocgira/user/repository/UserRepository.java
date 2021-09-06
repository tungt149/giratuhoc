package com.tuhocgira.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tuhocgira.user.dto.UserDto;
import com.tuhocgira.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u") // JQPL
	List<UserDto> findAllUserDto();

	int countByUserName(String userName);

	int countByEmail(String email);


	
	@Query("SELECT u FROM User u LEFT JOIN FETCH u.groups WHERE u.userName =?1")
	Optional<User> findByUsernameWithGroup(String username);

}
