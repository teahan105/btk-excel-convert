package model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "users_packages")
public class UsersPackage {
    @Id
    @ColumnDefault("nextval('users_packages_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id")
    private Package packageField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_service_result_id")
    private PackageServiceResult packageServiceResult;

    @Column(name = "service_type", length = Integer.MAX_VALUE)
    private String serviceType;

    @Column(name = "status", length = 20)
    private String status;

    @ColumnDefault("now()")
    @Column(name = "purchased_at")
    private Instant purchasedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Package getPackageField() {
        return packageField;
    }

    public void setPackageField(Package packageField) {
        this.packageField = packageField;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public PackageServiceResult getPackageServiceResult() {
        return packageServiceResult;
    }

    public void setPackageServiceResult(PackageServiceResult packageServiceResult) {
        this.packageServiceResult = packageServiceResult;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getPurchasedAt() {
        return purchasedAt;
    }

    public void setPurchasedAt(Instant purchasedAt) {
        this.purchasedAt = purchasedAt;
    }

}