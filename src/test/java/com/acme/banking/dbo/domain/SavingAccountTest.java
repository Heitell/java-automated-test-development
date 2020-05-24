package com.acme.banking.dbo.domain;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SavingAccountTest {

    private UUID stubId;
    private Client stubClient;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void prepareFixture() {
        stubId = UUID.randomUUID();
        stubClient = new Client(UUID.randomUUID(), "stub client name");
    }

    @Test
    public void shouldSaveIdWhenCreated() {
        //region given
        //end region

        //region when
        SavingAccount sut = new SavingAccount(stubId, stubClient, 0.0);
        //end region

        //region then
        assertThat(sut.getId(), equalTo(stubId));
        //end region
    }

    @Test
    public void shouldSaveClientIdWhenCreated() {
        //region given
        //end region

        //region when
        SavingAccount sut = new SavingAccount(stubId, stubClient, 0.0);
        //end region

        //region then
        assertThat(sut.getClientId(), equalTo(stubClient.getId()));
        //end region
    }

    @Test
    public void shouldSaveClientWhenCreated() {
        //region given
        //end region

        //region when
        SavingAccount sut = new SavingAccount(stubId, stubClient, 0.0);
        //end region

        //region then
        assertThat(sut.getClient(), equalTo(stubClient));
        //end region
    }

    @Test
    public void shouldSaveAmountWhenCreated() {
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
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Id can not be null");
        new SavingAccount(null, stubClient, 0.0);
    }

    @Test
    public void shouldThrowExceptionWhenNullClient() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Client can not be null");
        new SavingAccount(stubId, null, 0.0);
    }

    @Test
    public void shouldSetAccountUUIDForClientWhenCreated() {
        SavingAccount sut = new SavingAccount(stubId, stubClient, 0.0);
        assertTrue(stubClient.getAccountIds().contains(stubId));
    }
}
