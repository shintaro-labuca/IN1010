class Bil {
    Bil forrige;
    Bil neste;
}
class Billiste {
    Bil første, siste;
    
    public void settInnFør(Bil ny, Bil erILista){
        if (første == null) { // Listen er tom
            første = ny; siste = ny;
        } else { // Først, gjør det en alltid må (og uten å miste noe)
            ny.neste = erILista;
                if (første == erILista) { // Sett inn først
                    første = ny;
                    ny.neste = erILista;
            } else { // Sett inn inne i mellom
                ny.forrige = erILista.forrige;
                erILista.forrige.neste = ny;
                erILista.forrige = ny;
            }
        }
    }
}
