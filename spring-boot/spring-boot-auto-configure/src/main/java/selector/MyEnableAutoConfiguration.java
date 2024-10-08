package selector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
// @AutoConfigurationPackage
@Import({MyAutoConfigImportSelector.class})
public @interface MyEnableAutoConfiguration {
}
