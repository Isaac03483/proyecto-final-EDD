
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.mio.compiler.parser;

import com.mio.compiler.lexer.CargaLexer;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class EntradaParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return EntradaParserSym.class;
}

  /** Default constructor. */
  @Deprecated
  public EntradaParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public EntradaParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public EntradaParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\021\000\002\002\004\000\002\002\005\000\002\003" +
    "\006\000\002\003\005\000\002\004\003\000\002\004\003" +
    "\000\002\004\003\000\002\004\003\000\002\004\003\000" +
    "\002\004\003\000\002\004\003\000\002\004\003\000\002" +
    "\004\003\000\002\007\004\000\002\007\003\000\002\005" +
    "\005\000\002\006\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\037\000\004\004\005\001\002\000\004\002\041\001" +
    "\002\000\004\017\037\001\002\000\004\004\005\001\002" +
    "\000\004\004\033\001\002\000\024\007\017\010\023\011" +
    "\011\012\021\013\015\014\012\015\020\016\013\017\022" +
    "\001\002\000\004\004\ufffd\001\002\000\004\004\ufff8\001" +
    "\002\000\004\004\ufff6\001\002\000\006\004\ufff5\017\031" +
    "\001\002\000\004\004\ufff9\001\002\000\004\004\025\001" +
    "\002\000\004\004\ufffb\001\002\000\004\004\ufff7\001\002" +
    "\000\004\004\ufffa\001\002\000\006\004\ufff3\017\ufff3\001" +
    "\002\000\004\004\ufffc\001\002\000\004\004\ufffe\001\002" +
    "\000\004\006\026\001\002\000\004\017\027\001\002\000" +
    "\004\005\030\001\002\000\006\002\ufff1\004\ufff1\001\002" +
    "\000\006\004\ufff4\017\ufff4\001\002\000\004\002\000\001" +
    "\002\000\006\006\026\017\037\001\002\000\024\007\017" +
    "\010\023\011\011\012\021\013\015\014\012\015\020\016" +
    "\013\017\022\001\002\000\004\004\025\001\002\000\004" +
    "\004\uffff\001\002\000\004\005\040\001\002\000\026\004" +
    "\ufff2\007\ufff2\010\ufff2\011\ufff2\012\ufff2\013\ufff2\014\ufff2" +
    "\015\ufff2\016\ufff2\017\ufff2\001\002\000\004\002\001\001" +
    "\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\037\000\006\002\003\005\005\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\003\006\005\007\001\001" +
    "\000\006\005\033\006\031\001\001\000\006\004\015\007" +
    "\013\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\006" +
    "\023\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\004\034\007\013\001\001\000\004" +
    "\006\035\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$EntradaParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$EntradaParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$EntradaParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    public EntradaParser(CargaLexer lexer){

        super(lexer);
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$EntradaParser$actions {
  private final EntradaParser parser;

  /** Constructor */
  CUP$EntradaParser$actions(EntradaParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$EntradaParser$do_action_part00000000(
    int                        CUP$EntradaParser$act_num,
    java_cup.runtime.lr_parser CUP$EntradaParser$parser,
    java.util.Stack            CUP$EntradaParser$stack,
    int                        CUP$EntradaParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$EntradaParser$result;

      /* select the action based on the action number */
      switch (CUP$EntradaParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= main EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.elementAt(CUP$EntradaParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.elementAt(CUP$EntradaParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$EntradaParser$stack.elementAt(CUP$EntradaParser$top-1)).value;
		RESULT = start_val;
              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.elementAt(CUP$EntradaParser$top-1)), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$EntradaParser$parser.done_parsing();
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // main ::= lName attributes rName 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("main",0, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.elementAt(CUP$EntradaParser$top-2)), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // attributes ::= attributes lName value rName 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("attributes",1, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.elementAt(CUP$EntradaParser$top-3)), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // attributes ::= lName value rName 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("attributes",1, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.elementAt(CUP$EntradaParser$top-2)), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // value ::= INT 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("value",2, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // value ::= SHORT 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("value",2, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // value ::= BYTE 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("value",2, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // value ::= FLOAT 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("value",2, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // value ::= DOUBLE 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("value",2, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // value ::= LONG 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("value",2, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // value ::= CHAR 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("value",2, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // value ::= BOOLEAN 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("value",2, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // value ::= string 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("value",2, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // string ::= string NAME 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("string",5, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.elementAt(CUP$EntradaParser$top-1)), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // string ::= NAME 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("string",5, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // lName ::= LESS NAME GREATER 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("lName",3, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.elementAt(CUP$EntradaParser$top-2)), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // rName ::= LESS DIAGONAL NAME GREATER 
            {
              Object RESULT =null;

              CUP$EntradaParser$result = parser.getSymbolFactory().newSymbol("rName",4, ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.elementAt(CUP$EntradaParser$top-3)), ((java_cup.runtime.Symbol)CUP$EntradaParser$stack.peek()), RESULT);
            }
          return CUP$EntradaParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$EntradaParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$EntradaParser$do_action(
    int                        CUP$EntradaParser$act_num,
    java_cup.runtime.lr_parser CUP$EntradaParser$parser,
    java.util.Stack            CUP$EntradaParser$stack,
    int                        CUP$EntradaParser$top)
    throws java.lang.Exception
    {
              return CUP$EntradaParser$do_action_part00000000(
                               CUP$EntradaParser$act_num,
                               CUP$EntradaParser$parser,
                               CUP$EntradaParser$stack,
                               CUP$EntradaParser$top);
    }
}

}
