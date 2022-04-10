package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RestController
    class Hello {
        List<ShoppingItem> items = new ArrayList<>();

        @GetMapping("/hello")
        String helloWorld() {
            return "Hello World";
        }

        @GetMapping("/parameter/{id}")
        @ResponseBody
        String echoParameter(@PathVariable("id") String id) {
            return "Parameter ID: " + id;
        }

        /**
         * Usage of RequestParam, e.g. http://localhost:8090/item?name=User
         */
        @GetMapping("/item")
        @ResponseBody
        public ShoppingItem getItem(@RequestParam(value = "name", defaultValue = "default") String name) {
            return new ShoppingItem(name);
        }

        /**
         * Usage of PathVariable, e.g. http://localhost:8090/item/User
         */
        @GetMapping("/items/{name}")
        public ShoppingItem getItemByName(@PathVariable String name) {
            return new ShoppingItem(name);
        }

        /**
         * Return list of items
         */
        @GetMapping("/items")
        public List<ShoppingItem> getAllItems() {
            return items;
        }

        /**
         * Create item in List by using PathVariable and only name
         */
        @PostMapping("/items/{name}")
        public ShoppingItem setName(@PathVariable String name) {
            System.out.println("create item by name" + name);
            ShoppingItem tempItem = new ShoppingItem(name);
            items.add(tempItem);
            return tempItem;
        }

        /**
         * Create item in List using RequestBody and json
         */
        @PostMapping(path = "/items", consumes = "application/json", produces = "application/json")
        ShoppingItem createDemoItem(@RequestBody ShoppingItem item) {
            System.out.println("Item: " + item);
            items.add(item);
            return item;
        }

        /**
         * Delete using PathVariable and Iterator
         */
        @DeleteMapping("/items/{name}")
        public void deleteItem(@PathVariable String name) {
            items.removeIf(item -> item.getName().equals(name));
        }

        @PutMapping("/items")
        public ShoppingItem updateItemAmount(@RequestBody ShoppingItem item) {
            ShoppingItem returnItem = null;
            ListIterator<ShoppingItem> iterator = items.listIterator();
            while (iterator.hasNext()) {
                ShoppingItem iterItem = iterator.next();
                if (item.getName().equals(iterItem.getName())) {
                    System.out.println("Updating: " + iterItem);
                    iterator.set(item);
                    returnItem = item;
                    System.out.println("Updated: " + item);
                }
            }

            return returnItem;
        }

    }

}
