package en;

import java.util.Objects;

/**
 * @Author hu
 * @Description:
 * @Date Create In 10:26 2019/3/27 0027
 */
public class Sys {

    private String s;
    public static void main(String[] args) {
        System.out.println(new Object());
        System.out.println(new Object());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sys sys = (Sys) o;
        return Objects.equals(s, sys.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }
}
