package com.wwj.mockito.lesson09;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertMatcherTest {

    @Test
    public void test1(){
        int i =10;

        assertThat(i,equalTo(10));
        assertThat(i,not(equalTo(101)));
        assertThat(i,is(10));
        assertThat(i,is(not(20)));

    }

    @Test
    public void test2(){
        double price =10.22;

        assertThat(price,either(equalTo(10.22)).or(equalTo(10)));

        assertThat(price,both(equalTo(10.22)).and(equalTo(10.22)));
        assertThat(price,both(equalTo(10.22)).and(not(equalTo(10))));

        assertThat(price,anyOf(is(10.11),is(10.22)));

        assertThat(Stream.of(1,2,3).anyMatch(i->i>2),equalTo(true));
        assertThat(Stream.of(1,2,3).anyMatch(i->i>0),equalTo(true));

    }

    @Test
    public void test3() {
        double price = 10.23;

        assertThat("the double value assertion faild",price, either(equalTo(10.22)).or(equalTo(10)));


    }

}
