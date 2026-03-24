class Tråder {
    public static void main(String[] args) {
        Runnable HeiRunP = new minRun("Hei IN1010");
        Runnable halloRunP = new minRun("Hallo in1010");

        Thread tråd1 = new Thread(HeiRunP);
        Thread tråd2 = new Thread(halloRunP);

        tråd1.start();
        tråd2.start();
    }
        
}


class minRun implements Runnable {
    String melding;

    public minRun(String melding) {
        this.melding = melding;
    }

    @Override
    public void run() {
        while(true) {
           System.out.println(melding);
        }
    }
}