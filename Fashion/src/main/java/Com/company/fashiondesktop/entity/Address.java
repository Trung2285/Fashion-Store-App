package Com.company.fashiondesktop.entity;



import jakarta.persistence.*;


import java.util.List;


@Entity

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @Column(columnDefinition = "NVARCHAR(256)")
    private String streetName;

    @Column(columnDefinition = "NVARCHAR(256)")
    private String cityName;

    @Column(columnDefinition = "NVARCHAR(256)")

    private String districtName;

    @Column(columnDefinition = "NVARCHAR(256)")
    private String wardName;


    @OneToMany(mappedBy = "address")
    private List<User> listUsers;

    @OneToMany(mappedBy = "shippingAddress")
    private List<Order> listOrders;

    @OneToMany(mappedBy = "address")
    private List<Supplier> listSuppliers;
}
