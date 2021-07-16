import java.util.Arrays;
import java.util.Collections;

import modelo.*;
class App {
  public static void main(String[] args) {
    // Necessário importar Fracao

    Fracao f1 = new Fracao(5, 10);
    System.out.println(f1); // 1/2
    System.out.println(f1.toString().equals("1/2"));
    System.out.println(f1.getNumerador() == 1);
    System.out.println(f1.getDenominador() == 2);
    System.out.println(f1.getString().equals("1/2"));

    Fracao f2 = new Fracao(3, 0); // 3 inteiros
    System.out.println(f2.getString().equals("3/1"));

    Fracao f3 = new Fracao("30/40");
    System.out.println(f3.getNumerador() == 3);
    System.out.println(f3.getDenominador() == 4);
    System.out.println(f3.getString().equals("3/4"));

    Fracao f4 = new Fracao(0.345);
    // https://www.wolframalpha.com/input/?i=rationalize+0.345
    System.out.println(f4.getString().equals("69/200"));

    Fracao f5 = new Fracao(0.4);
    System.out.println(f5.getNumerador() == 2);
    System.out.println(f5.getDenominador() == 5);
    System.out.println(f5.getString().equals("2/5"));

    f1.somar(2);
    System.out.println(f1.getString().equals("5/2"));

    f1.somar(0.5);
    System.out.println(f1.getString().equals("3/1"));

    f1.somar(0.2862);
    System.out.println(f1.getString().equals("16431/5000"));

    f3.somar("7/8");
    System.out.println(f3.getNumerador() == 13);
    System.out.println(f3.getDenominador() == 8);
    System.out.println(f3.getString().equals("13/8"));

    f3.somar(6.45);
    System.out.println(f3.getNumerador() == 323);
    System.out.println(f3.getDenominador() == 40);
    System.out.println(f3.getString().equals("323/40"));

    Fracao f6 = new Fracao(4, 5); // PATCHED:
    Fracao f6 = new Fracao(1, 5); // para coincidir com f9.
    Fracao f7 = new Fracao(1, 3);
    Fracao f8 = new Fracao(125, 375);
    Fracao f9 = new Fracao(15, 75);

    System.out.println(f6.equals(f8) == false);
    System.out.println(f6.equals(f9) == true);
    System.out.println(f7.equals(f8) == true);

    System.out.println(new Fracao("3/19").equals(new Fracao(3, 19)) == true);

    Fracao f10 = new Fracao(2, 12);
    Fracao f11 = new Fracao(3, 4);
    Fracao f12 = new Fracao(9, 10);
    Fracao f13 = new Fracao(5);
    Fracao f14 = new Fracao(18, 24);

    // Todas estas assertivas devem imprimir true
    System.out.println(f10.compareTo(f11) < 0);
    System.out.println(f12.compareTo(f11) > 0);
    System.out.println(f13.compareTo(f12) > 0);
    System.out.println(f11.compareTo(f14) == 0);

    // PATCH: remover o `<Fracao>`, caso contrário causa erro de compilação em System.out.println(f15.compareTo(f16) == 0);
    // Comparable<Fracao> f15 = f10;
    // Comparable<Fracao> f16 = new Fracao(20, 120)
    Comparable f15 = f10;
    Comparable f16 = new Fracao(20, 120);

    System.out.println(f15.compareTo(f16) == 0);
    System.out.println(f16.compareTo(f14) < 0);

    Fracao[] fracoes = {f10, f11, f12, f13, f14};

    // Classifique em ordem crescente através de java.util.Arrays
    Arrays.sort(fracoes);

    System.out.println(fracoes[0].equals(f10));
    System.out.println(fracoes[1].equals(f11));
    System.out.println(fracoes[2].equals(f14));
    System.out.println(fracoes[3].equals(f12));
    System.out.println(fracoes[4].equals(f13));

    Complex complex1 = new Complex("2+3i");
    Complex complex2 = new Complex("2");
    Complex complex3 = new Complex("3i");
    Complex complex4 = new Complex(3, "+", 1);
    Complex complex5 = new Complex(2);
    Complex complex6 = new Complex(0, "+", 3);
    Complex complex7 = new Complex(2, "+", 3);

    System.out.println(complex1.compareTo(complex2) == 1);
    System.out.println(complex1.compareTo(complex3) == 1);
    System.out.println(complex1.compareTo(complex4) == -1);
    System.out.println(complex1.compareTo(complex5) == 1);
    System.out.println(complex1.compareTo(complex6) == 1);
    System.out.println(complex1.compareTo(complex7) == 0);

    System.out.println(complex1.equals(complex2) == false);
    System.out.println(complex1.equals(complex3) == false);
    System.out.println(complex1.equals(complex4) == false);
    System.out.println(complex1.equals(complex5) == false);
    System.out.println(complex1.equals(complex6) == false);
    System.out.println(complex1.equals(complex7) == true);

    Veiculo veiculo1 = new Veiculo("placa", "marca", "modelo", 0);
    Veiculo veiculo2 = new Veiculo("placa", "marca", "modelo", 0);
    Veiculo veiculo3 = new Veiculo("outra placa", "marca", "modelo", 0);

    System.out.println(veiculo1.equals(veiculo2) == true);
    System.out.println(veiculo1.equals(veiculo3) == false);

  }
}
