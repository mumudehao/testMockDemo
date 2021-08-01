package com.wwj.mockito.lesson03;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

public class DeepMockTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Lesson03Service lesson03Service;

    @Mock
    private Lesson03 lesson03;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    //stubbling
    @Test
    public void testDeepMock(){

        when(lesson03Service.get()).thenReturn(lesson03);
        Lesson03 l03 = lesson03Service.get();
        l03.foo();

        //stubbling
        lesson03Service.get().foo();
    }

}
