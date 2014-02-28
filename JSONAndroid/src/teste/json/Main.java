package teste.json;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView t = (TextView) findViewById(R.id.text);
        TextView t2 = (TextView) findViewById(R.id.text2);
        TextView t3 = (TextView) findViewById(R.id.text3);
        TextView t4 = (TextView) findViewById(R.id.text4);
 
        String url = "http://192.168.0.102:8080/JSONTeste/Server";
        String url2 = "http://192.168.0.102:8080/JSONTeste/Server2";
        
        WebService webService = new WebService(url);
        WebService webService2 = new WebService(url2);

        //passa parametros para o servidor se preciso...porém não será
        Map params = new HashMap();
        params.put("var", "Uhul");

        //Pega a resposta do servidor

        String response = webService.webGet("", params);
        String response2 = webService2.webGet("", params);

        try {
        	//Seta a resposta como um objeto JSON para acessar as informações
			JSONObject o = new JSONObject(response);
			String out = o.get("1").toString();
			t.setText("Nome da cidade: "+out);
			
			out = o.get("2").toString();
			t2.setText("Nome da cidade: "+out);
			
			JSONObject o2 = new JSONObject(response2);
			String out2 = o2.get("1").toString();
			t3.setText("Endereço da seção: "+out2);
			
			out2 = o2.get("2").toString();
			t4.setText("Endereço da seção: "+out2);
			
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    }
}