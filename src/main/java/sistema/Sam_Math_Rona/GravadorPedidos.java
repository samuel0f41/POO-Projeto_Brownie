package sistema.Sam_Math_Rona;

import java.io.*;
import java.util.Map;

public class GravadorPedidos {
    public Map<Integer, Pedido> lePedidos() throws IOException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("dadosPedidos.dat"));
            return (Map<Integer, Pedido>) in.readObject();
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
    public void gravaPedidos (Map<Integer,Pedido> listadePedidos) throws IOException{
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream("dadosPedidos.dat"));
            out.writeObject(listadePedidos);
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
