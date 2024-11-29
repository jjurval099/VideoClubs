package es.iesjandula.videoClubs.parsers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iesjandula.videoClubs.interfaces.IParseoUsers;
import es.iesjandula.videoClubs.models.Users;
import es.iesjandula.videoClubs.repository.UsersRepository;
import es.iesjandula.videoClubs.utils.MovieError;

@Service
public class ParseoUsersImpl implements IParseoUsers
{
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public void parseoUsers(Scanner scanner) throws MovieError
	{
		scanner.nextLine();
		
		while (scanner.hasNext()) 
		{
			String linea = scanner.nextLine();
			
			String [] valores = linea.split(",");
			
			Users users = new Users();
			
			users.setUserId(Long.valueOf(valores[0]));
			
			users.setUserName(valores[1]);			
			
			this.usersRepository.saveAndFlush(users);			 			
		}
		
	}

}
