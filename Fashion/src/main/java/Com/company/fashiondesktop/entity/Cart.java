package Com.company.fashiondesktop.entity;



import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int cartId;

    private Date createAt;

    private Date updateAt;

    private double totalPrices;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartDetail> listCartDetails;

}
