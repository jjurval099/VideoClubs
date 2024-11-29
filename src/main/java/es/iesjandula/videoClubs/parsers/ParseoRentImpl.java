package es.iesjandula.videoClubs.parsers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.videoClubs.interfaces.IParseoRent;
import es.iesjandula.videoClubs.models.Movie;
import es.iesjandula.videoClubs.models.Rent;
import es.iesjandula.videoClubs.models.RentId;
import es.iesjandula.videoClubs.models.Users;
import es.iesjandula.videoClubs.repository.MovieRepository;
import es.iesjandula.videoClubs.repository.RentRepository;
import es.iesjandula.videoClubs.repository.UsersRepository;
import es.iesjandula.videoClubs.utils.MovieError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParseoRentImpl implements IParseoRent
{
	@Autowired
	private RentRepository rentRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public void parseoRent(Scanner scanner) throws MovieError
	{
		scanner.nextLine();
		
		while (scanner.hasNext()) 
		{
			String linea = scanner.nextLine();
			
			String [] valores = linea.split(",");
			
			Rent rent = new Rent();
			
			Optional<Users>optionalUser = this.usersRepository.findById(Long.valueOf(valores[0]));
			
			if(!optionalUser.isPresent())
			{
				log.error("Asignatura no existe");
			}
			
			rent.setUserId(optionalUser.get());
			
			Optional<Movie>optionalMovie = this.movieRepository.findById(Long.valueOf(valores[1]));
			
			if(!optionalMovie.isPresent())
			{
				log.error("Movie no existe");
			}
			
			rent.setMovieId(optionalMovie.get());
			
			rent.setReview(valores[2]);
			
			Date fecha = null;
			try 
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				fecha = new Date(sdf.parse(valores[3]).getTime()); 
			}
			catch (Exception e)
			{
				log.error("Fecha inválida en la línea: " + linea, e);
			}
			
			// Crear RentId con los valores correctos
			RentId rentId = new RentId(optionalUser.get().getUserId(), optionalMovie.get().getMovieId(), fecha);
			
			// Asignar el RentId al Rent
			rent.setRentId(rentId);
			
			this.rentRepository.saveAndFlush(rent);
		}
		
		
	}

}
