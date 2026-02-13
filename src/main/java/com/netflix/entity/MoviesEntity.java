package com.netflix.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviesEntity {

	@Id
	private String id;

	@NotBlank(message = "Movie name is required")
	@Size(min = 1, max = 200)
	private String movieName;

	@NotNull(message = "Release date is required")
	@PastOrPresent(message = "Release date cannot be in the future")
	private LocalDate mrelease;

	@Size(max = 50)
	private String genre;

	@Size(max = 100)
	private String director;

	@DecimalMin(value = "0.0")
	@DecimalMax(value = "10.0")
	private Double rating;

	@Size(max = 1000)
	private String description;
}
