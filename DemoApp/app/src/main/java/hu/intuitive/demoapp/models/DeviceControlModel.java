package hu.intuitive.demoapp.models;


public class DeviceControlModel
{
    private Integer deviceChannel;
    private Integer value;
    private String deviceType;

    public Integer getDeviceChannel()
    {
        return deviceChannel;
    }

    public void setDeviceChannel(Integer deviceChannel)
    {
        this.deviceChannel = deviceChannel;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

    public String getDeviceType()
    {
        return deviceType;
    }

    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }
}
