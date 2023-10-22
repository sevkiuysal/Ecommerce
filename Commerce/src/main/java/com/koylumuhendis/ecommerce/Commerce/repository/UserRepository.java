package com.koylumuhendis.ecommerce.Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.koylumuhendis.ecommerce.Commerce.dto.CreateUserRequest;
import com.koylumuhendis.ecommerce.Commerce.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User save(User user);
	
//	@Modifying
//	@Query("update user u set u.firstname=:firstName, u.lastname=:lastName, u.address=:address WHERE u.id=:id")
//	User updateUser(@Param("id")Long id,
//			@Param("firtname")String firstName,
//			@Param("lastname")String lastName,
//			@Param("address")String address);
//	
//	@Modifying
//	@Query("update user u set u.active=false where u.id=:id")
//	void deactiveUser(@Param("id")Long id);

}
