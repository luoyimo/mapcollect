package excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author hu
 * @Description:
 * @Date Create In 17:28 2019/3/29 0029
 */
public class Demo {

    private static Map<String, Method> methodMap = new HashMap<>();

    private static Map<String, ExcelOrderDesc> filedAn = new HashMap<>();

    private static Map<String, Class> returnMap = new HashMap<>();


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        getFieldAnMap();
        getMethodMap();
        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setAge(11);
        simpleObject.setName("hello world");
        simpleObject.setDate(new Date());

        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = workbook.createSheet("详细");
        for (int i = 0; i < 10; i++) {
            SXSSFRow row = sheet.createRow(i);
            for (String s : filedAn.keySet()) {
                Object invoke = methodMap.get(s).invoke(simpleObject);
                int order = filedAn.get(s).order();
                Class cl = returnMap.get(s);
                System.out.println(order);
                System.out.println(invoke);
                row.createCell(order).setCellValue(invoke.toString());
            }
        }
        writeAndUpload(workbook, "hello.xls");
    }


    public static void writeAndUpload(Workbook workbook, String name) {
        String filePath = "D://" + name;
        File file = new File(filePath);
        try {
            workbook.write(new FileOutputStream(file));
        } catch (IOException e) {
        } finally {
            try {
                if (workbook != null) {
                    SXSSFWorkbook sxssfWorkbook = (SXSSFWorkbook) workbook;
                    sxssfWorkbook.dispose();
                }
            } catch (Exception e) {
            }
        }
    }

    public static void getFieldAnMap() {
        Field[] fields = SimpleObject.class.getDeclaredFields();

        for (Field f : fields) {
            f.setAccessible(true);
            filedAn.put(f.getName(), f.getAnnotation(ExcelOrderDesc.class));
        }
    }

    public static void getMethodMap() {
        Method[] methods = SimpleObject.class.getMethods();
        for (Method method : methods) {
            FieldName annotation = method.getAnnotation(FieldName.class);
            String name = method.getName();
            if (name.startsWith("get") && Objects.nonNull(annotation)) {
                System.out.println(annotation);
                methodMap.put(annotation.fieldName(), method);
                returnMap.put(annotation.fieldName(), annotation.type());
            }
        }
    }


}
