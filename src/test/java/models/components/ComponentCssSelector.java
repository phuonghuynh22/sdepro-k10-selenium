package models.components;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// time to execute
@Retention(value = RetentionPolicy.RUNTIME)

// where to apply this annotation
@Target(value = {ElementType.TYPE})

public @interface ComponentCssSelector {
    String value();
}
