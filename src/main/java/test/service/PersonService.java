package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.repository.PersonRepository;
import test.request.PersonRequest;
import test.response.PersonResponse;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	public PersonResponse handleRequest(PersonRequest personRequest) {
		personRepository.insertPerson(personRequest.getName(), personRequest.getAddress(), personRequest.getOccupation());
		PersonResponse personResponse = new PersonResponse();
		personResponse.setCode(PersonResponse.CODE_SUCCESS);
		return personResponse;
	}

	public PersonResponse handleRequest() {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setCode(PersonResponse.CODE_SUCCESS);
		personResponse.setPersonList(personRepository.findAll());
		return personResponse;
	}

}
