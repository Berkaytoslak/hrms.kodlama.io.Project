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
	/*private String companyName;
	private String positionName;
	private String startYear;
	private String lastYear;
	private String skillsName;
	private String linksType;
	private String link;
	private String language;
	private int level;*/

}
