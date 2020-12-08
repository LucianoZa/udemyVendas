package io.github.lucianoza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) //Anotação obrigatória para criação de anotations
@Retention(RetentionPolicy.RUNTIME) //Anotação obrigatória para criação de anotations
@Autowired
@Qualifier("gato")
public @interface Gato {
}
