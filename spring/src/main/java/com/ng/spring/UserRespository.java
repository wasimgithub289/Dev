package com.ng.spring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ng.spring.entities.User;

@Repository
public interface UserRespository extends CrudRepository<User, Integer> 
{

}
