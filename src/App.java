class App {
  public static void main(String[] args) {
    // Necessário importar Fracao

    Fracao f1 = new Fracao(5, 10);
    System.out.println(f1); // 1/2
    System.out.println(f1.toString().equals("1/2"));
    System.out.println(f1.getNumerador() == 1);
    System.out.println(f1.getDenomiador() == 2);
    System.out.println(f1.getString().equals("1/2"));

  }
}
