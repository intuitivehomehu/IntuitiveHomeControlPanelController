package hu.intuitive.demoapp.models;

import java.math.BigDecimal;

public class DeviceType
{
    private Integer id;
    private String code;
    private String name;
    private Boolean ble;
    private Boolean bleScanner;
    private BigDecimal multiplier;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Boolean getBle()
    {
        return ble;
    }

    public void setBle(Boolean ble)
    {
        this.ble = ble;
    }

    public Boolean getBleScanner()
    {
        return bleScanner;
    }

    public void setBleScanner(Boolean bleScanner)
    {
        this.bleScanner = bleScanner;
    }

    public BigDecimal getMultiplier()
    {
        return multiplier;
    }

    public void setMultiplier(BigDecimal multiplier)
    {
        this.multiplier = multiplier;
    }

    public DeviceType()
    {
    }
}