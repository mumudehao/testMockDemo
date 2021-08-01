package com.wwj.mockito.lesson07;

import javafx.scene.Parent;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArgumentsatcherTest {

    @Test
    public void basicTest(){
        List<Integer> list  = mock(ArrayList.class);

        when(list.get(0)).thenReturn(100);
        assertThat(list.get(0),equalTo(100));
        assertThat(list.get(1),nullValue());

    }

    /* isA,any */
    @Test
    public void testComplex1(){
        Foo foo = mock(Foo.class);
        when(foo.function(Mockito.isA(Parent.class))).thenReturn(100);
        int result = foo.function(new Child1());
        assertThat(result,equalTo(100));

    }

    @Test
    public void testComplex2(){
        Foo foo = mock(Foo.class);
        when(foo.function(Mockito.isA(Parent.class))).thenReturn(100);
        int result = foo.function(new Child2());
        assertThat(result,equalTo(100));

    }

    @Test
    public void testComplex3(){
        Foo foo = mock(Foo.class);
        when(foo.function(Mockito.isA(Child1.class))).thenReturn(100);
        int result = foo.function(new Child1());
        assertThat(result,equalTo(100));

        int result2 = foo.function(new Child2());
        assertThat(result2,equalTo(0));

    }




    static class Foo{
        int function(Parent p){
            return p.work();
        }
    }

    interface Parent
    {
        int work();
    }

    class Child1 implements Parent{

        @Override
        public int work() {
            throw new RuntimeException();
        }
    }

    class Child2 implements Parent{

        @Override
        public int work() {
            throw new RuntimeException();
        }
    }

}
