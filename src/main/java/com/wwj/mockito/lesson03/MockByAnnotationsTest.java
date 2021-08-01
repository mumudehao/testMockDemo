package com.wwj.mockito.lesson03;

import com.wwj.mockito.common.Account;
import com.wwj.mockito.common.AccountDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockByAnnotationsTest {

    @Before
    public void Init(){
        MockitoAnnotations.openMocks(this);
    }

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AccountDao accountDao;

    @Test
    public void testMock(){
        Account account = new Account();
        System.out.println(account);

    }

}
