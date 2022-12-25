package parse.token.parselet;

import parse.Expr;
import parse.Parser;
import parse.token.Precedence;
import parse.token.Token;

public class UnaryHead implements HeadParselet {
  @Override
  public Expr parse(Parser parser, Token token) {
    Expr right = parser.parseRecursive(Precedence.UNARY.getValue());
    return new Expr.Unary(token, right);
  }
}
