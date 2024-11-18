package es.iesjandula.video_clubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iesjandula.video_clubs.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long>
{

}
