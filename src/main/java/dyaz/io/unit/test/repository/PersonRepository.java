package dyaz.io.unit.test.repository;

import dyaz.io.unit.test.data.Person;

public interface PersonRepository {

  Person selectById(String id);

}
