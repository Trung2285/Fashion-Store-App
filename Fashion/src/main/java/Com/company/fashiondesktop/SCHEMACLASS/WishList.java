package Com.company.fashiondesktop.SCHEMACLASS;

import java.util.List;

import jakarta.persistence.*;

@Entity

public class WishList {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int wishListId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "wishList")
    private List<WishListDetail> listWishListDetails;

}
