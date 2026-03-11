class Katt implements Comparable<Katt> {
    private String navn;
    private int alder;

    public Katt(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    public String toString() {
        return "Navn: " + navn + " Alder: " + alder;
    }

    public int compareTo (Katt annen) {
        return 0;
    }
}