package com.app.trackers.user;

import com.app.trackers.expense.responses.AppResponse;
import com.app.trackers.user.request.ForgotPassword;
import com.app.trackers.user.request.ResetPassword;
import com.app.trackers.user.service.AppUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1/auth")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping(path = "/sign-up")
    public ResponseEntity<AppResponse> userRegistration(@RequestBody AppUser appUser) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(appUserService.userRegistration(appUser));
    }

    @PostMapping(path = "/forgot-password")
    public ResponseEntity<AppResponse> forgotPassword(@RequestBody ForgotPassword forgotPassword) {
        return ResponseEntity.status(HttpStatus.OK).body(appUserService.forgotPassword(forgotPassword));
    }

    @PutMapping(path = "/reset-password")
    public ResponseEntity<AppResponse> resetPassword(@RequestBody ResetPassword resetPassword){
        return ResponseEntity.status(HttpStatus.OK).body(appUserService.resetPassword(resetPassword));
    }
}
