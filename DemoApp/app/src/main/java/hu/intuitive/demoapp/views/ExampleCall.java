package hu.intuitive.demoapp.views;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.HashMap;

import hu.intuitive.demoapp.interfaces.ControllerAPI;
import hu.intuitive.demoapp.interfaces.ControllerInterface;
import hu.intuitive.demoapp.models.ControllerResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExampleCall
{
    private static final String TAG = "EXAMPLE_CALL";

    public void ExampleCallMethod()
    {
        //Example
        ControllerInterface call = ControllerAPI.getControllerClient("YOUR DEVICE URL").create(ControllerInterface.class);
        call.controllerControl(new HashMap<>()).enqueue(new Callback<ControllerResponseModel>()
        {
            @Override
            public void onResponse(@NonNull Call<ControllerResponseModel> call, @NonNull Response<ControllerResponseModel> response)
            {
                Log.d(TAG, "controller_onSuccess: " + response.body().getInputs());
                Log.d(TAG, "controller_onSuccess: " + response.body().getOutputs());
                Log.d(TAG, "controller_onSuccess: " + response.body().getRelay());

                //TODO insert your methods here
            }

            @Override
            public void onFailure(Call<ControllerResponseModel> call, Throwable t)
            {
                Log.d(TAG, "controller_onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}
