package es.iesjandula.videoClubs.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.videoClubs.interfaces.IParseoRent;
import es.iesjandula.videoClubs.repository.RentRepository;
import es.iesjandula.videoClubs.utils.MovieError;

@Service
public class ParseoRentImpl implements IParseoRent
{
	@Autowired
	private RentRepository rentRepository;
	
	@Override
	public void parseoRent(Scanner scanner) throws MovieError
	{
		
		
	}

}
