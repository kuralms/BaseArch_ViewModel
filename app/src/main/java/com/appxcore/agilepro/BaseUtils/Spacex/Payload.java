
package com.appxcore.agilepro.BaseUtils.Spacex;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload implements Serializable, Parcelable
{

    @SerializedName("payload_id")
    @Expose
    private String payloadId;
    @SerializedName("norad_id")
    @Expose
    private List<Integer> noradId = null;
    @SerializedName("reused")
    @Expose
    private Boolean reused;
    @SerializedName("customers")
    @Expose
    private List<String> customers = null;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("payload_type")
    @Expose
    private String payloadType;
    @SerializedName("payload_mass_kg")
    @Expose
    private Integer payloadMassKg;
    @SerializedName("payload_mass_lbs")
    @Expose
    private Double payloadMassLbs;
    @SerializedName("orbit")
    @Expose
    private String orbit;
    @SerializedName("orbit_params")
    @Expose
    private OrbitParams orbitParams;
    @SerializedName("uid")
    @Expose
    private String uid;
    public final static Creator<Payload> CREATOR = new Creator<Payload>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Payload createFromParcel(Parcel in) {
            return new Payload(in);
        }

        public Payload[] newArray(int size) {
            return (new Payload[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8623216990946546146L;

    protected Payload(Parcel in) {
        this.payloadId = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.noradId, (Integer.class.getClassLoader()));
        this.reused = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.customers, (String.class.getClassLoader()));
        this.nationality = ((String) in.readValue((String.class.getClassLoader())));
        this.manufacturer = ((String) in.readValue((String.class.getClassLoader())));
        this.payloadType = ((String) in.readValue((String.class.getClassLoader())));
        this.payloadMassKg = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.payloadMassLbs = ((Double) in.readValue((Double.class.getClassLoader())));
        this.orbit = ((String) in.readValue((String.class.getClassLoader())));
        this.orbitParams = ((OrbitParams) in.readValue((OrbitParams.class.getClassLoader())));
        this.uid = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Payload() {
    }

    /**
     * 
     * @param payloadId
     * @param payloadMassLbs
     * @param uid
     * @param noradId
     * @param nationality
     * @param payloadType
     * @param payloadMassKg
     * @param customers
     * @param orbit
     * @param reused
     * @param orbitParams
     * @param manufacturer
     */
    public Payload(String payloadId, List<Integer> noradId, Boolean reused, List<String> customers, String nationality, String manufacturer, String payloadType, Integer payloadMassKg, Double payloadMassLbs, String orbit, OrbitParams orbitParams, String uid) {
        super();
        this.payloadId = payloadId;
        this.noradId = noradId;
        this.reused = reused;
        this.customers = customers;
        this.nationality = nationality;
        this.manufacturer = manufacturer;
        this.payloadType = payloadType;
        this.payloadMassKg = payloadMassKg;
        this.payloadMassLbs = payloadMassLbs;
        this.orbit = orbit;
        this.orbitParams = orbitParams;
        this.uid = uid;
    }

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public List<Integer> getNoradId() {
        return noradId;
    }

    public void setNoradId(List<Integer> noradId) {
        this.noradId = noradId;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    public Integer getPayloadMassKg() {
        return payloadMassKg;
    }

    public void setPayloadMassKg(Integer payloadMassKg) {
        this.payloadMassKg = payloadMassKg;
    }

    public Double getPayloadMassLbs() {
        return payloadMassLbs;
    }

    public void setPayloadMassLbs(Double payloadMassLbs) {
        this.payloadMassLbs = payloadMassLbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public OrbitParams getOrbitParams() {
        return orbitParams;
    }

    public void setOrbitParams(OrbitParams orbitParams) {
        this.orbitParams = orbitParams;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(payloadId);
        dest.writeList(noradId);
        dest.writeValue(reused);
        dest.writeList(customers);
        dest.writeValue(nationality);
        dest.writeValue(manufacturer);
        dest.writeValue(payloadType);
        dest.writeValue(payloadMassKg);
        dest.writeValue(payloadMassLbs);
        dest.writeValue(orbit);
        dest.writeValue(orbitParams);
        dest.writeValue(uid);
    }

    public int describeContents() {
        return  0;
    }

}
