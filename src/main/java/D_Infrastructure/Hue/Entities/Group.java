package D_Infrastructure.Hue.Entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eleemans on 26-7-2017.
 */
public class Group {
    private String name;
    private int[] lights;
    private String type;
    private GroupState state;
    private boolean recycle;
    @SerializedName("class")
    private String groupClass;
    private GroupAction action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getLights() {
        return lights;
    }

    public void setLights(int[] lights) {
        this.lights = lights;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GroupState getState() {
        return state;
    }

    public void setState(GroupState state) {
        this.state = state;
    }

    public boolean isRecycle() {
        return recycle;
    }

    public void setRecycle(boolean recycle) {
        this.recycle = recycle;
    }

    public String getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(String groupClass) {
        this.groupClass = groupClass;
    }

    public GroupAction getAction() {
        return action;
    }

    public void setAction(GroupAction action) {
        this.action = action;
    }
}
