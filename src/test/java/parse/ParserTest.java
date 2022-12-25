package parse;


import org.junit.Test;

public class ParserTest {
  private AstDotPrintVisitor dotPrinter = new AstDotPrintVisitor();

  @Test
  public void testParse() {
    Parser p = new Parser();
    Expr e = p.parse("1+2*3");
    System.out.println();

    e = p.parse("1+2*3--1");
    System.out.println();
  }

  @Test
  public void testRightAssoc() {
    Parser p = new Parser();
    Expr e = p.parse("a=b=c");
    System.out.println();
  }

  @Test
  public void testConditional() {
    Parser p = new Parser();
    Expr e = p.parse("1+a? 3+2:4*3");
    System.out.println(dotPrinter.toDot(e));
  }

  @Test
  public void testGroup() {
    Parser p = new Parser();
    Expr e = p.parse("a * (1+2)");
    System.out.println(dotPrinter.toDot(e));
  }

}