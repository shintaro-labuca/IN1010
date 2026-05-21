import javax.swing.*;
import java.awt.event.*;

public class GUIBoilerplate {
        public void visVindu() {
        JFrame vindu = new JFrame("Tittel");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        // Tekst/melding
        JLabel tekst = new JLabel("Din tekst her");
        panel.add(tekst);

        // Tekstfelt for String-input
        JTextField felt = new JTextField(10);
        panel.add(new JLabel("Ledetekst:"));
        panel.add(felt);

        // Tekstfelt for tall-input
        JTextField tallFelt = new JTextField(10);
        panel.add(new JLabel("Tall:"));
        panel.add(tallFelt);

        // Dropdown med valgmuligheter
        JComboBox<String> valg = new JComboBox<>();
        valg.addItem("Alternativ 1");
        valg.addItem("Alternativ 2");
        panel.add(valg);

        // Avkrysningsboks
        JCheckBox boks = new JCheckBox("Avkrysning");
        panel.add(boks);

        // Knapp med ActionListener som håndterer klikk
        class Handler implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                // Hent tekst fra JTextField
                String tekstVerdi = felt.getText();

                // Hent tall fra JTextField og konverter til int
                int tallVerdi = Integer.parseInt(tallFelt.getText());

                // Hent valgt alternativ fra JComboBox
                String valgtVerdi = (String) valg.getSelectedItem();

                // Sjekk om JCheckBox er avkrysset
                boolean avkrysset = boks.isSelected();

                // Lag objekt: new Gjest med verdiene og legg inn i datastruktur: restaurant., med kall
                // f.eks: restaurant.leggTil(new Gjest(tekstVerdi"navn", tallVerdi"alder"));

                // Lukk vinduet (for meldingsvindu) eller la det stå åpent (for inputvindu)
                vindu.setVisible(false);
            }
        }

        JButton ok = new JButton("OK");
        ok.addActionListener(new Handler());
        panel.add(ok);

        // Pakk og vis vinduet
        vindu.pack();
        vindu.setVisible(true);
    }
}

