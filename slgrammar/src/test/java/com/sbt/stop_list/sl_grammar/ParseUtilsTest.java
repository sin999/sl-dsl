package com.sbt.stop_list.sl_grammar;

import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

public class ParseUtilsTest {
    private static final String TEST_STRING = "'Test string'";

    private static final String TEST_DATE = "{d'2012-01-03'}";
    private static final String TEST_TIME = "{t'11:12:13'}";
    private static final String TEST_TIME_STAMP = "{ts'2012-01-03 11:12:13.123'}";

    @Test
    public void parsingAnyDateTest(){
        Date parsedDate = ParseUtils.parseDateLiteral(TEST_DATE);
        assertEquals("",1-1, parsedDate.getMonth());
        assertEquals("",2012-1900, parsedDate.getYear());
        assertEquals("",3-1, parsedDate.getDay());
    }

    @Test
    public void parsingTimeTest(){
        Date parsedDate = ParseUtils.parseTimeLiteral(TEST_TIME);
        assertEquals("",11, parsedDate.getHours());
        assertEquals("",12, parsedDate.getMinutes());
        assertEquals("",13, parsedDate.getSeconds());
    }

    @Test
    public void parsingTimeStampTest(){
        Date parsedDate = ParseUtils.parseTimeStampLiteral(TEST_TIME_STAMP);
        assertEquals("",1-1, parsedDate.getMonth());
        assertEquals("",2012-1900, parsedDate.getYear());
        assertEquals("",3-1, parsedDate.getDay());
        assertEquals("",11, parsedDate.getHours());
        assertEquals("",12, parsedDate.getMinutes());
        assertEquals("",13, parsedDate.getSeconds());
//        assertEquals("",13, parsedDate.getTime();
    }

    @Test
    public void stringParsingTest(){
        assertEquals("","Test string",ParseUtils.parseString(TEST_STRING));
    }

    @Test(expected = IllegalArgumentException.class)
    public void stringParsingEmptySourceTest(){
        assertEquals("","",ParseUtils.parseString(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void stringParsingNullSourceTest(){
        assertNull("",ParseUtils.parseString(null));
    }
}
