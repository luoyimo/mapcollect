package excel;

import java.util.Date;

/**
 * @Author hu
 * @Description:
 * @Date Create In 17:08 2019/3/29 0029
 */
public class SimpleObject {

    @ExcelOrderDesc(order = 0, desc = "年龄")
    private Integer age;

    @ExcelOrderDesc(order = 1, desc = "姓名")
    private String name;

    @ExcelOrderDesc(order = 2, desc = "出生日期")
    private Date date;

    @FieldName(fieldName = "date", type = Date.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @FieldName(fieldName = "age", type = Integer.class)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @FieldName(fieldName = "name",type = String.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
