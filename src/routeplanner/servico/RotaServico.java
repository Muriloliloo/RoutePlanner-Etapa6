package routeplanner.servico;

import java.util.List;
import routeplanner.modelo.Rota;
import routeplanner.repositorio.RotaRepositorio;

public class RotaServico {

    private final RotaRepositorio repositorio;

    public RotaServico(RotaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Rota cadastrar(String nome, String destino, String doca) {
        if (nome.isBlank() || destino.isBlank() || doca.isBlank()) {
            throw new IllegalArgumentException("Preencha todos os campos.");
        }

        Rota rota = new Rota(nome, destino, doca);
        repositorio.salvar(rota);

        return rota;
    }

    public List<Rota> listar() {
        return repositorio.listar();
    }
}

