package com.sbt.stop_list.sl_grammar;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractParserTest {

    private Logger logger = LoggerFactory.getLogger(AbstractParserTest.class);


    @Before
    public void beforeAbstractParserTest() {

    }

    public StopListDslParser getParser(String filterString) {
        StopListDslLexer lexer = new StopListDslLexer(new ANTLRInputStream(filterString));
        return new StopListDslParser(new CommonTokenStream(lexer));
    }
}
