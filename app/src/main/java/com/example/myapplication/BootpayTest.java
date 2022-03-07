package com.example.myapplication;

import android.util.Log;

import java.util.HashMap;

//import kr.co.bootpay.BootpayObject;
//import kr.co.bootpay.model.request.Cancel;
//import kr.co.bootpay.model.request.Payload;
//import kr.co.bootpay.model.request.Subscribe;
//import kr.co.bootpay.model.request.SubscribePayload;
//import kr.co.bootpay.model.request.UserToken;
//import kr.co.bootpay.model.response.ResDefault;
//import kr.co.bootpay.service.BillingService;
//import kr.co.bootpay.service.CancelService;
//import kr.co.bootpay.service.EasyService;
//import kr.co.bootpay.service.LinkService;
//import kr.co.bootpay.service.SubmitService;
//import kr.co.bootpay.service.TokenService;
//import kr.co.bootpay.service.VerificationService;
//
//
//import kr.co.bootpay.model.request.*;
//import kr.co.bootpay.model.response.ResDefault;
//import kr.co.bootpay.model.response.data.*;
//import kr.co.bootpay.service.*;
//import org.apache.http.HttpResponse;
//
//import java.util.HashMap;

public class BootpayTest extends BootpayObject {

        public BootpayTest(String rest_application_id, String private_key) {
            super(rest_application_id, private_key);
        }

        public BootpayTest(String rest_application_id, String private_key, String devMode) {
            super(rest_application_id, private_key, devMode);
        }

        //token
        public ResDefault<HashMap<String, Object>> getAccessToken() throws Exception {
            Log.d("getAT:", String.valueOf(this));

//            return CancelService.getAccessToken(this);
            return TokenService.getAccessToken(this);
        }

        //billing
//        public ResDefault<HashMap<String, Object>> getBillingKey(Subscribe subscribeBilling) throws Exception {
//            return BillingService.getBillingKey(this, subscribeBilling);
//        }
//        public ResDefault<HashMap<String, Object>> requestSubscribe(SubscribePayload payload) throws Exception {
//            return BillingService.requestSubscribe(this, payload);
//        }
//        public ResDefault<HashMap<String, Object>> reserveSubscribe(SubscribePayload payload) throws Exception {
//            return BillingService.reserveSubscribe(this, payload);
//        }
//        public ResDefault<HashMap<String, Object>> reserveCancelSubscribe(String reserve_id) throws Exception {
//            return BillingService.reserveCancelSubscribe(this, reserve_id);
//        }
//        public ResDefault<HashMap<String, Object>> destroyBillingKey(String billing_key) throws Exception {
//            return BillingService.destroyBillingKey(this, billing_key);
//        }
//
//        //cancel
        public ResDefault<HashMap<String, Object>> receiptCancel(Cancel cancel) throws Exception {
            return CancelService.receiptCancel(this, cancel);
        }
//
//        //easy
//        public ResDefault<HashMap<String, Object>> getUserToken(UserToken userToken) throws Exception {
//            return EasyService.getUserToken(this, userToken);
//        }
//
//        //link
//        public ResDefault<String> requestLink(Payload payload) throws Exception {
//            return LinkService.requestLink(this, payload);
//        }
//
//        //submit
//        public ResDefault<HashMap<String, Object>> submit(String receiptId) throws Exception {
//            return SubmitService.submit(this, receiptId);
//        }
//
//        //veriy
//        public ResDefault<HashMap<String, Object>> verify(String receiptId) throws Exception {
//            return VerificationService.verify(this, receiptId);
//        }
//        public ResDefault<HashMap<String, Object>> certificate(String receiptId) throws Exception {
//            return VerificationService.certificate(this, receiptId);
//        }
    }
