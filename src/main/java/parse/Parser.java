package parse;

import parse.lexer.Lexer;
import parse.token.Precedence;
import parse.token.Token;
import parse.token.TokenType;
import parse.token.parserule.TokenParseRule;

public class Parser {
  private Lexer lexer;
  private TokenParseRuleTable tokenParseRuleTable;

  public Expr parse(String Expr) {
    lexer = new Lexer(Expr);
    tokenParseRuleTable = new TokenParseRuleTable();
    tokenParseRuleTable.init();
    return parseRecursive(Precedence.NONE.getValue());
  }

  public Expr parseRecursive(int subExprPrecedence) {
    Token currentToken = lexer.next();
    TokenParseRule currentRule = getRule(currentToken);
    Expr left = currentRule.getHeadParselet().parse(this, currentToken);

    while ((currentRule = getRule(lexer.peek())).getBp() > subExprPrecedence) {
      //move to next
      currentToken = lexer.next();
      left = currentRule.getTailParselet().parse(this, currentToken, left);
    }
    return left;
  }

  public TokenParseRule getRule(Token token) {
    return tokenParseRuleTable.getRule(token);
  }

  public void consume(TokenType token) {
    if (lexer.next().getType() != token) {
      throw new IllegalArgumentException("expect token type " + token);
    }
  }
}
