package by.devincubator.banklist.entity;

import java.io.Serializable;

public class Account implements Identifiable, Serializable {

    private Integer accountId;
    private Integer account;
    private Integer id;

    public Account(){

    }

    public Account(Integer accountId, Integer account, Integer id) {
        this.id = id;
        this.accountId = accountId;
        this.account = account;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public Integer getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account1 = (Account) o;

        if (id != null ? !id.equals(account1.id) : account1.id != null) return false;
        if (accountId != null ? !accountId.equals(account1.accountId) : account1.accountId != null) return false;
        return account != null ? account.equals(account1.account) : account1.account == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", account=" + account +
                '}';
    }


}
