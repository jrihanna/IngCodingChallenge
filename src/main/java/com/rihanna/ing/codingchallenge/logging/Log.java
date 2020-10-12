package com.rihanna.ing.codingchallenge.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A customised Log annotation for the Logging Aspect
 * @see com.rihanna.ing.codingchallenge.logging.LoggingAspect
 * @author reihanesadat.zekri
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {

}
