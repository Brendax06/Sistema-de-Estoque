public class Produto {

    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private int estoqueMinimo;

    public Produto(int id, String nome, double preco, int quantidade, int estoqueMinimo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void entradaEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        }
    }

    public boolean saidaEstoque(int quantidade) {

        if (quantidade <= 0) {
            return false;
        }

        if (quantidade > this.quantidade) {
            return false;
        }

        this.quantidade -= quantidade;
        return true;
    }

    public double calcularValorEstoque() {
        return preco * quantidade;
    }

    public boolean estoqueBaixo() {
        return quantidade <= estoqueMinimo;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Produto: " + nome +
                " | Preço: R$ " + String.format("%.2f", preco) +
                " | Quantidade: " + quantidade +
                " | Estoque mínimo: " + estoqueMinimo;
    }
}
