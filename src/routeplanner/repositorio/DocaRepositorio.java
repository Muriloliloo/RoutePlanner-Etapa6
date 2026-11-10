package routeplanner.repositorio;

import java.util.ArrayList;
import java.util.List;
import routeplanner.modelo.Doca;

public class DocaRepositorio {

    private final List<Doca> docas = new ArrayList<>();
    private int proximoId = 1;

    public void salvar(Doca doca) {
        doca.setId(proximoId);
        proximoId++;
        docas.add(doca);
    }

    public List<Doca> listar() {
        return docas;
    }
}

