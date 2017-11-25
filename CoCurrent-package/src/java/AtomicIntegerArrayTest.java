import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by 18362 on 2017/11/24.
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[]{1, 2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        System.out.println(ai.getAndSet(0, 3));
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }

}
