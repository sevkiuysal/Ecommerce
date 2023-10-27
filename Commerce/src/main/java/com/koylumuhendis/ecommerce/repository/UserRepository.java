package com.koylumuhendis.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.koylumuhendis.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User save(User user);
	
	@Modifying
	@Query("UPDATE User\r\n"
			+ "	SET address=:address, firstname=:firstname, lastname=:lastname\r\n"
			+ "	WHERE id=:id")
	void updateUser(@Param("id") Long id,@Param("firstname")String firstname,
			@Param("lastname")String lastname,@Param("address")String address);
	
	@Modifying
	@Query("UPDATE User\r\n"
			+"SET isactive=false WHERE id=:id")
	void deactiveteById(@Param("id")Long id);
	
	@Modifying
	@Query("DELETE User\r\n"
			+"WHERE id=:id")
	Boolean userDeleteById(@Param("id")Long id);

}
