package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CancelarPedidoController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;

    public CancelarPedidoController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        int codigoPedido = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Codigo pedido: "));
        try {
            sistema.cancelarPedido(codigoPedido);
            JOptionPane.showMessageDialog(janelaPrincipal, "Pedido: "+  codigoPedido + " cancelado!");
        } catch (PedidoNaoExisteException ex) {
            throw new RuntimeException(ex);
        }

    }

}
