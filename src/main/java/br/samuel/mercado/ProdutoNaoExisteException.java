package br.samuel.mercado;

public class ProdutoNaoExisteException extends Exception {
    public ProdutoNaoExisteException(String msg){
        super(msg);
    }
}
