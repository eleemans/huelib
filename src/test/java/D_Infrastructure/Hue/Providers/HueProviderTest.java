package D_Infrastructure.Hue.Providers;

import D_Infrastructure.Hue.Entities.Group;
import D_Infrastructure.Hue.Entities.Light;
import D_Infrastructure.Hue.Entities.Lights;
import D_Infrastructure.Hue.Enums.LightType;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by eleemans on 26-7-2017.
 */
public class HueProviderTest {
    @Test
    public void getAllLights() throws Exception {
        HueProvider prov = new HueProvider("192.168.1.100");
        Lights lights = prov.getAllLights();
    }

    @Test
    public void getAllLightsType() throws Exception {
        HueProvider prov = new HueProvider("192.168.1.100");
        Lights lights = prov.getAllLights(LightType.DimmableLight);
    }

    @org.junit.Test
    public void getLamp() throws Exception {
        HueProvider prov = new HueProvider("192.168.1.100");
        Light light = prov.getLight(4);
    }

    @org.junit.Test
    public void getLamps() throws Exception {
        HueProvider prov = new HueProvider("192.168.1.100");
        Lights light = prov.getLights(new int[]{1,3});
    }

    @org.junit.Test
    public void getGroup() throws Exception {
        HueProvider prov = new HueProvider("192.168.1.100");
        Group group = prov.getGroup(1);
    }

    @org.junit.Test
    public void getLightsFromGroup() throws Exception {
        HueProvider prov = new HueProvider("192.168.1.100");
        Group group = prov.getGroup(1);
        Lights lights = prov.getLights(group.getLights());
        Assert.assertTrue(lights.size()==1);
    }

    @org.junit.Test
    public void setLightState() throws Exception {
        HueProvider prov = new HueProvider("192.168.1.100");
        Group group = prov.getGroup(4);
        Lights lights = prov.getLights(group.getLights());

        for(Light light : lights){
            prov.changeLightOnState(light,true);
        }

    }

}