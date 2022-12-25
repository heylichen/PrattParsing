package parse.token.parselet;

import parse.Expr;
import parse.Parser;
import parse.token.Token;
/**
 * Parses assignment expressions like "a = b". The left side of an assignment
 * expression must be a simple name like "a", and expressions are
 * right-associative. (In other words, "a = b = c" is parsed as "a = (b = c)").
 */
public class AssignTail implements TailParselet {

  @Override
  public Expr parse(Parser parser, Token token, Expr left) {
    int rightAssocBp = parser.getRule(token).getBp() - 1;
    Expr right = parser.parseRecursive(rightAssocBp);
    return new Expr.Binary(left, token, right);
  }
}
