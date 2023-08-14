import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class Wycinanie extends Thread{
    private ArrayBlockingQueue<Integer> kolejka;
    private static AtomicInteger ID= new AtomicInteger(1);

    static int getNextID(){
        return ID.getAndIncrement();
    }

    public Wycinanie(String name, ArrayBlockingQueue<Integer> kolejka) {
        super(name);
        this.kolejka = kolejka;
    }

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                int id = getNextID();
                    System.out.printf(super.getName() + " wycial produkt:  " + id + "\n");
                Thread.sleep(150);
                kolejka.put(id);
                System.out.println("Oddano element: "+ id);
                    System.out.printf("Stan kolejki Wycinanie:" + kolejka + "\n");

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}