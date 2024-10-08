package enable_auto_configure;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
// @AutoConfigurationPackage
@Import({AutoConfigImportSelector.class})
public @interface MyEnableAutoConfiguration {
}
