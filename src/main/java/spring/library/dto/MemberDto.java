package spring.library.dto;

import lombok.*;
import spring.library.controller.request.MemberRequest;
import spring.library.domain.Member;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MemberDto {
    private Long id;
    private String name;
    private String idNumber;
    private String feature;
    private String email;
    private String phoneNumber;

    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .idNumber(member.getIdNumber())
                .feature(member.getFeature())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }

    public static MemberDto from(MemberRequest memberRequest) {
        return MemberDto.builder()
                .name(memberRequest.getName())
                .idNumber(memberRequest.getIdNumber())
                .feature(memberRequest.getFeature())
                .email(memberRequest.getEmail())
                .phoneNumber(memberRequest.getPhoneNumber())
                .build();
    }
}
