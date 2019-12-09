package task2;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class FisxedThreadService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many numbers of Febonachi you want to see");
        int numbers = sc.nextInt();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int firstNumber = 0;
                int secondNumber = 1;
                int febonachiNumber;
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
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int firstNumber = 0;
                int secondNumber = 1;
                int febonachiNumber = 0;
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
        });
        executor.shutdown();
    }
}
