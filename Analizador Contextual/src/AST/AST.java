package AST;

public abstract class AST
{
  public abstract Object visit(Visitor v,Object arg);
}
