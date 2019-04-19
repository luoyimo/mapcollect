package excel;

import java.lang.annotation.*;

/**
 * @Author hu
 * @Description:
 * @Date Create In 17:09 2019/3/29 0029
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelOrderDesc {

    int order() default 0;

    String desc();

}
