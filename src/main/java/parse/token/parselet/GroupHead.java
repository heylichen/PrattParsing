package parse.token.parselet;

import parse.Expr;
import parse.Parser;
import parse.token.Precedence;
import parse.token.Token;
import parse.token.TokenType;

public class GroupHead implements HeadParselet {

  @Override
  public Expr parse(Parser parser, Token token) {
    Expr inner = parser.parseRecursive(Precedence.NONE.getValue());
    parser.consume(TokenType.RIGHT_PAREN);
    return new Expr.Grouping(inner);
  }

}
