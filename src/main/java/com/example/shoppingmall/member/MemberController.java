package com.example.shoppingmall.member;

import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.shoppingmall.member.Member.fromDtoToEntity;
import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;


@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {
    private MemberService memberService;

    @PostMapping("/join/res/en") //before
    public ResponseEntity<String> joinByResponseEntity(@RequestBody MemberDto memberDto) {
        if (isDuplicateId(memberDto)) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
        Member requestMember = memberDto.convertToEntity();
        String userId = memberService.join(requestMember);

        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @PostMapping("/join/api/result") // after
    public ApiUtils.ApiResult<String> joinByApiResult(@Valid @RequestBody MemberDto memberDto, Errors errors) {
        if (errors.hasErrors()) {
            return error("Validation errors", HttpStatus.BAD_REQUEST, errors.getAllErrors());
        }

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
    public ResponseEntity<OAuth2ResourceServerProperties.Jwt> login(@RequestBody LoginForm loginForm) {
        OAuth2ResourceServerProperties.Jwt login = memberService.login(loginForm);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }
}
