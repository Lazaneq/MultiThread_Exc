

import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    static int liczbaWycinaczy = 2;
    static int liczbPrasowanie = 1;
    static int liczbaMalowania = 2;

    static int pojemnoscTasmy = 15;
    static int pojemnoscStolu = 5;

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> tasma = new ArrayBlockingQueue<Integer>(pojemnoscTasmy);
        ArrayBlockingQueue<Integer> stolJakosci = new ArrayBlockingQueue<Integer>(pojemnoscStolu);

        Wycinanie[] wycinacze = new Wycinanie[liczbaWycinaczy];
        Prasowanie[] prasowacze = new Prasowanie[liczbPrasowanie];
        Malowanie[] malowanie = new Malowanie[liczbaMalowania];

        for (int i=0; i<liczbaWycinaczy; i++){
            wycinacze[i] = new Wycinanie("Wycinacz "+(i+1), tasma);
            wycinacze[i].start();
        }
        for(int i=0; i<liczbPrasowanie; i++){
            prasowacze[i] =new Prasowanie("Prasowacz "+(i+1), tasma, stolJakosci);
            prasowacze[i].start();
        }
        for(int i=0; i<liczbaMalowania; i++){
            malowanie[i] =new Malowanie("Malowacz "+(i+1), tasma);
            malowanie[i].start();
        }
    }
}










