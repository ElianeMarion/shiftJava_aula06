import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carrinho {

    public static void exibirMenu() {

        System.out.println("Lojinha");
        System.out.println("1 - Adicionar valor do produto no carrinho");
        System.out.println("2 - Exibir o total do carrinho");
        System.out.println("3 - Sair");
        System.out.println("Digite a opção desejada.: ");

    }

    public static double somarCarrinho(List<Double> produtos) {
        double soma = 0;
        for(int i = 0; i < produtos.size(); i++)
            soma += produtos.get(i); //soma = soma + produtos[i]
        return soma;
    }
    public static List<Double> adicionarItens(List<Double> lista, double item){
        lista.add(item);
        return lista;
    }
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<Double> valoresItens = new ArrayList<>();
        int op;
        do {
            exibirMenu();
            op = leitor.nextInt();
            switch (op) {
                case 1:
                    //adicionar itens no vetor
                    System.out.println("Digite o valor do item: ");
                    double valor = leitor.nextDouble();
                    valoresItens = adicionarItens(valoresItens, valor);
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
