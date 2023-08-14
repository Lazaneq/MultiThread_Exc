import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class Malowanie extends Thread {
    ArrayBlockingQueue<Integer> kolejka;
    private static AtomicInteger magazyn = new AtomicInteger(0);

    public Malowanie(String name, ArrayBlockingQueue<Integer> kolejka) {
        super(name);
        this.kolejka = kolejka;
    }

    public static AtomicInteger getMagazyn() {
        return magazyn;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                    System.out.println("Stan kolejki przed malowaniem:" + kolejka );
                kolejka.take();
                Thread.sleep(100);
                    System.out.println("Pomalowano element i oddano do magazynu.");
                magazyn.getAndIncrement();
                    System.out.println("Stan magazynu: " + getMagazyn());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

