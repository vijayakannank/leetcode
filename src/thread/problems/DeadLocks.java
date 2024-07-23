package thread.problems;

/**
 * https://www.quickprogrammingtips.com/java/how-to-create-deadlock-in-java.html
 */

public class DeadLocks {
    String s1 = "s1";
    String s2 = "s2";

    Thread t1 = new Thread(() -> {
        synchronized (s1){
            try {
                System.out.println("started t1 ");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (s2){
                System.out.println("inside t1 s2");
            }
        }
        System.out.println("released lock1 ");
    });

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (s2) {
                try {
                    System.out.println("started t2 ");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s1){
                    System.out.println("inside t2 s1");
                }
            }
            System.out.println("released lock 2");
        }
    });

    public static void main(String[] args) {
        DeadLocks dl = new DeadLocks();
        dl.t1.start();
        dl.t2.start();
    }
}
