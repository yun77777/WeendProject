package com.example.myapplication;


import kr.co.bootpay.Bootpay;
//import kr.co.bootpay.model.request.*;
//import kr.co.bootpay.model.response.ResDefault;
//import kr.co.bootpay.model.response.data.*;

import java.util.HashMap;

public class BootpayExample {
    static BootpayTest bootpay;
    public static void main(String[] args) {
        bootpay = new BootpayTest("5b8f6a4d396fa665fdc2b5ea", "rm6EYECr6aroQVG2ntW0A6LpWnkTgP4uQ3H18sDDUYw=");

        goGetToken();
//        goVerfity();
//        receiptCancel();
//        getBillingKey();
//        requestSubscribe();
//        reserveSubscribe();
//        reserveCancelSubscribe();
//        destroyBillingKey();
//        getUserToken();
//        requestLink();
//        submit();
//        certificate();
    }

    public static void goGetToken() {
        try {
            ResDefault<HashMap<String, Object>> res = bootpay.getAccessToken();

//            String str = IOUtils.toString(res.getEntity().getContent(), "UTF-8");
//            ResToken resToken = new Gson().fromJson(str, ResToken.class);
            System.out.println(res.toJson());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void getBillingKey() {
//        Subscribe subscribe = new Subscribe();
//        subscribe.itemName = "정기결제 테스트 아이템";
//        subscribe.orderId = "" + (System.currentTimeMillis() / 1000);
//        subscribe.pg = "nicepay";
//        subscribe.cardNo = "5570**********1074"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
//        subscribe.cardPw = "**"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
//        subscribe.expireYear = "**"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
//        subscribe.expireMonth = "**"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
//        subscribe.identifyNumber = ""; //주민등록번호 또는 사업자 등록번호 (- 없이 입력)
//
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.getBillingKey(subscribe);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void destroyBillingKey() {
//        try {
//            ResDefault res = bootpay.destroyBillingKey("6100e7ea0d681b001fd4de69");
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void requestSubscribe() {
//        SubscribePayload payload = new SubscribePayload();
//        payload.billingKey = "6100e8c80d681b001dd4e0d7";
//        payload.itemName = "아이템01";
//        payload.price = 1000;
//        payload.orderId = "" + (System.currentTimeMillis() / 1000);
//
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.requestSubscribe(payload);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void reserveSubscribe() {
//        SubscribePayload payload = new SubscribePayload();
//
//        payload.billingKey = "6100e77a0d681b002ad4e5d9";
//        payload.itemName = "아이템01";
//        payload.price = 1000;
//        payload.orderId = "" + (System.currentTimeMillis() / 1000);
//        payload.executeAt = (System.currentTimeMillis() / 1000) + 10000;
//
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.reserveSubscribe(payload);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void reserveCancelSubscribe() {
//        try {
//            ResDefault res = bootpay.reserveCancelSubscribe("6100e892019943002150fef3");
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void receiptCancel() {
//        Cancel cancel = new Cancel();
//        cancel.receiptId = "6100e77a019943003650f4d5";
//        cancel.name = "관리자";
//        cancel.reason = "테스트 결제";
////        cancel.price = 1000.0; //부분취소 요청시 지정
////        cancel.
//
////        String receipt_id = "";
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.receiptCancel(cancel);
////            String str = IOUtils.toString(res.getEntity().getContent(), "UTF-8");
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void getUserToken() {
//        UserToken userToken = new UserToken();
//        userToken.userId = "1234";
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.getUserToken(userToken);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void requestLink() {
//        Payload payload = new Payload();
//        payload.orderId = "1234";
//        payload.price = 1000;
//        payload.name = "테스트 결제";
//        payload.pg = "nicepay";
//
//
////        subscribeBilling.itemName = "정기결제 테스트 아이템";
////        subscribeBilling.orderId = "" + (System.currentTimeMillis() / 1000);
////        subscribeBilling.pg = "nicepay";
////        subscribeBilling.cardNo = "5570**********1074"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
////        subscribeBilling.cardPw = "**"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
////        subscribeBilling.expireYear = "**"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
////        subscribeBilling.expireMonth = "**"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
////        subscribeBilling.identifyNumber = ""; //주민등록번호 또는 사업자 등록번호 (- 없이 입력)
//
//        try {
//            ResDefault res = bootpay.requestLink(payload);
////            String str = IOUtils.toString(res.getEntity().getContent(), "UTF-8");
//            System.out.println(res.data);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void submit() {
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.submit("6100e8e7019943003850f9b0");
////            String str = IOUtils.toString(res.getEntity().getContent(), "UTF-8");
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void goVerfity() {
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.verify("6100e8e7019943003850f9b0");
////            String str = IOUtils.toString(res.getEntity().getContent(), "UTF-8");
//            System.out.println(res.data);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void certificate() {
//
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.certificate("593f8febe13f332431a8ddae");
////            String str = IOUtils.toString(res.getEntity().getContent(), "UTF-8");
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}