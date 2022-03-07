package hu.intuitive.demoapp.models;

import java.util.List;

public class ControllerResponseModel
{
    private String inputs;
    private String outputs;
    private String relay;
    private Integer hb;
    private List<Long> counters = null;

    public String getInputs()
    {
        return inputs;
    }

    public void setInputs(String inputs)
    {
        this.inputs = inputs;
    }

    public String getOutputs()
    {
        return outputs;
    }

    public void setOutputs(String outputs)
    {
        this.outputs = outputs;
    }

    public String getRelay()
    {
        return relay;
    }

    public void setRelay(String relay)
    {
        this.relay = relay;
    }

    public Integer getHb()
    {
        return hb;
    }

    public void setHb(Integer hb)
    {
        this.hb = hb;
    }

    public List<Long> getCounters()
    {
        return counters;
    }

    public void setCounters(List<Long> counters)
    {
        this.counters = counters;
    }
}