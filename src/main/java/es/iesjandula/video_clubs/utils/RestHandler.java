package es.iesjandula.video_clubs.utils;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.iesjandula.video_clubs.models.Movie;
import es.iesjandula.video_clubs.models.Users;
import es.iesjandula.video_clubs.repository.MovieRepository;
import es.iesjandula.video_clubs.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping(value = "/videoclub", produces = {"application/json"})
@RestController
public class RestHandler 
{
	@Autowired
    private MovieRepository movieRepository;
	
	@Autowired
    private UsersRepository usersRepository;
	
	
	/**MOVIE
	 * @throws IOException 
	 * @throws DatabindException 
	 * @throws StreamReadException */
	
	@RequestMapping(method = RequestMethod.POST, value = "/movie")
	public ResponseEntity<?> uploadMovies(@RequestBody(required = true) MultipartFile jsonFile) 
	{
		try 
		{
            List<Movie> movies = (List<Movie>) new ObjectMapper().readValue(jsonFile.getBytes(), List.class);
            
            if (movies.isEmpty())
            {
            	String errorString = "La lista de películas está vacía" ;
            	log.error(errorString) ;
            	
            	throw new MovieError(1, errorString) ;
            }
            
            this.movieRepository.saveAll(movies);
            return ResponseEntity.ok("Películas guardadas correctamente en la base de datos.");
        } 
		catch (IOException ioException) 
		{
			String errorString = "La lista de películas no tiene el formato correcto" ;
			MovieError movieError = new MovieError(1, errorString, ioException) ;
			
			log.error(errorString, ioException) ;
            return ResponseEntity.status(400).body(movieError.getBodyExceptionMessage());
        }
		catch (MovieError movieError)
		{
			return ResponseEntity.status(401).body(movieError.getBodyExceptionMessage());
		}	
		catch (Exception exception) 
		{
			String errorString = "Error al leer las peliculas" ;
			MovieError movieError = new MovieError(1, errorString, exception) ;
			
			log.error(errorString, exception) ;
            return ResponseEntity.status(400).body(movieError.getBodyExceptionMessage());
        }
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/movie")
	public ResponseEntity<?> downloadMovies()
	{
		// Recuperacion de todas las películas de la base de datos
        List<Movie> movies = movieRepository.findAll();
        return ResponseEntity.status(200).body(movies);		
	}
	
	/**USERS*/
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public ResponseEntity<?> uploadUsers(@RequestBody(required = true) MultipartFile jsonFile)
	{
		try 
		{
            List<Users> user = new ObjectMapper().readValue(jsonFile.getBytes(), List.class);
            usersRepository.saveAll(user);
            return ResponseEntity.ok("Usuarios guardados correctamente en la base de datos.");
        } 
		catch (IOException ioException) 
		{
            return ResponseEntity.status(400).body("Error al procesar el archivo JSON.");
        }	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public ResponseEntity<?> downloadUsers()
	{
		// Recuperacion de todas las películas de la base de datos
        List<Users> users = usersRepository.findAll();
        return ResponseEntity.status(200).body(users);			
	}
	
	/**BOOKING*/
	
	@RequestMapping(method = RequestMethod.GET, value = "/booking")
	public ResponseEntity<?> getMovies()
	{
		return ResponseEntity.status(200).body("Fichero bajado");		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/booking", consumes = {"application/json"})
	public ResponseEntity<?> searchMovies(@RequestBody(required = true) MultipartFile searchByFields)
	{
		return ResponseEntity.status(200).body("Fichero subido correctamente");		
	}
	
	/**booking/movieId*/
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/booking/{movieId}")
	public ResponseEntity<?> cancelBookingMovie(@PathVariable(value="movieId", required = true) Integer movieId)
	{
		return ResponseEntity.status(200).body("Fichero eliminado");		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/booking/{movieId}")
	public ResponseEntity<?> bookingMovie(@PathVariable(value="movieId", required = true) Integer movieId,
										  @RequestParam(value="userId", required = true) Integer userId)
	{
		return ResponseEntity.status(200).body("Fichero subido correctamente");		
	}
	
	
}