package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidatesCvDtos {
	
	private String firstName;
	private String lastName;
	private String schoolName;
	private String departmentName;
	private String startedYear;
	private String endedYear;

}
