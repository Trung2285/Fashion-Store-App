package Com.company.fashiondesktop.SCHEMACLASS;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer districtID;
    private String districtName;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ward>wards;

    public District() {
    }

    public District(Integer districtID, String districtName, City city) {
        this.districtID = districtID;
        this.districtName = districtName;
        this.city = city;
    }

    public Integer getDistrictID() {
        return districtID;
    }

    public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
