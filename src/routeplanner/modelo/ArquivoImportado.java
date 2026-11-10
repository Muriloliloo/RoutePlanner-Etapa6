package routeplanner.modelo;

import java.time.LocalDate;

public class ArquivoImportado {
    private String nomeArquivo;
    private LocalDate dataImportacao;

    public ArquivoImportado(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.dataImportacao = LocalDate.now();
    }

    public String getNomeArquivo() { return nomeArquivo; }
    public LocalDate getDataImportacao() { return dataImportacao; }
}

