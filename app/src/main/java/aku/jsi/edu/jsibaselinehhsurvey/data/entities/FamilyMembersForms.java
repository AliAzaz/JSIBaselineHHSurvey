package aku.jsi.edu.jsibaselinehhsurvey.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import aku.jsi.edu.jsibaselinehhsurvey.core.CONSTANTS;

@Entity(tableName = CONSTANTS.TABLE_FAMILY_MEMBERS)
public class FamilyMembersForms implements Serializable {

    @Ignore
    private final String _projectName = "JSI - Family Members";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String uuid = "";
    private String uid = "";
    private String formDate = ""; // Date
    private String username = ""; // Interviewer
    private String participantID = ""; // Child ID
    private String participantName = ""; // Child Name
    private String sa1 = "";     // Section 1
    private String istatus = "";
    private String endtime = "";
    private String clustercode = "";
    private String districtname = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";

    @Ignore
    public FamilyMembersForms(FamilyMembersForms forms) {

        this.uuid = forms.uuid;
        this.uid = forms.uid;
        this.formDate = forms.formDate;
        this.username = forms.username;
        this.participantID = forms.participantID;
        this.participantName = forms.participantName;
        this.sa1 = forms.sa1;
        this.istatus = forms.istatus;
        this.endtime = forms.endtime;
        this.clustercode = forms.clustercode;
        this.districtname = forms.districtname;
        this.deviceID = forms.deviceID;
        this.devicetagID = forms.devicetagID;
        this.synced = forms.synced;
        this.synced_date = forms.synced_date;
        this.appversion = forms.appversion;

    }

    public FamilyMembersForms() {
    }

    @Ignore
    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("_tableDescription", this._projectName);
        json.put("_id", this.id == 0 ? JSONObject.NULL : this.id);
        json.put("uuid", this.uuid == null ? JSONObject.NULL : this.uuid);
        json.put("formDate", this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put("uid", this.uid == null ? JSONObject.NULL : this.uid);
        json.put("username", this.username == null ? JSONObject.NULL : this.username);
        json.put("participantID", this.participantID == null ? JSONObject.NULL : this.participantID);
        json.put("participantName", this.participantName == null ? JSONObject.NULL : this.participantName);
        json.put("clustercode", this.clustercode == null ? JSONObject.NULL : this.clustercode);
        json.put("endtime", this.endtime == null ? JSONObject.NULL : this.endtime);
        json.put("districtname", this.districtname == null ? JSONObject.NULL : this.districtname);
        json.put("deviceID", this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put("devicetagID", this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put("appversion", this.appversion == null ? JSONObject.NULL : this.appversion);
        json.put("istatus", this.istatus == null ? JSONObject.NULL : this.istatus);

        if (!this.sa1.equals("")) {
            json.put("sa1", this.sa1.equals("") ? JSONObject.NULL : new JSONObject(this.sa1));
        }

        return json;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParticipantID() {
        return participantID;
    }

    public void setParticipantID(String participantID) {
        this.participantID = participantID;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getSa1() {
        return sa1;
    }

    public void setSa1(String sa1) {
        this.sa1 = sa1;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getClustercode() {
        return clustercode;
    }

    public void setClustercode(String clustercode) {
        this.clustercode = clustercode;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

}
