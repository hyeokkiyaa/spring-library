package spring.library.controller.response;

import lombok.Builder;
import lombok.Data;
import spring.library.dto.MemberDto;

@Data
@Builder
public class MemberResponse {
    private String name;
    private int age;

    public static MemberResponse from(MemberDto memberDto) {
        return MemberResponse.builder()
                .name(memberDto.getName())
                .age(memberDto.getAge())
                .build();
    }
}
