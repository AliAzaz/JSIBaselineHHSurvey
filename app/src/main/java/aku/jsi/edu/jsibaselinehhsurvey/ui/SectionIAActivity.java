package aku.jsi.edu.jsibaselinehhsurvey.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import aku.jsi.edu.jsibaselinehhsurvey.JSON.GeneratorClass;
import aku.jsi.edu.jsibaselinehhsurvey.R;
import aku.jsi.edu.jsibaselinehhsurvey.RMOperations.CrudOperations;
import aku.jsi.edu.jsibaselinehhsurvey.core.MainApp;
import aku.jsi.edu.jsibaselinehhsurvey.data.DAO.FormsDAO;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.ChildHealthForms;
import aku.jsi.edu.jsibaselinehhsurvey.databinding.ActivitySectionIABinding;
import aku.jsi.edu.jsibaselinehhsurvey.validation.ValidatorClass;

public class SectionIAActivity extends AppCompatActivity {

    private static final String TAG = SectionIAActivity.class.getName();
    ActivitySectionIABinding bi;
    String deviceID;
    private ChildHealthForms chF;

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
                MainApp.stActivity(this, this, SectionIBActivity.class, chF);
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean UpdateDB() {

        try {

            Long longID = new CrudOperations(SectionIAActivity.this, FormsDAO.class.getName(), "formsDao", "insertChildHealth", chF).execute().get();

            if (longID != 0) {
                chF.setId(longID.intValue());

                chF.setUid(deviceID + chF.getId());

                longID = new CrudOperations(SectionIAActivity.this, FormsDAO.class.getName(), "formsDao", "updateFamilyMembers", chF).execute().get();
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

    private void SaveDraft() {
        chF = new ChildHealthForms();
        chF.setDevicetagID(MainApp.getTagName(this));
        chF.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        chF.setUsername(MainApp.userName);
        chF.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        chF.setDeviceID(deviceID);

        JSONObject s01 = GeneratorClass.getContainerJSON(bi.fldGrpSecIA01, true);
        chF.setSa1(String.valueOf(s01));

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
            MainApp.endActivity(this, this, EndingActivity.class, false, chF);
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }

    }
}
