package com.efrei.mockpaymentservice.model;

public class CreditCardInfos {

    private String pan;

    private String cvv;

    private String expirationDate;

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "PaymentInfos{" +
                "pan='" + pan + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
