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
    CheckBox investigationsBox, invest_chronic_hyper, invest_type_2_diabetes, invest_RHD_native, invest_RHD_post, invest_acyanotic, invest_cyanotic, invest_chronic_liver, invest_chronic_kidney, invest_APLA, invest_SLE;
    CheckBox anc_1, anc1_his_fever, anc1_his_rash, anc1_his_nausea_vomit, anc1_his_bleed, anc1_his_abdpain, anc1_drugin, anc1_his_smoke, anc1_his_alcohol, anc1_his_tob, anc1_his_caff, anc1_his_int, anc1_exam_pallor, anc1_exam_lcterus, anc1_exam_clubbing, anc1_exam_cyanosis, anc1_exam_edem, anc1_exam_lymp, anc1_invest_HIV, anc1_invest_hbsag, anc1_invest_VDRL, anc1_invest_urineRM, anc1_invest_urineCS, anc1_invest_CRL, anc1_invest_NT, anc1_invest_centile, anc1_invest_text, anc1_advice_Tfolate, anc1_advice_TFe, anc1_general_TSH, anc1_general_T_nitro, anc1_general_syp, anc1_general_Tvit, anc1_general_plenty;
    CheckBox anc_2, anc2_his_breath, anc2_his_fatigue, anc2_his_head, anc2_his_bleed, anc2_his_burn, anc2_his_quick_percieve, anc2_exam_pallor, anc2_exam_pedal, anc2_invest_quad, anc2_invest_fetal, anc2_advice_OGTT, anc2_advice_TFe, anc2_advice_TCa, anc2_advice_Hb_Talb, anc2_advice_Hb_TFe, anc2_advice_Hb_HPLC, anc2_advice_Hb_peri, anc2_advice_Hb_serum, anc2_advice_tetanus;
    CheckBox anc_3, anc3_his_breath, anc3_his_fatigue, anc3_his_head, anc3_his_bleed, anc3_his_leak, anc3_his_burn, anc3_his_fetal_move, anc3_his_itching, anc3_exam_pallor, anc3_exam_pedal, anc3_invest_GTT_fast, anc3_invest_GTT_1hr, anc3_invest_GTT_2hr, anc3_invest_CBC, anc3_invest_urine, anc3_invest_ICT, anc3_advice_TFe, anc3_advice_DFMC, anc3_advice_BleedPV, anc3_advice_spotPV, anc3_advice_leakPV, anc3_advice_fetalmove, anc3_advice_abdpain, anc3_advice_injAntiD;
    CheckBox anc_4, anc4_his_breath, anc4_his_fatigue, anc4_his_head, anc4_his_bleed, anc4_his_burn, anc4_his_fetal_move, anc4_his_itching, anc4_exam_pallor, anc4_exam_pedal, anc4_advice_TFe, anc4_advice_TCa, anc4_advice_DFMC, anc4_advice_BleedPV, anc4_advice_spotPV, anc4_advice_leakPV, anc4_advice_fetalmove, anc4_advice_abdpain, anc4_advice_USG;
    CheckBox anc_5, anc5_his_breath, anc5_his_fatigue, anc5_his_head, anc5_his_bleed, anc5_his_burn, anc5_his_fetal_move, anc5_his_itching, anc5_his_vaginal_del, anc5_his_LSCS_del, anc5_his_birth_attendant, anc5_exam_pallor, anc5_exam_pedal, anc5_invest_CBC, anc5_invest_LFT, anc5_invest_KFT, anc5_invest_CPR, anc5_advice_DFMC, anc5_advice_TFe_Ca, anc5_advice_BleedPV, anc5_advice_spotPV, anc5_advice_leakPV, anc5_advice_fetalmove, anc5_advice_abdpain, anc5_advice_NST;
    CheckBox anc_6, anc6_his_breath, anc6_his_fatigue, anc6_his_head, anc6_his_bleed, anc6_his_burn, anc6_his_fetal_move, anc6_his_itching, anc6_exam_pallor, anc6_exam_pedal, anc6_advice_DFMC, anc6_advice_TFe_Ca, anc6_advice_BleedPV, anc6_advice_spotPV, anc6_advice_leakPV, anc6_advice_fetalmove, anc6_advice_abdpain, anc6_advice_NST;
    CheckBox anc_7, anc7_his_breath, anc7_his_fatigue, anc7_his_head, anc7_his_bleed, anc7_his_burn, anc7_his_fetal_move, anc7_his_itching, anc7_exam_pallor, anc7_exam_pedal, anc7_advice_DFMC, anc7_advice_TFe_Ca, anc7_advice_BleedPV, anc7_advice_spotPV, anc7_advice_leakPV, anc7_advice_fetalmove, anc7_advice_abdpain;
    CheckBox anc_8, anc8_his_breath, anc8_his_fatigue, anc8_his_head, anc8_his_bleed, anc8_his_burn, anc8_his_fetal_move, anc8_his_itching, anc8_exam_pallor, anc8_exam_pedal, anc8_exam_pa, anc8_advice_DFMC, anc8_advice_Fe_Ca, anc8_advice_induction;
    EditText invest_others, invest_drug_history, anc_1_date, anc_1_POG, anc_1_GeneralDeranged_fasting, anc_1_GeneralDeranged_breakfast, anc_1_GeneralDeranged_lunch, anc_1_GeneralDeranged_dinner, anc1_his_others, anc1_exam_height, anc1_exam_weight, anc1_exam_BMI, anc1_exam_PR, anc1_exam_BP, anc1_exam_RR, anc1_exam_temp, anc1_exam_proteinuria, anc1_exam_chest, anc1_exam_PA, anc1_exam_others, anc1_invest_bg, anc1_invest_husband_bg, anc1_invest_hemo, anc1_invest_bloodsugar_fast, anc1_invest_bloodsugar_post, anc1_invest_GTT_fast, anc1_invest_GTT_1hr, anc1_invest_GTT_2hr, anc1_invest_TSH, anc1_invest_NT_done, anc1_invest_PAPP, anc1_invest_b_hcg, anc1_invest_levelII_done, anc1_invest_normal, anc1_invest_others, anc1_general_nutritional, anc1_general_ailment, anc1_general_ICT, anc1_general_others;
    EditText anc2_POG, anc_2_pa_2weeks, anc2_his_others, anc2_exam_PR, anc2_exam_BP, anc2_exam_weight, anc2_exam_others, anc2_invest_others, anc2_advice_nutri, anc2_advice_general, anc2_advice_common, anc2_advice_others;
    EditText anc3_his_others, anc3_investigation_others, anc_3_pa_2weeks, anc3_exam_PR, anc3_exam_BP, anc3_exam_weight, anc3_exam_others, anc3_advice_nutri, anc3_advice_general, anc3_advice_common, anc3_advice_others;
    EditText anc4_his_others, anc_4_pa_2weeks, anc4_exam_PR, anc4_exam_BP, anc4_exam_weight, anc4_exam_others, anc4_advice_nutri, anc4_advice_general, anc4_advice_common, anc4_advice_others;
    EditText anc5_his_others, anc5_pa_2weeks, anc5_his_timing, anc5_exam_PR, anc5_exam_BP, anc5_exam_weight, anc5_exam_others, anc5_invest_others, anc5_USG_BPD_cm, anc5_USG_BPD_weeks, anc5_USG_BPD_centile, anc5_USG_HC_cm, anc5_USG_HC_weeks, anc5_USG_HC_centile, anc5_USG_AC_cm, anc5_USG_AC_weeks, anc5_USG_AC_centile, anc5_USG_FL_cm, anc5_USG_FL_weeks, anc5_USG_FL_centile, anc5_USG_EFW_gm, anc5_USG_EFW_weeks, anc5_USG_EFW_centile, anc5_USG_liquor_SLP, anc5_USG_liquor_AFI, anc5_USG_UAPI, anc5_USG_UAPI_centile, anc5_USG_MCAPI, anc5_USG_MCAPI_centile, anc5_advice_nutri, anc5_advice_general, anc5_advice_common, anc5_advice_others;
    EditText anc6_his_others, anc6_pa_2weeks, anc6_exam_PR, anc6_exam_BP, anc6_exam_weight, anc6_exam_others, anc6_exam_pelvic, anc6_advice_others;
    EditText anc7_his_others, anc7_pa_2weeks, anc7_exam_PR, anc7_exam_BP, anc7_exam_weight, anc7_exam_others, anc7_advice_others;
    EditText anc8_his_others, anc8_exam_PR, anc8_exam_BP, anc8_exam_weight, anc8_exam_others, anc8_advice_others;
    TextView anc_1_GeneralDeranged_bs, anc_1_GeneralDeranged_fastingBox,anc_1_GeneralDeranged_breakfastBox, anc_1_GeneralDeranged_lunchBox, anc_1_GeneralDeranged_dinnerBox, anc1_date_box, anc_1_POG_box, anc1_history, anc1_his_others_box, anc1_examination, anc1_exam_height_box, anc1_exam_weight_box, anc1_exam_BMI_box, anc1_exam_PR_box, anc1_exam_BP_box, anc1_exam_RR_box, anc1_exam_temp_box, anc1_exam_proteinuria_box, anc1_exam_chest_box, anc1_exam_PA_box, anc1_exam_others_box, anc1_invest_bg_box, anc1_invest_husband_bg_box, anc1_invest_hemo_box, anc1_invest_TSH_box, anc1_invest_NT_done_box, anc1_invest_PAPP_box, anc1_invest_b_hcg_box, anc1_invest_levelII_done_box, anc1_invest_normal_box, anc1_invest_others_box, anc1_general_nutritional_box, anc1_general_ailment_box, anc1_general_ICT_box, anc1_general_others_box, anc1_anthropometry, anc1_investigations, anc1_invest_GTT, anc1_invest_levelII_USG, anc1_advice, anc1_adviceGeneral, anc1_general_Urine, anc1_general_Deranged, anc1_vitals, anc1_invest_bloodsugar, anc1_examinationGen, anc1_NTscan, anc1_investDual;
    TextView anc2_exam_pa, anc_2_POG_box, anc2_his_othersBox, anc_2_exam_PRBox, anc2_exam_BPBox, anc2_exam_weightBox, anc2_exam_othersBox, anc_2_invest_othersBox, anc2_advice_nutriBox, anc2_advice_generalBox, anc2_advice_commonBox, anc2_advice_othersBox, anc_2_history, anc_2_examination, anc2_investigationBox, anc_2_adviceBox, anc2_common_ailment_ifHbBox, anc3_historyBox, Anc_3_examinationBox, anc_3_investigationsBox, anc_3_GTTBox, anc_3_adviceBox, anc_3_inj_antiDBox;
    TextView anc3_his_othersBox, anc3_investigation_othersbox, anc3_exam_pa, anc3_exam_PRBox, anc3_exam_BPBox, anc3_exam_weightBox, anc3_exam_othersBox, anc3_advice_nutriBox, anc3_advice_generalBox, anc3_advice_commonBox, anc3_advice_othersBox, anc_3_reviewBox;
    TextView anc4_his_othersBox, anc4_exam_pa, anc4_exam_PRBox, anc4_exam_BPBox, anc4_exam_weightBox, anc4_exam_othersBox, anc4_advice_nutriBox, anc4_advice_generalBox, anc4_advice_commonBox, anc4_advice_othersBox, anc_4_historyBox, ANC_4_examinationBox, anc_4_adviceBox, anc_4_reviewBox;
    TextView anc5_his_othersBox, anc5_exam_pa, anc5_his_timingBox, anc5_exam_PRBox, anc5_exam_BPBox, anc5_exam_weightBox, anc5_exam_othersBox, anc5_invest_othersBox, anc5_USG_BPDBox, anc5_USG_HCBox, anc5_USG_ACBox, anc5_USG_FLBox, anc5_USG_EFWBox, anc5_USG_liquorBox, anc5_USG_UAPIBox, anc5_USG_MCAPIBox, anc5_advice_nutriBox, anc5_advice_generalBox, anc5_advice_commonBox, anc_5_reviewBox, anc5_advice_othersBox, anc5_historyBox, anc5_counsellingBox, anc5_modeOfDeliveryBox, anc5_examinationBox, anc5_investigationBox, anc5_USGBox, anc_5_adviceBox;
    TextView anc6_his_othersBox, anc6_exam_pa, anc6_exam_PRBox, anc6_exam_BPBox, anc6_exam_weightBox, anc6_exam_othersBox, anc6_exam_pelvicBox, anc6_advice_othersBox, anc_6_historyBox, anc_6_examinationBox, anc_6_adviceBox, anc_6_reviewBox;
    TextView anc7_his_othersBox, anc7_exam_pa, anc7_exam_PRBox, anc7_exam_BPBox, anc7_exam_weightBox, anc7_exam_othersBox, anc7_advice_othersBox, anc_7_historyBox, anc_7_examinationBox, anc_7_adviceBox, anc_7_reviewBox;
    TextView anc8_his_othersBox, anc8_exam_PRBox, anc8_exam_BPBox, anc8_exam_weightBox, anc8_exam_othersBox, anc8_advice_othersBox, anc_8_historyBox, anc_8_adviceBox, anc_8_examinationBox;
    TextView invest_othersBox, invest_drug_historyBox, Co_MorbiditiesBox, Heart_DiseaseBox;
    CardView anc1_his_linearBox, anc1_exam_linearBox, anc1_general_linear, invest_heart_linearBox, anc1_invest_linearBox, anc1_advice_linearBox, anc2_his_linearBox, anc2_exam_linearBox, anc2_invest_linearBox, anc2_advice_linearBox, anc3_his_linearBox, anc3_exam_linearBox, anc3_invest_linearBox, anc3_advice_linearBox, anc4_his_linearBox, anc4_exam_linearBox, anc4_advice_linearBox, anc5_his_linearBox, anc5_exam_linearBox, anc5_invest_linearBox, anc5_advice_linearBox, anc5_USG_linearBox, anc6_advice_linearBox, anc6_his_linearBox, anc6_exam_linearBox, anc7_his_linearBox, anc7_exam_linearBox, anc7_advice_linearBox, anc8_his_linearBox, anc8_exam_linearBox, anc8_advice_linearBox;

    int clickedPatientId;
    Button UpdateData;
    String anc_1_dateTime;
    Calendar newDate1 = Calendar.getInstance ( );
    Calendar anc1_date = Calendar.getInstance ( );
    private DatePickerDialog anc_1_datePickerDialog;
    private SimpleDateFormat dateFormatterShow, dateFormatterServer;
    String g;
    int key = 1;

    String lmpDateString;

    void callDateDiff(String p) {
        Log.d ("p =", p);
            g = p.split ("-")[1];
            g= g.trim ();
        Log.d ("g =", g);
            SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
            try {
                Date d = sdf.parse (g);
                Log.i ("d1", g);
                Date d2 = sdf.parse (lmpDateString);
                Log.i ("d1", lmpDateString);
                long diff = d.getTime ( ) - d2.getTime ( );
                Log.i ("difference", "" + diff);
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
                Log.d ("final =", t);
                anc2_POG.setText (t);

            } catch (ParseException e) {
                e.printStackTrace ( );
            }
        }

        void callDateDiff () {
            String[] temp = anc_1_dateTime.split ("-");
            String date_year = temp[2];
            String date_month = temp[1];
            String date_date = temp[0];

            anc_1_dateTime = date_date + "/" + date_month + "/" + date_year;
            Log.d ("ancdatee =", anc_1_dateTime );
            SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");

            try {
                Date d1 = sdf.parse (anc_1_dateTime);
                Log.i ("d1", anc_1_dateTime);
                Date d2 = sdf.parse (lmpDateString);
                Log.i ("d1", lmpDateString);
                long diff = d1.getTime ( ) - d2.getTime ( );
                Log.i ("difference", "" + diff);
                long days = diff / (24 * 60 * 60 * 1000);
                long month = days / 30;

                days = days % 30;

                Log.i ("month", "" + month);
                Log.i ("days", "" + days);
                String m = "";
                if (month == 1) {
                    m = month + " Month " + " and " + days + " Days";
                } else if (month > 1) {
                    m = month + " Months " + " and " + days + " Days";
                }
                else {
                    Toast.makeText (this, "Invalid Date!", Toast.LENGTH_SHORT).show ( );
                }
                Log.d ("final m =", m);
                anc_1_POG.setText (m);

            } catch (ParseException e) {
                e.printStackTrace ( );
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_patient_data_entry_bydoc);
        Log.i ("aaaaagyeeeeeee", "screeeen mae: ");


        anc_1 = (CheckBox) findViewById (R.id.anc_1);

        anc_2 = (CheckBox) findViewById (R.id.anc_2);

        anc_3 = (CheckBox) findViewById (R.id.anc_3);

        anc_4 = (CheckBox) findViewById (R.id.anc_4);

        anc_5 = (CheckBox) findViewById (R.id.anc_5);

        anc_6 = (CheckBox) findViewById (R.id.anc_6);

        anc_7 = (CheckBox) findViewById (R.id.anc_7);

        anc_8 = (CheckBox) findViewById (R.id.anc_8);

        investigationsBox = (CheckBox) findViewById (R.id.investigations_box);

        invest_chronic_hyper = (CheckBox) findViewById (R.id.chronichyper);

        invest_type_2_diabetes = (CheckBox) findViewById (R.id.type2);

        invest_RHD_native = (CheckBox) findViewById (R.id.rhd);

        invest_RHD_post = (CheckBox) findViewById (R.id.rhd_post);

        invest_acyanotic = (CheckBox) findViewById (R.id.acyanotic);

        invest_cyanotic = (CheckBox) findViewById (R.id.cyanotic);

        invest_chronic_liver = (CheckBox) findViewById (R.id.chronic_liver_disease);

        invest_chronic_kidney = (CheckBox) findViewById (R.id.chronic_kidney_disease);

        invest_APLA = (CheckBox) findViewById (R.id.apla);

        invest_SLE = (CheckBox) findViewById (R.id.sle);

        invest_others = (EditText) findViewById (R.id.others);

        invest_drug_history = (EditText) findViewById (R.id.drug_history);

        anc1_his_fever = (CheckBox) findViewById (R.id.fever);

        anc1_his_rash = (CheckBox) findViewById (R.id.rash);

        anc1_his_nausea_vomit = (CheckBox) findViewById (R.id.nausea_vomit);

        anc1_his_bleed = (CheckBox) findViewById (R.id.bleeding);

        anc1_his_abdpain = (CheckBox) findViewById (R.id.abdomen_pain);

        anc1_drugin = (CheckBox) findViewById (R.id.drug_intake);

        anc1_his_smoke = (CheckBox) findViewById (R.id.smoking);

        anc1_his_alcohol = (CheckBox) findViewById (R.id.alcohol);

        anc1_his_tob = (CheckBox) findViewById (R.id.Tob_intake);

        anc1_his_caff = (CheckBox) findViewById (R.id.caff_intake);

        anc1_his_int = (CheckBox) findViewById (R.id.intimate_partner);

        anc1_exam_pallor = (CheckBox) findViewById (R.id.pallor);

        anc1_exam_lcterus = (CheckBox) findViewById (R.id.lcterus);

        anc1_exam_clubbing = (CheckBox) findViewById (R.id.clubbing);

        anc1_exam_cyanosis = (CheckBox) findViewById (R.id.Cyanosis);

        anc1_exam_edem = (CheckBox) findViewById (R.id.edema);

        anc1_exam_lymp = (CheckBox) findViewById (R.id.lymphadenopathy);

        anc1_invest_HIV = (CheckBox) findViewById (R.id.HIV);

        anc1_invest_hbsag = (CheckBox) findViewById (R.id.Hbsag);

        anc1_invest_VDRL = (CheckBox) findViewById (R.id.VDRL);

        anc1_invest_urineRM = (CheckBox) findViewById (R.id.Urine_RM_text);

        anc1_invest_urineCS = (CheckBox) findViewById (R.id.Urine_CS_text);

        anc1_invest_CRL = (CheckBox) findViewById (R.id.NT_NB_CRL);

        anc1_invest_NT = (CheckBox) findViewById (R.id.NT_NB_NT);

        anc1_invest_centile = (CheckBox) findViewById (R.id.NT_NB_Centile);

        anc1_invest_text = (CheckBox) findViewById (R.id.NT_NB_text);

        anc1_advice_Tfolate = (CheckBox) findViewById (R.id.T_folate_if_lessthan_14weeks);

        anc1_advice_TFe = (CheckBox) findViewById (R.id.T_Fe_if_morethan_14weeks);

        anc1_general_TSH = (CheckBox) findViewById (R.id.general_TSH);

        anc1_general_T_nitro = (CheckBox) findViewById (R.id.urine_culture_nitrofur);

        anc1_general_syp = (CheckBox) findViewById (R.id.urine_culture_syp);

        anc1_general_Tvit = (CheckBox) findViewById (R.id.urine_culture_vit_c);

        anc1_general_plenty = (CheckBox) findViewById (R.id.urine_culture_plenty);

        anc1_exam_cyanosis = (CheckBox) findViewById (R.id.Cyanosis);

        anc1_exam_edem = (CheckBox) findViewById (R.id.edema);

        anc1_exam_lymp = (CheckBox) findViewById (R.id.lymphadenopathy);

        anc1_invest_HIV = (CheckBox) findViewById (R.id.HIV);

        anc1_invest_hbsag = (CheckBox) findViewById (R.id.Hbsag);

        anc1_invest_VDRL = (CheckBox) findViewById (R.id.VDRL);

        anc1_invest_urineRM = (CheckBox) findViewById (R.id.Urine_RM_text);

        anc1_invest_urineCS = (CheckBox) findViewById (R.id.Urine_CS_text);

        anc1_invest_CRL = (CheckBox) findViewById (R.id.NT_NB_CRL);

        anc1_invest_NT = (CheckBox) findViewById (R.id.NT_NB_NT);

        anc1_invest_centile = (CheckBox) findViewById (R.id.NT_NB_Centile);

        anc1_invest_text = (CheckBox) findViewById (R.id.NT_NB_text);

        anc1_advice_Tfolate = (CheckBox) findViewById (R.id.T_folate_if_lessthan_14weeks);

        anc1_advice_TFe = (CheckBox) findViewById (R.id.T_Fe_if_morethan_14weeks);

        anc1_general_TSH = (CheckBox) findViewById (R.id.general_TSH);

        anc1_general_T_nitro = (CheckBox) findViewById (R.id.urine_culture_nitrofur);

        anc1_general_syp = (CheckBox) findViewById (R.id.urine_culture_syp);

        anc1_general_Tvit = (CheckBox) findViewById (R.id.urine_culture_vit_c);

        anc1_general_plenty = (CheckBox) findViewById (R.id.urine_culture_plenty);

        dateFormatterShow = new SimpleDateFormat ("dd-MM-yyyy", Locale.US);
        dateFormatterServer = new SimpleDateFormat ("dd-MM-yyyy");
        anc_1_date = (EditText) findViewById (R.id.date);

        Calendar newCalendar = Calendar.getInstance ( );
        anc_1_date.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                anc_1_datePickerDialog.show ( );
            }
        });
        anc_1_datePickerDialog = new DatePickerDialog (this, new DatePickerDialog.OnDateSetListener ( ) {

            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                anc1_date.set (dayOfMonth, monthOfYear, year);
                anc_1_date.setText (dateFormatterShow.format (anc1_date.getTime ( )));
                anc_1_dateTime = dateFormatterShow.format (anc1_date.getTime ( ));
                callDateDiff ();
            }

        }, newCalendar.get (Calendar.YEAR), newCalendar.get (Calendar.MONTH), newCalendar.get (Calendar.DAY_OF_MONTH));


        anc_1_POG = (EditText) findViewById(R.id.anc1_POG);

        anc1_his_others = (EditText) findViewById(R.id.anc_1_his_others);

        anc1_exam_height = (EditText) findViewById(R.id.height);

        anc1_exam_weight = (EditText) findViewById(R.id.weight);

        anc1_exam_BMI = (EditText) findViewById(R.id.bmi);

        anc1_exam_PR = (EditText) findViewById(R.id.PR);

        anc1_exam_BP = (EditText) findViewById(R.id.BP);

        anc1_exam_RR = (EditText) findViewById(R.id.RR);

        anc1_exam_temp = (EditText) findViewById(R.id.Temp);

//        anc1_exam_proteinuria = (EditText) findViewById(R.id.Proteinuria);

        anc1_exam_chest = (EditText) findViewById(R.id.Chest_CVS);

        anc1_exam_PA = (EditText) findViewById(R.id.P_A);

        anc_1_GeneralDeranged_fasting= (EditText) findViewById(R.id.anc_1_GeneralDeranged_fasting);

        anc_1_GeneralDeranged_breakfast= (EditText) findViewById(R.id.anc_1_GeneralDeranged_breakfast);

        anc_1_GeneralDeranged_lunch= (EditText) findViewById(R.id.anc_1_GeneralDeranged_lunch);

        anc_1_GeneralDeranged_dinner= (EditText) findViewById(R.id.anc_1_GeneralDeranged_dinner);

        anc1_exam_others = (EditText) findViewById(R.id.exam_other);

        anc1_invest_bg = (EditText) findViewById(R.id.blood_group);

        anc1_invest_husband_bg = (EditText) findViewById(R.id.husband_blood_group);

        anc1_invest_hemo = (EditText) findViewById(R.id.hemogram);

        anc1_invest_bloodsugar_fast = (EditText) findViewById(R.id.blood_sugar_fasting);

        anc1_invest_bloodsugar_post = (EditText) findViewById(R.id.blood_sugar_post_prandial);

        anc1_invest_GTT_fast = (EditText) findViewById(R.id.GTT_fast);

        anc1_invest_GTT_1hr = (EditText) findViewById(R.id.GTT_1_hour);

        anc1_invest_GTT_2hr = (EditText) findViewById(R.id.GTT_2_hour);

        anc1_invest_TSH = (EditText) findViewById(R.id.TSH);

        anc1_invest_NT_done = (EditText) findViewById(R.id.NT_NB_done);

        anc1_invest_PAPP = (EditText) findViewById(R.id.Dual_screen_PAPP_A);

        anc1_invest_b_hcg = (EditText) findViewById(R.id.Dual_screen_B_hcg);

        anc1_invest_levelII_done = (EditText) findViewById(R.id.Level_II_USG_done);

        anc1_invest_normal = (EditText) findViewById(R.id.Level_II_USG_normal);

        anc1_invest_others = (EditText) findViewById(R.id.other_invest);

        anc1_general_nutritional = (EditText) findViewById(R.id.general_nutritional);

        anc1_general_ailment = (EditText) findViewById(R.id.general_ailments);

        anc1_general_ICT = (EditText) findViewById(R.id.general_BG_negative);

        anc1_general_others = (EditText) findViewById(R.id.general_others);

        anc2_his_breath = (CheckBox) findViewById(R.id.shortness_of_breath);

        anc2_his_fatigue = (CheckBox) findViewById(R.id.Easy_fatiguability);

        anc2_his_head = (CheckBox) findViewById(R.id.Headache_epigastric_pain_blurringofvision_nausea);

        anc2_his_bleed = (CheckBox) findViewById(R.id.Bleeding_spotting_pv);

        anc2_his_burn = (CheckBox) findViewById(R.id.Burning_micturition);

        anc2_his_quick_percieve = (CheckBox) findViewById(R.id.Quickening_Perceived_or_not);

        anc2_exam_pallor = (CheckBox) findViewById(R.id.Anc_2_pallor);

        anc2_exam_pedal = (CheckBox) findViewById(R.id.anc_2_Pedal_edema);

        anc2_exam_pa = (TextView) findViewById(R.id.anc_2_pa);

        anc_2_pa_2weeks = (EditText) findViewById(R.id.anc_2_pa_2weeks);

        anc2_invest_quad = (CheckBox) findViewById(R.id.anc_2_Quadruple_Screen);

        anc2_invest_fetal = (CheckBox) findViewById(R.id.anc_2_Fetal_Echo);

        anc2_advice_OGTT = (CheckBox) findViewById(R.id.anc_2_advice_OGTT);

        anc2_advice_TFe = (CheckBox) findViewById(R.id.anc_2_advice_T_Fe_OD);

        anc2_advice_TCa = (CheckBox) findViewById(R.id.anc_2_advice_T_Ca_BD);

        anc2_advice_Hb_Talb = (CheckBox) findViewById(R.id.anc_2_T_Albendazole);

        anc2_advice_Hb_TFe = (CheckBox) findViewById(R.id.anc_2_advice_T_Fe_BD);

        anc2_advice_Hb_HPLC = (CheckBox) findViewById(R.id.anc_2_hplc);

        anc2_advice_Hb_peri = (CheckBox) findViewById(R.id.anc_2_Peripheral_smear);

        anc2_advice_Hb_serum = (CheckBox) findViewById(R.id.anc_2_serum_iron);

        anc2_advice_tetanus = (CheckBox) findViewById(R.id.anc_2_inj_tetanus);

        anc2_POG = (EditText) findViewById(R.id.Anc_2_POG);

        anc2_his_others = (EditText) findViewById(R.id.anc_2_his_others);

        anc2_exam_PR = (EditText) findViewById(R.id.anc_2_PR);

        anc2_exam_BP = (EditText) findViewById(R.id.Anc_2_BP);

        anc2_exam_weight = (EditText) findViewById(R.id.anc_2_weight);

        anc2_exam_others = (EditText) findViewById(R.id.anc_2_exam_others);

        anc2_invest_others = (EditText) findViewById(R.id.anc_2_invest_others);

        anc2_advice_nutri = (EditText) findViewById(R.id.anc_2_nutritional);

        anc2_advice_general = (EditText) findViewById(R.id.anc_2_General_advice);

        anc2_advice_common = (EditText) findViewById(R.id.anc_2_common_ailment);

        anc2_advice_others = (EditText) findViewById(R.id.anc_2_others);

        anc3_his_breath = (CheckBox) findViewById(R.id.anc_3_shortness_of_breath);

        anc3_his_fatigue = (CheckBox) findViewById(R.id.anc_3_Easy_fatiguability);

        anc3_his_head = (CheckBox) findViewById(R.id.anc_3_Headache_epigastric_pain_blurringofvision_nausea);

        anc3_his_bleed = (CheckBox) findViewById(R.id.anc_3_Bleeding_spotting_pv);

        anc3_his_leak = (CheckBox) findViewById(R.id.anc_3_leaking_discharge_pv);

        anc3_his_burn = (CheckBox) findViewById(R.id.anc_3_burning_micturition);

        anc3_his_fetal_move = (CheckBox) findViewById(R.id.anc_3_fetal_movements);

        anc3_his_itching = (CheckBox) findViewById(R.id.anc_3_itching);

        anc3_exam_pallor = (CheckBox) findViewById(R.id.Anc_3_pallor);

        anc3_exam_pedal = (CheckBox) findViewById(R.id.anc_3_Pedal_edema);

        anc3_exam_pa = (TextView) findViewById(R.id.anc_3_pa);

        anc_3_pa_2weeks = (EditText) findViewById(R.id.anc_3_pa_2weeks);

        anc3_invest_GTT_fast = (CheckBox) findViewById(R.id.anc_3_GTT_fast);

        anc3_invest_GTT_1hr = (CheckBox) findViewById(R.id.anc_3_GTT_1hr);

        anc3_invest_GTT_2hr = (CheckBox) findViewById(R.id.anc_3_GTT_2hr);

        anc3_invest_CBC = (CheckBox) findViewById(R.id.anc_3_CBC);

        anc3_invest_urine = (CheckBox) findViewById(R.id.anc_3_urine);

        anc3_invest_ICT = (CheckBox) findViewById(R.id.anc_3_ICT);

        anc3_advice_TFe = (CheckBox) findViewById(R.id.anc_3_T_Fe_OD);

        anc3_advice_DFMC = (CheckBox) findViewById(R.id.anc_3_DFMC_LLP);

        anc3_advice_BleedPV = (CheckBox) findViewById(R.id.anc_3_bleeding);

        anc3_advice_spotPV = (CheckBox) findViewById(R.id.anc_3_spotting);

        anc3_advice_leakPV = (CheckBox) findViewById(R.id.anc_3_leaking);

        anc3_advice_fetalmove = (CheckBox) findViewById(R.id.anc_3_reducedfm);

        anc3_advice_abdpain = (CheckBox) findViewById(R.id.anc_3_abdomenpain);

        anc3_advice_injAntiD = (CheckBox) findViewById(R.id.anc_3_inj_tetanus);

        anc3_his_others = (EditText) findViewById(R.id.anc_3_others);

        anc3_exam_PR = (EditText) findViewById(R.id.anc_3_PR);

        anc3_exam_BP = (EditText) findViewById(R.id.Anc_3_BP);

        anc3_exam_weight = (EditText) findViewById(R.id.anc_3_weight);

        anc3_exam_others = (EditText) findViewById(R.id.anc_3_exam_others);

        anc3_advice_nutri = (EditText) findViewById(R.id.anc_3_nutritional);

        anc3_advice_general = (EditText) findViewById(R.id.anc_3_General_advice);

        anc3_advice_common = (EditText) findViewById(R.id.anc_3_common_ailment);

        anc3_advice_others = (EditText) findViewById(R.id.anc3_others);

        anc4_his_breath = (CheckBox) findViewById(R.id.anc_4_shortness_of_breath);

        anc4_his_fatigue = (CheckBox) findViewById(R.id.anc_4_Easy_fatiguability);

        anc4_his_head = (CheckBox) findViewById(R.id.anc_4_Headache_epigastric_pain_blurringofvision_nausea);

        anc4_his_bleed = (CheckBox) findViewById(R.id.anc_4_Bleeding_spotting_pv);

        anc4_his_burn = (CheckBox) findViewById(R.id.anc_4_burning_micturition);

        anc4_his_fetal_move = (CheckBox) findViewById(R.id.anc_4_fetal_movements);

        anc4_his_itching = (CheckBox) findViewById(R.id.anc_4_itching);

        anc4_exam_pallor = (CheckBox) findViewById(R.id.Anc_4_pallor);

        anc4_exam_pedal = (CheckBox) findViewById(R.id.anc_4_Pedal_edema);

        anc4_exam_pa = (TextView) findViewById(R.id.anc_4_pa);

        anc_4_pa_2weeks = (EditText) findViewById(R.id.anc__pa_2weeks);

        anc4_advice_TFe = (CheckBox) findViewById(R.id.anc_4_T_Fe_OD);

        anc4_advice_TCa = (CheckBox) findViewById(R.id.anc_4_T_Ca_BD);

        anc4_advice_DFMC = (CheckBox) findViewById(R.id.anc_4_DFMC);

        anc4_advice_BleedPV = (CheckBox) findViewById(R.id.anc_4_bleeding);

        anc4_advice_spotPV = (CheckBox) findViewById(R.id.anc_4_spotting);

        anc4_advice_leakPV = (CheckBox) findViewById(R.id.anc_4_leaking);

        anc4_advice_fetalmove = (CheckBox) findViewById(R.id.anc_4_reducedfm);

        anc4_advice_abdpain = (CheckBox) findViewById(R.id.anc_4_abdomenpain);

        anc4_advice_USG = (CheckBox) findViewById(R.id.anc_4_USG);

        anc4_his_others = (EditText) findViewById(R.id.ANC_others);

        anc4_exam_PR = (EditText) findViewById(R.id.anc_4_PR);

        anc4_exam_BP = (EditText) findViewById(R.id.Anc_4_BP);

        anc4_exam_weight = (EditText) findViewById(R.id.anc_4_weight);

        anc4_exam_others = (EditText) findViewById(R.id.anc_4_exam_others);

        anc4_advice_nutri = (EditText) findViewById(R.id.anc_4_nutritional);

        anc4_advice_general = (EditText) findViewById(R.id.anc_4_General_advice);

        anc4_advice_common = (EditText) findViewById(R.id.anc_4_common_ailment);

        anc4_advice_others = (EditText) findViewById(R.id.anc_4_others);

        anc5_his_breath = (CheckBox) findViewById(R.id.anc_5_shortness_of_breath);

        anc5_his_fatigue = (CheckBox) findViewById(R.id.anc_5_Easy_fatiguability);

        anc5_his_head = (CheckBox) findViewById(R.id.anc_5_Headache_epigastric_pain_blurringofvision_nausea);

        anc5_his_bleed = (CheckBox) findViewById(R.id.anc_5_Bleeding_spotting_pv);

        anc5_his_burn = (CheckBox) findViewById(R.id.anc_5_burning_micturition);

        anc5_his_fetal_move = (CheckBox) findViewById(R.id.anc_5_fetal_movements);

        anc5_his_itching = (CheckBox) findViewById(R.id.anc_5_itching);

        anc5_his_vaginal_del = (CheckBox) findViewById(R.id.anc_5_vaginal);

        anc5_his_LSCS_del = (CheckBox) findViewById(R.id.anc_5_LSCS);

        anc5_his_birth_attendant = (CheckBox) findViewById(R.id.anc_5_birth_attendant);

        anc5_exam_pallor = (CheckBox) findViewById(R.id.Anc_5_pallor);

        anc5_exam_pedal = (CheckBox) findViewById(R.id.anc_5_Pedal_edema);

        anc5_exam_pa = (TextView) findViewById(R.id.anc_5_pa);

        anc5_pa_2weeks = (EditText) findViewById(R.id.anc_5_pa_2weeks);

        anc5_invest_CBC = (CheckBox) findViewById(R.id.anc_5_CBC);

        anc5_invest_LFT = (CheckBox) findViewById(R.id.anc_5_LFT);

        anc5_invest_KFT = (CheckBox) findViewById(R.id.anc_5_KFT);

        anc5_invest_CPR = (CheckBox) findViewById(R.id.anc_5_CPR);

        anc5_advice_DFMC = (CheckBox) findViewById(R.id.anc_5_DFMC_LLP);

        anc5_advice_TFe_Ca = (CheckBox) findViewById(R.id.anc_5_T_Fe_Ca);

        anc5_advice_BleedPV = (CheckBox) findViewById(R.id.anc_5_bleeding);

        anc5_advice_spotPV = (CheckBox) findViewById(R.id.anc_5_spotting);

        anc5_advice_leakPV = (CheckBox) findViewById(R.id.anc_5_leaking);

        anc5_advice_fetalmove = (CheckBox) findViewById(R.id.anc_5_reducedfm);

        anc5_advice_abdpain = (CheckBox) findViewById(R.id.anc_5_abdomenpain);

        anc5_advice_NST = (CheckBox) findViewById(R.id.anc_5_NST);

        anc5_his_others = (EditText) findViewById(R.id.anc_5_others);

        anc5_his_timing = (EditText) findViewById(R.id.anc_5_timing);

        anc5_exam_PR = (EditText) findViewById(R.id.anc_5_PR);

        anc5_exam_BP = (EditText) findViewById(R.id.Anc_5_BP);

        anc5_exam_weight = (EditText) findViewById(R.id.anc_5_weight);

        anc5_exam_others = (EditText) findViewById(R.id.anc_5_exam_others);

        anc5_invest_others = (EditText) findViewById(R.id.anc_5_invest_others);

        anc5_USG_BPD_cm = (EditText) findViewById(R.id.anc_5_BPD_cm);

        anc5_USG_BPD_weeks = (EditText) findViewById(R.id.anc_5_BPD_weeks);

        anc5_USG_BPD_centile = (EditText) findViewById(R.id.anc_5_BPD_centile);

        anc5_USG_HC_cm = (EditText) findViewById(R.id.anc_5_HC_cm);

        anc5_USG_HC_weeks = (EditText) findViewById(R.id.anc_5_HC_weeks);

        anc5_USG_HC_centile = (EditText) findViewById(R.id.anc_5_HC_centile);

        anc5_USG_AC_cm = (EditText) findViewById(R.id.anc_5_AC_cm);

        anc5_USG_AC_weeks = (EditText) findViewById(R.id.anc_5_AC_weeks);

        anc5_USG_AC_centile = (EditText) findViewById(R.id.anc_5_AC_centile);

        anc5_USG_FL_cm = (EditText) findViewById(R.id.anc_5_FL_cm);

        anc5_USG_FL_weeks = (EditText) findViewById(R.id.anc_5_FL_weeks);

        anc5_USG_FL_centile = (EditText) findViewById(R.id.anc_5_FL_centile);

        anc5_USG_EFW_gm = (EditText) findViewById(R.id.anc_5_EFW_gm);

        anc5_USG_EFW_weeks = (EditText) findViewById(R.id.anc_5_EFW_weeks);

        anc5_USG_EFW_centile = (EditText) findViewById(R.id.anc_5_EFW_centile);

        anc5_USG_liquor_SLP = (EditText) findViewById(R.id.anc_5_liquor_SLP);

        anc5_USG_liquor_AFI = (EditText) findViewById(R.id.anc_5_liquor_AFI);

        anc5_USG_UAPI = (EditText) findViewById(R.id.anc_5_UA_PI);

        anc5_USG_UAPI_centile = (EditText) findViewById(R.id.anc_5_UA_PI_centile);

        anc5_USG_MCAPI = (EditText) findViewById(R.id.anc_5_MCA_PI);

        anc5_USG_MCAPI_centile = (EditText) findViewById(R.id.anc_5_UA_MCA_centile);

        anc5_advice_nutri = (EditText) findViewById(R.id.anc_5_nutritional);

        anc5_advice_general = (EditText) findViewById(R.id.anc_5_General_advice);

        anc5_advice_common = (EditText) findViewById(R.id.anc_5_common_ailment);

        anc5_advice_others = (EditText) findViewById(R.id.anc_5_advice_others);

        anc6_his_breath = (CheckBox) findViewById(R.id.anc_6_shortness_of_breath);

        anc6_his_fatigue = (CheckBox) findViewById(R.id.anc_6_Easy_fatiguability);

        anc6_his_head = (CheckBox) findViewById(R.id.anc_6_Headache_epigastric_pain_blurringofvision_nausea);

        anc6_his_bleed = (CheckBox) findViewById(R.id.anc_6_Bleeding_spotting_pv);

        anc6_his_burn = (CheckBox) findViewById(R.id.anc_6_burning_micturition);

        anc6_his_fetal_move = (CheckBox) findViewById(R.id.anc_6_fetal_movements);

        anc6_his_itching = (CheckBox) findViewById(R.id.anc_6_itching);

        anc6_exam_pallor = (CheckBox) findViewById(R.id.Anc_6_pallor);

        anc6_exam_pedal = (CheckBox) findViewById(R.id.anc_6_Pedal_edema);

        anc6_exam_pa = (TextView) findViewById(R.id.anc_6_pa);

        anc6_pa_2weeks = (EditText) findViewById(R.id.anc_6_pa_2weeks);

        anc6_advice_DFMC = (CheckBox) findViewById(R.id.anc_6_DFMC_LLP);

        anc6_advice_TFe_Ca = (CheckBox) findViewById(R.id.anc_6_T_Fe_Ca);

        anc6_advice_BleedPV = (CheckBox) findViewById(R.id.anc_6_bleeding);

        anc6_advice_spotPV = (CheckBox) findViewById(R.id.anc_6_spotting);

        anc6_advice_leakPV = (CheckBox) findViewById(R.id.anc_6_leaking);

        anc6_advice_fetalmove = (CheckBox) findViewById(R.id.anc_6_reducedfm);

        anc6_advice_abdpain = (CheckBox) findViewById(R.id.anc_6_abdomenpain);

        anc6_advice_NST = (CheckBox) findViewById(R.id.anc_6_NST);

        anc6_his_others = (EditText) findViewById(R.id.anc_6_others);

        anc6_exam_PR = (EditText) findViewById(R.id.anc_6_PR);

        anc6_exam_BP = (EditText) findViewById(R.id.Anc_6_BP);

        anc6_exam_weight = (EditText) findViewById(R.id.anc_6_weight);

        anc6_exam_others = (EditText) findViewById(R.id.anc_6_exam_others);

        anc6_exam_pelvic = (EditText) findViewById(R.id.anc_6_pelvic);

        anc6_advice_others = (EditText) findViewById(R.id.anc_6_advice_others);

        anc7_his_breath = (CheckBox) findViewById(R.id.anc_7_shortness_of_breath);

        anc7_his_fatigue = (CheckBox) findViewById(R.id.anc_7_easy_fatiguability);

        anc7_his_head = (CheckBox) findViewById(R.id.anc_7_Headache_epigastric_pain_blurringofvision_nausea);

        anc7_his_bleed = (CheckBox) findViewById(R.id.anc_7_Bleeding_spotting_pv);

        anc7_his_burn = (CheckBox) findViewById(R.id.anc_7_burning_micturition);

        anc7_his_fetal_move = (CheckBox) findViewById(R.id.anc_7_fetal_movements);

        anc7_his_itching = (CheckBox) findViewById(R.id.anc_7_itching);

        anc7_exam_pallor = (CheckBox) findViewById(R.id.Anc_7_pallor);

        anc7_exam_pedal = (CheckBox) findViewById(R.id.anc_7_Pedal_edema);

        anc7_exam_pa = (TextView) findViewById(R.id.anc_7_pa);

        anc7_pa_2weeks = (EditText) findViewById(R.id.anc_7_pa_2weeks);

        anc7_advice_DFMC = (CheckBox) findViewById(R.id.anc_7_DFMC_LLP);

        anc7_advice_TFe_Ca = (CheckBox) findViewById(R.id.anc_7_T_Fe_Ca);

        anc7_advice_BleedPV = (CheckBox) findViewById(R.id.anc_7_bleeding);

        anc7_advice_spotPV = (CheckBox) findViewById(R.id.anc_7_spotting);

        anc7_advice_leakPV = (CheckBox) findViewById(R.id.anc_7_leaking);

        anc7_advice_fetalmove = (CheckBox) findViewById(R.id.anc_7_reducedfm);

        anc7_advice_abdpain = (CheckBox) findViewById(R.id.anc_7_abdomenpain);

        anc7_his_others = (EditText) findViewById(R.id.anc_7_others);

        anc7_exam_PR = (EditText) findViewById(R.id.anc_7_PR);

        anc7_exam_BP = (EditText) findViewById(R.id.Anc_7_BP);

        anc7_exam_weight = (EditText) findViewById(R.id.anc_7_weight);

        anc7_exam_others = (EditText) findViewById(R.id.anc_7_exam_others);

        anc7_advice_others = (EditText) findViewById(R.id.anc_7others);

        anc8_his_breath = (CheckBox) findViewById(R.id.anc_8_shortness_of_breath);

        anc8_his_fatigue = (CheckBox) findViewById(R.id.anc_8_easy_fatiguability);

        anc8_his_head = (CheckBox) findViewById(R.id.anc_8_Headache_epigastric_pain_blurringofvision_nausea);

        anc8_his_bleed = (CheckBox) findViewById(R.id.anc_8_Bleeding_spotting_pv);

        anc8_his_burn = (CheckBox) findViewById(R.id.anc_8_burning_micturition);

        anc8_his_fetal_move = (CheckBox) findViewById(R.id.anc_8_fetal_movements);

        anc8_his_itching = (CheckBox) findViewById(R.id.anc_8_itching);

        anc8_exam_pallor = (CheckBox) findViewById(R.id.Anc_8_pallor);

        anc8_exam_pedal = (CheckBox) findViewById(R.id.anc_8_Pedal_edema);

        anc8_exam_pa = (CheckBox) findViewById(R.id.anc_8_pa);

        anc8_advice_DFMC = (CheckBox) findViewById(R.id.anc_8_DFMC_LLP);

        anc8_advice_Fe_Ca = (CheckBox) findViewById(R.id.anc_8_Fe_Ca);

        anc8_advice_induction = (CheckBox) findViewById(R.id.anc_8_induction);

        anc8_his_others = (EditText) findViewById(R.id.anc_8_others);

        anc8_exam_PR = (EditText) findViewById(R.id.anc_8_PR);

        anc8_exam_BP = (EditText) findViewById(R.id.Anc_8_BP);

        anc8_exam_weight = (EditText) findViewById(R.id.anc_8_weight);

        anc8_exam_others = (EditText) findViewById(R.id.anc_8_exam_others);

        anc8_advice_others = (EditText) findViewById(R.id.anc_8others);

        anc1_date_box = (TextView) findViewById(R.id.datebox);

        anc_1_POG_box = (TextView) findViewById(R.id.datePOG);

        anc1_his_others_box = (TextView) findViewById(R.id.anc_1_his_otherstext);

        anc1_history = (TextView) findViewById(R.id.anc1_history);

        anc1_examination = (TextView) findViewById(R.id.anc_1_examination);

        anc_1_GeneralDeranged_bs = (TextView) findViewById (R.id.anc_1_GeneralDeranged_bs);

        anc_1_GeneralDeranged_fastingBox = (TextView) findViewById (R.id.anc_1_GeneralDeranged_fastingBox);

        anc_1_GeneralDeranged_breakfastBox = (TextView) findViewById (R.id.anc_1_GeneralDeranged_breakfastBox);

        anc_1_GeneralDeranged_lunchBox = (TextView) findViewById (R.id.anc_1_GeneralDeranged_lunchBox);

        anc_1_GeneralDeranged_dinnerBox = (TextView) findViewById (R.id.anc_1_GeneralDeranged_dinnerBox);

        anc1_examinationGen = (TextView) findViewById(R.id.anc_1_examinationgen);

        anc1_anthropometry = (TextView) findViewById(R.id.anc_1_examinationAnth);

        anc1_exam_height_box = (TextView) findViewById(R.id.anc_1_Anthheight);

        anc1_exam_weight_box = (TextView) findViewById(R.id.anc_1_Anthweight);

        anc1_exam_BMI_box = (TextView) findViewById(R.id.anc_1_Anthbmi);

        anc1_vitals = (TextView) findViewById(R.id.anc_1_vitals);

        anc1_exam_PR_box = (TextView) findViewById(R.id.anc_1_vitalsPR);

        anc1_exam_BP_box = (TextView) findViewById(R.id.anc_1_vitalsBP);

        anc1_exam_RR_box = (TextView) findViewById(R.id.anc_1_vitalsRR);

        anc1_exam_temp_box = (TextView) findViewById(R.id.anc_1_vitalsTemp);

        anc1_exam_proteinuria_box = (TextView) findViewById(R.id.anc_1_vitalsProt);

        anc1_exam_chest_box = (TextView) findViewById(R.id.anc_1_vitalsChest);

        anc1_exam_PA_box = (TextView) findViewById(R.id.anc_1_vitalsPA);

        anc1_exam_others_box = (TextView) findViewById(R.id.anc_1_vitalsOthers);

        anc1_investigations = (TextView) findViewById(R.id.anc_1_investigation);

        anc1_invest_bg_box = (TextView) findViewById(R.id.anc_1_investBg);

        anc1_invest_husband_bg_box = (TextView) findViewById(R.id.anc_1_investHusBg);

        anc1_invest_hemo_box = (TextView) findViewById(R.id.anc_1_investHem);

        anc1_invest_bloodsugar = (TextView) findViewById(R.id.anc_1_investBs);

        anc1_invest_GTT = (TextView) findViewById(R.id.anc_1_investGTT);

        anc1_invest_TSH_box = (TextView) findViewById(R.id.anc_1_investTSH);

        anc1_NTscan = (TextView) findViewById(R.id.anc_1_investNTscan);

        anc1_invest_NT_done_box = (TextView) findViewById(R.id.anc_1_investDone);

        anc1_invest_PAPP_box = (TextView) findViewById(R.id.anc_1_investPAPP);

        anc1_invest_b_hcg_box = (TextView) findViewById(R.id.anc_1_investBcg);

        anc1_investDual = (TextView) findViewById(R.id.anc_1_investDual);

        anc1_invest_levelII_USG = (TextView) findViewById(R.id.anc_1_investLevelII);

        anc1_invest_levelII_done_box = (TextView) findViewById(R.id.anc_1_investLevelIIDone);

        anc1_invest_normal_box = (TextView) findViewById(R.id.anc_1_investNormal);

        anc1_invest_others_box = (TextView) findViewById(R.id.anc_1_investOthers);

        anc1_advice = (TextView) findViewById(R.id.anc_1_Advice);

        anc1_adviceGeneral = (TextView) findViewById(R.id.anc_1_General);

        anc1_general_nutritional_box = (TextView) findViewById(R.id.anc_1_GeneralNut);

        anc1_general_ailment_box = (TextView) findViewById(R.id.anc_1_GeneralCommon);

        anc1_general_ICT_box = (TextView) findViewById(R.id.anc_1_GeneralBG);

        anc1_general_Urine = (TextView) findViewById(R.id.anc_1_GeneralUrine);

        anc1_general_Deranged = (TextView) findViewById(R.id.anc_1_GeneralDeranged);

        anc1_general_others_box = (TextView) findViewById(R.id.anc_1_GeneralOthers);

        anc_2_POG_box = (TextView) findViewById(R.id.Anc_2_POG_box);

        anc_2_history = (TextView) findViewById(R.id.anc2_history_box);

        anc2_his_othersBox = (TextView) findViewById(R.id.anc_2_his_other_box);

        anc_2_examination = (TextView) findViewById(R.id.Anc_2_examination);

        anc_2_exam_PRBox = (TextView) findViewById(R.id.anc_2_PR_box);

        anc2_exam_BPBox = (TextView) findViewById(R.id.Anc_2_BP_box);

        anc2_exam_weightBox = (TextView) findViewById(R.id.anc_2_weight_box);

        anc2_exam_othersBox = (TextView) findViewById(R.id.anc_2_exam_others_box);

        anc2_investigationBox = (TextView) findViewById(R.id.anc_2_investigations);

        anc2_advice_nutriBox = (TextView) findViewById(R.id.anc_2_nutritional_box);

        anc_2_adviceBox = (TextView) findViewById(R.id.anc_2_advice);

        anc2_advice_generalBox = (TextView) findViewById(R.id.anc_2_General_advice_box);

        anc2_advice_commonBox = (TextView) findViewById(R.id.anc_2_common_ailment_box);

        anc2_common_ailment_ifHbBox = (TextView) findViewById(R.id.anc_2_common_ailment_ifHb);

        anc2_advice_othersBox = (TextView) findViewById(R.id.anc_2_others_box);

        anc_2_invest_othersBox = (TextView) findViewById(R.id.anc_2_invest_others_box);

        anc3_historyBox = (TextView) findViewById(R.id.anc3_history_box);

        anc3_investigation_othersbox = (TextView) findViewById(R.id.anc3_investigation_othersbox);

        anc3_investigation_others= (EditText) findViewById(R.id.anc3_investigation_others);

        anc3_his_othersBox = (TextView) findViewById(R.id.anc_3_others_box);

        Anc_3_examinationBox = (TextView) findViewById(R.id.Anc_3_examination);

        anc3_exam_PRBox = (TextView) findViewById(R.id.anc_3_PR_box);

        anc3_exam_BPBox = (TextView) findViewById(R.id.Anc_3_BP_box);

        anc3_exam_weightBox = (TextView) findViewById(R.id.anc_3_weight_box);

        anc3_exam_othersBox = (TextView) findViewById(R.id.anc_3_exam_others_box);

        anc_3_investigationsBox = (TextView) findViewById(R.id.anc_3_investigations);

        anc_3_GTTBox = (TextView) findViewById(R.id.anc_3_GTT_box);

        anc_3_adviceBox = (TextView) findViewById(R.id.anc_3_advice_box);

        anc3_advice_nutriBox = (TextView) findViewById(R.id.anc_3_nutritional_box);

        anc3_advice_generalBox = (TextView) findViewById(R.id.anc_3_General_advice_box);

        anc3_advice_commonBox = (TextView) findViewById(R.id.anc_3_common_ailment_box);

        anc_3_inj_antiDBox = (TextView) findViewById(R.id.anc_3_inj_antiD_box);

        anc3_advice_othersBox = (TextView) findViewById(R.id.anc3_others_box);

        anc_3_reviewBox = (TextView) findViewById(R.id.anc_3_review_box);

        anc4_his_othersBox = (TextView) findViewById(R.id.ANC_others_box);

        anc4_exam_PRBox = (TextView) findViewById(R.id.anc_4_PR_box);

        anc4_exam_BPBox = (TextView) findViewById(R.id.Anc_4_BP_box);

        anc4_exam_weightBox = (TextView) findViewById(R.id.anc_4_weight_box);

        anc4_exam_othersBox = (TextView) findViewById(R.id.anc_4_exam_others_box);

        anc4_advice_nutriBox = (TextView) findViewById(R.id.anc_4_nutritional_box);

        anc4_advice_generalBox = (TextView) findViewById(R.id.anc_4_General_advice_box);

        anc4_advice_commonBox = (TextView) findViewById(R.id.anc_4_common_ailment_box);

        anc4_advice_othersBox = (TextView) findViewById(R.id.anc_4_others_box);

        anc_4_historyBox = (TextView) findViewById(R.id.anc_4_history);

        ANC_4_examinationBox = (TextView) findViewById(R.id.ANC_4_examination);

        anc_4_adviceBox = (TextView) findViewById(R.id.anc_4_advice);

        anc_4_reviewBox = (TextView) findViewById(R.id.anc_4_review);

        anc5_his_othersBox = (TextView) findViewById(R.id.anc_5_others_box);

        anc5_his_timingBox = (TextView) findViewById(R.id.anc_5_timingBox);

        anc5_exam_PRBox = (TextView) findViewById(R.id.anc_5_PR_box);

        anc5_exam_BPBox = (TextView) findViewById(R.id.Anc_5_BP_box);

        anc5_exam_weightBox = (TextView) findViewById(R.id.anc_5_weight_box);

        anc5_exam_othersBox = (TextView) findViewById(R.id.anc_5_exam_others_box);

        anc5_invest_othersBox = (TextView) findViewById(R.id.anc_5_invest_others_box);

        anc5_USG_BPDBox = (TextView) findViewById(R.id.anc_5_BPD_box);

        anc5_USG_HCBox = (TextView) findViewById(R.id.anc_5_HC_box);

        anc5_USG_ACBox = (TextView) findViewById(R.id.anc_5_AC_box);

        anc5_USG_FLBox = (TextView) findViewById(R.id.anc_5_FL_box);

        anc5_USG_EFWBox = (TextView) findViewById(R.id.anc_5_EFW_box);

        anc5_USG_liquorBox = (TextView) findViewById(R.id.anc_5_liquor_box);

        anc5_USG_UAPIBox = (TextView) findViewById(R.id.anc_5_UA_box);

        anc5_USG_MCAPIBox = (TextView) findViewById(R.id.anc_5_MCA_box);

        anc5_advice_nutriBox = (TextView) findViewById(R.id.anc_5_nutritional_box);

        anc5_advice_generalBox = (TextView) findViewById(R.id.anc_5_General_advice_box);

        anc5_advice_commonBox= (TextView) findViewById(R.id.anc_5_common_ailment_box);

        anc_5_reviewBox = (TextView) findViewById(R.id.anc_5_review);

        anc5_advice_othersBox = (TextView) findViewById(R.id.anc_5_advice_others_box);

        anc5_historyBox = (TextView) findViewById(R.id.anc5_history);

        anc5_counsellingBox = (TextView) findViewById(R.id.anc_5_councelling);

        anc5_modeOfDeliveryBox = (TextView) findViewById(R.id.anc_5_othersmode_del);

        anc5_examinationBox = (TextView) findViewById(R.id.anc_5_examination);

        anc5_investigationBox = (TextView) findViewById(R.id.anc_5_investigation);

        anc5_USGBox = (TextView) findViewById(R.id.anc_5_USG);

        anc_5_adviceBox = (TextView) findViewById(R.id.anc_5_advice);

        anc6_his_othersBox = (TextView) findViewById(R.id.anc_6_others_box);

        anc6_exam_PRBox = (TextView) findViewById(R.id.anc_6_PR_box);

        anc6_exam_BPBox = (TextView) findViewById(R.id.Anc_6_BP_box);

        anc6_exam_weightBox = (TextView) findViewById(R.id.anc_6_weight_box);

        anc6_exam_othersBox = (TextView) findViewById(R.id.anc_6_exam_others_box);

        anc6_exam_pelvicBox= (TextView) findViewById(R.id.anc_6_pelvic_box);

        anc6_advice_othersBox = (TextView) findViewById(R.id.anc_6_advice_others_box);

        anc_6_historyBox = (TextView) findViewById(R.id.anc_6_history);

        anc_6_examinationBox = (TextView) findViewById(R.id.anc_6_examination);

        anc_6_adviceBox = (TextView) findViewById(R.id.anc_6_advice);

        anc_6_reviewBox = (TextView) findViewById(R.id.anc_6_review);

        anc7_his_othersBox = (TextView) findViewById(R.id.anc_7_others_box);

        anc7_exam_PRBox = (TextView) findViewById(R.id.anc_7_PR_box);

        anc7_exam_BPBox = (TextView) findViewById(R.id.Anc_7_BP_box);

        anc7_exam_weightBox = (TextView) findViewById(R.id.anc_7_weight_box);

        anc7_exam_othersBox = (TextView) findViewById(R.id.anc_7_exam_others_box);

        anc7_advice_othersBox = (TextView) findViewById(R.id.anc_7others_box);

        anc_7_historyBox = (TextView) findViewById(R.id.anc_7_history);

        anc_7_examinationBox = (TextView) findViewById(R.id.anc_7_examination);

        anc_7_adviceBox = (TextView) findViewById(R.id.anc_7_advice);

        anc_7_reviewBox = (TextView) findViewById(R.id.anc_7_review);

        anc8_his_othersBox = (TextView) findViewById(R.id.anc_8_others_box);

        anc8_exam_PRBox = (TextView) findViewById(R.id.anc_8_PR_box);

        anc8_exam_BPBox = (TextView) findViewById(R.id.anc_8_BP_box);

        anc8_exam_weightBox = (TextView) findViewById(R.id.anc_8_weight_box);

        anc8_exam_othersBox = (TextView) findViewById(R.id.anc_8_exam_others_box);

        anc8_advice_othersBox = (TextView) findViewById(R.id.anc_8others_box);

        anc_8_historyBox = (TextView) findViewById(R.id.anc_8_history);

        anc_8_examinationBox = (TextView) findViewById(R.id.anc_8_examination);

        anc_8_adviceBox = (TextView) findViewById(R.id.anc_8_advice);

        invest_othersBox = (TextView) findViewById(R.id.others_box);

        invest_heart_linearBox = (CardView) findViewById(R.id.invest_heart_linear);

        invest_drug_historyBox = (TextView) findViewById(R.id.drug_his);

        Co_MorbiditiesBox = (TextView) findViewById(R.id.CoMorbidities_box);

        Heart_DiseaseBox = (TextView) findViewById(R.id.Heart_Disease);

        anc1_his_linearBox = (CardView) findViewById(R.id.anc1_his_linear);

        anc1_exam_linearBox = (CardView) findViewById(R.id.anc1_exam_linear);

        anc1_invest_linearBox = (CardView) findViewById(R.id.anc1_invest_linear);

        anc1_advice_linearBox = (CardView) findViewById(R.id.anc1_advice_linear);

        anc1_general_linear = (CardView) findViewById(R.id.anc1_general_linear);

        anc2_his_linearBox = (CardView) findViewById(R.id.anc2_his_linear);

        anc2_exam_linearBox = (CardView) findViewById(R.id.anc2_exam_linear);

        anc2_invest_linearBox = (CardView) findViewById(R.id.anc2_invest_linear);

        anc2_advice_linearBox = (CardView) findViewById(R.id.anc2_advice_linear);

        anc3_his_linearBox = (CardView) findViewById(R.id.anc3_his_linear);

        anc3_exam_linearBox = (CardView) findViewById(R.id.anc3_exam_linear);

        anc3_invest_linearBox = (CardView) findViewById(R.id.anc3_invest_linear);

        anc3_advice_linearBox = (CardView) findViewById(R.id.anc3_advice_linear);

        anc4_his_linearBox = (CardView) findViewById(R.id.anc4_his_linear);

        anc4_exam_linearBox = (CardView) findViewById(R.id.anc4_exam_linear);

        anc4_advice_linearBox = (CardView) findViewById(R.id.anc4_advice_linear);

        anc5_his_linearBox = (CardView) findViewById(R.id.anc5_his_linear);

        anc5_exam_linearBox = (CardView) findViewById(R.id.anc5_exam_linear);

        anc5_USG_linearBox = (CardView) findViewById(R.id.anc5_USG_linear);

        anc5_invest_linearBox = (CardView) findViewById(R.id. anc5_invest_linear);

        anc5_advice_linearBox = (CardView) findViewById(R.id.anc5_advice_linear);

        anc6_advice_linearBox = (CardView) findViewById(R.id.anc6_advice_linear);

        anc6_his_linearBox = (CardView) findViewById(R.id.anc6_his_linear);

        anc6_exam_linearBox = (CardView) findViewById(R.id.anc6_exam_linear);

        anc7_his_linearBox = (CardView) findViewById(R.id.anc7_his_linear);

        anc7_exam_linearBox = (CardView) findViewById(R.id.anc7_exam_linear);

        anc7_advice_linearBox = (CardView) findViewById(R.id.anc7_advice_linear);

        anc8_his_linearBox = (CardView) findViewById(R.id.anc8_his_linear);

        anc8_exam_linearBox = (CardView) findViewById(R.id.anc8_exam_linear);

        anc8_advice_linearBox = (CardView) findViewById(R.id.anc8_advice_linear);


        anc_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    anc_1_GeneralDeranged_fasting.setVisibility (View.VISIBLE);
                    anc_1_GeneralDeranged_breakfast.setVisibility (View.VISIBLE);
                    anc_1_GeneralDeranged_lunch.setVisibility (View.VISIBLE);
                    anc_1_GeneralDeranged_dinner.setVisibility (View.VISIBLE);
                    anc_1_GeneralDeranged_fastingBox.setVisibility (View.VISIBLE);
                    anc_1_GeneralDeranged_breakfastBox.setVisibility (View.VISIBLE);
                    anc_1_GeneralDeranged_lunchBox.setVisibility (View.VISIBLE);
                    anc_1_GeneralDeranged_dinnerBox.setVisibility (View.VISIBLE);
                    anc_1_GeneralDeranged_bs.setVisibility (View.VISIBLE);
                    anc1_invest_linearBox.setVisibility (View.VISIBLE);
                    anc1_exam_linearBox.setVisibility (View.VISIBLE);
                    anc1_advice_linearBox.setVisibility (View.VISIBLE);
                    anc1_his_linearBox.setVisibility (View.VISIBLE);
                    anc1_his_fever.setVisibility (View.VISIBLE);
                    anc1_his_rash.setVisibility (View.VISIBLE);
                    anc1_his_nausea_vomit.setVisibility (View.VISIBLE);
                    anc1_his_bleed.setVisibility (View.VISIBLE);
                    anc1_his_abdpain.setVisibility (View.VISIBLE);
                    anc1_drugin.setVisibility (View.VISIBLE);
                    anc1_his_smoke.setVisibility (View.VISIBLE);
                    anc1_his_alcohol.setVisibility (View.VISIBLE);
                    anc1_his_tob.setVisibility (View.VISIBLE);
                    anc1_his_caff.setVisibility (View.VISIBLE);
                    anc1_his_int.setVisibility (View.VISIBLE);
                    anc1_exam_pallor.setVisibility (View.VISIBLE);
                    anc1_exam_lcterus.setVisibility (View.VISIBLE);
                    anc1_exam_clubbing.setVisibility (View.VISIBLE);
                    anc1_exam_cyanosis.setVisibility (View.VISIBLE);
                    anc1_exam_edem.setVisibility (View.VISIBLE);
                    anc1_exam_lymp.setVisibility (View.VISIBLE);
                    anc1_invest_HIV.setVisibility (View.VISIBLE);
                    anc1_invest_hbsag.setVisibility (View.VISIBLE);
                    anc1_invest_VDRL.setVisibility (View.VISIBLE);
                    anc1_invest_urineRM.setVisibility (View.VISIBLE);
                    anc1_invest_urineCS.setVisibility (View.VISIBLE);
                    anc1_invest_CRL.setVisibility (View.VISIBLE);
                    anc1_invest_NT.setVisibility (View.VISIBLE);
                    anc1_invest_centile.setVisibility (View.VISIBLE);
                    anc1_invest_text.setVisibility (View.VISIBLE);
                    anc1_advice_Tfolate.setVisibility (View.VISIBLE);
                    anc1_advice_TFe.setVisibility (View.VISIBLE);
                    anc1_general_TSH.setVisibility (View.VISIBLE);
                    anc1_general_T_nitro.setVisibility (View.VISIBLE);
                    anc1_general_syp.setVisibility (View.VISIBLE);
                    anc1_general_Tvit.setVisibility (View.VISIBLE);
                    anc1_general_plenty.setVisibility (View.VISIBLE);
                    anc_1_date.setVisibility (View.VISIBLE);
                    anc_1_POG.setVisibility (View.VISIBLE);
                    anc1_his_others.setVisibility (View.VISIBLE);
                    anc1_exam_height.setVisibility (View.VISIBLE);
                    anc1_exam_weight.setVisibility (View.VISIBLE);
                    anc1_exam_BMI.setVisibility (View.VISIBLE);
                    anc1_exam_PR.setVisibility (View.VISIBLE);
                    anc1_exam_BP.setVisibility (View.VISIBLE);
                    anc1_exam_RR.setVisibility (View.VISIBLE);
                    anc1_exam_temp.setVisibility (View.VISIBLE);
//                    anc1_exam_proteinuria.setVisibility (View.VISIBLE);
                    anc1_exam_chest.setVisibility (View.VISIBLE);
                    anc1_exam_PA.setVisibility (View.VISIBLE);
                    anc1_exam_others.setVisibility (View.VISIBLE);
                    anc1_invest_bg.setVisibility (View.VISIBLE);
                    anc1_invest_husband_bg.setVisibility (View.VISIBLE);
                    anc1_invest_hemo.setVisibility (View.VISIBLE);
                    anc1_invest_bloodsugar_fast.setVisibility (View.VISIBLE);
                    anc1_invest_bloodsugar_post.setVisibility (View.VISIBLE);
                    anc1_invest_GTT_fast.setVisibility (View.VISIBLE);
                    anc1_invest_GTT_1hr.setVisibility (View.VISIBLE);
                    anc1_invest_GTT_2hr.setVisibility (View.VISIBLE);
                    anc1_invest_TSH.setVisibility (View.VISIBLE);
                    anc1_invest_NT_done.setVisibility (View.VISIBLE);
                    anc1_invest_PAPP.setVisibility (View.VISIBLE);
                    anc1_invest_b_hcg.setVisibility (View.VISIBLE);
                    anc1_invest_levelII_done.setVisibility (View.VISIBLE);
                    anc1_invest_normal.setVisibility (View.VISIBLE);
                    anc1_invest_others.setVisibility (View.VISIBLE);
                    anc1_general_nutritional.setVisibility (View.VISIBLE);
                    anc1_general_ailment.setVisibility (View.VISIBLE);
                    anc1_general_ICT.setVisibility (View.VISIBLE);
                    anc1_general_others.setVisibility (View.VISIBLE);
                    anc1_date_box.setVisibility (View.VISIBLE);
                    anc_1_POG_box.setVisibility (View.VISIBLE);
                    anc1_his_others_box.setVisibility (View.VISIBLE);
                    anc1_exam_height_box.setVisibility (View.VISIBLE);
                    anc1_exam_weight_box.setVisibility (View.VISIBLE);
                    anc1_exam_BMI_box.setVisibility (View.VISIBLE);
                    anc1_exam_PR_box.setVisibility (View.VISIBLE);
                    anc1_exam_BP_box.setVisibility (View.VISIBLE);
                    anc1_exam_RR_box.setVisibility (View.VISIBLE);
                    anc1_exam_temp_box.setVisibility (View.VISIBLE);
                    anc1_exam_proteinuria_box.setVisibility (View.VISIBLE);
                    anc1_exam_chest_box.setVisibility (View.VISIBLE);
                    anc1_exam_PA_box.setVisibility (View.VISIBLE);
                    anc1_exam_others_box.setVisibility (View.VISIBLE);
                    anc1_invest_bg_box.setVisibility (View.VISIBLE);
                    anc1_invest_husband_bg_box.setVisibility (View.VISIBLE);
                    anc1_invest_hemo_box.setVisibility (View.VISIBLE);
                    anc1_invest_TSH_box.setVisibility (View.VISIBLE);
                    anc1_invest_NT_done_box.setVisibility (View.VISIBLE);
                    anc1_invest_PAPP_box.setVisibility (View.VISIBLE);
                    anc1_invest_b_hcg_box.setVisibility (View.VISIBLE);
                    anc1_invest_levelII_done_box.setVisibility (View.VISIBLE);
                    anc1_invest_normal_box.setVisibility (View.VISIBLE);
                    anc1_invest_others_box.setVisibility (View.VISIBLE);
                    anc1_general_nutritional_box.setVisibility (View.VISIBLE);
                    anc1_general_ailment_box.setVisibility (View.VISIBLE);
                    anc1_general_ICT_box.setVisibility (View.VISIBLE);
                    anc1_general_others_box.setVisibility (View.VISIBLE);
                    anc1_investigations.setVisibility (View.VISIBLE);
                    anc1_invest_GTT.setVisibility (View.VISIBLE);
                    anc1_invest_levelII_USG.setVisibility (View.VISIBLE);
                    anc1_advice.setVisibility (View.VISIBLE);
                    anc1_general_linear.setVisibility (View.VISIBLE);
                    anc1_adviceGeneral.setVisibility (View.VISIBLE);
                    anc1_general_Urine.setVisibility (View.VISIBLE);
                    anc1_general_Deranged.setVisibility (View.VISIBLE);
                    anc1_vitals.setVisibility (View.VISIBLE);
                    anc1_invest_bloodsugar.setVisibility (View.VISIBLE);
                    anc1_history.setVisibility (View.VISIBLE);
                    anc1_examination.setVisibility (View.VISIBLE);
                    anc1_examinationGen.setVisibility (View.VISIBLE);
                    anc1_anthropometry.setVisibility (View.VISIBLE);
                    anc1_NTscan.setVisibility (View.VISIBLE);
                    anc1_investDual.setVisibility (View.VISIBLE);


                }else{
                    anc_1_GeneralDeranged_fasting.setVisibility (View.GONE);
                    anc_1_GeneralDeranged_breakfast.setVisibility (View.GONE);
                    anc_1_GeneralDeranged_lunch.setVisibility (View.GONE);
                    anc_1_GeneralDeranged_dinner.setVisibility (View.GONE);
                    anc_1_GeneralDeranged_fastingBox.setVisibility (View.GONE);
                    anc_1_GeneralDeranged_breakfastBox.setVisibility (View.GONE);
                    anc_1_GeneralDeranged_lunchBox.setVisibility (View.GONE);
                    anc_1_GeneralDeranged_dinnerBox.setVisibility (View.GONE);
                    anc_1_GeneralDeranged_bs.setVisibility (View.GONE);
                    anc1_invest_linearBox.setVisibility (View.GONE);
                    anc1_exam_linearBox.setVisibility (View.GONE);
                    anc1_advice_linearBox.setVisibility (View.GONE);
                    anc1_his_linearBox.setVisibility (View.GONE);
                    anc1_his_fever.setVisibility (View.GONE);
                    anc1_his_rash.setVisibility (View.GONE);
                    anc1_his_nausea_vomit.setVisibility (View.GONE);
                    anc1_his_bleed.setVisibility (View.GONE);
                    anc1_his_abdpain.setVisibility (View.GONE);
                    anc1_drugin.setVisibility (View.GONE);
                    anc1_his_smoke.setVisibility (View.GONE);
                    anc1_his_alcohol.setVisibility (View.GONE);
                    anc1_his_tob.setVisibility (View.GONE);
                    anc1_his_caff.setVisibility (View.GONE);
                    anc1_his_int.setVisibility (View.GONE);
                    anc1_exam_pallor.setVisibility (View.GONE);
                    anc1_exam_lcterus.setVisibility (View.GONE);
                    anc1_exam_clubbing.setVisibility (View.GONE);
                    anc1_exam_cyanosis.setVisibility (View.GONE);
                    anc1_exam_edem.setVisibility (View.GONE);
                    anc1_exam_lymp.setVisibility (View.GONE);
                    anc1_invest_HIV.setVisibility (View.GONE);
                    anc1_invest_hbsag.setVisibility (View.GONE);
                    anc1_invest_VDRL.setVisibility (View.GONE);
                    anc1_invest_urineRM.setVisibility (View.GONE);
                    anc1_invest_urineCS.setVisibility (View.GONE);
                    anc1_invest_CRL.setVisibility (View.GONE);
                    anc1_invest_NT.setVisibility (View.GONE);
                    anc1_invest_centile.setVisibility (View.GONE);
                    anc1_invest_text.setVisibility (View.GONE);
                    anc1_advice_Tfolate.setVisibility (View.GONE);
                    anc1_advice_TFe.setVisibility (View.GONE);
                    anc1_general_TSH.setVisibility (View.GONE);
                    anc1_general_T_nitro.setVisibility (View.GONE);
                    anc1_general_syp.setVisibility (View.GONE);
                    anc1_general_Tvit.setVisibility (View.GONE);
                    anc1_general_plenty.setVisibility (View.GONE);
                    anc_1_date.setVisibility (View.GONE);
                    anc_1_POG.setVisibility (View.GONE);
                    anc1_his_others.setVisibility (View.GONE);
                    anc1_exam_height.setVisibility (View.GONE);
                    anc1_exam_weight.setVisibility (View.GONE);
                    anc1_exam_BMI.setVisibility (View.GONE);
                    anc1_exam_PR.setVisibility (View.GONE);
                    anc1_exam_BP.setVisibility (View.GONE);
                    anc1_exam_RR.setVisibility (View.GONE);
                    anc1_exam_temp.setVisibility (View.GONE);
//                    anc1_exam_proteinuria.setVisibility (View.GONE);
                    anc1_exam_chest.setVisibility (View.GONE);
                    anc1_exam_PA.setVisibility (View.GONE);
                    anc1_exam_others.setVisibility (View.GONE);
                    anc1_invest_bg.setVisibility (View.GONE);
                    anc1_invest_husband_bg.setVisibility (View.GONE);
                    anc1_invest_hemo.setVisibility (View.GONE);
                    anc1_invest_bloodsugar_fast.setVisibility (View.GONE);
                    anc1_invest_bloodsugar_post.setVisibility (View.GONE);
                    anc1_invest_GTT_fast.setVisibility (View.GONE);
                    anc1_invest_GTT_1hr.setVisibility (View.GONE);
                    anc1_invest_GTT_2hr.setVisibility (View.GONE);
                    anc1_invest_TSH.setVisibility (View.GONE);
                    anc1_invest_NT_done.setVisibility (View.GONE);
                    anc1_invest_PAPP.setVisibility (View.GONE);
                    anc1_invest_b_hcg.setVisibility (View.GONE);
                    anc1_invest_levelII_done.setVisibility (View.GONE);
                    anc1_invest_normal.setVisibility (View.GONE);
                    anc1_invest_others.setVisibility (View.GONE);
                    anc1_general_nutritional.setVisibility (View.GONE);
                    anc1_general_ailment.setVisibility (View.GONE);
                    anc1_general_ICT.setVisibility (View.GONE);
                    anc1_general_others.setVisibility (View.GONE);
                    anc1_date_box.setVisibility (View.GONE);
                    anc_1_POG_box.setVisibility (View.GONE);
                    anc1_his_others_box.setVisibility (View.GONE);
                    anc1_exam_height_box.setVisibility (View.GONE);
                    anc1_exam_weight_box.setVisibility (View.GONE);
                    anc1_exam_BMI_box.setVisibility (View.GONE);
                    anc1_exam_PR_box.setVisibility (View.GONE);
                    anc1_exam_BP_box.setVisibility (View.GONE);
                    anc1_exam_RR_box.setVisibility (View.GONE);
                    anc1_exam_temp_box.setVisibility (View.GONE);
                    anc1_exam_proteinuria_box.setVisibility (View.GONE);
                    anc1_exam_chest_box.setVisibility (View.GONE);
                    anc1_exam_PA_box.setVisibility (View.GONE);
                    anc1_exam_others_box.setVisibility (View.GONE);
                    anc1_invest_bg_box.setVisibility (View.GONE);
                    anc1_invest_husband_bg_box.setVisibility (View.GONE);
                    anc1_invest_hemo_box.setVisibility (View.GONE);
                    anc1_invest_TSH_box.setVisibility (View.GONE);
                    anc1_invest_NT_done_box.setVisibility (View.GONE);
                    anc1_invest_PAPP_box.setVisibility (View.GONE);
                    anc1_invest_b_hcg_box.setVisibility (View.GONE);
                    anc1_invest_levelII_done_box.setVisibility (View.GONE);
                    anc1_invest_normal_box.setVisibility (View.GONE);
                    anc1_invest_others_box.setVisibility (View.GONE);
                    anc1_general_nutritional_box.setVisibility (View.GONE);
                    anc1_general_ailment_box.setVisibility (View.GONE);
                    anc1_general_ICT_box.setVisibility (View.GONE);
                    anc1_general_others_box.setVisibility (View.GONE);
                    anc1_investigations.setVisibility (View.GONE);
                    anc1_invest_GTT.setVisibility (View.GONE);
                    anc1_invest_levelII_USG.setVisibility (View.GONE);
                    anc1_advice.setVisibility (View.GONE);
                    anc1_adviceGeneral.setVisibility (View.GONE);
                    anc1_general_linear.setVisibility (View.GONE);
                    anc1_general_Urine.setVisibility (View.GONE);
                    anc1_general_Deranged.setVisibility (View.GONE);
                    anc1_vitals.setVisibility (View.GONE);
                    anc1_invest_bloodsugar.setVisibility (View.GONE);
                    anc1_history.setVisibility (View.GONE);
                    anc1_examination.setVisibility (View.GONE);
                    anc1_examinationGen.setVisibility (View.GONE);
                    anc1_anthropometry.setVisibility (View.GONE);
                    anc1_NTscan.setVisibility (View.GONE);
                    anc1_investDual.setVisibility (View.GONE);

                }
            }
        });

        anc_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    anc2_his_linearBox.setVisibility (View.VISIBLE);
                    anc2_exam_linearBox.setVisibility (View.VISIBLE);
                    anc2_invest_linearBox.setVisibility (View.VISIBLE);
                    anc2_advice_linearBox.setVisibility (View.VISIBLE);
                    anc2_his_breath.setVisibility (View.VISIBLE);
                    anc2_his_fatigue.setVisibility (View.VISIBLE);
                    anc2_his_head.setVisibility (View.VISIBLE);
                    anc2_his_bleed.setVisibility (View.VISIBLE);
                    anc2_his_burn.setVisibility (View.VISIBLE);
                    anc2_his_quick_percieve.setVisibility (View.VISIBLE);
                    anc2_exam_pallor.setVisibility (View.VISIBLE);
                    anc2_exam_pedal.setVisibility (View.VISIBLE);
                    anc2_exam_pa.setVisibility (View.VISIBLE);
                    anc2_invest_quad.setVisibility (View.VISIBLE);
                    anc2_invest_fetal.setVisibility (View.VISIBLE);
                    anc2_advice_OGTT.setVisibility (View.VISIBLE);
                    anc2_advice_TFe.setVisibility (View.VISIBLE);
                    anc2_advice_TCa.setVisibility (View.VISIBLE);
                    anc2_advice_Hb_Talb.setVisibility (View.VISIBLE);
                    anc2_advice_Hb_TFe.setVisibility (View.VISIBLE);
                    anc2_advice_TCa.setVisibility (View.VISIBLE);
                    anc2_advice_Hb_Talb.setVisibility (View.VISIBLE);
                    anc2_advice_Hb_peri.setVisibility (View.VISIBLE);
                    anc2_advice_Hb_serum.setVisibility (View.VISIBLE);
                    anc2_advice_tetanus.setVisibility (View.VISIBLE);
                    anc_2_pa_2weeks.setVisibility (View.VISIBLE);
                    anc2_POG.setVisibility (View.VISIBLE);
                    anc2_his_others.setVisibility (View.VISIBLE);
                    anc2_exam_PR.setVisibility (View.VISIBLE);
                    anc2_exam_BP.setVisibility (View.VISIBLE);
                    anc2_exam_weight.setVisibility (View.VISIBLE);
                    anc2_exam_others.setVisibility (View.VISIBLE);
                    anc2_invest_others.setVisibility (View.VISIBLE);
                    anc2_advice_nutri.setVisibility (View.VISIBLE);
                    anc2_advice_general.setVisibility (View.VISIBLE);
                    anc2_advice_common.setVisibility (View.VISIBLE);
                    anc2_advice_others.setVisibility (View.VISIBLE);
                    anc_2_POG_box.setVisibility (View.VISIBLE);
                    anc2_his_othersBox.setVisibility (View.VISIBLE);
                    anc_2_exam_PRBox.setVisibility (View.VISIBLE);
                    anc2_exam_BPBox.setVisibility (View.VISIBLE);
                    anc2_exam_weightBox.setVisibility (View.VISIBLE);
                    anc2_exam_othersBox.setVisibility (View.VISIBLE);
                    anc_2_invest_othersBox.setVisibility (View.VISIBLE);
                    anc2_advice_nutriBox.setVisibility (View.VISIBLE);
                    anc2_advice_generalBox.setVisibility (View.VISIBLE);
                    anc2_advice_commonBox.setVisibility (View.VISIBLE);
                    anc2_advice_othersBox.setVisibility (View.VISIBLE);
                    anc_2_history.setVisibility (View.VISIBLE);
                    anc_2_examination.setVisibility (View.VISIBLE);
                    anc2_investigationBox.setVisibility (View.VISIBLE);
                    anc_2_adviceBox.setVisibility (View.VISIBLE);
                    anc2_common_ailment_ifHbBox.setVisibility (View.VISIBLE);
                    anc2_advice_Hb_HPLC.setVisibility (View.VISIBLE);



                } else {
                    anc2_his_linearBox.setVisibility (View.GONE);
                    anc2_exam_linearBox.setVisibility (View.GONE);
                    anc2_invest_linearBox.setVisibility (View.GONE);
                    anc2_advice_linearBox.setVisibility (View.GONE);
                    anc2_his_breath.setVisibility (View.GONE);
                    anc2_his_fatigue.setVisibility (View.GONE);
                    anc2_his_head.setVisibility (View.GONE);
                    anc2_his_bleed.setVisibility (View.GONE);
                    anc2_his_burn.setVisibility (View.GONE);
                    anc2_his_quick_percieve.setVisibility (View.GONE);
                    anc2_exam_pallor.setVisibility (View.GONE);
                    anc2_exam_pedal.setVisibility (View.GONE);
                    anc2_exam_pa.setVisibility (View.GONE);
                    anc2_invest_quad.setVisibility (View.GONE);
                    anc2_invest_fetal.setVisibility (View.GONE);
                    anc2_advice_OGTT.setVisibility (View.GONE);
                    anc2_advice_TFe.setVisibility (View.GONE);
                    anc2_advice_TCa.setVisibility (View.GONE);
                    anc2_advice_Hb_Talb.setVisibility (View.GONE);
                    anc2_advice_Hb_TFe.setVisibility (View.GONE);
                    anc2_advice_TCa.setVisibility (View.GONE);
                    anc2_advice_Hb_Talb.setVisibility (View.GONE);
                    anc2_advice_Hb_peri.setVisibility (View.GONE);
                    anc2_advice_Hb_serum.setVisibility (View.GONE);
                    anc2_advice_tetanus.setVisibility (View.GONE);
                    anc_2_pa_2weeks.setVisibility (View.GONE);
                    anc2_POG.setVisibility (View.GONE);
                    anc2_his_others.setVisibility (View.GONE);
                    anc2_exam_PR.setVisibility (View.GONE);
                    anc2_exam_BP.setVisibility (View.GONE);
                    anc2_exam_weight.setVisibility (View.GONE);
                    anc2_exam_others.setVisibility (View.GONE);
                    anc2_invest_others.setVisibility (View.GONE);
                    anc2_advice_nutri.setVisibility (View.GONE);
                    anc2_advice_general.setVisibility (View.GONE);
                    anc2_advice_common.setVisibility (View.GONE);
                    anc2_advice_others.setVisibility (View.GONE);
                    anc_2_POG_box.setVisibility (View.GONE);
                    anc2_his_othersBox.setVisibility (View.GONE);
                    anc_2_exam_PRBox.setVisibility (View.GONE);
                    anc2_exam_BPBox.setVisibility (View.GONE);
                    anc2_exam_weightBox.setVisibility (View.GONE);
                    anc2_exam_othersBox.setVisibility (View.GONE);
                    anc_2_invest_othersBox.setVisibility (View.GONE);
                    anc2_advice_nutriBox.setVisibility (View.GONE);
                    anc2_advice_generalBox.setVisibility (View.GONE);
                    anc2_advice_commonBox.setVisibility (View.GONE);
                    anc2_advice_othersBox.setVisibility (View.GONE);
                    anc_2_history.setVisibility (View.GONE);
                    anc_2_examination.setVisibility (View.GONE);
                    anc2_investigationBox.setVisibility (View.GONE);
                    anc_2_adviceBox.setVisibility (View.GONE);
                    anc2_common_ailment_ifHbBox.setVisibility (View.GONE);
                    anc2_advice_Hb_HPLC.setVisibility (View.GONE);


                }
                }
        });

        anc_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    anc3_invest_linearBox.setVisibility (View.VISIBLE);
                    anc3_his_linearBox.setVisibility (View.VISIBLE);
                    anc3_exam_linearBox.setVisibility (View.VISIBLE);
                    anc3_advice_linearBox.setVisibility (View.VISIBLE);
                    anc3_his_othersBox.setVisibility (View.VISIBLE);
                    anc3_exam_PRBox.setVisibility (View.VISIBLE);
                    anc3_exam_BPBox.setVisibility (View.VISIBLE);
                    anc3_exam_weightBox.setVisibility (View.VISIBLE);
                    anc3_exam_othersBox.setVisibility (View.VISIBLE);
                    anc3_advice_nutriBox.setVisibility (View.VISIBLE);
                    anc3_advice_generalBox.setVisibility (View.VISIBLE);
                    anc3_advice_commonBox.setVisibility (View.VISIBLE);
                    anc3_advice_othersBox.setVisibility (View.VISIBLE);
                    anc3_historyBox.setVisibility (View.VISIBLE);
                    Anc_3_examinationBox.setVisibility (View.VISIBLE);
                    anc_3_investigationsBox.setVisibility (View.VISIBLE);
                    anc_3_GTTBox.setVisibility (View.VISIBLE);
                    anc3_investigation_othersbox.setVisibility (View.VISIBLE);
                    anc3_investigation_others.setVisibility (View.VISIBLE);
                    anc_3_adviceBox.setVisibility (View.VISIBLE);
                    anc_3_inj_antiDBox.setVisibility (View.VISIBLE);
                    anc3_his_breath.setVisibility (View.VISIBLE);
                    anc3_his_fatigue.setVisibility (View.VISIBLE);
                    anc3_his_head.setVisibility (View.VISIBLE);
                    anc3_his_bleed.setVisibility (View.VISIBLE);
                    anc3_his_leak.setVisibility (View.VISIBLE);
                    anc3_his_burn.setVisibility (View.VISIBLE);
                    anc3_his_fetal_move.setVisibility (View.VISIBLE);
                    anc3_his_itching.setVisibility (View.VISIBLE);
                    anc3_exam_pallor.setVisibility (View.VISIBLE);
                    anc3_exam_pedal.setVisibility (View.VISIBLE);
                    anc3_exam_pa.setVisibility (View.VISIBLE);
                    anc_3_pa_2weeks.setVisibility (View.VISIBLE);
                    anc3_invest_GTT_fast.setVisibility (View.VISIBLE);
                    anc3_invest_GTT_1hr.setVisibility (View.VISIBLE);
                    anc3_invest_GTT_2hr.setVisibility (View.VISIBLE);
                    anc3_invest_CBC.setVisibility (View.VISIBLE);
                    anc3_invest_urine.setVisibility (View.VISIBLE);
                    anc3_invest_ICT.setVisibility (View.VISIBLE);
                    anc3_advice_TFe.setVisibility (View.VISIBLE);
                    anc3_advice_DFMC.setVisibility (View.VISIBLE);
                    anc3_advice_BleedPV.setVisibility (View.VISIBLE);
                    anc3_advice_spotPV.setVisibility (View.VISIBLE);
                    anc3_advice_leakPV.setVisibility (View.VISIBLE);
                    anc3_advice_fetalmove.setVisibility (View.VISIBLE);
                    anc3_advice_abdpain.setVisibility (View.VISIBLE);
                    anc3_advice_injAntiD.setVisibility (View.VISIBLE);
                    anc3_his_others.setVisibility (View.VISIBLE);
                    anc3_exam_PR.setVisibility (View.VISIBLE);
                    anc3_exam_BP.setVisibility (View.VISIBLE);
                    anc3_exam_weight.setVisibility (View.VISIBLE);
                    anc3_exam_others.setVisibility (View.VISIBLE);
                    anc3_advice_nutri.setVisibility (View.VISIBLE);
                    anc3_advice_general.setVisibility (View.VISIBLE);
                    anc3_advice_common.setVisibility (View.VISIBLE);
                    anc3_advice_others.setVisibility (View.VISIBLE);
                    anc_3_reviewBox.setVisibility (View.VISIBLE);

                } else {
                    anc3_invest_linearBox.setVisibility (View.GONE);
                    anc3_his_linearBox.setVisibility (View.GONE);
                    anc3_exam_linearBox.setVisibility (View.GONE);
                    anc3_advice_linearBox.setVisibility (View.GONE);
                    anc3_his_othersBox.setVisibility (View.GONE);
                    anc3_exam_PRBox.setVisibility (View.GONE);
                    anc3_exam_BPBox.setVisibility (View.GONE);
                    anc3_exam_weightBox.setVisibility (View.GONE);
                    anc3_exam_othersBox.setVisibility (View.GONE);
                    anc3_advice_nutriBox.setVisibility (View.GONE);
                    anc3_advice_generalBox.setVisibility (View.GONE);
                    anc3_advice_commonBox.setVisibility (View.GONE);
                    anc3_advice_othersBox.setVisibility (View.GONE);
                    anc3_historyBox.setVisibility (View.GONE);
                    Anc_3_examinationBox.setVisibility (View.GONE);
                    anc_3_investigationsBox.setVisibility (View.GONE);
                    anc_3_GTTBox.setVisibility (View.GONE);
                    anc_3_adviceBox.setVisibility (View.GONE);
                    anc_3_inj_antiDBox.setVisibility (View.GONE);
                    anc3_his_breath.setVisibility (View.GONE);
                    anc3_investigation_othersbox.setVisibility (View.GONE);
                    anc3_investigation_others.setVisibility (View.GONE);
                    anc3_his_fatigue.setVisibility (View.GONE);
                    anc3_his_head.setVisibility (View.GONE);
                    anc3_his_bleed.setVisibility (View.GONE);
                    anc3_his_leak.setVisibility (View.GONE);
                    anc3_his_burn.setVisibility (View.GONE);
                    anc3_his_fetal_move.setVisibility (View.GONE);
                    anc3_his_itching.setVisibility (View.GONE);
                    anc3_exam_pallor.setVisibility (View.GONE);
                    anc3_exam_pedal.setVisibility (View.GONE);
                    anc3_exam_pa.setVisibility (View.GONE);
                    anc_3_pa_2weeks.setVisibility (View.GONE);
                    anc3_invest_GTT_fast.setVisibility (View.GONE);
                    anc3_invest_GTT_1hr.setVisibility (View.GONE);
                    anc3_invest_GTT_2hr.setVisibility (View.GONE);
                    anc3_invest_CBC.setVisibility (View.GONE);
                    anc3_invest_urine.setVisibility (View.GONE);
                    anc3_invest_ICT.setVisibility (View.GONE);
                    anc3_advice_TFe.setVisibility (View.GONE);
                    anc3_advice_DFMC.setVisibility (View.GONE);
                    anc3_advice_BleedPV.setVisibility (View.GONE);
                    anc3_advice_spotPV.setVisibility (View.GONE);
                    anc3_advice_leakPV.setVisibility (View.GONE);
                    anc3_advice_fetalmove.setVisibility (View.GONE);
                    anc3_advice_abdpain.setVisibility (View.GONE);
                    anc3_advice_injAntiD.setVisibility (View.GONE);
                    anc3_his_others.setVisibility (View.GONE);
                    anc3_exam_PR.setVisibility (View.GONE);
                    anc3_exam_BP.setVisibility (View.GONE);
                    anc3_exam_weight.setVisibility (View.GONE);
                    anc3_exam_others.setVisibility (View.GONE);
                    anc3_advice_nutri.setVisibility (View.GONE);
                    anc3_advice_general.setVisibility (View.GONE);
                    anc3_advice_common.setVisibility (View.GONE);
                    anc3_advice_others.setVisibility (View.GONE);
                    anc_3_reviewBox.setVisibility (View.GONE);

                }
            }
        });


        anc_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    anc4_his_linearBox.setVisibility (View.VISIBLE);
                    anc4_exam_linearBox.setVisibility (View.VISIBLE);
                    anc4_advice_linearBox.setVisibility (View.VISIBLE);
                    anc4_his_breath.setVisibility (View.VISIBLE);
                    anc4_his_othersBox.setVisibility (View.VISIBLE);
                    anc4_his_fatigue.setVisibility (View.VISIBLE);
                    anc4_his_head.setVisibility (View.VISIBLE);
                    anc4_his_bleed.setVisibility (View.VISIBLE);
                    anc4_his_burn.setVisibility (View.VISIBLE);
                    anc4_his_fetal_move.setVisibility (View.VISIBLE);
                    anc4_his_itching.setVisibility (View.VISIBLE);
                    anc4_exam_pallor.setVisibility (View.VISIBLE);
                    anc4_exam_pedal.setVisibility (View.VISIBLE);
                    anc4_exam_pa.setVisibility (View.VISIBLE);
                    anc_4_pa_2weeks.setVisibility (View.VISIBLE);
                    anc4_advice_TFe.setVisibility (View.VISIBLE);
                    anc4_advice_TCa.setVisibility (View.VISIBLE);
                    anc4_advice_DFMC.setVisibility (View.VISIBLE);
                    anc4_advice_BleedPV.setVisibility (View.VISIBLE);
                    anc4_advice_spotPV.setVisibility (View.VISIBLE);
                    anc4_advice_leakPV.setVisibility (View.VISIBLE);
                    anc4_advice_fetalmove.setVisibility (View.VISIBLE);
                    anc4_advice_abdpain.setVisibility (View.VISIBLE);
                    anc4_advice_USG.setVisibility (View.VISIBLE);
                    anc4_his_others.setVisibility (View.VISIBLE);
                    anc4_exam_PR.setVisibility (View.VISIBLE);
                    anc4_exam_BP.setVisibility (View.VISIBLE);
                    anc4_exam_weight.setVisibility (View.VISIBLE);
                    anc4_exam_others.setVisibility (View.VISIBLE);
                    anc4_advice_nutri.setVisibility (View.VISIBLE);
                    anc4_advice_general.setVisibility (View.VISIBLE);
                    anc4_advice_common.setVisibility (View.VISIBLE);
                    anc4_advice_others.setVisibility (View.VISIBLE);
                    anc4_his_othersBox.setVisibility (View.VISIBLE);
                    anc4_exam_PRBox.setVisibility (View.VISIBLE);
                    anc4_exam_BPBox.setVisibility (View.VISIBLE);
                    anc4_exam_weightBox.setVisibility (View.VISIBLE);
                    anc4_exam_othersBox.setVisibility (View.VISIBLE);
                    anc4_advice_nutriBox.setVisibility (View.VISIBLE);
                    anc4_advice_generalBox.setVisibility (View.VISIBLE);
                    anc4_advice_commonBox.setVisibility (View.VISIBLE);
                    anc4_advice_othersBox.setVisibility (View.VISIBLE);
                    anc_4_historyBox.setVisibility (View.VISIBLE);
                    ANC_4_examinationBox.setVisibility (View.VISIBLE);
                    anc_4_adviceBox.setVisibility (View.VISIBLE);
                    anc_4_reviewBox.setVisibility (View.VISIBLE);


                } else {
                    anc4_his_linearBox.setVisibility (View.GONE);
                    anc4_exam_linearBox.setVisibility (View.GONE);
                    anc4_advice_linearBox.setVisibility (View.GONE);
                    anc4_his_breath.setVisibility (View.GONE);
                    anc4_his_othersBox.setVisibility (View.GONE);
                    anc4_his_fatigue.setVisibility (View.GONE);
                    anc4_his_head.setVisibility (View.GONE);
                    anc4_his_bleed.setVisibility (View.GONE);
                    anc4_his_burn.setVisibility (View.GONE);
                    anc4_his_fetal_move.setVisibility (View.GONE);
                    anc4_his_itching.setVisibility (View.GONE);
                    anc4_exam_pallor.setVisibility (View.GONE);
                    anc4_exam_pedal.setVisibility (View.GONE);
                    anc4_exam_pa.setVisibility (View.GONE);
                    anc_4_pa_2weeks.setVisibility (View.GONE);
                    anc4_advice_TFe.setVisibility (View.GONE);
                    anc4_advice_TCa.setVisibility (View.GONE);
                    anc4_advice_DFMC.setVisibility (View.GONE);
                    anc4_advice_BleedPV.setVisibility (View.GONE);
                    anc4_advice_spotPV.setVisibility (View.GONE);
                    anc4_advice_leakPV.setVisibility (View.GONE);
                    anc4_advice_fetalmove.setVisibility (View.GONE);
                    anc4_advice_abdpain.setVisibility (View.GONE);
                    anc4_advice_USG.setVisibility (View.GONE);
                    anc4_his_others.setVisibility (View.GONE);
                    anc4_exam_PR.setVisibility (View.GONE);
                    anc4_exam_BP.setVisibility (View.GONE);
                    anc4_exam_weight.setVisibility (View.GONE);
                    anc4_exam_others.setVisibility (View.GONE);
                    anc4_advice_nutri.setVisibility (View.GONE);
                    anc4_advice_general.setVisibility (View.GONE);
                    anc4_advice_common.setVisibility (View.GONE);
                    anc4_advice_others.setVisibility (View.GONE);
                    anc4_his_othersBox.setVisibility (View.GONE);
                    anc4_exam_PRBox.setVisibility (View.GONE);
                    anc4_exam_BPBox.setVisibility (View.GONE);
                    anc4_exam_weightBox.setVisibility (View.GONE);
                    anc4_exam_othersBox.setVisibility (View.GONE);
                    anc4_advice_nutriBox.setVisibility (View.GONE);
                    anc4_advice_generalBox.setVisibility (View.GONE);
                    anc4_advice_commonBox.setVisibility (View.GONE);
                    anc4_advice_othersBox.setVisibility (View.GONE);
                    anc_4_historyBox.setVisibility (View.GONE);
                    ANC_4_examinationBox.setVisibility (View.GONE);
                    anc_4_adviceBox.setVisibility (View.GONE);
                    anc_4_reviewBox.setVisibility (View.GONE);

                }
            }
        });

        anc_5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    anc5_USG_linearBox.setVisibility (View.VISIBLE);
                    anc5_his_linearBox.setVisibility (View.VISIBLE);
                    anc5_exam_linearBox.setVisibility (View.VISIBLE);
                    anc5_invest_linearBox.setVisibility (View.VISIBLE);
                    anc5_advice_linearBox.setVisibility (View.VISIBLE);
                    anc5_his_others.setVisibility (View.VISIBLE);
                    anc5_his_timing.setVisibility (View.VISIBLE);
                    anc5_exam_PR.setVisibility (View.VISIBLE);
                    anc5_exam_BP.setVisibility (View.VISIBLE);
                    anc5_exam_weight.setVisibility (View.VISIBLE);
                    anc5_exam_others.setVisibility (View.VISIBLE);
                    anc5_invest_others.setVisibility (View.VISIBLE);
                    anc5_USG_BPD_cm.setVisibility (View.VISIBLE);
                    anc5_USG_BPD_weeks.setVisibility (View.VISIBLE);
                    anc5_USG_BPD_centile.setVisibility (View.VISIBLE);
                    anc5_USG_HC_cm.setVisibility (View.VISIBLE);
                    anc5_USG_HC_weeks.setVisibility (View.VISIBLE);
                    anc5_USG_HC_centile.setVisibility (View.VISIBLE);
                    anc5_USG_AC_cm.setVisibility (View.VISIBLE);
                    anc5_USG_AC_weeks.setVisibility (View.VISIBLE);
                    anc5_USG_AC_centile.setVisibility (View.VISIBLE);
                    anc5_USG_FL_cm.setVisibility (View.VISIBLE);
                    anc5_USG_FL_weeks.setVisibility (View.VISIBLE);
                    anc5_USG_FL_centile.setVisibility (View.VISIBLE);
                    anc5_USG_EFW_gm.setVisibility (View.VISIBLE);
                    anc5_USG_EFW_weeks.setVisibility (View.VISIBLE);
                    anc5_USG_EFW_centile.setVisibility (View.VISIBLE);
                    anc5_USG_liquor_SLP.setVisibility (View.VISIBLE);
                    anc5_USG_liquor_AFI.setVisibility (View.VISIBLE);
                    anc5_USG_UAPI.setVisibility (View.VISIBLE);
                    anc5_USG_UAPI_centile.setVisibility (View.VISIBLE);
                    anc5_USG_MCAPI.setVisibility (View.VISIBLE);
                    anc5_USG_MCAPI_centile.setVisibility (View.VISIBLE);
                    anc5_advice_nutri.setVisibility (View.VISIBLE);
                    anc5_advice_general.setVisibility (View.VISIBLE);
                    anc5_advice_common.setVisibility (View.VISIBLE);
                    anc5_advice_others.setVisibility (View.VISIBLE);
                    anc5_his_othersBox.setVisibility (View.VISIBLE);
                    anc5_his_timingBox.setVisibility (View.VISIBLE);
                    anc5_exam_PRBox.setVisibility (View.VISIBLE);
                    anc5_exam_BPBox.setVisibility (View.VISIBLE);
                    anc5_exam_weightBox.setVisibility (View.VISIBLE);
                    anc5_exam_othersBox .setVisibility (View.VISIBLE);
                    anc5_invest_othersBox.setVisibility (View.VISIBLE);
                    anc5_USG_BPDBox.setVisibility (View.VISIBLE);
                    anc5_USG_HCBox.setVisibility (View.VISIBLE);
                    anc5_USG_ACBox.setVisibility (View.VISIBLE);
                    anc5_USG_FLBox.setVisibility (View.VISIBLE);
                    anc5_USG_EFWBox.setVisibility (View.VISIBLE);
                    anc5_USG_liquorBox.setVisibility (View.VISIBLE);
                    anc5_USG_UAPIBox.setVisibility (View.VISIBLE);
                    anc5_USG_MCAPIBox.setVisibility (View.VISIBLE);
                    anc5_advice_nutriBox.setVisibility (View.VISIBLE);
                    anc5_advice_generalBox.setVisibility (View.VISIBLE);
                    anc5_advice_commonBox.setVisibility (View.VISIBLE);
                    anc_5_reviewBox.setVisibility (View.VISIBLE);
                    anc5_advice_othersBox.setVisibility (View.VISIBLE);
                    anc5_historyBox.setVisibility (View.VISIBLE);
                    anc5_counsellingBox.setVisibility (View.VISIBLE);
                    anc5_modeOfDeliveryBox.setVisibility (View.VISIBLE);
                    anc5_examinationBox.setVisibility (View.VISIBLE);
                    anc5_investigationBox.setVisibility (View.VISIBLE);
                    anc5_USGBox.setVisibility (View.VISIBLE);
                    anc_5_adviceBox.setVisibility (View.VISIBLE);
                    anc5_his_breath.setVisibility (View.VISIBLE);
                    anc5_his_fatigue.setVisibility (View.VISIBLE);
                    anc5_his_head.setVisibility (View.VISIBLE);
                    anc5_his_bleed.setVisibility (View.VISIBLE);
                    anc5_his_burn.setVisibility (View.VISIBLE);
                    anc5_his_fetal_move.setVisibility (View.VISIBLE);
                    anc5_his_itching.setVisibility (View.VISIBLE);
                    anc5_his_vaginal_del.setVisibility (View.VISIBLE);
                    anc5_his_LSCS_del.setVisibility (View.VISIBLE);
                    anc5_his_birth_attendant.setVisibility (View.VISIBLE);
                    anc5_exam_pallor.setVisibility (View.VISIBLE);
                    anc5_exam_pedal .setVisibility (View.VISIBLE);
                    anc5_exam_pa.setVisibility (View.VISIBLE);
                    anc5_pa_2weeks.setVisibility (View.VISIBLE);
                    anc5_invest_CBC.setVisibility (View.VISIBLE);
                    anc5_invest_LFT.setVisibility (View.VISIBLE);
                    anc5_invest_KFT.setVisibility (View.VISIBLE);
                    anc5_invest_CPR.setVisibility (View.VISIBLE);
                    anc5_advice_DFMC.setVisibility (View.VISIBLE);
                    anc5_advice_TFe_Ca.setVisibility (View.VISIBLE);
                    anc5_advice_BleedPV.setVisibility (View.VISIBLE);
                    anc5_advice_spotPV.setVisibility (View.VISIBLE);
                    anc5_advice_leakPV .setVisibility (View.VISIBLE);
                    anc5_advice_fetalmove.setVisibility (View.VISIBLE);
                    anc5_advice_abdpain.setVisibility (View.VISIBLE);
                    anc5_advice_NST.setVisibility (View.VISIBLE);


                } else {
                    anc5_USG_linearBox.setVisibility (View.GONE);
                    anc5_his_linearBox.setVisibility (View.GONE);
                    anc5_exam_linearBox.setVisibility (View.GONE);
                    anc5_invest_linearBox.setVisibility (View.GONE);
                    anc5_advice_linearBox.setVisibility (View.GONE);
                    anc5_his_others.setVisibility (View.GONE);
                    anc5_his_timing.setVisibility (View.GONE);
                    anc5_exam_PR.setVisibility (View.GONE);
                    anc5_exam_BP.setVisibility (View.GONE);
                    anc5_exam_weight.setVisibility (View.GONE);
                    anc5_exam_others.setVisibility (View.GONE);
                    anc5_invest_others.setVisibility (View.GONE);
                    anc5_USG_BPD_cm.setVisibility (View.GONE);
                    anc5_USG_BPD_weeks.setVisibility (View.GONE);
                    anc5_USG_BPD_centile.setVisibility (View.GONE);
                    anc5_USG_HC_cm.setVisibility (View.GONE);
                    anc5_USG_HC_weeks.setVisibility (View.GONE);
                    anc5_USG_HC_centile.setVisibility (View.GONE);
                    anc5_USG_AC_cm.setVisibility (View.GONE);
                    anc5_USG_AC_weeks.setVisibility (View.GONE);
                    anc5_USG_AC_centile.setVisibility (View.GONE);
                    anc5_USG_FL_cm.setVisibility (View.GONE);
                    anc5_USG_FL_weeks.setVisibility (View.GONE);
                    anc5_USG_FL_centile.setVisibility (View.GONE);
                    anc5_USG_EFW_gm.setVisibility (View.GONE);
                    anc5_USG_EFW_weeks.setVisibility (View.GONE);
                    anc5_USG_EFW_centile.setVisibility (View.GONE);
                    anc5_USG_liquor_SLP.setVisibility (View.GONE);
                    anc5_USG_liquor_AFI.setVisibility (View.GONE);
                    anc5_USG_UAPI.setVisibility (View.GONE);
                    anc5_USG_UAPI_centile.setVisibility (View.GONE);
                    anc5_USG_MCAPI.setVisibility (View.GONE);
                    anc5_USG_MCAPI_centile.setVisibility (View.GONE);
                    anc5_advice_nutri.setVisibility (View.GONE);
                    anc5_advice_general.setVisibility (View.GONE);
                    anc5_advice_common.setVisibility (View.GONE);
                    anc5_advice_others.setVisibility (View.GONE);
                    anc5_his_othersBox.setVisibility (View.GONE);
                    anc5_his_timingBox.setVisibility (View.GONE);
                    anc5_exam_PRBox.setVisibility (View.GONE);
                    anc5_exam_BPBox.setVisibility (View.GONE);
                    anc5_exam_weightBox.setVisibility (View.GONE);
                    anc5_exam_othersBox .setVisibility (View.GONE);
                    anc5_invest_othersBox.setVisibility (View.GONE);
                    anc5_USG_BPDBox.setVisibility (View.GONE);
                    anc5_USG_HCBox.setVisibility (View.GONE);
                    anc5_USG_ACBox.setVisibility (View.GONE);
                    anc5_USG_FLBox.setVisibility (View.GONE);
                    anc5_USG_EFWBox.setVisibility (View.GONE);
                    anc5_USG_liquorBox.setVisibility (View.GONE);
                    anc5_USG_UAPIBox.setVisibility (View.GONE);
                    anc5_USG_MCAPIBox.setVisibility (View.GONE);
                    anc5_advice_nutriBox.setVisibility (View.GONE);
                    anc5_advice_generalBox.setVisibility (View.GONE);
                    anc5_advice_commonBox.setVisibility (View.GONE);
                    anc_5_reviewBox.setVisibility (View.GONE);
                    anc5_advice_othersBox.setVisibility (View.GONE);
                    anc5_historyBox.setVisibility (View.GONE);
                    anc5_counsellingBox.setVisibility (View.GONE);
                    anc5_modeOfDeliveryBox.setVisibility (View.GONE);
                    anc5_examinationBox.setVisibility (View.GONE);
                    anc5_investigationBox.setVisibility (View.GONE);
                    anc5_USGBox.setVisibility (View.GONE);
                    anc_5_adviceBox.setVisibility (View.GONE);
                    anc5_his_breath.setVisibility (View.GONE);
                    anc5_his_fatigue.setVisibility (View.GONE);
                    anc5_his_head.setVisibility (View.GONE);
                    anc5_his_bleed.setVisibility (View.GONE);
                    anc5_his_burn.setVisibility (View.GONE);
                    anc5_his_fetal_move.setVisibility (View.GONE);
                    anc5_his_itching.setVisibility (View.GONE);
                    anc5_his_vaginal_del.setVisibility (View.GONE);
                    anc5_his_LSCS_del.setVisibility (View.GONE);
                    anc5_his_birth_attendant.setVisibility (View.GONE);
                    anc5_exam_pallor.setVisibility (View.GONE);
                    anc5_exam_pedal .setVisibility (View.GONE);
                    anc5_exam_pa.setVisibility (View.GONE);
                    anc5_pa_2weeks.setVisibility (View.GONE);
                    anc5_invest_CBC.setVisibility (View.GONE);
                    anc5_invest_LFT.setVisibility (View.GONE);
                    anc5_invest_KFT.setVisibility (View.GONE);
                    anc5_invest_CPR.setVisibility (View.GONE);
                    anc5_advice_DFMC.setVisibility (View.GONE);
                    anc5_advice_TFe_Ca.setVisibility (View.GONE);
                    anc5_advice_BleedPV.setVisibility (View.GONE);
                    anc5_advice_spotPV.setVisibility (View.GONE);
                    anc5_advice_leakPV .setVisibility (View.GONE);
                    anc5_advice_fetalmove.setVisibility (View.GONE);
                    anc5_advice_abdpain.setVisibility (View.GONE);
                    anc5_advice_NST.setVisibility (View.GONE);

                }
            }
        });

        anc_6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    anc6_his_linearBox.setVisibility (View.VISIBLE);
                    anc6_exam_linearBox.setVisibility (View.VISIBLE);
                    anc6_advice_linearBox.setVisibility (View.VISIBLE);
                    anc6_his_others.setVisibility (View.VISIBLE);
                    anc6_exam_PR.setVisibility (View.VISIBLE);
                    anc6_exam_BP.setVisibility (View.VISIBLE);
                    anc6_exam_weight.setVisibility (View.VISIBLE);
                    anc6_exam_others.setVisibility (View.VISIBLE);
                    anc6_exam_pelvic.setVisibility (View.VISIBLE);
                    anc6_advice_others.setVisibility (View.VISIBLE);
                    anc6_his_othersBox.setVisibility (View.VISIBLE);
                    anc6_exam_PRBox.setVisibility (View.VISIBLE);
                    anc6_exam_BPBox.setVisibility (View.VISIBLE);
                    anc6_exam_weightBox.setVisibility (View.VISIBLE);
                    anc6_exam_othersBox.setVisibility (View.VISIBLE);
                    anc6_exam_pelvicBox.setVisibility (View.VISIBLE);
                    anc6_advice_othersBox.setVisibility (View.VISIBLE);
                    anc_6_historyBox.setVisibility (View.VISIBLE);
                    anc_6_examinationBox.setVisibility (View.VISIBLE);
                    anc_6_adviceBox.setVisibility (View.VISIBLE);
                    anc_6_reviewBox.setVisibility (View.VISIBLE);
                    anc6_his_breath.setVisibility (View.VISIBLE);
                    anc6_his_fatigue.setVisibility (View.VISIBLE);
                    anc6_his_head.setVisibility (View.VISIBLE);
                    anc6_his_bleed.setVisibility (View.VISIBLE);
                    anc6_his_burn.setVisibility (View.VISIBLE);
                    anc6_his_fetal_move.setVisibility (View.VISIBLE);
                    anc6_his_itching.setVisibility (View.VISIBLE);
                    anc6_exam_pallor.setVisibility (View.VISIBLE);
                    anc6_exam_pedal.setVisibility (View.VISIBLE);
                    anc6_exam_pa.setVisibility (View.VISIBLE);
                    anc6_pa_2weeks.setVisibility (View.VISIBLE);
                    anc6_advice_DFMC.setVisibility (View.VISIBLE);
                    anc6_advice_TFe_Ca.setVisibility (View.VISIBLE);
                    anc6_advice_BleedPV.setVisibility (View.VISIBLE);
                    anc6_advice_spotPV.setVisibility (View.VISIBLE);
                    anc6_advice_leakPV.setVisibility (View.VISIBLE);
                    anc6_advice_fetalmove.setVisibility (View.VISIBLE);
                    anc6_advice_abdpain.setVisibility (View.VISIBLE);
                    anc6_advice_NST.setVisibility (View.VISIBLE);

                } else {
                    anc6_his_linearBox.setVisibility (View.GONE);
                    anc6_exam_linearBox.setVisibility (View.GONE);
                    anc6_advice_linearBox.setVisibility (View.GONE);
                    anc6_his_others.setVisibility (View.GONE);
                    anc6_exam_PR.setVisibility (View.GONE);
                    anc6_exam_BP.setVisibility (View.GONE);
                    anc6_exam_weight.setVisibility (View.GONE);
                    anc6_exam_others.setVisibility (View.GONE);
                    anc6_exam_pelvic.setVisibility (View.GONE);
                    anc6_advice_others.setVisibility (View.GONE);
                    anc6_his_othersBox.setVisibility (View.GONE);
                    anc6_exam_PRBox.setVisibility (View.GONE);
                    anc6_exam_BPBox.setVisibility (View.GONE);
                    anc6_exam_weightBox.setVisibility (View.GONE);
                    anc6_exam_othersBox.setVisibility (View.GONE);
                    anc6_exam_pelvicBox.setVisibility (View.GONE);
                    anc6_advice_othersBox.setVisibility (View.GONE);
                    anc_6_historyBox.setVisibility (View.GONE);
                    anc_6_examinationBox.setVisibility (View.GONE);
                    anc_6_adviceBox.setVisibility (View.GONE);
                    anc_6_reviewBox.setVisibility (View.GONE);
                    anc6_his_breath.setVisibility (View.GONE);
                    anc6_his_fatigue.setVisibility (View.GONE);
                    anc6_his_head.setVisibility (View.GONE);
                    anc6_his_bleed.setVisibility (View.GONE);
                    anc6_his_burn.setVisibility (View.GONE);
                    anc6_his_fetal_move.setVisibility (View.GONE);
                    anc6_his_itching.setVisibility (View.GONE);
                    anc6_exam_pallor.setVisibility (View.GONE);
                    anc6_exam_pedal.setVisibility (View.GONE);
                    anc6_exam_pa.setVisibility (View.GONE);
                    anc6_pa_2weeks.setVisibility (View.GONE);
                    anc6_advice_DFMC.setVisibility (View.GONE);
                    anc6_advice_TFe_Ca.setVisibility (View.GONE);
                    anc6_advice_BleedPV.setVisibility (View.GONE);
                    anc6_advice_spotPV.setVisibility (View.GONE);
                    anc6_advice_leakPV.setVisibility (View.GONE);
                    anc6_advice_fetalmove.setVisibility (View.GONE);
                    anc6_advice_abdpain.setVisibility (View.GONE);
                    anc6_advice_NST.setVisibility (View.GONE);

                }
            }
        });


        anc_7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    anc7_his_linearBox.setVisibility (View.VISIBLE);
                    anc7_exam_linearBox.setVisibility (View.VISIBLE);
                    anc7_advice_linearBox.setVisibility (View.VISIBLE);
                    anc7_his_othersBox.setVisibility (View.VISIBLE);
                    anc7_exam_PRBox.setVisibility (View.VISIBLE);
                    anc7_exam_BPBox.setVisibility (View.VISIBLE);
                    anc7_exam_weightBox.setVisibility (View.VISIBLE);
                    anc7_exam_othersBox.setVisibility (View.VISIBLE);
                    anc7_advice_othersBox.setVisibility (View.VISIBLE);
                    anc_7_historyBox.setVisibility (View.VISIBLE);
                    anc_7_examinationBox.setVisibility (View.VISIBLE);
                    anc_7_adviceBox.setVisibility (View.VISIBLE);
                    anc_7_reviewBox.setVisibility (View.VISIBLE);
                    anc7_his_breath.setVisibility (View.VISIBLE);
                    anc7_his_fatigue.setVisibility (View.VISIBLE);
                    anc7_his_head.setVisibility (View.VISIBLE);
                    anc7_his_bleed.setVisibility (View.VISIBLE);
                    anc7_his_burn.setVisibility (View.VISIBLE);
                    anc7_his_fetal_move.setVisibility (View.VISIBLE);
                    anc7_his_itching.setVisibility (View.VISIBLE);
                    anc7_exam_pallor.setVisibility (View.VISIBLE);
                    anc7_exam_pedal.setVisibility (View.VISIBLE);
                    anc7_exam_pa.setVisibility (View.VISIBLE);
                    anc7_pa_2weeks.setVisibility (View.VISIBLE);
                    anc7_advice_DFMC.setVisibility (View.VISIBLE);
                    anc7_advice_TFe_Ca.setVisibility (View.VISIBLE);
                    anc7_advice_BleedPV.setVisibility (View.VISIBLE);
                    anc7_advice_spotPV.setVisibility (View.VISIBLE);
                    anc7_advice_leakPV.setVisibility (View.VISIBLE);
                    anc7_advice_fetalmove.setVisibility (View.VISIBLE);
                    anc7_advice_abdpain.setVisibility (View.VISIBLE);
                    anc7_his_others.setVisibility (View.VISIBLE);
                    anc7_exam_PR.setVisibility (View.VISIBLE);
                    anc7_exam_BP.setVisibility (View.VISIBLE);
                    anc7_exam_weight.setVisibility (View.VISIBLE);
                    anc7_exam_others.setVisibility (View.VISIBLE);
                    anc7_advice_others.setVisibility (View.VISIBLE);

                } else {
                    anc7_his_linearBox.setVisibility (View.GONE);
                    anc7_exam_linearBox.setVisibility (View.GONE);
                    anc7_advice_linearBox.setVisibility (View.GONE);
                    anc7_his_othersBox.setVisibility (View.GONE);
                    anc7_exam_PRBox.setVisibility (View.GONE);
                    anc7_exam_BPBox.setVisibility (View.GONE);
                    anc7_exam_weightBox.setVisibility (View.GONE);
                    anc7_exam_othersBox.setVisibility (View.GONE);
                    anc7_advice_othersBox.setVisibility (View.GONE);
                    anc_7_historyBox.setVisibility (View.GONE);
                    anc_7_examinationBox.setVisibility (View.GONE);
                    anc_7_adviceBox.setVisibility (View.GONE);
                    anc_7_reviewBox.setVisibility (View.GONE);
                    anc7_his_breath.setVisibility (View.GONE);
                    anc7_his_fatigue.setVisibility (View.GONE);
                    anc7_his_head.setVisibility (View.GONE);
                    anc7_his_bleed.setVisibility (View.GONE);
                    anc7_his_burn.setVisibility (View.GONE);
                    anc7_his_fetal_move.setVisibility (View.GONE);
                    anc7_his_itching.setVisibility (View.GONE);
                    anc7_exam_pallor.setVisibility (View.GONE);
                    anc7_exam_pedal.setVisibility (View.GONE);
                    anc7_exam_pa.setVisibility (View.GONE);
                    anc7_pa_2weeks.setVisibility (View.GONE);
                    anc7_advice_DFMC.setVisibility (View.GONE);
                    anc7_advice_TFe_Ca.setVisibility (View.GONE);
                    anc7_advice_BleedPV.setVisibility (View.GONE);
                    anc7_advice_spotPV.setVisibility (View.GONE);
                    anc7_advice_leakPV.setVisibility (View.GONE);
                    anc7_advice_fetalmove.setVisibility (View.GONE);
                    anc7_advice_abdpain.setVisibility (View.GONE);
                    anc7_his_others.setVisibility (View.GONE);
                    anc7_exam_PR.setVisibility (View.GONE);
                    anc7_exam_BP.setVisibility (View.GONE);
                    anc7_exam_weight.setVisibility (View.GONE);
                    anc7_exam_others.setVisibility (View.GONE);
                    anc7_advice_others.setVisibility (View.GONE);

                }
            }
        });

        anc_8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    anc8_his_linearBox.setVisibility (View.VISIBLE);
                    anc8_exam_linearBox.setVisibility (View.VISIBLE);
                    anc8_advice_linearBox.setVisibility (View.VISIBLE);
                    anc8_his_others.setVisibility (View.VISIBLE);
                    anc8_exam_PR.setVisibility (View.VISIBLE);
                    anc8_exam_BP.setVisibility (View.VISIBLE);
                    anc8_exam_weight.setVisibility (View.VISIBLE);
                    anc8_exam_others.setVisibility (View.VISIBLE);
                    anc8_advice_others.setVisibility (View.VISIBLE);
                    anc8_his_othersBox.setVisibility (View.VISIBLE);
                    anc8_exam_PRBox.setVisibility (View.VISIBLE);
                    anc8_exam_BPBox.setVisibility (View.VISIBLE);
                    anc8_exam_weightBox.setVisibility (View.VISIBLE);
                    anc8_exam_othersBox.setVisibility (View.VISIBLE);
                    anc8_advice_othersBox.setVisibility (View.VISIBLE);
                    anc_8_historyBox.setVisibility (View.VISIBLE);
                    anc_8_adviceBox.setVisibility (View.VISIBLE);
                    anc_8_examinationBox.setVisibility (View.VISIBLE);
                    anc8_his_breath.setVisibility (View.VISIBLE);
                    anc8_his_fatigue.setVisibility (View.VISIBLE);
                    anc8_his_head.setVisibility (View.VISIBLE);
                    anc8_his_bleed.setVisibility (View.VISIBLE);
                    anc8_his_burn.setVisibility (View.VISIBLE);
                    anc8_his_fetal_move.setVisibility (View.VISIBLE);
                    anc8_his_itching.setVisibility (View.VISIBLE);
                    anc8_exam_pallor.setVisibility (View.VISIBLE);
                    anc8_exam_pedal.setVisibility (View.VISIBLE);
                    anc8_exam_pa.setVisibility (View.VISIBLE);
                    anc8_advice_DFMC.setVisibility (View.VISIBLE);
                    anc8_advice_Fe_Ca.setVisibility (View.VISIBLE);
                    anc8_advice_induction.setVisibility (View.VISIBLE);

                } else {
                    anc8_his_linearBox.setVisibility (View.GONE);
                    anc8_exam_linearBox.setVisibility (View.GONE);
                    anc8_advice_linearBox.setVisibility (View.GONE);
                    anc8_his_others.setVisibility (View.GONE);
                    anc8_exam_PR.setVisibility (View.GONE);
                    anc8_exam_BP.setVisibility (View.GONE);
                    anc8_exam_weight.setVisibility (View.GONE);
                    anc8_exam_others.setVisibility (View.GONE);
                    anc8_advice_others.setVisibility (View.GONE);
                    anc8_his_othersBox.setVisibility (View.GONE);
                    anc8_exam_PRBox.setVisibility (View.GONE);
                    anc8_exam_BPBox.setVisibility (View.GONE);
                    anc8_exam_weightBox.setVisibility (View.GONE);
                    anc8_exam_othersBox.setVisibility (View.GONE);
                    anc8_advice_othersBox.setVisibility (View.GONE);
                    anc_8_historyBox.setVisibility (View.GONE);
                    anc_8_adviceBox.setVisibility (View.GONE);
                    anc_8_examinationBox.setVisibility (View.GONE);
                    anc8_his_breath.setVisibility (View.GONE);
                    anc8_his_fatigue.setVisibility (View.GONE);
                    anc8_his_head.setVisibility (View.GONE);
                    anc8_his_bleed.setVisibility (View.GONE);
                    anc8_his_burn.setVisibility (View.GONE);
                    anc8_his_fetal_move.setVisibility (View.GONE);
                    anc8_his_itching.setVisibility (View.GONE);
                    anc8_exam_pallor.setVisibility (View.GONE);
                    anc8_exam_pedal.setVisibility (View.GONE);
                    anc8_exam_pa.setVisibility (View.GONE);
                    anc8_advice_DFMC.setVisibility (View.GONE);
                    anc8_advice_Fe_Ca.setVisibility (View.GONE);
                    anc8_advice_induction.setVisibility (View.GONE);
                }
            }
        });

        investigationsBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    invest_heart_linearBox.setVisibility (View.VISIBLE);
                    invest_othersBox.setVisibility (View.VISIBLE);
                    invest_drug_historyBox.setVisibility (View.VISIBLE);
                    Co_MorbiditiesBox.setVisibility (View.VISIBLE);
                    Heart_DiseaseBox.setVisibility (View.VISIBLE);
                    invest_others.setVisibility (View.VISIBLE);
                    invest_drug_history.setVisibility (View.VISIBLE);
                    invest_chronic_hyper.setVisibility (View.VISIBLE);
                    invest_type_2_diabetes.setVisibility (View.VISIBLE);
                    invest_RHD_native.setVisibility (View.VISIBLE);
                    invest_RHD_post.setVisibility (View.VISIBLE);
                    invest_acyanotic.setVisibility (View.VISIBLE);
                    invest_cyanotic.setVisibility (View.VISIBLE);
                    invest_chronic_liver.setVisibility (View.VISIBLE);
                    invest_chronic_kidney.setVisibility (View.VISIBLE);
                    invest_APLA.setVisibility (View.VISIBLE);
                    invest_SLE.setVisibility (View.VISIBLE);

                } else {
                    invest_heart_linearBox.setVisibility (View.GONE);
                    invest_othersBox.setVisibility (View.GONE);
                    invest_drug_historyBox.setVisibility (View.GONE);
                    Co_MorbiditiesBox.setVisibility (View.GONE);
                    Heart_DiseaseBox.setVisibility (View.GONE);
                    invest_others.setVisibility (View.GONE);
                    invest_drug_history.setVisibility (View.GONE);
                    invest_chronic_hyper.setVisibility (View.GONE);
                    invest_type_2_diabetes.setVisibility (View.GONE);
                    invest_RHD_native.setVisibility (View.GONE);
                    invest_RHD_post.setVisibility (View.GONE);
                    invest_acyanotic.setVisibility (View.GONE);
                    invest_cyanotic.setVisibility (View.GONE);
                    invest_chronic_liver.setVisibility (View.GONE);
                    invest_chronic_kidney.setVisibility (View.GONE);
                    invest_APLA.setVisibility (View.GONE);
                    invest_SLE.setVisibility (View.GONE);
                }
            }
        });


        getSupportActionBar().setTitle("Add Data");

        session = new SessionManager(this);
//      Getting the WHO Data
        Log.i("information", "onCreate: " + "in whooo");
        clickedPatientId= getIntent().getIntExtra("EXTRA_PATIENT_ID", 0);
        System.out.print (clickedPatientId);
        String url = ApplicationController.get_base_url() + "swasthgarbh/patient/" + clickedPatientId;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("apihit", response.toString());
                        try {
                            if(response.has ("ID")) {
                                response = response.getJSONObject ("newPatientData");
                            }
                            Log.i ("kkjbgjhgjkh", "onResponse: rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr"+ response.toString ());
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

                            invest_others.setText(response.getString ("invest_others"));
                            invest_drug_history.setText(response.getString ("invest_drug_history"));
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
                            anc_1_GeneralDeranged_fasting.setText(response.getString ("anc_1_GeneralDeranged_fasting"));
                            anc_1_GeneralDeranged_breakfast.setText(response.getString ("anc_1_GeneralDeranged_breakfast"));
                            anc_1_GeneralDeranged_lunch.setText(response.getString ("anc_1_GeneralDeranged_lunch"));
                            anc_1_GeneralDeranged_dinner.setText(response.getString ("anc_1_GeneralDeranged_dinner"));
                            anc_1_POG.setText(response.getString ("anc_1_POG"));
                            anc_1_date.setText(response.getString ("anc_1_date"));
                            anc1_his_others.setText(response.getString ("anc1_his_others"));
                            anc1_exam_height.setText(response.getString ("anc1_exam_height"));
                            anc1_exam_weight.setText(response.getString ("anc1_exam_weight"));
                            anc1_exam_BMI.setText(response.getString ("anc1_exam_BMI"));
                            anc1_exam_PR.setText(response.getString ("anc1_exam_PR"));
                            anc1_exam_BP.setText(response.getString ("anc1_exam_BP"));
                            anc1_exam_RR.setText(response.getString ("anc1_exam_RR"));
                            anc1_exam_temp.setText(response.getString ("anc1_exam_temp"));
//                            anc1_exam_proteinuria.setText(response.getString ("anc1_exam_proteinuria"));
                            anc1_exam_chest.setText(response.getString ("anc1_exam_chest"));
                            anc1_exam_PA.setText(response.getString ("anc1_exam_PA"));
                            anc1_exam_others.setText(response.getString ("anc1_exam_others"));
                            anc1_invest_bg.setText(response.getString ("anc1_invest_bg"));
                            anc1_invest_husband_bg.setText(response.getString ("anc1_invest_husband_bg"));
                            anc1_invest_hemo.setText(response.getString ("anc1_invest_hemo"));
                            anc1_invest_bloodsugar_fast.setText(response.getString ("anc1_invest_bloodsugar_fast"));
                            anc1_invest_bloodsugar_post.setText(response.getString ("anc1_invest_bloodsugar_post"));
                            anc1_invest_GTT_fast.setText(response.getString ("anc1_invest_GTT_fast"));
                            anc1_invest_GTT_1hr.setText(response.getString ("anc1_invest_GTT_1hr"));
                            anc1_invest_GTT_2hr.setText(response.getString ("anc1_invest_GTT_2hr"));
                            anc1_invest_TSH.setText(response.getString ("anc1_invest_TSH"));
                            anc1_invest_NT_done.setText(response.getString ("anc1_invest_NT_done"));
                            anc1_invest_PAPP.setText(response.getString ("anc1_invest_PAPP"));
                            anc1_invest_b_hcg.setText(response.getString ("anc1_invest_b_hcg"));
                            anc1_invest_levelII_done.setText(response.getString ("anc1_invest_levelII_done"));
                            anc1_invest_normal.setText(response.getString ("anc1_invest_normal"));
                            anc1_invest_others.setText(response.getString ("anc1_invest_others"));
                            anc1_general_nutritional.setText(response.getString ("anc1_general_nutritional"));
                            anc1_general_ailment.setText(response.getString ("anc1_general_ailment"));
                            anc1_general_ICT.setText(response.getString ("anc1_general_ICT"));
                            anc1_general_others.setText(response.getString ("anc1_general_others"));
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
                            Log.d ("value", g);
                            callDateDiff (g);
                           // anc2_POG.setText(response.getString ("anc2_POG"));
                            anc2_his_others.setText(response.getString ("anc2_his_others"));
                            anc2_exam_PR.setText(response.getString ("anc2_exam_PR"));
                            anc2_exam_BP.setText(response.getString ("anc2_exam_BP"));
                            anc2_exam_weight.setText(response.getString ("anc2_exam_weight"));
                            anc2_exam_others.setText(response.getString ("anc2_exam_others"));
                            anc2_invest_others.setText(response.getString ("anc2_invest_others"));
                            anc2_advice_nutri.setText(response.getString ("anc2_advice_nutri"));
                            anc2_advice_general.setText(response.getString ("anc2_advice_general"));
                            anc2_advice_common.setText(response.getString ("anc2_advice_common"));
                            anc2_advice_others.setText(response.getString ("anc2_advice_others"));
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
                            anc2_advice_OGTT .setChecked(response.getBoolean("anc2_advice_OGTT"));
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
                            anc3_his_others.setText(response.getString ("anc3_his_others"));
                            anc3_exam_PR.setText(response.getString ("anc3_exam_PR"));
                            anc3_exam_BP.setText(response.getString ("anc3_exam_BP"));
                            anc3_investigation_others.setText(response.getString ("anc3_investigation_others"));
                            anc3_exam_weight.setText(response.getString ("anc3_exam_weight"));
                            anc3_exam_others.setText(response.getString ("anc3_exam_others"));
                            anc3_advice_others.setText(response.getString ("anc3_advice_others"));
                            anc3_advice_nutri.setText(response.getString ("anc3_advice_nutri"));
                            anc3_advice_general.setText(response.getString ("anc3_advice_general"));
                            anc3_advice_common.setText(response.getString ("anc3_advice_common"));
                            anc_3_pa_2weeks.setText(response.getString ("anc_3_pa_2weeks"));
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
                            anc4_his_others.setText(response.getString ("anc4_his_others"));
                            anc4_exam_PR.setText(response.getString ("anc4_exam_PR"));
                            anc4_exam_BP.setText(response.getString ("anc4_exam_BP"));
                            anc_4_pa_2weeks.setText(response.getString ("anc_4_pa_2weeks"));
                            anc4_exam_weight.setText(response.getString ("anc4_exam_weight"));
                            anc4_exam_others.setText(response.getString ("anc4_exam_others"));
                            anc4_advice_others.setText(response.getString ("anc4_advice_others"));
                            anc4_advice_nutri.setText(response.getString ("anc4_advice_nutri"));
                            anc4_advice_general.setText(response.getString ("anc4_advice_general"));
                            anc4_advice_common.setText(response.getString ("anc4_advice_common"));
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
                            anc5_his_others.setText(response.getString ("anc5_his_others"));
                            anc5_his_timing.setText(response.getString ("anc5_his_timing"));
                            anc5_exam_BP.setText(response.getString ("anc5_exam_BP"));
                            anc5_exam_weight.setText(response.getString ("anc5_exam_weight"));
                            anc5_pa_2weeks.setText(response.getString ("anc_5_pa_2weeks"));
                            anc5_exam_others.setText(response.getString ("anc5_exam_others"));
                            anc5_invest_others.setText(response.getString ("anc5_invest_others"));
                            anc5_USG_BPD_cm.setText(response.getString ("anc5_USG_BPD_cm"));
                            anc5_USG_BPD_weeks.setText(response.getString ("anc5_USG_BPD_weeks"));
                            anc5_USG_BPD_centile.setText(response.getString ("anc5_USG_BPD_centile"));
                            anc5_USG_HC_cm.setText(response.getString ("anc5_USG_HC_cm"));
                            anc5_USG_HC_weeks.setText(response.getString ("anc5_USG_HC_weeks"));
                            anc5_USG_HC_centile.setText(response.getString ("anc5_USG_HC_centile"));
                            anc5_USG_AC_cm.setText(response.getString ("anc5_USG_AC_cm"));
                            anc5_USG_AC_weeks.setText(response.getString ("anc5_USG_AC_weeks"));
                            anc5_USG_AC_centile.setText(response.getString ("anc5_USG_AC_centile"));
                            anc5_USG_FL_cm.setText(response.getString ("anc5_USG_FL_cm"));
                            anc5_USG_FL_weeks.setText(response.getString ("anc5_USG_FL_weeks"));
                            anc5_USG_FL_centile.setText(response.getString ("anc5_USG_FL_centile"));
                            anc5_USG_EFW_gm.setText(response.getString ("anc5_USG_EFW_gm"));
                            anc5_USG_EFW_weeks.setText(response.getString ("anc5_USG_EFW_weeks"));
                            anc5_USG_EFW_centile.setText(response.getString ("anc5_USG_EFW_centile"));
                            anc5_USG_liquor_SLP.setText(response.getString ("anc5_USG_liquor_SLP"));
                            anc5_USG_liquor_AFI.setText(response.getString ("anc5_USG_liquor_AFI"));
                            anc5_USG_UAPI.setText(response.getString ("anc5_USG_UAPI"));
                            anc5_USG_UAPI_centile.setText(response.getString ("anc5_USG_UAPI_centile"));
                            anc5_USG_MCAPI.setText(response.getString ("anc5_USG_MCAPI"));
                            anc5_USG_MCAPI_centile.setText(response.getString ("anc5_USG_MCAPI_centile"));
                            anc5_advice_nutri.setText(response.getString ("anc5_advice_nutri"));
                            anc5_advice_general.setText(response.getString ("anc5_advice_general"));
                            anc5_advice_common.setText(response.getString ("anc5_advice_common"));
                            anc5_advice_others.setText(response.getString ("anc5_advice_others"));
                            anc_5.setChecked(response.getBoolean("anc_5"));
                            anc5_his_breath.setChecked(response.getBoolean("anc5_his_breath"));
                            anc5_his_fatigue.setChecked(response.getBoolean("anc5_his_fatigue"));
                            anc5_his_head.setChecked(response.getBoolean("anc5_his_head"));
                            anc5_his_bleed.setChecked(response.getBoolean("anc5_his_bleed"));
                            anc5_his_burn.setChecked(response.getBoolean("anc5_his_burn"));
                            anc5_his_fetal_move.setChecked(response.getBoolean("anc5_his_fetal_move"));
                            anc5_his_itching.setChecked(response.getBoolean("anc4_his_itching"));
                            anc5_his_vaginal_del.setChecked (response.getBoolean ("anc5_his_vaginal_del"));
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
                            anc6_his_others.setText(response.getString ("anc6_his_others"));
                            anc6_exam_PR.setText(response.getString ("anc6_exam_PR"));
                            anc6_exam_BP.setText(response.getString ("anc6_exam_BP"));
                            anc6_pa_2weeks.setText(response.getString ("anc6_pa_2weeks"));
                            anc6_exam_weight.setText(response.getString ("anc6_exam_weight"));
                            anc6_exam_others.setText(response.getString ("anc6_exam_others"));
                            anc6_exam_pelvic.setText(response.getString ("anc6_exam_pelvic"));
                            anc6_advice_others.setText(response.getString ("anc6_advice_others"));
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
                            anc7_his_others.setText(response.getString ("anc7_his_others"));
                            anc7_exam_PR.setText(response.getString ("anc7_exam_PR"));
                            anc7_exam_BP.setText(response.getString ("anc7_exam_BP"));
                            anc7_pa_2weeks.setText(response.getString ("anc7_pa_2weeks"));
                            anc7_exam_weight.setText(response.getString ("anc7_exam_weight"));
                            anc7_exam_others.setText(response.getString ("anc7_exam_others"));
                            anc7_advice_others.setText(response.getString ("anc7_advice_others"));
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
                            anc8_his_others.setText(response.getString ("anc8_his_others"));
                            anc8_exam_PR.setText(response.getString ("anc8_exam_PR"));
                            anc8_exam_BP.setText(response.getString ("anc8_exam_BP"));
                            anc8_exam_weight.setText(response.getString ("anc8_exam_weight"));
                            anc8_exam_others.setText(response.getString ("anc8_exam_others"));
                            anc8_advice_others.setText(response.getString ("anc8_advice_others"));
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
                            Log.i ("Error", e.toString ());
//                            e.printStackTrace();
                        } catch (ParseException e) {
                            Log.i ("Error", e.toString ());
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
        LinearLayout a = (LinearLayout)findViewById(R.id.linearLayoutForAll);
        RelativeLayout b = (RelativeLayout)findViewById(R.id.updateButtonLayout);
        final HashMap<String, String> user = session.getUserDetails();
        if ("doctor".equals(user.get("type"))){
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

        Spinner spinner = (Spinner) findViewById(R.id.Proteinuria);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ProteinuriaDropdownElements, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
    public void updateData(){
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

                    params.put("invest_others","" +  invest_others.getText());
                    params.put("anc_2_pa_2weeks", ""+ anc_2_pa_2weeks.getText ());
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
                    params.put("anc1_exam_BP","" +  anc1_exam_BP.getText());
                    params.put("anc1_exam_RR", "" + anc1_exam_RR.getText());
                    params.put("anc1_exam_temp","" +  anc1_exam_temp.getText());
//                    params.put("anc1_exam_proteinuria","" +  anc1_exam_proteinuria.getText());
                    params.put("anc1_exam_chest", "" + anc1_exam_chest.getText());
                    params.put("anc1_exam_PA", "" + anc1_exam_PA.getText());
                    params.put("anc1_exam_others","" +  anc1_exam_others.getText());
                    params.put("anc1_invest_bg", "" + anc1_invest_bg.getText());
                    params.put("anc1_invest_husband_bg", "" + anc1_invest_husband_bg.getText());
                    params.put("anc1_invest_hemo","" +  anc1_invest_hemo.getText());
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
                    params.put("anc1_general_nutritional", anc1_general_nutritional.getText());
                    params.put("anc1_general_ailment", anc1_general_ailment.getText());
                    params.put("anc1_general_ICT", "" + anc1_general_ICT.getText());
                    params.put("anc1_general_others", "" + anc1_general_others.getText());
                    params.put("anc2_POG", "" + anc2_POG.getText());
                    params.put("anc2_his_others", "" + anc2_his_others.getText());
                    params.put("anc2_exam_PR", "" + anc2_exam_PR.getText());
                    params.put("anc2_exam_BP", "" + anc2_exam_BP.getText());
                    params.put("anc2_exam_weight", "" + anc2_exam_weight.getText());
                    params.put("anc2_exam_others", "" + anc2_exam_others.getText());
                    params.put("anc2_invest_others", "" + anc2_invest_others.getText());
                    params.put("anc2_advice_nutri","" +  anc2_advice_nutri.getText());
                    params.put("anc2_advice_general", "" + anc2_advice_general.getText());
                    params.put("anc2_advice_common", "" + anc2_advice_common.getText());
                    params.put("anc2_advice_others", "" + anc2_advice_others.getText());
                    params.put("anc3_his_others","" +  anc3_his_others.getText());
                    params.put("anc3_exam_PR", "" + anc3_exam_PR.getText());
                    params.put("anc3_investigation_others", ""+  anc3_investigation_others.getText());
                    params.put("anc3_exam_BP", "" + anc3_exam_BP.getText());
                    params.put("anc3_exam_weight","" +  anc3_exam_weight.getText());
                    params.put("anc3_exam_others", "" + anc3_exam_others.getText());
                    params.put("anc1_general_ailment", "" + anc1_general_ailment.getText());
                    params.put("anc3_advice_nutri", "" + anc3_advice_nutri.getText());
                    params.put("anc_3_pa_2weeks", "" + anc_3_pa_2weeks.getText());
                    params.put("anc3_advice_general","" +  anc3_advice_general.getText());
                    params.put("anc3_advice_common", "" + anc3_advice_common.getText());
                    params.put("anc3_advice_others", "" + anc3_advice_others.getText());
                    params.put("anc4_his_others", "" + anc4_his_others.getText());
                    params.put("anc4_exam_PR", "" + anc4_exam_PR.getText());
                    params.put("anc4_exam_BP", "" + anc4_exam_BP.getText());
                    params.put("anc_4_pa_2weeks", "" + anc_4_pa_2weeks.getText());
                    params.put("anc4_exam_weight", "" + anc4_exam_weight.getText());
                    params.put("anc4_exam_others", "" + anc4_exam_others.getText());
                    params.put("anc4_advice_nutri", "" + anc4_advice_nutri.getText());
                    params.put("anc4_advice_general","" +  anc4_advice_general.getText());
                    params.put("anc4_advice_common", "" + anc4_advice_common.getText());
                    params.put("anc4_advice_others", "" + anc4_advice_others.getText());
                    params.put("anc5_his_others","" +  anc5_his_others.getText());
                    params.put("anc5_his_timing", "" + anc5_his_timing.getText());
                    params.put("anc5_exam_PR","" +  anc5_exam_PR.getText());
                    params.put("anc_5_pa_2weeks","" +  anc5_pa_2weeks.getText());
                    params.put("anc5_exam_BP","" +  anc5_exam_BP.getText());
                    params.put("anc5_exam_weight", "" + anc5_exam_weight.getText());
                    params.put("anc5_exam_others","" +  anc5_exam_others.getText());
                    params.put("anc5_invest_others","" +  anc5_invest_others.getText());
                    params.put("anc5_USG_BPD_cm","" +  anc5_USG_BPD_cm.getText());
                    params.put("anc5_USG_BPD_weeks", "" + anc5_USG_BPD_weeks.getText());
                    params.put("anc5_USG_BPD_centile","" +  anc5_USG_BPD_centile.getText());
                    params.put("anc5_USG_HC_cm", "" + anc5_USG_HC_cm.getText());
                    params.put("anc5_USG_HC_weeks","" +  anc5_USG_HC_weeks.getText());
                    params.put("anc5_USG_HC_centile", "" + anc5_USG_HC_centile.getText());
                    params.put("anc5_USG_AC_cm", "" + anc5_USG_AC_cm.getText());
                    params.put("anc5_USG_AC_weeks", "" + anc5_USG_AC_weeks.getText());
                    params.put("anc5_USG_AC_centile","" +  anc5_USG_AC_centile.getText());
                    params.put("anc5_USG_FL_cm", "" + anc5_USG_FL_cm.getText());
                    params.put("anc5_USG_FL_weeks","" +  anc5_USG_FL_weeks.getText());
                    params.put("anc5_USG_FL_centile", "" + anc5_USG_FL_centile.getText());
                    params.put("anc5_USG_EFW_gm", "" + anc5_USG_EFW_gm.getText());
                    params.put("anc5_USG_EFW_weeks", "" + anc5_USG_EFW_weeks.getText());
                    params.put("anc5_USG_EFW_centile", "" + anc5_USG_EFW_centile.getText());
                    params.put("anc5_USG_liquor_SLP", "" + anc5_USG_liquor_SLP.getText());
                    params.put("anc5_USG_liquor_AFI", "" + anc5_USG_liquor_AFI.getText());
                    params.put("anc5_USG_UAPI", "" + anc5_USG_UAPI.getText());
                    params.put("anc5_USG_UAPI_centile","" +  anc5_USG_UAPI_centile.getText());
                    params.put("anc5_USG_MCAPI", "" + anc5_USG_MCAPI.getText());
                    params.put("anc5_USG_MCAPI_centile", "" + anc5_USG_MCAPI_centile.getText());
                    params.put("anc5_advice_nutri", "" + anc5_advice_nutri.getText());
                    params.put("anc5_advice_general", "" + anc5_advice_general.getText());
                    params.put("anc5_advice_common", "" + anc5_advice_common.getText());
                    params.put("anc5_advice_others","" +  anc5_advice_others.getText());
                    params.put("anc6_his_others", "" + anc6_his_others.getText());
                    params.put("anc6_exam_PR","" +  anc6_exam_PR.getText());
                    params.put("anc6_exam_BP", "" + anc6_exam_BP.getText());
                    params.put("anc6_pa_2weeks", "" + anc6_pa_2weeks.getText());
                    params.put("anc6_exam_weight", "" + anc6_exam_weight.getText());
                    params.put("anc6_exam_others", "" + anc6_exam_others.getText());
                    params.put("anc6_exam_pelvic", "" + anc6_exam_pelvic.getText());
                    params.put("anc6_advice_others", "" + anc6_advice_others.getText());
                    params.put("anc7_his_others", "" + anc7_his_others.getText());
                    params.put("anc7_exam_PR", "" + anc7_exam_PR.getText());
                    params.put("anc7_exam_BP", "" + anc7_exam_BP.getText());
                    params.put( "anc7_pa_2weeks","" + anc7_pa_2weeks.getText());
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

