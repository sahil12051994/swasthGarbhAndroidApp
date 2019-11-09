package com.swasthgarbh.root.swasthgarbh;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PatientSignupByDoctor extends AppCompatActivity implements View.OnClickListener {
    Button register;
    EditText date_of_birth, name, address, email, mobile, password, doctor_number, doctor_name, lmpDate, UHID;
//    Switch aiDoc;
    int doc_id;
    Boolean docRequried = Boolean.TRUE;
    LinearLayout normalDoc;
    String token, type;
    int u_id, id;
    SessionManager session;
    CheckBox highbp, histPree, motherPre, histObes, moreThanOneBaby, diseases;
    String lmpTime;
    Calendar newDate1 = Calendar.getInstance();
    private DatePickerDialog lmpDatePickerDialog;
    private SimpleDateFormat dateFormatterShow, dateFormatterServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_patient_signup_by_doctor);

        getSupportActionBar ( ).setTitle ("Patient Registration");
        name = (EditText) findViewById (R.id.editname);
        address = (EditText) findViewById (R.id.editaddress);
        email = (EditText) findViewById (R.id.editemail);
        mobile = (EditText) findViewById (R.id.editphone);
        UHID = (EditText) findViewById (R.id.editUHID);

//        password = (EditText) findViewById(R.id.editText6);

//        doctor_number = (EditText) findViewById(R.id.editText7);
//        doctor_number.addTextChangedListener(this);
//        doctor_name = (EditText) findViewById(R.id.editText10);

        dateFormatterShow = new SimpleDateFormat ("dd-MM-yyyy", Locale.US);
        dateFormatterServer = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:dd'Z'");
        lmpDate = (EditText) findViewById (R.id.lmpDate);


        highbp = (CheckBox) findViewById (R.id.highbp);
        histPree = (CheckBox) findViewById (R.id.histPree);
        motherPre = (CheckBox) findViewById (R.id.motherPre);
        histObes = (CheckBox) findViewById (R.id.histObes);
        moreThanOneBaby = (CheckBox) findViewById (R.id.moreThanOneBaby);
        diseases = (CheckBox) findViewById (R.id.diseases);

        Spinner spinnerStatus = (Spinner) findViewById(R.id.status);
        ArrayAdapter<CharSequence> adapterStatus = ArrayAdapter.createFromResource(this,
                R.array.SEStatusDropdownElements, android.R.layout.simple_spinner_item);
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(adapterStatus);

        Spinner spinnerEducation = (Spinner) findViewById(R.id.education);
        ArrayAdapter<CharSequence> adapterEducation = ArrayAdapter.createFromResource(this,
                R.array.SchoolDropdownElements, android.R.layout.simple_spinner_item);
        adapterEducation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEducation.setAdapter(adapterEducation);

        register = (Button) findViewById (R.id.register);
        register.setOnClickListener (this);

        date_of_birth = (EditText) findViewById (R.id.editage);

        session = new SessionManager (this);

        Calendar newCalendar = Calendar.getInstance ();
        lmpDate.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                lmpDatePickerDialog.show ();
            }
        });
        lmpDatePickerDialog = new DatePickerDialog (this, new DatePickerDialog.OnDateSetListener ( ) {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                newDate1.set (year, monthOfYear, dayOfMonth);
                lmpDate.setText (dateFormatterShow.format (newDate1.getTime ()));
                lmpTime = dateFormatterServer.format (newDate1.getTime ());
            }

        }, newCalendar.get (Calendar.YEAR), newCalendar.get (Calendar.MONTH), newCalendar.get (Calendar.DAY_OF_MONTH));

        // Calendar newCalendar = Calendar.getInstance();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.register) {
            String str_mobile = "" + mobile.getText();
            String str_password = "11111" ;//+ password.getText();
            String str_name = "" + name.getText();
            String str_UHID = "" + UHID.getText();
            String str_address = "" + address.getText();
            String str_dob = "" + date_of_birth.getText();

            String str_lmpDate = "" + lmpDate.getText();

       //     Log.i("DoctorID",str_doctor_mobile);

            if (str_name.length() == 0) {
                Toast.makeText(PatientSignupByDoctor.this, "Enter the name", Toast.LENGTH_LONG).show();
                return;
            }

            if (str_UHID.length() == 0) {
                Toast.makeText(PatientSignupByDoctor.this, "Enter UHID OR Registration no.", Toast.LENGTH_LONG).show();
                return;
            }

            String url = ApplicationController.get_base_url() + "api/onboard/patient";
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("TAG", response.toString());
                            try {
                                int U_ID = Integer.parseInt(response.get("U_ID").toString());
                                String token = "" + response.get("Token");
                                Toast.makeText(PatientSignupByDoctor.this, "Patient Registered Successfully!", Toast.LENGTH_SHORT).show();
//
                                Intent i = new Intent(PatientSignupByDoctor.this, patient_data_entry_bydoc.class);
                                i.putExtra("EXTRA_PATIENT_ID", Integer.parseInt(response.getString ("ID")));
                                startActivity(i);
                                finish();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
//                            edit.commit();
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("TAG", "Error Message: " + error);
                    Toast.makeText(PatientSignupByDoctor.this, "Some error occurred", Toast.LENGTH_LONG).show();
                }
            }) {

                @Override
                public byte[] getBody() {
                    JSONObject params = new JSONObject();
                    try {
                        params.put("name", "" + name.getText());
                        params.put("address", "" + address.getText());
                        params.put("UHID", "" + UHID.getText());
                        params.put("password", "" + name.getText() + "_" + UHID.getText());
                        params.put("mobile", mobile.getText());
                        params.put("email", "" + email.getText());
                        if(docRequried == Boolean.TRUE){
                            params.put("doctor", session.getUserDetails().get("id"));
                        } else {
                            params.put("doctor", "");
                        }
                        params.put("date_of_birth", date_of_birth.getText());
                        params.put("gender", 0);

                        params.put("lmp", lmpTime);
                        params.put("history_high_blood_pressure", highbp.isChecked());
                        params.put("history_of_preeclampsia", histPree.isChecked());
                        params.put("mother_or_sister_had_preeclampsia", motherPre.isChecked());
                        params.put("history_of_obesity", histObes.isChecked());
                        params.put("more_than_one_baby", moreThanOneBaby.isChecked());
                        params.put("history_of_diseases", diseases.isChecked());
                        params.put("verified", Boolean.FALSE);
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
}