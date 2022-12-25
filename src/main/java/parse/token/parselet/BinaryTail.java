package parse.token.parselet;

import parse.Expr;
import parse.Parser;
import parse.token.Token;
import parse.token.parserule.TokenParseRule;

public class BinaryTail implements TailParselet {

  @Override
  public Expr parse(Parser parser, Token token, Expr left) {
    TokenParseRule tRule = parser.getRule(token);
    Expr right = parser.parseRecursive(tRule.getBp());
    return new Expr.Binary(left, token, right);
  }
}
