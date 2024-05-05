package sistema.Sam_Math_Rona;

import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class SistemaBrownie implements SistemaDivinoBrownie {
    private List<Produto> produtos;
    private Map<Integer, Pedido> pedidos;
    private Map<Integer, Pedido> pedidosPendentes = new HashMap<>();
    private LocalDate dataLucros;
    GravadorProduto gravadorProdutos = new GravadorProduto();
    GravadorPedidos gravadorPedidos = new GravadorPedidos();
    GravadorPedidosPendentes gravadorPedidosPendentes = new GravadorPedidosPendentes();


    public SistemaBrownie(){
        try {
            this.produtos = gravadorProdutos.leProdutos();
            this.pedidos = gravadorPedidos.lePedidos();
            this.pedidosPendentes = gravadorPedidosPendentes.lePedidosPendentes();
            JOptionPane.showMessageDialog(null, "Dados 100% recuperados: \nProdutos cadastrados! \nLista de Pedidos Pendentes!\nLista de Pedidos concluidos!");
        }catch (IOException e){
            System.err.println((e.getMessage()));
            this.produtos = new LinkedList<>();
            this.pedidos = new HashMap<>();
            this.pedidosPendentes = new HashMap<>();

        }
    }

    public void salvarDados(){
        try {
            this.gravadorProdutos.gravaProduto(this.produtos);
            this.gravadorPedidos.gravaPedidos(this.pedidos);
            this.gravadorPedidosPendentes.gravaPedidosPendentes(this.pedidosPendentes);
            JOptionPane.showMessageDialog(null, "Dados 100% Salvos: \nProdutos cadastrados! \nLista de Pedidos Pendentes!\nLista de Pedidos concluidos!");
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Produto> listaDeProdutos(){
        return this.produtos;
    }

    @Override
    public List<Pedido> listaDeTodosPedidos() {
        List<Pedido> lista = new LinkedList<>();
        for(Pedido p: pedidos.values()){
            lista.add(p);
        }
        return lista;
    }
    @Override
    public List<Pedido> listaDePedidosPendentes() {
        List<Pedido> lista = new LinkedList<>();
        for(Pedido p: pedidosPendentes.values()){
            lista.add(p);
        }
        return lista;
    }
    public void removerPedidoFinalizado(int codigo) throws PedidoNaoExisteException{
        if(pedidos.containsKey(codigo)) pedidos.remove(codigo);
        else{
            throw new PedidoNaoExisteException("Esse pedido nao existe, tente outro codigo");
        }
    }
    @Override
    public void cadastrarPedido(Pedido pedido) throws CodigoPedidoJaExiste{
        //achar ultimo codigo pecorrendo o ultimo maior da lista de pedidos finalizados e pedidos pendentes
        int codigoPedidosPendentes = 0;
        int codigoPedidosFinalizados = 0;
        int codigoAtual = 0;
        for(Pedido p1: pedidosPendentes.values()){
            if (p1.getCodigo() >= codigoPedidosPendentes) codigoPedidosPendentes = p1.getCodigo();
        }
        for(Pedido p2: pedidos.values()){
            if (p2.getCodigo() >= codigoPedidosFinalizados) codigoPedidosFinalizados = p2.getCodigo();
        }
        if(codigoPedidosFinalizados > codigoPedidosPendentes) codigoAtual = codigoPedidosFinalizados+1;
        else codigoAtual = codigoPedidosPendentes+1;

        pedido.setCodigo(codigoAtual);
        pedido.setEstadoPedido(EstadoPedido.PENDENTE);
        pedido.getAtualizarValorTotal();
        if(this.pedidosPendentes.containsKey(pedido.getCodigo()) || this.pedidos.containsKey(pedido.getCodigo())){
                throw new CodigoPedidoJaExiste("Ja existe um pedido com esse codigo");

        }else{
            this.pedidosPendentes.put(pedido.getCodigo(), pedido);

        }

    }
    @Override
    public void cancelarPedido(int codigo) throws PedidoNaoExisteException {
        if(pedidosPendentes.containsKey(codigo)){
            pedidosPendentes.remove(codigo);
        }else{
            throw new PedidoNaoExisteException("Pedido nao encontrado com esse codigo: "+codigo);
        }
    }

    @Override
    public void finalizarPedido(int codigo)throws PedidoNaoExisteException {
        if(pedidosPendentes.containsKey(codigo)){
            Pedido pedido = pedidosPendentes.get(codigo);
            pedido.setEstadoPedido(EstadoPedido.FINALIZADO);
            pedidos.put(pedido.getCodigo(), pedido);
            pedidosPendentes.remove(pedido.getCodigo());
        }else{
            throw new PedidoNaoExisteException("Pedido nao encontrado com esse codigo: "+codigo);
        }

    }
    @Override
    public void cadastrarProduto(Produto produto)throws ProdutoJaExisteException{
        for(Produto p : produtos){
            if(p.getTipo().equals(produto.getTipo()) && p.getSabor().equals(produto.getSabor())){
                throw new ProdutoJaExisteException("Esse produto ja foi cadastrado, tente outro!");
            }
        }
        produtos.add(produto);
    }
    @Override
    public void removerProduto(String tipo, String sabor) throws ProdutoNaoExisteException {
        boolean produtoEncontrado = false; // Variável para verificar se o produto foi encontrado
        for(Produto p: produtos){
            if (p.getSabor().equals(sabor) && p.getTipo().equals(tipo)) {
                produtos.remove(p);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado) {
            throw new ProdutoNaoExisteException("Esse produto não existe no sistema!");
        }
    }

    @Override
    public void abasteceEstoqueProduto(String tipo, String sabor, int quantAbastecer) throws ProdutoNaoExisteException {
        boolean produtoEncontrado = false; // Variável para verificar se o produto foi encontrado
        for (Produto p : produtos) {
            if (p.getSabor().equals(sabor) && p.getTipo().equals(tipo)) {
                int quantAnterior = p.getQtEstoque();
                int quantNova = quantAnterior + quantAbastecer;
                p.setQtEstoque(quantNova);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado) {
            throw new ProdutoNaoExisteException("Esse produto não existe no sistema, estoque não atualizado!");
        }
    }

    @Override
    public int quantidadeNoEstoque(String tipo, String sabor) throws ProdutoNaoExisteException {
        for(Produto p : produtos){
            if(p.getSabor().equals(sabor) && p.getTipo().equals(tipo)){
                return p.getQtEstoque();
            }
        } throw new ProdutoNaoExisteException("Esse produto não existe no sistema");
    }
    @Override
    public Produto procurarProduto(String tipo, String sabor)throws ProdutoNaoExisteException{
        for(Produto p : produtos) {
            if (p.getSabor().equals(sabor) && p.getTipo().equals(tipo)) {
                return p;
            }
        }
        throw new ProdutoNaoExisteException("Esse produto não existe no sistema");
    }

    @Override
    public int quantidadeDeVendasMensal(Month mes) {
        int quantidadeDeVendasNoMes = 0;
        for(Pedido p: pedidos.values()){
            if(p.getData().getMonth() == mes){
                quantidadeDeVendasNoMes++;
            }
        }
        return quantidadeDeVendasNoMes;
    }

    @Override
    public int quantidadeDeVendasAnual(int ano) {
        int quantidadeDeVendasNoAno = 0;
        for(Pedido p: pedidos.values()){
            if(p.getData().getYear() == ano){
                quantidadeDeVendasNoAno++;
            }
        }
        return quantidadeDeVendasNoAno;
    }

    @Override
    public double calculaLucroAnual(int ano) {
        double valorLucroTotal = 0;

        for(Pedido p: pedidos.values()){
            if(p.getData().getYear() == ano ){
                valorLucroTotal += p.getValorTotal();
            }
        }

        return valorLucroTotal;
    }

    @Override
    public double calculaLucroMensal(Month mes) {
        double valorTotalLucro = 0;
        for(Pedido p: this.pedidos.values()){
            if(p.getData().getMonth() == mes){
                valorTotalLucro = valorTotalLucro + p.getValorTotal();
            }
        }
        return valorTotalLucro;
    }

    public void setPedidos(Map<Integer, Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void setProdutos(LinkedList<Produto> produtos) {
        this.produtos = produtos;
    }
}
