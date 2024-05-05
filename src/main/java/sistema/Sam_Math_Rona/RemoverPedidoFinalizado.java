package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverPedidoFinalizado implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    public RemoverPedidoFinalizado(SistemaBrownie sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        int codigoPedido = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Codigo pedido: "));
        try {
            sistema.removerPedidoFinalizado(codigoPedido);
            JOptionPane.showMessageDialog(janelaPrincipal, "Pedido: "+  codigoPedido + " Removido!");
        } catch (PedidoNaoExisteException ex) {
            throw new RuntimeException(ex);
        }
    }
}
