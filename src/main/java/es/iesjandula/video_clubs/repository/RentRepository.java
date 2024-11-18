package es.iesjandula.video_clubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.video_clubs.models.Rent;
import es.iesjandula.video_clubs.models.RentId;

public interface RentRepository extends JpaRepository<Rent, RentId>
{

}
