import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//во время работы
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE}) //на всякий случай по максималке

public @interface Test {
    int priority();//маркер приоритета
}
