package com.machine.vending.repo;
import com.machine.vending.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface repo extends JpaRepository<Machine, Long> {

}