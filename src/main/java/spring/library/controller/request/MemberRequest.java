package spring.library.controller.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String name;
    private String idNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    public MemberRequest(String name, String idNumber, String feature, String email, String phoneNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.feature = feature;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
