package routeplanner.tela;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import routeplanner.modelo.Rota;
import routeplanner.servico.RotaServico;

public class TelaRota extends JFrame {

    private final RotaServico service;
    private final JTextField txtNome = new JTextField();
    private final JTextField txtDestino = new JTextField();
    private final JTextField txtDoca = new JTextField();

    public TelaRota(RotaServico service) {
        this.service = service;

        setTitle("Cadastro de Rotas");
        setSize(400, 230);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(4, 2, 6, 6));
        painel.add(new JLabel("Nome da rota:"));
        painel.add(txtNome);
        painel.add(new JLabel("Destino:"));
        painel.add(txtDestino);
        painel.add(new JLabel("Doca:"));
        painel.add(txtDoca);

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
            Rota rota = service.cadastrar(
                    txtNome.getText(),
                    txtDestino.getText(),
                    txtDoca.getText());

            JOptionPane.showMessageDialog(
                    this,
                    "Rota cadastrada. ID: " + rota.getId());

            limpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void limpar() {
        txtNome.setText("");
        txtDestino.setText("");
        txtDoca.setText("");
    }
}

