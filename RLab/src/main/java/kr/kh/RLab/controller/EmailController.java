package kr.kh.RLab.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.RLab.service.EmailService;

@Controller
public class EmailController {

	 @Autowired
	 private EmailService emailService;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    @ResponseBody
    public String sendEmail(HttpServletRequest request, @RequestParam("email") String email) {
        String verificationCode = emailService.generateVerificationCode();
        HttpSession session = request.getSession();
        session.setAttribute("verificationCode", verificationCode);
        session.setMaxInactiveInterval(300); // 코드 유효 시간 설정 (5분)

        emailService.sendEmail(email, "회원가입 인증 번호", "인증 번호: " + verificationCode);

        return "이메일이 전송되었습니다.";
    }
}