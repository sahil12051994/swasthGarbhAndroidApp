package com.swasthgarbh.root.swasthgarbh;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class AllPatientListInDoctorAdapter extends ArrayAdapter<PatientListRowInDoctorClass> {

    ImageView iv;

    public AllPatientListInDoctorAdapter(Activity context, ArrayList<PatientListRowInDoctorClass> patientData) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, patientData);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PatientListRowInDoctorClass current_patient_data = getItem(position);

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_patient_list_row, parent, false);
            //iv=listItemView.findViewById (R.id.nextbutton);
        }

        TextView patientName = (TextView)listItemView.findViewById(R.id.PatientNameInList);
        patientName.setText(current_patient_data.getName());

        TextView eddDateOfPatient = (TextView)listItemView.findViewById(R.id.eddDateOfPatientInList);
        TextView uhidOfPatientInList = (TextView) listItemView.findViewById(R.id.uhidOfPatientInList);

        int isdocreg;
        iv = (ImageView)listItemView.findViewById (R.id.nextt);
        if(current_patient_data.getUHID ().equals ("null")) {
            iv.setImageResource (R.drawable.next);
            uhidOfPatientInList.setVisibility(View.GONE);
            isdocreg=0;
        }else{
            iv.setImageResource (R.drawable.open);
            uhidOfPatientInList.setVisibility(View.VISIBLE);
            uhidOfPatientInList.setText(" | UHID: " + current_patient_data.getUHID ());
            isdocreg=1;
        }

        try {
            eddDateOfPatient.setText("EDD: " + current_patient_data.getEDD());
            Log.d ("patient id", "EDD: " + current_patient_data.getEDD());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final int patientId = current_patient_data.getPatientId();
        Log.d ("getpatient", patientId+"");

            getPatientGraph (patientId, current_patient_data, listItemView,isdocreg);
            Log.d ("yes", "got the graph");

        ImageView verified;
        verified = (ImageView)listItemView.findViewById(R.id.verified);
        if(!current_patient_data.getVerified()){
            verified.setVisibility(View.GONE);
        }

        final String UHID = current_patient_data.getUHID();

        LinearLayout getInsideParticularPatient = (LinearLayout) listItemView.findViewById(R.id.getInsideParticularPatient);
        getInsideParticularPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i("Clicked","Next Clicked");what is left now?
                if (UHID.equals ("null")) {
                    Intent intent = new Intent(v.getContext(), DoctorScreenForParticularPatient.class);
                    intent.putExtra("EXTRA_PATIENT_ID", patientId);
                    v.getContext().startActivity(intent);

                } else {
                    Intent intent = new Intent (v.getContext(), patient_data_entry_bydoc.class);
                    intent.putExtra ("EXTRA_PATIENT_ID", patientId);
                    v.getContext().startActivity (intent);
                }
            }
        });

        return listItemView;
    }

    public void getPatientGraph(int id, final PatientListRowInDoctorClass current_patient_data, final View listItemView, final int isdocreg){

        String url;
        if(isdocreg==1)
            url = ApplicationController.get_base_url() + "swasthgarbh/patient/" + id;

        else
            url = ApplicationController.get_base_url() + "api/patient/" + id;
        Log.d ("url is : ", url);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d ("getDATA", response.toString ( ));

                            try {
                                LineChart chart = (LineChart) listItemView.findViewById (R.id.patientBpChartInListItem);

                                ArrayList<Entry> yValues = new ArrayList<Entry> ( );
                                ArrayList<Integer> colorssys = new ArrayList<Integer> ( );
                                ArrayList<Entry> y2Values = new ArrayList<Entry> ( );
                                ArrayList<Integer> colorsdys = new ArrayList<Integer> ( );

                                if (isdocreg==1){
                                    Log.i("Doc Entered Data","1");
                                    Log.i("Doc Entered Data","2" + response.getString ("anc1_examination_vitals_Bp"));

                                    Object data;
                                    ArrayList<String> bpdata = new ArrayList<>();

                                    if(response.has ("anc1_examination_vitals_Bp")) {
                                        data = response.getString ("anc1_examination_vitals_Bp");
                                        if(data.toString ().contains ("/")) {
                                            bpdata.add (data + "");
                                        }
                                    }

                                    if(response.has ("anc2_examination_BP")) {
                                        data = response.get ("anc2_examination_BP");
                                        if(data.toString ().contains ("/")) {
                                            bpdata.add (data + "");
                                        }
                                    }

                                    if(response.has ("anc3_examination_BP")) {
                                        data = response.get ("anc3_examination_BP");
                                        if(data.toString ().contains ("/")) {
                                            bpdata.add (data + "");
                                        }
                                    }

                                    if(response.has ("anc4_examination_BP")) {
                                        data = response.get ("anc4_examination_BP");
                                        if(data.toString ().contains ("/")) {
                                            bpdata.add (data + "");
                                        }
                                    }
                                    if(response.has ("anc5_examination_BP")) {
                                        data = response.get ("anc5_examination_BP");
                                        if(data.toString ().contains ("/")) {
                                            bpdata.add (data + "");
                                        }
                                    }
                                    if(response.has ("anc6_examination_BP")) {
                                        data = response.get ("anc6_examination_BP");
                                        if(data.toString ().contains ("/")) {
                                            bpdata.add (data + "");
                                        }
                                    }
                                    if(response.has ("anc7_examination_BP")) {
                                        data = response.get ("anc7_examination_BP");
                                        if(data.toString ().contains ("/")) {
                                            bpdata.add (data + "");
                                        }
                                    }
                                    if(response.has ("anc8_examination_BP")) {
                                        data = response.get ("anc8_examination_BP");
                                        if(data.toString ().contains ("/")) {
                                            bpdata.add (data + "");
                                        }
                                    }

                                    if(bpdata.size ()==0){
//                                        Toast.makeText (getContext (), "BP Data not found", Toast.LENGTH_SHORT).show ( );
                                        Log.i ("Data","BP Data not found" + bpdata);;
                                        chart.clear();

                                    } else {
                                        for(int i=0;i<bpdata.size ();i++){
                                            String s = bpdata.get (i);
                                            Log.d ("bpdataaa",s );
                                            if(s.contains ("/")) {
                                                String[] dd = s.split ("/");
                                                int sys = Integer.parseInt (dd[0].trim ( ));
                                                int dys = Integer.parseInt (dd[1].trim ( ));

                                                Log.d ("systolic bp", sys + ","+ dys);
                                                if (sys != 0 || i == 0) {
                                                    yValues.add (new Entry (i + 1, sys));
                                                    Log.d ("values are :", yValues + "");
                                                }
                                                if (sys > 160) {

                                                    colorssys.add (ContextCompat.getColor (getContext ( ), R.color.chart6));
                                                } else if (sys > 140 && sys <= 160) {
                                                    colorssys.add (ContextCompat.getColor (getContext ( ), R.color.chart4));
                                                } else if (sys <= 145) {
                                                    colorssys.add (ContextCompat.getColor (getContext ( ), R.color.chartsys));
                                                }

                                                if (dys > 110) {
                                                    colorsdys.add (ContextCompat.getColor (getContext ( ), R.color.chart6));
                                                } else if (dys > 90 && dys <= 110) {
                                                    colorsdys.add (ContextCompat.getColor (getContext ( ), R.color.chart4));
                                                } else if (dys <= 90 || i == 1) {
                                                    colorsdys.add (ContextCompat.getColor (getContext ( ), R.color.chartdys));
                                                }

                                                if (dys != 0 || bpdata.size () == 1) {
                                                    y2Values.add (new Entry (i+1, dys));
                                                }
                                            }
                                        }
                                        Log.i ("Graph","Forming the grph");
                                        chart.setDragEnabled (true);
                                        chart.setScaleEnabled (true);
                                        chart.getDescription ( ).setEnabled (false);

                                        LineDataSet set1 = new LineDataSet (yValues, "Systolic BP");
                                        set1.setAxisDependency (YAxis.AxisDependency.LEFT);
                                        LineDataSet set2 = new LineDataSet (y2Values, "Diastolic BP");
                                        set2.setAxisDependency (YAxis.AxisDependency.LEFT);

                                        set1.setFillAlpha (110);
                                        set1.setLineWidth (3.5f);
                                        set1.setColor (Color.rgb (19, 141, 117));
                                        set1.setDrawValues (false);
                                        set1.setCircleColors (colorssys);

                                        set2.setLineWidth (2f);
                                        set2.setColor (Color.rgb (171, 235, 198));
                                        set2.setDrawValues (false);
                                        set2.setCircleColors (colorsdys);

                                        YAxis leftAxis = chart.getAxisLeft ( );
                                        LimitLine ll = new LimitLine (160f, "Critical");
                                        ll.setLineColor (Color.rgb (19, 141, 117));
                                        ll.setLineWidth (1f);
                                        ll.setTextColor (Color.rgb (19, 141, 117));
                                        ll.setTextSize (12f);
                                        ll.enableDashedLine (4, 2, 0);
                                        leftAxis.addLimitLine (ll);

                                        LimitLine l2 = new LimitLine (110f, "Critical");
                                        l2.setLineColor (Color.rgb (171, 235, 198));
                                        l2.setLineWidth (1f);
                                        l2.setTextColor (Color.rgb (171, 235, 198));
                                        l2.setTextSize (12f);
                                        l2.enableDashedLine (4, 2, 0);
                                        leftAxis.addLimitLine (l2);

                                        set1.setMode (LineDataSet.Mode.HORIZONTAL_BEZIER);
                                        set2.setMode (LineDataSet.Mode.HORIZONTAL_BEZIER);

                                        ArrayList<ILineDataSet> dataSets = new ArrayList<> ( );
                                        dataSets.add (set1);
                                        dataSets.add (set2);
                                        LineData dataa = new LineData (dataSets);
                                        chart.setData (dataa);
                                        chart.invalidate ( );
                                        chart.animateXY (1000, 1000);

                                    }

                                } else {
                                    Log.i("Patient Entered Data","asd");
                                    Log.d ("gettheGraph", response.toString ( ));
                                    JSONArray patientBpData = response.getJSONArray ("data");
                                    Log.d ("The length check", "onResponse: " + patientBpData.length ( ));
                                    if (patientBpData.length ( ) != 0) {

                                        for (int i = patientBpData.length ( ) - 1; i >= 0; i--) {
                                            JSONObject po = (JSONObject) patientBpData.get (i);
                                            Log.d ("lao kya h data", po + "");
                                            int len = patientBpData.length ( );
                                            if (po.getInt ("systolic") != 0 || len == 1) {
                                                yValues.add (new Entry (patientBpData.length ( ) - i, po.getInt ("systolic")));
                                            }

                                            if (po.getInt ("systolic") > 160) {
                                                colorssys.add (ContextCompat.getColor (getContext ( ), R.color.chart6));
                                            } else if (po.getInt ("systolic") > 140 && po.getInt ("systolic") <= 160) {
                                                colorssys.add (ContextCompat.getColor (getContext ( ), R.color.chart4));
                                            } else if (po.getInt ("systolic") <= 145) {
                                                colorssys.add (ContextCompat.getColor (getContext ( ), R.color.chartsys));
                                            }

                                            if (po.getInt ("diastolic") > 110) {
                                                colorsdys.add (ContextCompat.getColor (getContext ( ), R.color.chart6));
                                            } else if (po.getInt ("diastolic") > 90 && po.getInt ("diastolic") <= 110) {
                                                colorsdys.add (ContextCompat.getColor (getContext ( ), R.color.chart4));
                                            } else if (po.getInt ("diastolic") <= 90 || len == 1) {
                                                colorsdys.add (ContextCompat.getColor (getContext ( ), R.color.chartdys));
                                            }

                                            if (po.getInt ("diastolic") != 0 || len == 1) {
                                                y2Values.add (new Entry (patientBpData.length ( ) - i, po.getInt ("diastolic")));
                                            }
                                        }

                                        chart.setDragEnabled (true);
                                        chart.setScaleEnabled (true);
                                        chart.getDescription ( ).setEnabled (false);

                                        LineDataSet set1 = new LineDataSet (yValues, "Systolic BP");
                                        set1.setAxisDependency (YAxis.AxisDependency.LEFT);
                                        LineDataSet set2 = new LineDataSet (y2Values, "Diastolic BP");
                                        set2.setAxisDependency (YAxis.AxisDependency.LEFT);

                                        set1.setFillAlpha (110);
                                        set1.setLineWidth (3.5f);
                                        set1.setColor (Color.rgb (19, 141, 117));
                                        set1.setDrawValues (false);
                                        set1.setCircleColors (colorssys);

                                        set2.setLineWidth (2f);
                                        set2.setColor (Color.rgb (171, 235, 198));
                                        set2.setDrawValues (false);
                                        set2.setCircleColors (colorsdys);

                                        YAxis leftAxis = chart.getAxisLeft ( );
                                        LimitLine ll = new LimitLine (160f, "Critical");
                                        ll.setLineColor (Color.rgb (19, 141, 117));
                                        ll.setLineWidth (1f);
                                        ll.setTextColor (Color.rgb (19, 141, 117));
                                        ll.setTextSize (12f);
                                        ll.enableDashedLine (4, 2, 0);
                                        leftAxis.addLimitLine (ll);

                                        LimitLine l2 = new LimitLine (110f, "Critical");
                                        l2.setLineColor (Color.rgb (171, 235, 198));
                                        l2.setLineWidth (1f);
                                        l2.setTextColor (Color.rgb (171, 235, 198));
                                        l2.setTextSize (12f);
                                        l2.enableDashedLine (4, 2, 0);
                                        leftAxis.addLimitLine (l2);

                                        set1.setMode (LineDataSet.Mode.HORIZONTAL_BEZIER);
                                        set2.setMode (LineDataSet.Mode.HORIZONTAL_BEZIER);

                                        ArrayList<ILineDataSet> dataSets = new ArrayList<> ( );
                                        dataSets.add (set1);
                                        dataSets.add (set2);

                                        LineData dataa = new LineData (dataSets);
                                        chart.setData (dataa);
                                        chart.invalidate ( );
                                        chart.animateXY (1000, 1000);


                                    } else {
//                                        Toast.makeText (getContext ( ), "bp not found", Toast.LENGTH_SHORT).show ( );
                                        chart.invalidate();
                                        chart.clear();
                                    }
                                }

                            } catch (JSONException e) {
                                Log.d ("error", "found error 1" + e);
                            }
                            catch (IndexOutOfBoundsException e){
                                Log.d ("error", "found error 2");
                            }
                            catch (Exception e){
                                Log.d ("error", "found error 3");
                            }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse response = error.networkResponse;
                String errorMsg = "something happened";
                if(response != null && response.data != null){
                    String errorString = new String(response.data);
                    Log.i("log error", errorString);
                }
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                params.put("Authorization", "Token " + DoctorScreen.session.getUserDetails().get("Token"));
                return params;
            }
        };
        ApplicationController.getInstance().addToRequestQueue(jsonObjReq);
    }
}
