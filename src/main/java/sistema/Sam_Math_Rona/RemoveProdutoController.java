package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RemoveProdutoController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;

    public RemoveProdutoController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){

        String sabor = JOptionPane.showInputDialog("Qual sabor?\n" +
                "\nBrigadeiro [1] / Ninho [2] / Dois Amores [3] / Ninho com nutella[4] / Doce de Leite[5]");

        try {
            Produto brownie = sistema.procurarProduto(sabor);
            sistema.removerProduto(Tipo.BROWNIE, brownie.getSabor());
            JOptionPane.showMessageDialog(janelaPrincipal, "Produto removido!");

        } catch (ProdutoNaoExisteException ex) {
            throw new RuntimeException(ex);
        }

    }

}
