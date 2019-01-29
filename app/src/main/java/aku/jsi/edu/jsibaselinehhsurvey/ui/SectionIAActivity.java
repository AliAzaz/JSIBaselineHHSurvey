package aku.jsi.edu.jsibaselinehhsurvey.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import aku.jsi.edu.jsibaselinehhsurvey.R;
import aku.jsi.edu.jsibaselinehhsurvey.RMOperations.CrudOperations;
import aku.jsi.edu.jsibaselinehhsurvey.core.MainApp;
import aku.jsi.edu.jsibaselinehhsurvey.data.DAO.FormsDAO;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.Forms;
import aku.jsi.edu.jsibaselinehhsurvey.databinding.ActivitySectionIABinding;
import aku.jsi.edu.jsibaselinehhsurvey.validation.ValidatorClass;

public class SectionIAActivity extends AppCompatActivity {

    private static final String TAG = SectionIAActivity.class.getName();
    ActivitySectionIABinding bi;
    String deviceID;
    private Forms fc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i_a);
        bi.setCallback(this);

        setContentUI();
    }

    private void setContentUI() {
        this.setTitle(R.string.sectionIA);
        deviceID = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public void BtnContinue() {
        if (!formValidation())
            return;

        try {
            SaveDraft();
            if (UpdateDB()) {

//                MainApp.stActivity(this, this, SectionBActivity.class, fc);
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean UpdateDB() {

        try {

            Long longID = new CrudOperations(SectionIAActivity.this, FormsDAO.class.getName(), "formsDao", "insertForm", fc).execute().get();

            if (longID != 0) {
                fc.setId(longID.intValue());

                fc.setUid(deviceID + fc.getId());

                longID = new CrudOperations(SectionIAActivity.this, FormsDAO.class.getName(), "formsDao", "updateForm", fc).execute().get();
                return longID == 1;

            } else {
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;

    }

    private void SaveDraft() throws JSONException {
        fc = new Forms();
        fc.setDevicetagID(MainApp.getTagName(this));
        fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc.setUsername(MainApp.userName);
        fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fc.setDeviceID(deviceID);
        setGPS(fc);


        JSONObject s01 = new JSONObject();


        fc.setSa1(String.valueOf(s01));

    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecIA01);
    }

    public void BtnEnd() {

        /*if (!ValidatorClass.EmptyRadioButton(this, bi.fas02a00, bi.fas02a00a, getString(R.string.fas01a00)))
            return;
        if (!ValidatorClass.EmptyTextBox(this, bi.fas02amw01, getString(R.string.fas02a01)))
            return;
        if (!ValidatorClass.EmptyTextBox(this, bi.fas02a001, getString(R.string.fas01a01)))
            return;*/

        if (UpdateDB()) {
//            MainApp.endActivity(this, this, EndingActivity.class, false, fc);
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }

    }

    public void setGPS(Forms fc) {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String elevation = GPSPref.getString("Elevation", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            fc.setGpsLat(lat);
            fc.setGpsLng(lang);
            fc.setGpsAcc(acc);
            fc.setGpsDT(date); // Timestamp is converted to date above
            fc.setGpsElev(elevation);

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }
}
