package parse.token.parserule;

import lombok.Getter;
import lombok.Setter;
import parse.token.TokenType;
import parse.token.parselet.HeadParselet;
import parse.token.parselet.TailParselet;

@Getter
@Setter
public class TokenParseRule {
  private TokenType type;
  //binding power
  private int bp;
  private HeadParselet headParselet;
  private TailParselet tailParselet;

  public TokenParseRule(TokenType type, int bp) {
    this.type = type;
    this.bp = bp;
  }


}
