import java.util.concurrent.locks.ReentrantLock;

/**
 * Java中的可重入锁的定义，线程中的方法再调用锁的方法可以直接调用
 * ！！！好处，不容易造成死锁！！
 * ReentrantLock和synchronized都是可重入锁！
 * Created by 18362 on 2017/11/24.
 */
public class ReentrantLockAndSynchro implements Runnable {
    public synchronized void get() {
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getName());
        get();
    }

    @Override
    public void run() {
        get();
    }
    public static void main(String args[])
    {
        ReentrantLock lock=new ReentrantLock();
    }
}
