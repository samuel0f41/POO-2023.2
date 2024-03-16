package sam.mercado;

import java.util.Objects;

public class Produto {
    private String nome;
    private String categoria;
    private double preco;


    public Produto(String nome, String categoria, double preco ){
        this.nome = nome;
        this.categoria = categoria;
        this.preco =  preco;
    }// fim do construtor

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String toString(){
        return "Produto: "+ this.nome + " categoria: "+ this.categoria+ " Preço: R$ ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (!Objects.equals(nome, produto.nome)) return false;
        return Objects.equals(categoria, produto.categoria);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        return result;
    }
}//fim da Class