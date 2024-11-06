package auto_configure_selector;

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
