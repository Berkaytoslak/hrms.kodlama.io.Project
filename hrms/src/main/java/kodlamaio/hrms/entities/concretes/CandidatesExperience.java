package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="candidates_experience")
public class CandidatesExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler","email","password","identityNumber","birthYear","passwordValidation"})
	@JoinColumn(name="candidates_id")
	private Candidates candidates;
	
	@ManyToOne
	@JoinColumn(name="experience_id")
	private Experiences experiences;
	
	@ManyToOne
	@JoinColumn(name="position_id")
	private Position position;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="last_date")
	private String lastDate;

}
