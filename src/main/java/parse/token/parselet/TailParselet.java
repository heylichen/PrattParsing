package parse.token.parselet;

import parse.Expr;
import parse.Parser;
import parse.token.Token;

public interface TailParselet {
  Expr parse(Parser parser, Token token, Expr left);
}