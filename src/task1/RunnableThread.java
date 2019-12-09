package task1;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class RunnableThread implements Runnable {
    private int firstNumber = 0;
    private int secondNumber = 1;
    private int febonachiNumber;
    @Override
    public synchronized void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Write how many numbers of Febonachi you want to see");
        int numbers = sc.nextInt();
        for (int i = 0; i < numbers-1 ; i++) {
            febonachiNumber = firstNumber+secondNumber;
            firstNumber = secondNumber;
            secondNumber = febonachiNumber;
        }

        System.out.print("Потік Runnable:...");
        for (int i = 0; i <numbers-1 ; i++) {
            System.out.print(febonachiNumber+" ");
            secondNumber=firstNumber;
            firstNumber=febonachiNumber-firstNumber;
            febonachiNumber=secondNumber;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("1");
        System.out.println();

    }
}
