package com.machine.vending.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.machine.vending.model.Machine;
import com.machine.vending.service.machineservice;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Machine")
public class machineresource {

    private final machineservice MachineService;

    @Autowired
    public machineresource(machineservice MachineService) {
        this.MachineService = MachineService;
    }

    //return all items and given mapping
    //List of Machine return HTTP response in form of List
    //call service and return

    @GetMapping("/all")
    public List<Machine> getAllItems() {
        return machineservice.getAllItems();
    }
    //CRUD ops


    @GetMapping("/find/{id}")
    public ResponseEntity<Machine> findItemById(@PathVariable Long id)
    {
        Optional<Machine> item = machineservice.getItemById(id);
        return item.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //Spring annotations used for mapping it with HTTP Req

    @PostMapping("/add")
    public ResponseEntity<List<Machine>> addItems(@RequestBody List<Machine> newItems)
    {
        List<Machine> addedItems = machineservice.createItems(newItems);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedItems);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Machine> updateItem(@PathVariable("id") Long id, @RequestBody Machine itemDetails) {
        Machine updatedItem = machineservice.updateItem(id, itemDetails);
        return updatedItem != null ? ResponseEntity.ok(updatedItem) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItemById(@PathVariable Long id)
    {
        machineservice.deleteItem(id);
        return ResponseEntity.ok().build();
    }

}












