package es.iesjandula.videoClubs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.videoClubs.repository.MovieRepository;
import es.iesjandula.videoClubs.repository.UsersRepository;
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
	
	
	
	
}
