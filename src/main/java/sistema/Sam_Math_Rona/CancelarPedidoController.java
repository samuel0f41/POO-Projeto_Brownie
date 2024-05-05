package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CancelarPedidoController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    ImageIcon cOder = new ImageIcon("./imgs/icons/cPedido.png");
    ImageIcon check = new ImageIcon("./imgs/icons/feito.png");
    private Object[] JTextField;

    public CancelarPedidoController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        int codigoPedido = Integer.parseInt((String) JOptionPane.showInputDialog(janelaPrincipal, "Codigo pedido: ","Cancelar Pedido",JOptionPane.QUESTION_MESSAGE,cOder,JTextField,null));
        try {
            sistema.cancelarPedido(codigoPedido);
            JOptionPane.showMessageDialog(janelaPrincipal, "Pedido: "+  codigoPedido + " cancelado!","Cancelar Pedido",JOptionPane.INFORMATION_MESSAGE,check);
        } catch (PedidoNaoExisteException ex) {
            throw new RuntimeException(ex);
        }

    }

}
