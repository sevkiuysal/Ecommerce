package com.koylumuhendis.ecommerce.Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koylumuhendis.ecommerce.Commerce.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
