package hu.intuitive.demoapp.models;


public class ControlUnit
{
    private Integer id;
    private String user;
    private String serialNumber;
    private String address;
    private String type;
    private String lastDataSeq;
    private String lastControlSeq;
    private String lastDataDate;

    public ControlUnit()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getLastDataSeq()
    {
        return lastDataSeq;
    }

    public void setLastDataSeq(String lastDataSeq)
    {
        this.lastDataSeq = lastDataSeq;
    }

    public String getLastControlSeq()
    {
        return lastControlSeq;
    }

    public void setLastControlSeq(String lastControlSeq)
    {
        this.lastControlSeq = lastControlSeq;
    }

    public String getLastDataDate()
    {
        return lastDataDate;
    }

    public void setLastDataDate(String lastDataDate)
    {
        this.lastDataDate = lastDataDate;
    }
}