package com.example.demo.repository;

import com.example.demo.model.ShoppingItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Long> {
    List<ShoppingItem> findByName(String name);
    ShoppingItem findById(long id);
}
