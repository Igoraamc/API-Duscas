package com.duscas.example.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * GET
     * POST
     * PUT
     * DELETE
     *
     * GetMapping
     * GET http://localhost:8080/people
     */

    @GetMapping("/people")
    List<Person> all() {
        return personRepository.findAll();
    }

    @PostMapping("/people")
    Person newPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/people/{cpf}")
    Person one(@PathVariable String cpf) {
        return personRepository.findById(cpf)
                .orElseThrow(() -> new PersonNotFoundException(cpf));
    }

    @PutMapping("/people/{cpf}")
    Person replacePerson(@RequestBody Person newPerson, @PathVariable String cpf) {

        return personRepository.findById(cpf)
                .map(person -> {
                    person.setName(newPerson.getName());
                    person.setAge(newPerson.getAge());
                    if (person.getRole() == "Aluno") {
                        person.setCourse(newPerson.getCourse());
                    } else if (person.getRole() == "Professor") {
                        person.setSalary(newPerson.getSalary());
                    }
                    return personRepository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setCpf(cpf);
                    return personRepository.save(newPerson);
                });
    }

    @DeleteMapping("/people/{cpf}")
    void deleteEmployee(@PathVariable String cpf) {
        personRepository.deleteById(cpf);
    }
}
