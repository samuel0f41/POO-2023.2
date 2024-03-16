package sam.mercado;

import java.util.Objects;

public class NotaFiscal {
    private String nomeCliente;
    private String cpf;
    private String data;
    private String responsavel;
    private String codigo;
    private String precoTotal;

    public NotaFiscal(String nomeCliente, String cpf, String data,
                      String responsavel, String codigo, String precoTotal){
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.data =data;
        this.responsavel = responsavel;
        this.codigo = codigo;
        this.precoTotal = precoTotal;

    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(String precoTotal) {
        this.precoTotal = precoTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaFiscal that = (NotaFiscal) o;

        if (!Objects.equals(cpf, that.cpf)) return false;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        int result = cpf != null ? cpf.hashCode() : 0;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NotaFiscal: " +
                "nomeCliente: " + nomeCliente + '\'' +
                "cpf: " + cpf + '\'' +
                "data " + data + '\'' +
                "responsavel " + responsavel + '\'' +
                "codigo " + codigo + '\'' +
                "precoTotal " + precoTotal;
    }


}
