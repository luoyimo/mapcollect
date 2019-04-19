package excel;

import java.lang.annotation.*;

/**
 * @Author hu
 * @Description:
 * @Date Create In 17:56 2019/3/29 0029
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldName {

    String fieldName();

    Class<?> type();
}
