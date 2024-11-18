package es.iesjandula.video_clubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.video_clubs.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>
{

}
