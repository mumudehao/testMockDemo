package com.wwj.mockito.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
class AccountLoginControllerTest {

    private AccountDao accountDao;
    private HttpServletRequest request;
    private AccountLoginController accountLoginController;


    @BeforeEach
    public void setUp(){
        this.accountDao = mock(AccountDao.class);
        this.request = mock(HttpServletRequest.class);
        this.accountLoginController = new AccountLoginController(accountDao);
    }

    @Test
    void testLoginSuccess() {
        Account account = new Account();
        when(request.getParameter("userName")).thenReturn("userName1");
        when(request.getParameter("password")).thenReturn("password1");
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(account);
        assertThat(accountLoginController.login(request) , equalTo("/index"));
    }

    @Test
    void testLoginFailed() {
        Account account = new Account();
        when(request.getParameter("userName")).thenReturn("userName2");
        when(request.getParameter("password")).thenReturn("password2");
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(null);
        assertThat(accountLoginController.login(request), equalTo("/login"));
    }

    @Test
    void testLogin505() {
        Account account = new Account();
        when(request.getParameter("userName")).thenReturn("userName3");
        when(request.getParameter("password")).thenReturn("password3");
        when(accountDao.findAccount(anyString(),anyString())).thenThrow(UnsupportedOperationException.class);
        assertThat(accountLoginController.login(request), equalTo("/505"));
    }

}