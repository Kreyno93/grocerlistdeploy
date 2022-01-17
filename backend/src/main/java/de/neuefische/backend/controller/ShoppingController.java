package de.neuefische.backend.controller;

import de.neuefische.backend.repository.ShoppingRepo;
import de.neuefische.backend.service.ShoppingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ShoppingController {

    final ShoppingRepo shoppingRepo;

    public ShoppingController(ShoppingRepo shoppingRepo) {
        this.shoppingRepo = shoppingRepo;
    }
}
