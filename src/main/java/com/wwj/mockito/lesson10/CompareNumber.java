package com.wwj.mockito.lesson10;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;

public class CompareNumber<T extends Number> extends BaseMatcher<T> {

    private final T value;

    private final boolean great;

    public CompareNumber(T value,boolean great) {
        this.value = value;
        this.great = great;
    }

    @Override
    public boolean matches(Object actual) {
        Class<?> clazz = actual.getClass();
        if (clazz == Integer.class){
            return great ? (Integer) actual > (Integer) value : (Integer) actual < (Integer) value;
        }
        else if (clazz == Short.class){
            return  great ? (Short) actual > (Short) value : (Short) actual < (Short) value;
        }
        else if (clazz == Byte.class){
            return  great ? (Byte) actual > (Byte) value : (Byte) actual < (Byte) value;
        }
        else if (clazz == Double.class){
            return  great ? (Double) actual > (Double) value : (Double) actual < (Double) value;
        }
        else if (clazz == Float.class){
            return  great ? (Float) actual > (Float) value : (Float) actual < (Float) value;
        }
        else if (clazz == Long.class){
            return  great ? (Long) actual > (Float) value : (Long) actual < (Float) value;
        }
        else {
            throw new AssertionError("The number type " + clazz + "not supported");        }
    }

    @Factory
    public static <T extends Number> CompareNumber<T> gt(T value){
        return new CompareNumber<>(value,true);
    }

    @Factory
    public static <T extends Number> CompareNumber<T> lt(T value){
        return new CompareNumber<>(value,false);
    }


    @Override
    public void describeTo(Description description) {
        description.appendText("Compare two number failed.");

    }
}
