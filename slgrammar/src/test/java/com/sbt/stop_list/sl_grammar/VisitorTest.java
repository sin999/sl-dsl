package com.sbt.stop_list.sl_grammar;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

@Ignore
public class VisitorTest extends AbstractParserTest {
    private Logger logger = LoggerFactory.getLogger(VisitorTest.class);

    private static String FILTER_STRING = " a=1 OR NOT b=2 AND NOT y=4 OR c=3 ";


    @Before
    public void beforeVisitorTest() {
//        final StackTraceElement[] ste =Thread.currentThread().getStackTrace();
        logger.info("Child Init method invocation! " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    public void testDisjunctionVisiting() {
        assertEquals("", Integer.valueOf(3), createDisjunctionClauseTestVisitor().visit(getParser(FILTER_STRING).disjunction_arguments()));

    }

    private StopListDslVisitor<Integer> createDisjunctionClauseTestVisitor() {
        return new StopListDslBaseVisitor<Integer>() {
            @Override
            public Integer visitDisjunction_arguments(StopListDslParser.Disjunction_argumentsContext ctx) {
                visitChildren(ctx);
                return ctx.conjunction_arguments().size();
            }

            @Override
            public Integer visitComparison_operator(StopListDslParser.Comparison_operatorContext ctx) {
                logger.info("SSSS ->> " + ctx.getText());
                return visitChildren(ctx);
            }

            @Override
            public Integer visitInteger_literal(StopListDslParser.Integer_literalContext ctx) {
                logger.info(" Int -> "+ParseUtils.parseInteger(ctx.getText()));
                return visitChildren(ctx);
            }


        };
    }

}
