package com.sbt.stop_list.sl_grammar;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class SignetIntegerLiteralsParsingTest extends AbstractParserTest {
    private Logger logger = LoggerFactory.getLogger(SignetIntegerLiteralsParsingTest.class);
    private static final String TEST_INT_NEGATIVE_WITH_UNDERSCORE = "-123_000";
    private static final String TEST_INT_NEGATIVE = "-123";
    private static final String TEST_INT_SIMPLE = "1";


    @Test
    public void testParsingInt() {

        assertEquals("",Integer.valueOf(1),createTestVisitor().visit(getParser(TEST_INT_SIMPLE).integer_literal()));
    }

    @Test

    public void testParsingIntWithUnderscore() {
        assertEquals("",Integer.valueOf(-123_000),createTestVisitor().visit(getParser(TEST_INT_NEGATIVE_WITH_UNDERSCORE).integer_literal()));
    }

    @Test
    public void testParsingIntNegative() {
        assertEquals("",Integer.valueOf(-123),createTestVisitor().visit(getParser(TEST_INT_NEGATIVE).integer_literal()));
    }

    private StopListDslVisitor<Integer> createTestVisitor() {
        return new StopListDslBaseVisitor<Integer>() {
            @Override
            public Integer visitInteger_literal(StopListDslParser.Integer_literalContext ctx) {
                return ParseUtils.parseInteger(ctx.getText());
            }
        };
    }
}
