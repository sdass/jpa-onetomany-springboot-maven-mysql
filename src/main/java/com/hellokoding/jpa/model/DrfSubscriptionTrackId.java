package com.hellokoding.jpa.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The "identity" for the drf_subscription_track table.
 *
 * The database has a unique index defined with these attributes
 * which will suffice as an identity.
 *
 * Created by gwiley on 3/1/17.
 */
@Embeddable
public class DrfSubscriptionTrackId implements Serializable {

    @NotNull
    public Integer subscriptionTypeId; //public I did

    @NotNull
    private String trackId;

    @NotNull
    private String country;


    public Integer getSubscriptionTypeId() {
        return subscriptionTypeId;
    }

    public void setSubscriptionTypeId(Integer subscriptionTypeId) {
        this.subscriptionTypeId = subscriptionTypeId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrfSubscriptionTrackId that = (DrfSubscriptionTrackId) o;

        if (subscriptionTypeId != null ? !subscriptionTypeId.equals(that.subscriptionTypeId) : that.subscriptionTypeId != null)
            return false;
        if (trackId != null ? !trackId.equals(that.trackId) : that.trackId != null) return false;
        return country != null ? country.equals(that.country) : that.country == null;
    }

    @Override
    public int hashCode() {
        int result = subscriptionTypeId != null ? subscriptionTypeId.hashCode() : 0;
        result = 31 * result + (trackId != null ? trackId.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DrfSubscriptionTrackId{" +
                "subscriptionTypeId=" + subscriptionTypeId +
                ", trackId='" + trackId + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
