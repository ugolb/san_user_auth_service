package com.san.auth.repositories;

import com.san.auth.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Method return User object retrieved from data base.
     *
     * @param email - user email specified during registration.
     * @return User object.
     */
    List<User> findByEmail(String email);
}
