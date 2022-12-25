package parse.token.parselet;

import parse.Expr;
import parse.Parser;
import parse.token.Precedence;
import parse.token.Token;
import parse.token.TokenType;

/**
 * Parselet for the condition or "ternary" operator, like "a ? b : c".
 */
public class ConditionalTail implements TailParselet {

  @Override
  public Expr parse(Parser parser, Token token, Expr left) {
    Expr thenExpr = parser.parseRecursive(Precedence.NONE.getValue());
    parser.consume(TokenType.COLON);
    Expr elseExpr = parser.parseRecursive(Precedence.CONDITIONAL.getValue() -1);
    return new Expr.Conditional(left, token, thenExpr, elseExpr);
  }
}
