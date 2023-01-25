package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ValueTypesJsonSerializerTest {

    @Test
    void testString(){
        JsonSerializer baseSerializer = mock(JsonSerializer.class);
        when(baseSerializer.serialize(any(JsonNode.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    JsonNode node = (JsonNode)args[0];

                    StringBuilder sb = new StringBuilder();
                    for (Iterator<String> it = node.fieldNames(); it.hasNext(); ) {
                        String key = it.next();
                        sb.append(key);
                        sb.append(":");
                        sb.append(node.get(key));
                        sb.append("\n");
                    }
                    return sb.toString();
                });

        ObjectNode inputNode = JsonNodeFactory.instance.objectNode();
        inputNode.put("a", "xyz");

        JsonSerializer serializer = new ValueTypesJsonSerializer(baseSerializer, new String[] {});
        String serialized = serializer.serialize(inputNode);

        assertEquals("a:\"string\"\n", serialized);
    }

    @Test
    void testNumber(){
        JsonSerializer baseSerializer = mock(JsonSerializer.class);
        when(baseSerializer.serialize(any(JsonNode.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    JsonNode node = (JsonNode)args[0];

                    StringBuilder sb = new StringBuilder();
                    for (Iterator<String> it = node.fieldNames(); it.hasNext(); ) {
                        String key = it.next();
                        sb.append(key);
                        sb.append(":");
                        sb.append(node.get(key));
                        sb.append("\n");
                    }
                    return sb.toString();
                });

        ObjectNode inputNode = JsonNodeFactory.instance.objectNode();
        inputNode.put("a", 123);

        JsonSerializer serializer = new ValueTypesJsonSerializer(baseSerializer, new String[] {});
        String serialized = serializer.serialize(inputNode);

        assertEquals("a:\"number\"\n", serialized);
    }

    @Test
    void testBool(){
        JsonSerializer baseSerializer = mock(JsonSerializer.class);
        when(baseSerializer.serialize(any(JsonNode.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    JsonNode node = (JsonNode)args[0];

                    StringBuilder sb = new StringBuilder();
                    for (Iterator<String> it = node.fieldNames(); it.hasNext(); ) {
                        String key = it.next();
                        sb.append(key);
                        sb.append(":");
                        sb.append(node.get(key));
                        sb.append("\n");
                    }
                    return sb.toString();
                });

        ObjectNode inputNode = JsonNodeFactory.instance.objectNode();
        inputNode.put("a", true);

        JsonSerializer serializer = new ValueTypesJsonSerializer(baseSerializer, new String[] {});
        String serialized = serializer.serialize(inputNode);

        assertEquals("a:\"boolean\"\n", serialized);
    }

    @Test
    void testNull(){
        JsonSerializer baseSerializer = mock(JsonSerializer.class);
        when(baseSerializer.serialize(any(JsonNode.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    JsonNode node = (JsonNode)args[0];

                    StringBuilder sb = new StringBuilder();
                    for (Iterator<String> it = node.fieldNames(); it.hasNext(); ) {
                        String key = it.next();
                        sb.append(key);
                        sb.append(":");
                        sb.append(node.get(key));
                        sb.append("\n");
                    }
                    return sb.toString();
                });

        ObjectNode inputNode = JsonNodeFactory.instance.objectNode();
        inputNode.putNull("a");

        JsonSerializer serializer = new ValueTypesJsonSerializer(baseSerializer, new String[] {});
        String serialized = serializer.serialize(inputNode);

        assertEquals("a:\"null\"\n", serialized);
    }
}