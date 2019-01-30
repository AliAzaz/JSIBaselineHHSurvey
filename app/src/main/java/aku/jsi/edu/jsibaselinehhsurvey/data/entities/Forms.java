package aku.jsi.edu.jsibaselinehhsurvey.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import aku.jsi.edu.jsibaselinehhsurvey.core.CONSTANTS;

@Entity(tableName = CONSTANTS.TABLE_FORMS)
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
    private String secF = "";     // Section F
    private String secG = "";     // Section G
    private String secH = "";     // Section H
    private String secJ = "";     // Section J
    private String secK = "";     // Section K
    private String secL = "";     // Section L
    private String secM = "";     // Section M
    private String secN = "";     // Section N
    private String secO = "";     // Section O
    private String secP = "";     // Section P
    private String secQ = "";     // Section Q
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
        this.secF = forms.secF;
        this.secG = forms.secG;
        this.secH = forms.secH;
        this.secJ = forms.secJ;
        this.secK = forms.secK;
        this.secL = forms.secL;
        this.secM = forms.secM;
        this.secN = forms.secN;
        this.secO = forms.secO;
        this.secP = forms.secP;
        this.secQ = forms.secQ;
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
        if (!this.secF.equals("")) {
            json.put("secF", this.secF.equals("") ? JSONObject.NULL : new JSONObject(this.secF));
        }
        if (!this.secG.equals("")) {
            json.put("secG", this.secG.equals("") ? JSONObject.NULL : new JSONObject(this.secG));
        }
        if (!this.secH.equals("")) {
            json.put("secH", this.secH.equals("") ? JSONObject.NULL : new JSONObject(this.secH));
        }
        if (!this.secJ.equals("")) {
            json.put("secJ", this.secJ.equals("") ? JSONObject.NULL : new JSONObject(this.secJ));
        }
        if (!this.secK.equals("")) {
            json.put("secK", this.secK.equals("") ? JSONObject.NULL : new JSONObject(this.secK));
        }
        if (!this.secL.equals("")) {
            json.put("secL", this.secL.equals("") ? JSONObject.NULL : new JSONObject(this.secL));
        }
        if (!this.secM.equals("")) {
            json.put("secM", this.secM.equals("") ? JSONObject.NULL : new JSONObject(this.secM));
        }
        if (!this.secN.equals("")) {
            json.put("secN", this.secN.equals("") ? JSONObject.NULL : new JSONObject(this.secN));
        }
        if (!this.secO.equals("")) {
            json.put("secO", this.secO.equals("") ? JSONObject.NULL : new JSONObject(this.secO));
        }
        if (!this.secP.equals("")) {
            json.put("secP", this.secP.equals("") ? JSONObject.NULL : new JSONObject(this.secP));
        }
        if (!this.secQ.equals("")) {
            json.put("secQ", this.secQ.equals("") ? JSONObject.NULL : new JSONObject(this.secQ));
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

    public String getSecF() {
        return secF;
    }

    public void setSecF(String secF) {
        this.secF = secF;
    }

    public String getSecG() {
        return secG;
    }

    public void setSecG(String secG) {
        this.secG = secG;
    }

    public String getSecH() {
        return secH;
    }

    public void setSecH(String secH) {
        this.secH = secH;
    }

    public String getSecJ() {
        return secJ;
    }

    public void setSecJ(String secJ) {
        this.secJ = secJ;
    }

    public String getSecK() {
        return secK;
    }

    public void setSecK(String secK) {
        this.secK = secK;
    }

    public String getSecL() {
        return secL;
    }

    public void setSecL(String secL) {
        this.secL = secL;
    }

    public String getSecM() {
        return secM;
    }

    public void setSecM(String secM) {
        this.secM = secM;
    }

    public String getSecN() {
        return secN;
    }

    public void setSecN(String secN) {
        this.secN = secN;
    }

    public String getSecO() {
        return secO;
    }

    public void setSecO(String secO) {
        this.secO = secO;
    }

    public String getSecP() {
        return secP;
    }

    public void setSecP(String secP) {
        this.secP = secP;
    }

    public String getSecQ() {
        return secQ;
    }

    public void setSecQ(String secQ) {
        this.secQ = secQ;
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


}
