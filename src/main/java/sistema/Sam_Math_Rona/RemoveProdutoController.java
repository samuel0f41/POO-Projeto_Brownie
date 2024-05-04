package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;


public class RemoveProdutoController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;

    public RemoveProdutoController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        Set<String> listaTipos = new LinkedHashSet<>();
        for(Produto p : sistema.listaDeProdutos()){
            listaTipos.add(p.getTipo());
        }
        ArrayList<String> listaTiposFinal = new ArrayList<>(listaTipos);

        int tipo = JOptionPane.showOptionDialog(janelaPrincipal, "Qual o tipo do produto:","Tipos",0,listaTipos.size(),null,listaTipos.toArray(),listaTipos);
        Set<String> listaSabor = new LinkedHashSet<>();
        for(Produto p : sistema.listaDeProdutos()){
            if(listaTiposFinal.get(tipo).equals(p.getTipo())){
                listaSabor.add(p.getSabor());
            }
        }
        ArrayList<String> listaSaborFinal = new ArrayList<>(listaSabor);

        int sabor = JOptionPane.showOptionDialog(janelaPrincipal, "Qual o Sabor do produto:","Sabores",0,listaSabor.size(),null,listaSabor.toArray(),listaSabor);

        try {
            Produto produto = sistema.procurarProduto(listaTiposFinal.get(tipo),listaSaborFinal.get(sabor));
            sistema.removerProduto(listaTiposFinal.get(tipo),listaSaborFinal.get(sabor));
            JOptionPane.showMessageDialog(janelaPrincipal, "Produto removido! " + produto);

        } catch (ProdutoNaoExisteException ex) {
            throw new RuntimeException(ex);
        }

    }

}
