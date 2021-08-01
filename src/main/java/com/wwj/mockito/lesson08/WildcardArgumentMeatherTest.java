package com.wwj.mockito.lesson08;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WildcardArgumentMeatherTest {

    @Mock
    private SimpleService simpleService;

    @After
    public void destoty(){
        reset(simpleService);
    }

    @Test
    public void wildcardMethod1(){
        when(simpleService.method1(anyInt(),anyString(),anyCollection(),isA(Serializable.class))).thenReturn(100);
        int result1 = simpleService.method1(1,"alex", Collections.emptyList(),"Mockito");
        assertThat(result1,equalTo(100));

        int result2 = simpleService.method1(1,"wang", Collections.emptySet(),"MockitoForJava");
        assertThat(result2,equalTo(100));

    }

    @Test
    public void wildcardMethod1WithSpecial(){
        // 全集最大写在最前面
        when(simpleService.method1(anyInt(),anyString(),anyCollection(),isA(Serializable.class))).thenReturn(-1);
        // 个性化的需要写在后面
        when(simpleService.method1(anyInt(),eq("alex"),anyCollection(),isA(Serializable.class))).thenReturn(100);
        when(simpleService.method1(anyInt(),eq("wang"),anyCollection(),isA(Serializable.class))).thenReturn(200);

        int result1 = simpleService.method1(1,"alex", Collections.emptyList(),"Mockito");
        assertThat(result1,equalTo(100));

        int result2 = simpleService.method1(1,"wang", Collections.emptySet(),"MockitoForJava");
        assertThat(result2,equalTo(200));

        int result3 = simpleService.method1(1,"ssss", Collections.emptySet(),"MockitoForJava");
        assertThat(result3,equalTo(-1));

    }

    @Test
    public void wiidcardMethod2(){
        List<Object> emptyList  = Collections.emptyList();
        doNothing().when(simpleService).method2(anyInt(),anyString(),anyCollection(),isA(Serializable.class));
        simpleService.method2(1,"alex", emptyList,"Mockito");
        verify(simpleService,times(1)).method2(1,"alex", emptyList,"Mockito");
        verify(simpleService,times(1)).method2(anyInt(),eq("alex"), anyCollection(),isA(Serializable.class));

    }



}
