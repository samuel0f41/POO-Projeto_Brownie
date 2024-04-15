package sistema.Sam_Math_Rona;

public class ItensPedidos {
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    public ItensPedidos(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = this.produto.getPreco();
    }
    public ItensPedidos(){
        this.quantidade = 1;
    }
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getPrecoTotal(){
        return this.quantidade * this.precoUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
