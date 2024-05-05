package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerQuantidadeVendasDoAno implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    ImageIcon calendar = new ImageIcon("./imgs/icons/calendario.png");
    ImageIcon reciboQuant = new ImageIcon("./imgs/icons/recibo.png");
    private Object[] JTextField;

    public VerQuantidadeVendasDoAno(SistemaBrownie sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        int anoPesquisar = Integer.parseInt((String) JOptionPane.showInputDialog(janelaPrincipal, "Digite o ano: ","Quantidade de Vendas no Ano",JOptionPane.QUESTION_MESSAGE,calendar,JTextField,null));
        int  quantidadeDeVendasNoAno =  sistema.quantidadeDeVendasAnual(anoPesquisar);

        JOptionPane.showMessageDialog(janelaPrincipal, "Quantidade total de vendas: "+ quantidadeDeVendasNoAno+ " No ano de "+anoPesquisar,"Quantidade de Vendas no Ano",JOptionPane.INFORMATION_MESSAGE,reciboQuant);
    }
}
