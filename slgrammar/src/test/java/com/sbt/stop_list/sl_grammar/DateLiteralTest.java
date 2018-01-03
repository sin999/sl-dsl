package com.sbt.stop_list.sl_grammar;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DateLiteralTest extends AbstractParserTest {
    private static final SimpleDateFormat dateLiteralParser =new SimpleDateFormat("'{d'''yyyy-MM-dd'''}'");
    private static final SimpleDateFormat timeLiteralParser =new SimpleDateFormat("'{t'''hh:mm:ss'''}'");
    private static final SimpleDateFormat timeStampLiteralParser =new SimpleDateFormat("'{ts'''yyyy-mm-dd hh:mm:ss.SSS'''}'");
//Time - {t'hh:mm:ss'}

    //Timestamp - {ts'yyyy-mm-dd hh:mm:ss.nnnnnnnnn'}
    private static final String TEST_DATE = "{d'2012-01-03'}";
    private static final String TEST_TIME = "{t'11:12:13'}";
    private static final String TEST_TIME_STAMP = "{ts'2012-01-03 11:12:13.123'}";

    private Logger logger = LoggerFactory.getLogger(DateLiteralTest.class);


    @Test
    public void testDateString() throws ParseException {
        Date date = new Date();
        String dateAsAStrting = date.toString();
//        logger.info("" + (dateAsAStrting));
//        Date theSameDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dateAsAStrting);
//        logger.info(" expected >>" + date.getTime());
//        logger.info(" actual  >>" + theSameDate.getTime());
//        assertEquals("",date,theSameDate);

        date = dateLiteralParser.parse(TEST_DATE);
        logger.info(""+date);
    }

    @Test
    public void stringParsingTest() {
//        assertEquals("", new Date(), createTestVisitor().visit(getParser(TEST_DATE)
//                .date_literal()));
    }


    private StopListDslVisitor<Date> createTestVisitor() {
        return new StopListDslBaseVisitor<Date>() {
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dateParser =new SimpleDateFormat("{d'yyyy-MM-dd'}");
            /**
             * {@inheritDoc}
             *
             * <p>The default implementation returns the result of calling
             * {@link #visitChildren} on {@code ctx}.</p>
             */
            @Override
            public Date visitDate_literal(StopListDslParser.Date_literalContext ctx) {
//               logger.info(ctx.toStringTree());
//               logger.info("date text"+ctx.DATE_LITERAL().getText());
//               logger.info(ctx.TIME_LITERAL().getText());
//               logger.info(ctx.TIMESTAMP_LITERAL().getText());
//                logger.info("year -> "+ctx.YYYY()+" month -> "+ctx.MM()+" day ->"+ctx.DD());
//                Date rDate = null;
//                try {
//                    rDate = sdf.parse((ctx.YYYY()+"-"+ctx.MM()+"-"+ctx.DD()));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
                return new Date();
            }

        };
    }
}
