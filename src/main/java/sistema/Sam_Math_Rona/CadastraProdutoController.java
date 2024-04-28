package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CadastraProdutoController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;

    public CadastraProdutoController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    public void actionPerformed(ActionEvent e){
        String tipo = JOptionPane.showInputDialog("Qual Tipo do Produto: ");
        String sabor = JOptionPane.showInputDialog("Qual Sabor do Produto: ");
        int qtEstoque = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade disponivel: "));
        double preco = Double.parseDouble(JOptionPane.showInputDialog("valor do produto: "));
        try {
            sistema.cadastrarProduto(new Produto(tipo,sabor,qtEstoque,preco));
            try {
                JOptionPane.showMessageDialog(janelaPrincipal, "Produto cadastrado!" + sistema.procurarProduto(tipo,sabor));
            } catch (ProdutoNaoExisteException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ProdutoJaExisteException ex) {
            throw new RuntimeException(ex);
        }

    }
}
