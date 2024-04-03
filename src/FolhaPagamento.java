import java.util.Scanner;

public class FolhaPagamento {

    //calcularSalario => double
    public static double calcularSalario(double valorHora, double qtdHoras){
        return  valorHora * qtdHoras;
    }
    //calcularHoraExtra => double

    public static void main(String[] args) {
        /*o salário dos funcionários é calculado de acordo com a carga horária trabalhada no mês,
         * por isso você deverá perguntar qual a quantidade de horas trabalhadas e multiplicar pelo valor da hora.
         * */
        Scanner leitorNumeros = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);
        int quantidade;
        System.out.println("PetShop FIAP\n\nDigite a quantidade de horas trabalhadas: ");
        quantidade = leitorNumeros.nextInt();
        double valorHora = 18;
        double salario = calcularSalario(valorHora, quantidade);
        //System.out.println("Salario Bruto: " + salario);
		/*
		 * O funcionário pode realizar horas extras no mês, para calcular o valor da hora extra você deverá solicitar
		 * a quantidade de horas extras no mês e acrescentar 50% sobre o valor hora, por exemplo:
		 * Imagine que um funcionário tenha realizado 10 horas extras no mês, sabendo que o salário por hora é de
			R$ 10,00 o funcionário receberá:
			double adicional =  valorHora * 0.5  /// (50%) = R$ 5,00
			valorHE =  valorHora + adicional  //= R$ 15,00
			valorHorasExtras = quantidadeHorasExtras  * valorHE //

			Duas variaveis: valorHE = valorHora * 0.5 + valorHora
			valorHorasExtras = quantidadeHorasExtras  * valorHE // = R$ 150,00
		 */
        double quantidadeHorasExtras, valorHorasExtras;
        System.out.println("Digite a quantidade de horas extras realizadas exceto domingos e feriados: ");
        quantidadeHorasExtras = leitorNumeros.nextDouble();
        //int x = Integer.parseInt("10");
        // (valorHora + 50% de 18) x QuantidadeHorasExtras
        valorHorasExtras = calcularHorasExtras(valorHora, quantidadeHorasExtras);
        //valorHorasExtras = calcularHorasExtras(valorHora);
        //valorHorasExtras = ((valorHora * 0.5) + valorHora) * quantidadeHorasExtras;

        double valorHoraExtraDomingo = 0;

        valorHoraExtraDomingo = calcularHorasExtrasDomingo(valorHora);

        double salarioFinal = salario + valorHorasExtras + valorHoraExtraDomingo;


        double descontoINSS = calcularDescontoINSS(salarioFinal);

        salarioFinal -= descontoINSS; // salarioFinal = salarioFinal - descontoINSS;

        System.out.println("Salario Bruto: " + salario + "\nHoras Extra: " + valorHorasExtras +
                "\nHoras Extra 100%: " + valorHoraExtraDomingo +
                "\nDesconto INSS: " + descontoINSS +
                "\nSalario Final: " + salarioFinal);
    }

    private static double calcularDescontoINSS(double salarioFinal) {
        double descontoINSS = 0;
        if (salarioFinal <= 1302) {
            //7,5%
            descontoINSS = salarioFinal * 0.075;
        }
        else if(salarioFinal > 1302 && salarioFinal <= 2571.29) {
            //9%
            descontoINSS = salarioFinal * 0.09;
        }
        else if (salarioFinal <= 3856.94) {
            //12%
            descontoINSS = salarioFinal * 0.12;
        }
        else if (salarioFinal <= 7507.79) {
            //14%
            descontoINSS = salarioFinal * 0.14;
        }
        else {
            //877,24
            descontoINSS = 877.24;
        }
        return descontoINSS;
    }

    private static double calcularHorasExtrasDomingo(double valorHora) {
        Scanner leitorTexto = new Scanner(System.in);
        Scanner leitorNumeros = new Scanner(System.in);
        System.out.println("Realizou horas extras de domingo ou feriado? ");
        String resposta = leitorTexto.nextLine();

        if(resposta.equalsIgnoreCase("Sim") || resposta.equals("s")) {
            System.out.println("Digite a quantidade de horas extras realizadas em domingos e feriados: ");
            double quantidadeHorasExtras = leitorNumeros.nextDouble();
            return valorHora * 2 * quantidadeHorasExtras;
        }
        return 0;
    }

    private static double calcularHorasExtras(double valorHora, double quantidadeHorasExtras) {
        return ((valorHora * 0.5) + valorHora) * quantidadeHorasExtras;
    }

    public static double calcularHorasExtras(double valorHora){
        Scanner leitorNumeros = new Scanner(System.in);
        System.out.println("Digite a quantidade de horas extras realizadas exceto domingos e feriados: ");
        double quantidadeHorasExtras = leitorNumeros.nextDouble();
        return ((valorHora * 0.5) + valorHora) * quantidadeHorasExtras;
    }


}
