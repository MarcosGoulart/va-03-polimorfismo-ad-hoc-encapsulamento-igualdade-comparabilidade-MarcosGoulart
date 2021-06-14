# Avaliação 03 Polimorfismo ad-hoc, Encapsulamento, Igualdade e Comparabilidade

Link do Classroom <https://classroom.github.com/a/uT1EWrxu>



## Implementar e testar segundo as especificações

- Esta atividade é avaliada com esforço estimado entre 4 e 8h.
- Copie os casos de teste para o método `main` em [App.java](src/App.java), conforme o exemplo que já está no arquivo. Comente com `//` ou `/*` e `*/` as linhas que ainda não foram implementadas.
- Os Casos de Teste podem ser corrigidos se estiverem mal escritos, mas **a especificação dos objetos não pode ser alterada**.
- Não esqueça de ajustar a visibilidade das classes [Fracao](src/modelo/Fracao.java) e [Veiculo](src/modelo/Veiculo.java), **elas não devem ser removidas da pasta `modelo`**.
- E, por fim, assegure-se de **assistir as videoaulas antes de começar**, pois lá estão explicados todos os conceitos e práticas.



### Tornar `Fracao` polimórfica

Sobrecarregar o construtor de [Fracao](src/modelo/Fracao.java) para aceitar um `int` representando o valor inteiro, `double` (com até seis casas decimais) e `String` no formato _numero/numero_ como `"3/7"` com até 9 casas no numerador e denominador, por exemplo `"123456789/123456789"`.

Sobrecarregue o método `somar` na classe [Fracao](src/modelo/Fracao.java) para aceitar parâmetros `int`, `double` e `String`, nas mesmas regras acima.

**Casos de Teste:**

```java
Fracao f1 = new Fracao(5, 10);
System.out.println(f1); // 1/2
System.out.println(f1.toString().equals("1/2"));
System.out.println(f1.getNumerador() == 1);
System.out.println(f1.getDenomiador() == 2);
System.out.println(f1.getString().equals("1/2"));

Fracao f2 = new Fracao(3); // 3 inteiros
System.out.println(f2.getString().equals("3/1"));

Fracao f3 = new Fracao("30/40");
System.out.println(f3.getNumerador() == 3);
System.out.println(f3.getDenomiador() == 4);
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
System.out.println(f3.getDenomiador() == 8);
System.out.println(f3.getString().equals("13/8"));

f3.somar(6.45);
System.out.println(f3.getNumerador() == 323);
System.out.println(f3.getDenomiador() == 40);
System.out.println(f3.getString().equals("323/40"));
```



### Avaliar a equivalência de `Fracao` com `equals`

Dadas instâncias de `Fracao` devem retornar verdadeiro se possuem o mesmo valor.

**Casos de Teste:**

```java
// Fracao f6 = new Fracao(4, 5); // PATCHED:
Fracao f6 = new Fracao(1, 5); // para coincidir com f9.
Fracao f7 = new Fracao(1, 3);
Fracao f8 = new Fracao(125, 375);
Fracao f9 = new Fracao(15, 75);

System.out.println(f6.equals(f8) == false);
System.out.println(f6.equals(f9) == true);
System.out.println(f7.equals(f8) == true);

System.out.println(new Fracao("3/19").equals(new Fracao(3, 19)) == true);
```



### Tornar `Fracao` comparável

Tornar `Fracao` comparável através da implementação da interface `Comparable`.

**Casos de Teste:**

```java
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
Comparable f16 = new Fracao(20, 120)

System.out.println(f15.compareTo(f16) == 0);
System.out.println(f16.compareTo(f14) < 0);

Fracao[] fracoes = {f10, f11, f12, f13, f14};

// Classifique em ordem crescente através de java.util.Arrays

System.out.println(fracoes[0].equals(f10));
System.out.println(fracoes[1].equals(f11));
System.out.println(fracoes[2].equals(f14));
System.out.println(fracoes[3].equals(f12));
System.out.println(fracoes[4].equals(f13));
```



### Implemente `Complex`

Implemente `Complex` (ex.: _3+5i_) de forma que possa ser instanciada de pelo menos duas maneiras (sobrecarga de construtor), com validação e totalmente encapsulada (atributos invisíveis) com acesso intermediado por acessores (getters), permitindo a verificação da equivalência (equals) e comparabilidade (compareTo).

**Importante**: a classe `Complex` deve ser colocada no diretório [modelo](/src/modelo/) e ser declarada como `package modelo;` (ver `Fracao` e `Veiculo`).

**Escreva os Casos de Teste**, conforme aprendeu nas atividades anteriores, que devem cobrir o comportamento normal e os casos especiais.

Pesquisar sobre _Números Complexos_ na _web_.



### Implementar `equals` em Veiculo

A classe [Veiculo](src/modelo/Veiculo.java) precisa de um método _equals_. Decida qual será o critério de equivalência e escreva testes para apresentar o comportamento esperado.



* * *

> _``Any non-trivial program contains at least one bug.''_
>
> <https://www.defprogramming.com/q/642230bcdaba/>
