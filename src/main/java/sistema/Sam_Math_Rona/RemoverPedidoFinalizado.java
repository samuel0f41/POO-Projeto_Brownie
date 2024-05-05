package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverPedidoFinalizado implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    ImageIcon iLixeira = new ImageIcon("./imgs/icons/lixeira.png");
    ImageIcon check = new ImageIcon("./imgs/icons/feito.png");
    private Object[] JTextField;

    public RemoverPedidoFinalizado(SistemaBrownie sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        int codigoPedido = Integer.parseInt((String) JOptionPane.showInputDialog(janelaPrincipal, "Codigo pedido: ","Remover Pedido Finalizado",3,iLixeira,JTextField,null));
        try {
            sistema.removerPedidoFinalizado(codigoPedido);
            JOptionPane.showMessageDialog(janelaPrincipal, "Pedido: "+  codigoPedido + " Removido!","Remover Pedido Finalizado",1,check);
        } catch (PedidoNaoExisteException ex) {
            throw new RuntimeException(ex);
        }
    }
}
