package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ClientTest {

    private UUID stubId;
    private String name;

    @Before
    public void prepareFixture() {
        stubId = UUID.randomUUID();
        name = "dummy client name";
    }

    @After
    public void clearFixture() {
        stubId = null;
        name = null;
    }

    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        //endregion

        //region when
        Client sut = new Client(stubId, "dummy client name");
        //endregion

        //region then
        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
        //endregion
    }

    @Test
    public void shouldReturnNameWhenPrompted() {
        //region given
        //end region

        //region when
        Client sut = new Client(UUID.randomUUID(), "dummy client name");
        //end region

        //region then
        assertThat(sut.getName(),
                allOf(
                        equalTo(name),
                        notNullValue()
                ));
        //end region
    }

    @Test
    public void shouldThrowExceptionWhenNullId() {
        //region given
        //end region

        //region when
        Exception exception = new Exception();
        try {
            Client sut = new Client(null, name);
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
    public void shouldThrowExceptionWhenNullName() {
        //region given
        //end region

        //region when
        Exception exception = new Exception();
        try {
            Client sut = new Client(stubId, null);
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
