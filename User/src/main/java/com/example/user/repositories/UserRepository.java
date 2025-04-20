package com.example.user.repositories;
import com.example.user.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User getUserById(String id);

    List<User> id(String id);
}