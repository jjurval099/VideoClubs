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
@Table(name="movie")
public class Movie 
{
	
	@Id
	@Column(length = 10, nullable = false)
	private long movieId;
	
	@Column(length = 15, nullable = false)
	private String title;
	
	@Column(length = 6, nullable = false)
	private String duration;

}
