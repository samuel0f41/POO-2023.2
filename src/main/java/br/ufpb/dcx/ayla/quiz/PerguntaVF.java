package br.ufpb.dcx.ayla.quiz;

public class PerguntaVF extends Pergunta {
    private String afirmativa;


    public PerguntaVF(String enunciado, String respostaCorreta, String afirmativa   ){
        super(enunciado, respostaCorreta);
        this.afirmativa = afirmativa;
    }
    public PerguntaVF(){
        super();
        this.afirmativa = "";
    }

    @Override
    public boolean estahCorretaResposta(String resposta) {
        boolean acertou = false;
        if(resposta.equalsIgnoreCase(getRespostaCorreta())){
            acertou = true;
        }
        return acertou;
    }

    public String getAfirmativa(){
        return afirmativa;
    }
    public void setAfirmativa(String novaAfirmativa){
        this.afirmativa = novaAfirmativa;
    }
    public String toString(){
        return "Resposta certa: " + getRespostaCorreta();
    }


}
