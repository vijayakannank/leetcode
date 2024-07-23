package thread.problems;

import java.util.LinkedList;

public class ConsumerProducer {
    public static void main(String[] args) throws InterruptedException {
        Pc pc = new Pc();
        Thread producer = new Thread(() -> {
            try {
                pc.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread( () -> {
            try {
                pc.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

    }


}

class Pc {
    LinkedList list = new LinkedList();
    int counter;
    int max = 2;


    void producer() throws InterruptedException {
        while(true){
            synchronized (this){
                while(list.size() == max)
                    wait();
                System.out.println("producer producing data for -"+counter);
                list.add(counter++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    void consumer() throws InterruptedException {
        while(true){
            synchronized (this){
                while (list.size() == 0)
                    wait();
                System.out.println("consumer consumed - "+list.get(0));
                list.removeFirst();
                notify();
                Thread.sleep(1000);
            }

        }
    }
}
