package com.sbt.stop_list.sl_grammar;

import com.sbt.stop_list.sl_grammar.literal_visitors.StringLiteralVisitor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringLiteralVisitorTest extends AbstractVisitorTest {

    private static final String TEST_STRING = "'Test string'";

    @Test
    public void stringParsingTest() {
        assertEquals("", "Test string", createTestVisitor().visit(getParser(TEST_STRING).string_literal()));
    }


    private StopListDslVisitor<String> createTestVisitor() {
        return new StringLiteralVisitor();
    }

}

