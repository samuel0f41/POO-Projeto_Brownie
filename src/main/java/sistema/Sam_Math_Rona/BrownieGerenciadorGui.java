package sistema.Sam_Math_Rona;

import javax.swing.*;
import java.awt.*;
public class BrownieGerenciadorGui extends JFrame {
    JLabel linha1, linha2;
    ImageIcon brasileirao;
    SistemaBrownie sistema = new SistemaBrownie();
    JMenuBar barraMenu = new JMenuBar();
    public BrownieGerenciadorGui(){

        setTitle("Sistema de vendas e Gerenciamento de Brownie");
        setSize(950, 650);
        setLocation(300,110);
        setResizable(false);
        setBackground(Color.white);

        brasileirao = new ImageIcon("./imgs/brownie1.jpeg");

        Image imagemOriginal = brasileirao.getImage();
        Image imagemRedimensionada = imagemOriginal.getScaledInstance(875, 455, Image.SCALE_SMOOTH);
        brasileirao = new ImageIcon(imagemRedimensionada);

        linha1 = new JLabel("Divino Brownie", JLabel.CENTER);
        linha1.setForeground(Color.blue);
        linha1.setFont(new Font("Serif", Font.BOLD, 40));
        add(linha1, BorderLayout.NORTH);

        linha2 = new JLabel(brasileirao, JLabel.CENTER);
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
        menuRemover.add(menuRemoverProduto);

        JMenu menuAltera = new JMenu("Alterar");
        JMenuItem menuAlteraQuantidadeEstoque = new JMenuItem("Quantidade no estoque");
        menuAltera.add(menuAlteraQuantidadeEstoque);

        JMenu menuListar = new JMenu("Listar");
        JMenuItem menuListarProdutos = new JMenuItem("Produtos");
        JMenuItem menuListarPedidos = new JMenuItem("Pedidos");
        menuListar.add(menuListarProdutos);
        menuListar.add(menuListarPedidos);

        JMenu menuPedidosPendentes = new JMenu("Area Pedidos");
        JMenuItem menuListarPedidosPendentes = new JMenuItem("Pedidos Pendentes");
        JMenuItem menuCancelarPedido = new JMenuItem("Cancelar Pedido");
        menuPedidosPendentes.add(menuListarPedidosPendentes);
        menuPedidosPendentes.add(menuCancelarPedido);

        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarDados = new JMenuItem("Dados atuais");
        menuSalvar.add(menuSalvarDados);

        //Classes com as funções do sistemas

        menuCadastrarPedido.addActionListener(new CadastraPedidoController(sistema, this));
        menuFinalizarPedido.addActionListener( new PesquisaPedidoController(sistema, this   ));

        menuCadastrarProduto.addActionListener(new CadastraProdutoController(sistema, this));
        menuRemoverProduto.addActionListener(new RemoveProdutoController(sistema, this));
        menuAlteraQuantidadeEstoque.addActionListener(new AtualizaQuantidadeBrownieController(sistema, this));

        menuListarPedidos.addActionListener(new ListarPedidosController(sistema, this));
        menuListarProdutos.addActionListener(new ListarProdutosController(sistema, this));

        menuListarPedidosPendentes.addActionListener(new ListarPedidosPendentesController(sistema, this));
        menuCancelarPedido.addActionListener(new CancelarPedidoController(sistema, this));

        menuSalvarDados.addActionListener((ae) -> {
            sistema.salvarDados();
        });

        barraMenu.add(menuCadastrar);
        barraMenu.add(menuFinalizar);
        barraMenu.add(menuRemover);
        barraMenu.add(menuAltera);
        barraMenu.add(menuListar);
        barraMenu.add(menuSalvar);
        barraMenu.add(menuPedidosPendentes);

        setJMenuBar(barraMenu);
    }

    public static void main(String [] args){
        JFrame janela = new BrownieGerenciadorGui();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
