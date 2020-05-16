package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Branch;
import com.acme.banking.dbo.domain.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BranchTest {

    private Collection<Account> stubCollection;

    @Before
    public void prepareFixture() {
        stubCollection = new HashSet<Account>();
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
    public void shouldReturnChildrenWhenPrompted() {
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
        //region given
        //end region

        //region when
        Exception exception = new Exception();
        try {
            Branch sut = new Branch(null);
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
