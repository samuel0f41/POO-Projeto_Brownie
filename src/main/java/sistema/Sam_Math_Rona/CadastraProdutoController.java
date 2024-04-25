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
        String sabor = JOptionPane.showInputDialog("Qual sabor do Brownie: \n"+
                "\nBrigadeiro [1] ou Ninho [2] \nDois Amores [3] " +
                "ou Ninho com nutella[4] \nDoce de Leite[5]");

        Produto brownie = new Produto();
        brownie.setTipo(Tipo.BROWNIE);
        if(sabor.equals("1")) brownie.setSabor(Sabores.BRIGADEIRO);
        else if(sabor.equals("2"))brownie.setSabor(Sabores.NINHO);
        else if(sabor.equals("3")) brownie.setSabor(Sabores.DOIS_AMORES);
        else if(sabor.equals("4"))brownie.setSabor(Sabores.NINHO_C_NUTELLA);
        else if(sabor.equals("5")) brownie.setSabor(Sabores.DOCE_DE_LEITE);
        else brownie.setSabor(Sabores.TEST);

        int qtEstoque = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade disponivel: "));
        double preco = Double.parseDouble(JOptionPane.showInputDialog("valor do produto: "));

        brownie.setQtEstoque(qtEstoque);
        brownie.setPreco(preco);
        try {
            sistema.cadastrarProduto(brownie);
            JOptionPane.showMessageDialog(janelaPrincipal, "Produto cadastrado!");
        } catch (ProdutoJaExisteException ex) {
            throw new RuntimeException(ex);
        }

    }
}
