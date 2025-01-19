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
    private int age;

    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .age(member.getAge())
                .build();
    }

    public static MemberDto from(MemberRequest memberRequest) {
        return MemberDto.builder()
                .name(memberRequest.getName())
                .age(memberRequest.getAge())
                .build();
    }
}
