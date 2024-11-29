package es.iesjandula.videoClubs;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import es.iesjandula.videoClubs.interfaces.IParseoMovie;
import es.iesjandula.videoClubs.interfaces.IParseoRent;
import es.iesjandula.videoClubs.interfaces.IParseoUsers;
import es.iesjandula.videoClubs.repository.MovieRepository;
import es.iesjandula.videoClubs.repository.RentRepository;
import es.iesjandula.videoClubs.repository.UsersRepository;

@SpringBootApplication
public class VideoClubsApplication implements CommandLineRunner
{
	
	@Autowired
	private IParseoUsers IParseoUsers;
	
	@Autowired
	private IParseoMovie iParseoMovie;
	
	@Autowired
	private IParseoRent iParseoRent;

	public static void main(String[] args) 
	{
		SpringApplication.run(VideoClubsApplication.class, args);
	}

	@Transactional(readOnly = false)
	public void run(String... args) throws Exception 
	{
		String rutaFicheroUsers = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"users.csv";
		File fileUsers = new File(rutaFicheroUsers);
		Scanner scanner = new Scanner(fileUsers);
		IParseoUsers.parseoUsers(scanner);
		
		String rutaFicheroMovie = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"movie.csv";
		File fileMovie = new File(rutaFicheroMovie);
		Scanner scanner1 = new Scanner(fileMovie);
		iParseoMovie.parseoMovie(scanner1);
		/**
		String rutaFicheroRent = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"rent.csv";
		File fileRent = new File(rutaFicheroRent);
		Scanner scanner2 = new Scanner(fileRent);
		iParseoRent.parseoRent(scanner2);
		*/
		
	}

}
