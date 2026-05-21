public class Restaurantbesøk implements Runnable {
    Restaurant restaurant;
    Gjestegruppe gruppe;

    public Restaurantbesøk(Restaurant restaurant, Gjestegruppe gruppe) {
        this.restaurant = restaurant;
        this.gruppe = gruppe;
    }

    public void run() {
        Bord bord = restaurant.taImotGjester(gruppe);
        // restaurant.spise();
        restaurant.forlatBordet(bord);
    }
}
