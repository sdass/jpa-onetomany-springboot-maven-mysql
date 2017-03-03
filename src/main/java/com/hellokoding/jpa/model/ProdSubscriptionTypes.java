package com.hellokoding.jpa.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * An entity for the prod.prod_subscription_types table
 *
 * Created by gwiley on 1/27/17.
 */
@Entity
//@Table( schema = "prod" )
public class ProdSubscriptionTypes {

    // Strayed from pure JPA and used Hibernate's GenericGenerator
    // because this table has a primary key that isn't an identity
    // column. Using the increment strategy causes Hibernate to
    // select the max id and increment it. We don't create
    // these entities very often so this should be acceptable
    // and avoids setup issues for a sequence or identity table.
    //
    // The GenericGenerator didn't honor the Table schema above
    // so we specify the full table name as a parameter.
    //
    // More info at https://goo.gl/UGkaWA
    @Id
    @GeneratedValue(generator="subscriptionTypeIdIncrement")
    @GenericGenerator(name = "subscriptionTypeIdIncrement",
            strategy = "increment",
            parameters = { @Parameter(name = "tables", value = "prod_subscription_types") })
    private Integer subscriptionTypeId;

    private String description;

    private Integer numberOfTracks;

    private BigDecimal price;

    private String subscriptionType;

    @Convert(converter=BooleanToStringConverter.class)
    private Boolean subscriptionEnable;

    private String url;

    @Convert(converter=StringToTrimmedStringConverter.class)
    private String expirationDateType;

    private String expirationDateValue;

    @Convert(converter=BooleanToStringConverter.class)
    private Boolean renewableIndicator;

    private Timestamp subscriptionBeginDate;

    private String planLevel;

    private String planType;

    private Integer priorityOrder;

    @Convert(converter=BooleanToStringConverter.class)
    private Boolean propickIndicator;

    @Convert(converter=BooleanToStringConverter.class)
    private Boolean drfPlusIndicator;

    @Convert(converter=BooleanToStringConverter.class)
    private Boolean trialPlanIndicator;

    @Convert(converter=BooleanToStringConverter.class)
    private Boolean oneClickEligibleInd;

    private String drfPlusType;

    /*
    @Convert(converter=BooleanToVideoTypeIdConverter.class)
    @Column(name="video_type_id")
    private Boolean videoIndicator;
*/
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.subscriptionTypeId", cascade = CascadeType.ALL)
    private List<DrfSubscriptionTrack> tracks;


    public ProdSubscriptionTypes() { }

    public Integer getSubscriptionTypeId() {
        return subscriptionTypeId;
    }

    public void setSubscriptionTypeId(Integer subscriptionTypeId) {
        this.subscriptionTypeId = subscriptionTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(Integer numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Boolean getSubscriptionEnable() {
        return subscriptionEnable;
    }

    public void setSubscriptionEnable(Boolean subscriptionEnable) {
        this.subscriptionEnable = subscriptionEnable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpirationDateType() {
        return expirationDateType;
    }

    public void setExpirationDateType(String expirationDateType) {
        this.expirationDateType = expirationDateType;
    }

    public String getExpirationDateValue() {
        return expirationDateValue;
    }

    public void setExpirationDateValue(String expirationDateValue) {
        this.expirationDateValue = expirationDateValue;
    }

    public Boolean getRenewableIndicator() {
        return renewableIndicator;
    }

    public void setRenewableIndicator(Boolean renewableIndicator) {
        this.renewableIndicator = renewableIndicator;
    }

    public Timestamp getSubscriptionBeginDate() {
        return subscriptionBeginDate;
    }

    public void setSubscriptionBeginDate(Timestamp subscriptionBeginDate) {
        this.subscriptionBeginDate = subscriptionBeginDate;
    }

    public String getPlanLevel() {
        return planLevel;
    }

    public void setPlanLevel(String planLevel) {
        this.planLevel = planLevel;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public Integer getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(Integer priorityOrder) {
        this.priorityOrder = priorityOrder;
    }

    public Boolean getPropickIndicator() {
        return propickIndicator;
    }

    public void setPropickIndicator(Boolean propickIndicator) {
        this.propickIndicator = propickIndicator;
    }

    public Boolean getDrfPlusIndicator() {
        return drfPlusIndicator;
    }

    public void setDrfPlusIndicator(Boolean drfPlusIndicator) {
        this.drfPlusIndicator = drfPlusIndicator;
    }

    public Boolean getTrialPlanIndicator() {
        return trialPlanIndicator;
    }

    public void setTrialPlanIndicator(Boolean trialPlanIndicator) {
        this.trialPlanIndicator = trialPlanIndicator;
    }

    public Boolean getOneClickEligibleInd() {
        return oneClickEligibleInd;
    }

    public void setOneClickEligibleInd(Boolean oneClickEligibleInd) {
        this.oneClickEligibleInd = oneClickEligibleInd;
    }

    public String getDrfPlusType() {
        return drfPlusType;
    }

    public void setDrfPlusType(String drfPlusType) {
        this.drfPlusType = drfPlusType;
    }
/*

    public Boolean getVideoIndicator() {
        return videoIndicator;
    }


    public void setVideoIndicator(Boolean videoIndicator) {
        this.videoIndicator = videoIndicator;
    }
*/

    public List<DrfSubscriptionTrack> getTracks() {
        return tracks;
    }

    public void setTracks(List<DrfSubscriptionTrack> drfSubscriptionTracks) {
        this.tracks = drfSubscriptionTracks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdSubscriptionTypes that = (ProdSubscriptionTypes) o;

        return subscriptionTypeId != null ? subscriptionTypeId.equals(that.subscriptionTypeId) : that.subscriptionTypeId == null;
    }

    @Override
    public int hashCode() {
        return subscriptionTypeId != null ? subscriptionTypeId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ProdSubscriptionTypes{" +
                "subscriptionTypeId=" + subscriptionTypeId +
                ", description='" + description + '\'' +
                ", numberOfTracks=" + numberOfTracks +
                ", price=" + price +
                ", subscriptionType='" + subscriptionType + '\'' +
                ", subscriptionEnable=" + subscriptionEnable +
                ", url='" + url + '\'' +
                ", expirationDateType='" + expirationDateType + '\'' +
                ", expirationDateValue='" + expirationDateValue + '\'' +
                ", renewableIndicator=" + renewableIndicator +
                ", subscriptionBeginDate=" + subscriptionBeginDate +
                ", planLevel='" + planLevel + '\'' +
                ", planType='" + planType + '\'' +
                ", priorityOrder=" + priorityOrder +
                ", propickIndicator=" + propickIndicator +
                ", drfPlusIndicator=" + drfPlusIndicator +
                ", trialPlanIndicator=" + trialPlanIndicator +
                ", oneClickEligibleInd=" + oneClickEligibleInd +
                ", drfPlusType='" + drfPlusType + '\'' +
                //", videoIndicator=" + videoIndicator +
                ", drfSubscriptionTracks=" + tracks +
                '}';
    }
}
