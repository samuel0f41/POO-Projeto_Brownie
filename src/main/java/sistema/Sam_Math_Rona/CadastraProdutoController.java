package sistema.Sam_Math_Rona;

import javax.swing.*;
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

        Tipo tipo = Tipo.BROWNIE;
        Sabores saborProduto;

        String sabor = JOptionPane.showInputDialog("Digite sabor: [1 / 2 / 3 / 4 / 5]\n"+
                "\nSabores possiveis: \nBrigadeiro [1] ou Ninho [2] \nDois Amores [3] " +
                "ou Ninho com nutella[4] \nDoce de Leite[5]");

        if(sabor.equals("1")) saborProduto = Sabores.BRIGADEIRO;
        else if(sabor.equals("2")) saborProduto = Sabores.NINHO;
        else if(sabor.equals("3")) saborProduto = Sabores.DOIS_AMORES;
        else if(sabor.equals("4")) saborProduto = Sabores.NINHO_C_NUTELLA;
        else if(sabor.equals("5")) saborProduto = Sabores.DOCE_DE_LEITE;
        else saborProduto = Sabores.UNICO;

        int qtEstoque = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade disponivel: "));
        double preco = Double.parseDouble(JOptionPane.showInputDialog("valor do produto: "));

        Produto brownie = new Produto(tipo, saborProduto, qtEstoque, preco);
        try {
            sistema.cadastrarProduto(brownie, qtEstoque);
        } catch (ProdutoJaExisteException ex) {
            throw new RuntimeException(ex);
        }

    }
}
