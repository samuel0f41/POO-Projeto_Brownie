package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class CadastraPedidoController implements ActionListener {
    private SistemaBrownie sistema;
    private JFrame janelaPrincipal;

    public CadastraPedidoController(SistemaBrownie sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    public void actionPerformed(ActionEvent e){
        String nome = JOptionPane.showInputDialog("Nome do clinte: ");
        if(nome == null){
            JOptionPane.showMessageDialog(janelaPrincipal, "Cadastro cancelado","Cancelado",JOptionPane.ERROR_MESSAGE);
        }
        else if(nome.trim().isEmpty()){
            JOptionPane.showMessageDialog(janelaPrincipal,"Nome não pode ser vazio","Cancelado",JOptionPane.WARNING_MESSAGE);
        }else{
            String[] opcoes = {"ENTREGA", "RETIRADA"};
            int op = JOptionPane.showOptionDialog(janelaPrincipal, "Qual o tipo de entrega:"
                    ,"Entrega",0,2,null,opcoes,opcoes[0]);
            Cliente c1 = new Cliente(nome);
            if(op==0){
                String numeroCasa = JOptionPane.showInputDialog("Numero da casa: ");
                if(numeroCasa == null){
                    JOptionPane.showMessageDialog(janelaPrincipal, "Cadastro cancelado","Cancelado",JOptionPane.ERROR_MESSAGE);
                    op=-1;
                } else if(numeroCasa.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(janelaPrincipal, "Numero da casa não pode ser vazio", "Cancelado", JOptionPane.WARNING_MESSAGE);
                    op = - 1;
                }else {
                    String endereco = JOptionPane.showInputDialog("Digete o seu endereço:");
                    if(endereco == null){
                        JOptionPane.showMessageDialog(janelaPrincipal, "Cadastro cancelado","Cancelado",JOptionPane.ERROR_MESSAGE);
                        op=-1;
                    }
                    else if(endereco.trim().isEmpty()){
                        JOptionPane.showMessageDialog(janelaPrincipal,"Nome não pode ser vazio","Cancelado",JOptionPane.WARNING_MESSAGE);
                        op=-1;
                    }else {
                        c1.setEndereco(endereco);
                        c1.setNumeroCasa(numeroCasa);
                    }
                }

            } else if(op==1){
                c1.setEndereco("Retirada");
            } else if(op == -1){
                JOptionPane.showMessageDialog(janelaPrincipal, " O pedido foi cancelado");
            }

            if(op == 0 || op == 1){
                List<Produto> carrinho = new ArrayList<>();
                int condicao = 0;
                while(condicao == 0){
                    Set<String> listaTipos = new LinkedHashSet<>();
                    for(Produto p : sistema.listaDeProdutos()){
                            listaTipos.add(p.getTipo());
                    }
                    ArrayList<String> listaTiposFinal = new ArrayList<>(listaTipos);

                    int tipo = JOptionPane.showOptionDialog(janelaPrincipal, "Qual o tipo do produto:",
                            "Tipos",0,listaTipos.size(),null,listaTipos.toArray(),listaTipos);
                    Set<String> listaSabor = new LinkedHashSet<>();
                    for(Produto p : sistema.listaDeProdutos()){
                        if(listaTiposFinal.get(tipo).equals(p.getTipo())){
                            listaSabor.add(p.getSabor());
                        }
                    }
                    ArrayList<String> listaSaborFinal = new ArrayList<>(listaSabor);

                    int sabor = JOptionPane.showOptionDialog(janelaPrincipal, "Qual o Sabor do produto:","Sabores",0,listaSabor.size(),null,listaSabor.toArray(),listaSabor);

                    try {
                        Produto produto = sistema.procurarProduto(listaTiposFinal.get(tipo), listaSaborFinal.get(sabor));
                        carrinho.add(produto);
                    } catch (ProdutoNaoExisteException ex) {
                        throw new RuntimeException(ex);
                    }


                    String[] comprando = {"SIM", "NÃO"};
                    condicao = JOptionPane.showOptionDialog(janelaPrincipal, "Deseja continuar comprando?:","Carrinho"
                            ,0,2,null,comprando,comprando[0]);

                }
                if(op != -1){
                    Pedido pedido = new Pedido(c1,carrinho);
                    pedido.getValorTotal();
                    try {
                        sistema.cadastrarPedido(pedido);
                    } catch (CodigoPedidoJaExiste ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(janelaPrincipal, pedido.toString());
                }
            }
        }


    }

}
