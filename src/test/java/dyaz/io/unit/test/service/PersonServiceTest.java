package dyaz.io.unit.test.service;

import dyaz.io.unit.test.data.Person;
import dyaz.io.unit.test.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

  @Mock
  private PersonRepository personRepository;

  private PersonService personService;

  @BeforeEach
  void setUp() {
    personService = new PersonService(personRepository);
  }

  @Test
  void testGetPersonNotFound() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      personService.get("Not Found!!");
    });
  }

  @Test
  void testGetPersonSuccess() {
    // Adding Behaviour to Mock Object
    Mockito.when(personRepository.selectById("D001"))
            .thenReturn(new Person("D001", "Dyaz Amrullah"));

    var person = personService.get("D001");

    Assertions.assertNotNull(person);
    Assertions.assertEquals("D001", person.getId());
    Assertions.assertEquals("Dyaz Amrullah", person.getName());
  }

  @Test
  void testRegisterSuccess() {
    var person = personService.register("Dyaz");
    Assertions.assertNotNull(person);
    Assertions.assertNotNull(person.getId());
    Assertions.assertEquals("Dyaz", person.getName());

    Mockito.verify(personRepository, Mockito.times(1))
            .insert(new Person(person.getId(), "Dyaz"));
  }
}
