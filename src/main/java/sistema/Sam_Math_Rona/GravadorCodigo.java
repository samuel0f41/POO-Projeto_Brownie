package sistema.Sam_Math_Rona;

import java.io.*;
import java.util.Properties;

public class GravadorCodigo {

    private static final String arquivo_Configuracao = "config.properties";
    private static final String ultimoCodigoPedido = "ultimo_codigo_pedido";

    public static int carregarUltimoCodigoPedido() {
        Properties props = new Properties();
        try (InputStream is = new FileInputStream(arquivo_Configuracao)){
            props.load(is);
            return Integer.parseInt(props.getProperty(ultimoCodigoPedido, "0"));
        } catch (IOException e) {
            return 0; // Valor padrão se não conseguir carregar
        }
    }
    public static void salvarUltimoCodigoPedido(int ultimoCodigo) {
        Properties props = new Properties();
        props.setProperty(ultimoCodigoPedido, String.valueOf(ultimoCodigo));
        try (OutputStream os = new FileOutputStream(arquivo_Configuracao)) {
            props.store(os, "Configurações do aplicativo");
        } catch (IOException e) {
            // Tratar erro ao salvar arquivo de configuração
        }
    }
}
