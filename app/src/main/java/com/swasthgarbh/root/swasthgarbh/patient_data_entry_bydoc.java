package com.swasthgarbh.root.swasthgarbh;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import android.widget.CompoundButton;

import java.util.ResourceBundle;

import static android.app.PendingIntent.getActivity;
import static com.swasthgarbh.root.swasthgarbh.patient_registration.session;

public class patient_data_entry_bydoc extends AppCompatActivity {

    int clickedPatientId;
    Button UpdateData;
    String anc_1_dateTime;

    EditText anc3_Date,anc4_Date,anc5_Date,anc6_Date,anc7_Date,anc8_Date;

//    ANC1 Variables
    EditText anc1_Date;
    EditText anc1_POG;

    CheckBox anc1_History_Fever, anc1_History_Rash, anc1_History_Nausea, anc1_History_Bleeding, anc1_History_AbdomenPain, anc1_History_DrugIntake, anc1_History_Smoking, anc1_History_Alcohol, anc1_History_TobaccoIntake, anc1_History_CaffeineIntake, anc1_History_IntimatePartnerViolence;
    EditText anc1_history_Others;

    CheckBox anc1_examination_general_Pallor, anc1_examination_general_Lcterus, anc1_examination_general_Clubbing, anc1_examination_general_Cyanosis, anc1_examination_general_Edema, anc1_examination_general_Lymphadenopathy;
    EditText anc1_examination_anthropometry_Height, anc1_examination_anthropometry_Weight, anc1_examination_anthropometry_Bmi;
    EditText anc1_examination_vitals_Pr, anc1_examination_vitals_Bp, anc1_examination_vitals_Rr, anc1_examination_vitals_Temp, anc1_examination_vitals_ChestCVS, anc1_examination_vitals_PA;
    Spinner anc1_examination_vitals_Proteinuria;

    CheckBox anc1_investigations_HIV, anc1_investigations_Hbsag, anc1_investigations_Vdrl, anc1_investigations_UrineRM, anc1_investigations_UrineCS;
    Switch anc1_investigations_HIV_switch, anc1_investigations_Hbsag_switch, anc1_investigations_Vdrl_switch, anc1_investigations_UrineRM_switch, anc1_investigations_UrineCS_switch;
    Spinner anc1_investigations_BloodGroup, anc1_investigations_HusbandBloodGroup;
    EditText anc1_investigations_Hemogram, anc1_investigations_Tsh;
    EditText anc1_investigations_GTT_fast, anc1_investigations_GTT_1Hour, anc1_investigations_GTT_2Hour;
    EditText anc1_investigations_bloodSugar_Fasting, anc1_investigations_bloodSugar_PostPrandial;
    EditText anc1_investigations_ntnb_DoneNotDone;
    CheckBox anc1_investigations_ntnb_CRL, anc1_investigations_ntnb_NT, anc1_investigations_ntnb_Centile, anc1_investigations_ntnb_Text;
    EditText anc1_investigations_dualScreen_PAPP, anc1_investigations_dualScreen_Bhcg;
    EditText anc1_investigations_level2Usg_DoneNotDone, anc1_investigations_level2Usg_NormalAbnormal;

    EditText anc1_advice_GTT, anc1_advice_BloodSugar, anc1_advice_NtNbScan, anc1_advice_DualScreen, anc1_advice_LeftUterineArteryPl, anc1_advice_RightUterineArteryPl, anc1_advice_PIGF, anc1_advice_ICT;
    CheckBox anc1_advice_GeneralNutritional, anc1_advice_GeneralAilments;

    EditText anc1_general_BgNegICT;
    CheckBox anc1_general_TSH;
    CheckBox anc1_general_urineCulture_Nitrofur, anc1_general_urineCulture_Syp, anc1_general_urineCulture_VitC, anc1_general_urineCulture_PlentyFluids;

    EditText anc1_general_deranged_Fasting, anc1_general_deranged_AfterBreakfast, anc1_general_deranged_AfterLunch, anc1_general_deranged_AfterDinner;
    EditText anc1_general_Others;

//    ANC2 Variables
    EditText anc2_Date;
    EditText anc2_POG;
    CheckBox anc2_history_ShortnessOfBreath, anc2_history_EasyFatiguability, anc2_history_HeadacheEpigastricPain, anc2_history_BleedingSpottingPv, anc2_history_BurningMicturition, anc2_history_QuickeningPerceived;
    EditText anc2_history_Others;

    CheckBox anc2_examination_Pallor, anc2_examination_PedalEdema;
    EditText anc2_examination_PR, anc2_examination_BP, anc2_examination_Weight, anc2_examination_PA2Weeks;
    EditText anc2_examination_Others;

    EditText anc2_investigations_QuadrupleScreen;
    CheckBox anc2_investigations_TfolateLessThan14Weeks, anc2_investigations_TFeMoreThan14Weeks;

    CheckBox anc2_advice_OGTT, anc2_advice_TfeOD, anc2_advice_TcaBD, anc2_advice_Tetanus, anc2_advice_QuadrupleScreen, anc2_advice_FetalEcho;

    CheckBox anc2_advice_HbLess10_TAlbendazole, anc2_advice_HbLess10_TFeBD, anc2_advice_HbLess10_Hplc, anc2_advice_HbLess10_PeripheralSmear, anc2_advice_HbLess10_SerumIron;
    EditText anc2_advice_Nutritional, anc2_advice_GeneralAdvice, anc2_advice_CommonAilment;
    EditText anc2_advice_Others;

//    ANC3 Variables
    CheckBox anc3_history_ShortnessOfBreath, anc3_history_EasyFatigability, anc3_history_HeadacheEpigastricPain, anc3_history_BleedingSpottingPv, anc3_history_LeakingDischargePv, anc3_history_BurningMicturition, anc3_history_FetalMovements, anc3_history_Itching;

    CheckBox anc3_examination_Pallor, anc3_examination_PedalEdema;
    EditText anc3_examination_PR, anc3_examination_BP, anc3_examination_Weight, anc3_examination_PA2Weeks, anc3_examination_Others;

    CheckBox anc3_investigations_CBC, anc3_investigations_UrineCS, anc3_investigations_ICT;
    EditText anc3_investigations_Others;

    CheckBox anc3_advice_TFeOD, anc3_advice_DFMCLLP, anc3_advice_InjTetanus, anc3_advice_CBC, anc3_advice_LFT, anc3_advice_KFT;
    CheckBox anc3_advice_GTT_Fasting, anc3_advice_GTT_1hr180Mg, anc3_advice_GTT_2hr153Mg;
    CheckBox anc3_advice_review_BleedingPV, anc3_advice_review_SpottingPV, anc3_advice_review_LeakingPV, anc3_advice_review_ReducedFetalMovement, anc3_advice_review_AbdominalPain;
    CheckBox anc3_advice_ictNegative_InjAntiD300;

    EditText anc3_advice_Nutritional, anc3_advice_General, anc_3_common_ailment, anc3_advice_Others;

//    ANC4 Variables
//    ANC5 Variables
//    ANC6 Variables
//    ANC7 Variables
//    ANC8 Variables

    Calendar newDate1 = Calendar.getInstance();
    Calendar anc1_date = Calendar.getInstance();
    private DatePickerDialog anc_1_datePickerDialog;
    private SimpleDateFormat dateFormatterShow, dateFormatterServer;
    String g;
    int key = 1;

    String lmpDateString;

    void callDateDiff(String p) {
        Log.d("p =", p);
        g = p.split("-")[1];
        g = g.trim();
        Log.d("g =", g);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d = sdf.parse(g);
            Log.i("d1", g);
            Date d2 = sdf.parse(lmpDateString);
            Log.i("d1", lmpDateString);
            long diff = d.getTime() - d2.getTime();
            Log.i("difference", "" + diff);
            long days = diff / (24 * 60 * 60 * 1000);
            long month = days / 30;
            days = days % 30;

//                Log.i ("month", "" + month);
//                Log.i ("days", "" + days);
            String t = "";
            if (month == 1) {
                t = month + " Month " + " and " + days + " Days";
            } else if (month > 1) {
                t = month + " Months " + " and " + days + " Days";
            }
            Log.d("final =", t);
            anc2_POG.setText(t);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void callDateDiff() {
        String[] temp = anc_1_dateTime.split("-");
        String date_year = temp[2];
        String date_month = temp[1];
        String date_date = temp[0];

        anc_1_dateTime = date_date + "/" + date_month + "/" + date_year;
        Log.d("ancdatee =", anc_1_dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date d1 = sdf.parse(anc_1_dateTime);
            Log.i("d1", anc_1_dateTime);
            Date d2 = sdf.parse(lmpDateString);
            Log.i("d1", lmpDateString);
            long diff = d1.getTime() - d2.getTime();
            Log.i("difference", "" + diff);
            long days = diff / (24 * 60 * 60 * 1000);
            long month = days / 30;

            days = days % 30;

            Log.i("month", "" + month);
            Log.i("days", "" + days);
            String m = "";
            if (month == 1) {
                m = month + " Month " + " and " + days + " Days";
            } else if (month > 1) {
                m = month + " Months " + " and " + days + " Days";
            } else {
                Toast.makeText(this, "Invalid Date!", Toast.LENGTH_SHORT).show();
            }
            Log.d("final m =", m);
            anc1_POG.setText(m);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_data_entry_bydoc);

        dateFormatterShow = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateFormatterServer = new SimpleDateFormat("dd-MM-yyyy");

        anc1_Date = (EditText) findViewById(R.id.anc1_Date);
        anc2_Date = (EditText) findViewById(R.id.anc2_Date);

        Calendar newCalendar = Calendar.getInstance();
        anc1_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anc_1_datePickerDialog.show();
            }
        });
        anc_1_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc1_date.set(dayOfMonth, monthOfYear, year);
                anc1_Date.setText(dateFormatterShow.format(anc1_date.getTime()));
                anc_1_dateTime = dateFormatterShow.format(anc1_date.getTime());
                callDateDiff();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


//        anc_6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    anc6_his_linearBox.setVisibility(View.VISIBLE);
//                    anc6_exam_linearBox.setVisibility(View.VISIBLE);
//                    anc6_advice_linearBox.setVisibility(View.VISIBLE);
//                    anc6_his_others.setVisibility(View.VISIBLE);
//                    anc6_exam_PR.setVisibility(View.VISIBLE);
//                    anc6_exam_BP.setVisibility(View.VISIBLE);
//                    anc6_exam_weight.setVisibility(View.VISIBLE);
//                    anc6_exam_others.setVisibility(View.VISIBLE);
//                    anc6_exam_pelvic.setVisibility(View.VISIBLE);
//                    anc6_advice_others.setVisibility(View.VISIBLE);
//                    anc6_his_othersBox.setVisibility(View.VISIBLE);
//                    anc6_exam_PRBox.setVisibility(View.VISIBLE);
//                    anc6_exam_BPBox.setVisibility(View.VISIBLE);
//                    anc6_exam_weightBox.setVisibility(View.VISIBLE);
//                    anc6_exam_othersBox.setVisibility(View.VISIBLE);
//                    anc6_exam_pelvicBox.setVisibility(View.VISIBLE);
//                    anc6_advice_othersBox.setVisibility(View.VISIBLE);
//                    anc_6_historyBox.setVisibility(View.VISIBLE);
//                    anc_6_examinationBox.setVisibility(View.VISIBLE);
//                    anc_6_adviceBox.setVisibility(View.VISIBLE);
//                    anc_6_reviewBox.setVisibility(View.VISIBLE);
//                    anc6_his_breath.setVisibility(View.VISIBLE);
//                    anc6_his_fatigue.setVisibility(View.VISIBLE);
//                    anc6_his_head.setVisibility(View.VISIBLE);
//                    anc6_his_bleed.setVisibility(View.VISIBLE);
//                    anc6_his_burn.setVisibility(View.VISIBLE);
//                    anc6_his_fetal_move.setVisibility(View.VISIBLE);
//                    anc6_his_itching.setVisibility(View.VISIBLE);
//                    anc6_exam_pallor.setVisibility(View.VISIBLE);
//                    anc6_exam_pedal.setVisibility(View.VISIBLE);
//                    anc6_exam_pa.setVisibility(View.VISIBLE);
//                    anc6_pa_2weeks.setVisibility(View.VISIBLE);
//                    anc6_advice_DFMC.setVisibility(View.VISIBLE);
//                    anc6_advice_TFe_Ca.setVisibility(View.VISIBLE);
//                    anc6_advice_BleedPV.setVisibility(View.VISIBLE);
//                    anc6_advice_spotPV.setVisibility(View.VISIBLE);
//                    anc6_advice_leakPV.setVisibility(View.VISIBLE);
//                    anc6_advice_fetalmove.setVisibility(View.VISIBLE);
//                    anc6_advice_abdpain.setVisibility(View.VISIBLE);
//                    anc6_advice_NST.setVisibility(View.VISIBLE);
//
//                } else {
//                    anc6_his_linearBox.setVisibility(View.GONE);
//                    anc6_exam_linearBox.setVisibility(View.GONE);
//                    anc6_advice_linearBox.setVisibility(View.GONE);
//                    anc6_his_others.setVisibility(View.GONE);
//                    anc6_exam_PR.setVisibility(View.GONE);
//                    anc6_exam_BP.setVisibility(View.GONE);
//                    anc6_exam_weight.setVisibility(View.GONE);
//                    anc6_exam_others.setVisibility(View.GONE);
//                    anc6_exam_pelvic.setVisibility(View.GONE);
//                    anc6_advice_others.setVisibility(View.GONE);
//                    anc6_his_othersBox.setVisibility(View.GONE);
//                    anc6_exam_PRBox.setVisibility(View.GONE);
//                    anc6_exam_BPBox.setVisibility(View.GONE);
//                    anc6_exam_weightBox.setVisibility(View.GONE);
//                    anc6_exam_othersBox.setVisibility(View.GONE);
//                    anc6_exam_pelvicBox.setVisibility(View.GONE);
//                    anc6_advice_othersBox.setVisibility(View.GONE);
//                    anc_6_historyBox.setVisibility(View.GONE);
//                    anc_6_examinationBox.setVisibility(View.GONE);
//                    anc_6_adviceBox.setVisibility(View.GONE);
//                    anc_6_reviewBox.setVisibility(View.GONE);
//                    anc6_his_breath.setVisibility(View.GONE);
//                    anc6_his_fatigue.setVisibility(View.GONE);
//                    anc6_his_head.setVisibility(View.GONE);
//                    anc6_his_bleed.setVisibility(View.GONE);
//                    anc6_his_burn.setVisibility(View.GONE);
//                    anc6_his_fetal_move.setVisibility(View.GONE);
//                    anc6_his_itching.setVisibility(View.GONE);
//                    anc6_exam_pallor.setVisibility(View.GONE);
//                    anc6_exam_pedal.setVisibility(View.GONE);
//                    anc6_exam_pa.setVisibility(View.GONE);
//                    anc6_pa_2weeks.setVisibility(View.GONE);
//                    anc6_advice_DFMC.setVisibility(View.GONE);
//                    anc6_advice_TFe_Ca.setVisibility(View.GONE);
//                    anc6_advice_BleedPV.setVisibility(View.GONE);
//                    anc6_advice_spotPV.setVisibility(View.GONE);
//                    anc6_advice_leakPV.setVisibility(View.GONE);
//                    anc6_advice_fetalmove.setVisibility(View.GONE);
//                    anc6_advice_abdpain.setVisibility(View.GONE);
//                    anc6_advice_NST.setVisibility(View.GONE);
//
//                }
//            }
//        });
//
//
//        anc_7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    anc7_his_linearBox.setVisibility(View.VISIBLE);
//                    anc7_exam_linearBox.setVisibility(View.VISIBLE);
//                    anc7_advice_linearBox.setVisibility(View.VISIBLE);
//                    anc7_his_othersBox.setVisibility(View.VISIBLE);
//                    anc7_exam_PRBox.setVisibility(View.VISIBLE);
//                    anc7_exam_BPBox.setVisibility(View.VISIBLE);
//                    anc7_exam_weightBox.setVisibility(View.VISIBLE);
//                    anc7_exam_othersBox.setVisibility(View.VISIBLE);
//                    anc7_advice_othersBox.setVisibility(View.VISIBLE);
//                    anc_7_historyBox.setVisibility(View.VISIBLE);
//                    anc_7_examinationBox.setVisibility(View.VISIBLE);
//                    anc_7_adviceBox.setVisibility(View.VISIBLE);
//                    anc_7_reviewBox.setVisibility(View.VISIBLE);
//                    anc7_his_breath.setVisibility(View.VISIBLE);
//                    anc7_his_fatigue.setVisibility(View.VISIBLE);
//                    anc7_his_head.setVisibility(View.VISIBLE);
//                    anc7_his_bleed.setVisibility(View.VISIBLE);
//                    anc7_his_burn.setVisibility(View.VISIBLE);
//                    anc7_his_fetal_move.setVisibility(View.VISIBLE);
//                    anc7_his_itching.setVisibility(View.VISIBLE);
//                    anc7_exam_pallor.setVisibility(View.VISIBLE);
//                    anc7_exam_pedal.setVisibility(View.VISIBLE);
//                    anc7_exam_pa.setVisibility(View.VISIBLE);
//                    anc7_pa_2weeks.setVisibility(View.VISIBLE);
//                    anc7_advice_DFMC.setVisibility(View.VISIBLE);
//                    anc7_advice_TFe_Ca.setVisibility(View.VISIBLE);
//                    anc7_advice_BleedPV.setVisibility(View.VISIBLE);
//                    anc7_advice_spotPV.setVisibility(View.VISIBLE);
//                    anc7_advice_leakPV.setVisibility(View.VISIBLE);
//                    anc7_advice_fetalmove.setVisibility(View.VISIBLE);
//                    anc7_advice_abdpain.setVisibility(View.VISIBLE);
//                    anc7_his_others.setVisibility(View.VISIBLE);
//                    anc7_exam_PR.setVisibility(View.VISIBLE);
//                    anc7_exam_BP.setVisibility(View.VISIBLE);
//                    anc7_exam_weight.setVisibility(View.VISIBLE);
//                    anc7_exam_others.setVisibility(View.VISIBLE);
//                    anc7_advice_others.setVisibility(View.VISIBLE);
//
//                } else {
//                    anc7_his_linearBox.setVisibility(View.GONE);
//                    anc7_exam_linearBox.setVisibility(View.GONE);
//                    anc7_advice_linearBox.setVisibility(View.GONE);
//                    anc7_his_othersBox.setVisibility(View.GONE);
//                    anc7_exam_PRBox.setVisibility(View.GONE);
//                    anc7_exam_BPBox.setVisibility(View.GONE);
//                    anc7_exam_weightBox.setVisibility(View.GONE);
//                    anc7_exam_othersBox.setVisibility(View.GONE);
//                    anc7_advice_othersBox.setVisibility(View.GONE);
//                    anc_7_historyBox.setVisibility(View.GONE);
//                    anc_7_examinationBox.setVisibility(View.GONE);
//                    anc_7_adviceBox.setVisibility(View.GONE);
//                    anc_7_reviewBox.setVisibility(View.GONE);
//                    anc7_his_breath.setVisibility(View.GONE);
//                    anc7_his_fatigue.setVisibility(View.GONE);
//                    anc7_his_head.setVisibility(View.GONE);
//                    anc7_his_bleed.setVisibility(View.GONE);
//                    anc7_his_burn.setVisibility(View.GONE);
//                    anc7_his_fetal_move.setVisibility(View.GONE);
//                    anc7_his_itching.setVisibility(View.GONE);
//                    anc7_exam_pallor.setVisibility(View.GONE);
//                    anc7_exam_pedal.setVisibility(View.GONE);
//                    anc7_exam_pa.setVisibility(View.GONE);
//                    anc7_pa_2weeks.setVisibility(View.GONE);
//                    anc7_advice_DFMC.setVisibility(View.GONE);
//                    anc7_advice_TFe_Ca.setVisibility(View.GONE);
//                    anc7_advice_BleedPV.setVisibility(View.GONE);
//                    anc7_advice_spotPV.setVisibility(View.GONE);
//                    anc7_advice_leakPV.setVisibility(View.GONE);
//                    anc7_advice_fetalmove.setVisibility(View.GONE);
//                    anc7_advice_abdpain.setVisibility(View.GONE);
//                    anc7_his_others.setVisibility(View.GONE);
//                    anc7_exam_PR.setVisibility(View.GONE);
//                    anc7_exam_BP.setVisibility(View.GONE);
//                    anc7_exam_weight.setVisibility(View.GONE);
//                    anc7_exam_others.setVisibility(View.GONE);
//                    anc7_advice_others.setVisibility(View.GONE);
//
//                }
//            }
//        });
//
//        anc_8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    anc8_his_linearBox.setVisibility(View.VISIBLE);
//                    anc8_exam_linearBox.setVisibility(View.VISIBLE);
//                    anc8_advice_linearBox.setVisibility(View.VISIBLE);
//                    anc8_his_others.setVisibility(View.VISIBLE);
//                    anc8_exam_PR.setVisibility(View.VISIBLE);
//                    anc8_exam_BP.setVisibility(View.VISIBLE);
//                    anc8_exam_weight.setVisibility(View.VISIBLE);
//                    anc8_exam_others.setVisibility(View.VISIBLE);
//                    anc8_advice_others.setVisibility(View.VISIBLE);
//                    anc8_his_othersBox.setVisibility(View.VISIBLE);
//                    anc8_exam_PRBox.setVisibility(View.VISIBLE);
//                    anc8_exam_BPBox.setVisibility(View.VISIBLE);
//                    anc8_exam_weightBox.setVisibility(View.VISIBLE);
//                    anc8_exam_othersBox.setVisibility(View.VISIBLE);
//                    anc8_advice_othersBox.setVisibility(View.VISIBLE);
//                    anc_8_historyBox.setVisibility(View.VISIBLE);
//                    anc_8_adviceBox.setVisibility(View.VISIBLE);
//                    anc_8_examinationBox.setVisibility(View.VISIBLE);
//                    anc8_his_breath.setVisibility(View.VISIBLE);
//                    anc8_his_fatigue.setVisibility(View.VISIBLE);
//                    anc8_his_head.setVisibility(View.VISIBLE);
//                    anc8_his_bleed.setVisibility(View.VISIBLE);
//                    anc8_his_burn.setVisibility(View.VISIBLE);
//                    anc8_his_fetal_move.setVisibility(View.VISIBLE);
//                    anc8_his_itching.setVisibility(View.VISIBLE);
//                    anc8_exam_pallor.setVisibility(View.VISIBLE);
//                    anc8_exam_pedal.setVisibility(View.VISIBLE);
//                    anc8_exam_pa.setVisibility(View.VISIBLE);
//                    anc8_advice_DFMC.setVisibility(View.VISIBLE);
//                    anc8_advice_Fe_Ca.setVisibility(View.VISIBLE);
//                    anc8_advice_induction.setVisibility(View.VISIBLE);
//
//                } else {
//                    anc8_his_linearBox.setVisibility(View.GONE);
//                    anc8_exam_linearBox.setVisibility(View.GONE);
//                    anc8_advice_linearBox.setVisibility(View.GONE);
//                    anc8_his_others.setVisibility(View.GONE);
//                    anc8_exam_PR.setVisibility(View.GONE);
//                    anc8_exam_BP.setVisibility(View.GONE);
//                    anc8_exam_weight.setVisibility(View.GONE);
//                    anc8_exam_others.setVisibility(View.GONE);
//                    anc8_advice_others.setVisibility(View.GONE);
//                    anc8_his_othersBox.setVisibility(View.GONE);
//                    anc8_exam_PRBox.setVisibility(View.GONE);
//                    anc8_exam_BPBox.setVisibility(View.GONE);
//                    anc8_exam_weightBox.setVisibility(View.GONE);
//                    anc8_exam_othersBox.setVisibility(View.GONE);
//                    anc8_advice_othersBox.setVisibility(View.GONE);
//                    anc_8_historyBox.setVisibility(View.GONE);
//                    anc_8_adviceBox.setVisibility(View.GONE);
//                    anc_8_examinationBox.setVisibility(View.GONE);
//                    anc8_his_breath.setVisibility(View.GONE);
//                    anc8_his_fatigue.setVisibility(View.GONE);
//                    anc8_his_head.setVisibility(View.GONE);
//                    anc8_his_bleed.setVisibility(View.GONE);
//                    anc8_his_burn.setVisibility(View.GONE);
//                    anc8_his_fetal_move.setVisibility(View.GONE);
//                    anc8_his_itching.setVisibility(View.GONE);
//                    anc8_exam_pallor.setVisibility(View.GONE);
//                    anc8_exam_pedal.setVisibility(View.GONE);
//                    anc8_exam_pa.setVisibility(View.GONE);
//                    anc8_advice_DFMC.setVisibility(View.GONE);
//                    anc8_advice_Fe_Ca.setVisibility(View.GONE);
//                    anc8_advice_induction.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        investigationsBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    invest_heart_linearBox.setVisibility(View.VISIBLE);
//                    invest_othersBox.setVisibility(View.VISIBLE);
//                    invest_drug_historyBox.setVisibility(View.VISIBLE);
//                    Co_MorbiditiesBox.setVisibility(View.VISIBLE);
//                    Heart_DiseaseBox.setVisibility(View.VISIBLE);
//                    invest_others.setVisibility(View.VISIBLE);
//                    invest_drug_history.setVisibility(View.VISIBLE);
//                    invest_chronic_hyper.setVisibility(View.VISIBLE);
//                    invest_type_2_diabetes.setVisibility(View.VISIBLE);
//                    invest_RHD_native.setVisibility(View.VISIBLE);
//                    invest_RHD_post.setVisibility(View.VISIBLE);
//                    invest_acyanotic.setVisibility(View.VISIBLE);
//                    invest_cyanotic.setVisibility(View.VISIBLE);
//                    invest_chronic_liver.setVisibility(View.VISIBLE);
//                    invest_chronic_kidney.setVisibility(View.VISIBLE);
//                    invest_APLA.setVisibility(View.VISIBLE);
//                    invest_SLE.setVisibility(View.VISIBLE);
//
//                } else {
//                    invest_heart_linearBox.setVisibility(View.GONE);
//                    invest_othersBox.setVisibility(View.GONE);
//                    invest_drug_historyBox.setVisibility(View.GONE);
//                    Co_MorbiditiesBox.setVisibility(View.GONE);
//                    Heart_DiseaseBox.setVisibility(View.GONE);
//                    invest_others.setVisibility(View.GONE);
//                    invest_drug_history.setVisibility(View.GONE);
//                    invest_chronic_hyper.setVisibility(View.GONE);
//                    invest_type_2_diabetes.setVisibility(View.GONE);
//                    invest_RHD_native.setVisibility(View.GONE);
//                    invest_RHD_post.setVisibility(View.GONE);
//                    invest_acyanotic.setVisibility(View.GONE);
//                    invest_cyanotic.setVisibility(View.GONE);
//                    invest_chronic_liver.setVisibility(View.GONE);
//                    invest_chronic_kidney.setVisibility(View.GONE);
//                    invest_APLA.setVisibility(View.GONE);
//                    invest_SLE.setVisibility(View.GONE);
//                }
//            }
//        });

        getSupportActionBar().setTitle("Add Data");

        session = new SessionManager(this);
//      Getting the WHO Data
        Log.i("information", "onCreate: " + "in whooo");
        clickedPatientId = getIntent().getIntExtra("EXTRA_PATIENT_ID", 0);
        System.out.print(clickedPatientId);
        String url = ApplicationController.get_base_url() + "swasthgarbh/patient/" + clickedPatientId;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("apihit", response.toString());
                        try {
                            if (response.has("ID")) {
                                response = response.getJSONObject("newPatientData");
                            }
                            Log.i("kkjbgjhgjkh", "onResponse: rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr" + response.toString());
                            TextView lmpDate = (TextView) findViewById(R.id.lmpDate);

                            TextView eddDate = (TextView) findViewById(R.id.eddDate);
                            TextView anc1Date = (TextView) findViewById(R.id.anc1Date);
                            TextView anc2Date = (TextView) findViewById(R.id.anc2Date);
                            TextView anc3Date = (TextView) findViewById(R.id.anc3Date);
                            TextView anc4Date = (TextView) findViewById(R.id.anc4Date);
                            TextView anc5Date = (TextView) findViewById(R.id.anc5Date);
                            TextView anc6Date = (TextView) findViewById(R.id.anc6Date);
                            TextView anc7Date = (TextView) findViewById(R.id.anc7Date);
                            TextView anc8Date = (TextView) findViewById(R.id.anc8Date);

                            String date_date = response.getString("startDate").split("T")[0].split("-")[2];
                            String date_month = response.getString("startDate").split("T")[0].split("-")[1];
                            String date_year = response.getString("startDate").split("T")[0].split("-")[0];

                            lmpDateString = date_date + "/" + date_month + "/" + date_year;
                            String eddDateString = date_year + "/" + date_month + "/" + date_date;
                            Calendar c = Calendar.getInstance();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

//                            newDate1.set(Integer.parseInt(date_year), Integer.parseInt(date_month), Integer.parseInt(date_date));
                            Date d = sdf.parse(lmpDateString);
                            newDate1.setTime(d);

                            lmpDate.setText(sdf.format(d));

                            invest_others.setText(response.getString("invest_others"));
                            invest_drug_history.setText(response.getString("invest_drug_history"));
                            invest_chronic_hyper.setChecked(response.getBoolean("invest_chronic_hyper"));
                            invest_type_2_diabetes.setChecked(response.getBoolean("invest_type_2_diabetes"));
                            invest_RHD_native.setChecked(response.getBoolean("invest_RHD_native"));
                            invest_RHD_post.setChecked(response.getBoolean("invest_RHD_post"));
                            invest_acyanotic.setChecked(response.getBoolean("invest_acyanotic"));
                            invest_cyanotic.setChecked(response.getBoolean("invest_cyanotic"));
                            invest_chronic_liver.setChecked(response.getBoolean("invest_chronic_liver"));
                            invest_chronic_kidney.setChecked(response.getBoolean("invest_chronic_kidney"));
                            invest_APLA.setChecked(response.getBoolean("invest_APLA"));


                            newDate1.add(Calendar.DATE, 84);
                            anc1Date.setText("12 Weeks - " + sdf.format(newDate1.getTime()));
                            anc_1_GeneralDeranged_fasting.setText(response.getString("anc_1_GeneralDeranged_fasting"));
                            anc_1_GeneralDeranged_breakfast.setText(response.getString("anc_1_GeneralDeranged_breakfast"));
                            anc_1_GeneralDeranged_lunch.setText(response.getString("anc_1_GeneralDeranged_lunch"));
                            anc_1_GeneralDeranged_dinner.setText(response.getString("anc_1_GeneralDeranged_dinner"));
                            anc_1_POG.setText(response.getString("anc_1_POG"));
                            anc_1_date.setText(response.getString("anc_1_date"));
                            anc1_his_others.setText(response.getString("anc1_his_others"));
                            anc1_exam_height.setText(response.getString("anc1_exam_height"));
                            anc1_exam_weight.setText(response.getString("anc1_exam_weight"));
                            anc1_exam_BMI.setText(response.getString("anc1_exam_BMI"));
                            anc1_exam_PR.setText(response.getString("anc1_exam_PR"));
                            anc1_exam_BP.setText(response.getString("anc1_exam_BP"));
                            anc1_exam_RR.setText(response.getString("anc1_exam_RR"));
                            anc1_exam_temp.setText(response.getString("anc1_exam_temp"));
//                            anc1_exam_proteinuria.setText(response.getString ("anc1_exam_proteinuria"));
                            anc1_exam_chest.setText(response.getString("anc1_exam_chest"));
                            anc1_exam_PA.setText(response.getString("anc1_exam_PA"));
                            anc1_exam_others.setText(response.getString("anc1_exam_others"));
//                            anc1_invest_bg.setText(response.getString ("anc1_invest_bg"));
                            anc1_invest_husband_bg.setText(response.getString("anc1_invest_husband_bg"));
                            anc1_invest_hemo.setText(response.getString("anc1_invest_hemo"));
                            anc1_invest_bloodsugar_fast.setText(response.getString("anc1_invest_bloodsugar_fast"));
                            anc1_invest_bloodsugar_post.setText(response.getString("anc1_invest_bloodsugar_post"));
                            anc1_invest_GTT_fast.setText(response.getString("anc1_invest_GTT_fast"));
                            anc1_invest_GTT_1hr.setText(response.getString("anc1_invest_GTT_1hr"));
                            anc1_invest_GTT_2hr.setText(response.getString("anc1_invest_GTT_2hr"));
                            anc1_invest_TSH.setText(response.getString("anc1_invest_TSH"));
                            anc1_invest_NT_done.setText(response.getString("anc1_invest_NT_done"));
                            anc1_invest_PAPP.setText(response.getString("anc1_invest_PAPP"));
                            anc1_invest_b_hcg.setText(response.getString("anc1_invest_b_hcg"));
                            anc1_invest_levelII_done.setText(response.getString("anc1_invest_levelII_done"));
                            anc1_invest_normal.setText(response.getString("anc1_invest_normal"));
                            anc1_invest_others.setText(response.getString("anc1_invest_others"));
//                            anc1_general_nutritional.setText(response.getString ("anc1_general_nutritional"));
//                            anc1_general_ailment.setText(response.getString ("anc1_general_ailment"));
                            anc1_general_ICT.setText(response.getString("anc1_general_ICT"));
                            anc1_general_others.setText(response.getString("anc1_general_others"));
                            anc_1.setChecked(response.getBoolean("anc_1"));
                            anc1_his_fever.setChecked(response.getBoolean("anc1_his_fever"));
                            anc1_his_rash.setChecked(response.getBoolean("anc1_his_rash"));
                            anc1_his_nausea_vomit.setChecked(response.getBoolean("anc1_his_nausea_vomit"));
                            anc1_his_bleed.setChecked(response.getBoolean("anc1_his_bleed"));
                            anc1_his_abdpain.setChecked(response.getBoolean("anc1_his_abdpain"));
                            anc1_drugin.setChecked(response.getBoolean("anc1_drugin"));
                            anc1_his_smoke.setChecked(response.getBoolean("anc1_drugin"));
                            anc1_his_alcohol.setChecked(response.getBoolean("anc1_his_alcohol"));
                            anc1_his_tob.setChecked(response.getBoolean("anc1_his_tob"));
                            anc1_his_caff.setChecked(response.getBoolean("anc1_his_caff"));
                            anc1_his_int.setChecked(response.getBoolean("anc1_his_int"));
                            anc1_exam_pallor.setChecked(response.getBoolean("anc1_exam_pallor"));
                            anc1_exam_lcterus.setChecked(response.getBoolean("anc1_exam_lcterus"));
                            anc1_exam_clubbing.setChecked(response.getBoolean("anc1_exam_clubbing"));
                            anc1_exam_cyanosis.setChecked(response.getBoolean("anc1_exam_cyanosis"));
                            anc1_exam_edem.setChecked(response.getBoolean("anc1_exam_edem"));
                            anc1_exam_lymp.setChecked(response.getBoolean("anc1_exam_lymp"));
                            anc1_invest_HIV.setChecked(response.getBoolean("anc1_invest_HIV"));
                            anc1_invest_hbsag.setChecked(response.getBoolean("anc1_invest_hbsag"));
                            anc1_invest_VDRL.setChecked(response.getBoolean("anc1_invest_VDRL"));
                            anc1_invest_urineRM.setChecked(response.getBoolean("anc1_invest_urineRM"));
                            anc1_invest_urineCS.setChecked(response.getBoolean("anc1_invest_urineCS"));
                            anc1_invest_CRL.setChecked(response.getBoolean("anc1_invest_CRL"));
                            anc1_invest_NT.setChecked(response.getBoolean("anc1_invest_NT"));
                            anc1_invest_centile.setChecked(response.getBoolean("anc1_invest_centile"));
                            anc1_invest_text.setChecked(response.getBoolean("anc1_invest_text"));
                            anc1_advice_Tfolate.setChecked(response.getBoolean("anc1_advice_Tfolate"));
                            anc1_advice_TFe.setChecked(response.getBoolean("anc1_advice_TFe"));
                            anc1_general_TSH.setChecked(response.getBoolean("anc1_general_TSH"));
                            anc1_general_T_nitro.setChecked(response.getBoolean("anc1_general_T_nitro"));
                            anc1_general_syp.setChecked(response.getBoolean("anc1_general_syp"));
                            anc1_general_Tvit.setChecked(response.getBoolean("anc1_general_Tvit"));
                            anc1_general_plenty.setChecked(response.getBoolean("anc1_general_plenty"));


                            newDate1.add(Calendar.DATE, 56);
                            anc2Date.setText("20 Weeks - " + sdf.format(newDate1.getTime()));
                            g = anc2Date.getText() + "";
                            Log.d("value", g);
                            callDateDiff(g);
                            // anc2_POG.setText(response.getString ("anc2_POG"));
                            anc2_his_others.setText(response.getString("anc2_his_others"));
                            anc2_exam_PR.setText(response.getString("anc2_exam_PR"));
                            anc2_exam_BP.setText(response.getString("anc2_exam_BP"));
                            anc2_exam_weight.setText(response.getString("anc2_exam_weight"));
                            anc2_exam_others.setText(response.getString("anc2_exam_others"));
                            anc2_invest_others.setText(response.getString("anc2_invest_others"));
                            anc2_advice_nutri.setText(response.getString("anc2_advice_nutri"));
                            anc2_advice_general.setText(response.getString("anc2_advice_general"));
                            anc2_advice_common.setText(response.getString("anc2_advice_common"));
                            anc2_advice_others.setText(response.getString("anc2_advice_others"));
                            anc_2.setChecked(response.getBoolean("anc_2"));
                            anc2_his_breath.setChecked(response.getBoolean("anc2_his_breath"));
                            anc2_his_fatigue.setChecked(response.getBoolean("anc2_his_fatigue"));
                            anc2_his_head.setChecked(response.getBoolean("anc2_his_head"));
                            anc2_his_bleed.setChecked(response.getBoolean("anc2_his_bleed"));
                            anc2_his_burn.setChecked(response.getBoolean("anc2_his_burn"));
                            anc2_his_quick_percieve.setChecked(response.getBoolean("anc2_his_quick_percieve"));
                            anc2_exam_pallor.setChecked(response.getBoolean("anc2_exam_pallor"));
                            anc2_exam_pedal.setChecked(response.getBoolean("anc2_exam_pedal"));
                            anc_2_pa_2weeks.setText(response.getString("anc_2_pa_2weeks"));
                            anc2_invest_quad.setChecked(response.getBoolean("anc2_invest_quad"));
                            anc2_invest_fetal.setChecked(response.getBoolean("anc2_invest_fetal"));
                            anc2_advice_OGTT.setChecked(response.getBoolean("anc2_advice_OGTT"));
                            anc2_advice_TFe.setChecked(response.getBoolean("anc2_advice_TFe"));
                            anc2_advice_TCa.setChecked(response.getBoolean("anc2_advice_TCa"));
                            anc2_advice_Hb_Talb.setChecked(response.getBoolean("anc2_advice_Hb_Talb"));
                            anc2_advice_Hb_TFe.setChecked(response.getBoolean("anc2_advice_Hb_TFe"));
                            anc2_advice_Hb_HPLC.setChecked(response.getBoolean("anc2_advice_Hb_HPLC"));
                            anc2_advice_Hb_peri.setChecked(response.getBoolean("anc2_advice_Hb_peri"));
                            anc2_advice_Hb_serum.setChecked(response.getBoolean("anc2_advice_Hb_serum"));
                            anc2_advice_tetanus.setChecked(response.getBoolean("anc2_advice_tetanus"));


                            newDate1.add(Calendar.DATE, 42);
                            anc3Date.setText("26 Weeks - " + sdf.format(newDate1.getTime()));
                            anc3_his_others.setText(response.getString("anc3_his_others"));
                            anc3_exam_PR.setText(response.getString("anc3_exam_PR"));
                            anc3_exam_BP.setText(response.getString("anc3_exam_BP"));
                            anc3_investigation_others.setText(response.getString("anc3_investigation_others"));
                            anc3_exam_weight.setText(response.getString("anc3_exam_weight"));
                            anc3_exam_others.setText(response.getString("anc3_exam_others"));
                            anc3_advice_others.setText(response.getString("anc3_advice_others"));
                            anc3_advice_nutri.setText(response.getString("anc3_advice_nutri"));
                            anc3_advice_general.setText(response.getString("anc3_advice_general"));
                            anc3_advice_common.setText(response.getString("anc3_advice_common"));
                            anc_3_pa_2weeks.setText(response.getString("anc_3_pa_2weeks"));
                            anc_3.setChecked(response.getBoolean("anc_3"));
                            anc3_his_breath.setChecked(response.getBoolean("anc3_his_breath"));
                            anc3_his_fatigue.setChecked(response.getBoolean("anc3_his_fatigue"));
                            anc3_his_head.setChecked(response.getBoolean("anc3_his_head"));
                            anc3_his_bleed.setChecked(response.getBoolean("anc3_his_bleed"));
                            anc3_his_leak.setChecked(response.getBoolean("anc3_his_leak"));
                            anc3_his_burn.setChecked(response.getBoolean("anc3_his_burn"));
                            anc3_his_fetal_move.setChecked(response.getBoolean("anc3_his_fetal_move"));
                            anc3_his_itching.setChecked(response.getBoolean("anc3_his_itching"));
                            anc3_exam_pallor.setChecked(response.getBoolean("anc3_exam_pallor"));
                            anc3_exam_pedal.setChecked(response.getBoolean("anc3_exam_pedal"));
                            anc3_invest_GTT_fast.setChecked(response.getBoolean("anc3_invest_GTT_fast"));
                            anc3_invest_GTT_1hr.setChecked(response.getBoolean("anc3_invest_GTT_1hr"));
                            anc3_invest_GTT_2hr.setChecked(response.getBoolean("anc3_invest_GTT_2hr"));
                            anc3_invest_CBC.setChecked(response.getBoolean("anc3_invest_CBC"));
                            anc3_invest_urine.setChecked(response.getBoolean("anc3_invest_urine"));
                            anc3_invest_ICT.setChecked(response.getBoolean("anc3_invest_ICT"));
                            anc3_advice_TFe.setChecked(response.getBoolean("anc3_advice_TFe"));
                            anc3_advice_DFMC.setChecked(response.getBoolean("anc3_advice_DFMC"));
                            anc3_advice_BleedPV.setChecked(response.getBoolean("anc3_advice_BleedPV"));
                            anc3_advice_spotPV.setChecked(response.getBoolean("anc3_advice_spotPV"));
                            anc3_advice_leakPV.setChecked(response.getBoolean("anc3_advice_leakPV"));
                            anc3_advice_fetalmove.setChecked(response.getBoolean("anc3_advice_fetalmove"));
                            anc3_advice_abdpain.setChecked(response.getBoolean("anc3_advice_abdpain"));
                            anc3_advice_injAntiD.setChecked(response.getBoolean("anc3_advice_injAntiD"));

                            newDate1.add(Calendar.DATE, 28);
                            anc4Date.setText("30 Weeks - " + sdf.format(newDate1.getTime()));
                            anc4_his_others.setText(response.getString("anc4_his_others"));
                            anc4_exam_PR.setText(response.getString("anc4_exam_PR"));
                            anc4_exam_BP.setText(response.getString("anc4_exam_BP"));
                            anc_4_pa_2weeks.setText(response.getString("anc_4_pa_2weeks"));
                            anc4_exam_weight.setText(response.getString("anc4_exam_weight"));
                            anc4_exam_others.setText(response.getString("anc4_exam_others"));
                            anc4_advice_others.setText(response.getString("anc4_advice_others"));
                            anc4_advice_nutri.setText(response.getString("anc4_advice_nutri"));
                            anc4_advice_general.setText(response.getString("anc4_advice_general"));
                            anc4_advice_common.setText(response.getString("anc4_advice_common"));
                            anc_4.setChecked(response.getBoolean("anc_4"));
                            anc4_his_breath.setChecked(response.getBoolean("anc4_his_breath"));
                            anc4_his_fatigue.setChecked(response.getBoolean("anc4_his_fatigue"));
                            anc4_his_head.setChecked(response.getBoolean("anc4_his_head"));
                            anc4_his_bleed.setChecked(response.getBoolean("anc4_his_bleed"));
                            anc4_his_burn.setChecked(response.getBoolean("anc4_his_burn"));
                            anc4_his_fetal_move.setChecked(response.getBoolean("anc4_his_fetal_move"));
                            anc4_his_itching.setChecked(response.getBoolean("anc4_his_itching"));
                            anc4_exam_pallor.setChecked(response.getBoolean("anc4_exam_pallor"));
                            anc4_exam_pedal.setChecked(response.getBoolean("anc4_exam_pedal"));
                            anc4_advice_TFe.setChecked(response.getBoolean("anc4_advice_TFe"));
                            anc4_advice_TCa.setChecked(response.getBoolean("anc4_advice_TCa"));
                            anc4_advice_DFMC.setChecked(response.getBoolean("anc4_advice_DFMC"));
                            anc4_advice_BleedPV.setChecked(response.getBoolean("anc4_advice_BleedPV"));
                            anc4_advice_spotPV.setChecked(response.getBoolean("anc4_advice_spotPV"));
                            anc4_advice_leakPV.setChecked(response.getBoolean("anc4_advice_leakPV"));
                            anc4_advice_fetalmove.setChecked(response.getBoolean("anc4_advice_fetalmove"));
                            anc4_advice_abdpain.setChecked(response.getBoolean("anc4_advice_abdpain"));
                            anc4_advice_USG.setChecked(response.getBoolean("anc4_advice_USG"));

                            newDate1.add(Calendar.DATE, 28);
                            anc5Date.setText("34 Weeks - " + sdf.format(newDate1.getTime()));
                            anc5_his_others.setText(response.getString("anc5_his_others"));
                            anc5_his_timing.setText(response.getString("anc5_his_timing"));
                            anc5_exam_BP.setText(response.getString("anc5_exam_BP"));
                            anc5_exam_weight.setText(response.getString("anc5_exam_weight"));
                            anc5_pa_2weeks.setText(response.getString("anc_5_pa_2weeks"));
                            anc5_exam_others.setText(response.getString("anc5_exam_others"));
                            anc5_invest_others.setText(response.getString("anc5_invest_others"));
                            anc5_USG_BPD_cm.setText(response.getString("anc5_USG_BPD_cm"));
                            anc5_USG_BPD_weeks.setText(response.getString("anc5_USG_BPD_weeks"));
                            anc5_USG_BPD_centile.setText(response.getString("anc5_USG_BPD_centile"));
                            anc5_USG_HC_cm.setText(response.getString("anc5_USG_HC_cm"));
                            anc5_USG_HC_weeks.setText(response.getString("anc5_USG_HC_weeks"));
                            anc5_USG_HC_centile.setText(response.getString("anc5_USG_HC_centile"));
                            anc5_USG_AC_cm.setText(response.getString("anc5_USG_AC_cm"));
                            anc5_USG_AC_weeks.setText(response.getString("anc5_USG_AC_weeks"));
                            anc5_USG_AC_centile.setText(response.getString("anc5_USG_AC_centile"));
                            anc5_USG_FL_cm.setText(response.getString("anc5_USG_FL_cm"));
                            anc5_USG_FL_weeks.setText(response.getString("anc5_USG_FL_weeks"));
                            anc5_USG_FL_centile.setText(response.getString("anc5_USG_FL_centile"));
                            anc5_USG_EFW_gm.setText(response.getString("anc5_USG_EFW_gm"));
                            anc5_USG_EFW_weeks.setText(response.getString("anc5_USG_EFW_weeks"));
                            anc5_USG_EFW_centile.setText(response.getString("anc5_USG_EFW_centile"));
                            anc5_USG_liquor_SLP.setText(response.getString("anc5_USG_liquor_SLP"));
                            anc5_USG_liquor_AFI.setText(response.getString("anc5_USG_liquor_AFI"));
                            anc5_USG_UAPI.setText(response.getString("anc5_USG_UAPI"));
                            anc5_USG_UAPI_centile.setText(response.getString("anc5_USG_UAPI_centile"));
                            anc5_USG_MCAPI.setText(response.getString("anc5_USG_MCAPI"));
                            anc5_USG_MCAPI_centile.setText(response.getString("anc5_USG_MCAPI_centile"));
                            anc5_advice_nutri.setText(response.getString("anc5_advice_nutri"));
                            anc5_advice_general.setText(response.getString("anc5_advice_general"));
                            anc5_advice_common.setText(response.getString("anc5_advice_common"));
                            anc5_advice_others.setText(response.getString("anc5_advice_others"));
                            anc_5.setChecked(response.getBoolean("anc_5"));
                            anc5_his_breath.setChecked(response.getBoolean("anc5_his_breath"));
                            anc5_his_fatigue.setChecked(response.getBoolean("anc5_his_fatigue"));
                            anc5_his_head.setChecked(response.getBoolean("anc5_his_head"));
                            anc5_his_bleed.setChecked(response.getBoolean("anc5_his_bleed"));
                            anc5_his_burn.setChecked(response.getBoolean("anc5_his_burn"));
                            anc5_his_fetal_move.setChecked(response.getBoolean("anc5_his_fetal_move"));
                            anc5_his_itching.setChecked(response.getBoolean("anc4_his_itching"));
                            anc5_his_vaginal_del.setChecked(response.getBoolean("anc5_his_vaginal_del"));
                            anc5_his_LSCS_del.setChecked(response.getBoolean("anc5_his_LSCS_del"));
                            anc5_his_birth_attendant.setChecked(response.getBoolean("anc5_his_birth_attendant"));
                            anc5_exam_pallor.setChecked(response.getBoolean("anc5_exam_pallor"));
                            anc5_invest_CBC.setChecked(response.getBoolean("anc5_invest_CBC"));
                            anc5_invest_LFT.setChecked(response.getBoolean("anc5_invest_LFT"));
                            anc5_invest_KFT.setChecked(response.getBoolean("anc5_invest_KFT"));
                            anc5_advice_DFMC.setChecked(response.getBoolean("anc5_advice_DFMC"));
                            anc5_advice_TFe_Ca.setChecked(response.getBoolean("anc5_advice_TFe_Ca"));
                            anc5_advice_BleedPV.setChecked(response.getBoolean("anc5_advice_BleedPV"));
                            anc5_advice_spotPV.setChecked(response.getBoolean("anc5_advice_spotPV"));
                            anc5_advice_leakPV.setChecked(response.getBoolean("anc5_advice_leakPV"));
                            anc5_advice_fetalmove.setChecked(response.getBoolean("anc5_advice_fetalmove"));
                            anc5_advice_abdpain.setChecked(response.getBoolean("anc5_advice_abdpain"));
                            anc5_advice_NST.setChecked(response.getBoolean("anc5_advice_NST"));

                            newDate1.add(Calendar.DATE, 14);
                            anc6Date.setText("36 Weeks - " + sdf.format(newDate1.getTime()));
                            anc6_his_others.setText(response.getString("anc6_his_others"));
                            anc6_exam_PR.setText(response.getString("anc6_exam_PR"));
                            anc6_exam_BP.setText(response.getString("anc6_exam_BP"));
                            anc6_pa_2weeks.setText(response.getString("anc6_pa_2weeks"));
                            anc6_exam_weight.setText(response.getString("anc6_exam_weight"));
                            anc6_exam_others.setText(response.getString("anc6_exam_others"));
                            anc6_exam_pelvic.setText(response.getString("anc6_exam_pelvic"));
                            anc6_advice_others.setText(response.getString("anc6_advice_others"));
                            anc_6.setChecked(response.getBoolean("anc_6"));
                            anc6_his_breath.setChecked(response.getBoolean("anc6_exam_pallor"));
                            anc6_his_fatigue.setChecked(response.getBoolean("anc6_his_fatigue"));
                            anc6_his_head.setChecked(response.getBoolean("anc6_his_head"));
                            anc6_his_bleed.setChecked(response.getBoolean("anc6_his_bleed"));
                            anc6_his_burn.setChecked(response.getBoolean("anc6_his_burn"));
                            anc6_his_fetal_move.setChecked(response.getBoolean("anc6_his_fetal_move"));
                            anc6_his_itching.setChecked(response.getBoolean("anc6_his_itching"));
                            anc6_exam_pallor.setChecked(response.getBoolean("anc6_exam_pallor"));
                            anc6_advice_DFMC.setChecked(response.getBoolean("anc6_advice_DFMC"));
                            anc6_advice_TFe_Ca.setChecked(response.getBoolean("anc6_advice_TFe_Ca"));
                            anc6_advice_BleedPV.setChecked(response.getBoolean("anc6_advice_BleedPV"));
                            anc6_advice_spotPV.setChecked(response.getBoolean("anc6_advice_spotPV"));
                            anc6_advice_leakPV.setChecked(response.getBoolean("anc6_advice_leakPV"));
                            anc6_advice_fetalmove.setChecked(response.getBoolean("anc6_advice_fetalmove"));
                            anc6_advice_abdpain.setChecked(response.getBoolean("anc6_advice_abdpain"));
                            anc6_advice_NST.setChecked(response.getBoolean("anc6_advice_NST"));

                            newDate1.add(Calendar.DATE, 14);
                            anc7Date.setText("38 Weeks - " + sdf.format(newDate1.getTime()));
                            anc7_his_others.setText(response.getString("anc7_his_others"));
                            anc7_exam_PR.setText(response.getString("anc7_exam_PR"));
                            anc7_exam_BP.setText(response.getString("anc7_exam_BP"));
                            anc7_pa_2weeks.setText(response.getString("anc7_pa_2weeks"));
                            anc7_exam_weight.setText(response.getString("anc7_exam_weight"));
                            anc7_exam_others.setText(response.getString("anc7_exam_others"));
                            anc7_advice_others.setText(response.getString("anc7_advice_others"));
                            anc_7.setChecked(response.getBoolean("anc_7"));
                            anc7_his_breath.setChecked(response.getBoolean("anc7_exam_pallor"));
                            anc7_his_fatigue.setChecked(response.getBoolean("anc7_his_fatigue"));
                            anc7_his_head.setChecked(response.getBoolean("anc7_his_head"));
                            anc7_his_bleed.setChecked(response.getBoolean("anc7_his_bleed"));
                            anc7_his_burn.setChecked(response.getBoolean("anc7_his_burn"));
                            anc7_his_fetal_move.setChecked(response.getBoolean("anc7_his_fetal_move"));
                            anc7_his_itching.setChecked(response.getBoolean("anc7_his_itching"));
                            anc7_exam_pallor.setChecked(response.getBoolean("anc7_exam_pallor"));
                            anc7_advice_DFMC.setChecked(response.getBoolean("anc7_advice_DFMC"));
                            anc7_advice_TFe_Ca.setChecked(response.getBoolean("anc7_advice_TFe_Ca"));
                            anc7_advice_BleedPV.setChecked(response.getBoolean("anc7_advice_BleedPV"));
                            anc7_advice_spotPV.setChecked(response.getBoolean("anc7_advice_spotPV"));
                            anc7_advice_leakPV.setChecked(response.getBoolean("anc7_advice_leakPV"));
                            anc7_advice_fetalmove.setChecked(response.getBoolean("anc7_advice_fetalmove"));
                            anc7_advice_abdpain.setChecked(response.getBoolean("anc7_advice_abdpain"));

                            newDate1.add(Calendar.DATE, 16);
                            anc8Date.setText("40 Weeks - " + sdf.format(newDate1.getTime()));
                            anc8_his_others.setText(response.getString("anc8_his_others"));
                            anc8_exam_PR.setText(response.getString("anc8_exam_PR"));
                            anc8_exam_BP.setText(response.getString("anc8_exam_BP"));
                            anc8_exam_weight.setText(response.getString("anc8_exam_weight"));
                            anc8_exam_others.setText(response.getString("anc8_exam_others"));
                            anc8_advice_others.setText(response.getString("anc8_advice_others"));
                            anc_8.setChecked(response.getBoolean("anc_8"));
                            anc8_his_breath.setChecked(response.getBoolean("anc8_exam_pallor"));
                            anc8_his_fatigue.setChecked(response.getBoolean("anc8_his_fatigue"));
                            anc8_his_head.setChecked(response.getBoolean("anc8_his_head"));
                            anc8_his_bleed.setChecked(response.getBoolean("anc8_his_bleed"));
                            anc8_his_burn.setChecked(response.getBoolean("anc8_his_burn"));
                            anc8_his_fetal_move.setChecked(response.getBoolean("anc8_his_fetal_move"));
                            anc8_his_itching.setChecked(response.getBoolean("anc8_his_itching"));
                            anc8_exam_pallor.setChecked(response.getBoolean("anc8_exam_pallor"));
                            anc8_exam_pa.setChecked(response.getBoolean("anc8_exam_pa"));
                            anc8_advice_DFMC.setChecked(response.getBoolean("anc8_advice_DFMC"));
                            anc8_advice_Fe_Ca.setChecked(response.getBoolean("anc8_advice_Fe_Ca"));
                            anc8_advice_induction.setChecked(response.getBoolean("anc8_advice_induction"));


                            eddDate.setText(sdf.format(newDate1.getTime()));
                            //set notifications

                        } catch (JSONException e) {
                            Log.i("Error", e.toString());
//                            e.printStackTrace();
                        } catch (ParseException e) {
                            Log.i("Error", e.toString());
//                            e.printStackTrace();
                        }
//                            edit.commit();
                    }


                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", "Error Message: " + error.getMessage());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                params.put("Authorization", "Token " + session.getUserDetails().get("Token"));
                return params;
            }
        };
        ApplicationController.getInstance().addToRequestQueue(jsonObjReq);

        UpdateData = (Button) findViewById(R.id.updatedatabydoc);
        LinearLayout a = (LinearLayout) findViewById(R.id.linearLayoutForAll);
        RelativeLayout b = (RelativeLayout) findViewById(R.id.updateButtonLayout);
        final HashMap<String, String> user = session.getUserDetails();
        if ("doctor".equals(user.get("type"))) {
//            a.removeView(b);
//            updateWhoData.setVisibility(View.GONE);
//            pb.setVisibility(View.GONE);
//            anc8_diabtese.setEnabled(false);
        }
        UpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });

//      Dropdown for status
        Spinner spinner = (Spinner) findViewById(R.id.Proteinuria);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ProteinuriaDropdownElements, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

//      Dropdown for education
        Spinner spinnerProteinuria = (Spinner) findViewById(R.id.blood_group);
        ArrayAdapter<CharSequence> adapterProteinuria = ArrayAdapter.createFromResource(this,
                R.array.BloodGroupDropdownElements, android.R.layout.simple_spinner_item);
        adapterProteinuria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProteinuria.setAdapter(adapterProteinuria);

    }

    public void updateData() {
//        UpdateData.setVisibility(View.GONE);
        String url = ApplicationController.get_base_url() + "swasthgarbh/patient/" + clickedPatientId;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.PATCH,
                url, null,


                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(patient_data_entry_bydoc.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
//                        Intent i = new Intent(PatientDataEntryByDoc.this, DoctorScreen.class);
//                        pb.setVisibility(View.GONE);
//                        startActivity(i);
//                        finish();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", "Error Message: " + error.getMessage());
            }
        }) {


            @Override
            public byte[] getBody() {
                JSONObject params = new JSONObject();
                try {
                    params.put("anc_1", anc_1.isChecked());
                    params.put("anc1_his_fever", anc1_his_fever.isChecked());
                    params.put("anc1_his_rash", anc1_his_rash.isChecked());
                    params.put("anc1_his_nausea_vomit", anc1_his_nausea_vomit.isChecked());
                    params.put("anc1_his_bleed", anc1_his_bleed.isChecked());
                    params.put("anc1_his_abdpain", anc1_his_abdpain.isChecked());
                    params.put("anc1_drugin", anc1_drugin.isChecked());
                    params.put("anc1_his_smoke", anc1_his_smoke.isChecked());
                    params.put("anc1_his_alcohol", anc1_his_alcohol.isChecked());
                    params.put("anc1_his_tob", anc1_his_tob.isChecked());
                    params.put("anc1_his_caff", anc1_his_caff.isChecked());
                    params.put("anc1_his_int", anc1_his_int.isChecked());
                    params.put("anc1_exam_pallor", anc1_exam_pallor.isChecked());
                    params.put("anc1_exam_lcterus", anc1_exam_lcterus.isChecked());
                    params.put("anc1_exam_clubbing", anc1_exam_clubbing.isChecked());
                    params.put("anc1_exam_cyanosis", anc1_exam_cyanosis.isChecked());
                    params.put("anc1_exam_edem", anc1_exam_edem.isChecked());
                    params.put("anc1_exam_lymp", anc1_exam_lymp.isChecked());
                    params.put("anc1_invest_HIV", anc1_invest_HIV.isChecked());
                    params.put("anc1_invest_hbsag", anc1_invest_hbsag.isChecked());
                    params.put("anc1_invest_VDRL", anc1_invest_VDRL.isChecked());
                    params.put("anc1_invest_urineRM", anc1_invest_urineRM.isChecked());
                    params.put("anc1_invest_urineCS", anc1_invest_urineCS.isChecked());
                    params.put("anc1_invest_CRL", anc1_invest_CRL.isChecked());
                    params.put("anc1_invest_NT", anc1_invest_NT.isChecked());
                    params.put("anc1_invest_centile", anc1_invest_centile.isChecked());
                    params.put("anc1_invest_text", anc1_invest_text.isChecked());
                    params.put("anc1_advice_Tfolate", anc1_advice_Tfolate.isChecked());
                    params.put("anc1_advice_TFe", anc1_advice_TFe.isChecked());
                    params.put("anc1_general_TSH", anc1_general_TSH.isChecked());
                    params.put("anc1_general_Tvit", anc1_general_Tvit.isChecked());
                    params.put("anc1_general_plenty", anc1_general_plenty.isChecked());
                    params.put("anc_2", anc_2.isChecked());
                    params.put("anc2_his_breath", anc2_his_breath.isChecked());
                    params.put("anc2_his_fatigue", anc2_his_fatigue.isChecked());
                    params.put("anc2_his_head", anc2_his_head.isChecked());
                    params.put("anc2_his_bleed", anc2_his_bleed.isChecked());
                    params.put("anc2_his_burn", anc2_his_burn.isChecked());
                    params.put("anc2_his_quick_percieve", anc2_his_quick_percieve.isChecked());
                    params.put("anc2_exam_pallor", anc2_exam_pallor.isChecked());
                    params.put("anc2_exam_pedal", anc2_exam_pedal.isChecked());
                    params.put("anc2_invest_quad", anc2_invest_quad.isChecked());
                    params.put("anc2_invest_fetal", anc2_invest_fetal.isChecked());
                    params.put("anc2_advice_OGTT", anc2_advice_OGTT.isChecked());
                    params.put("anc2_advice_TFe", anc2_advice_TFe.isChecked());
                    params.put("anc2_advice_TCa", anc2_advice_TCa.isChecked());
                    params.put("anc2_advice_Hb_Talb", anc2_advice_Hb_Talb.isChecked());
                    params.put("anc2_advice_Hb_TFe", anc2_advice_Hb_TFe.isChecked());
                    params.put("anc2_advice_Hb_HPLC", anc2_advice_Hb_HPLC.isChecked());
                    params.put("anc2_advice_Hb_peri", anc2_advice_Hb_peri.isChecked());
                    params.put("anc2_advice_Hb_serum", anc2_advice_Hb_serum.isChecked());
                    params.put("anc2_advice_tetanus", anc2_advice_tetanus.isChecked());
                    params.put("anc_3", anc_3.isChecked());
                    params.put("anc3_his_breath", anc3_his_breath.isChecked());
                    params.put("anc3_his_fatigue", anc3_his_fatigue.isChecked());
                    params.put("anc3_his_head", anc3_his_head.isChecked());
                    params.put("anc3_his_bleed", anc3_his_bleed.isChecked());
                    params.put("anc3_his_leak", anc3_his_leak.isChecked());
                    params.put("anc3_his_burn", anc3_his_burn.isChecked());
                    params.put("anc3_his_fetal_move", anc3_his_fetal_move.isChecked());
                    params.put("anc3_his_itching", anc3_his_itching.isChecked());
                    params.put("anc3_exam_pallor", anc3_exam_pallor.isChecked());
                    params.put("anc3_exam_pedal", anc3_exam_pedal.isChecked());
                    params.put("anc3_invest_GTT_fast", anc3_invest_GTT_fast.isChecked());
                    params.put("anc3_invest_GTT_1hr", anc3_invest_GTT_1hr.isChecked());
                    params.put("anc3_invest_GTT_2hr", anc3_invest_GTT_2hr.isChecked());
                    params.put("anc3_invest_CBC", anc3_invest_CBC.isChecked());
                    params.put("anc3_invest_urine", anc3_invest_urine.isChecked());
                    params.put("anc3_invest_ICT", anc3_invest_ICT.isChecked());
                    params.put("anc3_advice_TFe", anc3_advice_TFe.isChecked());
                    params.put("anc3_advice_DFMC", anc3_advice_DFMC.isChecked());
                    params.put("anc3_advice_BleedPV", anc3_advice_BleedPV.isChecked());
                    params.put("anc3_advice_spotPV", anc3_advice_spotPV.isChecked());
                    params.put("anc3_advice_leakPV", anc3_advice_leakPV.isChecked());
                    params.put("anc3_advice_fetalmove", anc3_advice_fetalmove.isChecked());
                    params.put("anc3_advice_abdpain", anc3_advice_abdpain.isChecked());
                    params.put("anc3_advice_injAntiD", anc3_advice_injAntiD.isChecked());
                    params.put("anc_4", anc_4.isChecked());
                    params.put("anc4_his_breath", anc4_his_breath.isChecked());
                    params.put("anc4_his_fatigue", anc4_his_fatigue.isChecked());
                    params.put("anc4_his_head", anc4_his_head.isChecked());
                    params.put("anc4_his_bleed", anc4_his_bleed.isChecked());
                    params.put("anc4_his_burn", anc4_his_burn.isChecked());
                    params.put("anc4_his_fetal_move", anc4_his_fetal_move.isChecked());
                    params.put("anc4_his_itching", anc4_his_itching.isChecked());
                    params.put("anc4_exam_pallor", anc4_exam_pallor.isChecked());
                    params.put("anc4_exam_pedal", anc4_exam_pedal.isChecked());
                    params.put("anc4_advice_TFe", anc4_advice_TFe.isChecked());
                    params.put("anc4_advice_TCa", anc4_advice_TCa.isChecked());
                    params.put("anc4_advice_DFMC", anc4_advice_DFMC.isChecked());
                    params.put("anc4_advice_BleedPV", anc4_advice_BleedPV.isChecked());
                    params.put("anc4_advice_spotPV", anc4_advice_spotPV.isChecked());
                    params.put("anc4_advice_leakPV", anc4_advice_leakPV.isChecked());
                    params.put("anc4_advice_fetalmove", anc4_advice_fetalmove.isChecked());
                    params.put("anc4_advice_abdpain", anc4_advice_abdpain.isChecked());
                    params.put("anc4_advice_USG", anc4_advice_USG.isChecked());
                    params.put("anc_5", anc_5.isChecked());
                    params.put("anc5_his_breath", anc5_his_breath.isChecked());
                    params.put("anc5_his_fatigue", anc5_his_fatigue.isChecked());
                    params.put("anc5_his_head", anc5_his_head.isChecked());
                    params.put("anc5_his_bleed", anc5_his_bleed.isChecked());
                    params.put("anc5_his_burn", anc5_his_burn.isChecked());
                    params.put("anc5_his_fetal_move", anc5_his_fetal_move.isChecked());
                    params.put("anc5_his_itching", anc5_his_itching.isChecked());
                    params.put("anc5_his_vaginal_del", anc5_his_vaginal_del.isChecked());
                    params.put("anc5_his_LSCS_del", anc5_his_LSCS_del.isChecked());
                    params.put("anc5_his_birth_attendant", anc5_his_birth_attendant.isChecked());
                    params.put("anc5_exam_pallor", anc5_exam_pallor.isChecked());
                    params.put("anc5_exam_pedal", anc5_exam_pedal.isChecked());
                    params.put("anc5_invest_CBC", anc5_invest_CBC.isChecked());
                    params.put("anc5_invest_LFT", anc5_invest_LFT.isChecked());
                    params.put("anc5_invest_KFT", anc5_invest_KFT.isChecked());
                    params.put("anc5_advice_DFMC", anc5_advice_DFMC.isChecked());
                    params.put("anc5_advice_TFe_Ca", anc5_advice_TFe_Ca.isChecked());
                    params.put("anc5_advice_BleedPV", anc5_advice_BleedPV.isChecked());
                    params.put("anc5_advice_spotPV", anc5_advice_spotPV.isChecked());
                    params.put("anc5_advice_leakPV", anc5_advice_leakPV.isChecked());
                    params.put("anc5_advice_fetalmove", anc5_advice_fetalmove.isChecked());
                    params.put("anc5_advice_abdpain", anc5_advice_abdpain.isChecked());
                    params.put("anc5_advice_NST", anc5_advice_NST.isChecked());
                    params.put("anc_6", anc_6.isChecked());
                    params.put("anc6_his_breath", anc6_his_breath.isChecked());
                    params.put("anc6_his_fatigue", anc6_his_fatigue.isChecked());
                    params.put("anc6_his_head", anc6_his_head.isChecked());
                    params.put("anc6_his_bleed", anc6_his_bleed.isChecked());
                    params.put("anc6_his_burn", anc6_his_burn.isChecked());
                    params.put("anc6_his_fetal_move", anc6_his_fetal_move.isChecked());
                    params.put("anc6_his_itching", anc6_his_itching.isChecked());
                    params.put("anc6_exam_pallor", anc6_exam_pallor.isChecked());
                    params.put("anc6_exam_pedal", anc6_exam_pedal.isChecked());
                    params.put("anc6_advice_DFMC", anc6_advice_DFMC.isChecked());
                    params.put("anc6_advice_TFe_Ca", anc6_advice_TFe_Ca.isChecked());
                    params.put("anc6_advice_BleedPV", anc6_advice_BleedPV.isChecked());
                    params.put("anc6_advice_spotPV", anc6_advice_spotPV.isChecked());
                    params.put("anc6_advice_leakPV", anc6_advice_leakPV.isChecked());
                    params.put("anc6_advice_fetalmove", anc6_advice_fetalmove.isChecked());
                    params.put("anc6_advice_abdpain", anc6_advice_abdpain.isChecked());
                    params.put("anc6_advice_NST", anc6_advice_NST.isChecked());
                    params.put("anc_7", anc_7.isChecked());
                    params.put("anc7_his_breath", anc7_his_breath.isChecked());
                    params.put("anc7_his_fatigue", anc7_his_fatigue.isChecked());
                    params.put("anc7_his_head", anc7_his_head.isChecked());
                    params.put("anc7_his_bleed", anc7_his_bleed.isChecked());
                    params.put("anc7_his_burn", anc7_his_burn.isChecked());
                    params.put("anc7_his_fetal_move", anc7_his_fetal_move.isChecked());
                    params.put("anc7_his_itching", anc7_his_itching.isChecked());
                    params.put("anc7_exam_pallor", anc7_exam_pallor.isChecked());
                    params.put("anc7_exam_pedal", anc7_exam_pedal.isChecked());
                    params.put("anc7_advice_DFMC", anc7_advice_DFMC.isChecked());
                    params.put("anc6_advice_TFe_Ca", anc7_advice_TFe_Ca.isChecked());
                    params.put("anc7_advice_BleedPV", anc7_advice_BleedPV.isChecked());
                    params.put("anc7_advice_spotPV", anc7_advice_spotPV.isChecked());
                    params.put("anc7_advice_leakPV", anc7_advice_leakPV.isChecked());
                    params.put("anc7_advice_fetalmove", anc7_advice_fetalmove.isChecked());
                    params.put("anc7_advice_abdpain", anc7_advice_abdpain.isChecked());
                    params.put("anc_8", anc_8.isChecked());
                    params.put("anc8_his_breath", anc8_his_breath.isChecked());
                    params.put("anc8_his_fatigue", anc8_his_fatigue.isChecked());
                    params.put("anc8_his_head", anc8_his_head.isChecked());
                    params.put("anc8_his_bleed", anc8_his_bleed.isChecked());
                    params.put("anc8_his_burn", anc8_his_burn.isChecked());
                    params.put("anc8_his_fetal_move", anc8_his_fetal_move.isChecked());
                    params.put("anc8_his_itching", anc8_his_itching.isChecked());
                    params.put("anc8_exam_pallor", anc8_exam_pallor.isChecked());
                    params.put("anc8_exam_pedal", anc8_exam_pedal.isChecked());
                    params.put("anc8_exam_pa", anc8_exam_pa.isChecked());
                    params.put("anc8_advice_DFMC", anc8_advice_DFMC.isChecked());
                    params.put("anc8_advice_Fe_Ca", anc8_advice_Fe_Ca.isChecked());
                    params.put("anc8_advice_induction", anc8_advice_induction.isChecked());
                    params.put("invest_chronic_hyper", invest_chronic_hyper.isChecked());
                    params.put("invest_type_2_diabetes", invest_type_2_diabetes.isChecked());
                    params.put("invest_RHD_native", invest_RHD_native.isChecked());
                    params.put("invest_RHD_post", invest_RHD_post.isChecked());
                    params.put("invest_acyanotic", invest_acyanotic.isChecked());
                    params.put("invest_cyanotic", invest_cyanotic.isChecked());
                    params.put("invest_chronic_liver", invest_chronic_liver.isChecked());
                    params.put("invest_chronic_kidney", invest_chronic_kidney.isChecked());
                    params.put("invest_APLA", invest_APLA.isChecked());
                    params.put("invest_SLE", invest_SLE.isChecked());

                    params.put("invest_others", "" + invest_others.getText());
                    params.put("anc_2_pa_2weeks", "" + anc_2_pa_2weeks.getText());
                    params.put("invest_drug_history", "" + invest_drug_history.getText());
                    params.put("anc_1_date", anc_1_dateTime);
                    params.put("anc_1_POG", "" + anc_1_POG.getText());
                    params.put("anc1_his_others", "" + anc1_his_others.getText());
                    params.put("anc_1_GeneralDeranged_fasting", "" + anc_1_GeneralDeranged_fasting.getText());
                    params.put("anc_1_GeneralDeranged_breakfast", "" + anc_1_GeneralDeranged_breakfast.getText());
                    params.put("anc_1_GeneralDeranged_lunch", "" + anc_1_GeneralDeranged_lunch.getText());
                    params.put("anc_1_GeneralDeranged_dinner", "" + anc_1_GeneralDeranged_dinner.getText());
                    params.put("anc1_exam_height", "" + anc1_exam_height.getText());
                    params.put("anc1_exam_weight", "" + anc1_exam_weight.getText());
                    params.put("anc1_exam_BMI", "" + anc1_exam_BMI.getText());
                    params.put("anc1_exam_PR", "" + anc1_exam_PR.getText());
                    params.put("anc1_exam_BP", "" + anc1_exam_BP.getText());
                    params.put("anc1_exam_RR", "" + anc1_exam_RR.getText());
                    params.put("anc1_exam_temp", "" + anc1_exam_temp.getText());
//                    params.put("anc1_exam_proteinuria","" +  anc1_exam_proteinuria.getText());
                    params.put("anc1_exam_chest", "" + anc1_exam_chest.getText());
                    params.put("anc1_exam_PA", "" + anc1_exam_PA.getText());
                    params.put("anc1_exam_others", "" + anc1_exam_others.getText());
//                    params.put("anc1_invest_bg", "" + anc1_invest_bg.getText());
                    params.put("anc1_invest_husband_bg", "" + anc1_invest_husband_bg.getText());
                    params.put("anc1_invest_hemo", "" + anc1_invest_hemo.getText());
                    params.put("anc1_invest_bloodsugar_fast", "" + anc1_invest_bloodsugar_fast.getText());
                    params.put("anc1_invest_bloodsugar_post", "" + anc1_invest_bloodsugar_post.getText());
                    params.put("anc1_invest_GTT_fast", "" + anc1_invest_GTT_fast.getText());
                    params.put("anc1_invest_GTT_1hr", "" + anc1_invest_GTT_1hr.getText());
                    params.put("anc1_invest_GTT_2hr", "" + anc1_invest_GTT_2hr.getText());
                    params.put("anc1_invest_TSH", "" + anc1_invest_TSH.getText());
                    params.put("anc1_invest_NT_done", "" + anc1_invest_NT_done.getText());
                    params.put("anc1_invest_PAPP", "" + anc1_invest_PAPP.getText());
                    params.put("anc1_invest_b_hcg", "" + anc1_invest_b_hcg.getText());
                    params.put("anc1_invest_levelII_done", "" + anc1_invest_levelII_done.getText());
                    params.put("anc1_invest_normal", "" + anc1_invest_normal.getText());
                    params.put("anc1_invest_others", "" + anc1_invest_others.getText());
//                    params.put("anc1_general_nutritional", anc1_general_nutritional.getText());
//                    params.put("anc1_general_ailment", anc1_general_ailment.getText());
                    params.put("anc1_general_ICT", "" + anc1_general_ICT.getText());
                    params.put("anc1_general_others", "" + anc1_general_others.getText());
                    params.put("anc2_POG", "" + anc2_POG.getText());
                    params.put("anc2_his_others", "" + anc2_his_others.getText());
                    params.put("anc2_exam_PR", "" + anc2_exam_PR.getText());
                    params.put("anc2_exam_BP", "" + anc2_exam_BP.getText());
                    params.put("anc2_exam_weight", "" + anc2_exam_weight.getText());
                    params.put("anc2_exam_others", "" + anc2_exam_others.getText());
                    params.put("anc2_invest_others", "" + anc2_invest_others.getText());
                    params.put("anc2_advice_nutri", "" + anc2_advice_nutri.getText());
                    params.put("anc2_advice_general", "" + anc2_advice_general.getText());
                    params.put("anc2_advice_common", "" + anc2_advice_common.getText());
                    params.put("anc2_advice_others", "" + anc2_advice_others.getText());
                    params.put("anc3_his_others", "" + anc3_his_others.getText());
                    params.put("anc3_exam_PR", "" + anc3_exam_PR.getText());
                    params.put("anc3_investigation_others", "" + anc3_investigation_others.getText());
                    params.put("anc3_exam_BP", "" + anc3_exam_BP.getText());
                    params.put("anc3_exam_weight", "" + anc3_exam_weight.getText());
                    params.put("anc3_exam_others", "" + anc3_exam_others.getText());
                    params.put("anc1_general_ailment", "" + anc1_general_ailment.getText());
                    params.put("anc3_advice_nutri", "" + anc3_advice_nutri.getText());
                    params.put("anc_3_pa_2weeks", "" + anc_3_pa_2weeks.getText());
                    params.put("anc3_advice_general", "" + anc3_advice_general.getText());
                    params.put("anc3_advice_common", "" + anc3_advice_common.getText());
                    params.put("anc3_advice_others", "" + anc3_advice_others.getText());
                    params.put("anc4_his_others", "" + anc4_his_others.getText());
                    params.put("anc4_exam_PR", "" + anc4_exam_PR.getText());
                    params.put("anc4_exam_BP", "" + anc4_exam_BP.getText());
                    params.put("anc_4_pa_2weeks", "" + anc_4_pa_2weeks.getText());
                    params.put("anc4_exam_weight", "" + anc4_exam_weight.getText());
                    params.put("anc4_exam_others", "" + anc4_exam_others.getText());
                    params.put("anc4_advice_nutri", "" + anc4_advice_nutri.getText());
                    params.put("anc4_advice_general", "" + anc4_advice_general.getText());
                    params.put("anc4_advice_common", "" + anc4_advice_common.getText());
                    params.put("anc4_advice_others", "" + anc4_advice_others.getText());
                    params.put("anc5_his_others", "" + anc5_his_others.getText());
                    params.put("anc5_his_timing", "" + anc5_his_timing.getText());
                    params.put("anc5_exam_PR", "" + anc5_exam_PR.getText());
                    params.put("anc_5_pa_2weeks", "" + anc5_pa_2weeks.getText());
                    params.put("anc5_exam_BP", "" + anc5_exam_BP.getText());
                    params.put("anc5_exam_weight", "" + anc5_exam_weight.getText());
                    params.put("anc5_exam_others", "" + anc5_exam_others.getText());
                    params.put("anc5_invest_others", "" + anc5_invest_others.getText());
                    params.put("anc5_USG_BPD_cm", "" + anc5_USG_BPD_cm.getText());
                    params.put("anc5_USG_BPD_weeks", "" + anc5_USG_BPD_weeks.getText());
                    params.put("anc5_USG_BPD_centile", "" + anc5_USG_BPD_centile.getText());
                    params.put("anc5_USG_HC_cm", "" + anc5_USG_HC_cm.getText());
                    params.put("anc5_USG_HC_weeks", "" + anc5_USG_HC_weeks.getText());
                    params.put("anc5_USG_HC_centile", "" + anc5_USG_HC_centile.getText());
                    params.put("anc5_USG_AC_cm", "" + anc5_USG_AC_cm.getText());
                    params.put("anc5_USG_AC_weeks", "" + anc5_USG_AC_weeks.getText());
                    params.put("anc5_USG_AC_centile", "" + anc5_USG_AC_centile.getText());
                    params.put("anc5_USG_FL_cm", "" + anc5_USG_FL_cm.getText());
                    params.put("anc5_USG_FL_weeks", "" + anc5_USG_FL_weeks.getText());
                    params.put("anc5_USG_FL_centile", "" + anc5_USG_FL_centile.getText());
                    params.put("anc5_USG_EFW_gm", "" + anc5_USG_EFW_gm.getText());
                    params.put("anc5_USG_EFW_weeks", "" + anc5_USG_EFW_weeks.getText());
                    params.put("anc5_USG_EFW_centile", "" + anc5_USG_EFW_centile.getText());
                    params.put("anc5_USG_liquor_SLP", "" + anc5_USG_liquor_SLP.getText());
                    params.put("anc5_USG_liquor_AFI", "" + anc5_USG_liquor_AFI.getText());
                    params.put("anc5_USG_UAPI", "" + anc5_USG_UAPI.getText());
                    params.put("anc5_USG_UAPI_centile", "" + anc5_USG_UAPI_centile.getText());
                    params.put("anc5_USG_MCAPI", "" + anc5_USG_MCAPI.getText());
                    params.put("anc5_USG_MCAPI_centile", "" + anc5_USG_MCAPI_centile.getText());
                    params.put("anc5_advice_nutri", "" + anc5_advice_nutri.getText());
                    params.put("anc5_advice_general", "" + anc5_advice_general.getText());
                    params.put("anc5_advice_common", "" + anc5_advice_common.getText());
                    params.put("anc5_advice_others", "" + anc5_advice_others.getText());
                    params.put("anc6_his_others", "" + anc6_his_others.getText());
                    params.put("anc6_exam_PR", "" + anc6_exam_PR.getText());
                    params.put("anc6_exam_BP", "" + anc6_exam_BP.getText());
                    params.put("anc6_pa_2weeks", "" + anc6_pa_2weeks.getText());
                    params.put("anc6_exam_weight", "" + anc6_exam_weight.getText());
                    params.put("anc6_exam_others", "" + anc6_exam_others.getText());
                    params.put("anc6_exam_pelvic", "" + anc6_exam_pelvic.getText());
                    params.put("anc6_advice_others", "" + anc6_advice_others.getText());
                    params.put("anc7_his_others", "" + anc7_his_others.getText());
                    params.put("anc7_exam_PR", "" + anc7_exam_PR.getText());
                    params.put("anc7_exam_BP", "" + anc7_exam_BP.getText());
                    params.put("anc7_pa_2weeks", "" + anc7_pa_2weeks.getText());
                    params.put("anc7_exam_weight", "" + anc7_exam_weight.getText());
                    params.put("anc7_exam_others", "" + anc7_exam_others.getText());
                    params.put("anc7_advice_others", "" + anc7_advice_others.getText());
                    params.put("anc8_his_others", "" + anc8_his_others.getText());
                    params.put("anc8_exam_PR", "" + anc8_exam_PR.getText());
                    params.put("anc8_exam_BP", "" + anc8_exam_BP.getText());
                    params.put("anc8_exam_weight", "" + anc8_exam_weight.getText());
                    params.put("anc8_exam_others", "" + anc8_exam_others.getText());
                    params.put("anc8_advice_others", "" + anc8_advice_others.getText());


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return params.toString().getBytes();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Token " + session.getUserDetails().get("Token"));
                Log.d("TAG", "Token " + session.getUserDetails().get("Token"));
                return params;
            }
        };
        ApplicationController.getInstance().addToRequestQueue(jsonObjReq);
    }
}

