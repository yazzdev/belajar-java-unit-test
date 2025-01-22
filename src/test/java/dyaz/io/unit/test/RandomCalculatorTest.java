package dyaz.io.unit.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

public class RandomCalculatorTest extends AbstractCalculatorTest {

  @Test
  void testRandom(Random random) {
    var a = random.nextInt();
    var b = random.nextInt();

    var result = calculator.add(a, b);
    var expected = a + b;

    Assertions.assertEquals(expected, result);
  }

  @DisplayName("Random test")
  @RepeatedTest(
          value = 10,
          name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
  )
  void testRandomRepeat(Random random) {
    var a = random.nextInt();
    var b = random.nextInt();

    var result = calculator.add(a, b);
    var expected = a + b;

    Assertions.assertEquals(expected, result);
  }

  @DisplayName("(Info) Random test")
  @RepeatedTest(
          value = 10,
          name = "{displayName}"
  )
  void testRandomRepeatInfo(TestInfo testInfo, Random random, RepetitionInfo repetitionInfo) {
    System.out.println(
            testInfo.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions()
    );
    var a = random.nextInt();
    var b = random.nextInt();

    var result = calculator.add(a, b);
    var expected = a + b;

    Assertions.assertEquals(expected, result);
  }

  @DisplayName("Test Calculator")
  @ParameterizedTest(name = "{displayName} dengan parameter {0}")
  @ValueSource(ints = {1, 3, 5, 2, 4})
  void testWithParam(int value) {
    var expected = value + value;
    var result = calculator.add(value, value);

    Assertions.assertEquals(expected, result);
  }

  public static List<Integer> parameterSource(){
    return List.of(1,2,3);
  }

  @DisplayName("Test Calculator")
  @ParameterizedTest(name = "{displayName} dengan parameter {0}")
  @MethodSource({"parameterSource"})
  void testWithMethodSrc(int value) {
    var expected = value + value;
    var result = calculator.add(value, value);

    Assertions.assertEquals(expected, result);
  }
}
