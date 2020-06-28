package com.example.test.repository;


import com.example.test.entity.Direction;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionRepository extends BaseRepository<Direction,Integer> {
    Direction findByName(String name);
}