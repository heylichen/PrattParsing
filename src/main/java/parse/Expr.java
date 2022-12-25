package parse;

import lombok.Getter;
import parse.token.Token;

/**
 * Ast Node
 */
public abstract class Expr {
  interface Visitor<R> {
    R visitBinaryExpr(Binary expr);
    R visitGroupingExpr(Grouping expr);
    R visitLiteralExpr(Literal expr);
    R visitUnaryExpr(Unary expr);

    R visitConditionalExpr(Conditional conditional);
  }

  public static class Binary extends Expr {
    public Binary(Expr left, Token operator, Expr right) {
      this.left = left;
      this.operator = operator;
      this.right = right;
    }

    final Expr left;
    final Token operator;
    final Expr right;

    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitBinaryExpr(this);
    }
  }

  public static class Conditional extends Expr {
    public Conditional(Expr left, Token operator, Expr thenExpr, Expr elseExpr) {
      this.left = left;
      this.operator = operator;
      this.thenExpr = thenExpr;
      this.elseExpr = elseExpr;
    }

    final Expr left;
    final Token operator;
    final Expr thenExpr;
    final Expr elseExpr;

    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitConditionalExpr(this);
    }
  }

  @Getter
  public static class Grouping extends Expr {
    public Grouping(Expr Expr) {
      this.Expr = Expr;
    }

    final Expr Expr;

    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitGroupingExpr(this);
    }
  }

  public static class Literal extends Expr {
    public Literal(Object value) {
      this.value = value;
    }

    final Object value;

    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitLiteralExpr(this);
    }
  }

  public  static class Unary extends Expr {
    public Unary(Token operator, Expr right) {
      this.operator = operator;
      this.right = right;
    }

    final Token operator;
    final Expr right;

    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitUnaryExpr(this);
    }
  }

  abstract <R> R accept(Visitor<R> visitor);
}
