package de.neuefische.backend.repository;

import de.neuefische.backend.model.ShoppingItems;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingRepo extends MongoRepository<ShoppingItems,String> {

}