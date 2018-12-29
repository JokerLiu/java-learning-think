package com.interview.concurrency;

/**
 * @Author: Joker
 * @Description:
 * @Date: Created in 2018/12/29 15:41
 */
public class Q2VolatileAndSynchronized {

    /*
    public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // class com/interview/concurrency/Q2VolatileAndSynchronized
       2: dup
       3: astore_1
       4: monitorenter
       5: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
       8: ldc           #4                  // String asd
      10: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      13: aload_1
      14: monitorexit
      15: goto          23
      18: astore_2
      19: aload_1
      20: monitorexit
      21: aload_2
      22: athrow
      23: invokestatic  #6                  // Method test:()V
      26: return
     */
    public static void main(String[] args) {
        // 4: monitorenter
        // 14: monitorexit
        synchronized (Q2VolatileAndSynchronized.class) {
            System.out.println("asd");
        }
        test();
    }

    public static synchronized void test() {

    }
}