package fpt.aptech.day3uploadimage.model;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String magicname;//chú ý phải đặt char thường hết, đặt Hoa sẽ báo lỗi, nên đặt magic_name hơn là magicName
    @Column
    private int manacost;
    @Column
    private String image;

    public Images() {
    }

    public Images(int id, String magicname, int manacost, String image) {
        this.id = id;
        this.magicname = magicname;
        this.manacost = manacost;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMagicname() {
        return magicname;
    }

    public void setMagicname(String magicname) {
        this.magicname = magicname;
    }

    public int getManacost() {
        return manacost;
    }

    public void setManacost(int manacost) {
        this.manacost = manacost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //get path display image upload
    @Transient
    public String getImagePath(){
        if (image == null) {
            return null;
        }
        return "/images/" + id + "/" + image; //tra ve link source image neu co image
    }
}
