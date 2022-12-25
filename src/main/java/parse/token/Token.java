package parse.token;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {
  private TokenType type;
  //original lexeme text. eg, a string "Hello"
  private final String lexeme;
  //parsed value. eg, Hello
  private final Object literal;

  public Token(TokenType type, String lexeme, Object literal) {
    this.type = type;
    this.lexeme = lexeme;
    this.literal = literal;
  }
}
