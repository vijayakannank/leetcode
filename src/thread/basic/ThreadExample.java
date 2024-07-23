package thread.basic;

public class ThreadExample {
    public static void main(String[] args) {
      ThreadExample te   = new ThreadExample();
//      te.runnableEx();

      ThreadEx ex = new ThreadEx();
        // this will be executed by creating thread
        ex.start();
        // this will call like normal call and executed by main thread. thread function should be called by start function.
        ex.run();
    }

    void runnableEx(){
        Runnable r = () ->{
            System.out.println("runnable ex");
        };
        Thread t = new Thread(r);
        t.start();

        Thread t1 = new Thread(() -> System.out.println("lambda with runnable"));
        t1.start();
    }
}

class ThreadEx extends Thread{
    public void run() {
        System.out.println("in thread run "+currentThread().getName());
    }
}
