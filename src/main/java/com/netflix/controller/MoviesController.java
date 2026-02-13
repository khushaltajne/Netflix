package com.netflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.entity.MoviesEntity;
import com.netflix.service.MoviesService;
import com.netflix.utility.ResponseMessage;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@Validated
@RequestMapping("/netflix")
public class MoviesController {

	@Autowired
	private MoviesService moviesService;
	
	@PostMapping("/addmovie")
    public ResponseEntity<ResponseMessage> addMovie(@Valid @RequestBody MoviesEntity movie) {

        return moviesService.addMovie(movie);
    }
	
	@GetMapping("/getmoviebyName/{movieName}")
	public ResponseEntity<ResponseMessage> movieByName(@PathVariable String movieName) {
		return moviesService.getMovieByName(movieName);
	}
	
	@DeleteMapping("/deletebyName/{movieName}")
	public ResponseEntity<ResponseMessage> movieByNamedelete(@PathVariable String movieName) {
		return moviesService.deleteMovieByName(movieName);
	}
	
	@GetMapping("/getAllMovies")
	public ResponseEntity<ResponseMessage> allMovies() {
		return moviesService.getAllMovies();
	}
	
	
	
}
