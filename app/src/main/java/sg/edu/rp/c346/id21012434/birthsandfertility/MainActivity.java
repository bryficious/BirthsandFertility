package sg.edu.rp.c346.id21012434.birthsandfertility;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView lvBirth;
    AsyncHttpClient client;
    ArrayAdapter<Birth> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvBirth = findViewById(R.id.lvBirth);
        client = new AsyncHttpClient();

    }
    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Birth> alBirth = new ArrayList<Birth>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=55f8c651-6c18-4017-b1f4-f4c4b65785e2&limit=10", new JsonHttpResponseHandler() {

            String level_1;
            String value;
            String year;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {

                    JSONObject firstObj = response.getJSONObject("result");
                    JSONArray jsonArrBirth = firstObj.getJSONArray("records");
                    for(int i = 0; i < jsonArrBirth.length(); i++) {
                        JSONObject jsonObjBirth = jsonArrBirth.getJSONObject(i);
                        level_1 = jsonObjBirth.getString("level_1");
                        value = jsonObjBirth.getString("value");
                        year = jsonObjBirth.getString("year");
                        Birth birth = new Birth( level_1, value, year);
                        alBirth.add(birth);
                    }
                }
                catch(JSONException e){

                }

                //POINT X – Code to display List View
                adapter = new ArrayAdapter<Birth>(MainActivity.this, android.R.layout.simple_list_item_1, alBirth);
                lvBirth.setAdapter(adapter);

            }//end onSuccess
        });
    }//end onResume
}