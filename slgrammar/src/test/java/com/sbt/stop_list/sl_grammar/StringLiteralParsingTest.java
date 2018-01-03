package com.sbt.stop_list.sl_grammar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringLiteralParsingTest extends AbstractParserTest {

    private static final String TEST_STRING = "'Test string'";

    @Test
    public void stringParsingTest() {
        assertEquals("", "Test string", createTestVisitor().visit(getParser(TEST_STRING).string_literal()));
    }


    private StopListDslVisitor<String> createTestVisitor() {
        return new StopListDslBaseVisitor<String>() {
            @Override
            public String visitString_literal(StopListDslParser.String_literalContext ctx) {
                return ParseUtils.parseString(ctx.STRING_LITERAL().getText());
            }

        };
    }

}

