package fute.sam.dcx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Time implements Serializable {
    private String nome;
    private String PJ;

    public Time(String nome, String pj){
        this.nome = nome;
        this.PJ = pj;
    }
    public String getPJ() {
        return PJ;
    }

    public void setPJ(String PJ) {
        this.PJ = PJ;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome + "\n" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        return Objects.equals(PJ, time.PJ);
    }

    @Override
    public int hashCode() {
        return PJ != null ? PJ.hashCode() : 0;
    }
}
