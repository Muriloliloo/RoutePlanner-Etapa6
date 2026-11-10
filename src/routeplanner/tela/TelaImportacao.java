package routeplanner.tela;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import routeplanner.modelo.ArquivoImportado;
import routeplanner.servico.ImportacaoServico;

public class TelaImportacao extends JFrame {

    private final ImportacaoServico service;
    private final JTextField txtArquivo = new JTextField();
    private final JLabel lblStatus = new JLabel("STATUS: aguardando arquivo");

    public TelaImportacao(ImportacaoServico service) {
        this.service = service;

        setTitle("ImportaÃ§Ã£o de Arquivo");
        setSize(520, 180);
        setLocationRelativeTo(null);

        JButton btnProcurar = new JButton("Procurar");
        JButton btnImportar = new JButton("Importar");

        btnProcurar.addActionListener(e -> procurar());
        btnImportar.addActionListener(e -> importar());

        JPanel botoes = new JPanel();
        botoes.add(btnProcurar);
        botoes.add(btnImportar);

        add(txtArquivo, BorderLayout.NORTH);
        add(botoes, BorderLayout.CENTER);
        add(lblStatus, BorderLayout.SOUTH);
    }

    private void procurar() {
        JFileChooser seletor = new JFileChooser();

        if (seletor.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            txtArquivo.setText(
                    seletor.getSelectedFile().getAbsolutePath());
        }
    }

    private void importar() {
        try {
            ArquivoImportado arquivo =
                    service.importar(txtArquivo.getText());

            lblStatus.setText(
                    "STATUS: " + arquivo.getNomeArquivo() + " importado.");
        } catch (Exception e) {
            lblStatus.setText("STATUS: " + e.getMessage());
        }
    }
}

