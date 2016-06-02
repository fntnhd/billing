package com.blueagility.billing.entity;

import java.time.LocalDateTime;

/**
 * Specifies the amount of minutes used by an account
 *
 * Created by MrSteveAndrews on 11/8/15.
 */
public class AccountUsage {

    private Account account;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
