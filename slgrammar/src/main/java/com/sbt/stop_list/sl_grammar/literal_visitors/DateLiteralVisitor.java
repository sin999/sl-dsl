package com.sbt.stop_list.sl_grammar.literal_visitors;

import com.sbt.stop_list.sl_grammar.StopListDslBaseVisitor;
import com.sbt.stop_list.sl_grammar.StopListDslParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateLiteralVisitor extends StopListDslBaseVisitor<Date> {

    private static final SimpleDateFormat dateLiteralParser = new SimpleDateFormat("'{d'''yyyy-MM-dd'''}'");
    private static final SimpleDateFormat timeLiteralParser = new SimpleDateFormat("'{t'''hh:mm:ss'''}'");
    private static final SimpleDateFormat timeStampLiteralParser = new SimpleDateFormat("'{ts'''yyyy-mm-dd hh:mm:ss.SSS'''}'");



    @Override
    public Date visitDateLiteral(StopListDslParser.DateLiteralContext ctx) {
        return parseDate(dateLiteralParser,ctx.getText());
    }


    @Override
    public Date visitTimeLiteral(StopListDslParser.TimeLiteralContext ctx) {
        return parseDate(timeLiteralParser,ctx.getText());
    }


    @Override
    public Date visitTimestampLiteral(StopListDslParser.TimestampLiteralContext ctx) {
        return parseDate(timeStampLiteralParser,ctx.getText());
    }

    private static Date parseDate(SimpleDateFormat parser,String literal){
        Date resultDate;
        try {
            resultDate = parser.parse(literal);
        } catch (ParseException e) {
            throw new RuntimeException("The Date literal has not been parsed "+ Objects.toString(literal),e);
        }
        return resultDate;
    }

}
