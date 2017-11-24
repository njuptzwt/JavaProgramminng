import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**锁接口Lock()和实现类ReentrantLock()，可重入锁类实现
 * 与synchronized区别
 * 1、自己手动加锁，手动解锁，更灵活
 * 2、修饰的是代码块，synchronizized修饰方法和代码块
 * 3、提供tryLock()的方法！
 * Created by 18362 on 2017/11/24.
 */
public class PrintQueue {
    private final Lock lock=new ReentrantLock();//可重入锁
    public void printjob(Object job)
    {
        lock.lock();//线程获取重入锁
        try {
            System.out.println(Thread.currentThread().getName()+":"+
            "PrintQueue:printing a job during "+(2000/1000)+"seconsds");
            System.out.printf("%s: The document has been printed\n",
                    Thread.currentThread().getName());
            Thread.sleep(2000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();//线程手动的释放锁，和synchronized区别
        }
    }

}
