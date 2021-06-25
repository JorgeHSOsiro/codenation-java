package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {
    @Override
    public BigDecimal somar(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        BigDecimal result = BigDecimal.ZERO;
        for ( Field field : fields) {
            if (field.isAnnotationPresent(Somar.class)) {
                field.setAccessible(true);
                result = result.add((BigDecimal) field.get(object));
            }
        }
        return result;
    }

    @Override
    public BigDecimal subtrair(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        BigDecimal result = BigDecimal.ZERO;
        for ( Field field : fields) {
            if (field.isAnnotationPresent(Subtrair.class)){
                field.setAccessible(true);
                result = result.add((BigDecimal) field.get(object));
            }

        }
        return result;
    }

    @Override
    public BigDecimal totalizar(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        BigDecimal soma = BigDecimal.ZERO;
        BigDecimal subtracao = BigDecimal.ZERO;
        for ( Field field : fields) {
            if (field.isAnnotationPresent(Somar.class)) {
                field.setAccessible(true);
                soma = soma.add( (BigDecimal) field.get(object));
            } else if(field.isAnnotationPresent(Subtrair.class)) {
                field.setAccessible(true);
                subtracao = subtracao.add((BigDecimal) field.get(object));
            }
        }

        return soma.subtract(subtracao);
    }
}
