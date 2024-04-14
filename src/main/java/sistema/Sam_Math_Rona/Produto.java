package sistema.Sam_Math_Rona;

import java.util.Objects;

public class Produto {
    private String nome;
    private Tipo tipo;
    private Sabores sabores;
    private int qtEstoque;
    private double preco;
    private String codigo;

    public Produto(String nome, Tipo tipo, Sabores sabores, int qtEstoque, double preco, String codigo) {
        this.nome = nome;
        this.tipo = tipo;
        this.sabores = sabores;
        this.qtEstoque = qtEstoque;
        this.preco = preco;
        this.codigo = codigo;
    }
    public Produto(){
        this.qtEstoque = 0;
        this.sabores = Sabores.UNICO;
        this.tipo = Tipo.INDEFINIDO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Sabores getSabores() {
        return sabores;
    }

    public void setSabores(Sabores sabores) {
        this.sabores = sabores;
    }

    public int getQtEstoque() {
        return qtEstoque;
    }

    public void setQtEstoque(int qtEstoque) {
        this.qtEstoque = qtEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
