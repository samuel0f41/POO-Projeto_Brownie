package sistema.Sam_Math_Rona;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SistemaBrownie implements Sistema_Divino_Brownie{

    int ultimoCodigo = 10000000;
    private Map<Integer, Pedido> pedidos;
    private Map<String, Produto> produtos;
    private double dispesaMateriasGastos;
    private LocalDate dataLucros;

    public SistemaBrownie(double dispesaMateriasGastos) {
        this.pedidos = new HashMap<>();
        this.produtos = new HashMap<>();
        this.dispesaMateriasGastos = dispesaMateriasGastos;
    }

    @Override
    public List<Produto> getListarProdutos() {
        List<Produto> lista = new LinkedList<>();
        for(Produto p: this.produtos.values()){
            lista.add(p);
        }
        return lista;
    }

    @Override
    public List<Pedido> getListarPedidos() {
        List<Pedido> lista = new LinkedList<>();

        for(Pedido p: pedidos.values()){
            lista.add(p);
        }
        return lista;
    }

    @Override
    public String vendaRealizarPedido(Cliente cliente, List<ItensPedidos> itensPedidos) throws PedidoJaComCodigoJaExiste {
        ultimoCodigo++;
        int codigo = ultimoCodigo;

        Pedido pedido = new Pedido();
        pedido.setCodigoDoPedido(ultimoCodigo);

        if(pedidos.containsKey(codigo)){
            throw new PedidoJaComCodigoJaExiste("Pedido com mesmo codigo, " +
                    "precisa ajeitar numeração dos pedidos");
        }

        pedido.setCliente(cliente);
        pedido.setItensPedidos(itensPedidos);
        pedido.setValorTotalpedidos(pedido.getValorTotalpedidos());
        pedido.setEstadoPedido(EstadoPedido.PENDENTE);

        pedidos.put(codigo, pedido);
        return "Pedido realizado!\nCodigo do pedido: "+ codigo + "\n\nCliente: "+cliente.getNome();
    }

    @Override
    public List<Pedido> pedidosFaltaConcluir() {
        List<Pedido> lista = new LinkedList<>();

        for(Pedido p: pedidos.values()){
            if(p.getEstadoPedido() == EstadoPedido.PENDENTE){
                lista.add(p);
            }
        }
        return lista;

    }

    @Override
    public void cancelarPedido(int codigo) throws NaoExistePedidoException {

        if(pedidos.containsKey(codigo)){
            pedidos.remove(codigo);
        }else{
            throw new NaoExistePedidoException("Pedido nao encontrado com esse codigo: "+codigo);
        }
    }

    @Override
    public String finalizarVenda(int codigoPedido)throws NaoExistePedidoException {
        // Perguntar a professora se precisa necessita dessa exceção
        if(pedidos.containsKey(codigoPedido)){
            Pedido pedido = pedidos.get(codigoPedido);

            pedido.setEstadoPedido(EstadoPedido.FINALIZADO);
            pedidos.put(pedido.getCodigoDoPedido(), pedido);
            return "Pedido Finalizado";
        }
        return "Pedido Não encontrado tente colocar o codigo certo";
        //throw new NaoExistePedidoException("Pedido não encontrado!");

    }

    public void cadastrarProduto(Produto produto) throws ProdutoJaExisteException{
        if(produtos.containsKey(produto.getCodigo()) ){
            throw new ProdutoJaExisteException("Produto ja foi cadastrado no sistema, tentar outro codigo");
        }

        produtos.put(produto.getCodigo(), produto);

    }

    @Override
        public void removerProduto(String codigo) throws ProdutoNaoEcontradoException {
            if(produtos.containsKey(codigo)) {
                produtos.remove(codigo);
            }else{
                throw new ProdutoNaoEcontradoException("Produto nao encontrado com esse codigo!" + codigo);
            }
        }

    @Override
    public void abasteceEstoqueProduto(String codigo, int unidadeAtualizada)throws ProdutoNaoEcontradoException{
        Produto produto = produtos.get(codigo);

        if(produtos.containsKey(codigo)){
            produto.setQtEstoque(unidadeAtualizada);
        }
        throw new ProdutoNaoEcontradoException("Produto Nao encontrado, estoque nao atualizado!");

    }

    public int quantidadeNoEstoque(String codigo)throws ProdutoNaoEcontradoException{
        if(produtos.containsKey(codigo)){
            Produto p = produtos.get(codigo);
            return p.getQtEstoque();
        }else {
            throw new ProdutoNaoEcontradoException("Produto nao encontrado com codigo: "+codigo);
        }
    }

    @Override
    public int quantidadeDeVendasMensal(List<Pedido> listaDePedidos, Month mes) {
        return 0;
    }

    @Override
    public int quantidadeDeVendasAnual(List<Pedido> listaDePedidos) {
        return 0;
    }

    @Override
    public double calculaLucroAnual(List<Pedido> listaDePedidos) {
        return 0;
    }

    @Override
    public double calculaLucroMensal(List<Pedido> listaDePedidos, Month mes) {
        return 0;
    }

    public void setPedidos(Map<Integer, Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void setProdutos(Map<String, Produto> produtos) {
        this.produtos = produtos;
    }
    public double getDispesaMateriasGastos() {
        return dispesaMateriasGastos;
    }
    public void setDispesaMateriasGastos(double dispesaMateriasGastos) {
        this.dispesaMateriasGastos = dispesaMateriasGastos;
    }
}