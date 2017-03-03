package com.hellokoding.jpa.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * An entity for the drf_subscription_track table
 *
 * Created by gwiley on 3/1/17.
 */
@Entity
public class DrfSubscriptionTrack {

    @EmbeddedId
    private DrfSubscriptionTrackId id;

        /* data
        203 DMS USA
        203 SAR USA
         */
    @ManyToOne
    @JoinColumn(name = "subscription_type_id")
    public DrfSubscriptionTrackId getId() {
        return id;
    }

    public void setId(DrfSubscriptionTrackId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrfSubscriptionTrack that = (DrfSubscriptionTrack) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DrfSubscriptionTrack{" +
                "id=" + id +
                '}';
    }
}
