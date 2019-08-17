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

    TextView anc1_Date_Automatic, anc2_Date_Automatic, anc3_Date_Automatic, anc4_Date_Automatic, anc5_Date_Automatic, anc6_Date_Automatic, anc7_Date_Automatic, anc8_Date_Automatic;

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
    CheckBox anc4_history_ShortnessOfBreath, anc4_history_EasyFatiguability, anc4_history_HeadacheEpigastricPain, anc4_history_BleedingSpottingPV, anc4_history_BurningMicturition, anc4_history_FetalMovements, anc4_history_Itching;
    EditText anc4_history_Others;

    CheckBox anc4_examination_Pallor, anc4_examination_PedalEdema;
    EditText anc4_examination_PR, anc4_examination_BP, anc4_examination_Weight, anc4_examination_PA2Weeks, anc4_examination_UrineCulture, anc4_examination_ICT;

    EditText anc4_examination_CBC_HB, anc4_examination_CBC_TLC, anc4_examination_CBC_Platelets;
    EditText anc4_examination_LFT_OT, anc4_examination_LFT_PT, anc4_examination_LFT_ALP;
    EditText anc4_examination_KFT_UREA, anc4_examination_KFT_Creatinine;

    CheckBox anc4_advice_TFeOD, anc4_advice_TCaBD, anc4_advice_DFMC, anc4_advice_USG;
    CheckBox anc4_advice_review_Bleeding, anc4_advice_review_Spotting, anc4_advice_review_Leaking, anc4_advice_review_ReducedFM, anc4_advice_review_AbdomenPain;
    EditText anc4_advice_Nutritional, anc4_advice_General, anc4_advice_CommonAilment, anc4_advice_Others;

//    ANC5 Variables
    CheckBox anc5_history_ShortnessOfBreath, anc5_history_EasyFatiguability, anc5_history_HeadacheEpigastricPain, anc5_history_BleedingSpottingPV, anc5_history_BurningMicturition, anc5_history_FetalMovements, anc5_history_Itching;
    EditText anc5_history_Others;

    CheckBox anc5_history_counseling_ModeOfDel_Vaginal, anc5_history_counseling_ModeOfDel_LSCS;
    EditText anc5_history_counseling_Timing;
    CheckBox anc5_history_counseling_BirthAttendant;

    CheckBox anc5_examination_Pallor, anc5_examination_PedalEdema;
    EditText anc5_examination_PR, anc5_examination_BP, anc5_examination_Weight, anc5_examination_PA2Weeks, anc5_examination_Others;
    CheckBox anc5_investigation_CBC, anc5_investigation_LFT, anc5_investigation_KFT;
    EditText anc5_investigation_Others;

    EditText anc5_USG_BPD_cm, anc5_USG_BPD_weeks, anc5_USG_BPD_centile;
    EditText anc5_USG_HC_cm, anc5_USG_HC_weeks, anc5_USG_HC_centile;
    EditText anc5_USG_AC_cm, anc5_USG_AC_weeks, anc5_USG_AC_centile;
    EditText anc5_USG_FL_cm, anc5_USG_FL_weeks, anc5_USG_FL_centile;
    EditText anc5_USG_EFW_gm, anc5_USG_EFW_weeks, anc5_USG_EFW_centile;
    EditText anc5_USG_liquor_SLP, anc5_USG_liquor_AFI;
    EditText anc5_USG_UAPI, anc5_USG_UAPI_centile;
    EditText anc5_USG_MCAPI, anc5_USG_MCAPI_centile;
    CheckBox anc5_USG_CPR;

    CheckBox anc5_advice_DFMCLLP, anc5_advice_TFeCa, anc5_advice_NST;
    EditText anc5_advice_Nutritional, anc5_advice_General, anc5_advice_CommonAilment;
    CheckBox anc5_advice_review_Bleeding, anc5_advice_review_Spotting, anc5_advice_review_Leaking, anc5_advice_review_ReducedFM, anc5_advice_review_AbdomenPain;
    EditText anc5_advice_Others;

//    ANC6 Variables
    CheckBox anc6_history_ShortnessOfBreath, anc6_history_EasyFatiguability, anc6_history_HeadacheEpigastricPain, anc6_history_BleedingSpottingPV, anc6_history_BurningMicturition, anc6_history_FetalMovements, anc6_history_Itching;
    EditText anc6_history_Others;

    CheckBox anc6_examination_Pallor, anc6_examination_PedalEdema;
    EditText anc6_examination_PR, anc6_examination_BP, anc6_examination_Weight, anc6_examination_PA2Weeks, anc6_examination_Others;

    EditText anc6_Pelvic;

    CheckBox anc6_advice_DFMCLLP, anc6_advice_TFeCa, anc6_advice_NST;
    CheckBox anc6_advice_review_Bleeding, anc6_advice_review_Spotting, anc6_advice_review_Leaking, anc6_advice_review_ReducedFM, anc6_advice_review_AbdomenPain;
    EditText anc6_advice_Others;

//    ANC7 Variables
    CheckBox anc7_history_ShortnessOfBreath, anc7_history_EasyFatiguability, anc7_history_HeadacheEpigastricPain, anc7_history_BleedingSpottingPV, anc7_history_BurningMicturition, anc7_history_FetalMovements, anc7_history_Itching;
    EditText anc7_history_Others;

    CheckBox anc7_examination_Pallor, anc7_examination_PedalEdema;
    EditText anc7_examination_PR, anc7_examination_BP, anc7_examination_Weight, anc7_examination_Pa2Weeks, anc7_examination_Others;

    CheckBox anc7_advice_DFMCLLP, anc7_advice_TFeCa, anc7_advice_Bleeding, anc7_advice_Spotting, anc7_advice_Leaking, anc7_advice_ReducedFM, anc7_advice_AbdomenPain;
    EditText anc7_advice_Others;

//    ANC8 Variables
    CheckBox anc8_history_ShortnessOfBreath, anc8_history_EasyFatiguability, anc8_history_HeadacheEpigastricPain, anc8_history_BleedingSpottingPV, anc8_history_BurningMicturition, anc8_history_FetalMovements, anc8_history_Itching;
    EditText anc8_history_Others;

    CheckBox anc8_examination_Pallor, anc8_examination_PedalEdema, anc8_examination_PA;
    EditText anc8_examination_PR, anc8_examination_BP, anc8_examination_Weight, anc8_examination_Others;

    CheckBox anc8_advice_DFMCLLP, anc8_advice_FeCa, anc8_advice_Induction;
    EditText anc8_advice_Others;

    Calendar anc1_Date_Calender = Calendar.getInstance();
    Calendar anc2_Date_Calender = Calendar.getInstance();
    Calendar anc3_Date_Calender = Calendar.getInstance();
    Calendar anc4_Date_Calender = Calendar.getInstance();
    Calendar anc5_Date_Calender = Calendar.getInstance();
    Calendar anc6_Date_Calender = Calendar.getInstance();
    Calendar anc7_Date_Calender = Calendar.getInstance();
    Calendar anc8_Date_Calender = Calendar.getInstance();

    String anc1_Date_String;
    String anc2_Date_String;
    String anc3_Date_String;
    String anc4_Date_String;
    String anc5_Date_String;
    String anc6_Date_String;
    String anc7_Date_String;
    String anc8_Date_String;

    EditText anc3_Date;
    EditText anc4_Date;
    EditText anc5_Date;
    EditText anc6_Date;
    EditText anc7_Date;
    EditText anc8_Date;

    private DatePickerDialog anc1_datePickerDialog;
    private DatePickerDialog anc2_datePickerDialog;
    private DatePickerDialog anc3_datePickerDialog;
    private DatePickerDialog anc4_datePickerDialog;
    private DatePickerDialog anc5_datePickerDialog;
    private DatePickerDialog anc6_datePickerDialog;
    private DatePickerDialog anc7_datePickerDialog;
    private DatePickerDialog anc8_datePickerDialog;

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
//        String[] temp = anc_1_dateTime.split("-");
//        String date_year = temp[2];
//        String date_month = temp[1];
//        String date_date = temp[0];
//
//        anc_1_dateTime = date_date + "/" + date_month + "/" + date_year;
//        Log.d("ancdatee =", anc_1_dateTime);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//        try {
//            Date d1 = sdf.parse(anc_1_dateTime);
//            Log.i("d1", anc_1_dateTime);
//            Date d2 = sdf.parse(lmpDateString);
//            Log.i("d1", lmpDateString);
//            long diff = d1.getTime() - d2.getTime();
//            Log.i("difference", "" + diff);
//            long days = diff / (24 * 60 * 60 * 1000);
//            long month = days / 30;
//
//            days = days % 30;
//
//            Log.i("month", "" + month);
//            Log.i("days", "" + days);
//            String m = "";
//            if (month == 1) {
//                m = month + " Month " + " and " + days + " Days";
//            } else if (month > 1) {
//                m = month + " Months " + " and " + days + " Days";
//            } else {
//                Toast.makeText(this, "Invalid Date!", Toast.LENGTH_SHORT).show();
//            }
//            Log.d("final m =", m);
//            anc1_POG.setText(m);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_data_entry_bydoc);

        dateFormatterShow = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateFormatterServer = new SimpleDateFormat("dd-MM-yyyy");

        anc1_Date = (EditText) findViewById(R.id.anc1_Date);
        anc2_Date = (EditText) findViewById(R.id.anc2_Date);
        anc3_Date = (EditText) findViewById(R.id.anc2_Date);
        anc4_Date = (EditText) findViewById(R.id.anc2_Date);
        anc5_Date = (EditText) findViewById(R.id.anc2_Date);
        anc6_Date = (EditText) findViewById(R.id.anc2_Date);
        anc7_Date = (EditText) findViewById(R.id.anc2_Date);
        anc8_Date = (EditText) findViewById(R.id.anc2_Date);

        Calendar newCalendar = Calendar.getInstance();
        anc1_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anc1_datePickerDialog.show();
            }
        });
        anc2_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anc2_datePickerDialog.show();
            }
        });
        anc3_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anc3_datePickerDialog.show();
            }
        });
        anc4_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anc4_datePickerDialog.show();
            }
        });
        anc5_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anc5_datePickerDialog.show();
            }
        });
        anc6_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anc6_datePickerDialog.show();
            }
        });
        anc7_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anc7_datePickerDialog.show();
            }
        });
        anc8_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anc8_datePickerDialog.show();
            }
        });

        anc1_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc1_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc1_Date.setText(dateFormatterShow.format(anc1_Date_Calender.getTime()));
                anc1_Date_String = dateFormatterShow.format(anc1_Date_Calender.getTime());
                callDateDiff();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc2_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc2_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc1_Date.setText(dateFormatterShow.format(anc2_Date_Calender.getTime()));
                anc2_Date_String = dateFormatterShow.format(anc2_Date_Calender.getTime());
                callDateDiff();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc3_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc3_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc3_Date.setText(dateFormatterShow.format(anc3_Date_Calender.getTime()));
                anc3_Date_String = dateFormatterShow.format(anc3_Date_Calender.getTime());
                callDateDiff();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc4_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc4_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc4_Date.setText(dateFormatterShow.format(anc4_Date_Calender.getTime()));
                anc4_Date_String = dateFormatterShow.format(anc4_Date_Calender.getTime());
                callDateDiff();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc5_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc5_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc5_Date.setText(dateFormatterShow.format(anc5_Date_Calender.getTime()));
                anc5_Date_String = dateFormatterShow.format(anc5_Date_Calender.getTime());
                callDateDiff();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc6_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc6_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc6_Date.setText(dateFormatterShow.format(anc6_Date_Calender.getTime()));
                anc6_Date_String = dateFormatterShow.format(anc6_Date_Calender.getTime());
                callDateDiff();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc7_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc7_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc7_Date.setText(dateFormatterShow.format(anc7_Date_Calender.getTime()));
                anc7_Date_String = dateFormatterShow.format(anc7_Date_Calender.getTime());
                callDateDiff();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc8_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc8_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc8_Date.setText(dateFormatterShow.format(anc8_Date_Calender.getTime()));
                anc8_Date_String = dateFormatterShow.format(anc8_Date_Calender.getTime());
                callDateDiff();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

//        ANC1 Variables
        anc1_History_Fever = (CheckBox) findViewById(R.id.anc1_History_Fever);
        anc1_History_Rash = (CheckBox) findViewById(R.id.anc1_History_Rash);
        anc1_History_Nausea = (CheckBox) findViewById(R.id.anc1_History_Nausea);
        anc1_History_Bleeding = (CheckBox) findViewById(R.id.anc1_History_Bleeding);
        anc1_History_AbdomenPain = (CheckBox) findViewById(R.id.anc1_History_AbdomenPain);
        anc1_History_DrugIntake = (CheckBox) findViewById(R.id.anc1_History_DrugIntake);
        anc1_History_Smoking = (CheckBox) findViewById(R.id.anc1_History_Smoking);
        anc1_History_Alcohol = (CheckBox) findViewById(R.id.anc1_History_Alcohol);
        anc1_History_TobaccoIntake = (CheckBox) findViewById(R.id.anc1_History_TobaccoIntake);
        anc1_History_CaffeineIntake = (CheckBox) findViewById(R.id.anc1_History_CaffeineIntake);
        anc1_History_IntimatePartnerViolence = (CheckBox) findViewById(R.id.anc1_History_IntimatePartnerViolence);

        anc1_history_Others = (EditText) findViewById(R.id.anc1_history_Others);

        anc1_examination_general_Pallor = (CheckBox) findViewById(R.id.anc1_examination_general_Pallor);
        anc1_examination_general_Lcterus = (CheckBox) findViewById(R.id.anc1_examination_general_Lcterus);
        anc1_examination_general_Clubbing = (CheckBox) findViewById(R.id.anc1_examination_general_Clubbing);
        anc1_examination_general_Cyanosis = (CheckBox) findViewById(R.id.anc1_examination_general_Cyanosis);
        anc1_examination_general_Edema = (CheckBox) findViewById(R.id.anc1_examination_general_Edema);
        anc1_examination_general_Lymphadenopathy = (CheckBox) findViewById(R.id.anc1_examination_general_Lymphadenopathy);

        anc1_examination_anthropometry_Height = (EditText) findViewById(R.id.anc1_examination_anthropometry_Height);
        anc1_examination_anthropometry_Weight = (EditText) findViewById(R.id.anc1_examination_anthropometry_Weight);
        anc1_examination_anthropometry_Bmi = (EditText) findViewById(R.id.anc1_examination_anthropometry_Bmi);
        anc1_examination_vitals_Pr = (EditText) findViewById(R.id.anc1_examination_vitals_Pr);
        anc1_examination_vitals_Bp = (EditText) findViewById(R.id.anc1_examination_vitals_Bp);
        anc1_examination_vitals_Rr = (EditText) findViewById(R.id.anc1_examination_vitals_Rr);
        anc1_examination_vitals_Temp = (EditText) findViewById(R.id.anc1_examination_vitals_Temp);
        anc1_examination_vitals_ChestCVS = (EditText) findViewById(R.id.anc1_examination_vitals_ChestCVS);
        anc1_examination_vitals_PA = (EditText) findViewById(R.id.anc1_examination_vitals_PA);
        anc1_examination_vitals_Proteinuria = (Spinner) findViewById(R.id.anc1_examination_vitals_Proteinuria);

        anc1_investigations_HIV = (CheckBox) findViewById(R.id.anc1_investigations_HIV);
        anc1_investigations_Hbsag = (CheckBox) findViewById(R.id.anc1_investigations_Hbsag);
        anc1_investigations_Vdrl = (CheckBox) findViewById(R.id.anc1_investigations_Vdrl);
        anc1_investigations_UrineRM = (CheckBox) findViewById(R.id.anc1_investigations_UrineRM);
        anc1_investigations_UrineCS = (CheckBox) findViewById(R.id.anc1_investigations_UrineCS);

        anc1_investigations_HIV_switch = (Switch) findViewById(R.id.anc1_investigations_HIV_switch);
        anc1_investigations_Hbsag_switch = (Switch) findViewById(R.id.anc1_investigations_Hbsag_switch);
        anc1_investigations_Vdrl_switch = (Switch) findViewById(R.id.anc1_investigations_Vdrl_switch);
        anc1_investigations_UrineRM_switch = (Switch) findViewById(R.id.anc1_investigations_UrineRM_switch);
        anc1_investigations_UrineCS_switch = (Switch) findViewById(R.id.anc1_investigations_UrineCS_switch);

        anc1_investigations_BloodGroup = (Spinner) findViewById(R.id.anc1_investigations_BloodGroup);
        anc1_investigations_HusbandBloodGroup = (Spinner) findViewById(R.id.anc1_investigations_HusbandBloodGroup);

        anc1_investigations_Hemogram = (EditText) findViewById(R.id.anc1_investigations_Hemogram);
        anc1_investigations_Tsh = (EditText) findViewById(R.id.anc1_investigations_Tsh);
        anc1_investigations_GTT_fast = (EditText) findViewById(R.id.anc1_investigations_GTT_fast);
        anc1_investigations_GTT_1Hour = (EditText) findViewById(R.id.anc1_investigations_GTT_1Hour);
        anc1_investigations_GTT_2Hour = (EditText) findViewById(R.id.anc1_investigations_GTT_2Hour);
        anc1_investigations_bloodSugar_Fasting = (EditText) findViewById(R.id.anc1_investigations_bloodSugar_Fasting);
        anc1_investigations_bloodSugar_PostPrandial = (EditText) findViewById(R.id.anc1_investigations_bloodSugar_PostPrandial);
        anc1_investigations_ntnb_DoneNotDone = (EditText) findViewById(R.id.anc1_investigations_ntnb_DoneNotDone);
        anc1_investigations_ntnb_CRL = (CheckBox) findViewById(R.id.anc1_investigations_ntnb_CRL);
        anc1_investigations_ntnb_NT = (CheckBox) findViewById(R.id.anc1_investigations_ntnb_NT);
        anc1_investigations_ntnb_Centile = (CheckBox) findViewById(R.id.anc1_investigations_ntnb_Centile);
        anc1_investigations_ntnb_Text = (CheckBox) findViewById(R.id.anc1_investigations_ntnb_Text);

        anc1_investigations_dualScreen_PAPP = (EditText) findViewById(R.id.anc1_investigations_dualScreen_PAPP);
        anc1_investigations_dualScreen_Bhcg = (EditText) findViewById(R.id.anc1_investigations_dualScreen_Bhcg);
        anc1_investigations_level2Usg_DoneNotDone = (EditText) findViewById(R.id.anc1_investigations_level2Usg_DoneNotDone);
        anc1_investigations_level2Usg_NormalAbnormal = (EditText) findViewById(R.id.anc1_investigations_level2Usg_NormalAbnormal);
        anc1_advice_GTT = (EditText) findViewById(R.id.anc1_advice_GTT);
        anc1_advice_BloodSugar = (EditText) findViewById(R.id.anc1_advice_BloodSugar);
        anc1_advice_NtNbScan = (EditText) findViewById(R.id.anc1_advice_NtNbScan);
        anc1_advice_DualScreen = (EditText) findViewById(R.id.anc1_advice_DualScreen);
        anc1_advice_LeftUterineArteryPl = (EditText) findViewById(R.id.anc1_advice_LeftUterineArteryPl);
        anc1_advice_RightUterineArteryPl = (EditText) findViewById(R.id.anc1_advice_RightUterineArteryPl);
        anc1_advice_PIGF = (EditText) findViewById(R.id.anc1_advice_PIGF);
        anc1_advice_ICT = (EditText) findViewById(R.id.anc1_advice_ICT);
        anc1_advice_GeneralNutritional = (CheckBox) findViewById(R.id.anc1_advice_GeneralNutritional);
        anc1_advice_GeneralAilments = (CheckBox) findViewById(R.id.anc1_advice_GeneralAilments);

        anc1_general_BgNegICT = (EditText) findViewById(R.id.anc1_general_BgNegICT);
        anc1_general_TSH = (CheckBox) findViewById(R.id.anc1_general_TSH);
        anc1_general_urineCulture_Nitrofur = (CheckBox) findViewById(R.id.anc1_general_urineCulture_Nitrofur);
        anc1_general_urineCulture_Syp = (CheckBox) findViewById(R.id.anc1_general_urineCulture_Syp);
        anc1_general_urineCulture_VitC = (CheckBox) findViewById(R.id.anc1_general_urineCulture_VitC);
        anc1_general_urineCulture_PlentyFluids = (CheckBox) findViewById(R.id.anc1_general_urineCulture_PlentyFluids);

        anc1_general_deranged_Fasting = (EditText) findViewById(R.id.anc1_general_deranged_Fasting);
        anc1_general_deranged_AfterBreakfast = (EditText) findViewById(R.id.anc1_general_deranged_AfterBreakfast);
        anc1_general_deranged_AfterLunch = (EditText) findViewById(R.id.anc1_general_deranged_AfterLunch);
        anc1_general_deranged_AfterDinner = (EditText) findViewById(R.id.anc1_general_deranged_AfterDinner);
        anc1_general_Others = (EditText) findViewById(R.id.anc1_general_Others);

//        ANC2 Variables
        anc2_Date = (EditText) findViewById(R.id.anc2_Date);
        anc2_POG = (EditText) findViewById(R.id.anc2_POG);

        anc2_history_ShortnessOfBreath = (CheckBox) findViewById(R.id.anc2_history_ShortnessOfBreath);
        anc2_history_EasyFatiguability = (CheckBox) findViewById(R.id.anc2_history_EasyFatiguability);
        anc2_history_HeadacheEpigastricPain = (CheckBox) findViewById(R.id.anc2_history_HeadacheEpigastricPain);
        anc2_history_BleedingSpottingPv = (CheckBox) findViewById(R.id.anc2_history_BleedingSpottingPv);
        anc2_history_BurningMicturition = (CheckBox) findViewById(R.id.anc2_history_BurningMicturition);
        anc2_history_QuickeningPerceived = (CheckBox) findViewById(R.id.anc2_history_QuickeningPerceived);
        anc2_history_Others = (EditText) findViewById(R.id.anc2_history_Others);

        anc2_examination_Pallor = (CheckBox) findViewById(R.id.anc2_examination_Pallor);
        anc2_examination_PedalEdema = (CheckBox) findViewById(R.id.anc2_examination_PedalEdema);
        anc2_examination_PR = (EditText) findViewById(R.id.anc2_examination_PR);
        anc2_examination_BP = (EditText) findViewById(R.id.anc2_examination_BP);
        anc2_examination_Weight = (EditText) findViewById(R.id.anc2_examination_Weight);
        anc2_examination_PA2Weeks = (EditText) findViewById(R.id.anc2_examination_PA2Weeks);
        anc2_examination_Others = (EditText) findViewById(R.id.anc2_examination_Others);

        anc2_investigations_QuadrupleScreen = (EditText) findViewById(R.id.anc2_investigations_QuadrupleScreen);
        anc2_investigations_TfolateLessThan14Weeks = (CheckBox) findViewById(R.id.anc2_investigations_TfolateLessThan14Weeks);
        anc2_investigations_TFeMoreThan14Weeks = (CheckBox) findViewById(R.id.anc2_investigations_TFeMoreThan14Weeks);

        anc2_advice_OGTT = (CheckBox) findViewById(R.id.anc2_advice_OGTT);
        anc2_advice_TfeOD = (CheckBox) findViewById(R.id.anc2_advice_TfeOD);
        anc2_advice_TcaBD = (CheckBox) findViewById(R.id.anc2_advice_TcaBD);
        anc2_advice_Tetanus = (CheckBox) findViewById(R.id.anc2_advice_Tetanus);
        anc2_advice_QuadrupleScreen = (CheckBox) findViewById(R.id.anc2_advice_QuadrupleScreen);
        anc2_advice_FetalEcho = (CheckBox) findViewById(R.id.anc2_advice_FetalEcho);
        anc2_advice_HbLess10_TAlbendazole = (CheckBox) findViewById(R.id.anc2_advice_HbLess10_TAlbendazole);
        anc2_advice_HbLess10_TFeBD = (CheckBox) findViewById(R.id.anc2_advice_HbLess10_TFeBD);
        anc2_advice_HbLess10_Hplc = (CheckBox) findViewById(R.id.anc2_advice_HbLess10_Hplc);
        anc2_advice_HbLess10_PeripheralSmear = (CheckBox) findViewById(R.id.anc2_advice_HbLess10_PeripheralSmear);
        anc2_advice_HbLess10_SerumIron = (CheckBox) findViewById(R.id.anc2_advice_HbLess10_SerumIron);
        anc2_advice_Nutritional = (EditText) findViewById(R.id.anc2_advice_Nutritional);
        anc2_advice_GeneralAdvice = (EditText) findViewById(R.id.anc2_advice_GeneralAdvice);
        anc2_advice_CommonAilment = (EditText) findViewById(R.id.anc2_advice_CommonAilment);
        anc2_advice_Others = (EditText) findViewById(R.id.anc2_advice_Others);

//        ANC3 Variables
        anc3_history_ShortnessOfBreath = (CheckBox) findViewById(R.id.anc3_history_ShortnessOfBreath);
        anc3_history_EasyFatigability = (CheckBox) findViewById(R.id.anc3_history_EasyFatigability);
        anc3_history_HeadacheEpigastricPain = (CheckBox) findViewById(R.id.anc3_history_HeadacheEpigastricPain);
        anc3_history_BleedingSpottingPv = (CheckBox) findViewById(R.id.anc3_history_BleedingSpottingPv);
        anc3_history_LeakingDischargePv = (CheckBox) findViewById(R.id.anc3_history_LeakingDischargePv);
        anc3_history_BurningMicturition = (CheckBox) findViewById(R.id.anc3_history_BurningMicturition);
        anc3_history_FetalMovements = (CheckBox) findViewById(R.id.anc3_history_FetalMovements);
        anc3_history_Itching = (CheckBox) findViewById(R.id.anc3_history_Itching);

        anc3_examination_Pallor = (CheckBox) findViewById(R.id.anc3_examination_Pallor);
        anc3_examination_PedalEdema = (CheckBox) findViewById(R.id.anc3_examination_PedalEdema);
        anc3_examination_PR = (EditText) findViewById(R.id.anc3_examination_PR);
        anc3_examination_BP = (EditText) findViewById(R.id.anc3_examination_BP);
        anc3_examination_Weight = (EditText) findViewById(R.id.anc3_examination_Weight);
        anc3_examination_PA2Weeks = (EditText) findViewById(R.id.anc3_examination_PA2Weeks);
        anc3_examination_Others = (EditText) findViewById(R.id.anc3_examination_Others);

        anc3_investigations_CBC = (CheckBox) findViewById(R.id.anc3_investigations_CBC);
        anc3_investigations_UrineCS = (CheckBox) findViewById(R.id.anc3_investigations_UrineCS);
        anc3_investigations_ICT = (CheckBox) findViewById(R.id.anc3_investigations_ICT);
        anc3_investigations_Others = (EditText) findViewById(R.id.anc3_investigations_Others);

        anc3_advice_TFeOD = (CheckBox) findViewById(R.id.anc3_advice_TFeOD);
        anc3_advice_DFMCLLP = (CheckBox) findViewById(R.id.anc3_advice_DFMCLLP);
        anc3_advice_InjTetanus = (CheckBox) findViewById(R.id.anc3_advice_InjTetanus);
        anc3_advice_CBC = (CheckBox) findViewById(R.id.anc3_advice_CBC);
        anc3_advice_LFT = (CheckBox) findViewById(R.id.anc3_advice_LFT);
        anc3_advice_KFT = (CheckBox) findViewById(R.id.anc3_advice_KFT);
        anc3_advice_GTT_Fasting = (CheckBox) findViewById(R.id.anc3_advice_GTT_Fasting);
        anc3_advice_GTT_1hr180Mg = (CheckBox) findViewById(R.id.anc3_advice_GTT_1hr180Mg);
        anc3_advice_GTT_2hr153Mg = (CheckBox) findViewById(R.id.anc3_advice_GTT_2hr153Mg);
        anc3_advice_review_BleedingPV = (CheckBox) findViewById(R.id.anc3_advice_review_BleedingPV);
        anc3_advice_review_SpottingPV = (CheckBox) findViewById(R.id.anc3_advice_review_SpottingPV);
        anc3_advice_review_LeakingPV = (CheckBox) findViewById(R.id.anc3_advice_review_LeakingPV);
        anc3_advice_review_ReducedFetalMovement = (CheckBox) findViewById(R.id.anc3_advice_review_ReducedFetalMovement);
        anc3_advice_review_AbdominalPain = (CheckBox) findViewById(R.id.anc3_advice_review_AbdominalPain);
        anc3_advice_ictNegative_InjAntiD300 = (CheckBox) findViewById(R.id.anc3_advice_ictNegative_InjAntiD300);

        anc3_advice_Nutritional = (EditText) findViewById(R.id.anc3_advice_Nutritional);
        anc3_advice_General = (EditText) findViewById(R.id.anc3_advice_General);
        anc_3_common_ailment = (EditText) findViewById(R.id.anc_3_common_ailment);
        anc3_advice_Others = (EditText) findViewById(R.id.anc3_advice_Others);

//        ANC4 Variables
        anc4_history_ShortnessOfBreath = (CheckBox) findViewById(R.id.anc4_history_ShortnessOfBreath);
        anc4_history_EasyFatiguability = (CheckBox) findViewById(R.id.anc4_history_EasyFatiguability);
        anc4_history_HeadacheEpigastricPain = (CheckBox) findViewById(R.id.anc4_history_HeadacheEpigastricPain);
        anc4_history_BleedingSpottingPV = (CheckBox) findViewById(R.id.anc4_history_BleedingSpottingPV);
        anc4_history_BurningMicturition = (CheckBox) findViewById(R.id.anc4_history_BurningMicturition);
        anc4_history_FetalMovements = (CheckBox) findViewById(R.id.anc4_history_FetalMovements);
        anc4_history_Itching = (CheckBox) findViewById(R.id.anc4_history_Itching);
        anc4_history_Others =  (EditText) findViewById(R.id.anc4_history_Others);

        anc4_examination_Pallor = (CheckBox) findViewById(R.id.anc4_examination_Pallor);
        anc4_examination_PedalEdema = (CheckBox) findViewById(R.id.anc4_examination_PedalEdema);
        anc4_examination_PR =  (EditText) findViewById(R.id.anc4_examination_PR);
        anc4_examination_BP =  (EditText) findViewById(R.id.anc4_examination_BP);
        anc4_examination_Weight =  (EditText) findViewById(R.id.anc4_examination_Weight);
        anc4_examination_PA2Weeks =  (EditText) findViewById(R.id.anc4_examination_PA2Weeks);
        anc4_examination_UrineCulture =  (EditText) findViewById(R.id.anc4_examination_UrineCulture);
        anc4_examination_ICT =  (EditText) findViewById(R.id.anc4_examination_ICT);
        anc4_examination_CBC_HB =  (EditText) findViewById(R.id.anc4_examination_CBC_HB);
        anc4_examination_CBC_TLC =  (EditText) findViewById(R.id.anc4_examination_CBC_TLC);
        anc4_examination_CBC_Platelets =  (EditText) findViewById(R.id.anc4_examination_CBC_Platelets);
        anc4_examination_LFT_OT =  (EditText) findViewById(R.id.anc4_examination_LFT_OT);
        anc4_examination_LFT_PT =  (EditText) findViewById(R.id.anc4_examination_LFT_PT);
        anc4_examination_LFT_ALP =  (EditText) findViewById(R.id.anc4_examination_LFT_ALP);
        anc4_examination_KFT_UREA =  (EditText) findViewById(R.id.anc4_examination_KFT_UREA);
        anc4_examination_KFT_Creatinine =  (EditText) findViewById(R.id.anc4_examination_KFT_Creatinine);

        anc4_advice_TFeOD = (CheckBox) findViewById(R.id.anc4_advice_TFeOD);
        anc4_advice_TCaBD = (CheckBox) findViewById(R.id.anc4_advice_TCaBD);
        anc4_advice_DFMC = (CheckBox) findViewById(R.id.anc4_advice_DFMC);
        anc4_advice_USG = (CheckBox) findViewById(R.id.anc4_advice_USG);
        anc4_advice_review_Bleeding = (CheckBox) findViewById(R.id.anc4_advice_review_Bleeding);
        anc4_advice_review_Spotting = (CheckBox) findViewById(R.id.anc4_advice_review_Spotting);
        anc4_advice_review_Leaking = (CheckBox) findViewById(R.id.anc4_advice_review_Leaking);
        anc4_advice_review_ReducedFM = (CheckBox) findViewById(R.id.anc4_advice_review_ReducedFM);
        anc4_advice_review_AbdomenPain = (CheckBox) findViewById(R.id.anc4_advice_review_AbdomenPain);
        anc4_advice_Nutritional =  (EditText) findViewById(R.id.anc4_advice_Nutritional);
        anc4_advice_General =  (EditText) findViewById(R.id.anc4_advice_General);
        anc4_advice_CommonAilment =  (EditText) findViewById(R.id.anc4_advice_CommonAilment);
        anc4_advice_Others =  (EditText) findViewById(R.id.anc4_advice_Others);

//        ANC5 Variables
        anc5_history_ShortnessOfBreath = (CheckBox) findViewById(R.id.anc5_history_ShortnessOfBreath);
        anc5_history_EasyFatiguability = (CheckBox) findViewById(R.id.anc5_history_EasyFatiguability);
        anc5_history_HeadacheEpigastricPain = (CheckBox) findViewById(R.id.anc5_history_HeadacheEpigastricPain);
        anc5_history_BleedingSpottingPV = (CheckBox) findViewById(R.id.anc5_history_BleedingSpottingPV);
        anc5_history_BurningMicturition = (CheckBox) findViewById(R.id.anc5_history_BurningMicturition);
        anc5_history_FetalMovements = (CheckBox) findViewById(R.id.anc5_history_FetalMovements);
        anc5_history_Itching = (CheckBox) findViewById(R.id.anc5_history_Itching);
        anc5_history_Others =  (EditText) findViewById(R.id.anc5_history_Others);

        anc5_history_counseling_ModeOfDel_Vaginal = (CheckBox) findViewById(R.id.anc5_history_counseling_ModeOfDel_Vaginal);
        anc5_history_counseling_ModeOfDel_LSCS = (CheckBox) findViewById(R.id.anc5_history_counseling_ModeOfDel_LSCS);
        anc5_history_counseling_Timing =  (EditText) findViewById(R.id.anc5_history_counseling_Timing);
        anc5_history_counseling_BirthAttendant = (CheckBox) findViewById(R.id.anc5_history_counseling_BirthAttendant);

        anc5_examination_Pallor = (CheckBox) findViewById(R.id.anc5_examination_Pallor);
        anc5_examination_PedalEdema = (CheckBox) findViewById(R.id.anc5_examination_PedalEdema);
        anc5_examination_PR =  (EditText) findViewById(R.id.anc5_examination_PR);
        anc5_examination_BP =  (EditText) findViewById(R.id.anc5_examination_BP);
        anc5_examination_Weight =  (EditText) findViewById(R.id.anc5_examination_Weight);
        anc5_examination_PA2Weeks =  (EditText) findViewById(R.id.anc5_examination_PA2Weeks);
        anc5_examination_Others =  (EditText) findViewById(R.id.anc5_examination_Others);

        anc5_investigation_CBC = (CheckBox) findViewById(R.id.anc5_investigation_CBC);
        anc5_investigation_LFT = (CheckBox) findViewById(R.id.anc5_investigation_LFT);
        anc5_investigation_KFT = (CheckBox) findViewById(R.id.anc5_investigation_KFT);
        anc5_investigation_Others =  (EditText) findViewById(R.id.anc5_investigation_Others);

        anc5_USG_BPD_cm =  (EditText) findViewById(R.id.anc5_USG_BPD_cm);
        anc5_USG_BPD_weeks =  (EditText) findViewById(R.id.anc5_USG_BPD_weeks);
        anc5_USG_BPD_centile =  (EditText) findViewById(R.id.anc5_USG_BPD_centile);
        anc5_USG_HC_cm =  (EditText) findViewById(R.id.anc5_USG_HC_cm);
        anc5_USG_HC_weeks =  (EditText) findViewById(R.id.anc5_USG_HC_weeks);
        anc5_USG_HC_centile =  (EditText) findViewById(R.id.anc5_USG_HC_centile);
        anc5_USG_AC_cm =  (EditText) findViewById(R.id.anc5_USG_AC_cm);
        anc5_USG_AC_weeks =  (EditText) findViewById(R.id.anc5_USG_AC_weeks);
        anc5_USG_AC_centile =  (EditText) findViewById(R.id.anc5_USG_AC_centile);
        anc5_USG_FL_cm =  (EditText) findViewById(R.id.anc5_USG_FL_cm);
        anc5_USG_FL_weeks =  (EditText) findViewById(R.id.anc5_USG_FL_weeks);
        anc5_USG_FL_centile =  (EditText) findViewById(R.id.anc5_USG_FL_centile);
        anc5_USG_EFW_gm =  (EditText) findViewById(R.id.anc5_USG_EFW_gm);
        anc5_USG_EFW_weeks =  (EditText) findViewById(R.id.anc5_USG_EFW_weeks);
        anc5_USG_EFW_centile =  (EditText) findViewById(R.id.anc5_USG_EFW_centile);
        anc5_USG_liquor_SLP =  (EditText) findViewById(R.id.anc5_USG_liquor_SLP);
        anc5_USG_liquor_AFI =  (EditText) findViewById(R.id.anc5_USG_liquor_AFI);
        anc5_USG_UAPI =  (EditText) findViewById(R.id.anc5_USG_UAPI);
        anc5_USG_UAPI_centile =  (EditText) findViewById(R.id.anc5_USG_UAPI_centile);
        anc5_USG_MCAPI =  (EditText) findViewById(R.id.anc5_USG_MCAPI);
        anc5_USG_MCAPI_centile =  (EditText) findViewById(R.id.anc5_USG_MCAPI_centile);

        anc5_USG_CPR = (CheckBox) findViewById(R.id.anc5_USG_CPR);
        anc5_advice_DFMCLLP = (CheckBox) findViewById(R.id.anc5_advice_DFMCLLP);
        anc5_advice_TFeCa = (CheckBox) findViewById(R.id.anc5_advice_TFeCa);
        anc5_advice_NST = (CheckBox) findViewById(R.id.anc5_advice_NST);
        anc5_advice_Nutritional =  (EditText) findViewById(R.id.anc5_advice_Nutritional);
        anc5_advice_General =  (EditText) findViewById(R.id.anc5_advice_General);
        anc5_advice_CommonAilment =  (EditText) findViewById(R.id.anc5_advice_CommonAilment);
        anc5_advice_review_Bleeding = (CheckBox) findViewById(R.id.anc5_advice_review_Bleeding);
        anc5_advice_review_Spotting = (CheckBox) findViewById(R.id.anc5_advice_review_Spotting);
        anc5_advice_review_Leaking = (CheckBox) findViewById(R.id.anc5_advice_review_Leaking);
        anc5_advice_review_ReducedFM = (CheckBox) findViewById(R.id.anc5_advice_review_ReducedFM);
        anc5_advice_review_AbdomenPain = (CheckBox) findViewById(R.id.anc5_advice_review_AbdomenPain);
        anc5_advice_Others =  (EditText) findViewById(R.id.anc5_advice_Others);

//        ANC6 Variables
        anc6_history_ShortnessOfBreath = (CheckBox) findViewById(R.id.anc6_history_ShortnessOfBreath);
        anc6_history_EasyFatiguability = (CheckBox) findViewById(R.id.anc6_history_EasyFatiguability);
        anc6_history_HeadacheEpigastricPain = (CheckBox) findViewById(R.id.anc6_history_HeadacheEpigastricPain);
        anc6_history_BleedingSpottingPV = (CheckBox) findViewById(R.id.anc6_history_BleedingSpottingPV);
        anc6_history_BurningMicturition = (CheckBox) findViewById(R.id.anc6_history_BurningMicturition);
        anc6_history_FetalMovements = (CheckBox) findViewById(R.id.anc6_history_FetalMovements);
        anc6_history_Itching = (CheckBox) findViewById(R.id.anc6_history_Itching);
        anc6_examination_Pallor = (CheckBox) findViewById(R.id.anc6_examination_Pallor);
        anc6_examination_PedalEdema = (CheckBox) findViewById(R.id.anc6_examination_PedalEdema);
        anc6_advice_DFMCLLP = (CheckBox) findViewById(R.id.anc6_advice_DFMCLLP);
        anc6_advice_TFeCa = (CheckBox) findViewById(R.id.anc6_advice_TFeCa);
        anc6_advice_NST = (CheckBox) findViewById(R.id.anc6_advice_NST);
        anc6_advice_review_Bleeding = (CheckBox) findViewById(R.id.anc6_advice_review_Bleeding);
        anc6_advice_review_Spotting = (CheckBox) findViewById(R.id.anc6_advice_review_Spotting);
        anc6_advice_review_Leaking = (CheckBox) findViewById(R.id.anc6_advice_review_Leaking);
        anc6_advice_review_ReducedFM = (CheckBox) findViewById(R.id.anc6_advice_review_ReducedFM);
        anc6_advice_review_AbdomenPain = (CheckBox) findViewById(R.id.anc6_advice_review_AbdomenPain);

        anc6_history_Others =  (EditText) findViewById(R.id.anc6_history_Others);
        anc6_examination_PR =  (EditText) findViewById(R.id.anc6_examination_PR);
        anc6_examination_BP =  (EditText) findViewById(R.id.anc6_examination_BP);
        anc6_examination_Weight =  (EditText) findViewById(R.id.anc6_examination_Weight);
        anc6_examination_PA2Weeks =  (EditText) findViewById(R.id.anc6_examination_PA2Weeks);
        anc6_examination_Others =  (EditText) findViewById(R.id.anc6_examination_Others);
        anc6_Pelvic =  (EditText) findViewById(R.id.anc6_Pelvic);
        anc6_advice_Others =  (EditText) findViewById(R.id.anc6_advice_Others);

//        ANC7 Variables
        anc7_history_ShortnessOfBreath = (CheckBox) findViewById(R.id.anc7_history_ShortnessOfBreath);
        anc7_history_EasyFatiguability = (CheckBox) findViewById(R.id.anc7_history_EasyFatiguability);
        anc7_history_HeadacheEpigastricPain = (CheckBox) findViewById(R.id.anc7_history_HeadacheEpigastricPain);
        anc7_history_BleedingSpottingPV = (CheckBox) findViewById(R.id.anc7_history_BleedingSpottingPV);
        anc7_history_BurningMicturition = (CheckBox) findViewById(R.id.anc7_history_BurningMicturition);
        anc7_history_FetalMovements = (CheckBox) findViewById(R.id.anc7_history_FetalMovements);
        anc7_history_Itching = (CheckBox) findViewById(R.id.anc7_history_Itching);
        anc7_examination_Pallor = (CheckBox) findViewById(R.id.anc7_examination_Pallor);
        anc7_examination_PedalEdema = (CheckBox) findViewById(R.id.anc7_examination_PedalEdema);
        anc7_advice_DFMCLLP = (CheckBox) findViewById(R.id.anc7_advice_DFMCLLP);
        anc7_advice_TFeCa = (CheckBox) findViewById(R.id.anc7_advice_TFeCa);
        anc7_advice_Bleeding = (CheckBox) findViewById(R.id.anc7_advice_Bleeding);
        anc7_advice_Spotting = (CheckBox) findViewById(R.id.anc7_advice_Spotting);
        anc7_advice_Leaking = (CheckBox) findViewById(R.id.anc7_advice_Leaking);
        anc7_advice_ReducedFM = (CheckBox) findViewById(R.id.anc7_advice_ReducedFM);
        anc7_advice_AbdomenPain = (CheckBox) findViewById(R.id.anc7_advice_AbdomenPain);

        anc7_history_Others =  (EditText) findViewById(R.id.anc7_history_Others);
        anc7_examination_PR =  (EditText) findViewById(R.id.anc7_examination_PR);
        anc7_examination_BP =  (EditText) findViewById(R.id.anc7_examination_BP);
        anc7_examination_Weight =  (EditText) findViewById(R.id.anc7_examination_Weight);
        anc7_examination_Pa2Weeks =  (EditText) findViewById(R.id.anc7_examination_Pa2Weeks);
        anc7_examination_Others =  (EditText) findViewById(R.id.anc7_examination_Others);
        anc7_advice_Others =  (EditText) findViewById(R.id.anc7_advice_Others);

//        ANC8 Variables
        anc8_history_ShortnessOfBreath = (CheckBox) findViewById(R.id.anc8_history_ShortnessOfBreath);
        anc8_history_EasyFatiguability = (CheckBox) findViewById(R.id.anc8_history_EasyFatiguability);
        anc8_history_HeadacheEpigastricPain = (CheckBox) findViewById(R.id.anc8_history_HeadacheEpigastricPain);
        anc8_history_BleedingSpottingPV = (CheckBox) findViewById(R.id.anc8_history_BleedingSpottingPV);
        anc8_history_BurningMicturition = (CheckBox) findViewById(R.id.anc8_history_BurningMicturition);
        anc8_history_FetalMovements = (CheckBox) findViewById(R.id.anc8_history_FetalMovements);
        anc8_history_Itching = (CheckBox) findViewById(R.id.anc8_history_Itching);
        anc8_examination_Pallor = (CheckBox) findViewById(R.id.anc8_examination_Pallor);
        anc8_examination_PedalEdema = (CheckBox) findViewById(R.id.anc8_examination_PedalEdema);
        anc8_examination_PA = (CheckBox) findViewById(R.id.anc8_examination_PA);
        anc8_advice_DFMCLLP = (CheckBox) findViewById(R.id.anc8_advice_DFMCLLP);
        anc8_advice_FeCa = (CheckBox) findViewById(R.id.anc8_advice_FeCa);
        anc8_advice_Induction = (CheckBox) findViewById(R.id.anc8_advice_Induction);

        anc8_history_Others =  (EditText) findViewById(R.id.anc8_history_Others);
        anc8_examination_PR =  (EditText) findViewById(R.id.anc8_examination_PR);
        anc8_examination_BP =  (EditText) findViewById(R.id.anc8_examination_BP);
        anc8_examination_Weight =  (EditText) findViewById(R.id.anc8_examination_Weight);
        anc8_examination_Others =  (EditText) findViewById(R.id.anc8_examination_Others);
        anc8_advice_Others =  (EditText) findViewById(R.id.anc8_advice_Others);

        anc1_Date_Automatic = (TextView) findViewById(R.id.anc1_Date_Automatic);
        anc2_Date_Automatic = (TextView) findViewById(R.id.anc2_Date_Automatic);
        anc3_Date_Automatic = (TextView) findViewById(R.id.anc3_Date_Automatic);
        anc4_Date_Automatic = (TextView) findViewById(R.id.anc4_Date_Automatic);
        anc5_Date_Automatic = (TextView) findViewById(R.id.anc5_Date_Automatic);
        anc6_Date_Automatic = (TextView) findViewById(R.id.anc6_Date_Automatic);
        anc7_Date_Automatic = (TextView) findViewById(R.id.anc7_Date_Automatic);
        anc8_Date_Automatic = (TextView) findViewById(R.id.anc8_Date_Automatic);

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

                            TextView lmpDate = (TextView) findViewById(R.id.lmpDate);
                            TextView eddDate = (TextView) findViewById(R.id.eddDate);

                            String date_date = response.getString("startDate").split("T")[0].split("-")[2];
                            String date_month = response.getString("startDate").split("T")[0].split("-")[1];
                            String date_year = response.getString("startDate").split("T")[0].split("-")[0];

                            lmpDateString = date_date + "/" + date_month + "/" + date_year;
                            String eddDateString = date_year + "/" + date_month + "/" + date_date;
                            Calendar newDate1 = Calendar.getInstance();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

//                            newDate1.set(Integer.parseInt(date_year), Integer.parseInt(date_month), Integer.parseInt(date_date));
                            Date d = sdf.parse(lmpDateString);
                            newDate1.setTime(d);

                            lmpDate.setText(sdf.format(d));

//                            invest_others.setText(response.getString("invest_others"));
//                            invest_drug_history.setText(response.getString("invest_drug_history"));
//                            invest_chronic_hyper.setChecked(response.getBoolean("invest_chronic_hyper"));
//                            invest_type_2_diabetes.setChecked(response.getBoolean("invest_type_2_diabetes"));
//                            invest_RHD_native.setChecked(response.getBoolean("invest_RHD_native"));
//                            invest_RHD_post.setChecked(response.getBoolean("invest_RHD_post"));
//                            invest_acyanotic.setChecked(response.getBoolean("invest_acyanotic"));
//                            invest_cyanotic.setChecked(response.getBoolean("invest_cyanotic"));
//                            invest_chronic_liver.setChecked(response.getBoolean("invest_chronic_liver"));
//                            invest_chronic_kidney.setChecked(response.getBoolean("invest_chronic_kidney"));
//                            invest_APLA.setChecked(response.getBoolean("invest_APLA"));

                            newDate1.add(Calendar.DATE, 84);
                            anc1_Date_Automatic.setText("12 Weeks - " + sdf.format(newDate1.getTime()));
                            newDate1.add(Calendar.DATE, 56);
                            anc2_Date_Automatic.setText("20 Weeks - " + sdf.format(newDate1.getTime()));
                            newDate1.add(Calendar.DATE, 42);
                            anc3_Date_Automatic.setText("26 Weeks - " + sdf.format(newDate1.getTime()));
                            newDate1.add(Calendar.DATE, 28);
                            anc4_Date_Automatic.setText("30 Weeks - " + sdf.format(newDate1.getTime()));
                            newDate1.add(Calendar.DATE, 28);
                            anc5_Date_Automatic.setText("34 Weeks - " + sdf.format(newDate1.getTime()));
                            newDate1.add(Calendar.DATE, 14);
                            anc6_Date_Automatic.setText("36 Weeks - " + sdf.format(newDate1.getTime()));
                            newDate1.add(Calendar.DATE, 14);
                            anc7_Date_Automatic.setText("38 Weeks - " + sdf.format(newDate1.getTime()));
                            newDate1.add(Calendar.DATE, 16);
                            anc8_Date_Automatic.setText("40 Weeks - " + sdf.format(newDate1.getTime()));
                            eddDate.setText(sdf.format(newDate1.getTime()));

                            anc1_History_Fever.setChecked(response.getBoolean("anc1_History_Fever"));
                            anc1_History_Rash.setChecked(response.getBoolean("anc1_History_Rash"));
                            anc1_History_Nausea.setChecked(response.getBoolean("anc1_History_Nausea"));
                            anc1_History_Bleeding.setChecked(response.getBoolean("anc1_History_Bleeding"));
                            anc1_History_AbdomenPain.setChecked(response.getBoolean("anc1_History_AbdomenPain"));
                            anc1_History_DrugIntake.setChecked(response.getBoolean("anc1_History_DrugIntake"));
                            anc1_History_Smoking.setChecked(response.getBoolean("anc1_History_Smoking"));
                            anc1_History_Alcohol.setChecked(response.getBoolean("anc1_History_Alcohol"));
                            anc1_History_TobaccoIntake.setChecked(response.getBoolean("anc1_History_TobaccoIntake"));
                            anc1_History_CaffeineIntake.setChecked(response.getBoolean("anc1_History_CaffeineIntake"));
                            anc1_History_IntimatePartnerViolence.setChecked(response.getBoolean("anc1_History_IntimatePartnerViolence"));
                            anc1_history_Others.setText(response.getString("anc1_history_Others"));
                            anc1_examination_general_Pallor.setChecked(response.getBoolean("anc1_examination_general_Pallor"));
                            anc1_examination_general_Lcterus.setChecked(response.getBoolean("anc1_examination_general_Lcterus"));
                            anc1_examination_general_Clubbing.setChecked(response.getBoolean("anc1_examination_general_Clubbing"));
                            anc1_examination_general_Cyanosis.setChecked(response.getBoolean("anc1_examination_general_Cyanosis"));
                            anc1_examination_general_Edema.setChecked(response.getBoolean("anc1_examination_general_Edema"));
                            anc1_examination_general_Lymphadenopathy.setChecked(response.getBoolean("anc1_examination_general_Lymphadenopathy"));
                            anc1_examination_anthropometry_Height.setText(response.getString("anc1_examination_anthropometry_Height"));
                            anc1_examination_anthropometry_Weight.setText(response.getString("anc1_examination_anthropometry_Weight"));
                            anc1_examination_anthropometry_Bmi.setText(response.getString("anc1_examination_anthropometry_Bmi"));
                            anc1_examination_vitals_Pr.setText(response.getString("anc1_examination_vitals_Pr"));
                            anc1_examination_vitals_Bp.setText(response.getString("anc1_examination_vitals_Bp"));
                            anc1_examination_vitals_Rr.setText(response.getString("anc1_examination_vitals_Rr"));
                            anc1_examination_vitals_Temp.setText(response.getString("anc1_examination_vitals_Temp"));
                            anc1_examination_vitals_ChestCVS.setText(response.getString("anc1_examination_vitals_ChestCVS"));
                            anc1_examination_vitals_PA.setText(response.getString("anc1_examination_vitals_PA"));
                            anc1_examination_vitals_Proteinuria = (Spinner) findViewById(R.id.anc1_examination_vitals_Proteinuria);
                            anc1_investigations_HIV.setChecked(response.getBoolean("anc1_investigations_HIV"));
                            anc1_investigations_Hbsag.setChecked(response.getBoolean("anc1_investigations_Hbsag"));
                            anc1_investigations_Vdrl.setChecked(response.getBoolean("anc1_investigations_Vdrl"));
                            anc1_investigations_UrineRM.setChecked(response.getBoolean("anc1_investigations_UrineRM"));
                            anc1_investigations_UrineCS.setChecked(response.getBoolean("anc1_investigations_UrineCS"));
                            anc1_investigations_HIV_switch.setChecked(response.getBoolean("anc1_investigations_HIV_switch"));
                            anc1_investigations_Hbsag_switch.setChecked(response.getBoolean("anc1_investigations_Hbsag_switch"));
                            anc1_investigations_Vdrl_switch.setChecked(response.getBoolean("anc1_investigations_Vdrl_switch"));
                            anc1_investigations_UrineRM_switch.setChecked(response.getBoolean("anc1_investigations_UrineRM_switch"));
                            anc1_investigations_UrineCS_switch.setChecked(response.getBoolean("anc1_investigations_UrineCS_switch"));
                            anc1_investigations_BloodGroup = (Spinner) findViewById(R.id.anc1_investigations_BloodGroup);
                            anc1_investigations_HusbandBloodGroup = (Spinner) findViewById(R.id.anc1_investigations_HusbandBloodGroup);
                            anc1_investigations_Hemogram.setText(response.getString("anc1_investigations_Hemogram"));
                            anc1_investigations_Tsh.setText(response.getString("anc1_investigations_Tsh"));
                            anc1_investigations_GTT_fast.setText(response.getString("anc1_investigations_GTT_fast"));
                            anc1_investigations_GTT_1Hour.setText(response.getString("anc1_investigations_GTT_1Hour"));
                            anc1_investigations_GTT_2Hour.setText(response.getString("anc1_investigations_GTT_2Hour"));
                            anc1_investigations_bloodSugar_Fasting.setText(response.getString("anc1_investigations_bloodSugar_Fasting"));
                            anc1_investigations_bloodSugar_PostPrandial.setText(response.getString("anc1_investigations_bloodSugar_PostPrandial"));
                            anc1_investigations_ntnb_DoneNotDone.setText(response.getString("anc1_investigations_ntnb_DoneNotDone"));
                            anc1_investigations_ntnb_CRL.setChecked(response.getBoolean("anc1_investigations_ntnb_CRL"));
                            anc1_investigations_ntnb_NT.setChecked(response.getBoolean("anc1_investigations_ntnb_NT"));
                            anc1_investigations_ntnb_Centile.setChecked(response.getBoolean("anc1_investigations_ntnb_Centile"));
                            anc1_investigations_ntnb_Text.setChecked(response.getBoolean("anc1_investigations_ntnb_Text"));
                            anc1_investigations_dualScreen_PAPP.setText(response.getString("anc1_investigations_dualScreen_PAPP"));
                            anc1_investigations_dualScreen_Bhcg.setText(response.getString("anc1_investigations_dualScreen_Bhcg"));
                            anc1_investigations_level2Usg_DoneNotDone.setText(response.getString("anc1_investigations_level2Usg_DoneNotDone"));
                            anc1_investigations_level2Usg_NormalAbnormal.setText(response.getString("anc1_investigations_level2Usg_NormalAbnormal"));
                            anc1_advice_GTT.setText(response.getString("anc1_advice_GTT"));
                            anc1_advice_BloodSugar.setText(response.getString("anc1_advice_BloodSugar"));
                            anc1_advice_NtNbScan.setText(response.getString("anc1_advice_NtNbScan"));
                            anc1_advice_DualScreen.setText(response.getString("anc1_advice_DualScreen"));
                            anc1_advice_LeftUterineArteryPl.setText(response.getString("anc1_advice_LeftUterineArteryPl"));
                            anc1_advice_RightUterineArteryPl.setText(response.getString("anc1_advice_RightUterineArteryPl"));
                            anc1_advice_PIGF.setText(response.getString("anc1_advice_PIGF"));
                            anc1_advice_ICT.setText(response.getString("anc1_advice_ICT"));
                            anc1_advice_GeneralNutritional.setChecked(response.getBoolean("anc1_advice_GeneralNutritional"));
                            anc1_advice_GeneralAilments.setChecked(response.getBoolean("anc1_advice_GeneralAilments"));
                            anc1_general_BgNegICT.setText(response.getString("anc1_general_BgNegICT"));
                            anc1_general_TSH.setChecked(response.getBoolean("anc1_general_TSH"));
                            anc1_general_urineCulture_Nitrofur.setChecked(response.getBoolean("anc1_general_urineCulture_Nitrofur"));
                            anc1_general_urineCulture_Syp.setChecked(response.getBoolean("anc1_general_urineCulture_Syp"));
                            anc1_general_urineCulture_VitC.setChecked(response.getBoolean("anc1_general_urineCulture_VitC"));
                            anc1_general_urineCulture_PlentyFluids.setChecked(response.getBoolean("anc1_general_urineCulture_PlentyFluids"));
                            anc1_general_deranged_Fasting.setText(response.getString("anc1_general_deranged_Fasting"));
                            anc1_general_deranged_AfterBreakfast.setText(response.getString("anc1_general_deranged_AfterBreakfast"));
                            anc1_general_deranged_AfterLunch.setText(response.getString("anc1_general_deranged_AfterLunch"));
                            anc1_general_deranged_AfterDinner.setText(response.getString("anc1_general_deranged_AfterDinner"));
                            anc1_general_Others.setText(response.getString("anc1_general_Others"));

                            
                            anc2_Date.setText(response.getString("anc2_Date"));
                            anc2_POG.setText(response.getString("anc2_POG"));
                            anc2_history_ShortnessOfBreath.setChecked(response.getBoolean("anc2_history_ShortnessOfBreath"));
                            anc2_history_EasyFatiguability.setChecked(response.getBoolean("anc2_history_EasyFatiguability"));
                            anc2_history_HeadacheEpigastricPain.setChecked(response.getBoolean("anc2_history_HeadacheEpigastricPain"));
                            anc2_history_BleedingSpottingPv.setChecked(response.getBoolean("anc2_history_BleedingSpottingPv"));
                            anc2_history_BurningMicturition.setChecked(response.getBoolean("anc2_history_BurningMicturition"));
                            anc2_history_QuickeningPerceived.setChecked(response.getBoolean("anc2_history_QuickeningPerceived"));
                            anc2_history_Others.setText(response.getString("anc2_history_Others"));
                            anc2_examination_Pallor.setChecked(response.getBoolean("anc2_examination_Pallor"));
                            anc2_examination_PedalEdema.setChecked(response.getBoolean("anc2_examination_PedalEdema"));
                            anc2_examination_PR.setText(response.getString("anc2_examination_PR"));
                            anc2_examination_BP.setText(response.getString("anc2_examination_BP"));
                            anc2_examination_Weight.setText(response.getString("anc2_examination_Weight"));
                            anc2_examination_PA2Weeks.setText(response.getString("anc2_examination_PA2Weeks"));
                            anc2_examination_Others.setText(response.getString("anc2_examination_Others"));
                            anc2_investigations_QuadrupleScreen.setText(response.getString("anc2_investigations_QuadrupleScreen"));
                            anc2_investigations_TfolateLessThan14Weeks.setChecked(response.getBoolean("anc2_investigations_TfolateLessThan14Weeks"));
                            anc2_investigations_TFeMoreThan14Weeks.setChecked(response.getBoolean("anc2_investigations_TFeMoreThan14Weeks"));
                            anc2_advice_OGTT.setChecked(response.getBoolean("anc2_advice_OGTT"));
                            anc2_advice_TfeOD.setChecked(response.getBoolean("anc2_advice_TfeOD"));
                            anc2_advice_TcaBD.setChecked(response.getBoolean("anc2_advice_TcaBD"));
                            anc2_advice_Tetanus.setChecked(response.getBoolean("anc2_advice_Tetanus"));
                            anc2_advice_QuadrupleScreen.setChecked(response.getBoolean("anc2_advice_QuadrupleScreen"));
                            anc2_advice_FetalEcho.setChecked(response.getBoolean("anc2_advice_FetalEcho"));
                            anc2_advice_HbLess10_TAlbendazole.setChecked(response.getBoolean("anc2_advice_HbLess10_TAlbendazole"));
                            anc2_advice_HbLess10_TFeBD.setChecked(response.getBoolean("anc2_advice_HbLess10_TFeBD"));
                            anc2_advice_HbLess10_Hplc.setChecked(response.getBoolean("anc2_advice_HbLess10_Hplc"));
                            anc2_advice_HbLess10_PeripheralSmear.setChecked(response.getBoolean("anc2_advice_HbLess10_PeripheralSmear"));
                            anc2_advice_HbLess10_SerumIron.setChecked(response.getBoolean("anc2_advice_HbLess10_SerumIron"));
                            anc2_advice_Nutritional.setText(response.getString("anc2_advice_Nutritional"));
                            anc2_advice_GeneralAdvice.setText(response.getString("anc2_advice_GeneralAdvice"));
                            anc2_advice_CommonAilment.setText(response.getString("anc2_advice_CommonAilment"));
                            anc2_advice_Others.setText(response.getString("anc2_advice_Others"));


                            anc3_history_ShortnessOfBreath.setChecked(response.getBoolean("anc3_history_ShortnessOfBreath"));
                            anc3_history_EasyFatigability.setChecked(response.getBoolean("anc3_history_EasyFatigability"));
                            anc3_history_HeadacheEpigastricPain.setChecked(response.getBoolean("anc3_history_HeadacheEpigastricPain"));
                            anc3_history_BleedingSpottingPv.setChecked(response.getBoolean("anc3_history_BleedingSpottingPv"));
                            anc3_history_LeakingDischargePv.setChecked(response.getBoolean("anc3_history_LeakingDischargePv"));
                            anc3_history_BurningMicturition.setChecked(response.getBoolean("anc3_history_BurningMicturition"));
                            anc3_history_FetalMovements.setChecked(response.getBoolean("anc3_history_FetalMovements"));
                            anc3_history_Itching.setChecked(response.getBoolean("anc3_history_Itching"));
                            anc3_examination_Pallor.setChecked(response.getBoolean("anc3_examination_Pallor"));
                            anc3_examination_PedalEdema.setChecked(response.getBoolean("anc3_examination_PedalEdema"));
                            anc3_examination_PR.setText(response.getString("anc3_examination_PR"));
                            anc3_examination_BP.setText(response.getString("anc3_examination_BP"));
                            anc3_examination_Weight.setText(response.getString("anc3_examination_Weight"));
                            anc3_examination_PA2Weeks.setText(response.getString("anc3_examination_PA2Weeks"));
                            anc3_examination_Others.setText(response.getString("anc3_examination_Others"));
                            anc3_investigations_CBC.setChecked(response.getBoolean("anc3_investigations_CBC"));
                            anc3_investigations_UrineCS.setChecked(response.getBoolean("anc3_investigations_UrineCS"));
                            anc3_investigations_ICT.setChecked(response.getBoolean("anc3_investigations_ICT"));
                            anc3_investigations_Others.setText(response.getString("anc3_investigations_Others"));
                            anc3_advice_TFeOD.setChecked(response.getBoolean("anc3_advice_TFeOD"));
                            anc3_advice_DFMCLLP.setChecked(response.getBoolean("anc3_advice_DFMCLLP"));
                            anc3_advice_InjTetanus.setChecked(response.getBoolean("anc3_advice_InjTetanus"));
                            anc3_advice_CBC.setChecked(response.getBoolean("anc3_advice_CBC"));
                            anc3_advice_LFT.setChecked(response.getBoolean("anc3_advice_LFT"));
                            anc3_advice_KFT.setChecked(response.getBoolean("anc3_advice_KFT"));
                            anc3_advice_GTT_Fasting.setChecked(response.getBoolean("anc3_advice_GTT_Fasting"));
                            anc3_advice_GTT_1hr180Mg.setChecked(response.getBoolean("anc3_advice_GTT_1hr180Mg"));
                            anc3_advice_GTT_2hr153Mg.setChecked(response.getBoolean("anc3_advice_GTT_2hr153Mg"));
                            anc3_advice_review_BleedingPV.setChecked(response.getBoolean("anc3_advice_review_BleedingPV"));
                            anc3_advice_review_SpottingPV.setChecked(response.getBoolean("anc3_advice_review_SpottingPV"));
                            anc3_advice_review_LeakingPV.setChecked(response.getBoolean("anc3_advice_review_LeakingPV"));
                            anc3_advice_review_ReducedFetalMovement.setChecked(response.getBoolean("anc3_advice_review_ReducedFetalMovement"));
                            anc3_advice_review_AbdominalPain.setChecked(response.getBoolean("anc3_advice_review_AbdominalPain"));
                            anc3_advice_ictNegative_InjAntiD300.setChecked(response.getBoolean("anc3_advice_ictNegative_InjAntiD300"));


                            //        ANC4 Variables
                            anc4_history_ShortnessOfBreath.setChecked(response.getBoolean("anc4_history_ShortnessOfBreath"));
                            anc4_history_EasyFatiguability.setChecked(response.getBoolean("anc4_history_EasyFatiguability"));
                            anc4_history_HeadacheEpigastricPain.setChecked(response.getBoolean("anc4_history_HeadacheEpigastricPain"));
                            anc4_history_BleedingSpottingPV.setChecked(response.getBoolean("anc4_history_BleedingSpottingPV"));
                            anc4_history_BurningMicturition.setChecked(response.getBoolean("anc4_history_BurningMicturition"));
                            anc4_history_FetalMovements.setChecked(response.getBoolean("anc4_history_FetalMovements"));
                            anc4_history_Itching.setChecked(response.getBoolean("anc4_history_Itching"));
                            anc4_history_Others.setText(response.getString("anc4_history_Others"));
                            anc4_examination_Pallor.setChecked(response.getBoolean("anc4_examination_Pallor"));
                            anc4_examination_PedalEdema.setChecked(response.getBoolean("anc4_examination_PedalEdema"));
                            anc4_examination_PR.setText(response.getString("anc4_examination_PR"));
                            anc4_examination_BP.setText(response.getString("anc4_examination_BP"));
                            anc4_examination_Weight.setText(response.getString("anc4_examination_Weight"));
                            anc4_examination_PA2Weeks.setText(response.getString("anc4_examination_PA2Weeks"));
                            anc4_examination_UrineCulture.setText(response.getString("anc4_examination_UrineCulture"));
                            anc4_examination_ICT.setText(response.getString("anc4_examination_ICT"));
                            anc4_examination_CBC_HB.setText(response.getString("anc4_examination_CBC_HB"));
                            anc4_examination_CBC_TLC.setText(response.getString("anc4_examination_CBC_TLC"));
                            anc4_examination_CBC_Platelets.setText(response.getString("anc4_examination_CBC_Platelets"));
                            anc4_examination_LFT_OT.setText(response.getString("anc4_examination_LFT_OT"));
                            anc4_examination_LFT_PT.setText(response.getString("anc4_examination_LFT_PT"));
                            anc4_examination_LFT_ALP.setText(response.getString("anc4_examination_LFT_ALP"));
                            anc4_examination_KFT_UREA.setText(response.getString("anc4_examination_KFT_UREA"));
                            anc4_examination_KFT_Creatinine.setText(response.getString("anc4_examination_KFT_Creatinine"));
                            anc4_advice_TFeOD.setChecked(response.getBoolean("anc4_advice_TFeOD"));
                            anc4_advice_TCaBD.setChecked(response.getBoolean("anc4_advice_TCaBD"));
                            anc4_advice_DFMC.setChecked(response.getBoolean("anc4_advice_DFMC"));
                            anc4_advice_USG.setChecked(response.getBoolean("anc4_advice_USG"));
                            anc4_advice_review_Bleeding.setChecked(response.getBoolean("anc4_advice_review_Bleeding"));
                            anc4_advice_review_Spotting.setChecked(response.getBoolean("anc4_advice_review_Spotting"));
                            anc4_advice_review_Leaking.setChecked(response.getBoolean("anc4_advice_review_Leaking"));
                            anc4_advice_review_ReducedFM.setChecked(response.getBoolean("anc4_advice_review_ReducedFM"));
                            anc4_advice_review_AbdomenPain .setChecked(response.getBoolean("anc4_advice_review_AbdomenPain"));
                            anc4_advice_Nutritional.setText(response.getString("anc4_advice_Nutritional"));
                            anc4_advice_General.setText(response.getString("anc4_advice_General"));
                            anc4_advice_CommonAilment.setText(response.getString("anc4_advice_CommonAilment"));
                            anc4_advice_Others.setText(response.getString("anc4_advice_Others"));


                            //        ANC5 Variables
                            anc5_history_ShortnessOfBreath.setChecked(response.getBoolean("anc5_history_ShortnessOfBreath"));
                            anc5_history_EasyFatiguability.setChecked(response.getBoolean("anc5_history_EasyFatiguability"));
                            anc5_history_HeadacheEpigastricPain.setChecked(response.getBoolean("anc5_history_HeadacheEpigastricPain"));
                            anc5_history_BleedingSpottingPV.setChecked(response.getBoolean("anc5_history_BleedingSpottingPV"));
                            anc5_history_BurningMicturition.setChecked(response.getBoolean("anc5_history_BurningMicturition"));
                            anc5_history_FetalMovements.setChecked(response.getBoolean("anc5_history_FetalMovements"));
                            anc5_history_Itching.setChecked(response.getBoolean("anc5_history_Itching"));
                            anc5_history_Others.setText(response.getString("anc5_history_Others"));
                            anc5_history_counseling_ModeOfDel_Vaginal.setChecked(response.getBoolean("anc5_history_counseling_ModeOfDel_Vaginal"));
                            anc5_history_counseling_ModeOfDel_LSCS.setChecked(response.getBoolean("anc5_history_counseling_ModeOfDel_LSCS"));
                            anc5_history_counseling_Timing.setText(response.getString("anc5_history_counseling_Timing"));
                            anc5_history_counseling_BirthAttendant.setChecked(response.getBoolean("anc5_history_counseling_BirthAttendant"));
                            anc5_examination_Pallor.setChecked(response.getBoolean("anc5_examination_Pallor"));
                            anc5_examination_PedalEdema.setChecked(response.getBoolean("anc5_examination_PedalEdema"));
                            anc5_examination_PR.setText(response.getString("anc5_examination_PR"));
                            anc5_examination_BP.setText(response.getString("anc5_examination_BP"));
                            anc5_examination_Weight.setText(response.getString("anc5_examination_Weight"));
                            anc5_examination_PA2Weeks.setText(response.getString("anc5_examination_PA2Weeks"));
                            anc5_examination_Others.setText(response.getString("anc5_examination_Others"));
                            anc5_investigation_CBC.setChecked(response.getBoolean("anc5_investigation_CBC"));
                            anc5_investigation_LFT.setChecked(response.getBoolean("anc5_investigation_LFT"));
                            anc5_investigation_KFT.setChecked(response.getBoolean("anc5_investigation_KFT"));
                            anc5_investigation_Others.setText(response.getString("anc5_investigation_Others"));
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
                            anc5_USG_CPR.setChecked(response.getBoolean("anc5_USG_CPR"));
                            anc5_advice_DFMCLLP.setChecked(response.getBoolean("anc5_advice_DFMCLLP"));
                            anc5_advice_TFeCa.setChecked(response.getBoolean("anc5_advice_TFeCa"));
                            anc5_advice_NST.setChecked(response.getBoolean("anc5_advice_NST"));
                            anc5_advice_Nutritional.setText(response.getString("anc5_advice_Nutritional"));
                            anc5_advice_General.setText(response.getString("anc5_advice_General"));
                            anc5_advice_CommonAilment.setText(response.getString("anc5_advice_CommonAilment"));
                            anc5_advice_review_Bleeding.setChecked(response.getBoolean("anc5_advice_review_Bleeding"));
                            anc5_advice_review_Spotting.setChecked(response.getBoolean("anc5_advice_review_Spotting"));
                            anc5_advice_review_Leaking.setChecked(response.getBoolean("anc5_advice_review_Leaking"));
                            anc5_advice_review_ReducedFM.setChecked(response.getBoolean("anc5_advice_review_ReducedFM"));
                            anc5_advice_review_AbdomenPain.setChecked(response.getBoolean("anc5_advice_review_AbdomenPain"));
                            anc5_advice_Others.setText(response.getString("anc5_advice_Others"));


                            anc6_history_ShortnessOfBreath.setChecked(response.getBoolean("anc6_history_ShortnessOfBreath"));
                            anc6_history_EasyFatiguability.setChecked(response.getBoolean("anc6_history_EasyFatiguability"));
                            anc6_history_HeadacheEpigastricPain.setChecked(response.getBoolean("anc6_history_HeadacheEpigastricPain"));
                            anc6_history_BleedingSpottingPV.setChecked(response.getBoolean("anc6_history_BleedingSpottingPV"));
                            anc6_history_BurningMicturition.setChecked(response.getBoolean("anc6_history_BurningMicturition"));
                            anc6_history_FetalMovements.setChecked(response.getBoolean("anc6_history_FetalMovements"));
                            anc6_history_Itching.setChecked(response.getBoolean("anc6_history_Itching"));
                            anc6_examination_Pallor.setChecked(response.getBoolean("anc6_examination_Pallor"));
                            anc6_examination_PedalEdema.setChecked(response.getBoolean("anc6_examination_PedalEdema"));
                            anc6_advice_DFMCLLP.setChecked(response.getBoolean("anc6_advice_DFMCLLP"));
                            anc6_advice_TFeCa.setChecked(response.getBoolean("anc6_advice_TFeCa"));
                            anc6_advice_NST.setChecked(response.getBoolean("anc6_advice_NST"));
                            anc6_advice_review_Bleeding.setChecked(response.getBoolean("anc6_advice_review_Bleeding"));
                            anc6_advice_review_Spotting.setChecked(response.getBoolean("anc6_advice_review_Spotting"));
                            anc6_advice_review_Leaking.setChecked(response.getBoolean("anc6_advice_review_Leaking"));
                            anc6_advice_review_ReducedFM.setChecked(response.getBoolean("anc6_advice_review_ReducedFM"));
                            anc6_advice_review_AbdomenPain.setChecked(response.getBoolean("anc6_advice_review_AbdomenPain"));
                            anc6_history_Others.setText(response.getString("anc6_history_Others"));
                            anc6_examination_PR.setText(response.getString("anc6_examination_PR"));
                            anc6_examination_BP.setText(response.getString("anc6_examination_BP"));
                            anc6_examination_Weight.setText(response.getString("anc6_examination_Weight"));
                            anc6_examination_PA2Weeks.setText(response.getString("anc6_examination_PA2Weeks"));
                            anc6_examination_Others.setText(response.getString("anc6_examination_Others"));
                            anc6_Pelvic.setText(response.getString("anc6_Pelvic"));
                            anc6_advice_Others.setText(response.getString("anc6_advice_Others"));


                            anc7_history_ShortnessOfBreath.setChecked(response.getBoolean("anc7_history_ShortnessOfBreath"));
                            anc7_history_EasyFatiguability.setChecked(response.getBoolean("anc7_history_EasyFatiguability"));
                            anc7_history_HeadacheEpigastricPain.setChecked(response.getBoolean("anc7_history_HeadacheEpigastricPain"));
                            anc7_history_BleedingSpottingPV.setChecked(response.getBoolean("anc7_history_BleedingSpottingPV"));
                            anc7_history_BurningMicturition.setChecked(response.getBoolean("anc7_history_BurningMicturition"));
                            anc7_history_FetalMovements.setChecked(response.getBoolean("anc7_history_FetalMovements"));
                            anc7_history_Itching.setChecked(response.getBoolean("anc7_history_Itching"));
                            anc7_examination_Pallor.setChecked(response.getBoolean("anc7_examination_Pallor"));
                            anc7_examination_PedalEdema.setChecked(response.getBoolean("anc7_examination_PedalEdema"));
                            anc7_advice_DFMCLLP.setChecked(response.getBoolean("anc7_advice_DFMCLLP"));
                            anc7_advice_TFeCa.setChecked(response.getBoolean("anc7_advice_TFeCa"));
                            anc7_advice_Bleeding.setChecked(response.getBoolean("anc7_advice_Bleeding"));
                            anc7_advice_Spotting.setChecked(response.getBoolean("anc7_advice_Spotting"));
                            anc7_advice_Leaking.setChecked(response.getBoolean("anc7_advice_Leaking"));
                            anc7_advice_ReducedFM.setChecked(response.getBoolean("anc7_advice_ReducedFM"));
                            anc7_advice_AbdomenPain.setChecked(response.getBoolean("anc7_advice_AbdomenPain"));
                            anc7_history_Others.setText(response.getString("anc7_history_Others"));
                            anc7_examination_PR.setText(response.getString("anc7_examination_PR"));
                            anc7_examination_BP.setText(response.getString("anc7_examination_BP"));
                            anc7_examination_Weight.setText(response.getString("anc7_examination_Weight"));
                            anc7_examination_Pa2Weeks.setText(response.getString("anc7_examination_Pa2Weeks"));
                            anc7_examination_Others.setText(response.getString("anc7_examination_Others"));
                            anc7_advice_Others.setText(response.getString("anc7_advice_Others"));


                            anc8_history_ShortnessOfBreath.setChecked(response.getBoolean("anc8_history_ShortnessOfBreath"));
                            anc8_history_EasyFatiguability.setChecked(response.getBoolean("anc8_history_EasyFatiguability"));
                            anc8_history_HeadacheEpigastricPain.setChecked(response.getBoolean("anc8_history_HeadacheEpigastricPain"));
                            anc8_history_BleedingSpottingPV.setChecked(response.getBoolean("anc8_history_BleedingSpottingPV"));
                            anc8_history_BurningMicturition.setChecked(response.getBoolean("anc8_history_BurningMicturition"));
                            anc8_history_FetalMovements.setChecked(response.getBoolean("anc8_history_FetalMovements"));
                            anc8_history_Itching.setChecked(response.getBoolean("anc8_history_Itching"));
                            anc8_examination_Pallor.setChecked(response.getBoolean("anc8_examination_Pallor"));
                            anc8_examination_PedalEdema.setChecked(response.getBoolean("anc8_examination_PedalEdema"));
                            anc8_examination_PA.setChecked(response.getBoolean("anc8_examination_PA"));
                            anc8_advice_DFMCLLP.setChecked(response.getBoolean("anc8_advice_DFMCLLP"));
                            anc8_advice_FeCa.setChecked(response.getBoolean("anc8_advice_FeCa"));
                            anc8_advice_Induction.setChecked(response.getBoolean("anc8_advice_Induction"));
                            anc8_history_Others.setText(response.getString("anc8_history_Others"));
                            anc8_examination_PR.setText(response.getString("anc8_examination_PR"));
                            anc8_examination_BP.setText(response.getString("anc8_examination_BP"));
                            anc8_examination_Weight.setText(response.getString("anc8_examination_Weight"));
                            anc8_examination_Others.setText(response.getString("anc8_examination_Others"));
                            anc8_advice_Others.setText(response.getString("anc8_advice_Others"));

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
        Spinner spinner = (Spinner) findViewById(R.id.anc1_examination_vitals_Proteinuria);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ProteinuriaDropdownElements, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

//      Dropdown for Blood Group
        Spinner spinnerBloodGroup = (Spinner) findViewById(R.id.anc1_investigations_BloodGroup);
        ArrayAdapter<CharSequence> adapterBloodGroup = ArrayAdapter.createFromResource(this,
                R.array.BloodGroupDropdownElements, android.R.layout.simple_spinner_item);
        adapterBloodGroup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBloodGroup.setAdapter(adapterBloodGroup);

//        Dropdown for Husband Blood Group
        Spinner spinnerHusbandBloodGroup = (Spinner) findViewById(R.id.anc1_investigations_BloodGroup);
        ArrayAdapter<CharSequence> adapterHusbandBloodGroup = ArrayAdapter.createFromResource(this,
                R.array.BloodGroupDropdownElements, android.R.layout.simple_spinner_item);
        adapterHusbandBloodGroup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHusbandBloodGroup.setAdapter(adapterHusbandBloodGroup);

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

                    params.put("anc1_History_Fever", "" + anc1_History_Fever.isChecked());
                    params.put("anc1_History_Rash", "" + anc1_History_Rash.isChecked());
                    params.put("anc1_History_Nausea", "" + anc1_History_Nausea.isChecked());
                    params.put("anc1_History_Bleeding", "" + anc1_History_Bleeding.isChecked());
                    params.put("anc1_History_AbdomenPain", "" + anc1_History_AbdomenPain.isChecked());
                    params.put("anc1_History_DrugIntake", "" + anc1_History_DrugIntake.isChecked());
                    params.put("anc1_History_Smoking", "" + anc1_History_Smoking.isChecked());
                    params.put("anc1_History_Alcohol", "" + anc1_History_Alcohol.isChecked());
                    params.put("anc1_History_TobaccoIntake", "" + anc1_History_TobaccoIntake.isChecked());
                    params.put("anc1_History_CaffeineIntake", "" + anc1_History_CaffeineIntake.isChecked());
                    params.put("anc1_History_IntimatePartnerViolence", "" + anc1_History_IntimatePartnerViolence.isChecked());
                    params.put("anc1_history_Others", "" + anc1_history_Others.getText());
                    params.put("anc1_examination_general_Pallor", "" + anc1_examination_general_Pallor.isChecked());
                    params.put("anc1_examination_general_Lcterus", "" + anc1_examination_general_Lcterus.isChecked());
                    params.put("anc1_examination_general_Clubbing", "" + anc1_examination_general_Clubbing.isChecked());
                    params.put("anc1_examination_general_Cyanosis", "" + anc1_examination_general_Cyanosis.isChecked());
                    params.put("anc1_examination_general_Edema", "" + anc1_examination_general_Edema.isChecked());
                    params.put("anc1_examination_general_Lymphadenopathy", "" + anc1_examination_general_Lymphadenopathy.isChecked());
                    params.put("anc1_examination_anthropometry_Height", "" + anc1_examination_anthropometry_Height.getText());
                    params.put("anc1_examination_anthropometry_Weight", "" + anc1_examination_anthropometry_Weight.getText());
                    params.put("anc1_examination_anthropometry_Bmi", "" + anc1_examination_anthropometry_Bmi.getText());
                    params.put("anc1_examination_vitals_Pr", "" + anc1_examination_vitals_Pr.getText());
                    params.put("anc1_examination_vitals_Bp", "" + anc1_examination_vitals_Bp.getText());
                    params.put("anc1_examination_vitals_Rr", "" + anc1_examination_vitals_Rr.getText());
                    params.put("anc1_examination_vitals_Temp", "" + anc1_examination_vitals_Temp.getText());
                    params.put("anc1_examination_vitals_ChestCVS", "" + anc1_examination_vitals_ChestCVS.getText());
                    params.put("anc1_examination_vitals_PA", "" + anc1_examination_vitals_PA.getText());
                    params.put("anc1_examination_vitals_Proteinuria", "" + anc1_examination_vitals_Proteinuria.getSelectedItem().toString());
                    params.put("anc1_investigations_HIV", "" + anc1_investigations_HIV.isChecked());
                    params.put("anc1_investigations_Hbsag", "" + anc1_investigations_Hbsag.isChecked());
                    params.put("anc1_investigations_Vdrl", "" + anc1_investigations_Vdrl.isChecked());
                    params.put("anc1_investigations_UrineRM", "" + anc1_investigations_UrineRM.isChecked());
                    params.put("anc1_investigations_UrineCS", "" + anc1_investigations_UrineCS.isChecked());
                    params.put("anc1_investigations_HIV_switch", "" + anc1_investigations_HIV_switch.isChecked());
                    params.put("anc1_investigations_Hbsag_switch", "" + anc1_investigations_Hbsag_switch.isChecked());
                    params.put("anc1_investigations_Vdrl_switch", "" + anc1_investigations_Vdrl_switch.isChecked());
                    params.put("anc1_investigations_UrineRM_switch", "" + anc1_investigations_UrineRM_switch.isChecked());
                    params.put("anc1_investigations_UrineCS_switch", "" + anc1_investigations_UrineCS_switch.isChecked());
                    params.put("anc1_investigations_BloodGroup", "" + anc1_investigations_BloodGroup.getSelectedItem().toString());
                    params.put("anc1_investigations_HusbandBloodGroup", "" + anc1_investigations_HusbandBloodGroup.getSelectedItem().toString());
                    params.put("anc1_investigations_Hemogram", "" + anc1_investigations_Hemogram.getText());
                    params.put("anc1_investigations_Tsh", "" + anc1_investigations_Tsh.getText());
                    params.put("anc1_investigations_GTT_fast", "" + anc1_investigations_GTT_fast.getText());
                    params.put("anc1_investigations_GTT_1Hour", "" + anc1_investigations_GTT_1Hour.getText());
                    params.put("anc1_investigations_GTT_2Hour", "" + anc1_investigations_GTT_2Hour.getText());
                    params.put("anc1_investigations_bloodSugar_Fasting", "" + anc1_investigations_bloodSugar_Fasting.getText());
                    params.put("anc1_investigations_bloodSugar_PostPrandial", "" + anc1_investigations_bloodSugar_PostPrandial.getText());
                    params.put("anc1_investigations_ntnb_DoneNotDone", "" + anc1_investigations_ntnb_DoneNotDone.getText());
                    params.put("anc1_investigations_ntnb_CRL", "" + anc1_investigations_ntnb_CRL.isChecked());
                    params.put("anc1_investigations_ntnb_NT", "" + anc1_investigations_ntnb_NT.isChecked());
                    params.put("anc1_investigations_ntnb_Centile", "" + anc1_investigations_ntnb_Centile.isChecked());
                    params.put("anc1_investigations_ntnb_Text", "" + anc1_investigations_ntnb_Text.isChecked());
                    params.put("anc1_investigations_dualScreen_PAPP", "" + anc1_investigations_dualScreen_PAPP.getText());
                    params.put("anc1_investigations_dualScreen_Bhcg", "" + anc1_investigations_dualScreen_Bhcg.getText());
                    params.put("anc1_investigations_level2Usg_DoneNotDone", "" + anc1_investigations_level2Usg_DoneNotDone.getText());
                    params.put("anc1_investigations_level2Usg_NormalAbnormal", "" + anc1_investigations_level2Usg_NormalAbnormal.getText());
                    params.put("anc1_advice_GTT", "" + anc1_advice_GTT.getText());
                    params.put("anc1_advice_BloodSugar", "" + anc1_advice_BloodSugar.getText());
                    params.put("anc1_advice_NtNbScan", "" + anc1_advice_NtNbScan.getText());
                    params.put("anc1_advice_DualScreen", "" + anc1_advice_DualScreen.getText());
                    params.put("anc1_advice_LeftUterineArteryPl", "" + anc1_advice_LeftUterineArteryPl.getText());
                    params.put("anc1_advice_RightUterineArteryPl", "" + anc1_advice_RightUterineArteryPl.getText());
                    params.put("anc1_advice_PIGF", "" + anc1_advice_PIGF.getText());
                    params.put("anc1_advice_ICT", "" + anc1_advice_ICT.getText());
                    params.put("anc1_advice_GeneralNutritional", "" + anc1_advice_GeneralNutritional.isChecked());
                    params.put("anc1_advice_GeneralAilments", "" + anc1_advice_GeneralAilments.isChecked());
                    params.put("anc1_general_BgNegICT", "" + anc1_general_BgNegICT.getText());
                    params.put("anc1_general_TSH", "" + anc1_general_TSH.isChecked());
                    params.put("anc1_general_urineCulture_Nitrofur", "" + anc1_general_urineCulture_Nitrofur.isChecked());
                    params.put("anc1_general_urineCulture_Syp", "" + anc1_general_urineCulture_Syp.isChecked());
                    params.put("anc1_general_urineCulture_VitC", "" + anc1_general_urineCulture_VitC.isChecked());
                    params.put("anc1_general_urineCulture_PlentyFluids", "" + anc1_general_urineCulture_PlentyFluids.isChecked());
                    params.put("anc1_general_deranged_Fasting", "" + anc1_general_deranged_Fasting.getText());
                    params.put("anc1_general_deranged_AfterBreakfast", "" + anc1_general_deranged_AfterBreakfast.getText());
                    params.put("anc1_general_deranged_AfterLunch", "" + anc1_general_deranged_AfterLunch.getText());
                    params.put("anc1_general_deranged_AfterDinner", "" + anc1_general_deranged_AfterDinner.getText());
                    params.put("anc1_general_Others", "" + anc1_general_Others.getText());



                    params.put("anc2_Date", "" + anc2_Date.getText());
                    params.put("anc2_POG", "" + anc2_POG.getText());
                    params.put("anc2_history_ShortnessOfBreath", "" + anc2_history_ShortnessOfBreath.isChecked());
                    params.put("anc2_history_EasyFatiguability", "" + anc2_history_EasyFatiguability.isChecked());
                    params.put("anc2_history_HeadacheEpigastricPain", "" + anc2_history_HeadacheEpigastricPain.isChecked());
                    params.put("anc2_history_BleedingSpottingPv", "" + anc2_history_BleedingSpottingPv.isChecked());
                    params.put("anc2_history_BurningMicturition", "" + anc2_history_BurningMicturition.isChecked());
                    params.put("anc2_history_QuickeningPerceived", "" + anc2_history_QuickeningPerceived.isChecked());
                    params.put("anc2_history_Others", "" + anc2_history_Others.getText());
                    params.put("anc2_examination_Pallor", "" + anc2_examination_Pallor.isChecked());
                    params.put("anc2_examination_PedalEdema", "" + anc2_examination_PedalEdema.isChecked());
                    params.put("anc2_examination_PR", "" + anc2_examination_PR.getText());
                    params.put("anc2_examination_BP", "" + anc2_examination_BP.getText());
                    params.put("anc2_examination_Weight", "" + anc2_examination_Weight.getText());
                    params.put("anc2_examination_PA2Weeks", "" + anc2_examination_PA2Weeks.getText());
                    params.put("anc2_examination_Others", "" + anc2_examination_Others.getText());
                    params.put("anc2_investigations_QuadrupleScreen", "" + anc2_investigations_QuadrupleScreen.getText());
                    params.put("anc2_investigations_TfolateLessThan14Weeks", "" + anc2_investigations_TfolateLessThan14Weeks.isChecked());
                    params.put("anc2_investigations_TFeMoreThan14Weeks", "" + anc2_investigations_TFeMoreThan14Weeks.isChecked());
                    params.put("anc2_advice_OGTT", "" + anc2_advice_OGTT.isChecked());
                    params.put("anc2_advice_TfeOD", "" + anc2_advice_TfeOD.isChecked());
                    params.put("anc2_advice_TcaBD", "" + anc2_advice_TcaBD.isChecked());
                    params.put("anc2_advice_Tetanus", "" + anc2_advice_Tetanus.isChecked());
                    params.put("anc2_advice_QuadrupleScreen", "" + anc2_advice_QuadrupleScreen.isChecked());
                    params.put("anc2_advice_FetalEcho", "" + anc2_advice_FetalEcho.isChecked());
                    params.put("anc2_advice_HbLess10_TAlbendazole", "" + anc2_advice_HbLess10_TAlbendazole.isChecked());
                    params.put("anc2_advice_HbLess10_TFeBD", "" + anc2_advice_HbLess10_TFeBD.isChecked());
                    params.put("anc2_advice_HbLess10_Hplc", "" + anc2_advice_HbLess10_Hplc.isChecked());
                    params.put("anc2_advice_HbLess10_PeripheralSmear", "" + anc2_advice_HbLess10_PeripheralSmear.isChecked());
                    params.put("anc2_advice_HbLess10_SerumIron", "" + anc2_advice_HbLess10_SerumIron.isChecked());
                    params.put("anc2_advice_Nutritional", "" + anc2_advice_Nutritional.getText());
                    params.put("anc2_advice_GeneralAdvice", "" + anc2_advice_GeneralAdvice.getText());
                    params.put("anc2_advice_CommonAilment", "" + anc2_advice_CommonAilment.getText());
                    params.put("anc2_advice_Others", "" + anc2_advice_Others.getText());



                    params.put("anc3_history_ShortnessOfBreath", "" + anc3_history_ShortnessOfBreath.isChecked());
                    params.put("anc3_history_EasyFatigability", "" + anc3_history_EasyFatigability.isChecked());
                    params.put("anc3_history_HeadacheEpigastricPain", "" + anc3_history_HeadacheEpigastricPain.isChecked());
                    params.put("anc3_history_BleedingSpottingPv", "" + anc3_history_BleedingSpottingPv.isChecked());
                    params.put("anc3_history_LeakingDischargePv", "" + anc3_history_LeakingDischargePv.isChecked());
                    params.put("anc3_history_BurningMicturition", "" + anc3_history_BurningMicturition.isChecked());
                    params.put("anc3_history_FetalMovements", "" + anc3_history_FetalMovements.isChecked());
                    params.put("anc3_history_Itching", "" + anc3_history_Itching.isChecked());
                    params.put("anc3_examination_Pallor", "" + anc3_examination_Pallor.isChecked());
                    params.put("anc3_examination_PedalEdema", "" + anc3_examination_PedalEdema.isChecked());
                    params.put("anc3_examination_PR", "" + anc3_examination_PR.getText());
                    params.put("anc3_examination_BP", "" + anc3_examination_BP.getText());
                    params.put("anc3_examination_Weight", "" + anc3_examination_Weight.getText());
                    params.put("anc3_examination_PA2Weeks", "" + anc3_examination_PA2Weeks.getText());
                    params.put("anc3_examination_Others", "" + anc3_examination_Others.getText());
                    params.put("anc3_investigations_CBC", "" + anc3_investigations_CBC.isChecked());
                    params.put("anc3_investigations_UrineCS", "" + anc3_investigations_UrineCS.isChecked());
                    params.put("anc3_investigations_ICT", "" + anc3_investigations_ICT.isChecked());
                    params.put("anc3_investigations_Others", "" + anc3_investigations_Others.getText());
                    params.put("anc3_advice_TFeOD", "" + anc3_advice_TFeOD.isChecked());
                    params.put("anc3_advice_DFMCLLP", "" + anc3_advice_DFMCLLP.isChecked());
                    params.put("anc3_advice_InjTetanus", "" + anc3_advice_InjTetanus.isChecked());
                    params.put("anc3_advice_CBC", "" + anc3_advice_CBC.isChecked());
                    params.put("anc3_advice_LFT", "" + anc3_advice_LFT.isChecked());
                    params.put("anc3_advice_KFT", "" + anc3_advice_KFT.isChecked());
                    params.put("anc3_advice_GTT_Fasting", "" + anc3_advice_GTT_Fasting.isChecked());
                    params.put("anc3_advice_GTT_1hr180Mg", "" + anc3_advice_GTT_1hr180Mg.isChecked());
                    params.put("anc3_advice_GTT_2hr153Mg", "" + anc3_advice_GTT_2hr153Mg.isChecked());
                    params.put("anc3_advice_review_BleedingPV", "" + anc3_advice_review_BleedingPV.isChecked());
                    params.put("anc3_advice_review_SpottingPV", "" + anc3_advice_review_SpottingPV.isChecked());
                    params.put("anc3_advice_review_LeakingPV", "" + anc3_advice_review_LeakingPV.isChecked());
                    params.put("anc3_advice_review_ReducedFetalMovement", "" + anc3_advice_review_ReducedFetalMovement.isChecked());
                    params.put("anc3_advice_review_AbdominalPain", "" + anc3_advice_review_AbdominalPain.isChecked());
                    params.put("anc3_advice_ictNegative_InjAntiD300", "" + anc3_advice_ictNegative_InjAntiD300.isChecked());


                    params.put("anc4_history_ShortnessOfBreath", "" + anc4_history_ShortnessOfBreath.isChecked());
                    params.put("anc4_history_EasyFatiguability", "" + anc4_history_EasyFatiguability.isChecked());
                    params.put("anc4_history_HeadacheEpigastricPain", "" + anc4_history_HeadacheEpigastricPain.isChecked());
                    params.put("anc4_history_BleedingSpottingPV", "" + anc4_history_BleedingSpottingPV.isChecked());
                    params.put("anc4_history_BurningMicturition", "" + anc4_history_BurningMicturition.isChecked());
                    params.put("anc4_history_FetalMovements", "" + anc4_history_FetalMovements.isChecked());
                    params.put("anc4_history_Itching", "" + anc4_history_Itching.isChecked());
                    params.put("anc4_history_Others", "" + anc4_history_Others.getText());
                    params.put("anc4_examination_Pallor", "" + anc4_examination_Pallor.isChecked());
                    params.put("anc4_examination_PedalEdema", "" + anc4_examination_PedalEdema.isChecked());
                    params.put("anc4_examination_PR", "" + anc4_examination_PR.getText());
                    params.put("anc4_examination_BP", "" + anc4_examination_BP.getText());
                    params.put("anc4_examination_Weight", "" + anc4_examination_Weight.getText());
                    params.put("anc4_examination_PA2Weeks", "" + anc4_examination_PA2Weeks.getText());
                    params.put("anc4_examination_UrineCulture", "" + anc4_examination_UrineCulture.getText());
                    params.put("anc4_examination_ICT", "" + anc4_examination_ICT.getText());
                    params.put("anc4_examination_CBC_HB", "" + anc4_examination_CBC_HB.getText());
                    params.put("anc4_examination_CBC_TLC", "" + anc4_examination_CBC_TLC.getText());
                    params.put("anc4_examination_CBC_Platelets", "" + anc4_examination_CBC_Platelets.getText());
                    params.put("anc4_examination_LFT_OT", "" + anc4_examination_LFT_OT.getText());
                    params.put("anc4_examination_LFT_PT", "" + anc4_examination_LFT_PT.getText());
                    params.put("anc4_examination_LFT_ALP", "" + anc4_examination_LFT_ALP.getText());
                    params.put("anc4_examination_KFT_UREA", "" + anc4_examination_KFT_UREA.getText());
                    params.put("anc4_examination_KFT_Creatinine", "" + anc4_examination_KFT_Creatinine.getText());
                    params.put("anc4_advice_TFeOD", "" + anc4_advice_TFeOD.isChecked());
                    params.put("anc4_advice_TCaBD", "" + anc4_advice_TCaBD.isChecked());
                    params.put("anc4_advice_DFMC", "" + anc4_advice_DFMC.isChecked());
                    params.put("anc4_advice_USG", "" + anc4_advice_USG.isChecked());
                    params.put("anc4_advice_review_Bleeding", "" + anc4_advice_review_Bleeding.isChecked());
                    params.put("anc4_advice_review_Spotting", "" + anc4_advice_review_Spotting.isChecked());
                    params.put("anc4_advice_review_Leaking", "" + anc4_advice_review_Leaking.isChecked());
                    params.put("anc4_advice_review_ReducedFM", "" + anc4_advice_review_ReducedFM.isChecked());
                    params.put("anc4_advice_review_AbdomenPain", "" + anc4_advice_review_AbdomenPain.isChecked());
                    params.put("anc4_advice_Nutritional", "" + anc4_advice_Nutritional.getText());
                    params.put("anc4_advice_General", "" + anc4_advice_General.getText());
                    params.put("anc4_advice_CommonAilment", "" + anc4_advice_CommonAilment.getText());
                    params.put("anc4_advice_Others", "" + anc4_advice_Others.getText());


                    params.put("anc5_history_ShortnessOfBreath", "" + anc5_history_ShortnessOfBreath.isChecked());
                    params.put("anc5_history_EasyFatiguability", "" + anc5_history_EasyFatiguability.isChecked());
                    params.put("anc5_history_HeadacheEpigastricPain", "" + anc5_history_HeadacheEpigastricPain.isChecked());
                    params.put("anc5_history_BleedingSpottingPV", "" + anc5_history_BleedingSpottingPV.isChecked());
                    params.put("anc5_history_BurningMicturition", "" + anc5_history_BurningMicturition.isChecked());
                    params.put("anc5_history_FetalMovements", "" + anc5_history_FetalMovements.isChecked());
                    params.put("anc5_history_Itching", "" + anc5_history_Itching.isChecked());
                    params.put("anc5_history_Others", "" + anc5_history_Others.getText());
                    params.put("anc5_history_counseling_ModeOfDel_Vaginal", "" + anc5_history_counseling_ModeOfDel_Vaginal.isChecked());
                    params.put("anc5_history_counseling_ModeOfDel_LSCS", "" + anc5_history_counseling_ModeOfDel_LSCS.isChecked());
                    params.put("anc5_history_counseling_Timing", "" + anc5_history_counseling_Timing.getText());
                    params.put("anc5_history_counseling_BirthAttendant", "" + anc5_history_counseling_BirthAttendant.isChecked());
                    params.put("anc5_examination_Pallor", "" + anc5_examination_Pallor.isChecked());
                    params.put("anc5_examination_PedalEdema", "" + anc5_examination_PedalEdema.isChecked());
                    params.put("anc5_examination_PR", "" + anc5_examination_PR.getText());
                    params.put("anc5_examination_BP", "" + anc5_examination_BP.getText());
                    params.put("anc5_examination_Weight", "" + anc5_examination_Weight.getText());
                    params.put("anc5_examination_PA2Weeks", "" + anc5_examination_PA2Weeks.getText());
                    params.put("anc5_examination_Others", "" + anc5_examination_Others.getText());
                    params.put("anc5_investigation_CBC", "" + anc5_investigation_CBC.isChecked());
                    params.put("anc5_investigation_LFT", "" + anc5_investigation_LFT.isChecked());
                    params.put("anc5_investigation_KFT", "" + anc5_investigation_KFT.isChecked());
                    params.put("anc5_investigation_Others", "" + anc5_investigation_Others.getText());
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
                    params.put("anc5_USG_CPR", "" + anc5_USG_CPR.isChecked());
                    params.put("anc5_advice_DFMCLLP", "" + anc5_advice_DFMCLLP.isChecked());
                    params.put("anc5_advice_TFeCa", "" + anc5_advice_TFeCa.isChecked());
                    params.put("anc5_advice_NST", "" + anc5_advice_NST.isChecked());
                    params.put("anc5_advice_Nutritional", "" + anc5_advice_Nutritional.getText());
                    params.put("anc5_advice_General", "" + anc5_advice_General.getText());
                    params.put("anc5_advice_CommonAilment", "" + anc5_advice_CommonAilment.getText());
                    params.put("anc5_advice_review_Bleeding", "" + anc5_advice_review_Bleeding.isChecked());
                    params.put("anc5_advice_review_Spotting", "" + anc5_advice_review_Spotting.isChecked());
                    params.put("anc5_advice_review_Leaking", "" + anc5_advice_review_Leaking.isChecked());
                    params.put("anc5_advice_review_ReducedFM", "" + anc5_advice_review_ReducedFM.isChecked());
                    params.put("anc5_advice_review_AbdomenPain", "" + anc5_advice_review_AbdomenPain.isChecked());
                    params.put("anc5_advice_Others", "" + anc5_advice_Others.getText());


                    params.put("anc6_history_ShortnessOfBreath", "" + anc6_history_ShortnessOfBreath.isChecked());
                    params.put("anc6_history_EasyFatiguability", "" + anc6_history_EasyFatiguability.isChecked());
                    params.put("anc6_history_HeadacheEpigastricPain", "" + anc6_history_HeadacheEpigastricPain.isChecked());
                    params.put("anc6_history_BleedingSpottingPV", "" + anc6_history_BleedingSpottingPV.isChecked());
                    params.put("anc6_history_BurningMicturition", "" + anc6_history_BurningMicturition.isChecked());
                    params.put("anc6_history_FetalMovements", "" + anc6_history_FetalMovements.isChecked());
                    params.put("anc6_history_Itching", "" + anc6_history_Itching.isChecked());
                    params.put("anc6_examination_Pallor", "" + anc6_examination_Pallor.isChecked());
                    params.put("anc6_examination_PedalEdema", "" + anc6_examination_PedalEdema.isChecked());
                    params.put("anc6_advice_DFMCLLP", "" + anc6_advice_DFMCLLP.isChecked());
                    params.put("anc6_advice_TFeCa", "" + anc6_advice_TFeCa.isChecked());
                    params.put("anc6_advice_NST", "" + anc6_advice_NST.isChecked());
                    params.put("anc6_advice_review_Bleeding", "" + anc6_advice_review_Bleeding.isChecked());
                    params.put("anc6_advice_review_Spotting", "" + anc6_advice_review_Spotting.isChecked());
                    params.put("anc6_advice_review_Leaking", "" + anc6_advice_review_Leaking.isChecked());
                    params.put("anc6_advice_review_ReducedFM", "" + anc6_advice_review_ReducedFM.isChecked());
                    params.put("anc6_advice_review_AbdomenPain", "" + anc6_advice_review_AbdomenPain.isChecked());
                    params.put("anc6_history_Others", "" + anc6_history_Others.getText());
                    params.put("anc6_examination_PR", "" + anc6_examination_PR.getText());
                    params.put("anc6_examination_BP", "" + anc6_examination_BP.getText());
                    params.put("anc6_examination_Weight", "" + anc6_examination_Weight.getText());
                    params.put("anc6_examination_PA2Weeks", "" + anc6_examination_PA2Weeks.getText());
                    params.put("anc6_examination_Others", "" + anc6_examination_Others.getText());
                    params.put("anc6_Pelvic", "" + anc6_Pelvic.getText());
                    params.put("anc6_advice_Others", "" + anc6_advice_Others.getText());


                    params.put("anc7_history_ShortnessOfBreath", "" + anc7_history_ShortnessOfBreath.isChecked());
                    params.put("anc7_history_EasyFatiguability", "" + anc7_history_EasyFatiguability.isChecked());
                    params.put("anc7_history_HeadacheEpigastricPain", "" + anc7_history_HeadacheEpigastricPain.isChecked());
                    params.put("anc7_history_BleedingSpottingPV", "" + anc7_history_BleedingSpottingPV.isChecked());
                    params.put("anc7_history_BurningMicturition", "" + anc7_history_BurningMicturition.isChecked());
                    params.put("anc7_history_FetalMovements", "" + anc7_history_FetalMovements.isChecked());
                    params.put("anc7_history_Itching", "" + anc7_history_Itching.isChecked());
                    params.put("anc7_examination_Pallor", "" + anc7_examination_Pallor.isChecked());
                    params.put("anc7_examination_PedalEdema", "" + anc7_examination_PedalEdema.isChecked());
                    params.put("anc7_advice_DFMCLLP", "" + anc7_advice_DFMCLLP.isChecked());
                    params.put("anc7_advice_TFeCa", "" + anc7_advice_TFeCa.isChecked());
                    params.put("anc7_advice_Bleeding", "" + anc7_advice_Bleeding.isChecked());
                    params.put("anc7_advice_Spotting", "" + anc7_advice_Spotting.isChecked());
                    params.put("anc7_advice_Leaking", "" + anc7_advice_Leaking.isChecked());
                    params.put("anc7_advice_ReducedFM", "" + anc7_advice_ReducedFM.isChecked());
                    params.put("anc7_advice_AbdomenPain", "" + anc7_advice_AbdomenPain.isChecked());
                    params.put("anc7_history_Others", "" + anc7_history_Others.getText());
                    params.put("anc7_examination_PR", "" + anc7_examination_PR.getText());
                    params.put("anc7_examination_BP", "" + anc7_examination_BP.getText());
                    params.put("anc7_examination_Weight", "" + anc7_examination_Weight.getText());
                    params.put("anc7_examination_Pa2Weeks", "" + anc7_examination_Pa2Weeks.getText());
                    params.put("anc7_examination_Others", "" + anc7_examination_Others.getText());
                    params.put("anc7_advice_Others", "" + anc7_advice_Others.getText());


                    params.put("anc8_history_ShortnessOfBreath", "" + anc8_history_ShortnessOfBreath.isChecked());
                    params.put("anc8_history_EasyFatiguability", "" + anc8_history_EasyFatiguability.isChecked());
                    params.put("anc8_history_HeadacheEpigastricPain", "" + anc8_history_HeadacheEpigastricPain.isChecked());
                    params.put("anc8_history_BleedingSpottingPV", "" + anc8_history_BleedingSpottingPV.isChecked());
                    params.put("anc8_history_BurningMicturition", "" + anc8_history_BurningMicturition.isChecked());
                    params.put("anc8_history_FetalMovements", "" + anc8_history_FetalMovements.isChecked());
                    params.put("anc8_history_Itching", "" + anc8_history_Itching.isChecked());
                    params.put("anc8_examination_Pallor", "" + anc8_examination_Pallor.isChecked());
                    params.put("anc8_examination_PedalEdema", "" + anc8_examination_PedalEdema.isChecked());
                    params.put("anc8_examination_PA", "" + anc8_examination_PA.isChecked());
                    params.put("anc8_advice_DFMCLLP", "" + anc8_advice_DFMCLLP.isChecked());
                    params.put("anc8_advice_FeCa", "" + anc8_advice_FeCa.isChecked());
                    params.put("anc8_advice_Induction", "" + anc8_advice_Induction.isChecked());
                    params.put("anc8_history_Others", "" + anc8_history_Others.getText());
                    params.put("anc8_examination_PR", "" + anc8_examination_PR.getText());
                    params.put("anc8_examination_BP", "" + anc8_examination_BP.getText());
                    params.put("anc8_examination_Weight", "" + anc8_examination_Weight.getText());
                    params.put("anc8_examination_Others", "" + anc8_examination_Others.getText());
                    params.put("anc8_advice_Others", "" + anc8_advice_Others.getText());


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