package dyaz.io.unit.test;

import org.junit.jupiter.api.Test;

public class LifecycleTest {

  private String temp;

  @Test
  void testA() {
    temp = "Temporary";
  }

  @Test
  void testB() {
    System.out.println(temp);
  }
}
