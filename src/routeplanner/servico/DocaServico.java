package routeplanner.servico;

import java.util.List;
import routeplanner.modelo.Doca;
import routeplanner.repositorio.DocaRepositorio;

public class DocaServico {

    private final DocaRepositorio repositorio;

    public DocaServico(DocaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Doca cadastrar(String nome, String capacidadeTexto) {
        if (nome.isBlank() || capacidadeTexto.isBlank()) {
            throw new IllegalArgumentException("Preencha todos os campos.");
        }

        int capacidade = Integer.parseInt(capacidadeTexto);

        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }

        Doca doca = new Doca(nome, capacidade);
        repositorio.salvar(doca);

        return doca;
    }

    public List<Doca> listar() {
        return repositorio.listar();
    }
}

