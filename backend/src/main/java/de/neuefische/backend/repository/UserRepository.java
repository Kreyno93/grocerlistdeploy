package de.neuefische.backend.repository;

import de.neuefische.backend.model.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserMongo, String> {
    UserMongo findByUsername(String username);
}
