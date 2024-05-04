package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerQuantidadeVendasDoAno implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    public VerQuantidadeVendasDoAno(SistemaBrownie sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        int anoPesquisar = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Digite o ano: "));
        int  quantidadeDeVendasNoAno =  sistema.quantidadeDeVendasAnual(anoPesquisar);

        JOptionPane.showMessageDialog(janelaPrincipal, "Quantidade total de vendas: "+ quantidadeDeVendasNoAno+ " No ano de "+anoPesquisar);
    }
}
