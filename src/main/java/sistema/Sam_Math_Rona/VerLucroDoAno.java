package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerLucroDoAno implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    public VerLucroDoAno(SistemaBrownie sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        int anoPesquisar = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Digite o ano: "));
        double  valorTotal =  sistema.calculaLucroAnual(anoPesquisar);
        JOptionPane.showMessageDialog(janelaPrincipal, "Lucro de vendas: " + valorTotal + " Do ano "+ anoPesquisar);
    }

}
