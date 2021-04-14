package test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import test.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
	
	List<Person> findAll();

	@Transactional
	@Modifying
	@Query(value="INSERT INTO person(name, address, occupation) VALUES(?1, ?2, ?3)", nativeQuery=true)
	void insertPerson(String name, String address, String occupation);
}
