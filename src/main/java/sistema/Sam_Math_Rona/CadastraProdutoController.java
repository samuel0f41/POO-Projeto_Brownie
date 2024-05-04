package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CadastraProdutoController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;
    ImageIcon addBox = new ImageIcon("./imgs/icons/addCaixa.png");
    ImageIcon iconfeitar = new ImageIcon("./imgs/icons/sconfeitar.png");
    ImageIcon quantEstoque = new ImageIcon("./imgs/icons/estoque.png");
    ImageIcon valor = new ImageIcon("./imgs/icons/dinheiro.png");
    ImageIcon check = new ImageIcon("./imgs/icons/feito.png");
    private Object[] JTextField;

    public CadastraProdutoController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    public void actionPerformed(ActionEvent e){
        String tipo = (String) JOptionPane.showInputDialog(null,"Qual Tipo do Produto: ","Cadastrar Produto",JOptionPane.QUESTION_MESSAGE,addBox,JTextField,null);
        String sabor = (String) JOptionPane.showInputDialog(null,"Qual Sabor do Produto: ","Cadastrar Produto",JOptionPane.QUESTION_MESSAGE,iconfeitar,JTextField,null);
        int qtEstoque = Integer.parseInt((String) JOptionPane.showInputDialog(null,"Digite a quantidade disponivel: ","Cadastrar Produto",JOptionPane.QUESTION_MESSAGE,quantEstoque,JTextField,null));
        double preco = Double.parseDouble((String) JOptionPane.showInputDialog(null,"valor do produto: ","Cadastrar Produto",JOptionPane.QUESTION_MESSAGE,valor,JTextField,null));
        try {
            sistema.cadastrarProduto(new Produto(tipo,sabor,qtEstoque,preco));
            try {
                JOptionPane.showMessageDialog(janelaPrincipal, "Produto cadastrado!" + sistema.procurarProduto(tipo,sabor),"Cadastrar Produto",1,check);
            } catch (ProdutoNaoExisteException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ProdutoJaExisteException ex) {
            throw new RuntimeException(ex);
        }

    }
}
