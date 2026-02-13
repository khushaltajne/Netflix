package com.netflix.service;

import org.springframework.http.ResponseEntity;

import com.netflix.entity.MoviesEntity;
import com.netflix.utility.ResponseMessage;

import jakarta.validation.Valid;

public interface MoviesService {

	public ResponseEntity<ResponseMessage> getMovieByName(String mname);

	public ResponseEntity<ResponseMessage> deleteMovieByName(String movieName);

	public ResponseEntity<ResponseMessage> getAllMovies();

	public ResponseEntity<ResponseMessage> addMovie(@Valid MoviesEntity movie);
}
