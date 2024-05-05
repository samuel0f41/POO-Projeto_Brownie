package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;

public class VerLucroDoMes implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    ImageIcon calendar = new ImageIcon("./imgs/icons/calendario.png");
    ImageIcon vendasTotal = new ImageIcon("./imgs/icons/venda.png");
    private Object[] JTextField;

    public VerLucroDoMes(SistemaBrownie sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        Month mes = null;
        String nomeMes = "";
        while (mes == null){
            String mesPesquisar = (String) JOptionPane.showInputDialog(janelaPrincipal, "Digite o Mês:\n1 - Janeiro\n2 - Fevereiro\n3 - Março\n4 - Abril" +
                    "5 - Maio \n6 - Junho \n7 - Julho \n8 - Agosto \n9 - Setembro \n10 Outubro \n11 - Novembro \n12 - Dezembro", "Ver Lucro do Mês",JOptionPane.QUESTION_MESSAGE,calendar,JTextField,null);
            if(mesPesquisar.equals("1")){ mes = Month.JANUARY; nomeMes = "Janeiro"; }
            else if(mesPesquisar.equals("2")){ mes = Month.FEBRUARY; nomeMes = " Fevereiro";}
            else if(mesPesquisar.equals("3")){ mes = Month.MARCH; nomeMes = " Março";}
            else if(mesPesquisar.equals("4")){ mes = Month.APRIL; nomeMes = " Abril";}
            else if(mesPesquisar.equals("5")){ mes = Month.MAY; nomeMes = " Maio";}
            else if(mesPesquisar.equals("6")){ mes = Month.JUNE; nomeMes = " Junho";}
            else if(mesPesquisar.equals("7")){ mes = Month.JULY; nomeMes = " Julho";}
            else if(mesPesquisar.equals("8")){ mes = Month.AUGUST; nomeMes = " Agosto";}
            else if(mesPesquisar.equals("9")){ mes = Month.SEPTEMBER; nomeMes = " Setembro";}
            else if(mesPesquisar.equals("10")){ mes = Month.OCTOBER; nomeMes = " Outubro";}
            else if(mesPesquisar.equals("11")){ mes = Month.NOVEMBER; nomeMes = " Novembro";}
            else if(mesPesquisar.equals("12")){ mes = Month.DECEMBER; nomeMes = " Dezembro";}
            else mes = null;
        }

        double  valorTotal =  sistema.calculaLucroMensal(mes);
        JOptionPane.showMessageDialog(janelaPrincipal, "Lucro de vendas: " + valorTotal + " no mes de"+ nomeMes,"Ver Lucro do Mês",JOptionPane.INFORMATION_MESSAGE,vendasTotal);
    }

}
