package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatesExperienceCvDtos {
	
	private String firstName;
	private String lastName;
	private String companyName;
	private String positionName;
	private String startYear;
	private String lastYear;

}
