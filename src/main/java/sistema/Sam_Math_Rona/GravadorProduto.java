package sistema.Sam_Math_Rona;

import java.io.*;
import java.util.List;


public class GravadorProduto {
    public List<Produto> leProdutos() throws IOException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("dadosProdutos.dat"));
            return (List<Produto>) in.readObject();
        }catch (FileNotFoundException e) {
            throw new IOException("Não foi encontrado o arquivo dados.dat", e);
        }catch (IOException e){
            throw e;
        }catch (ClassNotFoundException e){
            throw new IOException("Class dos objetos gravados no arquivo"+" dados.dat não existe", e);
        }finally {
            if(in != null){
                in.close();
            }
        }
    }

    public void gravaProduto (List<Produto> listadeProduto) throws IOException{
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream("dadosProdutos.dat"));
            out.writeObject(listadeProduto);
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
