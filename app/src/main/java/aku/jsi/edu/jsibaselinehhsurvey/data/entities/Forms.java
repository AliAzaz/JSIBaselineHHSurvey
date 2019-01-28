package aku.jsi.edu.jsibaselinehhsurvey.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import aku.jsi.edu.jsibaselinehhsurvey.data.AppDatabase;

@Entity(tableName = AppDatabase.Sub_DBConnection.TABLE_FORMS)
public class Forms implements Serializable {

    @Ignore
    private final String _projectName = "MNCH-SRC2";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String uuid = "";
    private String formType = "";
    private String uid = "";
    private String formDate = ""; // Date
    private String username = ""; // Interviewer
    private String participantID = ""; // Child ID
    private String participantName = ""; // Child Name
    private String sInfo = "";   // Section Info
    private String sa1 = "";     // Section 1
    private String sa2 = "";     // Section 2
    private String sa3 = "";     // Section 3
    private String sa4 = "";     // Section 4
    private String sa5 = "";     // Section 5
    private String sa6 = "";     // Section 6
    private String istatus = "";
    private String endtime = "";
    private String clustercode = "";
    private String districtname = "";
    private String studyID = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String gpsElev = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String round = "";
    private String pdeviation = ""; // Protocol Deviation Form

    @Ignore
    public Forms(Forms forms) {

        this.uuid = forms.uuid;
        this.formType = forms.formType;
        this.uid = forms.uid;
        this.formDate = forms.formDate;
        this.username = forms.username;
        this.participantID = forms.participantID;
        this.participantName = forms.participantName;
        this.studyID = forms.studyID;
        this.sInfo = forms.sInfo;
        this.sa1 = forms.sa1;
        this.sa2 = forms.sa2;
        this.sa3 = forms.sa3;
        this.sa4 = forms.sa4;
        this.sa5 = forms.sa5;
        this.sa6 = forms.sa6;
        this.istatus = forms.istatus;
        this.endtime = forms.endtime;
        this.clustercode = forms.clustercode;
        this.districtname = forms.districtname;
        this.gpsLat = forms.gpsLat;
        this.gpsLng = forms.gpsLng;
        this.gpsDT = forms.gpsDT;
        this.gpsAcc = forms.gpsAcc;
        this.gpsElev = forms.gpsElev;
        this.deviceID = forms.deviceID;
        this.devicetagID = forms.devicetagID;
        this.synced = forms.synced;
        this.synced_date = forms.synced_date;
        this.appversion = forms.appversion;
        this.round = forms.round;
        this.pdeviation = forms.pdeviation;

    }

    public Forms() {
    }

    @Ignore
    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("projectName", this._projectName);
        json.put("_id", this.id == 0 ? JSONObject.NULL : this.id);
//        json.put("uuid", this.uuid == null ? JSONObject.NULL : this.uuid);
        json.put("formType", this.formType == null ? JSONObject.NULL : this.formType);
        json.put("formDate", this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put("uid", this.uid == null ? JSONObject.NULL : this.uid);
        json.put("username", this.username == null ? JSONObject.NULL : this.username);
        json.put("participantID", this.participantID == null ? JSONObject.NULL : this.participantID);
        json.put("participantName", this.participantName == null ? JSONObject.NULL : this.participantName);

        json.put("studyID", this.studyID == null ? JSONObject.NULL : this.studyID);
        json.put("clustercode", this.clustercode == null ? JSONObject.NULL : this.clustercode);
        json.put("endtime", this.endtime == null ? JSONObject.NULL : this.endtime);
        json.put("districtname", this.districtname == null ? JSONObject.NULL : this.districtname);
        json.put("gpsLat", this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put("gpsLng", this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put("gpsDT", this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put("gpsAcc", this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put("deviceID", this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put("gpsElev", this.gpsElev == null ? JSONObject.NULL : this.gpsElev);
        json.put("devicetagID", this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        /*json.put("synced", this.synced == null ? JSONObject.NULL : this.synced);
        json.put("synced_date", this.synced_date == null ? JSONObject.NULL : this.synced_date);*/
        json.put("appversion", this.appversion == null ? JSONObject.NULL : this.appversion);
        json.put("istatus", this.istatus == null ? JSONObject.NULL : this.istatus);

        json.put("round", this.round == null ? JSONObject.NULL : this.round);
        json.put("pdeviation", this.pdeviation == null ? JSONObject.NULL : this.pdeviation);

        if (!this.sInfo.equals("")) {
            json.put("sInfo", this.sInfo.equals("") ? JSONObject.NULL : new JSONObject(this.sInfo));
        }
        if (!this.sa1.equals("")) {
            json.put("sa1", this.sa1.equals("") ? JSONObject.NULL : new JSONObject(this.sa1));
        }
        if (!this.sa2.equals("")) {
            json.put("sa2", this.sa2.equals("") ? JSONObject.NULL : new JSONObject(this.sa2));
        }
        if (!this.sa3.equals("")) {
            json.put("sa3", this.sa3.equals("") ? JSONObject.NULL : new JSONObject(this.sa3));
        }
        if (!this.sa4.equals("")) {
            json.put("sa4", this.sa4.equals("") ? JSONObject.NULL : new JSONObject(this.sa4));
        }
        if (!this.sa5.equals("")) {
            json.put("sa5", this.sa5.equals("") ? JSONObject.NULL : new JSONObject(this.sa5));
        }
        if (!this.sa6.equals("")) {
            json.put("sa6", this.sa6.equals("") ? JSONObject.NULL : new JSONObject(this.sa6));
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

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
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

    public String getStudyID() {
        return studyID;
    }

    public void setStudyID(String studyID) {
        this.studyID = studyID;
    }

    public String getSInfo() {
        return sInfo;
    }

    public void setSInfo(String sInfo) {
        this.sInfo = sInfo;
    }

    public String getSa1() {
        return sa1;
    }

    public void setSa1(String sa1) {
        this.sa1 = sa1;
    }

    public String getSa2() {
        return sa2;
    }

    public void setSa2(String sa2) {
        this.sa2 = sa2;
    }

    public String getSa3() {
        return sa3;
    }

    public void setSa3(String sa3) {
        this.sa3 = sa3;
    }

    public String getSa4() {
        return sa4;
    }

    public void setSa4(String sa4) {
        this.sa4 = sa4;
    }

    public String getSa5() {
        return sa5;
    }

    public void setSa5(String sa5) {
        this.sa5 = sa5;
    }

    public String getSa6() {
        return sa6;
    }

    public void setSa6(String sa6) {
        this.sa6 = sa6;
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

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getGpsElev() {
        return gpsElev;
    }

    public void setGpsElev(String gpsElev) {
        this.gpsElev = gpsElev;
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

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getPdeviation() {
        return pdeviation;
    }

    public void setPdeviation(String pdeviation) {
        this.pdeviation = pdeviation;
    }

    public class Simple_Forms_04_05 {

        String ls01a05, ls01a06, ls01a07, ls01a09, ls01f03, ls01f04, ls01f05d, ls01f05m, ls01f05y;

        public String getLs01a05() {
            return ls01a05;
        }

        public String getLs01a06() {
            return ls01a06;
        }

        public String getLs01a07() {
            return ls01a07;
        }

        public String getLs01a09() {
            return ls01a09;
        }

        public String getLs01f03() {
            return ls01f03;
        }

        public String getLs01f04() {
            return ls01f04;
        }

        public String getLs01f05d() {
            return ls01f05d;
        }

        public String getLs01f05m() {
            return ls01f05m;
        }

        public String getLs01f05y() {
            return ls01f05y;
        }
    }

}
