package com.wwj.mockito.lesson10;


import org.junit.Test;

import static com.wwj.mockito.lesson10.CompareNumber1.gt;
import static com.wwj.mockito.lesson10.CompareNumber1.lt;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompareNumber1Test {

    @Test
    public void testInt(){
        assertThat(10,gt(8));
    }

    @Test
    public void testFloat(){
        assertThat(10.55,gt(8.1));
    }

    @Test
    public void testInt1(){
        assertThat(10,lt(18));
    }

    @Test
    public void testInt3(){
        assertThat(10,both(gt(8)).and(lt(12)));
    }
}
