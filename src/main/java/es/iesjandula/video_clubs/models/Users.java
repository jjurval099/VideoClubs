package es.iesjandula.video_clubs.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class Users
{
	@Id
	@Column(length = 10, nullable = false)
	private long userId;
	
	@Column(length = 10, nullable = false)
	private String userName;

}
