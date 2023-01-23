package pl.put.poznan.jsontools.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompoundSerializerFactoryTest {
    CompoundSerializerFactory factory;

    @BeforeEach
    void createFactory(){
        factory = new CompoundSerializerFactory();
    }

    @Test
    void testParseInputTwoKeys(){
        String[] keys = factory.parseInput("key0;key1");
        assertEquals(2, keys.length);
        assertEquals("key0", keys[0]);
        assertEquals("key1", keys[1]);
    }

    @Test
    void testParseInputOneKey(){
        String[] keys = factory.parseInput("key0");
        assertEquals(1, keys.length);
        assertEquals("key0", keys[0]);
    }

    @Test
    void testParseInputNoKey(){
        String[] keys = factory.parseInput("");
        assertEquals(0, keys.length);
    }

    @Test
    void testSplitTwoParams(){
        CompoundSerializerFactory.TransformDesignator td;
        td = factory.splitTransformAndArguments("action:param0,param1");
        assertEquals("action", td.transformId);
        assertEquals(2, td.arguments.length);
        assertEquals("param0", td.arguments[0]);
        assertEquals("param1", td.arguments[1]);
    }

    @Test
    void testSplitOneParam(){
        CompoundSerializerFactory.TransformDesignator td;
        td = factory.splitTransformAndArguments("action:param0");
        assertEquals("action", td.transformId);
        assertEquals(1, td.arguments.length);
        assertEquals("param0", td.arguments[0]);
    }

    @Test
    void testSplitNoParam(){
        CompoundSerializerFactory.TransformDesignator td;
        td = factory.splitTransformAndArguments("action");
        assertEquals("action", td.transformId);
        assertEquals(0, td.arguments.length);
    }

    @Test
    void testSplitOneParamWithColon(){
        CompoundSerializerFactory.TransformDesignator td;
        td = factory.splitTransformAndArguments("action:param:0");
        assertEquals("action", td.transformId);
        assertEquals(1, td.arguments.length);
        assertEquals("param:0", td.arguments[0]);
    }
}
