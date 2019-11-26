
package com.appxcore.agilepro.BaseUtils.Spacex;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecondStage implements Serializable, Parcelable
{

    @SerializedName("block")
    @Expose
    private Integer block;
    @SerializedName("payloads")
    @Expose
    private List<Payload> payloads = null;
    public final static Creator<SecondStage> CREATOR = new Creator<SecondStage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SecondStage createFromParcel(Parcel in) {
            return new SecondStage(in);
        }

        public SecondStage[] newArray(int size) {
            return (new SecondStage[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4149651816510645456L;

    protected SecondStage(Parcel in) {
        this.block = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.payloads, (Payload.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public SecondStage() {
    }

    /**
     * 
     * @param payloads
     * @param block
     */
    public SecondStage(Integer block, List<Payload> payloads) {
        super();
        this.block = block;
        this.payloads = payloads;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(block);
        dest.writeList(payloads);
    }

    public int describeContents() {
        return  0;
    }

}
