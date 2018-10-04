package com.example.aasim.volley_web;



         import android.support.v7.app.AppCompatActivity;
         import android.os.Bundle;
         import android.view.View;
         import android.widget.Button;
         import android.widget.EditText;
         import android.widget.Toast;

         import com.android.volley.AuthFailureError;
         import com.android.volley.Request;
         import com.android.volley.RequestQueue;
         import com.android.volley.Response;
         import com.android.volley.VolleyError;
         import com.android.volley.toolbox.StringRequest;
         import com.android.volley.toolbox.Volley;

         import java.util.HashMap;
         import java.util.Map;

public class MainActivity extends AppCompatActivity
{

    String url="https://mohdaasim71.000webhostapp.com/register.php";


    EditText e1,e2,e3;

    Button btn;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1= (EditText) findViewById(R.id.editText);
        e2= (EditText) findViewById(R.id.editText2);
        e3= (EditText) findViewById(R.id.editText3);

        btn= (Button) findViewById(R.id.button);

        requestQueue= Volley.newRequestQueue(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        String msg=response.toString();

                        Toast.makeText(MainActivity.this, ""+msg, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, ""+error.getMessage()
                                , Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<String, String>();

                        params.put("name", e1.getText().toString().trim());
                        params.put("contact", e2.getText().toString().trim());
                        params.put("address", e3.getText().toString().trim());

                        return params;
                    }

                };

                requestQueue.add(request);

            }
        });

    }
}
