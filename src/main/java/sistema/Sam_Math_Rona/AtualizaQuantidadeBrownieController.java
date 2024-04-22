package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AtualizaQuantidadeBrownieController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;

    public AtualizaQuantidadeBrownieController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    public void actionPerformed(ActionEvent e){

        String sabor = JOptionPane.showInputDialog("Digite sabor: [1 / 2 / 3 / 4 / 5]\n" +
                "\nBrigadeiro [1] / Ninho [2] / Dois Amores [3] / Ninho com nutella[4] / Doce de Leite[5]");

        try {
            Produto produto = sistema.procurarProduto(sabor);
            int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite quantidade para acrescentar no estoque: "));

            sistema.abasteceEstoqueProduto(produto.getTipo(),produto.getSabor(), novaQuantidade);
        } catch (ProdutoNaoExisteException ex) {
            throw new RuntimeException(ex);
        }

    }

}
