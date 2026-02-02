/*
What do you mean by thread and multithreading? Write a progrem
to create three threads so that one thread print even numbers
between 1 and 10 in 1 sec, another thread print odd numbers
between 11 and 20 in 2 secs, and third thread print prime numbers
between 21 and 30 in 3 secs simultaneousty. 
*/

// thread in multi threading is a light weight unit of execution within a process.
// multithreading is a process of executing multiple threads simultaneously to maximize CPU utilization.
// so multi threading boosts the performance of the applicaion 

// the program demonstrated multi threading in java let's discuss how
// we create three threads to print even, odd and prime numbers in specified intervals
// what if there was no interval ? the program would have printed all the numbers at once by executing the threads concurrently
// but with the help of sleep method we can pause the execution of a thread for a specified time 

// class NumberThread extends Thread {
//     //giving custom implementation the run method to define the task for the thread
//     public void run() {
//         try {
//             // Even numbers between 1 and 10
//             for (int i = 2; i <= 10; i += 2) {
//                 System.out.println("Even: " + i);
//                 Thread.sleep(1000); // 1 sec
//             }

//             // Odd numbers between 11 and 20
//             for (int i = 11; i <= 20; i += 2) {
//                 System.out.println("Odd: " + i);
//                 Thread.sleep(2000); // 2 secs
//             }

//             // Prime numbers between 21 and 30
//             for (int i = 21; i <= 30; i++) {
//                 if (isPrime(i)) {
//                     System.out.println("Prime: " + i);
//                     Thread.sleep(3000); // 3 secs
//                 }
//             }
//         } catch (InterruptedException e) {
//             System.out.println("Thread interrupted: " + e.getMessage());
//         }
//     }

//     private boolean isPrime(int num) {
//         if (num <= 1) return false;
//         for (int i = 2; i <= Math.sqrt(num); i++) {
//             if (num % i == 0) return false;
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         NumberThread numberThread = new NumberThread();
//         numberThread.start();
//     }
// }


class NumberThread implements Runnable {
    private int timeInSeconds;

    public NumberThread(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public void run() {
        try {
            if (this.timeInSeconds == 1) {
                // Even numbers between 1 and 10
                for (int i = 2; i <= 10; i += 2) {
                    System.out.println("Even: " + i);
                    Thread.sleep(1000); // 1 sec
                }
            } else if (this.timeInSeconds == 2) {
                // Odd numbers between 11 and 20
                for (int i = 11; i <= 20; i += 2) {
                    System.out.println("Odd: " + i);
                    Thread.sleep(2000); // 2 secs
                }
            } else if (this.timeInSeconds == 3) {
                // Prime numbers between 21 and 30
                for (int i = 21; i <= 30; i++) {
                    if (isPrime(i)) {
                        System.out.println("Prime: " + i);
                        Thread.sleep(3000); // 3 secs
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Thread evenThread = new Thread(new NumberThread(1));
        Thread oddThread = new Thread(new NumberThread(2));
        Thread primeThread = new Thread(new NumberThread(3));

        evenThread.start();
        oddThread.start();
        primeThread.start();
    }
}