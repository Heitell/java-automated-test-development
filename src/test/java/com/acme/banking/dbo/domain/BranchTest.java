package com.acme.banking.dbo.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.assertNull;


public class BranchTest {

    private Collection<Account> stubCollection;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void prepareFixture() {
        stubCollection = new HashSet<>();
    }

    @After
    public void clearFixture() {
        stubCollection = null;
    }

    /*@Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        //end region

        //region when
        Branch sut = new Branch(stubCollection);
        //end region

        //region then
        assertThat(sut.getAccounts(), allOf(equalTo(stubCollection), notNullValue()));
        //end region
    }*/

    @Test
    public void shouldSaveChildrenWhenCreated() {
        //region given
        //end region

        //region when
        Branch sut = new Branch(stubCollection);
        //end region

        //region then
        assertNull(sut.getChildren());
        //end region
    }

    @Test
    public void shouldThrowExceptionWhenNullName() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Accounts can not be null");
        new Branch(null);
    }
}
