
package com.appxcore.agilepro.BaseUtils.Spacex;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fairings implements Serializable, Parcelable
{

    @SerializedName("reused")
    @Expose
    private Boolean reused;
    @SerializedName("recovery_attempt")
    @Expose
    private Boolean recoveryAttempt;
    @SerializedName("recovered")
    @Expose
    private Boolean recovered;
    @SerializedName("ship")
    @Expose
    private Object ship;
    public final static Creator<Fairings> CREATOR = new Creator<Fairings>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Fairings createFromParcel(Parcel in) {
            return new Fairings(in);
        }

        public Fairings[] newArray(int size) {
            return (new Fairings[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2370074997571836749L;

    protected Fairings(Parcel in) {
        this.reused = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.recoveryAttempt = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.recovered = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.ship = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fairings() {
    }

    /**
     * 
     * @param recovered
     * @param recoveryAttempt
     * @param ship
     * @param reused
     */
    public Fairings(Boolean reused, Boolean recoveryAttempt, Boolean recovered, Object ship) {
        super();
        this.reused = reused;
        this.recoveryAttempt = recoveryAttempt;
        this.recovered = recovered;
        this.ship = ship;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Boolean getRecoveryAttempt() {
        return recoveryAttempt;
    }

    public void setRecoveryAttempt(Boolean recoveryAttempt) {
        this.recoveryAttempt = recoveryAttempt;
    }

    public Boolean getRecovered() {
        return recovered;
    }

    public void setRecovered(Boolean recovered) {
        this.recovered = recovered;
    }

    public Object getShip() {
        return ship;
    }

    public void setShip(Object ship) {
        this.ship = ship;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(reused);
        dest.writeValue(recoveryAttempt);
        dest.writeValue(recovered);
        dest.writeValue(ship);
    }

    public int describeContents() {
        return  0;
    }

}
