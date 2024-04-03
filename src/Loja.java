import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Loja {
    public static String email = "";
    public static String senha = "";
    public static String apelido = "";
    public static List<String> listaProdutos = new ArrayList<>();

    public static void registrarProduto(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o nome do produto que deseja registar: ");
        String nomeProduto = leitor.nextLine();
        listaProdutos.add(nomeProduto);
        System.out.println("O produto " + nomeProduto + " foi registrado com sucesso!");
    }

    public static String mostrarProdutos(){
        String mensagem = "Produtos: \n";

        for (String produto : listaProdutos){
            mensagem += produto + "\n";
        }
        return mensagem;
    }

    public static void registrarUsuario(){
        String nome, telefone;
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        nome = leitor.nextLine();
        System.out.println("Digite seu telefone: ");
        telefone = leitor.nextLine();
        System.out.println("Digite seu email: ");
        email = leitor.nextLine();
        System.out.println("Digite sua senha: ");
        senha = leitor.nextLine();
        System.out.println("Digite seu apelido: ");
        apelido = leitor.nextLine();
    }

    public static boolean validarLogin(String emailLogin, String senhaLogin){
        if(emailLogin.equalsIgnoreCase(email) && senhaLogin.equals(senha))
            return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner leitorNumero = new Scanner(System.in);
        Scanner leitor = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("FIAP System");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Efetuar login");
            System.out.println("3 - Sair");
            System.out.println("Digite a opção desejada: ");
            opcao = leitorNumero.nextInt();
            if(opcao == 1)
                registrarUsuario();
            else if(opcao == 2){
                System.out.println("Login");
                System.out.println("Digite seu email: ");
                String emailDigitado = leitor.nextLine();
                System.out.println("Digite sua senha: ");
                String senhaDigitada = leitor.nextLine();
                if(validarLogin(emailDigitado,senhaDigitada)){
                    System.out.println("Bem vindo ao Sistema Fiap " + apelido);
                    int opcaoSubMenu = 0;
                    do {
                        subMenu();
                        System.out.println("Digite a opção desejada: ");
                        opcaoSubMenu = leitorNumero.nextInt();
                        switch (opcaoSubMenu) {
                            case 1:
                                //System.out.println("registrar produto");
                                registrarProduto();
                                break;
                            case 2:
                                System.out.println(mostrarProdutos());
                                break;
                            case 3:
                                System.out.println("avaliar produto");
                                break;
                            case 0:
                                System.out.println("Voltando para o menu principal.....");
                                break;
                        }
                    }while (opcaoSubMenu != 0);
                }else
                    System.out.println("Usuário e/ou senha inválidos");
            } //opcao 2
            else
                System.out.println("Obrigada por utilizar nosso sistema!");
        }while(opcao != 3);
    }

    private static void subMenu() {
        System.out.println("Usuário logado com sucesso!! Bem vindo(a)!");
        System.out.println("Digite 1 para registrar um produto");
        System.out.println("Digite 2 para mostrar produtos");
        System.out.println("Digite 3 para avaliar um produto");
        System.out.println("Digite 0 para voltar para o menu principal");
    }
}
