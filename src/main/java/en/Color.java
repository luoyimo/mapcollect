package en;

import java.util.Objects;

/**
 * @Author hu
 * @Description:
 * @Date Create In 11:08 2019/1/25 0025
 */
public enum Color {

    RED(1, "hongse"), GREEN(2, "lvse");

    private Integer sort;
    private String desc;


    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Color getColor(Integer sort) {
        for (Color color : Color.values()) {
            if (Objects.equals(color.getSort(), 2)) {
                return color;
            }
        }
        return null;
    }


    Color(Integer sort, String desc) {
        this.sort = sort;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Color{" +
                "sort=" + sort +
                ", desc='" + desc + '\'' + name() + ordinal()+
        '}';
    }

    public static void main(String[] args) {
        Color s = null;
        for (Color color : Color.values()) {
            System.out.println(color.name());
            ;
            if (Objects.equals(color.getSort(), 2)) {
                s = color;
                break;
            }

        }

        System.out.println(Color.class.getSuperclass());

        System.out.println(s);
        Color color = Color.valueOf(Color.class, "RED");
        System.out.println(color);
    }
}
