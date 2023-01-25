package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FilterDeleteJsonSerializerTest {

    @Test
    void testDelete(){
        JsonSerializer baseSerializer = mock(JsonSerializer.class);
        when(baseSerializer.serialize(any(JsonNode.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    JsonNode node = (JsonNode)args[0];

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

        String[] keys = { "c", "d" };
        JsonSerializer serializer = new FilterDeleteJsonSerializer(baseSerializer, keys);
        String serialized = serializer.serialize(inputNode);

        assertEquals("a\nb\n", serialized);
    }

    @Test
    void testDeleteNotExists(){
        JsonSerializer baseSerializer = mock(JsonSerializer.class);
        when(baseSerializer.serialize(any(JsonNode.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    JsonNode node = (JsonNode)args[0];

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

        String[] keys = { "c", "d", "e" };
        JsonSerializer serializer = new FilterDeleteJsonSerializer(baseSerializer, keys);
        String serialized = serializer.serialize(inputNode);

        assertEquals("a\nb\n", serialized);
    }

    @Test
    void testDeleteEmptyResult(){
        JsonSerializer baseSerializer = mock(JsonSerializer.class);
        when(baseSerializer.serialize(any(JsonNode.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    JsonNode node = (JsonNode)args[0];

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

        String[] keys = { "a", "b", "c", "d" };
        JsonSerializer serializer = new FilterDeleteJsonSerializer(baseSerializer, keys);
        String serialized = serializer.serialize(inputNode);

        assertEquals("", serialized);
    }

    @Test
    void testDeleteEmptyRule(){
        JsonSerializer baseSerializer = mock(JsonSerializer.class);
        when(baseSerializer.serialize(any(JsonNode.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    JsonNode node = (JsonNode)args[0];

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
        JsonSerializer serializer = new FilterDeleteJsonSerializer(baseSerializer, keys);
        String serialized = serializer.serialize(inputNode);

        assertEquals("a\nb\nc\nd\n", serialized);
    }
}
