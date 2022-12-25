package parse.token.parserule;

import parse.token.Precedence;
import parse.token.TokenType;
import parse.token.parselet.HeadParselet;
import parse.token.parselet.TailParselet;

public final class TokenParseRuleBuilder {
  private HeadParselet headParselet;
  private TailParselet tailParselet;
  private TokenType type;
  private int bp;

  private TokenParseRuleBuilder() {
  }

  public static TokenParseRuleBuilder ruleBuilder(TokenType type, Precedence bp) {
    TokenParseRuleBuilder b = new TokenParseRuleBuilder();
    b.withBp(bp.getValue()).withType(type);
    return b;
  }
  public static TokenParseRuleBuilder ruleBuilder(TokenType type, int bp) {
    TokenParseRuleBuilder b = new TokenParseRuleBuilder();
    b.withBp(bp).withType(type);
    return b;
  }

  public TokenParseRuleBuilder headParselet(HeadParselet headParselet) {
    this.headParselet = headParselet;
    return this;
  }

  public TokenParseRuleBuilder tailParselet(TailParselet tailParselet) {
    this.tailParselet = tailParselet;
    return this;
  }

  public TokenParseRuleBuilder withType(TokenType type) {
    this.type = type;
    return this;
  }

  public TokenParseRuleBuilder withBp(int bp) {
    this.bp = bp;
    return this;
  }

  public TokenParseRule build() {
    TokenParseRule tokenParseRule = new TokenParseRule(type, bp);
    tokenParseRule.setHeadParselet(headParselet);
    tokenParseRule.setTailParselet(tailParselet);
    return tokenParseRule;
  }
}
