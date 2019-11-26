
package com.appxcore.agilepro.BaseUtils.Spacex;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FirstStage implements Serializable, Parcelable
{

    @SerializedName("cores")
    @Expose
    private List<Core> cores = null;
    public final static Creator<FirstStage> CREATOR = new Creator<FirstStage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FirstStage createFromParcel(Parcel in) {
            return new FirstStage(in);
        }

        public FirstStage[] newArray(int size) {
            return (new FirstStage[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4055211574225180008L;

    protected FirstStage(Parcel in) {
        in.readList(this.cores, (Core.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public FirstStage() {
    }

    /**
     * 
     * @param cores
     */
    public FirstStage(List<Core> cores) {
        super();
        this.cores = cores;
    }

    public List<Core> getCores() {
        return cores;
    }

    public void setCores(List<Core> cores) {
        this.cores = cores;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(cores);
    }

    public int describeContents() {
        return  0;
    }

}
