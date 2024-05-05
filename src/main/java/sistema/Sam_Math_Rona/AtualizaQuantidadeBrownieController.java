package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;


public class AtualizaQuantidadeBrownieController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    ImageIcon iBrownie = new ImageIcon("./imgs/icons/ibrownie.png");
    ImageIcon iconfeitar = new ImageIcon("./imgs/icons/sconfeitar.png");
    ImageIcon pvalor = new ImageIcon("./imgs/icons/preco.png");
    private Object[] JTextField;

    public AtualizaQuantidadeBrownieController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    public void actionPerformed(ActionEvent e){
        Set<String> listaTipos = new LinkedHashSet<>();
        for(Produto p : sistema.listaDeProdutos()){
            listaTipos.add(p.getTipo());
        }
        ArrayList<String> listaTiposFinal = new ArrayList<>(listaTipos);

        int tipo = JOptionPane.showOptionDialog(janelaPrincipal, "Qual o tipo do produto:","Estoque do Produto",0,listaTipos.size(),iBrownie,listaTipos.toArray(),listaTipos);
        Set<String> listaSabor = new LinkedHashSet<>();
        for(Produto p : sistema.listaDeProdutos()){
            if(listaTiposFinal.get(tipo).equals(p.getTipo())){
                listaSabor.add(p.getSabor());
            }
        }
        ArrayList<String> listaSaborFinal = new ArrayList<>(listaSabor);

        int sabor = JOptionPane.showOptionDialog(janelaPrincipal, "Qual o Sabor do produto:", "Sabores", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, iconfeitar, listaSabor.toArray(), listaSabor);

        String quant = (String) JOptionPane.showInputDialog(janelaPrincipal,"Digite a quantidade que vai abastecer desse sabor: ","Estoque do Produto",JOptionPane.QUESTION_MESSAGE,pvalor,JTextField,null);
        int quanti = Integer.parseInt(quant);

        try {
            sistema.abasteceEstoqueProduto(listaTiposFinal.get(tipo),listaSaborFinal.get(sabor),quanti);
            JOptionPane.showMessageDialog(janelaPrincipal,sistema.procurarProduto(listaTiposFinal.get(tipo),listaSaborFinal.get(sabor)));
        } catch (ProdutoNaoExisteException ex) {
            throw new RuntimeException(ex);
        }


    }

}
