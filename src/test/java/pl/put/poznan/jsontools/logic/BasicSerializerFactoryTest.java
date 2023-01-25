package pl.put.poznan.jsontools.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

public class BasicSerializerFactoryTest {
  BasicSerializerFactory factory;

  @BeforeEach
  void createFactory() {
    factory = new BasicSerializerFactory();
  }

  @Test
  void testExpectMinifyingSerializer() {
    JsonSerializer serializer = factory.create("minified");
    assertTrue(serializer instanceof MinifyJsonSerializer);
  }

  @Test
  void testExpectPrettifyingSerializer() {
    JsonSerializer serializer = factory.create("pretty");
    assertTrue(serializer instanceof PrettifyJsonSerializer);
  }

  @Test
  void testExpectInvalidParameterException() {
    assertThrows(InvalidParameterException.class, () -> factory.create("lorem"));
  }
}
