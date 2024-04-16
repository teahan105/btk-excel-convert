package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('payments_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "order_no", length = Integer.MAX_VALUE)
    private String orderNo;

    @Column(name = "bank_code", length = Integer.MAX_VALUE)
    private String bankCode;

    @Column(name = "payment_date")
    private Instant paymentDate;

    @Column(name = "payment_status")
    private Integer paymentStatus;

    @Column(name = "bank_ref_code", length = Integer.MAX_VALUE)
    private String bankRefCode;

    @Column(name = "current_datetime")
    private Instant currentDatetime;

    @Column(name = "payment_description", length = Integer.MAX_VALUE)
    private String paymentDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getBankRefCode() {
        return bankRefCode;
    }

    public void setBankRefCode(String bankRefCode) {
        this.bankRefCode = bankRefCode;
    }

    public Instant getCurrentDatetime() {
        return currentDatetime;
    }

    public void setCurrentDatetime(Instant currentDatetime) {
        this.currentDatetime = currentDatetime;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }

}