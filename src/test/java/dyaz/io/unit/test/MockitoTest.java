package dyaz.io.unit.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockitoTest {

  @Test
  void testMock() {

    // Mock Object
    List<String> list = Mockito.mock(List.class);

    // Adding behaviour to Mock Object
    Mockito.when(list.get(0)).thenReturn("Dyaz");
    Mockito.when(list.get(10)).thenReturn("Amrullah");

    // Test Mock
    System.out.println(list.get(0));
    System.out.println(list.get(10));

    // Verify Mock
    Mockito.verify(list, Mockito.times(1)).get(0);

  }
}
