package Com.company.fashiondesktop.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity

public class ShippingMethod {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int shippingMethodID;

    private String shippingMethodName;

    @Column(columnDefinition = "NVARCHAR(256)")
    private String description;
    private double fee;
    @OneToMany(mappedBy = "shippingMethod")
    private List<Order> listOrder;

}
