package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;

public class QuantidadeDeVendasMensalController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    public QuantidadeDeVendasMensalController(SistemaBrownie sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    public void actionPerformed(ActionEvent e){

        String[] opcoes = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
        int op = JOptionPane.showOptionDialog(janelaPrincipal, "Escolha o mes:",
                "Calcular quantidade de vendas do Mês" ,
                0,12,null,opcoes,opcoes[0]);
        if(op==0){
            JOptionPane.showMessageDialog(janelaPrincipal,sistema.quantidadeDeVendasMensal(Month.valueOf(opcoes[0])));
            }
                JOptionPane.showMessageDialog(janelaPrincipal, "Cadastro cancelado","Cancelado",JOptionPane.ERROR_MESSAGE);
                op=-1;
            }
}

