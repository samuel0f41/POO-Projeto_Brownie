package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerLucroDoAno implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    ImageIcon vendasTotal = new ImageIcon("./imgs/icons/venda.png");
    ImageIcon calendar = new ImageIcon("./imgs/icons/calendario.png");
    private Object[] JTextField;

    public VerLucroDoAno(SistemaBrownie sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        int anoPesquisar = Integer.parseInt((String) JOptionPane.showInputDialog(janelaPrincipal, "Digite o ano: ","Ver Lucro do Ano",JOptionPane.QUESTION_MESSAGE,calendar,JTextField,null));
        double  valorTotal =  sistema.calculaLucroAnual(anoPesquisar);
        JOptionPane.showMessageDialog(janelaPrincipal, "Lucro de vendas: " + valorTotal + " do ano "+ anoPesquisar,"Ver Lucro do Ano",JOptionPane.INFORMATION_MESSAGE,vendasTotal);
    }

}
