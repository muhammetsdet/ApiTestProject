package pojoDatas;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //Bazen fazladan data yada cookies gelebilir bunun hata vermemesi için hataları görmez test geçer
public class GoRestApiPojo {

 /*
                     {
        "id": 7511416,
        "name": "Msgr. Chaturbhuj Bhat",
        "email": "bhat_msgr_chaturbhuj@skiles.example",
        "gender": "female",
        "status": "active"
    }
     */

    private String id;
    private String name;
    private String email;
    private String gender;
    private String status;

    public GoRestApiPojo(){

    }

    public GoRestApiPojo(String id, String name, String email, String gender, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GoRestApiPojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
