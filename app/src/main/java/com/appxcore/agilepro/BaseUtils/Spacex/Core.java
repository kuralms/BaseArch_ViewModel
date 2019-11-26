
package com.appxcore.agilepro.BaseUtils.Spacex;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Core implements Serializable, Parcelable
{

    @SerializedName("core_serial")
    @Expose
    private String coreSerial;
    @SerializedName("flight")
    @Expose
    private Integer flight;
    @SerializedName("block")
    @Expose
    private Integer block;
    @SerializedName("gridfins")
    @Expose
    private Boolean gridfins;
    @SerializedName("legs")
    @Expose
    private Boolean legs;
    @SerializedName("reused")
    @Expose
    private Boolean reused;
    @SerializedName("land_success")
    @Expose
    private Boolean landSuccess;
    @SerializedName("landing_intent")
    @Expose
    private Boolean landingIntent;
    @SerializedName("landing_type")
    @Expose
    private String landingType;
    @SerializedName("landing_vehicle")
    @Expose
    private String landingVehicle;
    public final static Creator<Core> CREATOR = new Creator<Core>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Core createFromParcel(Parcel in) {
            return new Core(in);
        }

        public Core[] newArray(int size) {
            return (new Core[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5379583175541273829L;

    protected Core(Parcel in) {
        this.coreSerial = ((String) in.readValue((String.class.getClassLoader())));
        this.flight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.block = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.gridfins = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.legs = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.reused = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.landSuccess = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.landingIntent = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.landingType = ((String) in.readValue((String.class.getClassLoader())));
        this.landingVehicle = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Core() {
    }

    /**
     * 
     * @param flight
     * @param landSuccess
     * @param landingType
     * @param gridfins
     * @param landingIntent
     * @param coreSerial
     * @param legs
     * @param landingVehicle
     * @param block
     * @param reused
     */
    public Core(String coreSerial, Integer flight, Integer block, Boolean gridfins, Boolean legs, Boolean reused, Boolean landSuccess, Boolean landingIntent, String landingType, String landingVehicle) {
        super();
        this.coreSerial = coreSerial;
        this.flight = flight;
        this.block = block;
        this.gridfins = gridfins;
        this.legs = legs;
        this.reused = reused;
        this.landSuccess = landSuccess;
        this.landingIntent = landingIntent;
        this.landingType = landingType;
        this.landingVehicle = landingVehicle;
    }

    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Boolean getGridfins() {
        return gridfins;
    }

    public void setGridfins(Boolean gridfins) {
        this.gridfins = gridfins;
    }

    public Boolean getLegs() {
        return legs;
    }

    public void setLegs(Boolean legs) {
        this.legs = legs;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Boolean getLandSuccess() {
        return landSuccess;
    }

    public void setLandSuccess(Boolean landSuccess) {
        this.landSuccess = landSuccess;
    }

    public Boolean getLandingIntent() {
        return landingIntent;
    }

    public void setLandingIntent(Boolean landingIntent) {
        this.landingIntent = landingIntent;
    }

    public String getLandingType() {
        return landingType;
    }

    public void setLandingType(String landingType) {
        this.landingType = landingType;
    }

    public String getLandingVehicle() {
        return landingVehicle;
    }

    public void setLandingVehicle(String landingVehicle) {
        this.landingVehicle = landingVehicle;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(coreSerial);
        dest.writeValue(flight);
        dest.writeValue(block);
        dest.writeValue(gridfins);
        dest.writeValue(legs);
        dest.writeValue(reused);
        dest.writeValue(landSuccess);
        dest.writeValue(landingIntent);
        dest.writeValue(landingType);
        dest.writeValue(landingVehicle);
    }

    public int describeContents() {
        return  0;
    }

}
