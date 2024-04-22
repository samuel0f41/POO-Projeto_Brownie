package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ListarProdutosController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;

    public ListarProdutosController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){

        JOptionPane.showInputDialog(janelaPrincipal, sistema.listaDeProdutos());

    }

}
