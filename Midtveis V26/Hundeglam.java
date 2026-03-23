public class Hundeglam {
    public static void main(String[] args) {
        Hund h1, h2, h3;
        h1 = new Hund("Voff-voff");
        h2 = new Hund("Bjeff-bjeff");
        h2 = h1;
        h1 = null;

        h3 = h2;
        h3.bjeff();

    }
}
    
    class Hund {
        private String voff;

        Hund(String bjeff) {voff = bjeff;}

        public void bjeff() {System.out.println(voff);}
    }

