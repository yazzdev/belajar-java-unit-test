package dyaz.io.unit.test;

import dyaz.io.unit.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// @DisplayName("Testing For Class Calculator")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {

  private Calculator calculator = new Calculator();

  @BeforeAll
  public static void beforeAll(){
    System.out.println("Before All Testing!");
  }

  @BeforeAll
  public static void afterAll(){
    System.out.println("After All Testing!");
  }

  @BeforeEach
  public void setUp(){
    System.out.println("Before Each Testing!");
  }

  @AfterEach
  public void tearDown(){
    System.out.println("After Each Testing!");
  }

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

  @Test
  public void testAborted(){
    // For cancel testing
    var profile = System.getenv("PROFILE");
    if (!"DEV".equals(profile)) {
      throw new TestAbortedException("[Test Aborted] -> not DEV");
    }
  }

}
