package D_Infrastructure.Hue.Enums;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eleemans on 26-7-2017.
 */
public enum LightType {
    @SerializedName("Color light") ColorLight,
    @SerializedName("Dimmable light") DimmableLight,
    @SerializedName("Extended color light") ExtendedColorLight

}
