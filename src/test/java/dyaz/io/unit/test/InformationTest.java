package dyaz.io.unit.test;

import org.junit.jupiter.api.*;

@DisplayName("Information Test")
public class InformationTest {

  @Test
  @Tags({
          @Tag("cool"),
          @Tag("crazy")
  })
  @DisplayName("This is test first")
  void test1(TestInfo testInfo) {
    System.out.println(testInfo.getDisplayName());
    System.out.println(testInfo.getTags());
    System.out.println(testInfo.getTestClass().orElse(null));
    System.out.println(testInfo.getTestMethod().orElse(null));
  }
}
