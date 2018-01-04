package com.sbt.stop_list.dsl.dpl;

import com.sbt.stop_list.sl_grammar.StopListDslParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

public class WhereVisitorTest extends AbstractParserTest{
    private static final String TEST_STRING ="SELECT c FROM C c WHERE c.a=1 AND c.b=2 OR c.c=3";
    private DplCriteriaBuilderVisitor dplCriteriaBuilderVisitor;


    @Before
    public void beforeWhereVisitorTest(){
        dplCriteriaBuilderVisitor = new DplCriteriaBuilderVisitor(null);
    }


    @Test
    public void testParsing(){
        StopListDslParser parser = getParser(TEST_STRING);
//        StopListDslParser parser = getParser("SELECT c FROM C c WHERE c.a=1");
        ParseTree parseTree = parser.select_statement();
        System.out.println(parseTree.toStringTree(parser));
//        System.out.println(parser.select_statement().getText());
//        System.out.println(parser.from_clause().getText());
//        dplCriteriaBuilderVisitor.visit(parser.where_clause());
    }
}
