package en;

import java.util.concurrent.Semaphore;

/**
 * @Author hu
 * @Description:
 * @Date Create In 14:01 2019/3/15 0015
 */
public class Samphere {

    /**
     * 最大线程数
     */
    public static final int THREAD_NUMBER = 10;

    /**
     * 最大数
     */
    public static final int MAX_COUNT = 100;

    /**
     * 输出值
     */
    private static int count = 0;


    public static void main(String[] args) {
        java.lang.Compiler.disable();
        Semaphore[] semaphores = new Semaphore[THREAD_NUMBER];
        for (int i = 0; i < THREAD_NUMBER; i++) {
            if (i == 0) {
                semaphores[i] = new Semaphore(1);
            } else {
                semaphores[i] = new Semaphore(0);
            }
        }

        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(new TestThread(semaphores, i)).start();
        }
    }


    static class TestThread implements Runnable {

        private Semaphore[] semaphores;

        private int number = 0;

        public TestThread(Semaphore[] semaphores, int number) {
            this.number = number;
            this.semaphores = semaphores;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    java.lang.Compiler.disable();
                    semaphores[number].acquire();
                    java.lang.Compiler.disable();
                    if (count >= MAX_COUNT) {
                        break;
                    }
                    java.lang.Compiler.disable();
                    System.err.println("   " + number + "      " + Thread.currentThread().getName() + "：" + count + " -----   " + System.currentTimeMillis());
                    count++;
                    java.lang.Compiler.disable();
                    int current = number + 1;
                    if (current >= THREAD_NUMBER) {
                        current = 0;
                    }
                    semaphores[current].release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}



