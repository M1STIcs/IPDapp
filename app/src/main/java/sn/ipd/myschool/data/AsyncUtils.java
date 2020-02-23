package sn.ipd.myschool.data;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

public class AsyncUtils {
    private void requestJSON(String url) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject obj = new JSONObject(response);

                            if (obj.getString("status").equals("OK")) {


                            } else {

                                //          Toast.makeText(LoginActivity.this, getString(R.string.error_parameters), Toast.LENGTH_SHORT).show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        //      Toast.makeText(getApplicationContext(), getString(R.string.error_connection), Toast.LENGTH_SHORT).show();
                    }
                });

        // request queue
        //  RequestQueue requestQueue = Volley.newRequestQueue(this);
        //  requestQueue.add(stringRequest);

    }
}
