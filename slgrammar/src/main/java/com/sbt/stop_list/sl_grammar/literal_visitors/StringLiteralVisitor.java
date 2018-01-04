package com.sbt.stop_list.sl_grammar.literal_visitors;

import com.sbt.stop_list.sl_grammar.StopListDslBaseVisitor;
import com.sbt.stop_list.sl_grammar.StopListDslParser;

public class StringLiteralVisitor extends StopListDslBaseVisitor<String>{


    //todo: make it possible to have a quote with escape character
    @Override
    public String visitString_literal(StopListDslParser.String_literalContext ctx) {
        String quotedString = ctx.getText();
        if(quotedString == null || !quotedString.matches("^'(.*)'$"))
            throw new  IllegalArgumentException("The input value does't mit the rules");
        return  quotedString.replaceAll("^'(.*)'$","$1");
    }
}
