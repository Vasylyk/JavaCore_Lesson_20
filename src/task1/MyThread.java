package task1;

import java.util.Scanner;

public class MyThread extends Thread {
    private int firstNumber = 0;
    private int secondNumber = 1;
    private int febonachiNumber;
    @Override
    public synchronized void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many numbers of Febonachi you want to see");
        int numbers = sc.nextInt();
        System.out.print("Потік Thread: ");
        System.out.print("1 ");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < numbers-1 ; i++) {
            febonachiNumber = firstNumber+secondNumber;
            System.out.print(febonachiNumber+" ");
            firstNumber=secondNumber;
            secondNumber=febonachiNumber;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("...");
        System.out.println();

    }
}
