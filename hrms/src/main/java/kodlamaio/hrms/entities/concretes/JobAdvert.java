package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

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
@Table(name="job_advertisement")
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="salary_min")
	private int salaryMin;
	
	@Column(name="salary_max")
	private int salaryMax;
	
	@Column(name="open_position")
	private int openPosition;
	
	@Column(name="active_date")
	private LocalDate activeDate;
	
	@Column(name="last_date")
	private LocalDate lastDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler","email","password","phoneNumber","webAdress","passwordValidation"})
	@JoinColumn(name="employer_id")
	private Employers employers;
	
	@ManyToOne
	@JoinColumn(name="job_tittle_id")
	private JobTittles jobTittles;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private Cities cities;

}
