package com.machine.vending.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.machine.vending.model.Machine;
import com.machine.vending.repo.repo;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
@Transactional
public class machineservice {

// injected in this class, when
    private static repo itemRepository;

    @Autowired
    public machineservice(repo itemRepository) {
        this.itemRepository = itemRepository;
    }

    public static List<Machine> getAllItems() {
        return itemRepository.findAll();
    }

    public static Optional<Machine> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public static List<Machine> createItems(List<Machine> newItems) {
        List<Machine> addedItems = new ArrayList<>();
        for (Machine newItem : newItems) {
            Machine addedItem = itemRepository.save(newItem);
            addedItems.add(addedItem);
        }
        return addedItems;
    }
// add brand in the service file ass well set brand and
    public static Machine updateItem(Long id, Machine itemDetails) {
        Optional<Machine> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            Machine item = existingItem.get();
            item.setName(itemDetails.getName());
            item.setPrice(itemDetails.getPrice());
            //below
            item.setBrand(itemDetails.getBrand());
            item.setQuantity(itemDetails.getQuantity());
            return itemRepository.save(item);
        }
        return null;
    }

    public static void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
