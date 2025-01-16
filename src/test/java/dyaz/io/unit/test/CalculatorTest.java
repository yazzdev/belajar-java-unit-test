package dyaz.io.unit.test;

import dyaz.io.unit.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// @DisplayName("Testing For Class Calculator")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {

  private Calculator calculator = new Calculator();

  @Test
  //@DisplayName("Testing Success method add(integer, integer)")
  public void testAddSuccess() {
    var result = calculator.add(10, 10);
    // Using assertions
    assertEquals(20, result);
  }

  @Test
  public void testDivideSuccess(){
    var result = calculator.divide(100, 10);
    assertEquals(10, result);
  }

  @Test
  public void testDivideFailed(){
    // Using assertions for accept error value
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.divide(10, 0);
    } );
  }

  @Test
  @Disabled
  public void testComingSoon(){
    // Testing for future
  }

}
