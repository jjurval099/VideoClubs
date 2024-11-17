package es.iesjandula.VideoClubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.VideoClubs.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>
{

}
