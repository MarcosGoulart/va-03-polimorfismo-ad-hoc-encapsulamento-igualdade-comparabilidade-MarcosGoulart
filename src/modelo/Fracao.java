package modelo;

public class Fracao implements Comparable<Fracao>{

  private int numerador;
  private int denominador;

  public void construtor(int numerador, int denominador){
    this.numerador = numerador;
    if(denominador == 0) denominador = 1;
    this.denominador = denominador;
    this.simplificar();
  }

  public Fracao(int numerador, int denominador) {
    this.construtor(numerador, denominador);
  }

  public Fracao(String fracao) {
    int[] fracaoInt = this.tratarFracaoString(fracao);
    this.construtor(fracaoInt[0], fracaoInt[1]);
  }
  

  public Fracao(double decimal) {
    int[] fracaoInt = this.tratarFracaoDouble(decimal);
    this.construtor(fracaoInt[0], fracaoInt[1]);
  }

  public int getNumerador() {
    return this.numerador;
  }

  public int getDenominador() {
    return this.denominador;
  }

  void somar(Fracao f) {
    int mmc = mmc(this.denominador, f.denominador);
    this.numerador = mmc / this.denominador * this.numerador
        + mmc / f.denominador * f.numerador;
    this.denominador = mmc;
    this.simplificar();
  }

  private void simplificar() {
    int mdc = mdc(this.numerador, this.denominador);
    this.numerador /= mdc;
    this.denominador /= mdc;
  }

  static int mdc(int n1, int n2) {
    int min = Math.min(n1, n2);
    for (int i = min; i > 1; i -= 1) {
      if (n1 % i == 0 && n2 % i == 0) {
        return i;
      }
    }
    return 1;
  }


  static int mmc(int n1, int n2) {
    return (n1 / mdc(n1, n2)) * n2;
  }

  public int[] tratarFracaoString(String fracao){
    String[] fracaoArray = fracao.split("/");
    int[] fracaoInt = {Integer.parseInt(fracaoArray[0]), Integer.parseInt(fracaoArray[1])};
    return fracaoInt;
  }

  public int[] tratarFracaoDouble(double decimal){
    int denominador = 1;
    
    while(decimal % 1 != 0){
      
      decimal *= 10;
      //System.out.println("decimal % 10 " + decimal % 10);
      //System.out.println("decimal " + decimal);
      denominador *= 10; 
    }
   // System.out.println("denominador " + denominador);
    int[] fracaoInt = {(int) decimal, denominador};
    return fracaoInt;
  }

  public String getString() {
    return this.numerador + "/" + this.denominador;
  }

  @Override
  public String toString() {
    return this.getString();
  }

  public void somar(int inteiro) {
    inteiro *= this.denominador;
    this.numerador += inteiro;
    this.simplificar();
  }

  public void somar(double decimal) {
    int[] fracaoInt = this.tratarFracaoDouble(decimal);
    this.somar(fracaoInt);
  }

  public void somar(String fracao) {
    int[] fracaoInt = this.tratarFracaoString(fracao);
    this.somar(fracaoInt);
  }

  public void somar(int[] fracaoInt){
    int mmc = mmc(this.denominador, fracaoInt[1]);
    fracaoInt[0] *= (mmc / fracaoInt[1]);
    this.numerador *= (mmc / this.denominador);
    this.numerador += fracaoInt[0];;
    this.denominador = mmc;
    this.simplificar();
  }

  @Override
  public  boolean equals(Object fracao){
    if(this.numerador == ((Fracao)fracao).getNumerador() && this.denominador == ((Fracao)fracao).getDenominador()) return true;
    return false;
  }

  public int compareTo(Fracao fracao) {
    int num = this.numerador;
    int num2 = fracao.getNumerador();
    int mmc = mmc(this.denominador, fracao.getDenominador());
    num *= (mmc / this.denominador);
    num2 *= (mmc / fracao.getDenominador());
    if(num > num2) return 1;
    if(num < num2) return -1;
    return 0;
  }
}
