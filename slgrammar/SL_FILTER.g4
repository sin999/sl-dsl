grammar SL_FILTER;



filter_exprassion
    : disjunction_arguments
    ;

disjunction_arguments
   : (conjunction_arguments) ('OR' conjunction_arguments)*
   ;

conjunction_arguments
   : (negate_exprassion) ('AND' negate_exprassion)*
   ;

negate_exprassion
   : ('NOT')? condition_exprassion
   ;

condition_exprassion
   : simple_cond_expression
   | '(' disjunction_arguments ')'
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
  : string_expression comparison_operator (string_expression)
//  | boolean_expression ('=' | '<>') (boolean_expression | all_or_any_expression)
//  | enum_expression ('=' | '<>') (enum_expression | all_or_any_expression)
//  | datetime_expression comparison_operator (datetime_expression | all_or_any_expression)
//  | entity_expression ('=' | '<>') (entity_expression | all_or_any_expression)
//  | arithmetic_expression comparison_operator (arithmetic_expression | all_or_any_expression)
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
 : string_primary
// | '(' subquery ')'
 ;


state_field_path_expression
   : (IDENTIFICATION_VARIABLE | single_valued_association_path_expression) '.' state_field
   ;


string_primary
   : state_field_path_expression
   | STRINGLITERAL
   | input_parameter
   | functions_returning_strings
//   | aggregate_expression
   ;



single_valued_association_path_expression
   : IDENTIFICATION_VARIABLE '.' (single_valued_association_field '.')* single_valued_association_field
   ;

simple_arithmetic_expression
   : (arithmetic_term) (('+' | '-') arithmetic_term)*
   ;

arithmetic_term
   : (arithmetic_factor) (('*' | '/') arithmetic_factor)*
   ;

arithmetic_factor
   : ('+' | '-')? arithmetic_primary
   ;

arithmetic_primary
   : state_field_path_expression
   | numeric_literal
   | '(' simple_arithmetic_expression ')'
   | input_parameter
   | functions_returning_numerics
//   | aggregate_expression
   ;


numeric_literal
   : SIGNED_INT
   ;

string_literal
    : STRING_LITERAL_QUOTA STRING_LITERAL_VALUE STRING_LITERAL_QUOTA
    ;




functions_returning_numerics
   : 'LENGTH' '(' string_primary ')'
   | 'LOCATE' '(' string_primary ',' string_primary (',' simple_arithmetic_expression)? ')'
   | 'ABS' '(' simple_arithmetic_expression ')'
   | 'SQRT' '(' simple_arithmetic_expression ')'
   | 'MOD' '(' simple_arithmetic_expression ',' simple_arithmetic_expression ')'
   | 'SIZE' '(' collection_valued_path_expression ')'
   ;

collection_valued_path_expression
   : IDENTIFICATION_VARIABLE '.' (single_valued_association_field '.')* collection_valued_association_field
   ;




single_valued_association_field
   :
   ;


state_field
   : (embedded_class_state_field '.')* simple_state_field
   ;


input_parameter
   : '?' INT_NUMERAL
   | ':' IDENTIFICATION_VARIABLE
   ;


functions_returning_strings
   : 'CONCAT' '(' string_primary ',' string_primary ')'
   | 'SUBSTRING' '(' string_primary ',' simple_arithmetic_expression ',' simple_arithmetic_expression ')'
   | 'TRIM' '(' ((trim_specification)? (TRIM_CHARACTER)? 'FROM')? string_primary ')'
   | 'LOWER' '(' string_primary ')'
   | 'UPPER' '(' string_primary ')'
   ;



trim_specification
   : 'LEADING'
   | 'TRAILING'
   | 'BOTH'
   ;


simple_state_field
   :
   ;


embedded_class_state_field
   :
   ;

collection_valued_association_field
   :
   ;
date_literal
    :   DATE_LITERAL
    |   TIME_LITERAL
    |   TIMESTAMP_LITERAL
    ;


SIGN: ('+'|'-');
SIGNED_INT: (SIGN)? ('0' | [1-9] (Digits? | '_'+ Digits));
SIGNED_LONG: (SIGN)? ('0' | [1-9] (Digits? | '_'+ Digits))[Ll];




//Date - {d'yyyy-mm-dd'}
DATE_LITERAL : '{d\'' YEAR'-'MONTH_NUMBER'-'DAY_OF_MONTH '\'}';
//Time - {t'hh:mm:ss'}
TIME_LITERAL : '{t\'' HOUR_24':'MINUTES':'SECONDS'\'}';
//Timestamp - {ts'yyyy-mm-dd hh:mm:ss.nnnnnnnnn'} -
TIMESTAMP_LITERAL : '{ts\'' YEAR'-'MONTH_NUMBER'-'DAY_OF_MONTH HOUR_24':'MINUTES':'SECONDS'.'MICRO_SECONDS'\'}';

fragment YEAR : DIGIT DIGIT DIGIT DIGIT;
fragment MONTH_NUMBER : ('0'[1-9] | '1'[0-2]);
fragment DAY_OF_MONTH : ('3'[0-1] | [0-2][0-9]);
fragment HOUR_24 : ([0-1][0-9] | '2'[0-3] );
fragment MINUTES : [0-5][0-9];
fragment SECONDS : [0-5][0-9];
fragment MICRO_SECONDS : [0-9]*;
fragment DIGIT : [0-9];
fragment DIGIT_NOT_ZERRO : [1-9];





STRING_LITERAL_QUOTA : '\'';
STRING_LITERAL_VALUE :  ( ~['\\\r\n] | EscapeSequence)* ;


//// Literals
//
//
//DECIMAL_LITERAL:    ('0' | [1-9] (Digits? | '_'+ Digits)) [lL]?;
//HEX_LITERAL:        '0' [xX] [0-9a-fA-F] ([0-9a-fA-F_]* [0-9a-fA-F])? [lL]?;
//OCT_LITERAL:        '0' '_'* [0-7] ([0-7_]* [0-7])? [lL]?;
//BINARY_LITERAL:     '0' [bB] [01] ([01_]* [01])? [lL]?;
//
//FLOAT_LITERAL:      (Digits '.' Digits? | '.' Digits) ExponentPart? [fFdD]?
//             |       Digits (ExponentPart [fFdD]? | [fFdD])
//             ;
//
//HEX_FLOAT_LITERAL:  '0' [xX] (HexDigits '.'? | HexDigits? '.' HexDigits) [pP] [+-]? Digits [fFdD]?;
//
//BOOL_LITERAL:       'true'
//            |       'false'
//            ;
//
//CHAR_LITERAL:       '\'' (~['\\\r\n] | EscapeSequence) '\'';
//
//STRING_LITERAL:     '"' (~["\\\r\n] | EscapeSequence)* '"';
//
//NULL_LITERAL:       'null';
//
//// Separators
//
//LPAREN:             '(';
//RPAREN:             ')';
//LBRACE:             '{';
//RBRACE:             '}';
//LBRACK:             '[';
//RBRACK:             ']';
//SEMI:               ';';
//COMMA:              ',';
//DOT:                '.';
//
//// Operators
//
//ASSIGN:             '=';
//GT:                 '>';
//LT:                 '<';
//BANG:               '!';
//TILDE:              '~';
//QUESTION:           '?';
//COLON:              ':';
//EQUAL:              '==';
//LE:                 '<=';
//GE:                 '>=';
//NOTEQUAL:           '!=';
//AND:                '&&';
//OR:                 '||';
//INC:                '++';
//DEC:                '--';
//ADD:                '+';
//SUB:                '-';
//MUL:                '*';
//DIV:                '/';
//BITAND:             '&';
//BITOR:              '|';
//CARET:              '^';
//MOD:                '%';
//
//ADD_ASSIGN:         '+=';
//SUB_ASSIGN:         '-=';
//MUL_ASSIGN:         '*=';
//DIV_ASSIGN:         '/=';
//AND_ASSIGN:         '&=';
//OR_ASSIGN:          '|=';
//XOR_ASSIGN:         '^=';
//MOD_ASSIGN:         '%=';
//LSHIFT_ASSIGN:      '<<=';
//RSHIFT_ASSIGN:      '>>=';
//URSHIFT_ASSIGN:     '>>>=';
//
//// Java 8 tokens
//
//ARROW:              '->';
//COLONCOLON:         '::';
//
//// Additional symbols not defined in the lexical specification
//
//AT:                 '@';
//ELLIPSIS:           '...';
//
//// Whitespace and comments
//
//WS:                 [ \t\r\n\u000C]+ -> channel(HIDDEN);
//COMMENT:            '/*' .*? '*/'    -> channel(HIDDEN);
//LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);
//
//// Identifiers
//
//IDENTIFIER:         Letter LetterOrDigit*;

// Fragment rules

fragment ExponentPart
    : [eE] [+-]? Digits
    ;

fragment EscapeSequence
    : '\\' [btnfr"'\\]
    | '\\' ([0-3]? [0-7])? [0-7]
    | '\\' 'u'+ HexDigit HexDigit HexDigit HexDigit
    ;

fragment HexDigits
    : HexDigit ((HexDigit | '_')* HexDigit)?
    ;

fragment HexDigit
    : [0-9a-fA-F]
    ;

fragment Digits
    : [0-9] ([0-9_]* [0-9])?
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