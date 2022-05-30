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
@Table(name="candidates_links",schema = "hrms")
public class CandidatesLinks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler","email","password","identityNumber","birthYear","passwordValidation"})
	@JoinColumn(name="candidates_id")
	private Candidates candidates;
	
	@ManyToOne
	@JoinColumn(name="links_type_id")
	private LinksType linksType;
	
	@Column(name="link")
	private String link;

}
