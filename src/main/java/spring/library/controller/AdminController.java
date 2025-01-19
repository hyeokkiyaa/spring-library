package spring.library.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.library.controller.request.MemberRequest;
import spring.library.controller.response.MemberResponse;
import spring.library.dto.MemberDto;
import spring.library.repository.MemberRepository;
import spring.library.service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> showAllMembers() {
        List<MemberResponse> members = memberService.findAll().stream().map(MemberResponse::from).toList();
        return ResponseEntity.ok().body(members);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<MemberResponse> showMember(@PathVariable Long id) {
        MemberDto memberDto = memberService.findById(id);
        return ResponseEntity.ok().body(MemberResponse.from(memberDto));
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

    @PatchMapping("/member/{id}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long id, @RequestBody MemberRequest memberRequest) {
        MemberDto memberDto = memberService.update(id, memberRequest);
        return ResponseEntity.ok().body(MemberResponse.from(memberDto));
    }



}
