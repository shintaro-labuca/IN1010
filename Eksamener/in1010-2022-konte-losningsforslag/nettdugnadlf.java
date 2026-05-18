import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Skrevet av Dag Langmyhr
// Lett modifisert av Stein Gjessing
// Sist modifisert av SG kl 22:15 den 21. juli
// Aller sist modifisert av DL kl 15:50 den 39. august.


// Oppgave 1
class Måling {
    Måling neste = null;
    int antall = 1;
    int tid;
    double dB;
    
    Måling (int t, double v) {
	tid = t;  dB = v;
    }
}


// Oppgave 2
class MestStøyANT {
    final int ANT;
    Måling[] mest;
    private int antHittil = 0;

    // Invariant: Hvis antHittil < ANT: mest[0..antHittil] inneholder alle målinger
    //            Ellers: mest[0..ANT-1] inneholder de ANT største målingene

    MestStøyANT (int a) {
	ANT = a;  mest = new Måling[ANT];
    }

    public void settInnANT (Måling m) {
	if (antHittil < ANT) {
	    mest[antHittil] = m;  ++antHittil;
	    return;
	}

	// Finn minste verdi:
	int minPos = 0;
	for (int i = 1;  i < ANT;  ++i)
	    if (mest[i].dB < mest[minPos].dB)
		minPos = i;

	// Hvis den nye målingen er større enn den minste hittil,
	// sett den inn.
	if (m.dB > mest[minPos].dB)
	    mest[minPos] = m;
    }

    public Måling[] hentUtANT () {
	Måling[] res = new Måling[antHittil];
	for (int i = 0;  i < antHittil;  ++i)
	    res[i] = mest[i];
	return res;
    }

    // Hjelperutine til oppgave 9 (iterasjon)
    double sumStøy () {
	double sum = 0;
	for (int i = 0;  i < antHittil;  ++i)
	    sum += mest[i].dB;
	return sum;
    }
}


// Oppgave 4
class Sted {
    final int ANT;
    Måling første = null, siste = null;
    MestStøyANT mestStøy;
    String navn;
    double maksStøy = 0;

    Sted (String n, int a) {
	navn = n;  ANT = a;
	mestStøy = new MestStøyANT(ANT);
    }

    void settInnMåling (Måling inn) {
	mestStøy.settInnANT(inn);

	if (inn.dB > maksStøy)
	    maksStøy = inn.dB;

	if (første == null) {
	    første = inn;  siste = inn;
	    return;
	}

	if (inn.tid >= siste.tid) {
	    siste.neste = inn;
	    siste = inn;
	}
    }
    

    // Oppgave 5
    void slåSammen () {
	Måling m = første;
	while (m != null && m.neste != null) {
	    if (m.tid == m.neste.tid) {
		// Slå sammen m og m.neste:
		m.dB = 
		    (m.antall*m.dB + m.neste.antall*m.neste.dB) /
		    (m.antall + m.neste.antall);
		m.antall += m.neste.antall;
		m.neste = m.neste.neste;
	    } else {
		m = m.neste;
	    }
	}
    }

    Måling[] hentUtANT () {
	return mestStøy.hentUtANT();
    }

    double hentMaksStøy () {
	return maksStøy;
    }
}


// Oppgave 7
class Gate {
    String navn;
    StedListe steder;

    Gate (String n) {
	navn = n;  steder = new StedListe();
    }

    // Oppgave 9  (iterasjon)
    Måling[] finnMestStøyANT () {
	Sted støySted = null;
	double maksSum = 0;	
	for (Sted s: steder) {
	    if (støySted == null || s.mestStøy.sumStøy() > maksSum) {
		støySted = s;  maksSum = s.mestStøy.sumStøy();
	    }
	}
	return støySted.hentUtANT();
    }

    // Oppgave 12  Start på rekursjon
    double maksStøyR() {
	return steder.maksListeR();
    }
}


// Oppgave 7
class StedListe implements Iterable<Sted> {
    StedNode første = null, siste = null;

    class StedNode {
	StedNode neste = null, forrige = null;
	Sted sted;

	// Oppgave 10 Rekursjon
	double maksListeR() {
	    double støyHer = sted.hentMaksStøy();
	    if (neste == null)
		return støyHer;
	    double restMaks = neste.maksListeR();
	    if (støyHer > restMaks)
		return støyHer;
	    else
		return restMaks;
	}
    }
    
    // Iterator, oppgave 8
    public Iterator<Sted> iterator () {
	return new StedIterator();
    }

    class StedIterator implements Iterator<Sted> {
	StedNode p = første;

	public boolean hasNext () {
	    return p != null;
	}

	public Sted next () {
	    Sted res = p.sted;
	    p = p.neste;
	    return res;
	}
    }
    
    // Oppgave 11  Start på rekursjon i listen
    double maksListeR() {
	if (første == null)
	    return 0;
	else
	    return første.maksListeR();
    }
}


// Oppgave 13
class By {
    ArrayList<Gate> gater = new ArrayList<>();
    HashMap<String,Sted> steder = new HashMap<>();

    // Oppgave 14, GUI
    // Metode som kalles fra GUI-vinduet.
    // (Den burde vært laget mer robust.)
    void nyRegistrering (String sted, String tid, String dB) throws FeilStedUnntak {
	Sted s = steder.get(sted);
	if (s == null) 
	    throw new FeilStedUnntak(sted);

	int t = Integer.parseInt(tid);
	double d = Double.parseDouble(dB);
	s.settInnMåling(new Måling(t, d));
    }
}

class FeilStedUnntak extends Exception {
    FeilStedUnntak (String t) {
	super(t);
    }
}


// Oppgave 14
class GUI {
    By minBy;
    JFrame vindu = null;
    JPanel panel;
    JButton ok;
    JLabel stedLab, tidLab, dBLab;
    JTextField sted, tid, dB;

    GUI (By b) {
	minBy = b;
    }

    class OKHandler implements ActionListener {
	@Override
	    public void actionPerformed (ActionEvent e) {
	    try{
		minBy.nyRegistrering(sted.getText().trim(),
				     tid.getText().trim(), dB.getText().trim());
	    } catch (FeilStedUnntak f) { 
		System.out.println("Ukjent sted: " + f.getMessage()); 
		System.out.println();
	    }
	}
    }

    void lagStøyVindu () {
	try {
	    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	} catch (Exception e) { System.exit(1); }
	vindu = new JFrame("Registrer støy");
	vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	panel = new JPanel();
	vindu.add(panel);

	stedLab = new JLabel("Sted:");
	sted = new JTextField("                   ");
	panel.add(stedLab);  panel.add(sted);
	tidLab = new JLabel("Tid:");
	tid = new JTextField("           ");
	panel.add(tidLab);  panel.add(tid);
	dBLab = new JLabel("dB:");
	dB = new JTextField("           ");
	panel.add(dBLab);  panel.add(dB);
	ok = new JButton("OK");
	ok.addActionListener(new OKHandler());
	panel.add(ok);
	vindu.pack();
	sted.setText("                ");
	tid.setText("           ");
	dB.setText("           ");
	vindu.setVisible(true);
    }
}
