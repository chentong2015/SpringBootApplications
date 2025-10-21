package auto_configure;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Import({SystemReportingConfiguration.class, SystemIntegrationConfiguration.class})
public @interface MyEnableAutoConfiguration {
}
