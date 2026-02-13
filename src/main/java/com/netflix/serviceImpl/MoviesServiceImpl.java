package com.netflix.serviceImpl;

import java.net.HttpURLConnection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.netflix.entity.MoviesEntity;
import com.netflix.repository.MoviesRepository;
import com.netflix.service.MoviesService;
import com.netflix.utility.Response;
import com.netflix.utility.ResponseMessage;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	private MoviesRepository moviesRepository;

	
	@Override
	public ResponseEntity<ResponseMessage> addMovie(MoviesEntity movie) {

		
		MoviesEntity existing = moviesRepository.findByMovieName(movie.getMovieName());
		if (existing != null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Movie already exists",
					HttpURLConnection.HTTP_BAD_REQUEST, Response.FAILURE.name()));
		}

		MoviesEntity savedMovie = moviesRepository.save(movie);

		return ResponseEntity.ok(new ResponseMessage("Movie added successfully", HttpURLConnection.HTTP_OK,
				Response.SUCCESS.name(), savedMovie));
	}

	
	@Override
	public ResponseEntity<ResponseMessage> getMovieByName(String movieName) {

		MoviesEntity movie = moviesRepository.findByMovieName(movieName);

		if (movie == null) {
			return ResponseEntity.status(HttpURLConnection.HTTP_NOT_FOUND).body(
					new ResponseMessage("Movie not found", HttpURLConnection.HTTP_NOT_FOUND, Response.FAILURE.name()));
		}

		return ResponseEntity.ok(new ResponseMessage("Movie fetched successfully", HttpURLConnection.HTTP_OK,
				Response.SUCCESS.name(), movie));
	}

	
	@Override
	public ResponseEntity<ResponseMessage> deleteMovieByName(String movieName) {

		MoviesEntity movie = moviesRepository.findByMovieName(movieName);

		if (movie == null) {
			return ResponseEntity.status(HttpURLConnection.HTTP_NOT_FOUND).body(
					new ResponseMessage("Movie not found", HttpURLConnection.HTTP_NOT_FOUND, Response.FAILURE.name()));
		}

		moviesRepository.delete(movie);

		return ResponseEntity.ok(
				new ResponseMessage("Movie deleted successfully", HttpURLConnection.HTTP_OK, Response.SUCCESS.name()));
	}

	// ✅ GET ALL MOVIES
	@Override
	public ResponseEntity<ResponseMessage> getAllMovies() {

		List<MoviesEntity> allMovies = moviesRepository.findAll();

		if (allMovies.isEmpty()) {
			return ResponseEntity.status(HttpURLConnection.HTTP_NO_CONTENT).body(new ResponseMessage(
					"No movies available", HttpURLConnection.HTTP_NO_CONTENT, Response.SUCCESS.name()));
		}

		return ResponseEntity.ok(new ResponseMessage("Movies fetched successfully", HttpURLConnection.HTTP_OK,
				Response.SUCCESS.name(), allMovies));
	}
}
