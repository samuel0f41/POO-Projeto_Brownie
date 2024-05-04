package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerQuantidadeDoProdutoNoEstoqueController implements ActionListener {

    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    public VerQuantidadeDoProdutoNoEstoqueController(SistemaBrownie sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        String sabor = JOptionPane.showInputDialog("Qual sabor do Brownie: \n"+
                "\nBrigadeiro [1] ou Ninho [2] \nDois Amores [3] " +
                "ou Ninho com nutella[4] \nDoce de Leite[5]");

        try {
            Produto p = sistema.procurarProduto("","");
            JOptionPane.showMessageDialog(null, "Quantidade no estoque: "+ p.getQtEstoque());

        } catch (ProdutoNaoExisteException ex) {
            throw new RuntimeException(ex);
        }
    }
}
