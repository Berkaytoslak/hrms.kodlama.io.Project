package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployersWithJobAdverts {
	
	private String companyName;
	private String jobDescription;
	private int openPosition;
	private LocalDate activeDate;
	private LocalDate lastDate;
	

}
