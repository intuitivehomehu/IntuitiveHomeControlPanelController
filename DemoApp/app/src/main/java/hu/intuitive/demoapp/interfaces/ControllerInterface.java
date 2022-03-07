package hu.intuitive.demoapp.interfaces;

import java.util.Map;

import hu.intuitive.demoapp.models.ControllerResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ControllerInterface
{
    @GET("/outs.cgi")
    Call<ControllerResponseModel> controllerControl(@QueryMap Map<String, Integer> paramsMap);
}
