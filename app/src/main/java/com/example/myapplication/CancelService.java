package com.example.myapplication;

import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CancelService {

    static public ResDefault<HashMap<String, Object>> receiptCancel(BootpayObject bootpay, Cancel cancel) throws Exception {
        Log.d("bootpay:", String.valueOf(bootpay));
        Log.d("bootpay.token:", String.valueOf(bootpay.token));

        if(bootpay.token == null || bootpay.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");
        if(cancel.receiptId == null || cancel.receiptId.isEmpty()) throw new Exception("receiptId 값을 입력해주세요.");


        Token token = new Token();
        token.application_id = bootpay.application_id;
        token.private_key = bootpay.private_key;

        Retrofit retrofit;
        PgApiService service;
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request newRequest  = chain.request().newBuilder()
                                .addHeader("Authorization", bootpay.token)
                                .build();
                        return chain.proceed(newRequest);
                    }
                }).build();

        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(DevMode.PRODUCTION)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PgApiService.class);

        Log.d("retrofit:",retrofit.toString());
        Log.d("service:",service.toString());
        Log.d("service:", new Gson().toJson(token));
        ResDefault res = new ResDefault();

        Call<ResponseBody> call_post = service.cancel(token);
        call_post.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("response@@@@@@@@:", String.valueOf(response));

//                if (response.isSuccessful()) {
                String result = null;
                try {
                    result = response.body().string();
                    Log.d("result:", result);
                    Log.d("response.body().contentType():", String.valueOf(response.body().contentType()));
                    JsonParser jsonParser = new JsonParser();
                    JsonElement element = jsonParser.parse(result);

                } catch (IOException e) {
                    e.printStackTrace();
                }
//                    Log.d("result:", result);
//                    Log.d("response.body().contentType():", String.valueOf(response.body().contentType()));
//                    JsonParser jsonParser = new JsonParser();
//                    JsonElement element = jsonParser.parse(result);

//                Type resTokenType = new TypeToken<ResDefault<TokenData>>(){}.getType();
//                ResDefault<TokenData> resToken = new Gson().fromJson(result, resTokenType);
//                if(resToken.status == 200)
//                    bootpay.token = resToken.data.token;

                Type resType = new TypeToken<ResDefault<HashMap<String, Object>>>(){}.getType();
                ResDefault res = new Gson().fromJson(result, resType);
                Log.d("res:", String.valueOf(res));


                //                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("onFailure(): ", String.valueOf(call));
            }
        });

//        HttpClient client = HttpClientBuilder.create().build();
//        Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .create();
//        HttpPost post = bootpay.httpPost("cancel", new StringEntity(gson.toJson(cancel), "UTF-8"));
//        post.setHeader("Authorization", bootpay.token);
//        HttpResponse response = client.execute(post);
//        String str = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
//
//        Type resType = new TypeToken<ResDefault<HashMap<String, Object>>>(){}.getType();
//        ResDefault res = new Gson().fromJson(str, resType);

        return res;
    }
}