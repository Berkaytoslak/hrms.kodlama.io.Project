package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employers",schema = "hrms")
public class Employers extends Users{
	
	@Column(name="company_names")
	private String companyName;
	
	@Column(name="web_adress")
	private String webAdress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Transient
	private String passwordValidation;
	
}
