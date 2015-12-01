package com.matisia.billing.entity;

import java.time.LocalDateTime;

/**
 * A billing period specifies the start and end dates for which bills will be generated.
 *
 * Created by MrSteveAndrews on 11/11/15.
 */
public class BillingPeriod {

    private String name;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}
