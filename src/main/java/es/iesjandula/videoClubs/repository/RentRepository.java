package es.iesjandula.videoClubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.videoClubs.models.Rent;
import es.iesjandula.videoClubs.models.RentId;

public interface RentRepository extends JpaRepository<Rent, RentId>
{

}
