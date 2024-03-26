import java.util.Scanner;

public class CarrinhoCompras {

    public static double somarCarrinho(double[] produtos) {
        double soma = 0;
        for(int i = 0; i < produtos.length; i++)
            soma += produtos[i]; //soma = soma + produtos[i]
        return soma;
    }

    public static double[] adicionarItens(double[] produtos){
        Scanner leitor = new Scanner(System.in);
        for (int i = 0; i < produtos.length; i++) {
            System.out.println("Digite o valor do item: ");
            produtos[i] = leitor.nextDouble();
        }
            return produtos;

    }


    public static void exibirMenu() {

        System.out.println("Lojinha");
        System.out.println("1 - Adicionar valor do produto no carrinho");
        System.out.println("2 - Exibir o total do carrinho");
        System.out.println("3 - Sair");
        System.out.println("Digite a opção desejada.: ");

    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        double[] valoresItens = new double[5];
        int op;
        do {
            exibirMenu();
            op = leitor.nextInt();
            switch (op) {
                case 1:
                    //adicionar itens no vetor
                    valoresItens = adicionarItens(valoresItens);
                    break;
                case 2:
                    System.out.println("Valor total: " + somarCarrinho(valoresItens));
                    break;
                case 3:
                    System.out.println("Sistema finalizado!");
            }
        }while (op != 3) ;

    }
}
