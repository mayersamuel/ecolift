package at.ac.leonding.htl.feature.company.person.dtos;

import at.ac.leonding.htl.feature.company.person.Person;

import java.util.List;

public class PersonDtoFactory {
    static public PersonDto create(Person person) {
        return new PersonDto(person.id, person.name, person.company);
    }

    static public List<PersonDto> createList(List<Person> persons) {
        return persons.stream().map(PersonDtoFactory::create).toList();
    }
}
