public class Gjestegruppe {
    Samling<Gjest> gjester;

    public Gjestegruppe() {
        gjester = new Samling<>(20);
    }

    public boolean noenØnskerVin() {
        for (Gjest gjest : gjester) {
            if (gjest.ønskerVin()) {
                return true;
            }
        }
        return false;
    }
}

