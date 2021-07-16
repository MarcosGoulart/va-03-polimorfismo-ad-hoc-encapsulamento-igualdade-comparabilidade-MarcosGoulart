package modelo;

public class Veiculo {
  final String placa;
  final String marca;
  final String modelo;
  final int    cilindrada;

  public Veiculo(String placa, String marca, String modelo, int cilindrada) {
    this.placa = placa;
    this.marca = marca;
    this.modelo = modelo;
    this.cilindrada = cilindrada;
  }

  public String getPlaca(){
    return this.placa;
  }

  public String getMarca(){
    return this.marca;
  }

  public String getModelo(){
    return this.modelo;
  }

  public int getCilindrada(){
    return this.cilindrada;
  }

  @Override
  public  boolean equals(Object veiculo){

      if(this.placa == ((Veiculo)veiculo).getPlaca() && this.marca == ((Veiculo)veiculo).getMarca() && this.modelo == ((Veiculo)veiculo).getModelo() && this.cilindrada == ((Veiculo)veiculo).getCilindrada()) return true;
      return false;
  }
}
