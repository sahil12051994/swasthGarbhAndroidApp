package com.swasthgarbh.root.swasthgarbh;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class patient_data_entry_bydoc extends AppCompatActivity {

    int clickedPatientId;
    Button UpdateData;
    static String p_id, to_fcm;
    static SessionManager session;

    TextView anc1_Date_Automatic, anc2_Date_Automatic, anc3_Date_Automatic, anc4_Date_Automatic, anc5_Date_Automatic, anc6_Date_Automatic, anc7_Date_Automatic, anc8_Date_Automatic;
    CheckBox investigations_box, anc_1, anc_2, anc_3, anc_4, anc_5, anc_6, anc_7, anc_8;
    LinearLayout investigations_elements, anc1_elements, anc2_elements, anc3_elements, anc4_elements, anc5_elements, anc6_elements, anc7_elements, anc8_elements;


    CheckBox investigations_ChronicHyper, investigations_Type2, investigations_ChronicLiverDisease, investigations_ChronicKidneyDisease, investigations_ALPA, investigations_SLE;
    CheckBox investigations_heatDisease_RHD, investigations_heatDisease_RHDpost, investigations_heatDisease_Acyanotic, investigations_heatDisease_Cyanotic;
    EditText investigations_Others, investigations_DrugHistory;

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
    EditText anc1_investigations_bloodSugar_Fasting, anc1_investigations_bloodSugar_PostPrandial;
    EditText anc1_investigations_ntnb_DoneNotDone;
    EditText anc1_investigations_ntnb_CRL, anc1_investigations_ntnb_NT, anc1_investigations_ntnb_Centile, anc1_investigations_ntnb_Text;
    EditText anc1_investigations_dualScreen_PAPP, anc1_investigations_dualScreen_Bhcg;
    EditText anc1_investigations_level2Usg_DoneNotDone, anc1_investigations_level2Usg_NormalAbnormal;
    CheckBox anc1_investigations_GTT;
    CheckBox anc1_advice_GTT, anc1_advice_BloodSugar, anc1_advice_NtNbScan, anc1_advice_DualScreen, anc1_advice_ICT;
    CheckBox anc1_advice_GeneralNutritional;
    CheckBox anc1_advice_Level2USG;
    CheckBox anc1_advice_TfolateLessThan14Weeks, anc1_advice_TFeMoreThan14Weeks;
    CheckBox anc1_advice_NauseaVomiting, anc1_advice_HeatBurn, anc1_advice_Constipation, anc1_advice_PedalEdema, anc1_advice_LegCramps;
    EditText anc1_general_BgNegICT;
    CheckBox anc1_general_TSH;
    CheckBox anc1_general_urineCulture_Nitrofur, anc1_general_urineCulture_Syp, anc1_general_urineCulture_VitC, anc1_general_urineCulture_PlentyFluids;
    EditText anc1_general_deranged_Fasting, anc1_general_deranged_AfterBreakfast, anc1_general_deranged_AfterLunch, anc1_general_deranged_AfterDinner;
    EditText anc1_general_Others;
    EditText anc1_advice_LeftUterineArteryPl, anc1_advice_RightUterineArteryPl, anc1_advice_PIGF;

//    ANC2 Variables
    EditText anc2_Date;
    EditText anc2_POG;
    CheckBox anc2_history_ShortnessOfBreath, anc2_history_EasyFatiguability, anc2_history_HeadacheEpigastricPain, anc2_history_BleedingSpottingPv, anc2_history_BurningMicturition, anc2_history_QuickeningPerceived;
    EditText anc2_history_Others;
    CheckBox anc2_examination_Pallor, anc2_examination_PedalEdema;
    EditText anc2_examination_PR, anc2_examination_BP, anc2_examination_Weight, anc2_examination_PA2Weeks;
    EditText anc2_examination_Others;
    EditText anc2_investigations_QuadrupleScreen;
    CheckBox anc2_advice_OGTT, anc2_advice_TfeOD, anc2_advice_TcaBD, anc2_advice_Tetanus, anc2_advice_QuadrupleScreen, anc2_advice_FetalEcho;
    CheckBox anc2_advice_HbLess10_TAlbendazole, anc2_advice_HbLess10_TFeBD, anc2_advice_HbLess10_Hplc, anc2_advice_HbLess10_PeripheralSmear, anc2_advice_HbLess10_SerumIron;
    EditText anc2_advice_Others;

//    ANC3 Variables
    CheckBox anc3_history_ShortnessOfBreath, anc3_history_EasyFatigability, anc3_history_HeadacheEpigastricPain, anc3_history_BleedingSpottingPv, anc3_history_LeakingDischargePv, anc3_history_BurningMicturition, anc3_history_FetalMovements, anc3_history_Itching;
    CheckBox anc3_examination_Pallor, anc3_examination_PedalEdema;
    EditText anc3_examination_PR, anc3_examination_BP, anc3_examination_Weight, anc3_examination_PA2Weeks, anc3_examination_Others;
    EditText anc3_examination_FetalEcho;
    CheckBox anc3_investigations_UrineCS, anc3_investigations_ICT;
    EditText anc3_investigations_Others;
    CheckBox anc3_advice_TFeOD, anc3_advice_DFMCLLP, anc3_advice_InjTetanus, anc3_advice_CBC, anc3_advice_LFT, anc3_advice_KFT;
    CheckBox anc3_advice_GTT;
    CheckBox anc3_advice_ictNegative_InjAntiD300;
    EditText anc3_advice_Others;

//    ANC4 Variables
    CheckBox anc4_history_ShortnessOfBreath, anc4_history_EasyFatiguability, anc4_history_HeadacheEpigastricPain, anc4_history_BleedingSpottingPV, anc4_history_BurningMicturition, anc4_history_FetalMovements, anc4_history_Itching;
    EditText anc4_history_Others;
    CheckBox anc4_examination_Pallor, anc4_examination_PedalEdema;
    EditText anc4_examination_PR, anc4_examination_BP, anc4_examination_Weight, anc4_examination_PA2Weeks, anc4_examination_UrineCulture, anc4_examination_ICT;
    EditText anc4_examination_CBC_HB, anc4_examination_CBC_TLC, anc4_examination_CBC_Platelets;
    EditText anc4_examination_LFT_OT, anc4_examination_LFT_PT, anc4_examination_LFT_ALP;
    EditText anc4_examination_KFT_UREA, anc4_examination_KFT_Creatinine;
    CheckBox anc4_advice_TFeOD, anc4_advice_TCaBD, anc4_advice_DFMC, anc4_advice_USG;
    EditText anc4_advice_Others;

//    ANC5 Variables
    CheckBox anc5_history_ShortnessOfBreath, anc5_history_EasyFatiguability, anc5_history_HeadacheEpigastricPain, anc5_history_BleedingSpottingPV, anc5_history_BurningMicturition, anc5_history_FetalMovements, anc5_history_Itching;
    EditText anc5_history_Others;
    CheckBox anc5_history_counseling_ModeOfDel_Vaginal, anc5_history_counseling_ModeOfDel_LSCS;
    EditText anc5_history_counseling_Timing;
    CheckBox anc5_history_counseling_BirthAttendant;
    CheckBox anc5_examination_Pallor, anc5_examination_PedalEdema;
    EditText anc5_examination_PR, anc5_examination_BP, anc5_examination_Weight, anc5_examination_PA2Weeks, anc5_examination_Others;
    EditText anc5_investigation_CBC, anc5_investigation_LFT, anc5_investigation_KFT;
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
    EditText anc5_advice_Others;

//    ANC6 Variables
    CheckBox anc6_history_ShortnessOfBreath, anc6_history_EasyFatiguability, anc6_history_HeadacheEpigastricPain, anc6_history_BleedingSpottingPV, anc6_history_BurningMicturition, anc6_history_FetalMovements, anc6_history_Itching;
    EditText anc6_history_Others;
    CheckBox anc6_examination_Pallor, anc6_examination_PedalEdema;
    EditText anc6_examination_PR, anc6_examination_BP, anc6_examination_Weight, anc6_examination_PA2Weeks, anc6_examination_Others;
    EditText anc6_Pelvic;
    CheckBox anc6_advice_DFMCLLP, anc6_advice_TFeCa, anc6_advice_NST;
    EditText anc6_advice_Others;

//    ANC7 Variables
    CheckBox anc7_history_ShortnessOfBreath, anc7_history_EasyFatiguability, anc7_history_HeadacheEpigastricPain, anc7_history_BleedingSpottingPV, anc7_history_BurningMicturition, anc7_history_FetalMovements, anc7_history_Itching;
    EditText anc7_history_Others;
    CheckBox anc7_examination_Pallor, anc7_examination_PedalEdema;
    EditText anc7_examination_PR, anc7_examination_BP, anc7_examination_Weight, anc7_examination_Pa2Weeks, anc7_examination_Others;
    CheckBox anc7_advice_DFMCLLP, anc7_advice_TFeCa;
    EditText anc7_advice_Others;

//    ANC8 Variables
    CheckBox anc8_history_ShortnessOfBreath, anc8_history_EasyFatiguability, anc8_history_HeadacheEpigastricPain, anc8_history_BleedingSpottingPV, anc8_history_BurningMicturition, anc8_history_FetalMovements, anc8_history_Itching;
    EditText anc8_history_Others;
    CheckBox anc8_examination_Pallor, anc8_examination_PedalEdema, anc8_examination_PA;
    EditText anc8_examination_PR, anc8_examination_BP, anc8_examination_Weight, anc8_examination_Others;
    CheckBox anc8_advice_DFMCLLP, anc8_advice_FeCa, anc8_advice_Induction;
    EditText anc8_advice_Others;

    CheckBox anc3_advice_review;
    CheckBox anc4_advice_review;
    CheckBox anc5_advice_review;
    CheckBox anc6_advice_review;
    CheckBox anc7_advice_review;

    EditText anc1_investigations_GTT_fast, anc1_investigations_GTT_1Hour, anc1_investigations_GTT_2Hour;

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

    EditText anc3_POG, anc4_POG, anc5_POG, anc6_POG, anc7_POG, anc8_POG;

    CheckBox anc2_advice_GeneralNutritional, anc2_advice_NauseaVomiting, anc2_advice_HeatBurn, anc2_advice_Constipation, anc2_advice_PedalEdema, anc2_advice_LegCramps;
    CheckBox anc3_advice_GeneralNutritional, anc3_advice_NauseaVomiting, anc3_advice_HeatBurn, anc3_advice_Constipation, anc3_advice_PedalEdema, anc3_advice_LegCramps;
    CheckBox anc4_advice_GeneralNutritional, anc4_advice_NauseaVomiting, anc4_advice_HeatBurn, anc4_advice_Constipation, anc4_advice_PedalEdema, anc4_advice_LegCramps;
    CheckBox anc5_advice_GeneralNutritional, anc5_advice_NauseaVomiting, anc5_advice_HeatBurn, anc5_advice_Constipation, anc5_advice_PedalEdema, anc5_advice_LegCramps;
    CheckBox anc6_advice_GeneralNutritional, anc6_advice_NauseaVomiting, anc6_advice_HeatBurn, anc6_advice_Constipation, anc6_advice_PedalEdema, anc6_advice_LegCramps;
    CheckBox anc7_advice_GeneralNutritional, anc7_advice_NauseaVomiting, anc7_advice_HeatBurn, anc7_advice_Constipation, anc7_advice_PedalEdema, anc7_advice_LegCramps;
    CheckBox anc8_advice_GeneralNutritional, anc8_advice_NauseaVomiting, anc8_advice_HeatBurn, anc8_advice_Constipation, anc8_advice_PedalEdema, anc8_advice_LegCramps;

    private DatePickerDialog anc1_datePickerDialog;
    private DatePickerDialog anc2_datePickerDialog;
    private DatePickerDialog anc3_datePickerDialog;
    private DatePickerDialog anc4_datePickerDialog;
    private DatePickerDialog anc5_datePickerDialog;
    private DatePickerDialog anc6_datePickerDialog;
    private DatePickerDialog anc7_datePickerDialog;
    private DatePickerDialog anc8_datePickerDialog;

    Boolean temp_anc1_advice_GeneralNutritional;
    Boolean temp_anc2_advice_GeneralNutritional;
    Boolean temp_anc3_advice_GeneralNutritional;
    Boolean temp_anc4_advice_GeneralNutritional;
    Boolean temp_anc5_advice_GeneralNutritional;
    Boolean temp_anc6_advice_GeneralNutritional;
    Boolean temp_anc7_advice_GeneralNutritional;
    Boolean temp_anc8_advice_GeneralNutritional;
    Boolean temp_anc1_History_Nausea;
    Boolean temp_anc2_History_Nausea;
    Boolean temp_anc3_History_Nausea;
    Boolean temp_anc1_advice_HeatBurn;
    Boolean temp_anc2_advice_HeatBurn;
    Boolean temp_anc3_advice_HeatBurn;
    Boolean temp_anc2_advice_Constipation;
    Boolean temp_anc2_advice_PedalEdema;
    Boolean temp_anc2_advice_LegCramps;

    private SimpleDateFormat dateFormatterShow, dateFormatterServer;
    String g;
    int key = 1;

    String lmpDateString;

    void callDateDiff() {
        String[] temp = anc1_Date_String.split("-");
        String date_year = temp[2];
        String date_month = temp[1];
        String date_date = temp[0];

        anc1_Date_String = date_date + "/" + date_month + "/" + date_year;
//        Log.d("ancdatee =", anc1_Date_String);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date d1 = sdf.parse(anc1_Date_String);
//            Log.i("d1", anc1_Date_String);
            Date d2 = sdf.parse(lmpDateString);
//            Log.i("d1", lmpDateString);
            long diff = d1.getTime() - d2.getTime();
//            Log.i("difference", "" + diff);
            long days = diff / (24 * 60 * 60 * 1000);
            long weeks = days / 7;

            days = days % 7;

//            Log.i("month", "" + month);
//            Log.i("days", "" + days);
            String m = "";
            if (weeks == 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else if (weeks > 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else {
                m = weeks + " weeks " + " and " + days + " Days";
                Toast.makeText(this, "Invalid Date!", Toast.LENGTH_SHORT).show();
            }
            Log.d("final m =", m);
            anc1_POG.setText(m);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void callDateDiff2() {
        String[] temp = anc2_Date_String.split("-");
        String date_year = temp[2];
        String date_month = temp[1];
        String date_date = temp[0];

        anc2_Date_String = date_date + "/" + date_month + "/" + date_year;
        Log.d("ancdatee =", anc2_Date_String);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date d1 = sdf.parse(anc2_Date_String);
//            Log.i("d1", anc2_Date_String);
            Date d2 = sdf.parse(lmpDateString);
//            Log.i("d1", lmpDateString);
            long diff = d1.getTime() - d2.getTime();
//            Log.i("difference", "" + diff);
            long days = diff / (24 * 60 * 60 * 1000);
            long weeks = days / 7;

            days = days % 7;

//            Log.i("month", "" + month);
//            Log.i("days", "" + days);
            String m = "";
            if (weeks == 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else if (weeks > 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else {
                m = weeks + " weeks " + " and " + days + " Days";
                Toast.makeText(this, "Invalid Date!", Toast.LENGTH_SHORT).show();
            }
            Log.d("final m =", m);
            anc2_POG.setText(m);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void callDateDiff3() {
        String[] temp = anc3_Date_String.split("-");
        String date_year = temp[2];
        String date_month = temp[1];
        String date_date = temp[0];

        anc3_Date_String = date_date + "/" + date_month + "/" + date_year;
        Log.d("ancdatee =", anc3_Date_String);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date d1 = sdf.parse(anc3_Date_String);
//            Log.i("d1", anc2_Date_String);
            Date d2 = sdf.parse(lmpDateString);
//            Log.i("d1", lmpDateString);
            long diff = d1.getTime() - d2.getTime();
//            Log.i("difference", "" + diff);
            long days = diff / (24 * 60 * 60 * 1000);
            long weeks = days / 7;

            days = days % 7;

//            Log.i("month", "" + month);
//            Log.i("days", "" + days);
            String m = "";
            if (weeks == 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else if (weeks > 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else {
                m = weeks + " weeks " + " and " + days + " Days";
                Toast.makeText(this, "Invalid Date!", Toast.LENGTH_SHORT).show();
            }
            Log.d("final m =", m);
            anc3_POG.setText(m);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void callDateDiff4() {
        String[] temp = anc4_Date_String.split("-");
        String date_year = temp[2];
        String date_month = temp[1];
        String date_date = temp[0];

        anc4_Date_String = date_date + "/" + date_month + "/" + date_year;
        Log.d("ancdatee =", anc4_Date_String);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date d1 = sdf.parse(anc4_Date_String);
//            Log.i("d1", anc2_Date_String);
            Date d2 = sdf.parse(lmpDateString);
//            Log.i("d1", lmpDateString);
            long diff = d1.getTime() - d2.getTime();
//            Log.i("difference", "" + diff);
            long days = diff / (24 * 60 * 60 * 1000);
            long weeks = days / 7;

            days = days % 7;

//            Log.i("month", "" + month);
//            Log.i("days", "" + days);
            String m = "";
            if (weeks == 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else if (weeks > 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else {
                m = weeks + " weeks " + " and " + days + " Days";
                Toast.makeText(this, "Invalid Date!", Toast.LENGTH_SHORT).show();
            }
            Log.d("final m =", m);
            anc4_POG.setText(m);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void callDateDiff5() {
        String[] temp = anc5_Date_String.split("-");
        String date_year = temp[2];
        String date_month = temp[1];
        String date_date = temp[0];

        anc5_Date_String = date_date + "/" + date_month + "/" + date_year;
        Log.d("ancdatee =", anc5_Date_String);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date d1 = sdf.parse(anc5_Date_String);
//            Log.i("d1", anc2_Date_String);
            Date d2 = sdf.parse(lmpDateString);
//            Log.i("d1", lmpDateString);
            long diff = d1.getTime() - d2.getTime();
//            Log.i("difference", "" + diff);
            long days = diff / (24 * 60 * 60 * 1000);
            long weeks = days / 7;

            days = days % 7;

//            Log.i("month", "" + month);
//            Log.i("days", "" + days);
            String m = "";
            if (weeks == 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else if (weeks > 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else {
                m = weeks + " weeks " + " and " + days + " Days";
                Toast.makeText(this, "Invalid Date!", Toast.LENGTH_SHORT).show();
            }
            Log.d("final m =", m);
            anc5_POG.setText(m);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void callDateDiff6() {
        String[] temp = anc6_Date_String.split("-");
        String date_year = temp[2];
        String date_month = temp[1];
        String date_date = temp[0];

        anc6_Date_String = date_date + "/" + date_month + "/" + date_year;
        Log.d("ancdatee =", anc6_Date_String);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date d1 = sdf.parse(anc6_Date_String);
//            Log.i("d1", anc2_Date_String);
            Date d2 = sdf.parse(lmpDateString);
//            Log.i("d1", lmpDateString);
            long diff = d1.getTime() - d2.getTime();
//            Log.i("difference", "" + diff);
            long days = diff / (24 * 60 * 60 * 1000);
            long weeks = days / 7;

            days = days % 7;

//            Log.i("month", "" + month);
//            Log.i("days", "" + days);
            String m = "";
            if (weeks == 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else if (weeks > 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else {
                m = weeks + " weeks " + " and " + days + " Days";
                Toast.makeText(this, "Invalid Date!", Toast.LENGTH_SHORT).show();
            }
            Log.d("final m =", m);
            anc6_POG.setText(m);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void callDateDiff7() {
        String[] temp = anc7_Date_String.split("-");
        String date_year = temp[2];
        String date_month = temp[1];
        String date_date = temp[0];

        anc7_Date_String = date_date + "/" + date_month + "/" + date_year;
        Log.d("ancdatee =", anc7_Date_String);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date d1 = sdf.parse(anc7_Date_String);
//            Log.i("d1", anc2_Date_String);
            Date d2 = sdf.parse(lmpDateString);
//            Log.i("d1", lmpDateString);
            long diff = d1.getTime() - d2.getTime();
//            Log.i("difference", "" + diff);
            long days = diff / (24 * 60 * 60 * 1000);
            long weeks = days / 7;

            days = days % 7;

//            Log.i("month", "" + month);
//            Log.i("days", "" + days);
            String m = "";
            if (weeks == 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else if (weeks > 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else {
                m = weeks + " weeks " + " and " + days + " Days";
                Toast.makeText(this, "Invalid Date!", Toast.LENGTH_SHORT).show();
            }
            Log.d("final m =", m);
            anc7_POG.setText(m);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void callDateDiff8() {
        String[] temp = anc8_Date_String.split("-");
        String date_year = temp[2];
        String date_month = temp[1];
        String date_date = temp[0];

        anc8_Date_String = date_date + "/" + date_month + "/" + date_year;
        Log.d("ancdatee =", anc8_Date_String);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date d1 = sdf.parse(anc8_Date_String);
//            Log.i("d1", anc2_Date_String);
            Date d2 = sdf.parse(lmpDateString);
//            Log.i("d1", lmpDateString);
            long diff = d1.getTime() - d2.getTime();
//            Log.i("difference", "" + diff);
            long days = diff / (24 * 60 * 60 * 1000);
            long weeks = days / 7;

            days = days % 7;

//            Log.i("month", "" + month);
//            Log.i("days", "" + days);
            String m = "";
            if (weeks == 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else if (weeks > 1) {
                m = weeks + " weeks " + " and " + days + " Days";
            } else {
                m = weeks + " weeks " + " and " + days + " Days";
                Toast.makeText(this, "Invalid Date!", Toast.LENGTH_SHORT).show();
            }
            Log.d("final m =", m);
            anc8_POG.setText(m);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //private method of your class
    private int getIndex(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }

        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_data_entry_bydoc);

        dateFormatterShow = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dateFormatterServer = new SimpleDateFormat("dd-MM-yyyy");

        anc1_Date = (EditText) findViewById(R.id.anc1_Date);
        anc2_Date = (EditText) findViewById(R.id.anc2_Date);
        anc3_Date = (EditText) findViewById(R.id.anc3_Date);
        anc4_Date = (EditText) findViewById(R.id.anc4_Date);
        anc5_Date = (EditText) findViewById(R.id.anc5_Date);
        anc6_Date = (EditText) findViewById(R.id.anc6_Date);
        anc7_Date = (EditText) findViewById(R.id.anc7_Date);
        anc8_Date = (EditText) findViewById(R.id.anc8_Date);

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

        investigations_ChronicHyper = (CheckBox) findViewById(R.id.investigations_ChronicHyper);
        investigations_Type2 = (CheckBox) findViewById(R.id.investigations_Type2);
        investigations_ChronicLiverDisease = (CheckBox) findViewById(R.id.investigations_ChronicLiverDisease);
        investigations_ChronicKidneyDisease = (CheckBox) findViewById(R.id.investigations_ChronicKidneyDisease);
        investigations_ALPA = (CheckBox) findViewById(R.id.investigations_ALPA);
        investigations_SLE = (CheckBox) findViewById(R.id.investigations_SLE);
        investigations_heatDisease_RHD = (CheckBox) findViewById(R.id.investigations_heatDisease_RHD);
        investigations_heatDisease_RHDpost = (CheckBox) findViewById(R.id.investigations_heatDisease_RHDpost);
        investigations_heatDisease_Acyanotic = (CheckBox) findViewById(R.id.investigations_heatDisease_Acyanotic);
        investigations_heatDisease_Cyanotic = (CheckBox) findViewById(R.id.investigations_heatDisease_Cyanotic);
        investigations_Others = (EditText) findViewById(R.id.investigations_Others);
        investigations_DrugHistory = (EditText) findViewById(R.id.investigations_DrugHistory);

        anc3_advice_review = (CheckBox) findViewById(R.id.anc3_advice_review);
        anc4_advice_review = (CheckBox) findViewById(R.id.anc4_advice_review);
        anc5_advice_review = (CheckBox) findViewById(R.id.anc5_advice_review);
        anc6_advice_review = (CheckBox) findViewById(R.id.anc6_advice_review);
        anc7_advice_review = (CheckBox) findViewById(R.id.anc7_advice_review);


//        ANC1 Variables
        anc1_POG = (EditText) findViewById(R.id.anc1_POG);
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

        anc1_examination_anthropometry_Height.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
//                anc1_examination_anthropometry_Height.clearFocus();
//                anc1_examination_anthropometry_Height.getText().clear();
//                anc1_examination_anthropometry_Height.requestFocus();
                if (getCurrentFocus() == anc1_examination_anthropometry_Height) {
                    // is only executed if the EditText was directly changed by the user
                    Double height = (anc1_examination_anthropometry_Height.getText().toString().matches("")) ? 1 : (Double) Double.parseDouble(String.valueOf(anc1_examination_anthropometry_Height.getText()));
                    Double weight = (anc1_examination_anthropometry_Weight.getText().toString().matches("")) ? 0 : (Double) Double.parseDouble(String.valueOf(anc1_examination_anthropometry_Weight.getText()));
                    Double BMI = weight / (height * height);
                    DecimalFormat df = new DecimalFormat("#.00");
                    String angleFormated = df.format(BMI);
                    anc1_examination_anthropometry_Bmi.setText(angleFormated);
                }
            }


            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void afterTextChanged(Editable s) {

            }
        });

        anc1_examination_anthropometry_Weight.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
//                anc1_examination_anthropometry_Weight.clearFocus();
//                anc1_examination_anthropometry_Weight.getText().clear();
//                anc1_examination_anthropometry_Weight.requestFocus();
                if (getCurrentFocus() == anc1_examination_anthropometry_Weight) {
                    // is only executed if the EditText was directly changed by the user
//                    anc1_examination_anthropometry_Weight.requestFocus();
                    Double height = (anc1_examination_anthropometry_Height.getText().toString().matches("")) ? 1 : (Double) Double.parseDouble(String.valueOf(anc1_examination_anthropometry_Height.getText()));
                    Double weight = (anc1_examination_anthropometry_Weight.getText().toString().matches("")) ? 0 : (Double) Double.parseDouble(String.valueOf(anc1_examination_anthropometry_Weight.getText()));
                    Double BMI = weight / (height * height);
                    DecimalFormat df = new DecimalFormat("#.00");
                    String angleFormated = df.format(BMI);
                    anc1_examination_anthropometry_Bmi.setText(angleFormated);
                }
            }


            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void afterTextChanged(Editable s) {

            }
        });

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
        anc1_investigations_ntnb_CRL = (EditText) findViewById(R.id.anc1_investigations_ntnb_CRL);
        anc1_investigations_ntnb_NT = (EditText) findViewById(R.id.anc1_investigations_ntnb_NT);
        anc1_investigations_ntnb_Centile = (EditText) findViewById(R.id.anc1_investigations_ntnb_Centile);
        anc1_investigations_ntnb_Text = (EditText) findViewById(R.id.anc1_investigations_ntnb_Text);

        anc1_investigations_dualScreen_PAPP = (EditText) findViewById(R.id.anc1_investigations_dualScreen_PAPP);
        anc1_investigations_dualScreen_Bhcg = (EditText) findViewById(R.id.anc1_investigations_dualScreen_Bhcg);
        anc1_investigations_level2Usg_DoneNotDone = (EditText) findViewById(R.id.anc1_investigations_level2Usg_DoneNotDone);
        anc1_investigations_level2Usg_NormalAbnormal = (EditText) findViewById(R.id.anc1_investigations_level2Usg_NormalAbnormal);
        anc1_advice_GTT = (CheckBox) findViewById(R.id.anc1_advice_GTT);
        anc1_advice_BloodSugar = (CheckBox) findViewById(R.id.anc1_advice_BloodSugar);
        anc1_advice_NtNbScan = (CheckBox) findViewById(R.id.anc1_advice_NtNbScan);
        anc1_advice_DualScreen = (CheckBox) findViewById(R.id.anc1_advice_DualScreen);
        anc1_advice_LeftUterineArteryPl = (EditText) findViewById(R.id.anc1_advice_LeftUterineArteryPl);
        anc1_advice_RightUterineArteryPl = (EditText) findViewById(R.id.anc1_advice_RightUterineArteryPl);
        anc1_advice_PIGF = (EditText) findViewById(R.id.anc1_advice_PIGF);
        anc1_advice_ICT = (CheckBox) findViewById(R.id.anc1_advice_ICT);
        anc1_advice_Level2USG = (CheckBox) findViewById(R.id.anc1_advice_Level2USG);
        anc1_advice_GeneralNutritional = (CheckBox) findViewById(R.id.anc1_advice_GeneralNutritional);
        anc1_advice_NauseaVomiting = (CheckBox) findViewById(R.id.anc1_advice_NauseaVomiting);
        anc1_advice_HeatBurn = (CheckBox) findViewById(R.id.anc1_advice_HeatBurn);
        anc1_advice_Constipation = (CheckBox) findViewById(R.id.anc1_advice_Constipation);
        anc1_advice_PedalEdema = (CheckBox) findViewById(R.id.anc1_advice_PedalEdema);
        anc1_advice_LegCramps = (CheckBox) findViewById(R.id.anc1_advice_LegCramps);

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
//        anc2_POG.setVisibility(View.GONE);

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
        anc1_advice_TfolateLessThan14Weeks = (CheckBox) findViewById(R.id.anc1_advice_TfolateLessThan14Weeks);
        anc1_advice_TFeMoreThan14Weeks = (CheckBox) findViewById(R.id.anc1_advice_TFeMoreThan14Weeks);

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
        anc2_advice_GeneralNutritional = (CheckBox) findViewById(R.id.anc2_advice_GeneralNutritional);
        anc2_advice_NauseaVomiting = (CheckBox) findViewById(R.id.anc2_advice_NauseaVomiting);
        anc2_advice_HeatBurn = (CheckBox) findViewById(R.id.anc2_advice_HeatBurn);
        anc2_advice_Constipation = (CheckBox) findViewById(R.id.anc2_advice_Constipation);
        anc2_advice_PedalEdema = (CheckBox) findViewById(R.id.anc2_advice_PedalEdema);
        anc2_advice_LegCramps = (CheckBox) findViewById(R.id.anc2_advice_LegCramps);
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
        anc3_examination_FetalEcho = (EditText) findViewById(R.id.anc3_examination_FetalEcho);
        anc3_examination_Others = (EditText) findViewById(R.id.anc3_examination_Others);

        anc3_investigations_UrineCS = (CheckBox) findViewById(R.id.anc3_investigations_UrineCS);
        anc3_investigations_ICT = (CheckBox) findViewById(R.id.anc3_investigations_ICT);
        anc3_investigations_Others = (EditText) findViewById(R.id.anc3_investigations_Others);

        anc3_advice_TFeOD = (CheckBox) findViewById(R.id.anc3_advice_TFeOD);
        anc3_advice_DFMCLLP = (CheckBox) findViewById(R.id.anc3_advice_DFMCLLP);
        anc3_advice_InjTetanus = (CheckBox) findViewById(R.id.anc3_advice_InjTetanus);
        anc3_advice_CBC = (CheckBox) findViewById(R.id.anc3_advice_CBC);
        anc3_advice_LFT = (CheckBox) findViewById(R.id.anc3_advice_LFT);
        anc3_advice_KFT = (CheckBox) findViewById(R.id.anc3_advice_KFT);
        anc3_advice_GTT = (CheckBox) findViewById(R.id.anc3_advice_GTT);
        anc3_advice_ictNegative_InjAntiD300 = (CheckBox) findViewById(R.id.anc3_advice_ictNegative_InjAntiD300);

        anc3_advice_GeneralNutritional = (CheckBox) findViewById(R.id.anc3_advice_GeneralNutritional);
        anc3_advice_NauseaVomiting = (CheckBox) findViewById(R.id.anc3_advice_NauseaVomiting);
        anc3_advice_HeatBurn = (CheckBox) findViewById(R.id.anc3_advice_HeatBurn);
        anc3_advice_Constipation = (CheckBox) findViewById(R.id.anc3_advice_Constipation);
        anc3_advice_PedalEdema = (CheckBox) findViewById(R.id.anc3_advice_PedalEdema);
        anc3_advice_LegCramps = (CheckBox) findViewById(R.id.anc3_advice_LegCramps);
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
        anc4_advice_GeneralNutritional = (CheckBox) findViewById(R.id.anc4_advice_GeneralNutritional);
        anc4_advice_NauseaVomiting = (CheckBox) findViewById(R.id.anc4_advice_NauseaVomiting);
        anc4_advice_HeatBurn = (CheckBox) findViewById(R.id.anc4_advice_HeatBurn);
        anc4_advice_Constipation = (CheckBox) findViewById(R.id.anc4_advice_Constipation);
        anc4_advice_PedalEdema = (CheckBox) findViewById(R.id.anc4_advice_PedalEdema);
        anc4_advice_LegCramps = (CheckBox) findViewById(R.id.anc4_advice_LegCramps);
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

        anc5_investigation_CBC = (EditText) findViewById(R.id.anc5_investigation_CBC);
        anc5_investigation_LFT = (EditText) findViewById(R.id.anc5_investigation_LFT);
        anc5_investigation_KFT = (EditText) findViewById(R.id.anc5_investigation_KFT);
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
        anc5_advice_GeneralNutritional = (CheckBox) findViewById(R.id.anc5_advice_GeneralNutritional);
        anc5_advice_NauseaVomiting = (CheckBox) findViewById(R.id.anc5_advice_NauseaVomiting);
        anc5_advice_HeatBurn = (CheckBox) findViewById(R.id.anc5_advice_HeatBurn);
        anc5_advice_Constipation = (CheckBox) findViewById(R.id.anc5_advice_Constipation);
        anc5_advice_PedalEdema = (CheckBox) findViewById(R.id.anc5_advice_PedalEdema);
        anc5_advice_LegCramps = (CheckBox) findViewById(R.id.anc5_advice_LegCramps);
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
        anc6_advice_GeneralNutritional = (CheckBox) findViewById(R.id.anc6_advice_GeneralNutritional);
        anc6_advice_NauseaVomiting = (CheckBox) findViewById(R.id.anc6_advice_NauseaVomiting);
        anc6_advice_HeatBurn = (CheckBox) findViewById(R.id.anc6_advice_HeatBurn);
        anc6_advice_Constipation = (CheckBox) findViewById(R.id.anc6_advice_Constipation);
        anc6_advice_PedalEdema = (CheckBox) findViewById(R.id.anc6_advice_PedalEdema);
        anc6_advice_LegCramps = (CheckBox) findViewById(R.id.anc6_advice_LegCramps);

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
        anc7_advice_GeneralNutritional = (CheckBox) findViewById(R.id.anc7_advice_GeneralNutritional);
        anc7_advice_NauseaVomiting = (CheckBox) findViewById(R.id.anc7_advice_NauseaVomiting);
        anc7_advice_HeatBurn = (CheckBox) findViewById(R.id.anc7_advice_HeatBurn);
        anc7_advice_Constipation = (CheckBox) findViewById(R.id.anc7_advice_Constipation);
        anc7_advice_PedalEdema = (CheckBox) findViewById(R.id.anc7_advice_PedalEdema);
        anc7_advice_LegCramps = (CheckBox) findViewById(R.id.anc7_advice_LegCramps);

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
        anc8_advice_GeneralNutritional = (CheckBox) findViewById(R.id.anc8_advice_GeneralNutritional);
        anc8_advice_NauseaVomiting = (CheckBox) findViewById(R.id.anc8_advice_NauseaVomiting);
        anc8_advice_HeatBurn = (CheckBox) findViewById(R.id.anc8_advice_HeatBurn);
        anc8_advice_Constipation = (CheckBox) findViewById(R.id.anc8_advice_Constipation);
        anc8_advice_PedalEdema = (CheckBox) findViewById(R.id.anc8_advice_PedalEdema);
        anc8_advice_LegCramps = (CheckBox) findViewById(R.id.anc8_advice_LegCramps);

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

        anc_1 = (CheckBox) findViewById(R.id.anc_1);
        anc_2 = (CheckBox) findViewById(R.id.anc_2);
        anc_3 = (CheckBox) findViewById(R.id.anc_3);
        anc_4 = (CheckBox) findViewById(R.id.anc_4);
        anc_5 = (CheckBox) findViewById(R.id.anc_5);
        anc_6 = (CheckBox) findViewById(R.id.anc_6);
        anc_7 = (CheckBox) findViewById(R.id.anc_7);
        anc_8 = (CheckBox) findViewById(R.id.anc_8);
        investigations_box = (CheckBox) findViewById(R.id.investigations_box);

        investigations_elements = (LinearLayout) findViewById(R.id.investigations_elements);
        anc1_elements = (LinearLayout) findViewById(R.id.anc1_elements);
        anc2_elements = (LinearLayout) findViewById(R.id.anc2_elements);
        anc3_elements = (LinearLayout) findViewById(R.id.anc3_elements);
        anc4_elements = (LinearLayout) findViewById(R.id.anc4_elements);
        anc5_elements = (LinearLayout) findViewById(R.id.anc5_elements);
        anc6_elements = (LinearLayout) findViewById(R.id.anc6_elements);
        anc7_elements = (LinearLayout) findViewById(R.id.anc7_elements);
        anc8_elements = (LinearLayout) findViewById(R.id.anc8_elements);

        anc3_POG = (EditText) findViewById(R.id.anc3_POG);
        anc4_POG = (EditText) findViewById(R.id.anc4_POG);
        anc5_POG = (EditText) findViewById(R.id.anc5_POG);
        anc6_POG = (EditText) findViewById(R.id.anc6_POG);
        anc7_POG = (EditText) findViewById(R.id.anc7_POG);
        anc8_POG = (EditText) findViewById(R.id.anc8_POG);

        investigations_box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    investigations_elements.setVisibility(View.VISIBLE);
                } else {
                    investigations_elements.setVisibility(View.GONE);
                }
            }
        });
        anc_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    anc1_elements.setVisibility(View.VISIBLE);
                } else {
                    anc1_elements.setVisibility(View.GONE);
                }
            }
        });
        anc_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    anc2_elements.setVisibility(View.VISIBLE);
                } else {
                    anc2_elements.setVisibility(View.GONE);
                }
            }
        });
        anc_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    anc3_elements.setVisibility(View.VISIBLE);
                } else {
                    anc3_elements.setVisibility(View.GONE);
                }
            }
        });
        anc_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    anc4_elements.setVisibility(View.VISIBLE);
                } else {
                    anc4_elements.setVisibility(View.GONE);
                }
            }
        });
        anc_5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    anc5_elements.setVisibility(View.VISIBLE);
                } else {
                    anc5_elements.setVisibility(View.GONE);
                }
            }
        });
        anc_6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    anc6_elements.setVisibility(View.VISIBLE);
                } else {
                    anc6_elements.setVisibility(View.GONE);
                }
            }
        });
        anc_7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    anc7_elements.setVisibility(View.VISIBLE);
                } else {
                    anc7_elements.setVisibility(View.GONE);
                }
            }
        });
        anc_8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                 if (isChecked) {
                                                     anc8_elements.setVisibility(View.VISIBLE);
                                                 } else {
                                                     anc8_elements.setVisibility(View.GONE);
                                                 }
                                             }
                                         });

        getSupportActionBar().setTitle("Add Data");

        session = new SessionManager(this);

        clickedPatientId = getIntent().getIntExtra("EXTRA_PATIENT_ID", 0);
        p_id = String.valueOf(clickedPatientId);
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

                            investigations_box.setChecked(response.getBoolean("investigations_box"));
                            if(!response.getBoolean("investigations_box")){
                                investigations_elements.setVisibility(View.GONE);
                            } else {
                                investigations_elements.setVisibility(View.VISIBLE);
                            }
                            investigations_ChronicHyper.setChecked(response.getBoolean("investigations_ChronicHyper"));
                            investigations_Type2.setChecked(response.getBoolean("investigations_Type2"));
                            investigations_ChronicLiverDisease.setChecked(response.getBoolean("investigations_ChronicLiverDisease"));
                            investigations_ChronicKidneyDisease.setChecked(response.getBoolean("investigations_ChronicKidneyDisease"));
                            investigations_ALPA.setChecked(response.getBoolean("investigations_ALPA"));
                            investigations_SLE.setChecked(response.getBoolean("investigations_SLE"));
                            investigations_heatDisease_RHD.setChecked(response.getBoolean("investigations_heatDisease_RHD"));
                            investigations_heatDisease_RHDpost.setChecked(response.getBoolean("investigations_heatDisease_RHDpost"));
                            investigations_heatDisease_Acyanotic.setChecked(response.getBoolean("investigations_heatDisease_Acyanotic"));
                            investigations_heatDisease_Cyanotic.setChecked(response.getBoolean("investigations_heatDisease_Cyanotic"));
                            investigations_Others.setText(response.getString("investigations_Others"));
                            investigations_DrugHistory.setText(response.getString("investigations_DrugHistory"));

                            anc3_advice_review.setChecked(response.getBoolean("anc3_advice_review"));
                            anc4_advice_review.setChecked(response.getBoolean("anc4_advice_review"));
                            anc5_advice_review.setChecked(response.getBoolean("anc5_advice_review"));
                            anc6_advice_review.setChecked(response.getBoolean("anc6_advice_review"));
                            anc7_advice_review.setChecked(response.getBoolean("anc7_advice_review"));

                            anc_1.setChecked(response.getBoolean("anc_1"));
                            if(!response.getBoolean("anc_1")){
                                anc1_elements.setVisibility(View.GONE);
                            } else {
                                anc1_elements.setVisibility(View.VISIBLE);
                            }
                            anc1_Date.setText(response.getString("anc1_Date"));
                            anc1_POG.setText(response.getString("anc1_POG"));
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
//                            anc1_examination_anthropometry_Height.clearFocus();
//                            anc1_examination_anthropometry_Weight.clearFocus();




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
                            anc1_examination_vitals_Proteinuria.setSelection(getIndex(anc1_examination_vitals_Proteinuria, response.getString("anc1_examination_vitals_Proteinuria")));

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
                            anc1_investigations_BloodGroup.setSelection(getIndex(anc1_investigations_BloodGroup, response.getString("anc1_investigations_BloodGroup")));
                            anc1_investigations_HusbandBloodGroup.setSelection(getIndex(anc1_investigations_HusbandBloodGroup, response.getString("anc1_investigations_HusbandBloodGroup")));
                            anc1_investigations_Hemogram.setText(response.getString("anc1_investigations_Hemogram"));
                            anc1_investigations_Tsh.setText(response.getString("anc1_investigations_Tsh"));
                            anc1_investigations_GTT_fast.setText(response.getString("anc1_investigations_GTT_fast"));
                            anc1_investigations_GTT_1Hour.setText(response.getString("anc1_investigations_GTT_1Hour"));
                            anc1_investigations_GTT_2Hour.setText(response.getString("anc1_investigations_GTT_2Hour"));
                            anc1_investigations_bloodSugar_Fasting.setText(response.getString("anc1_investigations_bloodSugar_Fasting"));
                            anc1_investigations_bloodSugar_PostPrandial.setText(response.getString("anc1_investigations_bloodSugar_PostPrandial"));
                            anc1_investigations_ntnb_DoneNotDone.setText(response.getString("anc1_investigations_ntnb_DoneNotDone"));
                            anc1_investigations_ntnb_CRL.setText(response.getString("anc1_investigations_ntnb_CRL"));
                            anc1_investigations_ntnb_NT.setText(response.getString("anc1_investigations_ntnb_NT"));
                            anc1_investigations_ntnb_Centile.setText(response.getString("anc1_investigations_ntnb_Centile"));
                            anc1_investigations_ntnb_Text.setText(response.getString("anc1_investigations_ntnb_Text"));
                            anc1_investigations_dualScreen_PAPP.setText(response.getString("anc1_investigations_dualScreen_PAPP"));
                            anc1_investigations_dualScreen_Bhcg.setText(response.getString("anc1_investigations_dualScreen_Bhcg"));
                            anc1_investigations_level2Usg_DoneNotDone.setText(response.getString("anc1_investigations_level2Usg_DoneNotDone"));
                            anc1_investigations_level2Usg_NormalAbnormal.setText(response.getString("anc1_investigations_level2Usg_NormalAbnormal"));

                            anc1_advice_GTT.setChecked(response.getBoolean("anc1_advice_GTT"));
                            anc1_advice_BloodSugar.setChecked(response.getBoolean("anc1_advice_BloodSugar"));
                            anc1_advice_NtNbScan.setChecked(response.getBoolean("anc1_advice_NtNbScan"));
                            anc1_advice_DualScreen.setChecked(response.getBoolean("anc1_advice_DualScreen"));

                            anc1_advice_LeftUterineArteryPl.setText(response.getString("anc1_advice_LeftUterineArteryPl"));
                            anc1_advice_RightUterineArteryPl.setText(response.getString("anc1_advice_RightUterineArteryPl"));
                            anc1_advice_PIGF.setText(response.getString("anc1_advice_PIGF"));

                            anc1_advice_ICT.setChecked(response.getBoolean("anc1_advice_ICT"));
                            anc1_advice_Level2USG.setChecked(response.getBoolean("anc1_advice_Level2USG"));
                            anc1_advice_GeneralNutritional.setChecked(response.getBoolean("anc1_advice_GeneralNutritional"));
                            anc1_advice_NauseaVomiting.setChecked(response.getBoolean("anc1_advice_NauseaVomiting"));
                            anc1_advice_HeatBurn.setChecked(response.getBoolean("anc1_advice_HeatBurn"));
                            anc1_advice_Constipation.setChecked(response.getBoolean("anc1_advice_Constipation"));
                            anc1_advice_PedalEdema.setChecked(response.getBoolean("anc1_advice_PedalEdema"));
                            anc1_advice_LegCramps.setChecked(response.getBoolean("anc1_advice_LegCramps"));
                            anc2_advice_GeneralNutritional.setChecked(response.getBoolean("anc2_advice_GeneralNutritional"));
                            anc2_advice_NauseaVomiting.setChecked(response.getBoolean("anc2_advice_NauseaVomiting"));
                            anc2_advice_HeatBurn.setChecked(response.getBoolean("anc2_advice_HeatBurn"));
                            anc2_advice_Constipation.setChecked(response.getBoolean("anc2_advice_Constipation"));
                            anc2_advice_PedalEdema.setChecked(response.getBoolean("anc2_advice_PedalEdema"));
                            anc2_advice_LegCramps.setChecked(response.getBoolean("anc2_advice_LegCramps"));

                            temp_anc1_advice_GeneralNutritional = response.getBoolean("anc2_advice_GeneralNutritional");
                            temp_anc1_History_Nausea = response.getBoolean("anc2_advice_NauseaVomiting");
                            temp_anc1_advice_HeatBurn = response.getBoolean("anc2_advice_HeatBurn");
                            temp_anc2_advice_GeneralNutritional = response.getBoolean("anc2_advice_GeneralNutritional");
                            temp_anc3_advice_GeneralNutritional = response.getBoolean("anc3_advice_GeneralNutritional");
                            temp_anc4_advice_GeneralNutritional = response.getBoolean("anc4_advice_GeneralNutritional");
                            temp_anc5_advice_GeneralNutritional = response.getBoolean("anc5_advice_GeneralNutritional");
                            temp_anc6_advice_GeneralNutritional = response.getBoolean("anc6_advice_GeneralNutritional");
                            temp_anc7_advice_GeneralNutritional = response.getBoolean("anc7_advice_GeneralNutritional");
                            temp_anc8_advice_GeneralNutritional = response.getBoolean("anc8_advice_GeneralNutritional");
                            temp_anc2_History_Nausea = response.getBoolean("anc2_advice_NauseaVomiting");
                            temp_anc3_History_Nausea = response.getBoolean("anc3_advice_NauseaVomiting");
                            temp_anc2_advice_HeatBurn = response.getBoolean("anc2_advice_HeatBurn");
                            temp_anc3_advice_HeatBurn = response.getBoolean("anc3_advice_HeatBurn");
                            temp_anc2_advice_Constipation = response.getBoolean("anc2_advice_Constipation");
                            temp_anc2_advice_PedalEdema = response.getBoolean("anc2_advice_PedalEdema");
                            temp_anc2_advice_LegCramps = response.getBoolean("anc2_advice_LegCramps");

                            anc3_advice_GeneralNutritional.setChecked(response.getBoolean("anc3_advice_GeneralNutritional"));
                            anc3_advice_NauseaVomiting.setChecked(response.getBoolean("anc3_advice_NauseaVomiting"));
                            anc3_advice_HeatBurn.setChecked(response.getBoolean("anc3_advice_HeatBurn"));
                            anc3_advice_Constipation.setChecked(response.getBoolean("anc3_advice_Constipation"));
                            anc3_advice_PedalEdema.setChecked(response.getBoolean("anc3_advice_PedalEdema"));
                            anc3_advice_LegCramps.setChecked(response.getBoolean("anc3_advice_LegCramps"));

                            anc4_advice_GeneralNutritional.setChecked(response.getBoolean("anc4_advice_GeneralNutritional"));
                            anc4_advice_NauseaVomiting.setChecked(response.getBoolean("anc4_advice_NauseaVomiting"));
                            anc4_advice_HeatBurn.setChecked(response.getBoolean("anc4_advice_HeatBurn"));
                            anc4_advice_Constipation.setChecked(response.getBoolean("anc4_advice_Constipation"));
                            anc4_advice_PedalEdema.setChecked(response.getBoolean("anc4_advice_PedalEdema"));
                            anc4_advice_LegCramps.setChecked(response.getBoolean("anc4_advice_LegCramps"));

                            anc5_advice_GeneralNutritional.setChecked(response.getBoolean("anc5_advice_GeneralNutritional"));
                            anc5_advice_NauseaVomiting.setChecked(response.getBoolean("anc5_advice_NauseaVomiting"));
                            anc5_advice_HeatBurn.setChecked(response.getBoolean("anc5_advice_HeatBurn"));
                            anc5_advice_Constipation.setChecked(response.getBoolean("anc5_advice_Constipation"));
                            anc5_advice_PedalEdema.setChecked(response.getBoolean("anc5_advice_PedalEdema"));
                            anc5_advice_LegCramps.setChecked(response.getBoolean("anc5_advice_LegCramps"));

                            anc6_advice_GeneralNutritional.setChecked(response.getBoolean("anc6_advice_GeneralNutritional"));
                            anc6_advice_NauseaVomiting.setChecked(response.getBoolean("anc6_advice_NauseaVomiting"));
                            anc6_advice_HeatBurn.setChecked(response.getBoolean("anc6_advice_HeatBurn"));
                            anc6_advice_Constipation.setChecked(response.getBoolean("anc6_advice_Constipation"));
                            anc6_advice_PedalEdema.setChecked(response.getBoolean("anc6_advice_PedalEdema"));
                            anc6_advice_LegCramps.setChecked(response.getBoolean("anc6_advice_LegCramps"));

                            anc7_advice_GeneralNutritional.setChecked(response.getBoolean("anc7_advice_GeneralNutritional"));
                            anc7_advice_NauseaVomiting.setChecked(response.getBoolean("anc7_advice_NauseaVomiting"));
                            anc7_advice_HeatBurn.setChecked(response.getBoolean("anc7_advice_HeatBurn"));
                            anc7_advice_Constipation.setChecked(response.getBoolean("anc7_advice_Constipation"));
                            anc7_advice_PedalEdema.setChecked(response.getBoolean("anc7_advice_PedalEdema"));
                            anc7_advice_LegCramps.setChecked(response.getBoolean("anc7_advice_LegCramps"));

                            anc8_advice_GeneralNutritional.setChecked(response.getBoolean("anc8_advice_GeneralNutritional"));
                            anc8_advice_NauseaVomiting.setChecked(response.getBoolean("anc8_advice_NauseaVomiting"));
                            anc8_advice_HeatBurn.setChecked(response.getBoolean("anc8_advice_HeatBurn"));
                            anc8_advice_Constipation.setChecked(response.getBoolean("anc8_advice_Constipation"));
                            anc8_advice_PedalEdema.setChecked(response.getBoolean("anc8_advice_PedalEdema"));
                            anc8_advice_LegCramps.setChecked(response.getBoolean("anc8_advice_LegCramps"));

                            anc1_advice_NauseaVomiting.setChecked(response.getBoolean("anc1_advice_NauseaVomiting"));
                            anc1_advice_HeatBurn.setChecked(response.getBoolean("anc1_advice_HeatBurn"));
                            anc1_advice_Constipation.setChecked(response.getBoolean("anc1_advice_Constipation"));
                            anc1_advice_PedalEdema.setChecked(response.getBoolean("anc1_advice_PedalEdema"));
                            anc1_advice_LegCramps.setChecked(response.getBoolean("anc1_advice_LegCramps"));
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

                            anc_2.setChecked(response.getBoolean("anc_2"));
                            if(!response.getBoolean("anc_2")){
                                anc2_elements.setVisibility(View.GONE);
                            } else {
                                anc2_elements.setVisibility(View.VISIBLE);
                            }
                            anc2_Date.setText(response.getString("anc2_Date"));
                            Log.i("jajajajajajajajaaj", "onResponse: " + response.getString("anc2_POG"));
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
                            anc1_advice_TfolateLessThan14Weeks.setChecked(response.getBoolean("anc1_advice_TfolateLessThan14Weeks"));
                            anc1_advice_TFeMoreThan14Weeks.setChecked(response.getBoolean("anc1_advice_TFeMoreThan14Weeks"));
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
                            anc2_advice_Others.setText(response.getString("anc2_advice_Others"));

                            anc_3.setChecked(response.getBoolean("anc_3"));
                            if(!response.getBoolean("anc_3")){
                                anc3_elements.setVisibility(View.GONE);
                            } else {
                                anc3_elements.setVisibility(View.VISIBLE);
                            }
                            anc3_Date.setText(response.getString("anc3_Date"));
                            anc3_POG.setText(response.getString("anc3_POG"));
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
                            anc3_examination_FetalEcho.setText(response.getString("anc3_examination_FetalEcho"));
                            anc3_examination_Others.setText(response.getString("anc3_examination_Others"));
                            anc3_investigations_UrineCS.setChecked(response.getBoolean("anc3_investigations_UrineCS"));
                            anc3_investigations_ICT.setChecked(response.getBoolean("anc3_investigations_ICT"));
                            anc3_investigations_Others.setText(response.getString("anc3_investigations_Others"));
                            anc3_advice_TFeOD.setChecked(response.getBoolean("anc3_advice_TFeOD"));
                            anc3_advice_DFMCLLP.setChecked(response.getBoolean("anc3_advice_DFMCLLP"));
                            anc3_advice_InjTetanus.setChecked(response.getBoolean("anc3_advice_InjTetanus"));
                            anc3_advice_CBC.setChecked(response.getBoolean("anc3_advice_CBC"));
                            anc3_advice_LFT.setChecked(response.getBoolean("anc3_advice_LFT"));
                            anc3_advice_KFT.setChecked(response.getBoolean("anc3_advice_KFT"));
                            anc3_advice_GTT.setChecked(response.getBoolean("anc3_advice_GTT"));
                            anc3_advice_ictNegative_InjAntiD300.setChecked(response.getBoolean("anc3_advice_ictNegative_InjAntiD300"));

                            //        ANC4 Variables
                            anc_4.setChecked(response.getBoolean("anc_4"));
                            if(!response.getBoolean("anc_4")){
                                anc4_elements.setVisibility(View.GONE);
                            } else {
                                anc4_elements.setVisibility(View.VISIBLE);
                            }
                            anc4_Date.setText(response.getString("anc4_Date"));
                            anc4_POG.setText(response.getString("anc4_POG"));
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
                            anc4_advice_Others.setText(response.getString("anc4_advice_Others"));


                            //        ANC5 Variables
                            anc_5.setChecked(response.getBoolean("anc_5"));
                            if(!response.getBoolean("anc_5")){
                                anc5_elements.setVisibility(View.GONE);
                            } else {
                                anc5_elements.setVisibility(View.VISIBLE);
                            }
                            anc5_Date.setText(response.getString("anc5_Date"));
                            anc5_POG.setText(response.getString("anc5_POG"));
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
                            anc5_investigation_CBC.setText(response.getString("anc5_investigation_CBC"));
                            anc5_investigation_LFT.setText(response.getString("anc5_investigation_LFT"));
                            anc5_investigation_KFT.setText(response.getString("anc5_investigation_KFT"));
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
                            anc5_advice_Others.setText(response.getString("anc5_advice_Others"));

                            anc_6.setChecked(response.getBoolean("anc_6"));
                            if(!response.getBoolean("anc_6")){
                                anc6_elements.setVisibility(View.GONE);
                            } else {
                                anc6_elements.setVisibility(View.VISIBLE);
                            }
                            anc6_Date.setText(response.getString("anc6_Date"));
                            anc6_POG.setText(response.getString("anc6_POG"));
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
                            anc6_history_Others.setText(response.getString("anc6_history_Others"));
                            anc6_examination_PR.setText(response.getString("anc6_examination_PR"));
                            anc6_examination_BP.setText(response.getString("anc6_examination_BP"));
                            anc6_examination_Weight.setText(response.getString("anc6_examination_Weight"));
                            anc6_examination_PA2Weeks.setText(response.getString("anc6_examination_PA2Weeks"));
                            anc6_examination_Others.setText(response.getString("anc6_examination_Others"));
                            anc6_Pelvic.setText(response.getString("anc6_Pelvic"));
                            anc6_advice_Others.setText(response.getString("anc6_advice_Others"));

                            anc_7.setChecked(response.getBoolean("anc_7"));
                            if(!response.getBoolean("anc_7")){
                                anc7_elements.setVisibility(View.GONE);
                            } else {
                                anc7_elements.setVisibility(View.VISIBLE);
                            }
                            anc7_Date.setText(response.getString("anc7_Date"));
                            anc7_POG.setText(response.getString("anc7_POG"));
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
                            anc7_history_Others.setText(response.getString("anc7_history_Others"));
                            anc7_examination_PR.setText(response.getString("anc7_examination_PR"));
                            anc7_examination_BP.setText(response.getString("anc7_examination_BP"));
                            anc7_examination_Weight.setText(response.getString("anc7_examination_Weight"));
                            anc7_examination_Pa2Weeks.setText(response.getString("anc7_examination_Pa2Weeks"));
                            anc7_examination_Others.setText(response.getString("anc7_examination_Others"));
                            anc7_advice_Others.setText(response.getString("anc7_advice_Others"));

                            anc_8.setChecked(response.getBoolean("anc_8"));
                            if(!response.getBoolean("anc_8")){
                                anc8_elements.setVisibility(View.GONE);
                            } else {
                                anc8_elements.setVisibility(View.VISIBLE);
                            }
                            anc8_Date.setText(response.getString("anc8_Date"));
                            anc8_POG.setText(response.getString("anc8_POG"));
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

        getPatientData(clickedPatientId);

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
        Spinner spinnerHusbandBloodGroup = (Spinner) findViewById(R.id.anc1_investigations_HusbandBloodGroup);
        ArrayAdapter<CharSequence> adapterHusbandBloodGroup = ArrayAdapter.createFromResource(this,
                R.array.BloodGroupDropdownElements, android.R.layout.simple_spinner_item);
        adapterHusbandBloodGroup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHusbandBloodGroup.setAdapter(adapterHusbandBloodGroup);


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
                anc2_Date.setText(dateFormatterShow.format(anc2_Date_Calender.getTime()));
                anc2_Date_String = dateFormatterShow.format(anc2_Date_Calender.getTime());
                callDateDiff2();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc3_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc3_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc3_Date.setText(dateFormatterShow.format(anc3_Date_Calender.getTime()));
                anc3_Date_String = dateFormatterShow.format(anc3_Date_Calender.getTime());
                callDateDiff3();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc4_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc4_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc4_Date.setText(dateFormatterShow.format(anc4_Date_Calender.getTime()));
                anc4_Date_String = dateFormatterShow.format(anc4_Date_Calender.getTime());
                callDateDiff4();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc5_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc5_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc5_Date.setText(dateFormatterShow.format(anc5_Date_Calender.getTime()));
                anc5_Date_String = dateFormatterShow.format(anc5_Date_Calender.getTime());
                callDateDiff5();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc6_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc6_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc6_Date.setText(dateFormatterShow.format(anc6_Date_Calender.getTime()));
                anc6_Date_String = dateFormatterShow.format(anc6_Date_Calender.getTime());
                callDateDiff6();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc7_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc7_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc7_Date.setText(dateFormatterShow.format(anc7_Date_Calender.getTime()));
                anc7_Date_String = dateFormatterShow.format(anc7_Date_Calender.getTime());
                callDateDiff7();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        anc8_datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc8_Date_Calender.set(dayOfMonth, monthOfYear, year);
                anc8_Date.setText(dateFormatterShow.format(anc8_Date_Calender.getTime()));
                anc8_Date_String = dateFormatterShow.format(anc8_Date_Calender.getTime());
                callDateDiff8();
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }

    public void getPatientData(int pId) {
        String url = ApplicationController.get_base_url() + "api/patient/" + pId ;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("patient data retirval", response.toString());
                        try {
                            Log.i("dayaa", String.valueOf(response.getString("device")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                                if(String.valueOf(response.getString("device")) != "null") {
                                    JSONObject device = (JSONObject) response.get("device");
                                    to_fcm = device.getString("device_id");
                                }
                            } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
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
//                        pb.setVisibility(View.GONE);
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date = new Date();

                        String notfMessage = "Date : " + dateFormat.format(date) + " \n";

                        if( anc1_advice_GTT.isChecked()){
                            notfMessage += anc1_advice_GTT.getText() + " ,\n";
                        }

                        if( anc1_advice_BloodSugar.isChecked()){
                            notfMessage += anc1_advice_BloodSugar.getText() + " ,\n";
                        }

                        if( anc1_advice_NtNbScan.isChecked()){
                            notfMessage += anc1_advice_NtNbScan.getText() + " ,\n";
                        }

                        if( anc1_advice_DualScreen.isChecked()){
                            notfMessage += anc1_advice_DualScreen.getText() + " ,\n";
                        }

//                        if( anc1_advice_LeftUterineArteryPl.isChecked()){
//                            notfMessage += anc1_advice_LeftUterineArteryPl.getText() + " ,\n";
//                        }

                        if (anc1_advice_TfolateLessThan14Weeks.isChecked()){
                            notfMessage += anc1_advice_TfolateLessThan14Weeks.getText() + " ,\n";
                        }

                        if (anc1_advice_TFeMoreThan14Weeks.isChecked()){
                            notfMessage += anc1_advice_TFeMoreThan14Weeks.getText() + " ,\n";
                        }

//                        if( anc1_advice_RightUterineArteryPl.isChecked()){
//                            notfMessage += anc1_advice_RightUterineArteryPl.getText() + " ,\n";
//                        }
//
//                        if( anc1_advice_PIGF.isChecked()){
//                            notfMessage += anc1_advice_PIGF.getText() + " ,\n";
//                        }

                        if( anc1_advice_ICT.isChecked()){
                            notfMessage += anc1_advice_ICT.getText() + " ,\n";
                        }

                        if( anc1_advice_Level2USG.isChecked()){
                            notfMessage += anc1_advice_Level2USG.getText() + " ,\n";
                        }

                        if (anc2_advice_OGTT.isChecked()){
                            notfMessage += anc2_advice_OGTT.getText() + " ,\n";
                        }

                        if (anc2_advice_TfeOD.isChecked()){
                            notfMessage += anc2_advice_TfeOD.getText() + " ,\n";
                        }

                        if (anc2_advice_TcaBD.isChecked()){
                            notfMessage += anc2_advice_TcaBD.getText() + " ,\n";
                        }

                        if (anc2_advice_Tetanus.isChecked()){
                            notfMessage += anc2_advice_Tetanus.getText() + " ,\n";
                        }

                        if (anc2_advice_QuadrupleScreen.isChecked()){
                            notfMessage += anc2_advice_QuadrupleScreen.getText() + " ,\n";
                        }

                        if (anc2_advice_FetalEcho.isChecked()){
                            notfMessage += anc2_advice_FetalEcho.getText() + " ,\n";
                        }

                        if (anc2_advice_HbLess10_TAlbendazole.isChecked()){
                            notfMessage += anc2_advice_HbLess10_TAlbendazole.getText() + " ,\n";
                        }

                        if (anc2_advice_HbLess10_TFeBD.isChecked()){
                            notfMessage += anc2_advice_HbLess10_TFeBD.getText() + " ,\n";
                        }

                        if (anc2_advice_HbLess10_Hplc.isChecked()){
                            notfMessage += anc2_advice_HbLess10_Hplc.getText() + " ,\n";
                        }

                        if (anc2_advice_HbLess10_PeripheralSmear.isChecked()){
                            notfMessage += anc2_advice_HbLess10_PeripheralSmear.getText() + " ,\n";
                        }

                        if (anc2_advice_HbLess10_SerumIron.isChecked()){
                            notfMessage += anc2_advice_HbLess10_SerumIron.getText() + " ,\n";
                        }

                        if (anc3_advice_TFeOD.isChecked()){
                            notfMessage += anc3_advice_TFeOD.getText() + " ,\n";
                        }

                        if (anc3_advice_DFMCLLP.isChecked()){
                            notfMessage += anc3_advice_DFMCLLP.getText() + " ,\n";
                        }

                        if (anc3_advice_InjTetanus.isChecked()){
                            notfMessage += anc3_advice_InjTetanus.getText() + " ,\n";
                        }

                        if (anc3_advice_CBC.isChecked()){
                            notfMessage += anc3_advice_CBC.getText() + " ,\n";
                        }

                        if (anc3_advice_LFT.isChecked()){
                            notfMessage += anc3_advice_LFT.getText() + " ,\n";
                        }

                        if (anc3_advice_KFT.isChecked()){
                            notfMessage += anc3_advice_KFT.getText() + " ,\n";
                        }

                        if (anc3_advice_GTT.isChecked()){
                            notfMessage += anc3_advice_GTT.getText() + " ,\n";
                        }

                        if (anc3_advice_ictNegative_InjAntiD300.isChecked()){
                            notfMessage += anc3_advice_ictNegative_InjAntiD300.getText() + " ,\n";
                        }

                        if (anc4_advice_TFeOD.isChecked()){
                            notfMessage += anc4_advice_TFeOD.getText() + " ,\n";
                        }

                        if (anc4_advice_TCaBD.isChecked()){
                            notfMessage += anc4_advice_TCaBD.getText() + " ,\n";
                        }

                        if (anc4_advice_DFMC.isChecked()){
                            notfMessage += anc4_advice_DFMC.getText() + " ,\n";
                        }

                        if (anc4_advice_USG.isChecked()){
                            notfMessage += anc4_advice_USG.getText() + " ,\n";
                        }

                        if (anc5_advice_DFMCLLP.isChecked()){
                            notfMessage += anc5_advice_DFMCLLP.getText() + " ,\n";
                        }

                        if (anc5_advice_TFeCa.isChecked()){
                            notfMessage += anc5_advice_TFeCa.getText() + " ,\n";
                        }

                        if (anc5_advice_NST.isChecked()){
                            notfMessage += anc5_advice_NST.getText() + " ,\n";
                        }

                        if(     anc1_advice_GeneralNutritional.isChecked() ||
                                anc2_advice_GeneralNutritional.isChecked() ||
                                anc3_advice_GeneralNutritional.isChecked() ||
                                anc4_advice_GeneralNutritional.isChecked() ||
                                anc5_advice_GeneralNutritional.isChecked() ||
                                anc6_advice_GeneralNutritional.isChecked() ||
                                anc7_advice_GeneralNutritional.isChecked() ||
                                anc8_advice_GeneralNutritional.isChecked()) {
                            notfMessage += "Have a balanced diet.\n" +
                                    "Ensure adequate hydration and have 6-8 glasses of water daily.\n" +
                                    "Ensure a daily diet with adequate protein, dairy products, fruit.\n" +
                                    "Have folate rich foods like green leafy vegetables, legumes, beans.\n" +
                                    "Have Vitamin C rich food daily.\n" +
                                    "Have a High fibre diet.\n" +
                                    "Take small, frequent meals.\n" +
                                    "Avoid smoking/alcohol.\n";

                            notfMessage += "Take iron and calcium supplements daily as prescribed.\n" +
                                    "Iron should not be taken empty stomach.\n" +
                                    "A gap of 2 hours should be kept between the ion and calcium tablets.\n" +
                                    "Aim for daily moderate intensity activity for 30 minutes.\n" +
                                    "Avoid lifting heavy weight.\n";
                        }

                        if(     anc1_advice_NauseaVomiting.isChecked() ||
                                anc2_advice_NauseaVomiting.isChecked() ||
                                anc3_advice_NauseaVomiting.isChecked() ||
                                anc4_advice_NauseaVomiting.isChecked() ||
                                anc5_advice_NauseaVomiting.isChecked() ||
                                anc6_advice_NauseaVomiting.isChecked() ||
                                anc7_advice_NauseaVomiting.isChecked() ||
                                anc8_advice_NauseaVomiting.isChecked()) {
                            notfMessage += "Drink plenty of fluids and maintain hydration.\n" +
                                    "Eat small frequent meals.\n" +
                                    "Have non greasy meals with little odor.\n" +
                                    "Ginger or chamomile tea can help reduce morning sickness.\n" +
                                    "If excessive, vitamin b6 supplements can be tried.\n";
                        }

                        if(     anc1_advice_HeatBurn.isChecked() ||
                                anc2_advice_HeatBurn.isChecked() ||
                                anc3_advice_HeatBurn.isChecked() ||
                                anc4_advice_HeatBurn.isChecked() ||
                                anc5_advice_HeatBurn.isChecked() ||
                                anc6_advice_HeatBurn.isChecked() ||
                                anc7_advice_HeatBurn.isChecked() ||
                                anc8_advice_HeatBurn.isChecked()){
                            notfMessage += "Eat small, frequent meals.\n" +
                                    "Avoid spicy, greasy foods.\n" +
                                    "Elevate head of bed when lying down.\n" +
                                    "Avoid lying down immediately after taking a meal.\n";
                        }

                        if(     anc1_advice_Constipation.isChecked() ||
                                anc2_advice_Constipation.isChecked() ||
                                anc3_advice_Constipation.isChecked() ||
                                anc4_advice_Constipation.isChecked() ||
                                anc5_advice_Constipation.isChecked() ||
                                anc6_advice_Constipation.isChecked() ||
                                anc7_advice_Constipation.isChecked() ||
                                anc8_advice_Constipation.isChecked()
                        ){
                            notfMessage += "Eat fresh fruits and vegetables.\n" +
                                    "Drink 8-10 glasses of water.\n" +
                                    "Eat foods with high fibre.\n";
                        }

                        if(     anc1_advice_PedalEdema.isChecked() ||
                                anc2_advice_PedalEdema.isChecked() ||
                                anc3_advice_PedalEdema.isChecked() ||
                                anc4_advice_PedalEdema.isChecked() ||
                                anc5_advice_PedalEdema.isChecked() ||
                                anc6_advice_PedalEdema.isChecked() ||
                                anc7_advice_PedalEdema.isChecked() ||
                                anc8_advice_PedalEdema.isChecked()
                        ){
                            notfMessage += "Rest with legs elevated.\n" +
                                    "Lie in the left lateral position.\n" +
                                    "Avoid sitting or standing for long periods.\n";
                        }

                        if(     anc1_advice_LegCramps.isChecked() ||
                                anc2_advice_LegCramps.isChecked() ||
                                anc3_advice_LegCramps.isChecked() ||
                                anc4_advice_LegCramps.isChecked() ||
                                anc5_advice_LegCramps.isChecked() ||
                                anc6_advice_LegCramps.isChecked() ||
                                anc7_advice_LegCramps.isChecked() ||
                                anc8_advice_LegCramps.isChecked()
                        ){
                            notfMessage += "Daily magnesium/calcium supplements can be used.\n";
                        }

                    notifGeneration(notfMessage);

                        Intent intent = new Intent(patient_data_entry_bydoc.this, AllPatientListActivity.class);
                        startActivity(intent);
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

                    params.put("investigations_ChronicHyper", "" + investigations_ChronicHyper.isChecked());
                    params.put("investigations_Type2", "" + investigations_Type2.isChecked());
                    params.put("investigations_ChronicLiverDisease", "" + investigations_ChronicLiverDisease.isChecked());
                    params.put("investigations_ChronicKidneyDisease", "" + investigations_ChronicKidneyDisease.isChecked());
                    params.put("investigations_ALPA", "" + investigations_ALPA.isChecked());
                    params.put("investigations_SLE", "" + investigations_SLE.isChecked());
                    params.put("investigations_heatDisease_RHD", "" + investigations_heatDisease_RHD.isChecked());
                    params.put("investigations_heatDisease_RHDpost", "" + investigations_heatDisease_RHDpost.isChecked());
                    params.put("investigations_heatDisease_Acyanotic", "" + investigations_heatDisease_Acyanotic.isChecked());
                    params.put("investigations_heatDisease_Cyanotic", "" + investigations_heatDisease_Cyanotic.isChecked());
                    params.put("investigations_Others", "" + investigations_Others.getText());
                    params.put("investigations_DrugHistory", "" + investigations_DrugHistory.getText());

                    params.put("anc3_advice_review", "" + anc3_advice_review.isChecked());
                    params.put("anc4_advice_review", "" + anc4_advice_review.isChecked());
                    params.put("anc5_advice_review", "" + anc5_advice_review.isChecked());
                    params.put("anc6_advice_review", "" + anc6_advice_review.isChecked());
                    params.put("anc7_advice_review", "" + anc7_advice_review.isChecked());

                    params.put("anc1_Date", "" + anc1_Date.getText());
                    params.put("anc1_POG", "" + anc1_POG.getText());
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

                    params.put("anc1_investigations_ntnb_CRL", "" + anc1_investigations_ntnb_CRL.getText());
                    params.put("anc1_investigations_ntnb_NT", "" + anc1_investigations_ntnb_NT.getText());
                    params.put("anc1_investigations_ntnb_Centile", "" + anc1_investigations_ntnb_Centile.getText());
                    params.put("anc1_investigations_ntnb_Text", "" + anc1_investigations_ntnb_Text.getText());

                    params.put("anc1_investigations_dualScreen_PAPP", "" + anc1_investigations_dualScreen_PAPP.getText());
                    params.put("anc1_investigations_dualScreen_Bhcg", "" + anc1_investigations_dualScreen_Bhcg.getText());
                    params.put("anc1_investigations_level2Usg_DoneNotDone", "" + anc1_investigations_level2Usg_DoneNotDone.getText());
                    params.put("anc1_investigations_level2Usg_NormalAbnormal", "" + anc1_investigations_level2Usg_NormalAbnormal.getText());
                    params.put("anc1_advice_GTT", "" + anc1_advice_GTT.isChecked());
                    params.put("anc1_advice_BloodSugar", "" + anc1_advice_BloodSugar.isChecked());
                    params.put("anc1_advice_NtNbScan", "" + anc1_advice_NtNbScan.isChecked());
                    params.put("anc1_advice_DualScreen", "" + anc1_advice_DualScreen.isChecked());
                    params.put("anc1_advice_LeftUterineArteryPl", "" + anc1_advice_LeftUterineArteryPl.getText());
                    params.put("anc1_advice_RightUterineArteryPl", "" + anc1_advice_RightUterineArteryPl.getText());
                    params.put("anc1_advice_PIGF", "" + anc1_advice_PIGF.getText());
                    params.put("anc1_advice_ICT", "" + anc1_advice_ICT.isChecked());
                    params.put("anc1_advice_Level2USG", "" + anc1_advice_Level2USG.isChecked());
                    params.put("anc1_advice_GeneralNutritional", "" + anc1_advice_GeneralNutritional.isChecked());
                    params.put("anc1_advice_NauseaVomiting", "" + anc1_advice_NauseaVomiting.isChecked());
                    params.put("anc1_advice_HeatBurn", "" + anc1_advice_HeatBurn.isChecked());
                    params.put("anc1_advice_Constipation", "" + anc1_advice_Constipation.isChecked());
                    params.put("anc1_advice_PedalEdema", "" + anc1_advice_PedalEdema.isChecked());
                    params.put("anc1_advice_LegCramps", "" + anc1_advice_LegCramps.isChecked());
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
                    params.put("anc1_advice_TfolateLessThan14Weeks", "" + anc1_advice_TfolateLessThan14Weeks.isChecked());
                    params.put("anc1_advice_TFeMoreThan14Weeks", "" + anc1_advice_TFeMoreThan14Weeks.isChecked());
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
                    params.put("anc2_advice_GeneralNutritional", "" + anc2_advice_GeneralNutritional.isChecked());
                    params.put("anc2_advice_NauseaVomiting", "" + anc2_advice_NauseaVomiting.isChecked());
                    params.put("anc2_advice_HeatBurn", "" + anc2_advice_HeatBurn.isChecked());
                    params.put("anc2_advice_Constipation", "" + anc2_advice_Constipation.isChecked());
                    params.put("anc2_advice_PedalEdema", "" + anc2_advice_PedalEdema.isChecked());
                    params.put("anc2_advice_LegCramps", "" + anc2_advice_LegCramps.isChecked());
                    params.put("anc2_advice_Others", "" + anc2_advice_Others.getText());


                    params.put("anc3_Date", "" + anc3_Date.getText());
                    params.put("anc3_POG", "" + anc3_POG.getText());
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
                    params.put("anc3_examination_FetalEcho", "" + anc3_examination_FetalEcho.getText());
                    params.put("anc3_examination_Others", "" + anc3_examination_Others.getText());
                    params.put("anc3_investigations_UrineCS", "" + anc3_investigations_UrineCS.isChecked());
                    params.put("anc3_investigations_ICT", "" + anc3_investigations_ICT.isChecked());
                    params.put("anc3_investigations_Others", "" + anc3_investigations_Others.getText());
                    params.put("anc3_advice_TFeOD", "" + anc3_advice_TFeOD.isChecked());
                    params.put("anc3_advice_DFMCLLP", "" + anc3_advice_DFMCLLP.isChecked());
                    params.put("anc3_advice_InjTetanus", "" + anc3_advice_InjTetanus.isChecked());
                    params.put("anc3_advice_CBC", "" + anc3_advice_CBC.isChecked());
                    params.put("anc3_advice_LFT", "" + anc3_advice_LFT.isChecked());
                    params.put("anc3_advice_KFT", "" + anc3_advice_KFT.isChecked());
                    params.put("anc3_advice_GTT", "" + anc3_advice_GTT.isChecked());
                    params.put("anc3_advice_ictNegative_InjAntiD300", "" + anc3_advice_ictNegative_InjAntiD300.isChecked());
                    params.put("anc3_advice_GeneralNutritional", "" + anc3_advice_GeneralNutritional.isChecked());
                    params.put("anc3_advice_NauseaVomiting", "" + anc3_advice_NauseaVomiting.isChecked());
                    params.put("anc3_advice_HeatBurn", "" + anc3_advice_HeatBurn.isChecked());
                    params.put("anc3_advice_Constipation", "" + anc3_advice_Constipation.isChecked());
                    params.put("anc3_advice_PedalEdema", "" + anc3_advice_PedalEdema.isChecked());
                    params.put("anc3_advice_LegCramps", "" + anc3_advice_LegCramps.isChecked());

                    params.put("anc4_Date", "" + anc4_Date.getText());
                    params.put("anc4_POG", "" + anc4_POG.getText());
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
                    params.put("anc4_advice_GeneralNutritional", "" + anc4_advice_GeneralNutritional.isChecked());
                    params.put("anc4_advice_NauseaVomiting", "" + anc4_advice_NauseaVomiting.isChecked());
                    params.put("anc4_advice_HeatBurn", "" + anc4_advice_HeatBurn.isChecked());
                    params.put("anc4_advice_Constipation", "" + anc4_advice_Constipation.isChecked());
                    params.put("anc4_advice_PedalEdema", "" + anc4_advice_PedalEdema.isChecked());
                    params.put("anc4_advice_LegCramps", "" + anc4_advice_LegCramps.isChecked());
                    params.put("anc4_advice_Others", "" + anc4_advice_Others.getText());

                    params.put("anc5_Date", "" + anc5_Date.getText());
                    params.put("anc5_POG", "" + anc5_POG.getText());
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
                    params.put("anc5_investigation_CBC", "" + anc5_investigation_CBC.getText());
                    params.put("anc5_investigation_LFT", "" + anc5_investigation_LFT.getText());
                    params.put("anc5_investigation_KFT", "" + anc5_investigation_KFT.getText());
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
                    params.put("anc5_advice_GeneralNutritional", "" + anc5_advice_GeneralNutritional.isChecked());
                    params.put("anc5_advice_NauseaVomiting", "" + anc5_advice_NauseaVomiting.isChecked());
                    params.put("anc5_advice_HeatBurn", "" + anc5_advice_HeatBurn.isChecked());
                    params.put("anc5_advice_Constipation", "" + anc5_advice_Constipation.isChecked());
                    params.put("anc5_advice_PedalEdema", "" + anc5_advice_PedalEdema.isChecked());
                    params.put("anc5_advice_LegCramps", "" + anc5_advice_LegCramps.isChecked());
                    params.put("anc5_advice_Others", "" + anc5_advice_Others.getText());

                    params.put("anc6_Date", "" + anc6_Date.getText());
                    params.put("anc6_POG", "" + anc6_POG.getText());
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
                    params.put("anc6_advice_GeneralNutritional", "" + anc6_advice_GeneralNutritional.isChecked());
                    params.put("anc6_advice_NauseaVomiting", "" + anc6_advice_NauseaVomiting.isChecked());
                    params.put("anc6_advice_HeatBurn", "" + anc6_advice_HeatBurn.isChecked());
                    params.put("anc6_advice_Constipation", "" + anc6_advice_Constipation.isChecked());
                    params.put("anc6_advice_PedalEdema", "" + anc6_advice_PedalEdema.isChecked());
                    params.put("anc6_advice_LegCramps", "" + anc6_advice_LegCramps.isChecked());
                    params.put("anc6_history_Others", "" + anc6_history_Others.getText());
                    params.put("anc6_examination_PR", "" + anc6_examination_PR.getText());
                    params.put("anc6_examination_BP", "" + anc6_examination_BP.getText());
                    params.put("anc6_examination_Weight", "" + anc6_examination_Weight.getText());
                    params.put("anc6_examination_PA2Weeks", "" + anc6_examination_PA2Weeks.getText());
                    params.put("anc6_examination_Others", "" + anc6_examination_Others.getText());
                    params.put("anc6_Pelvic", "" + anc6_Pelvic.getText());
                    params.put("anc6_advice_Others", "" + anc6_advice_Others.getText());

                    params.put("anc7_Date", "" + anc7_Date.getText());
                    params.put("anc7_POG", "" + anc7_POG.getText());
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
                    params.put("anc7_advice_GeneralNutritional", "" + anc7_advice_GeneralNutritional.isChecked());
                    params.put("anc7_advice_NauseaVomiting", "" + anc7_advice_NauseaVomiting.isChecked());
                    params.put("anc7_advice_HeatBurn", "" + anc7_advice_HeatBurn.isChecked());
                    params.put("anc7_advice_Constipation", "" + anc7_advice_Constipation.isChecked());
                    params.put("anc7_advice_PedalEdema", "" + anc7_advice_PedalEdema.isChecked());
                    params.put("anc7_advice_LegCramps", "" + anc7_advice_LegCramps.isChecked());
                    params.put("anc7_history_Others", "" + anc7_history_Others.getText());
                    params.put("anc7_examination_PR", "" + anc7_examination_PR.getText());
                    params.put("anc7_examination_BP", "" + anc7_examination_BP.getText());
                    params.put("anc7_examination_Weight", "" + anc7_examination_Weight.getText());
                    params.put("anc7_examination_Pa2Weeks", "" + anc7_examination_Pa2Weeks.getText());
                    params.put("anc7_examination_Others", "" + anc7_examination_Others.getText());
                    params.put("anc7_advice_Others", "" + anc7_advice_Others.getText());

                    params.put("anc8_Date", "" + anc8_Date.getText());
                    params.put("anc8_POG", "" + anc8_POG.getText());
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
                    params.put("anc8_advice_GeneralNutritional", "" + anc8_advice_GeneralNutritional.isChecked());
                    params.put("anc8_advice_NauseaVomiting", "" + anc8_advice_NauseaVomiting.isChecked());
                    params.put("anc8_advice_HeatBurn", "" + anc8_advice_HeatBurn.isChecked());
                    params.put("anc8_advice_Constipation", "" + anc8_advice_Constipation.isChecked());
                    params.put("anc8_advice_PedalEdema", "" + anc8_advice_PedalEdema.isChecked());
                    params.put("anc8_advice_LegCramps", "" + anc8_advice_LegCramps.isChecked());
                    params.put("anc8_history_Others", "" + anc8_history_Others.getText());
                    params.put("anc8_examination_PR", "" + anc8_examination_PR.getText());
                    params.put("anc8_examination_BP", "" + anc8_examination_BP.getText());
                    params.put("anc8_examination_Weight", "" + anc8_examination_Weight.getText());
                    params.put("anc8_examination_Others", "" + anc8_examination_Others.getText());
                    params.put("anc8_advice_Others", "" + anc8_advice_Others.getText());

                    params.put("anc_1", "" + anc_1.isChecked());
                    params.put("anc_2", "" + anc_2.isChecked());
                    params.put("anc_3", "" + anc_3.isChecked());
                    params.put("anc_4", "" + anc_4.isChecked());
                    params.put("anc_5", "" + anc_5.isChecked());
                    params.put("anc_6", "" + anc_6.isChecked());
                    params.put("anc_7", "" + anc_7.isChecked());
                    params.put("anc_8", "" + anc_8.isChecked());
                    params.put("investigations_box", "" + investigations_box.isChecked());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.v("Objectt", "getBody: " + params.toString());
                return params.toString().getBytes();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                params.put("Authorization", "Token " + session.getUserDetails().get("Token"));
                return params;
            }
        };
        ApplicationController.getInstance().addToRequestQueue(jsonObjReq);
    }

    public void notifGeneration(String notfMessage) {
        String url = ApplicationController.get_base_url() + "sg/api/notification";
        final String finalNotfMessage = notfMessage;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
//                        Log.d("TAG", response.toString());

//
                        try {
                            JSONArray patient_details = response.getJSONArray("data");
                            Log.d("TAG", patient_details.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
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
            public byte[] getBody() {
                JSONObject params = new JSONObject();

                try {
                    params.put("p_id", p_id);
                    params.put("message", "" + finalNotfMessage);
                    params.put("to", "" + to_fcm);
                    params.put("from", "" + "me");
                    params.put("docId", "" + session.getUserDetails().get("id"));
                    Log.d("NOTIFICATIONNNNNN", "dATA: " + params);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return params.toString().getBytes();

            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                params.put("Authorization", "Token " + session.getUserDetails().get("Token"));;
                return params;
            }
        };
        ApplicationController.getInstance().addToRequestQueue(jsonObjReq);
    }
}