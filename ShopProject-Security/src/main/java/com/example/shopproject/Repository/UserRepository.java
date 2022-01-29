package com.example.shopproject.Repository;

import com.example.shopproject.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByNameAndPassword(String username,String password);
    Optional<User> findByToken(String token);
    Optional<User> findById(Long id);
    boolean existsByName(String name);
    Optional<User> findByName(String name);
}
