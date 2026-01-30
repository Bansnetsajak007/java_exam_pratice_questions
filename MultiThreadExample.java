class NumberThread extends Thread {
    private int start, end, delay;
    private String type;

    public NumberThread(int start, int end, int delay, String type) {
        this.start = start;
        this.end = end;
        this.delay = delay;
        this.type = type;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if ((type.equals("Even") && i % 2 == 0) ||
                (type.equals("Odd") && i % 2 != 0) ||
                (type.equals("Prime") && isPrime(i))) {
                System.out.println(type + ": " + i);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

public class MultiThreadExample {
    public static void main(String[] args) {
        new NumberThread(1, 10, 1000, "Even").start();
        new NumberThread(11, 20, 2000, "Odd").start();
        new NumberThread(21, 30, 3000, "Prime").start();
    }
}
