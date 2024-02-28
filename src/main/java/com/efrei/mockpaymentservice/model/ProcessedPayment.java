package com.efrei.mockpaymentservice.model;

public class ProcessedPayment {
    private String paymentId;
    private PaymentResult paymentResult;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentResult getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(PaymentResult paymentResult) {
        this.paymentResult = paymentResult;
    }

    @Override
    public String toString() {
        return "ProcessedPayment{" +
                "userId='" + paymentId + '\'' +
                ", paymentResult=" + paymentResult +
                '}';
    }
}