package kodlamaio.hrms.dataAccsess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Experiences;

public interface ExperiencesDao extends JpaRepository<Experiences, Integer>{

}
