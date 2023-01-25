package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FilterKeepJsonSerializerTest {

  @Test
  void testKeep() {
    JsonSerializer baseSerializer = mock(JsonSerializer.class);
    when(baseSerializer.serialize(any(JsonNode.class)))
        .thenAnswer(
            invocation -> {
              Object[] args = invocation.getArguments();
              JsonNode node = (JsonNode) args[0];

              StringBuilder sb = new StringBuilder();
              for (Iterator<String> it = node.fieldNames(); it.hasNext(); ) {
                String key = it.next();
                sb.append(key);
                sb.append("\n");
              }
              return sb.toString();
            });

    ObjectNode inputNode = JsonNodeFactory.instance.objectNode();
    inputNode.put("a", "xyz");
    inputNode.put("b", 123);
    inputNode.put("c", "lorem");
    inputNode.put("d", "test");

    String[] keys = {"a", "b"};
    JsonSerializer serializer = new FilterKeepJsonSerializer(baseSerializer, keys);
    String serialized = serializer.serialize(inputNode);

    assertEquals("a\nb\n", serialized);
  }

  @Test
  void testKeepNotExists() {
    JsonSerializer baseSerializer = mock(JsonSerializer.class);
    when(baseSerializer.serialize(any(JsonNode.class)))
        .thenAnswer(
            invocation -> {
              Object[] args = invocation.getArguments();
              JsonNode node = (JsonNode) args[0];

              StringBuilder sb = new StringBuilder();
              for (Iterator<String> it = node.fieldNames(); it.hasNext(); ) {
                String key = it.next();
                sb.append(key);
                sb.append("\n");
              }
              return sb.toString();
            });

    ObjectNode inputNode = JsonNodeFactory.instance.objectNode();
    inputNode.put("a", "xyz");
    inputNode.put("b", 123);
    inputNode.put("c", "lorem");
    inputNode.put("d", "test");

    String[] keys = {"a", "b", "e"};
    JsonSerializer serializer = new FilterKeepJsonSerializer(baseSerializer, keys);
    String serialized = serializer.serialize(inputNode);

    assertEquals("a\nb\n", serialized);
  }

  @Test
  void testKeepEmptyResult() {
    JsonSerializer baseSerializer = mock(JsonSerializer.class);
    when(baseSerializer.serialize(any(JsonNode.class)))
        .thenAnswer(
            invocation -> {
              Object[] args = invocation.getArguments();
              JsonNode node = (JsonNode) args[0];

              StringBuilder sb = new StringBuilder();
              for (Iterator<String> it = node.fieldNames(); it.hasNext(); ) {
                String key = it.next();
                sb.append(key);
                sb.append("\n");
              }
              return sb.toString();
            });

    ObjectNode inputNode = JsonNodeFactory.instance.objectNode();
    inputNode.put("a", "xyz");
    inputNode.put("b", 123);
    inputNode.put("c", "lorem");
    inputNode.put("d", "test");

    String[] keys = {};
    JsonSerializer serializer = new FilterKeepJsonSerializer(baseSerializer, keys);
    String serialized = serializer.serialize(inputNode);

    assertEquals("", serialized);
  }
}
