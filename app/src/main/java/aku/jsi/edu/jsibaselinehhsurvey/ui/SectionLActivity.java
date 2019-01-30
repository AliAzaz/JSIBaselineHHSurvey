package aku.jsi.edu.jsibaselinehhsurvey.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import aku.jsi.edu.jsibaselinehhsurvey.JSON.GeneratorClass;
import aku.jsi.edu.jsibaselinehhsurvey.R;
import aku.jsi.edu.jsibaselinehhsurvey.RMOperations.CrudOperations;
import aku.jsi.edu.jsibaselinehhsurvey.core.CONSTANTS;
import aku.jsi.edu.jsibaselinehhsurvey.core.MainApp;
import aku.jsi.edu.jsibaselinehhsurvey.data.DAO.FormsDAO;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.Forms;
import aku.jsi.edu.jsibaselinehhsurvey.databinding.ActivitySectionLBinding;
import aku.jsi.edu.jsibaselinehhsurvey.validation.ClearClass;
import aku.jsi.edu.jsibaselinehhsurvey.validation.ValidatorClass;

public class SectionLActivity extends AppCompatActivity {

    private ActivitySectionLBinding bi;
    private Forms fc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_l);
        bi.setCallback(this);

        setContentUI();
    }

    private void setContentUI() {
        this.setTitle(R.string.sectionL);
        fc = (Forms) getIntent().getSerializableExtra(CONSTANTS._URI_FC_OBJ);

    }

    public void BtnContinue() {

        if (!formValidation())
            return;

        SaveDraft();
        if (UpdateDB()) {
//            MainApp.endActivity(this, this, EndingActivity.class, true, fc);
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {
        try {

            Long longID = new CrudOperations(this, FormsDAO.class.getName(), "formsDao", "updateForm", fc).execute().get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void SaveDraft() {
        JSONObject secL = GeneratorClass.getContainerJSON(bi.fldGrpSecL01, true);
        fc.setSecL(String.valueOf(secL));
    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecL01);
    }


    private void setListeners() {

//        fas02b03
        bi.jsik03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsik03a.getId())
                    ClearClass.ClearAllFields(bi.fldGrpCVjsik04, null);
                ClearClass.ClearAllFields(bi.fldGrpCVjsik05, null);
            }
        });



    }



    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, fc);
    }
}
