package com.elsys.webapp.DataAccess;

import com.elsys.webapp.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
