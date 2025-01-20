package spring.library.controller.response;

import lombok.Builder;
import lombok.Data;
import spring.library.dto.MemberDto;

@Data
@Builder
public class MemberResponse {
    private String name;
    private String idNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    public static MemberResponse from(MemberDto memberDto) {
        return MemberResponse.builder()
                .name(memberDto.getName())
                .idNumber(memberDto.getIdNumber())
                .feature(memberDto.getFeature())
                .email(memberDto.getEmail())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }
}
