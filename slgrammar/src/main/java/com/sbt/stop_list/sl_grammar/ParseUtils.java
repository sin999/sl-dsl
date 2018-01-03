package com.sbt.stop_list.sl_grammar;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ParseUtils {

    private static final SimpleDateFormat dateLiteralParser =new SimpleDateFormat("'{d'''yyyy-MM-dd'''}'");
    private static final SimpleDateFormat timeLiteralParser =new SimpleDateFormat("'{t'''hh:mm:ss'''}'");
    private static final SimpleDateFormat timeStampLiteralParser =new SimpleDateFormat("'{ts'''yyyy-mm-dd hh:mm:ss.SSS'''}'");



    public static Integer parseInteger(String integerString){
        return Integer.parseInt(integerString.replace("_",""));
    }

    /**
     * This method is aimed to withdraw value from within a string literal
     * The last supposed to be quoted value  zum beispiel - 'my string'
     * @param quotedString
     * @return same string, with trimmed quotes
     */
    public static String parseString(String quotedString){
        if(quotedString == null || !quotedString.matches("^'(.*)'$"))
            throw new  IllegalArgumentException("The input value does't met the rules");
        return  quotedString.replaceAll("^'(.*)'$","$1");
    }

    public static Date parseDateLiteral(String dateLiteral){
        return parseDate(dateLiteralParser,dateLiteral);
    }

    public static Date parseTimeLiteral(String timeLiteral){
        return parseDate(timeLiteralParser,timeLiteral);
    }

    public static Date parseTimeStampLiteral(String timeStampLiteral){
        return parseDate(timeStampLiteralParser,timeStampLiteral);
    }

    private static Date parseDate(SimpleDateFormat parser,String literal){
        Date resultDate = null;
        try {
            resultDate = parser.parse(literal);
        } catch (ParseException e) {
            throw new RuntimeException("The Date literal has not been parsed "+ Objects.toString(literal),e);
        }
        return resultDate;
    }

}
