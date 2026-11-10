package routeplanner.modelo;

public class Doca {
    private int id;
    private String nome;
    private int capacidade;

    public Doca(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public int getCapacidade() { return capacidade; }
}

