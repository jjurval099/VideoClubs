package es.iesjandula.videoClubs.interfaces;

import java.util.Scanner;

import es.iesjandula.videoClubs.utils.MovieError;

public interface IParseoMovie 
{
	public void parseoMovie(Scanner scanner) throws MovieError;
}
