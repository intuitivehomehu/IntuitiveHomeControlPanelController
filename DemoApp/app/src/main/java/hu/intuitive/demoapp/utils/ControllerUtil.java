package hu.intuitive.demoapp.utils;

import hu.intuitive.demoapp.models.ControllerResponseModel;
import hu.intuitive.demoapp.models.DeviceControlModel;

public class ControllerUtil
{
    public static Integer ControlValueProcessor(ControllerResponseModel controllerResponseModel, DeviceControlModel deviceControlModel)
    {
        return 0;
    }

    public static Long controlCounterProcess(ControllerResponseModel controllerResponseModel, DeviceControlModel deviceControlModel)
    {
        return controllerResponseModel.getCounters().get(deviceControlModel.getDeviceChannel());
    }

    public static String getControllerChannel(Integer channel)
    {
        return channel > 4 ? "o" : "r";
    }

    public static Integer getControllerChannelNumber(Integer channel)
    {
        return channel > 4 ? channel - 4 : channel;
    }
}