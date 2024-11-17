package es.iesjandula.VideoClubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.VideoClubs.models.Rent;
import es.iesjandula.VideoClubs.models.RentId;

public interface RentRepository extends JpaRepository<Rent, RentId>
{

}
