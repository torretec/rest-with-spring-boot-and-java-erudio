package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	

	public List<Person> findAll() {
		
		logger.info("Finding all People!");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons ;
	}

	public Person findById(String id) {
		
		logger.info("Finding one Person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Lucas");
		person.setLastName("Oliveira");
		person.setAddress("Duque de Caxias - Rio de Janeiro - Brasil");
		person.setGender("Male");
		return person;
	}
	
	public Person create(Person person) {
		
		logger.info("Creating one Person!");
		
		return person;
		
	}
	public Person update(Person person) {
		
		logger.info("Updating one Person!");
		
		return person;
		
	}
	public void delete(String id) {
		
		logger.info("Deleting one Person!");
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last Name" + i);
		person.setAddress("Some Address in Brazil" + i);
		person.setGender("Male");
		return person;
	}
}