package fix;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @Author hu
 * @Description:
 * @Date Create In 11:13 2018/12/4 0004
 */
public class GuavaTest {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(2);

        System.out.println(("1000".hashCode() + "").hashCode());


    }
}
