package parse.token.parselet;

import parse.Expr;
import parse.Parser;
import parse.token.Token;

public class LiteralHead implements HeadParselet {

  @Override
  public Expr parse(Parser parser, Token token) {
    return new Expr.Literal(token.getLexeme());
  }

}
