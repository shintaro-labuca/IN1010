import java.util.Scanner;
class Stoppeklokke {
    public static void main(String[] args) {
        Runnable klokkeRun = new Klokke();
        Thread klokkeTråd = new Thread(klokkeRun);

        klokkeTråd.start();

        Scanner tastatur = new Scanner(System.in);
        tastatur.nextLine();
        klokkeTråd.interrupt();
        tastatur.close();
    }
}

class Klokke implements Runnable {
    @Override
    public void run() {
        int tid = 0;
        while(true) {
            System.out.println(tid + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            tid++;
        }
    }
}