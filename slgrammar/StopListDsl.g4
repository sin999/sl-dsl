grammar StopListDsl;

//ql_statement
//   : select_statement
//   | update_statement
//   | delete_statement
//   ;
//
select_statement
   : select_clause  from_clause (where_clause)?
   ;

select_clause
    : 'SELECT' IDENTIFIER
    ;

from_clause
    : 'FROM' IDENTIFIER IDENTIFIER?
    ;

where_clause
    : 'WHERE' filter_exprassion
    ;

filter_exprassion
    : disjunction_arguments
    ;

disjunction_arguments
   : conjunction_arguments ('OR' conjunction_arguments)*
   ;

conjunction_arguments
   : (negate_exprassion) ('AND' negate_exprassion)*
   ;

negate_exprassion
   : ('NOT')? condition_exprassion
   ;

condition_exprassion
   : simple_cond_expression
//   | '(' disjunction_arguments ')'
   ;

simple_cond_expression
   : comparison_expression
//   | between_expression
//   | like_expression
//   | in_expression
//   | null_comparison_expression
//   | empty_collection_comparison_expression
//   | collection_member_expression
//   | exists_expression
   ;


comparison_expression
  : string_expression comparison_operator string_expression
  | property_identifier comparison_operator integer_literal
//  | boolean_expression ('=' | '<>') (boolean_expression | all_or_any_expression)
//  | enum_expression ('=' | '<>') (enum_expression | all_or_any_expression)
//  | datetime_expression comparison_operator (datetime_expression | all_or_any_expression)
//  | entity_expression ('=' | '<>') (entity_expression | all_or_any_expression)
//  | arithmetic_expression comparison_operator (arithmetic_expression | all_or_any_expression)
  ;


property_identifier
    :   PROPERTY_IDENTIFIER
    ;


comparison_operator
  : '='
  | '>'
  | '>='
  | '<'
  | '<='
  | '<>'
  ;

string_expression
 : string_literal
// | '(' subquery ')'
 ;




integer_literal
    : SIGNED_INT
    ;
long_literal
    : SIGNED_LONG
    ;

string_literal : STRING_LITERAL ;

tmporal_literal
    :   DATE_LITERAL        #DateLiteral
    |   TIME_LITERAL        #TimeLiteral
    |   TIMESTAMP_LITERAL   #TimestampLiteral
    ;


STRING_LITERAL :  '\''( ~['\\\r\n] | EscapeSequence)* '\'';

SIGN: ('+'|'-');
SIGNED_INT: (SIGN)? ('0' | [1-9] (DIGIT | '_')*);
SIGNED_LONG: (SIGN)? ('0' | [1-9](DIGIT | '_')*)[Ll];

NUMBER : '0'
       | [1-9](DIGIT | '_')*;
DIGITS : DIGIT* ;



//Date - {d'yyyy-mm-dd'}
DATE_LITERAL : '{d\'' YEAR'-'MONTH_NUMBER'-'DAY_OF_MONTH '\'}';
//Time - {t'hh:mm:ss'}
TIME_LITERAL : '{t\'' HOUR_24':'MINUTES':'SECONDS'\'}';
//Timestamp - {ts'yyyy-mm-dd hh:mm:ss.nnnnnnnnn'} -
TIMESTAMP_LITERAL : '{ts\'' YEAR'-'MONTH_NUMBER'-'DAY_OF_MONTH ' ' HOUR_24':'MINUTES':'SECONDS'.'MICRO_SECONDS'\'}';


// Identifiers

IDENTIFIER:         Letter LetterOrDigit*;
PROPERTY_IDENTIFIER : SMALL_CHARACTER LetterOrDigit* ('.' SMALL_CHARACTER LetterOrDigit*)+;

fragment SMALL_CHARACTER : [a-z];

fragment YEAR : DIGIT DIGIT DIGIT DIGIT;
fragment MONTH_NUMBER : ('0'[1-9] | '1'[0-2]);
fragment DAY_OF_MONTH : ('3'[0-1] | [0-2][0-9]);
fragment HOUR_24 : ([0-1][0-9] | '2'[0-3] );
fragment MINUTES : [0-5][0-9];
fragment SECONDS : [0-5][0-9];
fragment MICRO_SECONDS : [0-9]*;
fragment DIGIT : [0-9];
fragment DIGIT_NOT_ZERRO : [1-9];


fragment HexDigits
    : HexDigit ((HexDigit | '_')* HexDigit)?
    ;

fragment HexDigit
    : [0-9a-fA-F]
    ;

fragment EscapeSequence
    : '\\' [btnfr"'\\]
    | '\\' ([0-3]? [0-7])? [0-7]
    | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
    ;


fragment LetterOrDigit
    : Letter
    | [0-9]
    ;

fragment Letter
    : [a-zA-Z$_] // these are the "java letters" below 0x7F
    | ~[\u0000-\u007F\uD800-\uDBFF] // covers all characters above 0x7F which are not a surrogate
    | [\uD800-\uDBFF] [\uDC00-\uDFFF] // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    ;


WS
   : [ \t\r\n] -> skip
   ;