package org.wfeng.testclient.rest.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by wfeng on 2017/4/24.
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
