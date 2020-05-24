package com.acme.banking.dbo.domain;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Nested;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ClientTest {

    private UUID dummyId;
    private String dummyName;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public final TestRule globalTimeout = Timeout.seconds(2);

    @Before
    public void prepareFixture() {
        dummyId = UUID.randomUUID();
        dummyName = "dummy client name";
    }

    @Test
    public void shouldSaveIdWhenCreated() {
        //region given
        //endregion

        //region when
        Client sut = new Client(dummyId, "dummy client name");
        //endregion

        //region then
        assertThat(sut.getId(), equalTo(dummyId));
        //endregion
    }

    @Test
    public void shouldSaveNameWhenCreated() {
        //region given
        //end region

        //region when
        Client sut = new Client(UUID.randomUUID(), "dummy client name");
        //end region

        //region then
        assertThat(sut.getName(), equalTo(dummyName));
        //end region
    }

    @Test
    public void shouldThrowExceptionWhenNullId() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Id can not be null");
        new Client(null, dummyName);
    }

    @Test
    public void shouldThrowExceptionWhenNullName() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Name can not be null");
        new Client(dummyId, null);
    }
}
