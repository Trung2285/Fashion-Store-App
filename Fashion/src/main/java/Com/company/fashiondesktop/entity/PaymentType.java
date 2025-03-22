package Com.company.fashiondesktop.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity

public class PaymentType {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int paymentTypeID;

    @Column(columnDefinition = "NVARCHAR(500)")
    private String paymentTypeName;

    private String description;

    private double fee;

    @OneToMany(mappedBy = "paymentType")
    private List<Order> listOrder;
}
