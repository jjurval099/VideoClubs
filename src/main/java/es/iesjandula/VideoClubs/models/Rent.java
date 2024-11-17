package es.iesjandula.VideoClubs.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="rent")
public class Rent
{
	@EmbeddedId
	private RentId rentId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@MapsId("userId")
	private Users userId;
	
	@ManyToOne
	@JoinColumn(name = "movieId")
	@MapsId("movieId")
	private Movie movieId;
	
	@Column(length = 20)
	private String review;	

}
