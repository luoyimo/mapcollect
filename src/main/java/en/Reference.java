package en;

import java.lang.ref.SoftReference;

/**
 * @Author hu
 * @Description:
 * @Date Create In 17:07 2019/3/12 0012
 */
public class Reference {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<String> softReference = new SoftReference<>(new String("hello word"));
        System.err.println(softReference.get());
        byte[] bytes1 = new byte[1024 * 1024 * 2];
        System.err.println(softReference.get());
        byte[] bytess = new byte[1000];
        Thread.sleep(1000);
        System.err.println(softReference.get());

//        WeakReference<String>  weakReference = new WeakReference<>(new String("hello world"));
//        System.err.println(weakReference.get());
//        Byte[] bytes1 = new Byte[1024 * 4 ];
//        Thread.sleep(1000);
//        System.err.println(weakReference.get());

//        ReferenceQueue<String> stringReferenceQueue  = new ReferenceQueue<>();
//        PhantomReference<String> phantomReference = new PhantomReference<>("string", stringReferenceQueue);
//        System.err.println(phantomReference.get());
//        System.err.println(stringReferenceQueue);

    }
}
