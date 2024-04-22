package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CadastraPedidoController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;

    public CadastraPedidoController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    public void actionPerformed(ActionEvent e){

        String nome = JOptionPane.showInputDialog("Nome do clinte: ");
        String endereco = JOptionPane.showInputDialog("endereço: ");
        String numeroCasa = JOptionPane.showInputDialog("Numero da casa: ");
        Cliente c1 = new Cliente(nome, endereco, numeroCasa);

        List<Produto> carrinho = new ArrayList<>();
        String itemPedido = "s";

        while (itemPedido.equals("s")){
            Tipo tipo = Tipo.BROWNIE;
            String sabores = JOptionPane.showInputDialog("Digite sabor: [1 / 2 / 3 / 4 / 5]\n"+
            "\nSabores possiveis: \nBrigadeiro [1] ou Ninho [2] \nDois Amores [3] " +
                    "ou Ninho com nutella[4] \nDoce de Leite[5]");

            try {
                Produto brownie = sistema.procurarProduto(sabores);
                carrinho.add(brownie);

            } catch (ProdutoNaoExisteException ex) {
                throw new RuntimeException(ex);
            }

            itemPedido = JOptionPane.showInputDialog("Deseja adicionar mais? [s/n] ");
        }

        Pedido pedido = new Pedido(c1, carrinho);
        try {
            sistema.cadastrarPedido(pedido);
            JOptionPane.showMessageDialog(janelaPrincipal, "Pedido Realizado!");

        } catch (CodigoPedidoJaExiste ex) {
            throw new RuntimeException(ex);
        }

    }

}
