
package com.appxcore.agilepro.BaseUtils.Spacex;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpacexLatest implements Serializable, Parcelable
{

    @SerializedName("flight_number")
    @Expose
    private Integer flightNumber;
    @SerializedName("mission_name")
    @Expose
    private String missionName;
    @SerializedName("mission_id")
    @Expose
    private List<Object> missionId = null;
    @SerializedName("launch_year")
    @Expose
    private String launchYear;
    @SerializedName("launch_date_unix")
    @Expose
    private Integer launchDateUnix;
    @SerializedName("launch_date_utc")
    @Expose
    private String launchDateUtc;
    @SerializedName("launch_date_local")
    @Expose
    private String launchDateLocal;
    @SerializedName("is_tentative")
    @Expose
    private Boolean isTentative;
    @SerializedName("tentative_max_precision")
    @Expose
    private String tentativeMaxPrecision;
    @SerializedName("tbd")
    @Expose
    private Boolean tbd;
    @SerializedName("launch_window")
    @Expose
    private Integer launchWindow;
    @SerializedName("rocket")
    @Expose
    private Rocket rocket;
    @SerializedName("ships")
    @Expose
    private List<String> ships = null;
    @SerializedName("telemetry")
    @Expose
    private Telemetry telemetry;
    @SerializedName("launch_site")
    @Expose
    private LaunchSite launchSite;
    @SerializedName("launch_success")
    @Expose
    private Boolean launchSuccess;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("upcoming")
    @Expose
    private Boolean upcoming;
    @SerializedName("static_fire_date_utc")
    @Expose
    private String staticFireDateUtc;
    @SerializedName("static_fire_date_unix")
    @Expose
    private Integer staticFireDateUnix;
    @SerializedName("timeline")
    @Expose
    private Object timeline;
    @SerializedName("crew")
    @Expose
    private Object crew;
    @SerializedName("last_date_update")
    @Expose
    private String lastDateUpdate;
    @SerializedName("last_ll_launch_date")
    @Expose
    private String lastLlLaunchDate;
    @SerializedName("last_ll_update")
    @Expose
    private String lastLlUpdate;
    @SerializedName("last_wiki_launch_date")
    @Expose
    private String lastWikiLaunchDate;
    @SerializedName("last_wiki_revision")
    @Expose
    private String lastWikiRevision;
    @SerializedName("last_wiki_update")
    @Expose
    private String lastWikiUpdate;
    @SerializedName("launch_date_source")
    @Expose
    private String launchDateSource;
    public final static Creator<SpacexLatest> CREATOR = new Creator<SpacexLatest>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SpacexLatest createFromParcel(Parcel in) {
            return new SpacexLatest(in);
        }

        public SpacexLatest[] newArray(int size) {
            return (new SpacexLatest[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1567341106154435213L;

    protected SpacexLatest(Parcel in) {
        this.flightNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.missionName = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.missionId, (Object.class.getClassLoader()));
        this.launchYear = ((String) in.readValue((String.class.getClassLoader())));
        this.launchDateUnix = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.launchDateUtc = ((String) in.readValue((String.class.getClassLoader())));
        this.launchDateLocal = ((String) in.readValue((String.class.getClassLoader())));
        this.isTentative = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.tentativeMaxPrecision = ((String) in.readValue((String.class.getClassLoader())));
        this.tbd = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.launchWindow = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.rocket = ((Rocket) in.readValue((Rocket.class.getClassLoader())));
        in.readList(this.ships, (String.class.getClassLoader()));
        this.telemetry = ((Telemetry) in.readValue((Telemetry.class.getClassLoader())));
        this.launchSite = ((LaunchSite) in.readValue((LaunchSite.class.getClassLoader())));
        this.launchSuccess = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.links = ((Links) in.readValue((Links.class.getClassLoader())));
        this.details = ((String) in.readValue((String.class.getClassLoader())));
        this.upcoming = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.staticFireDateUtc = ((String) in.readValue((String.class.getClassLoader())));
        this.staticFireDateUnix = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.timeline = ((Object) in.readValue((Object.class.getClassLoader())));
        this.crew = ((Object) in.readValue((Object.class.getClassLoader())));
        this.lastDateUpdate = ((String) in.readValue((String.class.getClassLoader())));
        this.lastLlLaunchDate = ((String) in.readValue((String.class.getClassLoader())));
        this.lastLlUpdate = ((String) in.readValue((String.class.getClassLoader())));
        this.lastWikiLaunchDate = ((String) in.readValue((String.class.getClassLoader())));
        this.lastWikiRevision = ((String) in.readValue((String.class.getClassLoader())));
        this.lastWikiUpdate = ((String) in.readValue((String.class.getClassLoader())));
        this.launchDateSource = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public SpacexLatest() {
    }

    /**
     * 
     * @param tentativeMaxPrecision
     * @param staticFireDateUtc
     * @param launchYear
     * @param rocket
     * @param launchDateSource
     * @param launchSite
     * @param launchDateLocal
     * @param lastWikiRevision
     * @param crew
     * @param lastWikiUpdate
     * @param lastLlLaunchDate
     * @param missionName
     * @param launchSuccess
     * @param links
     * @param details
     * @param staticFireDateUnix
     * @param lastDateUpdate
     * @param launchWindow
     * @param missionId
     * @param lastWikiLaunchDate
     * @param lastLlUpdate
     * @param isTentative
     * @param flightNumber
     * @param ships
     * @param tbd
     * @param launchDateUtc
     * @param timeline
     * @param telemetry
     * @param launchDateUnix
     * @param upcoming
     */
    public SpacexLatest(Integer flightNumber, String missionName, List<Object> missionId, String launchYear, Integer launchDateUnix, String launchDateUtc, String launchDateLocal, Boolean isTentative, String tentativeMaxPrecision, Boolean tbd, Integer launchWindow, Rocket rocket, List<String> ships, Telemetry telemetry, LaunchSite launchSite, Boolean launchSuccess, Links links, String details, Boolean upcoming, String staticFireDateUtc, Integer staticFireDateUnix, Object timeline, Object crew, String lastDateUpdate, String lastLlLaunchDate, String lastLlUpdate, String lastWikiLaunchDate, String lastWikiRevision, String lastWikiUpdate, String launchDateSource) {
        super();
        this.flightNumber = flightNumber;
        this.missionName = missionName;
        this.missionId = missionId;
        this.launchYear = launchYear;
        this.launchDateUnix = launchDateUnix;
        this.launchDateUtc = launchDateUtc;
        this.launchDateLocal = launchDateLocal;
        this.isTentative = isTentative;
        this.tentativeMaxPrecision = tentativeMaxPrecision;
        this.tbd = tbd;
        this.launchWindow = launchWindow;
        this.rocket = rocket;
        this.ships = ships;
        this.telemetry = telemetry;
        this.launchSite = launchSite;
        this.launchSuccess = launchSuccess;
        this.links = links;
        this.details = details;
        this.upcoming = upcoming;
        this.staticFireDateUtc = staticFireDateUtc;
        this.staticFireDateUnix = staticFireDateUnix;
        this.timeline = timeline;
        this.crew = crew;
        this.lastDateUpdate = lastDateUpdate;
        this.lastLlLaunchDate = lastLlLaunchDate;
        this.lastLlUpdate = lastLlUpdate;
        this.lastWikiLaunchDate = lastWikiLaunchDate;
        this.lastWikiRevision = lastWikiRevision;
        this.lastWikiUpdate = lastWikiUpdate;
        this.launchDateSource = launchDateSource;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public List<Object> getMissionId() {
        return missionId;
    }

    public void setMissionId(List<Object> missionId) {
        this.missionId = missionId;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Integer getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(Integer launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public Boolean getIsTentative() {
        return isTentative;
    }

    public void setIsTentative(Boolean isTentative) {
        this.isTentative = isTentative;
    }

    public String getTentativeMaxPrecision() {
        return tentativeMaxPrecision;
    }

    public void setTentativeMaxPrecision(String tentativeMaxPrecision) {
        this.tentativeMaxPrecision = tentativeMaxPrecision;
    }

    public Boolean getTbd() {
        return tbd;
    }

    public void setTbd(Boolean tbd) {
        this.tbd = tbd;
    }

    public Integer getLaunchWindow() {
        return launchWindow;
    }

    public void setLaunchWindow(Integer launchWindow) {
        this.launchWindow = launchWindow;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public List<String> getShips() {
        return ships;
    }

    public void setShips(List<String> ships) {
        this.ships = ships;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public Boolean getLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(Boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getStaticFireDateUtc() {
        return staticFireDateUtc;
    }

    public void setStaticFireDateUtc(String staticFireDateUtc) {
        this.staticFireDateUtc = staticFireDateUtc;
    }

    public Integer getStaticFireDateUnix() {
        return staticFireDateUnix;
    }

    public void setStaticFireDateUnix(Integer staticFireDateUnix) {
        this.staticFireDateUnix = staticFireDateUnix;
    }

    public Object getTimeline() {
        return timeline;
    }

    public void setTimeline(Object timeline) {
        this.timeline = timeline;
    }

    public Object getCrew() {
        return crew;
    }

    public void setCrew(Object crew) {
        this.crew = crew;
    }

    public String getLastDateUpdate() {
        return lastDateUpdate;
    }

    public void setLastDateUpdate(String lastDateUpdate) {
        this.lastDateUpdate = lastDateUpdate;
    }

    public String getLastLlLaunchDate() {
        return lastLlLaunchDate;
    }

    public void setLastLlLaunchDate(String lastLlLaunchDate) {
        this.lastLlLaunchDate = lastLlLaunchDate;
    }

    public String getLastLlUpdate() {
        return lastLlUpdate;
    }

    public void setLastLlUpdate(String lastLlUpdate) {
        this.lastLlUpdate = lastLlUpdate;
    }

    public String getLastWikiLaunchDate() {
        return lastWikiLaunchDate;
    }

    public void setLastWikiLaunchDate(String lastWikiLaunchDate) {
        this.lastWikiLaunchDate = lastWikiLaunchDate;
    }

    public String getLastWikiRevision() {
        return lastWikiRevision;
    }

    public void setLastWikiRevision(String lastWikiRevision) {
        this.lastWikiRevision = lastWikiRevision;
    }

    public String getLastWikiUpdate() {
        return lastWikiUpdate;
    }

    public void setLastWikiUpdate(String lastWikiUpdate) {
        this.lastWikiUpdate = lastWikiUpdate;
    }

    public String getLaunchDateSource() {
        return launchDateSource;
    }

    public void setLaunchDateSource(String launchDateSource) {
        this.launchDateSource = launchDateSource;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(flightNumber);
        dest.writeValue(missionName);
        dest.writeList(missionId);
        dest.writeValue(launchYear);
        dest.writeValue(launchDateUnix);
        dest.writeValue(launchDateUtc);
        dest.writeValue(launchDateLocal);
        dest.writeValue(isTentative);
        dest.writeValue(tentativeMaxPrecision);
        dest.writeValue(tbd);
        dest.writeValue(launchWindow);
        dest.writeValue(rocket);
        dest.writeList(ships);
        dest.writeValue(telemetry);
        dest.writeValue(launchSite);
        dest.writeValue(launchSuccess);
        dest.writeValue(links);
        dest.writeValue(details);
        dest.writeValue(upcoming);
        dest.writeValue(staticFireDateUtc);
        dest.writeValue(staticFireDateUnix);
        dest.writeValue(timeline);
        dest.writeValue(crew);
        dest.writeValue(lastDateUpdate);
        dest.writeValue(lastLlLaunchDate);
        dest.writeValue(lastLlUpdate);
        dest.writeValue(lastWikiLaunchDate);
        dest.writeValue(lastWikiRevision);
        dest.writeValue(lastWikiUpdate);
        dest.writeValue(launchDateSource);
    }

    public int describeContents() {
        return  0;
    }

}
