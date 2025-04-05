package Com.company.fashiondesktop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ward")
public class Ward {
    @Id
    Integer wardID;
    String wardName;
    @ManyToOne
    private District district;

    public Ward() {
    }

    public Ward(Integer wardID, String wardName, District district) {
        this.wardID = wardID;
        this.wardName = wardName;
        this.district = district;
    }

    public Integer getWardID() {
        return wardID;
    }

    public void setWardID(Integer wardID) {
        this.wardID = wardID;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
