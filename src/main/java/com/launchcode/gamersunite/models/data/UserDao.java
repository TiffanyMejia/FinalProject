package com.launchcode.gamersunite.models.data;


import com.launchcode.gamersunite.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}
