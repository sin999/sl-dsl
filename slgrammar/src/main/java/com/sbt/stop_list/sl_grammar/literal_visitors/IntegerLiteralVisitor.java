package com.sbt.stop_list.sl_grammar.literal_visitors;

import com.sbt.stop_list.sl_grammar.StopListDslBaseVisitor;
import com.sbt.stop_list.sl_grammar.StopListDslParser;

public class IntegerLiteralVisitor extends StopListDslBaseVisitor<Integer> {
    @Override
    public Integer visitInteger_literal(StopListDslParser.Integer_literalContext ctx) {
        String integerString = ctx.SIGNED_INT().getText();
        return Integer.parseInt(integerString.replace("_",""));
    }
}
