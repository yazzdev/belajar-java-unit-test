package dyaz.io.unit.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

  private Calculator calculator = new Calculator();

  @Test
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

}
