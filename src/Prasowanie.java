import java.util.concurrent.ArrayBlockingQueue;

class Prasowanie extends Thread{
    ArrayBlockingQueue<Integer> kolejka;
    ArrayBlockingQueue<Integer> kolejkaDoStolu;

    public Prasowanie(String name, ArrayBlockingQueue<Integer> kolejka, ArrayBlockingQueue<Integer> kolejkaDoStolu) {
        super(name);
        this.kolejka = kolejka;
        this.kolejkaDoStolu=kolejkaDoStolu;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                int x = kolejka.take();
                System.out.println("Stan kolejki po zabraniu elementu: " + kolejka);
                Thread.sleep(200);
                kolejkaDoStolu.put(x);
                System.out.println("Stan kolejki Prasowanie: " + kolejkaDoStolu);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
