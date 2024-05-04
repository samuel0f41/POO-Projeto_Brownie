package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.*;
public class BrownieGerenciadorGui extends JFrame {
    JLabel linha1, linha2;
    ImageIcon brownie;
    SistemaBrownie sistema = new SistemaBrownie();
    JMenuBar barraMenu = new JMenuBar();
    public BrownieGerenciadorGui(){

        setTitle("Sistema de vendas e Gerenciamento de Brownie");
        setSize(950, 650);
        setLocation(300,110);
        setResizable(false);
        setBackground(Color.white);

        brownie = new ImageIcon("./imgs/brownie1.jpeg");

        Image imagemOriginal = brownie.getImage();
        Image imagemRedimensionada = imagemOriginal.getScaledInstance(875, 455, Image.SCALE_SMOOTH);
        brownie = new ImageIcon(imagemRedimensionada);

        linha1 = new JLabel("Divino Brownie", JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("Serif", Font.BOLD, 40));
        add(linha1, BorderLayout.NORTH);

        linha2 = new JLabel(brownie, JLabel.CENTER);
        add(linha2, BorderLayout.CENTER);
        // Setando o fundo da linha2 como transparente para que a imagem de fundo do JFrame seja visível
        linha2.setOpaque(false);

        setJMenuBar(barraMenu);
        setVisible(true);

        add(linha1);
        add(linha2);
        add(new JLabel());

        //botoes da interface

        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarProduto = new JMenuItem("Produto");
        JMenuItem menuCadastrarPedido = new JMenuItem("Pedido");
        menuCadastrar.add(menuCadastrarProduto);
        menuCadastrar.add(menuCadastrarPedido);

        JMenu menuFinalizar = new JMenu("Finalizar");
        JMenuItem menuFinalizarPedido = new JMenuItem("Pedido");
        menuFinalizar.add(menuFinalizarPedido);

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverProduto = new JMenuItem("Produto");
        JMenuItem menuRemoverPedidoFinalizado = new JMenuItem("Pedido Finalizado");
        menuRemover.add(menuRemoverProduto);
        menuRemover.add(menuRemoverPedidoFinalizado);

        JMenu menuAtualizar = new JMenu("Atualizar");
        JMenuItem menuAlteraQuantidadeEstoque = new JMenuItem("Estoque do produto");
        JMenuItem menuVerQuantidadeDoProdutoNoEstoque = new JMenuItem("Ver quantidade do Produto no estoque");
        menuAtualizar.add(menuAlteraQuantidadeEstoque);
        menuAtualizar.add(menuVerQuantidadeDoProdutoNoEstoque);

        JMenu menuListar = new JMenu("Listar");
        JMenuItem menuListarProdutos = new JMenuItem("Ver todos os Produtos cadastrados");
        JMenuItem menuListarPedidos = new JMenuItem("Ver todos Pedidos finalizados");
        menuListar.add(menuListarProdutos);
        menuListar.add(menuListarPedidos);

        JMenu menuPedidosPendentes = new JMenu("Pendentes / Cancelar");
        JMenuItem menuListarPedidosPendentes = new JMenuItem("Ver Pedidos Pendentes");
        JMenuItem menuCancelarPedido = new JMenuItem("Cancelar Pedido Pendentes");
        menuPedidosPendentes.add(menuListarPedidosPendentes);
        menuPedidosPendentes.add(menuCancelarPedido);

        JMenu menuLucros = new JMenu("Lucro");
        JMenuItem menuVerLucroDoMes = new JMenuItem("Ver Lucro do Mês");
        JMenuItem menuVerLucroDoAno = new JMenuItem("Ver Lucro do Ano");
        JMenuItem menuVerQuantidadeVendasDoMes = new JMenuItem("Ver Quantidade de vendas do Mes");
        JMenuItem menuVerQuantidadeVendasDoAno = new JMenuItem("Ver Quantidade de vendas do Ano");

        menuLucros.add(menuVerLucroDoMes);
        menuLucros.add(menuVerLucroDoAno);
        menuLucros.add(menuVerQuantidadeVendasDoMes);
        menuLucros.add(menuVerQuantidadeVendasDoAno);


        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarDados = new JMenuItem("Dados atuais");
        menuSalvar.add(menuSalvarDados);

        //Classes com as funções do sistemas

        menuCadastrarPedido.addActionListener(new CadastraPedidoController(sistema, this));
        menuFinalizarPedido.addActionListener( new FinalizaPedidoController(sistema, this   ));
        menuRemoverPedidoFinalizado.addActionListener((ae) -> {
            int codigoPedido = Integer.parseInt(JOptionPane.showInputDialog(null, "Codigo pedido: "));
            try {
                sistema.removerPedidoFinalizado(codigoPedido);
                JOptionPane.showMessageDialog(null, "Pedido: "+  codigoPedido + " Removido!");
            } catch (PedidoNaoExisteException ex) {
                throw new RuntimeException(ex);
            }
        });

        menuCadastrarProduto.addActionListener(new CadastraProdutoController(sistema, this));
        menuRemoverProduto.addActionListener(new RemoveProdutoController(sistema, this));
        menuAlteraQuantidadeEstoque.addActionListener(new AtualizaQuantidadeBrownieController(sistema, this));
        menuVerQuantidadeDoProdutoNoEstoque.addActionListener(new VerQuantidadeDoProdutoNoEstoqueController(sistema, this));
        menuCancelarPedido.addActionListener(new CancelarPedidoController(sistema, this));
        menuVerLucroDoMes.addActionListener(new VerLucroDoMes(sistema, this));
        menuVerLucroDoAno.addActionListener(new VerLucroDoAno(sistema, this));
        menuVerQuantidadeVendasDoMes.addActionListener(new VerQuantidadeVendasDoMes(sistema, this));
        menuVerQuantidadeVendasDoAno.addActionListener(new VerQuantidadeVendasDoAno(sistema, this));


        menuListarPedidos.addActionListener((ae) ->{
            JOptionPane.showMessageDialog(this, sistema.listaDeTodosPedidos());
        });
        menuListarProdutos.addActionListener((ae)->{
            JOptionPane.showMessageDialog(this, sistema.listaDeProdutos());
        });
        menuListarPedidosPendentes.addActionListener((ae) -> {
            JOptionPane.showMessageDialog(this, sistema.listaDePedidosPendentes());
        });
        menuSalvarDados.addActionListener((ae) -> {
            sistema.salvarDados();
        });

        barraMenu.add(menuCadastrar);
        barraMenu.add(menuAtualizar);
        barraMenu.add(menuPedidosPendentes);
        barraMenu.add(menuFinalizar);
        barraMenu.add(menuRemover);
        barraMenu.add(menuLucros);
        barraMenu.add(menuListar);
        barraMenu.add(menuSalvar);

        setJMenuBar(barraMenu);
    }

    public static void main(String [] args){
        JFrame janela = new BrownieGerenciadorGui();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
