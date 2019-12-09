package task1;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RunnableThread runnableThread = new RunnableThread();
        Thread t = new Thread(runnableThread);
        t.run();
    }
}
