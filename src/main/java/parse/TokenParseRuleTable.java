package parse;

import parse.token.Precedence;
import parse.token.Token;
import parse.token.TokenType;
import parse.token.parselet.*;
import parse.token.parserule.TokenParseRule;
import parse.token.parserule.TokenParseRuleBuilder;

import java.util.EnumMap;

import static parse.token.parserule.TokenParseRuleBuilder.ruleBuilder;

public class TokenParseRuleTable {
  private EnumMap<TokenType, TokenParseRule> tokenRuleMap;

  public void init() {
    tokenRuleMap = new EnumMap<>(TokenType.class);

    LiteralHead literalHead = new LiteralHead();
    UnaryHead unaryHead = new UnaryHead();
    BinaryTail binaryTail = new BinaryTail();

    addTokenRule(TokenParseRuleBuilder.ruleBuilder(TokenType.NUMBER, Precedence.NONE).headParselet(literalHead).build());
    addTokenRule(ruleBuilder(TokenType.IDENTIFIER, Precedence.NONE).headParselet(literalHead).build());
    addTokenRule(ruleBuilder(TokenType.PLUS, Precedence.TERM).tailParselet(binaryTail).build());
    addTokenRule(ruleBuilder(TokenType.MINUS, Precedence.TERM).headParselet(unaryHead).tailParselet(binaryTail).build());
    addTokenRule(ruleBuilder(TokenType.STAR, Precedence.FACTOR).tailParselet(binaryTail).build());
    addTokenRule(ruleBuilder(TokenType.SLASH, Precedence.FACTOR).tailParselet(binaryTail).build());

    GroupHead groupHead = new GroupHead();
    addTokenRule(ruleBuilder(TokenType.LEFT_PAREN, Precedence.NONE).headParselet(groupHead).build());

    AssignTail assignTail = new AssignTail();
    addTokenRule(ruleBuilder(TokenType.EQUAL, Precedence.ASSIGNMENT).tailParselet(assignTail).build());

    ConditionalTail conditionalTail = new ConditionalTail();
    addTokenRule(ruleBuilder(TokenType.QUESTION, Precedence.CONDITIONAL).tailParselet(conditionalTail).build());

    addTokenRule(ruleBuilder(TokenType.EOF, Precedence.NONE).build());
    addTokenRule(ruleBuilder(TokenType.COLON, Precedence.NONE).build());
    addTokenRule(ruleBuilder(TokenType.RIGHT_PAREN, Precedence.NONE).build());
  }

  private void addTokenRule(TokenParseRule rule) {
    tokenRuleMap.put(rule.getType(), rule);
  }

  public TokenParseRule getRule(Token token) {
    return tokenRuleMap.get(token.getType());
  }

}
