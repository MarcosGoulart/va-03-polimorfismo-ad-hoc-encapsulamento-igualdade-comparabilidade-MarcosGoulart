package modelo;

public class Complex {
    private int numero;
    private int complexo;
    private String sinal;

    public Complex(String complex){
        if(this.validate(complex)){    
        }else{
            System.out.println("Ó tens que manda a parada no formato certo!");
        }
    }

    public Complex(int numero, String sinal, int complexo){
        this.numero = numero;
        if(sinal.equals("+") || sinal.equals("-")) {
            this.sinal =  sinal;
        }else if(sinal.equals("")){
            this.sinal =  "+";
        }
        if(complexo < 0){
            System.out.println("insira numero complexo valido");
        } else {
            this.complexo = complexo;
        }
    }

    public Complex(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return this.numero;
    }

    public String getSinal(){
        return this.sinal;
    }

    public int getComplexo(){
        return this.complexo;
    }

    public Boolean validate(String complex){
        System.out.println("complex: " + complex.matches("[0-9]+[+]+[0-9]+[i]"));
        String[] complexArray = complex.split("");
        String tempString = "";
        if(complex.matches("[0-9]+[+]+[0-9]+[i]") || complex.matches("[0-9]+[-]+[0-9]+[i]")){
            if(complex.indexOf("+") != -1){
                this.atribuicao(complex.indexOf("+"), complexArray);
            } else if (complex.indexOf("-") != -1){
                this.atribuicao(complex.indexOf("-"), complexArray);
            }             
            return true;
        } else if(complex.matches("[0-9]+[i]")){
            this.atribuicao(complexArray);
            return true;
        }else if(complex.matches("[0-9]")) {
            this.numero = Integer.parseInt(complex);
            return true;
        } 
        return false;
    }
    
    public void atribuicao(int posicaoSinal, String[] complexArray){
        String tempString = "";
        this.sinal = complexArray[posicaoSinal];
        for(int i = 0; i < posicaoSinal; i++){
            tempString += complexArray[i];
        }
        this.numero = Integer.parseInt(tempString);
        tempString = "";
        for(int i = posicaoSinal+1; i < complexArray.length; i++){;
            if(!complexArray[i].equals("i")){
                tempString += complexArray[i];
            }
        }
        this.complexo = Integer.parseInt(tempString);
        tempString = "";
    }

    public void atribuicao(String[] complexArray){
        String tempString = "";
        for(int i = 0; i < complexArray.length; i++){;
            if(!complexArray[i].equals("i")){
                tempString += complexArray[i];
            }
        }
        this.complexo = Integer.parseInt(tempString);
        tempString = "";
    }

    public int compareTo(Complex complex) {
        if(this.numero > complex.numero) return 1;
        if(this.numero < complex.numero) return -1;
        if(this.sinal == "+" && complex.sinal == "-") return 1;
        if(this.sinal == "-" && complex.sinal == "+") return -1;
        if(this.complexo > complex.complexo) return 1;
        if(this.complexo < complex.complexo) return -1;
        return 0;
    }

    @Override
    public  boolean equals(Object complex){

        if(this.numero == ((Complex)complex).getNumero() && this.sinal.equals(getSinal()) && this.complexo == ((Complex)complex).getComplexo()) return true;
        return false;
    }
}
