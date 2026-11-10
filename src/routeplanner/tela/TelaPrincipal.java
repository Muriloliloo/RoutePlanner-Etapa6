package routeplanner.tela;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import routeplanner.repositorio.DocaRepositorio;
import routeplanner.repositorio.RotaRepositorio;
import routeplanner.servico.DocaServico;
import routeplanner.servico.ImportacaoServico;
import routeplanner.servico.RotaServico;

public class TelaPrincipal extends JFrame {

    private final RotaServico rotaService;
    private final DocaServico docaService;
    private final ImportacaoServico importacaoService;

    public TelaPrincipal() {
        rotaService = new RotaServico(new RotaRepositorio());
        docaService = new DocaServico(new DocaRepositorio());
        importacaoService = new ImportacaoServico();

        setTitle("Route Planner - Etapa 6");
        setSize(420, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titulo = new JLabel("Route Planner", JLabel.CENTER);
        JButton btnRotas = new JButton("Cadastro de Rotas");
        JButton btnDocas = new JButton("Cadastro de Docas");
        JButton btnImportacao = new JButton("Importar Arquivo");

        btnRotas.addActionListener(e -> new TelaRota(rotaService).setVisible(true));
        btnDocas.addActionListener(e -> new TelaDoca(docaService).setVisible(true));
        btnImportacao.addActionListener(e -> new TelaImportacao(importacaoService).setVisible(true));

        JPanel painel = new JPanel(new GridLayout(4, 1, 8, 8));
        painel.add(titulo);
        painel.add(btnRotas);
        painel.add(btnDocas);
        painel.add(btnImportacao);

        add(painel);
    }
}

