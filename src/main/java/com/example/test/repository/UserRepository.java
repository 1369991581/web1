package com.example.test.repository;

import com.example.test.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User,Integer> {

    @Query("from User u where u.number=:number ")
    User find(@Param("number") int number);

}
