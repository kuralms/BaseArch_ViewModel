
package com.appxcore.agilepro.BaseUtils.Spacex;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rocket implements Serializable, Parcelable
{

    @SerializedName("rocket_id")
    @Expose
    private String rocketId;
    @SerializedName("rocket_name")
    @Expose
    private String rocketName;
    @SerializedName("rocket_type")
    @Expose
    private String rocketType;
    @SerializedName("first_stage")
    @Expose
    private FirstStage firstStage;
    @SerializedName("second_stage")
    @Expose
    private SecondStage secondStage;
    @SerializedName("fairings")
    @Expose
    private Fairings fairings;
    public final static Creator<Rocket> CREATOR = new Creator<Rocket>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Rocket createFromParcel(Parcel in) {
            return new Rocket(in);
        }

        public Rocket[] newArray(int size) {
            return (new Rocket[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5336760751799318154L;

    protected Rocket(Parcel in) {
        this.rocketId = ((String) in.readValue((String.class.getClassLoader())));
        this.rocketName = ((String) in.readValue((String.class.getClassLoader())));
        this.rocketType = ((String) in.readValue((String.class.getClassLoader())));
        this.firstStage = ((FirstStage) in.readValue((FirstStage.class.getClassLoader())));
        this.secondStage = ((SecondStage) in.readValue((SecondStage.class.getClassLoader())));
        this.fairings = ((Fairings) in.readValue((Fairings.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rocket() {
    }

    /**
     * 
     * @param rocketId
     * @param secondStage
     * @param fairings
     * @param rocketType
     * @param rocketName
     * @param firstStage
     */
    public Rocket(String rocketId, String rocketName, String rocketType, FirstStage firstStage, SecondStage secondStage, Fairings fairings) {
        super();
        this.rocketId = rocketId;
        this.rocketName = rocketName;
        this.rocketType = rocketType;
        this.firstStage = firstStage;
        this.secondStage = secondStage;
        this.fairings = fairings;
    }

    public String getRocketId() {
        return rocketId;
    }

    public void setRocketId(String rocketId) {
        this.rocketId = rocketId;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getRocketType() {
        return rocketType;
    }

    public void setRocketType(String rocketType) {
        this.rocketType = rocketType;
    }

    public FirstStage getFirstStage() {
        return firstStage;
    }

    public void setFirstStage(FirstStage firstStage) {
        this.firstStage = firstStage;
    }

    public SecondStage getSecondStage() {
        return secondStage;
    }

    public void setSecondStage(SecondStage secondStage) {
        this.secondStage = secondStage;
    }

    public Fairings getFairings() {
        return fairings;
    }

    public void setFairings(Fairings fairings) {
        this.fairings = fairings;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(rocketId);
        dest.writeValue(rocketName);
        dest.writeValue(rocketType);
        dest.writeValue(firstStage);
        dest.writeValue(secondStage);
        dest.writeValue(fairings);
    }

    public int describeContents() {
        return  0;
    }

}
