package es.iesjandula.videoClubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.videoClubs.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long>
{

}
