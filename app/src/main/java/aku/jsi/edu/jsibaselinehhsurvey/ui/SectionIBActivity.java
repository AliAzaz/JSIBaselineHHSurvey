package aku.jsi.edu.jsibaselinehhsurvey.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import aku.jsi.edu.jsibaselinehhsurvey.JSON.GeneratorClass;
import aku.jsi.edu.jsibaselinehhsurvey.R;
import aku.jsi.edu.jsibaselinehhsurvey.RMOperations.CrudOperations;
import aku.jsi.edu.jsibaselinehhsurvey.core.CONSTANTS;
import aku.jsi.edu.jsibaselinehhsurvey.core.MainApp;
import aku.jsi.edu.jsibaselinehhsurvey.data.DAO.FormsDAO;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.ChildHealthForms;
import aku.jsi.edu.jsibaselinehhsurvey.databinding.ActivitySectionIBBinding;
import aku.jsi.edu.jsibaselinehhsurvey.validation.ValidatorClass;

public class SectionIBActivity extends AppCompatActivity {

    private ActivitySectionIBBinding bi;
    private ChildHealthForms chF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i_b);
        bi.setCallback(this);

        setContentUI();
    }

    private void setContentUI() {
        this.setTitle(R.string.sectionIB);
        chF = (ChildHealthForms) getIntent().getSerializableExtra(CONSTANTS._URI_FC_OBJ);

    }

    public void BtnContinue() {

        if (!formValidation())
            return;

        SaveDraft();
        if (UpdateDB()) {
            MainApp.endActivity(this, this, EndingActivity.class, true, chF);
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {
        try {

            Long longID = new CrudOperations(this, FormsDAO.class.getName(), "formsDao", "updateFamilyMembers", chF).execute().get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void SaveDraft() {
        JSONObject Json = GeneratorClass.getContainerJSON(bi.fldGrpSecIB01, true);
        chF.setSa2(String.valueOf(Json));
    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecIB01);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, chF);
    }
}
