public class Lege implements Comparable<Lege> {

    public final String navn;
    public final IndeksertListe<Resept> utskrevneResepter;

    public Lege(String navn) {
        this.navn = navn;
        utskrevneResepter = new IndeksertListe<Resept>();
    }

    public String hentNavn() {
        return this.navn;
    }

    @Override
    public String toString() {
        return "Navn: " + this.navn;
    }

    @Override
    public int compareTo(Lege annen) {
        return this.navn.compareTo(annen.navn);
    }

    public IndeksertListe<Resept> hentUtskrevneResepter() {
        return utskrevneResepter;
    }

    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {throw new UlovligUtskrift(this, legemiddel);}
        HvitResept resept = new HvitResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(resept);
        return resept;
    }

    public MilitærResept skrivMilitærResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {throw new UlovligUtskrift(this, legemiddel);}
        MilitærResept resept = new MilitærResept(legemiddel, this, pasient);
        utskrevneResepter.leggTil(resept);
        return resept;
    }
    
    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {throw new UlovligUtskrift(this, legemiddel);}
        PResept resept = new PResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(resept);
        return resept;
    }

    public BlåResept skrivBlåResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {throw new UlovligUtskrift(this, legemiddel);}
        BlåResept resept = new BlåResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(resept);
        return resept;
    }

}
