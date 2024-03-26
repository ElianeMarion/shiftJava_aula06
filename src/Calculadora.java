import java.util.Scanner;

public class Calculadora {

    //Variável global
    public static double resultado;

    //Procedimento => void
    //Sintaxe procedimento sem argumentos => public static void nomeProcedimento(){}
    //Sintaxe procedimento com argumentos => public static void nomeProcedimento(tipo nomeVariavel){}
    public static void exibirMenu(){
        System.out.println("PROGRAMA CALCULADORA");
        System.out.println("----------------------------");
        System.out.println("Escolha sua opção: ");
        System.out.println("1 - Digitar valores");
        System.out.println("2 - Realizar soma");
        System.out.println("3 - Realizar subtração");
        System.out.println("4 - Realizar divisão");
        System.out.println("5 - Realizar multiplicação");
        System.out.println("6 - Sair");
        System.out.println(".: ");
    }
    //Função => tem retorno
    //Sintaxe função sem argumentos => public static tipo nomeFuncao(){}
    //Sintaxe função com argumentos => public static tipo nomeFuncao(tipo nomeVariavel){}
    //Tipo: int, double, String, vetor, Lista
    //SEMPRE TEM RETORNO => return x;
    public static String exibirResultado(){
        return "O resultado é " + resultado;
    }

    public static void exibirResultado(double resultado){
        System.out.println("O resultado é " + resultado);
    }

    public static void exibirResultado(double resultado, String operacao){
        System.out.println(operacao + " é = " + resultado);
    }

    //procedimento
    public static void somar(double primeiroValor, double segundoValor){
        double soma;
        System.out.println("\n\nRealizando a soma entre " + primeiroValor + " e " + segundoValor);
        soma  = primeiroValor + segundoValor;
        exibirResultado(soma, "Soma");
    }
    //função
    public static double subtrair(double v1, double v2){
        return v1 - v2;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner leitor = new Scanner(System.in);
        double valor1 = 0, valor2=0;
       // double resultado;   variavel local
        double subtracao = 0, divisao=0, multiplicacao=0;
        int opcao = 0;

        while (opcao!=6) {
            exibirMenu();
            opcao = leitor.nextInt();

            switch(opcao) {
                case 1:
                    System.out.println("\n\nDigite o 1. valor:");
                    valor1 = leitor.nextDouble();
                    System.out.println("\n\nDigite o 2. valor:");
                    valor2 = leitor.nextDouble();
                    System.out.println("Os valores " + valor1 + " e " + valor2 + " foram armazenados\n\n");
                    break;
                case 2:
                    somar(valor1, valor2);
                    break;
                case 3:
                    subtracao = subtrair(valor1, valor2);
                    System.out.println("\n\nRealizando a subtração entre " + valor1 + " e " + valor2);
                    exibirResultado(subtracao);
                    exibirResultado(subtrair(valor1, valor2));
                    break;
                case 4:
                    divisao = valor1 / valor2;
                    System.out.println("\n\nRealizando a divisão entre " + valor1 + " e " + valor2);
                    exibirResultado(divisao);

                    break;
                case 5:
                    multiplicacao = valor1 * valor2;
                    System.out.println("\n\nRealizando a multiplicação entre " + valor1 + " e " + valor2);
                    exibirResultado(multiplicacao);

                    break;
                case 6:
                    System.out.println("Saindo do sistema");
                    break;
            }
        }


        leitor.close();


    }
}
