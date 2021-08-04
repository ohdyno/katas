package com.example.springboot_helloworld.repositories;

import com.example.springboot_helloworld.models.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Customers extends JpaRepository<Name, Long> {
    @Query(value = "select * from CUSTOMERS where Name = ?1", nativeQuery = true)
    public Name getCustomerFromDatabase(String name);
}
