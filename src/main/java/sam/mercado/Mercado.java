package sam.mercado;

import java.util.Scanner;

public class Mercado{
    public static void main(String [] args) throws ProdutoNaoExisteException{
        SistemaMercado sistema = new SistemaMercado();
        Scanner sc = new Scanner(System.in);
        String opcao = "1";
        while(!opcao.equals("4")){
            System.out.println("Menu \n1- Funcionarios \n2- NotaFiscal \n3 Produto\n4- sair");
            opcao = sc.nextLine();
            if(opcao.equals("1")){
                System.out.println("1- cadastrar funcionario \n2- Subir Cargo \n3 Remover Funcionario \n4- voltar");
                opcao = sc.nextLine();
                if(opcao.equals("1")){
                    System.out.println("Digite nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Cargo: ");
                    String cargo = sc.nextLine();
                    System.out.println("Salario: ");
                    String salario = sc.nextLine();
                    sistema.cadastrarFuncionario(nome, cargo, salario);
                }else if(opcao.equals("2")){
                    System.out.println("Digite nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Cargo: ");
                    String cargo = sc.nextLine();
                    System.out.println(" Digite novo Cargo: ");
                    String novoCargo = sc.nextLine();
                    System.out.println("Salario do novo cargo: ");
                    String salario = sc.nextLine();
                    sistema.subirCargoFuncionario(nome, cargo, novoCargo, salario);
                }else if(opcao.equals("3")){
                    System.out.println("Digite nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Cargo: ");
                    String cargo = sc.nextLine();
                    sistema.removerFuncionario(nome, cargo);
                }//Fim da opcao 1 if

            }else if(opcao.equals("2")){
                System.out.println("1- criar nota\n2- emitir nota");
                opcao = sc.nextLine();
                if(opcao.equals("1")){
                    System.out.println("Digite Nome:");
                    String nome = sc.nextLine();
                    System.out.println("CPF:");
                    String cpf = sc.next();
                    System.out.println("Data criada:");
                    String data = sc.nextLine();
                    System.out.println("Funcinario responsavel:");
                    String responsavel = sc.nextLine();
                    System.out.println("Codigo da nota:");
                    String codigo = sc.nextLine();
                    System.out.println("precoTotal:");
                    String precototal = sc.nextLine();
                    sistema.criarNotaFiscal(nome, cpf,data, responsavel, codigo, precototal);
                }else if(opcao.equals("2")){
                    System.out.println("CPF:");
                    String cpf = sc.next();
                    System.out.println("Codigo da nota:");
                    String codigo = sc.nextLine();
                    sistema.emitirNotaFiscal(cpf, codigo);
                }//Fim da opcao 2 else if

            }else if(opcao.equals("3")){
                System.out.println("1- Cadastrar produto\n2- Pesquisar\n3- Atualizar preço");
                opcao = sc.next();

                if(opcao.equals("1")){
                    try {
                        System.out.println("Nome do produto: ");
                        String nome = sc.nextLine();

                        System.out.println("categoria: ");
                        String cate = sc.nextLine();

                        System.out.println("Preço: ");
                        double preco = Double.parseDouble(sc.nextLine());
                        sistema.cadastrarProduto(nome, cate, preco);
                    }catch (ProdutoNaoExisteException e){
                        System.out.println(" Não foi possivel cadastrar");
                    }

                }else if(opcao.equals("2")){
                    System.out.println("Nome do produto: ");
                    String nome = sc.next();
                    System.out.println("categoria: ");
                    String categoria = sc.nextLine();
                    sistema.pesquisaProduto(nome, categoria);

                }else if(opcao.equals("3")){
                    System.out.println("Nome do produto: ");
                    String nome = sc.next();
                    System.out.println("categoria: ");
                    String categoria = sc.nextLine();
                    System.out.println("Novo preco a atualizar: ");
                    double novopreco = Double.parseDouble(sc.nextLine());
                    sistema.atualizarPrecoProduto(nome,categoria, novopreco);
                }
            }

        }

    }

}
