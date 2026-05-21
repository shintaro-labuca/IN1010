// import java.awt.event.*;
// import javax.swing.*;
import java.util.concurrent.locks.*;

public class Restaurant {
    Samling<Ansatt> ansatte;
    Samling<Bord> antallBord;

    ReentrantLock lås = new ReentrantLock(); // Monitor
    Condition ventPåBord = lås.newCondition(); // Monitor

    public Restaurant() {
        ansatte = new Samling<>(25);
        antallBord = new Samling<>(15);
    }


    public Kelner finnMinstÅGjøre(boolean erVinkelner) {
        Kelner minstHittil = null;
        for (Ansatt ansatt : ansatte) {
            if (erVinkelner && ansatt instanceof Vinkelner || !erVinkelner && ansatt instanceof Kelner) {
                Kelner kelner = (Kelner) ansatt;
                if (minstHittil == null || kelner.hentAntallServerer() < minstHittil.hentAntallServerer()) {
                    minstHittil = kelner;
                }
            } 
        }
        return minstHittil;
    }

    public Bord taImotGjester(Gjestegruppe gruppe) {
        lås.lock();
        try {
            Bord gyldigBord = null;
            boolean trengerVinkelner = gruppe.noenØnskerVin();

            while (gyldigBord == null) {
                for (Bord bord : antallBord) {
                    if (bord.plasser >= gruppe.gjester.antall() && bord.gjestegruppe == null) {
                        gyldigBord = bord;
                        break;
                    } 
                }

                if (gyldigBord == null) {
                    try {
                        ventPåBord.await();
                    } catch (InterruptedException e){
                        //
                    }
                }
            }


            // if (gyldigBord == null) {
            //     visVindu();
            //     return;
            // }

            Kelner gyldigKelner = this.finnMinstÅGjøre(trengerVinkelner);

            gyldigBord.gjestegruppe = gruppe;
            gyldigBord.kelner = gyldigKelner;
            gyldigKelner.bordBetjent.settInn(gyldigBord);

            return gyldigBord;
        } finally {
            lås.unlock();
        }
    }


    public void forlatBordet(Bord bord) {
        lås.lock();
        try {
            bord.gjestegruppe = null;
            bord.kelner = null;
            ventPåBord.signalAll();
        } finally {
            lås.unlock();
        }
    }

    // private void visVindu() {
    //     JFrame vindu = new JFrame ("Melding");
    //     vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //     JPanel panel = new JPanel();
    //     vindu.add(panel);

    //     JLabel tekst = new JLabel("Beklager, restauranten er full!");
    //     panel.add(tekst);

    //     class Handler implements ActionListener {
    //         public void actionPerformed(ActionEvent e) {
    //             vindu.setVisible(false);
    //         }
    //     }
        
    //     JButton ok = new JButton("OK");
    //     ok.addActionListener(new Handler());
    //     panel.add(ok);

    //     vindu.pack();
    //     vindu.setVisible(true);

    // }




}
