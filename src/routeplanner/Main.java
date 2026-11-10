package routeplanner;

import javax.swing.SwingUtilities;
import routeplanner.modelo.ArquivoImportado;
import routeplanner.modelo.Doca;
import routeplanner.modelo.Rota;
import routeplanner.repositorio.DocaRepositorio;
import routeplanner.repositorio.RotaRepositorio;
import routeplanner.servico.DocaServico;
import routeplanner.servico.ImportacaoServico;
import routeplanner.servico.RotaServico;
import routeplanner.tela.TelaPrincipal;

public class Main {

    public static void main(String[] args) {

        // Primeiro fazemos alguns testes simples.
        executarTestes();

        // Depois abrimos a tela principal do sistema.
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
        });
    }

    private static void executarTestes() {

        System.out.println("==================================");
        System.out.println("TESTES SIMPLES - ROUTE PLANNER");
        System.out.println("==================================");

        RotaServico rotaServico =
                new RotaServico(new RotaRepositorio());

        DocaServico docaServico =
                new DocaServico(new DocaRepositorio());

        ImportacaoServico importacaoServico =
                new ImportacaoServico();

        // TESTE 1 - cadastro de uma doca.
        try {
            Doca doca = docaServico.cadastrar("Doca 10", "100");

            System.out.println(
                    "[OK] Teste 1 - Doca cadastrada. ID: "
                    + doca.getId());
        } catch (Exception e) {
            System.out.println(
                    "[ERRO] Teste 1 - " + e.getMessage());
        }

        // TESTE 2 - cadastro de uma rota.
        try {
            Rota rota = rotaServico.cadastrar(
                    "Rota A1",
                    "Santos",
                    "Doca 10");

            System.out.println(
                    "[OK] Teste 2 - Rota cadastrada. ID: "
                    + rota.getId());
        } catch (Exception e) {
            System.out.println(
                    "[ERRO] Teste 2 - " + e.getMessage());
        }

        // TESTE 3 - importacao de um arquivo permitido.
        try {
            ArquivoImportado arquivo =
                    importacaoServico.importar("rotas.csv");

            System.out.println(
                    "[OK] Teste 3 - Arquivo aceito: "
                    + arquivo.getNomeArquivo());
        } catch (Exception e) {
            System.out.println(
                    "[ERRO] Teste 3 - " + e.getMessage());
        }

        // TESTE 4 - verifica se rota sem nome e recusada.
        try {
            rotaServico.cadastrar(
                    "",
                    "Santos",
                    "Doca 10");

            System.out.println(
                    "[ERRO] Teste 4 - A rota vazia foi aceita.");
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "[OK] Teste 4 - Rota sem nome foi recusada.");
        }

        System.out.println("==================================");
        System.out.println("FIM DOS TESTES");
        System.out.println("==================================");
    }
}
