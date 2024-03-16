package sam.mercado;

import java.util.ArrayList;
import java.util.List;

public class SistemaMercado implements SistemaMercadoInteface {
    private List<NotaFiscal> notasFiscais;
    private List<Funcionario> funcionarios;
    private List<Produto> produtos;

    public SistemaMercado() {
        this.funcionarios = new ArrayList<>();
        this.notasFiscais = new ArrayList<>();
        this.produtos = new ArrayList<>();

    }

    public void cadastrarProduto(String nome, String categoria, double preco) throws ProdutoNaoExisteException{
        boolean cadastrou = false;
        for (Produto p : produtos) {
            if (!p.getNome().equalsIgnoreCase(nome) && !p.getCategoria().equalsIgnoreCase(categoria)) {
                Produto produto = new Produto(nome, categoria, preco);
                produtos.add(produto);
                cadastrou = true;
            }
        }
        if(!cadastrou){
            throw new ProdutoNaoExisteException("Produdo ja existe no sistema, tente cadastrar um novo!");
        }

    }

    public String pesquisaProduto(String nome, String categoria) {
        String produtoAchou = "";
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome) && p.getCategoria().equalsIgnoreCase(categoria)) {
                produtoAchou = p.toString();
            }
        }
        if(produtoAchou.equals("")){
            produtoAchou = "Sinto muito, nao foi possivel achar o produto, tente de novo!";
        }
        return produtoAchou;
    }

    public void atualizarPrecoProduto(String nome, String categoria, double preco) {
        boolean atualizou = false;
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome) && p.getCategoria().equalsIgnoreCase(categoria)) {
                p.setPreco(preco);
                atualizou = true;
                break;
            }
        }
        if(!atualizou){
            System.out.println("Produto não encontrado, tente novamente!");
        }

    }

    public void cadastrarFuncionario (String nome, String cargo, String salario){
        for(Funcionario f: funcionarios){
            if(!f.getNomeFuncionario().equals(nome)){
                Funcionario fun = new Funcionario(nome, cargo, salario);
                funcionarios.add(fun);
            }
        }
    }//Fim do metodo

    public void subirCargoFuncionario(String nome, String cargo, String novoCargo, String salario) {
        for (Funcionario f : funcionarios) {
            if (f.getNomeFuncionario().equals(nome) && f.getCargo().equals(cargo)) {
                f.setCargo(novoCargo);
                f.setSalario(salario);
            }
        }
    }//FIm do metodo

    public void removerFuncionario(String nome, String cargo){
        for (Funcionario f : funcionarios) {
            if (f.getNomeFuncionario().equals(nome) && f.getCargo().equals(cargo)) {
                funcionarios.remove(f);
                System.out.println("Funcionario despejado");
            }
        }
    }//Fim da class

    public String criarNotaFiscal(String nome, String cpf, String data, String responsavel, String codigo, String precototal){
        NotaFiscal nota = new NotaFiscal(nome, cpf, data, responsavel, codigo, precototal);
        notasFiscais.add(nota);
        return "Nota fiscal criada com sucesso, emita para o cliente receber sua via";
    }
    public String emitirNotaFiscal(String cpf, String codigo){
        for(NotaFiscal n: notasFiscais){
            if(n.getCpf().equals(cpf)){
                return n.toString();
            }
        }
        return "Nenhuma nota fiscal encontrada com esse cpf ou codigo, tente novamente!";
    }

    public List<Produto> todosProdutos(){
        return this.produtos;
    }
    public List<Funcionario> todosFuncionarios(){
        return this.funcionarios;
    }
    public List<NotaFiscal> todasNotasFiscais(){
        return this.notasFiscais;
    }


}//Fim da class
