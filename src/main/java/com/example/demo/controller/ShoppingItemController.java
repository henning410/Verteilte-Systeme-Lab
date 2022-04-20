package com.example.demo.controller;

import com.example.demo.model.ShoppingItem;
import com.example.demo.repository.ShoppingItemRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingItem")
public class ShoppingItemController {

    @Autowired
    ShoppingItemRepository shoppingItemRepository;

    @Operation(summary = "Create a new shopping item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item created", content = @Content) })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ShoppingItem createShoppingItem(@RequestBody ShoppingItem item){
        shoppingItemRepository.save(item);
        return item;
    }

    @Operation(summary = "Returns a list of shopping items")
    @GetMapping(produces = "application/json")
    List<ShoppingItem> getAllShoppingItems(){
        return (List<ShoppingItem>) shoppingItemRepository.findAll();
    }
}
