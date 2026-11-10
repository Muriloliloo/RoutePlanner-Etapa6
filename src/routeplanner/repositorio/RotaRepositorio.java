package routeplanner.repositorio;

import java.util.ArrayList;
import java.util.List;
import routeplanner.modelo.Rota;

public class RotaRepositorio {

    private final List<Rota> rotas = new ArrayList<>();
    private int proximoId = 1;

    public void salvar(Rota rota) {
        rota.setId(proximoId);
        proximoId++;
        rotas.add(rota);
    }

    public List<Rota> listar() {
        return rotas;
    }
}

