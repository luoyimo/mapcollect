package en;

import java.util.Map;

/**
 * @Author hu
 * @Description:
 * @Date Create In 15:02 2019/1/29 0029
 */
public class CastMap {
    public static void main(String[] args) {
        Object object = new Object();
        Map<Object, Object> map = (Map<Object, Object>) object;
        for (Object object1 : map.values()
        ) {
            System.out.println(object1);

        }
    }
}
