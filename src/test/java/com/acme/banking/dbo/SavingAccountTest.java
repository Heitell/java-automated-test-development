package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class SavingAccountTest {

    private UUID stubId;
    private Client stubClient;

    @Before
    public void prepareFixture() {
        stubId = UUID.randomUUID();
        stubClient = new Client(UUID.randomUUID(), "stub client name");
    }

    @After
    public void cleanFixture() {
        stubClient = null;
        stubId = null;
    }

    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        //end region

        //region when
        SavingAccount sut = new SavingAccount(stubId, stubClient, 0.0);
        //end region

        //region then
        assertThat(sut.getId(), allOf(equalTo(stubId), notNullValue()));
        //end region
    }

    @Test
    public void shouldReturnClientIdWhenPrompted() {
        //region given
        //end region

        //region when
        SavingAccount sut = new SavingAccount(stubId, stubClient, 0.0);
        //end region

        //region then
        assertThat(sut.getClientId(), allOf(equalTo(stubClient.getId()), notNullValue()));
        //end region
    }

    @Test
    public void shouldReturnClientWhenPrompted() {
        //region given
        //end region

        //region when
        SavingAccount sut = new SavingAccount(stubId, stubClient, 0.0);
        //end region

        //region then
        assertThat(sut.getClient(), allOf(equalTo(stubClient), notNullValue()));
        //end region
    }

    @Test
    public void shouldReturnAmountWhenPrompted() {
        //region given
        double stubAmount = 1.1;
        //end region

        //region when
        SavingAccount sut = new SavingAccount(stubId, stubClient, stubAmount);
        //end region

        //region then
        assertThat(sut.getAmount(), equalTo(stubAmount));
        //end region
    }

    @Test
    public void shouldThrowExceptionWhenNullId() {
        //region given
        //end region

        //region when
        Exception exception = new Exception();
        try {
            SavingAccount sut = new SavingAccount(null, stubClient, 0.0);
        }
        catch(Exception e) {
            exception = e;
        }
        //end region

        //region then
        assertTrue(exception instanceof IllegalArgumentException);
        //end region
    }

    @Test
    public void shouldThrowExceptionWhenNullClient() {
        //region given
        //end region

        //region when
        Exception exception = new Exception();
        try {
            SavingAccount sut = new SavingAccount(stubId, null, 0.0);
        }
        catch(Exception e) {
            exception = e;
        }
        //end region

        //region then
        assertTrue(exception instanceof IllegalArgumentException);
        //end region
    }
}
