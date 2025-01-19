package spring.library.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.request.MemberRequest;
import spring.library.controller.response.MemberResponse;
import spring.library.dto.MemberDto;
import spring.library.service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> showAllMembers() {
        List<MemberResponse> members = memberService.findAll().stream().map(MemberResponse::from).toList();
        return ResponseEntity.ok().body(members);
    }

    @PostMapping("/add")
    public ResponseEntity<MemberResponse> addMember(@RequestBody MemberRequest memberRequest) {
        MemberDto memberDto = memberService.save(memberRequest);
        return ResponseEntity.ok().body(MemberResponse.from(memberDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MemberResponse> deleteMember(@PathVariable Long id) {
        memberService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
