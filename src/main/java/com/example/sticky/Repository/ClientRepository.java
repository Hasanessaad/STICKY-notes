package com.example.sticky.Repository;

import com.example.sticky.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "SELECT * FROM Client WHERE name = :name", nativeQuery = true)
    List<Client> findByName(@Param("name") final String name);
}
