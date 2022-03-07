package hu.intuitive.demoapp.models;

import java.math.BigDecimal;

public class Device
{
    private Integer id;
    private String serialNumber;
    private ControlUnit controlUnit;
    private DeviceType deviceType;
    private Boolean alarmState;
    private String alarmStatus;
    private Integer displayOrder;
    private String deviceStatus;
    private String displayName;
    private BigDecimal measuredValue;
    private BigDecimal currentTemp = new BigDecimal(0);
    private BigDecimal secondaryValue = new BigDecimal(0);
    private Long startImpulse;
    private Long startCounter;
    private Integer major;
    private Integer minor;
    private Integer channelPrimary;
    private Integer channelSecondary;
    private Integer powerChannel;
    private boolean digitalState;
    private boolean digitalStateSecondary;

    public void setDevice(Device device)
    {
        this.id = device.getId();
        this.serialNumber = device.getSerialNumber();
        this.deviceType = device.getDeviceType();
        this.alarmState = device.getAlarmState();
        this.displayOrder = device.getDisplayOrder();
        this.deviceStatus = device.getDeviceStatus();
        this.displayName = device.getDisplayName();
        this.currentTemp = device.getCurrentTemp();
        this.measuredValue = device.getMeasuredValue();
        this.alarmStatus = device.getAlarmStatus();
        this.channelPrimary = device.getChannelPrimary();
        this.channelPrimary = device.getChannelSecondary();
        this.digitalState = device.isDigitalState();
        this.digitalStateSecondary = device.isDigitalStateSecondary();
        this.powerChannel = device.getPowerChannel();
        this.controlUnit = device.getControlUnit();
        this.startCounter = device.getStartCounter();
        this.startImpulse = device.getStartImpulse();
    }

    public Long getStartImpulse()
    {
        return startImpulse;
    }

    public void setStartImpulse(Long startImpulse)
    {
        this.startImpulse = startImpulse;
    }

    public Long getStartCounter()
    {
        return startCounter;
    }

    public void setStartCounter(Long startCounter)
    {
        this.startCounter = startCounter;
    }

    public ControlUnit getControlUnit()
    {
        return controlUnit;
    }

    public void setControlUnit(ControlUnit controlUnit)
    {
        this.controlUnit = controlUnit;
    }

    public Integer getPowerChannel()
    {
        return powerChannel;
    }

    public void setPowerChannel(Integer powerChannel)
    {
        this.powerChannel = powerChannel;
    }

    public boolean isDigitalStateSecondary()
    {
        return digitalStateSecondary;
    }

    public void setDigitalStateSecondary(boolean digitalStateSecondary)
    {
        this.digitalStateSecondary = digitalStateSecondary;
    }

    public boolean isDigitalState()
    {
        return digitalState;
    }

    public void setDigitalState(boolean digitalState)
    {
        this.digitalState = digitalState;
    }

    public Integer getChannelPrimary()
    {
        return channelPrimary;
    }

    public void setChannelPrimary(Integer channelPrimary)
    {
        this.channelPrimary = channelPrimary;
    }

    public Integer getChannelSecondary()
    {
        return channelSecondary;
    }

    public void setChannelSecondary(Integer channelSecondary)
    {
        this.channelSecondary = channelSecondary;
    }

    public String getAlarmStatus()
    {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus)
    {
        this.alarmStatus = alarmStatus;
    }

    public BigDecimal getMeasuredValue()
    {
        return measuredValue;
    }

    public void setMeasuredValue(BigDecimal measuredValue)
    {
        this.measuredValue = measuredValue;
    }

    public BigDecimal getCurrentTemp()
    {
        return currentTemp;
    }

    public void setCurrentTemp(BigDecimal currentTemp)
    {
        this.currentTemp = currentTemp;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public DeviceType getDeviceType()
    {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType)
    {
        this.deviceType = deviceType;
    }

    public Boolean getAlarmState()
    {
        return alarmState;
    }

    public void setAlarmState(Boolean alarmState)
    {
        this.alarmState = alarmState;
    }

    public Integer getDisplayOrder()
    {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder)
    {
        this.displayOrder = displayOrder;
    }

    public String getDeviceStatus()
    {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus)
    {
        this.deviceStatus = deviceStatus;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public Integer getMajor()
    {
        return major;
    }

    public void setMajor(Integer major)
    {
        this.major = major;
    }

    public Integer getMinor()
    {
        return minor;
    }

    public void setMinor(Integer minor)
    {
        this.minor = minor;
    }


    public Device()
    {
    }


    public BigDecimal getSecondaryValue()
    {
        return secondaryValue;
    }

    public void setSecondaryValue(BigDecimal secondaryValue)
    {
        this.secondaryValue = secondaryValue;
    }
}
