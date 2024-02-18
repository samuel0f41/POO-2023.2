package br.samuel.mercado;

public interface SistemaMercadoInteface {
    void cadastrarProduto(String nome, String categoria, double preco) throws ProdutoNaoExisteException;

    String pesquisaProduto(String nome, String categoria);
    void atualizarPrecoProduto(String nome, String categoria, double preco);
    void cadastrarFuncionario (String nome, String cargo, String salario);
    void subirCargoFuncionario(String nome, String cargo, String novoCargo, String salario);
    void removerFuncionario(String nome, String cargo);
    String criarNotaFiscal(String nome, String cpf, String data, String responsavel, String codigo, String precototal);
    String emitirNotaFiscal(String cpf, String codigo);
}
