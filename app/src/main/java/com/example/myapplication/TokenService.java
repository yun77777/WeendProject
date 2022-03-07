package com.example.myapplication;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.example.myapplication.BootpayObject;
import com.example.myapplication.Token;
import com.example.myapplication.ResDefault;
import com.example.myapplication.TokenData;
import org.apache.commons.io.IOUtils;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import kr.co.bootpay.api.ApiService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TokenService {
    static public ResDefault<HashMap<String, Object>> getAccessToken(BootpayObject bootpay) throws Exception {
        Log.d("bootpay:",bootpay.application_id);
        Log.d("bootpay:",bootpay.private_key);

        if(bootpay.application_id == null || bootpay.application_id.isEmpty()) throw new Exception("application_id 값이 비어있습니다.");
        if(bootpay.private_key == null || bootpay.private_key.isEmpty()) throw new Exception("private_key 값이 비어있습니다.");

        Token token = new Token();
        token.application_id = bootpay.application_id;
        token.private_key = bootpay.private_key;

        Retrofit retrofit;
        PgApiService service;

        retrofit = new Retrofit.Builder()
                .baseUrl(DevMode.PRODUCTION)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PgApiService.class);

        Log.d("retrofit:",retrofit.toString());
        Log.d("service:",service.toString());
        Log.d("service:", new Gson().toJson(token));
        ResDefault res = new ResDefault();

        Call<ResponseBody> call_post = service.getAccessToken(token);
        call_post.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("response:", String.valueOf(response));

//                if (response.isSuccessful()) {
                    String result = null;
                    try {
                        result = response.body().string();
                        Log.d("result:", result);
                        Log.d("response.body().contentType():", String.valueOf(response.body().contentType()));
                        JsonParser jsonParser = new JsonParser();
                        JsonElement element = jsonParser.parse(result);

//                        String str = IOUtils.toString(response.getEntity().getContent(), "UTF-8");

                        Type resTokenType = new TypeToken<ResDefault<TokenData>>(){}.getType();
                        ResDefault<TokenData> resToken = new Gson().fromJson(result, resTokenType);
                        if(resToken.status == 200)
                            bootpay.token = resToken.data.token;

                        Type resType = new TypeToken<ResDefault<HashMap<String, Object>>>(){}.getType();
                        ResDefault res = new Gson().fromJson(result, resType);
                        Log.d("res:", String.valueOf(res));

//                        String msg = element.getAsJsonObject().get("msg").getAsString();
//                        String status = element.getAsJsonObject().get("status") != null ? element.getAsJsonObject().get("status").getAsString() : null;
//
//                        System.out.println("msg : " + msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                }
            }

              @Override
              public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("onFailure(): ", String.valueOf(call));
              }
          });



//        HttpClient client = HttpClientBuilder.create().build();

//        Log.d("client:", String.valueOf(client));
//
//        HttpPost post = bootpay.httpPost("request/token.json", new StringEntity(new Gson().toJson(token), "UTF-8"));
//
//        HttpResponse response = client.execute(post);
//        String str = IOUtils.toString(response.getEntity().getContent(), "UTF-8");

//        Type resTokenType = new TypeToken<ResDefault<TokenData>>(){}.getType();
//        ResDefault<TokenData> resToken = new Gson().fromJson(str, resTokenType);
//        if(resToken.status == 200)
//            bootpay.token = resToken.data.token;
//
//        Type resType = new TypeToken<ResDefault<HashMap<String, Object>>>(){}.getType();
//        ResDefault res = new Gson().fromJson(str, resType);
//        return res;

        return res;
    }
}