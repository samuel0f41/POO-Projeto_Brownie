package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FinalizaPedidoController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    ImageIcon bagCheck = new ImageIcon("./imgs/icons/sacola.png");
    private Object[] JTextField;

    public FinalizaPedidoController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        int codigoPedido = Integer.parseInt((String) JOptionPane.showInputDialog(janelaPrincipal, "Codigo pedido: ","Finalizar Pedido",JOptionPane.QUESTION_MESSAGE,bagCheck,JTextField,null));
        try {
            sistema.finalizarPedido(codigoPedido);
            JOptionPane.showMessageDialog(janelaPrincipal, "Pedido: "+  codigoPedido + " finalizado!");
        } catch (PedidoNaoExisteException ex) {
            throw new RuntimeException(ex);
        }

    }

}
