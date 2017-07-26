package D_Infrastructure.Hue.Entities;

import D_Infrastructure.Hue.Enums.LightType;

/**
 * Created by eleemans on 26-7-2017.
 */
public class Light {
    private int lampId;
    private LightState lightState;
    private LightType type;
    private String name;
    private String modelid;
    private String manufacturername;
    private String uniqueid;
    private String swversion;

    public LightState getLightState() {
        return lightState;
    }

    public void setLightState(LightState lightState) {
        this.lightState = lightState;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelid() {
        return modelid;
    }

    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    public String getManufacturername() {
        return manufacturername;
    }

    public void setManufacturername(String manufacturername) {
        this.manufacturername = manufacturername;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getSwversion() {
        return swversion;
    }

    public void setSwversion(String swversion) {
        this.swversion = swversion;
    }

    public LightType getType() {
        return type;
    }

    public void setType(LightType type) {
        this.type = type;
    }

    public void setLampId(int lampId) {
        this.lampId = lampId;
    }

    public int getLampId() {
        return lampId;
    }
}
