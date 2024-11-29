package es.iesjandula.videoClubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.videoClubs.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>
{

}
