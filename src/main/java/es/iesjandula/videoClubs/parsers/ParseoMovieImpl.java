package es.iesjandula.videoClubs.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.videoClubs.interfaces.IParseoMovie;
import es.iesjandula.videoClubs.models.Movie;
import es.iesjandula.videoClubs.repository.MovieRepository;
import es.iesjandula.videoClubs.utils.MovieError;

@Service
public class ParseoMovieImpl implements IParseoMovie
{
	@Autowired
	private MovieRepository movieRepository;
	

	@Override
	public void parseoMovie(Scanner scanner) throws MovieError
	{
		scanner.nextLine();
		
		while (scanner.hasNext()) 
		{
			String linea = scanner.nextLine();
			
			String [] valores = linea.split(",");
			
			Movie movie = new Movie();
			
			movie.setMovieId(Long.valueOf(valores[0]));
			
			movie.setTitle(valores[1]);
			
			movie.setDuration(valores[2]);
			
			
			this.movieRepository.saveAndFlush(movie);			 			
		}
	}
	
	

}
