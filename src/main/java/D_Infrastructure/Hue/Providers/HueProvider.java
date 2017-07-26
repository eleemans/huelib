package D_Infrastructure.Hue.Providers;

import D_Infrastructure.Hue.Entities.DimmableLight;
import D_Infrastructure.Hue.Entities.Group;
import D_Infrastructure.Hue.Entities.Light;
import D_Infrastructure.Hue.Entities.Lights;
import D_Infrastructure.Hue.Enums.LightType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by eleemans on 26-7-2017.
 */
public class HueProvider {

    private String _bridgeAdress;

    public HueProvider(String bridgeAdress){
        this._bridgeAdress = bridgeAdress;
    }



    public Lights getAllLights() throws Exception{
        String urlString = "http://" + _bridgeAdress + "/api/3ZOsgLFiHz-zHKGzotEcTBjhCU9umJHgX0RdFn5O/lights";
        String responseString;
        URL url = new URL(urlString);
        Lights result = new Lights();

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }

        responseString=response.toString();

        in.close();

        Type map = new TypeToken<HashMap<String,Light>>(){}.getType();

        HashMap<String,Light> mapResult = new Gson().fromJson(responseString, map);
        Set<Map.Entry<String,Light>> set = mapResult.entrySet();

        for(Map.Entry<String,Light> entry: set){
            Light EntryLight = entry.getValue();
            EntryLight.setLampId(Integer.parseInt(entry.getKey()));
            result.add(EntryLight);
        }

        return result;
    }

    public Lights getAllLights(LightType lightType) throws Exception{

        Lights result = new Lights();
        Lights lights = getAllLights();

        for(Light light: lights){
            if(light.getType()==lightType){
                result.add(light);
            }
        }
        return result;
    }


    public Light getLight(int id) throws Exception{

        String urlString = "http://" + _bridgeAdress + "/api/3ZOsgLFiHz-zHKGzotEcTBjhCU9umJHgX0RdFn5O/lights/" + id;
        String responseString;
        URL url = new URL(urlString);
        Light result;

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }

        responseString=response.toString();

        in.close();


        result = new Gson().fromJson(responseString, Light.class);
        result.setLampId(id);

        return result;

    }

    public Group getGroup(int id) throws Exception{

        String urlString = "http://" + _bridgeAdress + "/api/3ZOsgLFiHz-zHKGzotEcTBjhCU9umJHgX0RdFn5O/groups/" + id;
        String responseString;
        URL url = new URL(urlString);
        Group result;

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }

        responseString=response.toString();

        in.close();


        result = new Gson().fromJson(responseString, Group.class);

        return result;

    }



    public Lights getLights(int[] ids) throws Exception{

        Lights result = new Lights();

        for(int i : ids){
            result.add(getLight(i));
        }

        return result;

    }


    public void changeLightOnState(Light light, boolean onstate) throws Exception{

        URL url = new URL("http://"+ _bridgeAdress +"/api/3ZOsgLFiHz-zHKGzotEcTBjhCU9umJHgX0RdFn5O/lights/"+ light.getLampId() +"/state/on");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(
                httpCon.getOutputStream());
        out.write("{\"on\": "+onstate+"}");
        out.close();

        httpCon.getInputStream();
        int responseCode = httpCon.getResponseCode();


    }

    public void changeLightDimValue(DimmableLight light, int value) throws Exception{

        URL url = new URL("http://"+ _bridgeAdress +"/api/3ZOsgLFiHz-zHKGzotEcTBjhCU9umJHgX0RdFn5O/lights/"+ light.getLampId() +"/state/on");



    }





}
