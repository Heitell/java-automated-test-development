package com.acme.banking.dbo.domain;

import java.util.Collection;

import static java.util.Collections.unmodifiableCollection;

public class Branch {
    private Collection<Account> accounts; //TODO impl

    public Branch(Collection<Account> accounts) {
        if (accounts == null) throw new IllegalArgumentException();

        this.accounts = accounts;
    }

    public Collection<Account> getAccounts() {
        return unmodifiableCollection(accounts);
    }

    public Collection<Branch> getChildren() {
        //TODO
        return null;
    }
}
