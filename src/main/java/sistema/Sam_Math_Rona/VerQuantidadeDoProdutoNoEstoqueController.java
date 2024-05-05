package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class VerQuantidadeDoProdutoNoEstoqueController implements ActionListener {

    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    ImageIcon iconfeitar = new ImageIcon("./imgs/icons/sconfeitar.png");
    ImageIcon iBrownie = new ImageIcon("./imgs/icons/ibrownie.png");
    ImageIcon quantEstoque = new ImageIcon("./imgs/icons/estoque.png");
    public VerQuantidadeDoProdutoNoEstoqueController(SistemaBrownie sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    public void actionPerformed(ActionEvent e){
        Set<String> listaTipos = new LinkedHashSet<>();
        for(Produto p : sistema.listaDeProdutos()){
            listaTipos.add(p.getTipo());
        }
        ArrayList<String> listaTiposFinal = new ArrayList<>(listaTipos);

        int tipo = JOptionPane.showOptionDialog(janelaPrincipal, "Qual o tipo do produto:","Quantidade do Produto no Estoque",0,listaTipos.size(),iBrownie,listaTipos.toArray(),listaTipos);
        Set<String> listaSabor = new LinkedHashSet<>();
        for(Produto p : sistema.listaDeProdutos()){
            if(listaTiposFinal.get(tipo).equals(p.getTipo())){
                listaSabor.add(p.getSabor());
            }
        }
        ArrayList<String> listaSaborFinal = new ArrayList<>(listaSabor);

        int sabor = JOptionPane.showOptionDialog(janelaPrincipal, "Qual o Sabor do produto:","Quantidade do Produto no Estoque",0,listaSabor.size(),iconfeitar,listaSabor.toArray(),listaSabor);


        try {
            Produto produto = sistema.procurarProduto(listaTiposFinal.get(tipo),listaSaborFinal.get(sabor));
            JOptionPane.showMessageDialog(null, "Quantidade no estoque: "+ produto.getQtEstoque(),"Quantidade do Produto no Estoque",JOptionPane.INFORMATION_MESSAGE,quantEstoque);

        } catch (ProdutoNaoExisteException ex) {
            throw new RuntimeException(ex);
        }
    }
}
