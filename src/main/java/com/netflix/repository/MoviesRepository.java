package com.netflix.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.netflix.entity.MoviesEntity;

public interface MoviesRepository extends MongoRepository<MoviesEntity, String> {

	public MoviesEntity findByMovieName(String mname);

	public boolean deleteByMovieName(String movieName);

}
