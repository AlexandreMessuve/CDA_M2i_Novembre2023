package com.example.userapplication.repository;

import com.example.userapplication.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
