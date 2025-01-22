package dyaz.io.unit.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class SlowTest {

  @Test
  @Timeout(value = 5, unit = TimeUnit.SECONDS)
  void testSlow() throws InterruptedException {
    Thread.sleep(5_000);
  }
}
