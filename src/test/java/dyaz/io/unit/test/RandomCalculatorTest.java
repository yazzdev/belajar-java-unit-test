package dyaz.io.unit.test;

import org.junit.jupiter.api.*;

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
}
