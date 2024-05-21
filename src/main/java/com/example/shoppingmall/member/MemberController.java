package com.example.shoppingmall.member;

import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.shoppingmall.member.Member.fromDtoToEntity;
import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;


@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {
    private MemberService memberService;
    @PostMapping("/join") // after
    public ApiUtils.ApiResult join(@Valid @RequestBody MemberDto memberDto) {

        if (isDuplicateId(memberDto)) {
            return error("아이디 중복", HttpStatus.CONFLICT);
        }

//        Member requestMember = fromDtoToEntity(memberDto);
        Member requestMember = memberDto.convertToEntity();
        String userId = memberService.join(requestMember);
        return success(userId);
    }

    private boolean isDuplicateId(MemberDto memberDto) {
        return memberService.checkDuplicateId(memberDto.getUserId());
    }

    @PostMapping("/checkId")
    public ResponseEntity<Boolean> checkId(@RequestBody String id) {
        boolean dupID = memberService.checkId(id);
        return new ResponseEntity<>(dupID, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ApiUtils.ApiResult login(@RequestBody LoginForm loginForm) {
        Member loginedMember = memberService.login(loginForm);
        return success(loginedMember);
    }

}
