package parse.token.parselet;

import parse.Expr;
import parse.Parser;
import parse.token.Token;


public interface HeadParselet {
  Expr parse(Parser parser, Token token);
}
