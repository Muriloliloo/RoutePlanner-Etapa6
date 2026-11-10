package routeplanner.servico;

import routeplanner.modelo.ArquivoImportado;

public class ImportacaoServico {

    public ArquivoImportado importar(String nomeArquivo) {
        if (nomeArquivo == null || nomeArquivo.isBlank()) {
            throw new IllegalArgumentException("Selecione um arquivo.");
        }

        String nome = nomeArquivo.toLowerCase();

        if (!nome.endsWith(".csv") && !nome.endsWith(".xls") && !nome.endsWith(".xlsx")) {
            throw new IllegalArgumentException("Use um arquivo CSV ou Excel.");
        }

        return new ArquivoImportado(nomeArquivo);
    }
}

