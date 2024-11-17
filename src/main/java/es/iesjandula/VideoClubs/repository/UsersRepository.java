package es.iesjandula.VideoClubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.VideoClubs.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long>
{

}
