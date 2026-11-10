package routeplanner.tela;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import routeplanner.modelo.Doca;
import routeplanner.servico.DocaServico;

public class TelaDoca extends JFrame {

    private final DocaServico service;
    private final JTextField txtNome = new JTextField();
    private final JTextField txtCapacidade = new JTextField();

    public TelaDoca(DocaServico service) {
        this.service = service;

        setTitle("Cadastro de Docas");
        setSize(380, 190);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(3, 2, 6, 6));
        painel.add(new JLabel("Nome da doca:"));
        painel.add(txtNome);
        painel.add(new JLabel("Capacidade:"));
        painel.add(txtCapacidade);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnLimpar = new JButton("Limpar");

        btnSalvar.addActionListener(e -> salvar());
        btnLimpar.addActionListener(e -> limpar());

        painel.add(btnSalvar);
        painel.add(btnLimpar);

        add(painel);
    }

    private void salvar() {
        try {
            Doca doca = service.cadastrar(
                    txtNome.getText(),
                    txtCapacidade.getText());

            JOptionPane.showMessageDialog(
                    this,
                    "Doca cadastrada. ID: " + doca.getId());

            limpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Verifique os dados informados.");
        }
    }

    private void limpar() {
        txtNome.setText("");
        txtCapacidade.setText("");
    }
}

