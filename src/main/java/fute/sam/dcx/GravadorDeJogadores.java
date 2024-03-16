package fute.sam.dcx;

import java.io.*;
import java.util.Map;

public class GravadorDeJogadores {
    public Map<String, Jogador> leJogadores() throws IOException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("dadosJogadores.dat"));
            return (Map<String, Jogador>) in.readObject();
        }catch (FileNotFoundException e){
            throw new IOException("Não foi encontrado o arquivo dados.dat", e);
        }catch (IOException e){
            throw e;
        }catch (ClassNotFoundException e){
            throw new IOException("Class dos objetos gravados no arquivo" + " dados.dat não existe", e);
        }finally {
            if (in != null){
                in.close();
            }
        }
    }

    public void gravaJogadores(Map<String, Jogador> listasDeJogadoresEtimes) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("dadosJogadores.dat"));
            out.writeObject(listasDeJogadoresEtimes);
        }catch (FileNotFoundException e){
            throw new IOException("Não foi encontrado o arquivo dados.dat", e);
        }catch (IOException e){
            throw e;
        }finally {
            if (out != null){
                out.close();
            }
        }
    }
}
