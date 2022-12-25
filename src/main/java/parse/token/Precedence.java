package parse.token;

import lombok.Getter;

public enum Precedence {
  NONE(0),
  ASSIGNMENT(20),    // =
  CONDITIONAL(40),   //  a ? b : c
  OR(60),            // or
  AND(80),           // and
  EQUALITY(100),      // == !=
  COMPARISON(120),   // < > <= >=
  TERM(140),         // + -
  FACTOR(160),       // * /
  UNARY(180),        // ! -
  CALL(200),         // . ()
  PRIMARY(220),
  ;
  @Getter
  private final int value;

  Precedence(int value) {
    this.value = value;
  }
}
