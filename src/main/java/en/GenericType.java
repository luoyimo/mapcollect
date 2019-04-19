package en;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.List;

/**
 * @Author hu
 * @Description:
 * @Date Create In 12:00 2019/3/29 0029
 */
public class GenericType {

    @Autowired(required = true)
    private HashMap<Integer, List<String>> myMap;

    @Deprecated
    public HashMap<Integer, List<String>> getMyMap() {
        return myMap;
    }

    @Deprecated
    public void setMyMap(HashMap<Integer, List<String>> myMap) {
        this.myMap = myMap;
    }

    public static void example() throws NoSuchFieldException, NoSuchMethodException {
        ResolvableType t = ResolvableType.forField(GenericType.class.getDeclaredField("myMap"));
        System.out.println(t.getSuperType());

        Autowired myMap = GenericType.class.getDeclaredField("myMap").getAnnotation(Autowired.class);

        Deprecated setMyMap = GenericType.class.getMethod("setMyMap", HashMap.class).getAnnotation(Deprecated.class);

        boolean required = myMap.required();
        System.out.println(required);
        ; // AbstractMap<Integer, List<String>>
        System.out.println(t.asMap()); // Map<Integer, List<String>>
        System.out.println(t.getGeneric(0).resolve()); // Integer
        System.out.println(t.getGeneric(1).resolve()); // List
        System.out.println(t.getGeneric(1)); // List<String>
        System.out.println(t.resolveGeneric(1, 0)); // String
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        example();

        ResolvableType example = ResolvableType.forMethodReturnType(GenericType.class.getMethod("example"));
        System.out.println(example);

    }

}
