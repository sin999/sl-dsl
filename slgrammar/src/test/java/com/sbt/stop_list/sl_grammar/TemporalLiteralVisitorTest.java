package com.sbt.stop_list.sl_grammar;

import com.sbt.stop_list.sl_grammar.literal_visitors.DateLiteralVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TemporalLiteralVisitorTest extends AbstractVisitorTest {

    private Logger logger = LoggerFactory.getLogger(TemporalLiteralVisitorTest.class);

    private static final String TEST_DATE = "{d'2012-01-03'}";
    private static final String TEST_TIME = "{t'11:12:13'}";
    private static final String TEST_TIME_STAMP = "{ts'2012-01-03 11:12:13.123'}";

    @Test
    public void parsingDateTest() {
        Date parsedDate = parseTemporalLiteral(TEST_DATE);
        assertEquals("", 1 - 1, parsedDate.getMonth());
        assertEquals("", 2012 - 1900, parsedDate.getYear());
        assertEquals("", 3 - 1, parsedDate.getDay());
    }

    @Test
    public void parsingTimeTest() {
        Date parsedDate = parseTemporalLiteral(TEST_TIME);
        assertEquals("", 11, parsedDate.getHours());
        assertEquals("", 12, parsedDate.getMinutes());
        assertEquals("", 13, parsedDate.getSeconds());
    }

    @Test
    public void parsingTimeStampTest() {
        Date parsedDate = parseTemporalLiteral(TEST_TIME_STAMP);
        assertEquals("", 1 - 1, parsedDate.getMonth());
        assertEquals("", 2012 - 1900, parsedDate.getYear());
        assertEquals("", 3 - 1, parsedDate.getDay());
        assertEquals("", 11, parsedDate.getHours());
        assertEquals("", 12, parsedDate.getMinutes());
        assertEquals("", 13, parsedDate.getSeconds());
//        assertEquals("",13, parsedDate.getTime();
    }

    private Date parseTemporalLiteral(String temporalLiteral){
        ParseTree temporalLiteralTree = getParser(temporalLiteral).tmporal_literal();
        return createTestVisitor().visit(temporalLiteralTree);
    }


    private StopListDslVisitor<Date> createTestVisitor() {
        return new DateLiteralVisitor();
    }
}
