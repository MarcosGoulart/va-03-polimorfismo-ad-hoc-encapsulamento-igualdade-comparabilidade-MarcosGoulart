package modelo;

class Fracao {

  private int numerador;
  private int denominador;

  Fracao(int numerador, int denominador) {
    this.numerador = numerador;
    this.denominador = denominador;
    this.simplificar();
  }

  int getNumerador() {
    return this.numerador;
  }

  int getDenominador() {
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

  String getString() {
    return this.numerador + "/" + this.denominador;
  }

  @Override
  public String toString() {
    return this.getString();
  }

  public static void main(String... paraFinsDeTesteApenas) {
    Fracao f1 = new Fracao(3, 4);
    System.out.println(f1);

    Fracao f2 = new Fracao(144, 12);
    System.out.println(f2);

    Fracao f3 = new Fracao(18, 8);
    System.out.println(f3);

    f1.somar(f2);
    System.out.println(f1);

    f2.somar(f3);
    System.out.println(f2);

    Fracao f5 = new Fracao(3, 9);
    f5.somar(new Fracao(4, 8));
    System.out.println(f5);

  }
}
