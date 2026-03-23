abstract class Kanin implements Comparable<Kanin>{
    final String navn; protected int vekt; protected int alder;
    Kanin(String nv, int v, int a) {navn=nv; vekt=v; alder=a;}
    @Override
    public int compareTo(Kanin med) {return vekt - med.vekt;}
    public static Kanin største(Kanin en, Kanin to) {
        if (en.compareTo(to) > 0) return en; else return to;
    }
}
class Barnekanin extends Kanin {
    Barnekanin(String nv, int v, int a) {super(nv,v,a);}
    @Override
    public int compareTo(Kanin med){return alder-med.alder;}
}
class Hunnkanin extends Kanin {
    Hunnkanin(String nv, int v, int a) {super(nv,v,a);}
    @Override
    public int compareTo(Kanin med){return navn.compareTo(med.navn);}
}
class Hannkanin extends Kanin {
    Hannkanin(String nv, int v, int a) {super(nv,v,a);}
}
class HovedSammenlign {
    public static void main (String[] args) {
        Kanin en = new Barnekanin("Puck", 6, 2);
        Kanin to = new Barnekanin("Kølle", 5, 3);
        Kanin tre = new Hannkanin("Carsten", 52, 40);
        Kanin fire = new Hannkanin("Jabben", 41, 51);
        Kanin fem = new Hunnkanin("Kine", 36, 32);
        Kanin seks = new Hunnkanin("Anne", 48, 28);
        Kanin syv,åtte,ni,ti,elleve,tolv;
        syv = Kanin.største(en,to);
        åtte = Kanin.største(tre,fire);
        ni = Kanin.største(fem,seks);
        ti = tre.største(en,tre);
        elleve = ti.største(fire,fem);
        tolv = Hunnkanin.største(seks,new Hunnkanin("Eva", 32, 27));

        System.out.println("Kanin 7: " + syv.navn);
        System.out.println("Kanin 8: " + åtte.navn);
        System.out.println("Kanin 9: " + ni.navn);
        System.out.println("Kanin 10: " + ti.navn);
        System.out.println("Kanin 11: " + elleve.navn);
        System.out.println("Kanin 12: " + tolv.navn);
    }
}