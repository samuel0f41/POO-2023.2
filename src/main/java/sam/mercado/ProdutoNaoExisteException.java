package sam.mercado;

public class ProdutoNaoExisteException extends Exception {
    public ProdutoNaoExisteException(String msg){
        super(msg);
    }
}
