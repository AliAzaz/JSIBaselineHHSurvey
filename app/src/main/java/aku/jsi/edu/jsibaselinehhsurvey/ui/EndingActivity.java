package aku.jsi.edu.jsibaselinehhsurvey.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import aku.jsi.edu.jsibaselinehhsurvey.R;
import aku.jsi.edu.jsibaselinehhsurvey.RMOperations.CrudOperations;
import aku.jsi.edu.jsibaselinehhsurvey.core.CONSTANTS;
import aku.jsi.edu.jsibaselinehhsurvey.data.DAO.FormsDAO;
import aku.jsi.edu.jsibaselinehhsurvey.data.entities.Forms;
import aku.jsi.edu.jsibaselinehhsurvey.databinding.ActivityEndingBinding;
import aku.jsi.edu.jsibaselinehhsurvey.validation.ValidatorClass;


public class EndingActivity extends AppCompatActivity {

    private static final String TAG = EndingActivity.class.getSimpleName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivityEndingBinding bi;
    Forms fc;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending);
        bi.setCallback(this);

        this.setTitle("End Interview");

        Boolean check = getIntent().getExtras().getBoolean(CONSTANTS._URI_END_FLAG);

        if (check) {
            bi.istatusa.setEnabled(true);
            bi.istatusb.setEnabled(false);
            bi.istatusc.setEnabled(false);
            bi.istatusd.setEnabled(false);
        } else {
            bi.istatusa.setEnabled(false);
            bi.istatusb.setEnabled(true);
            bi.istatusc.setEnabled(true);
            bi.istatusd.setEnabled(true);
        }

        fc = (Forms) getIntent().getSerializableExtra(CONSTANTS._URI_FC_OBJ);

    }

    public void BtnEnd() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() {
        fc.setIstatus(bi.istatusa.isChecked() ? "1" : bi.istatusb.isChecked() ? "2" : bi.istatusc.isChecked() ? "3" : bi.istatusd.isChecked() ? "4" : "0");
        fc.setEndtime(dtToday);
    }

    public boolean UpdateDB() {
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

    private boolean formValidation() {
        return ValidatorClass.EmptyRadioButton(this, bi.istatus, bi.istatusb, getString(R.string.istatus));
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
