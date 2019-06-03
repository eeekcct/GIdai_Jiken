package ex190603;

public class ClassPC {
  protected int num1;
  protected int num2;
  protected int result;

  public ClassPC(){
    num1 = 0;
    num2 = 0;
    result = 0;
    System.out.println("パソコン起動・・・！");
  }

  public void setNum1(int num){
    num1 = num;
  }

  public void setNum2(int num){
    num2 = num;
  }

  public void Wa(){
    result = num1 + num2;
  }
  public void Sa(){
    result = num1 - num2;
  }
  public int getResult(){
    return result;
  }
}
