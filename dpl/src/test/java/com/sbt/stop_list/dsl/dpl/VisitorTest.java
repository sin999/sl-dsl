package com.sbt.stop_list.dsl.dpl;

import com.sbt.persistence.api.dao.DPL;
import com.sbt.stop_list.jpa.JPALexer;
import com.sbt.stop_list.jpa.JPAParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class VisitorTest {

    private Logger logger = LoggerFactory.getLogger(VisitorTest.class);


    private InputStream inputStream;
    private Lexer lexer;
    private TokenStream tokenStream;
    private JPAParser parser;
    private DplCriteriaBuilderVisitor visitor;
    private DPL dpl;

    @Before
    public void init() throws IOException {
        /*
         * get the input file as an InputStream
         */
//        InputStream inputStream = Main.class.getResourceAsStream("/pyth.txt");
        inputStream = VisitorTest.class.getResourceAsStream("/query1.txt");

//        /*
//         * make Lexer
//         */
        lexer = new JPALexer(CharStreams.fromStream(inputStream));
//        /*
//         * get a TokenStream on the Lexer
//         */
        tokenStream = new CommonTokenStream(lexer);
//        /*
//         * make a Parser on the token stream
//         */
        parser = new JPAParser(tokenStream);
//        /*
//         * get the top node of the AST. This corresponds to the topmost rule of equation.q4, "equation"
//         */
//        EquationContext equationContext = parser.equation();

//        ParseTree tree = parser.start();



    }

    @Test
    public void visitorInvocationTest(){
        visitor = new DplCriteriaBuilderVisitor(null,null);
        String result = visitor.visit(parser.select_statement());
        logger.info(result);
    }


    @Test
    public void testInputStreamReading() throws IOException {

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String line = null;
//        while ((line = bufferedReader.readLine())!=null) System.out.println(line);


    }
}
