package com.wwj.mockito.lesson03;


import com.wwj.mockito.common.Account;
import com.wwj.mockito.common.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockByRunnerTest {


    @Test
    public void testMock(){
        AccountDao accountDao = mock(AccountDao.class, RETURNS_SMART_NULLS);
        Account account = accountDao.findAccount("x","x");
        System.out.println(account);
    }


}
