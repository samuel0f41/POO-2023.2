package sam.mercado;

public class Funcionario {
    private String nomeFuncionario;
    private String cargo;
    private String salario;

    public Funcionario(String nomeFuncionario, String cargo, String salario) {
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario: "+ nomeFuncionario + ", Cargo: " + cargo + " salario: R$ " + salario;
    }
}
