package es.iesjandula.videoClubs.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Embeddable
public class RentId implements Serializable
{
	/** Serial Version UID */
	private static final long serialVersionUID = -433468710270308424L;

	private long userId;
	
	private long movieId;
	
	private Date fecha;

}
