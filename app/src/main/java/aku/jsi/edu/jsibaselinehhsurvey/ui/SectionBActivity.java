package aku.jsi.edu.jsibaselinehhsurvey.ui;

import android.content.Intent;
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
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.FamilyMembersForms;
import aku.jsi.edu.jsibaselinehhsurvey.databinding.ActivitySectionBBinding;
import aku.jsi.edu.jsibaselinehhsurvey.ui.recyclers.SectionFamilyMembersList;
import aku.jsi.edu.jsibaselinehhsurvey.validation.ValidatorClass;

public class SectionBActivity extends AppCompatActivity {

    private static final String TAG = SectionBActivity.class.getName();
    ActivitySectionBBinding bi;
    String deviceID;
    private FamilyMembersForms fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b);
        bi.setCallback(this);

        setContentUI();
    }

    private void setContentUI() {
        this.setTitle(R.string.sectionB);
        deviceID = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

        bi.jsib07.setManager(getSupportFragmentManager());
    }

    public void BtnContinue() {
        if (!formValidation())
            return;

        try {
            SaveDraft();
            if (UpdateDB()) {

//                MainApp.stActivity(this, this, SectionBActivity.class, fm);
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean UpdateDB() {

        try {

            Long longID = new CrudOperations(SectionBActivity.this, FormsDAO.class.getName(), "formsDao", "insertFamilyMembers", fm).execute().get();

            if (longID != 0) {
                fm.setId(longID.intValue());

                fm.setUid(deviceID + fm.getId());

                longID = new CrudOperations(SectionBActivity.this, FormsDAO.class.getName(), "formsDao", "updateFamilyMembers", fm).execute().get();
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
        fm = new FamilyMembersForms();
        fm.setDevicetagID(MainApp.getTagName(this));
        fm.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fm.setUsername(MainApp.userName);
        fm.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fm.setDeviceID(deviceID);

        JSONObject sa1 = GeneratorClass.getContainerJSON(bi.fldGrpSecB01, true);
        fm.setSa1(String.valueOf(sa1));
    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecB01);
    }

    public void BtnEnd() {
        startActivity(new Intent(this, SectionFamilyMembersList.class));
    }
}
