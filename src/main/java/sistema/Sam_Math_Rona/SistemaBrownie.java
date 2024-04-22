package sistema.Sam_Math_Rona;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;

public class SistemaBrownie implements SistemaDivinoBrownie {

    private List<Produto> produtos;
    private Map<Integer, Pedido> pedidos;
    private double dispesaMateriasGastos;
    private LocalDate dataLucros;
    GravadorProduto gravadorProdutos = new GravadorProduto();
    GravadorPedidos gravadorPedidos = new GravadorPedidos();


    public SistemaBrownie(){
        try {
            this.produtos = gravadorProdutos.leProdutos();
            this.pedidos = gravadorPedidos.lePedidos();
        }catch (IOException e){
            System.err.println((e.getMessage()));
            this.produtos = new LinkedList<>();
            this.pedidos = new HashMap<>();
        }
    }

    public void salvarDados(){
        try {
            this.gravadorProdutos.gravaProduto(this.produtos);
            this.gravadorPedidos.gravaPedidos(this.pedidos);
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
        for(Pedido p: pedidos.values()){
            if(p.getEstadoPedido() == EstadoPedido.PENDENTE){
                lista.add(p);
            }
        }
        return lista;
    }
    @Override
    public void cadastrarPedido(Pedido pedido) throws CodigoPedidoJaExiste{
        int ultimoCodigo = GravadorCodigo.carregarUltimoCodigoPedido();
        if(pedidos.containsKey(pedido.getCodigo())){
            throw new CodigoPedidoJaExiste("Ja existe um pedido com esse codigo");
        }else{
            pedido.setCodigo(ultimoCodigo + 1);
            pedidos.put(pedido.getCodigo(), pedido);
            System.out.println("Total a pagar: "+pedido.getValorTotal());

            GravadorCodigo.salvarUltimoCodigoPedido(pedido.getCodigo());

        }
    }
    @Override
    public void cancelarPedido(int codigo) throws PedidoNaoExisteException {
        if(pedidos.containsKey(codigo)){
            pedidos.remove(codigo);
        }else{
            throw new PedidoNaoExisteException("Pedido nao encontrado com esse codigo: "+codigo);
        }
    }

    @Override
    public void finalizarPedido(int codigo)throws PedidoNaoExisteException {
        if(pedidos.containsKey(codigo)){
            Pedido pedido = pedidos.get(codigo);
            pedido.setEstadoPedido(EstadoPedido.FINALIZADO);
            pedidos.put(pedido.getCodigo(), pedido);
        }
        throw new PedidoNaoExisteException("Pedido nao encontrado com esse codigo: "+codigo);
    }
    @Override
    public void cadastrarProduto(Produto produto, int quantDeProduto)throws ProdutoJaExisteException{
        for(Produto p : produtos){
            if(p.getSabor() == produto.getSabor() && p.getTipo() == produto.getTipo()){
                throw new ProdutoJaExisteException("Esse produto ja foi cadastrado, tente outro!");
            }
//            if (p.equals(produto)) {
//                int quantAnterio = p.getQtEstoque();
//                int quantidadeAtual = quantAnterio + quantDeProduto;
//                p.setQtEstoque(quantidadeAtual);
//            }
        }

        produtos.add(produto);

    }
    @Override
    public void removerProduto(Tipo tipo, Sabores sabor) {
        for(Produto p: produtos){
            if (p.getTipo() == tipo  && p.getSabor()== sabor) {
                produtos.remove(p);
            }
        }
    }

    @Override
    public void abasteceEstoqueProduto(Tipo tipo, Sabores sabor, int quantidade)throws ProdutoNaoExisteException {
        for(Produto p : produtos){
            if(p.getTipo().equals(tipo) && p.getSabor().equals(sabor)){
                int quantAnterior = p.getQtEstoque();
                int quantNova = quantAnterior + quantidade;
                p.setQtEstoque(quantNova);
            }
        }
        throw new ProdutoNaoExisteException("Esse produto não existe no sistema, estoque nao atualizado!");
    }

    public int quantidadeNoEstoque(Tipo tipo, Sabores sabor) throws ProdutoNaoExisteException {
        for(Produto p : produtos){
            if(p.getTipo().equals(tipo) && p.getSabor().equals(sabor)){
                return p.getQtEstoque();
            }
        } throw new ProdutoNaoExisteException("Esse produto não existe no sistema");
    }

    public Produto procurarProduto(String sabor)throws ProdutoNaoExisteException{
        //Legenda 1-Brigadeiro 2-Ninho 3-Dois_Amores 4-NinhoC/Nutela 5- Doce_de_Leite
        Produto brownie = null;
        if(sabor.equals("1")) {
            for(Produto b: produtos){
                if(b.getSabor() == Sabores.BRIGADEIRO){
                    brownie = b;
                }
            }
        }
        else if (sabor.equals("2")) {
            for(Produto b: produtos){
                if(b.getSabor() == Sabores.NINHO){
                    brownie = b;
                }
            }
        }
        else if (sabor.equals("3")) {
            for(Produto b: produtos){
                if(b.getSabor() == Sabores.DOIS_AMORES){
                    brownie = b;
                }
            }
        }
        else if (sabor.equals("4")) {
            for(Produto b: produtos){
                if(b.getSabor() == Sabores.NINHO_C_NUTELLA){
                    brownie = b;
                }
            }
        }
        else if(sabor.equals("5")){
            for(Produto b: produtos){
                if(b.getSabor() == Sabores.DOCE_DE_LEITE){
                    brownie = b;
                }
            }
        }
        if(brownie == null){
            throw new ProdutoNaoExisteException("Esse produto não existe no sistema, estoque nao atualizado!");
        }
        return brownie;
    }

    @Override
    public int quantidadeDeVendasMensal(Month mes) {
        return 0;
    }

    @Override
    public int quantidadeDeVendasAnual(Year ano) {
        return 0;
    }

    @Override
    public double calculaLucroAnual(Year ano) {
        return 0;
    }

    @Override
    public double calculaLucroMensal(Month mes) {
        return 0;
    }

    public void setPedidos(Map<Integer, Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void setProdutos(LinkedList<Produto> produtos) {
        this.produtos = produtos;
    }
    public double getDispesaMateriasGastos() {
        return dispesaMateriasGastos;
    }
    public void setDispesaMateriasGastos(double dispesaMateriasGastos) {
        this.dispesaMateriasGastos = dispesaMateriasGastos;
    }
}
