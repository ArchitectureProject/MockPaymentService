package com.efrei.mockpaymentservice.model;

public class ReceivedPaymentAttempt {
    private String paymentId;
    private float amount;
    private CreditCardInfos creditCardInfos;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public CreditCardInfos getCreditCardInfos() {
        return creditCardInfos;
    }

    public void setCreditCardInfos(CreditCardInfos creditCardInfos) {
        this.creditCardInfos = creditCardInfos;
    }

    @Override
    public String toString() {
        return "ReceivedPaymentAttempt{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", paymentInfos=" + creditCardInfos +
                '}';
    }
}
