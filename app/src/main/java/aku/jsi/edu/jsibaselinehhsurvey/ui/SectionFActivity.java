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
import aku.jsi.edu.jsibaselinehhsurvey.databinding.ActivitySectionFBinding;
import aku.jsi.edu.jsibaselinehhsurvey.validation.ClearClass;
import aku.jsi.edu.jsibaselinehhsurvey.validation.ValidatorClass;

public class SectionFActivity extends AppCompatActivity {

    private ActivitySectionFBinding bi;
    private Forms fc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f);
        bi.setCallback(this);

        setContentUI();
    }

    private void setContentUI() {
        this.setTitle(R.string.sectionF);
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
        JSONObject secF = GeneratorClass.getContainerJSON(bi.fldGrpSecF01, true);
        fc.setSecF(String.valueOf(secF));
    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecF01);
    }


    private void setListeners() {

//        jsil01
        bi.jsif01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif01a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif02, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif03, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif04, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif05, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif06, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif07, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif08, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif09, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif10, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif11, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif12, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif13, false);
                } else {
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif02, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif03, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif04, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif05, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif06, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif07, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif08, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif09, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif10, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif11, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif12, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif13, true);

                }
            }
        });



        bi.jsif05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif05a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif06, false);

                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif06, true);


                }
            }
        });

        bi.jsif14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif14a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif15, false);

                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif15, true);


                }
            }
        });
        bi.jsif16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif16a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif17, false);

                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif17, true);


                }
            }
        });


        bi.jsif18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif18a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif19, false);

                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif19, true);


                }
            }
        });

        bi.jsif20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif20a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif21, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif22, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif23, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif24, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif25, false);

                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif21, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif22, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif23, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif24, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif25, true);


                }
            }
        });


        bi.jsif22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif22a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif23, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif24, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif25, true);

                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif23, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif24, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif25, false);


                }
            }
        });



        bi.jsif26.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif26a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif27, false);


                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif27, true);



                }
            }
        });


        bi.jsif28.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif28a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif29, false);


                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif29, true);



                }
            }
        });


        bi.jsif30.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif30a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif31, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif32, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif33, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif34, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif35, false);


                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif31, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif32, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif33, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif34, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif35, true);



                }
            }
        });




        bi.jsif34.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif34a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif35, false);


                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif35, true);



                }
            }
        });



        bi.jsif36.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif36a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif37, false);


                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif37, true);



                }
            }
        });


        bi.jsif38.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif38a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif39, false);


                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif39, true);



                }
            }
        });



        bi.jsif40.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif40a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif41, false);


                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif41, true);



                }
            }
        });


        bi.jsif42.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif42a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif43, false);


                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif43, true);



                }
            }
        });


        bi.jsif44.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.jsif44a.getId()) {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif45, false);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif46, false);


                } else {

                    ClearClass.ClearAllFields(bi.fldGrpCVjsif45, true);
                    ClearClass.ClearAllFields(bi.fldGrpCVjsif46, true);



                }
            }
        });

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, fc);
    }
}
