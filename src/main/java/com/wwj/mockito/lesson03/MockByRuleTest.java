package com.wwj.mockito.lesson03;

import com.wwj.mockito.common.Account;
import com.wwj.mockito.common.AccountDao;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

public class MockByRuleTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private AccountDao accountDao;

    @Test
    public void testMock(){
        Account account = accountDao.findAccount("x","x");
        System.out.println(account);
    }

}
