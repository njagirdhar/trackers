package com.app.trackers.user.service;

import com.app.trackers.expense.responses.AppResponse;
import com.app.trackers.user.AppUser;
import com.app.trackers.user.ForgotEntity;
import com.app.trackers.user.repo.AppUserRepository;
import com.app.trackers.user.repo.ForgotPasswordRepository;
import com.app.trackers.user.request.ForgotPassword;
import com.app.trackers.user.request.ResetPassword;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
@AllArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ForgotPasswordRepository forgotPasswordRepository;
    public AppResponse userRegistration(AppUser appUser) {

        boolean mailExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        boolean phoneExists = appUserRepository.findByMobileNumber(appUser.getMobileNumber()).isPresent();

        if (mailExists) {
            return new AppResponse("User Already Exists with Mail");
        }

        if (phoneExists) {
            return new AppResponse("User Already Exists with Mail");
        }

        String encryptedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encryptedPassword);

        AppUser appUser1 = appUserRepository.save(appUser);

        return new AppResponse("User Registered Successfully - " + appUser1.getUserId());
    }

    public AppResponse forgotPassword(ForgotPassword forgotPassword) {
        boolean userExists = appUserRepository.findByEmail(forgotPassword.getEmail()).isPresent();
        if (!userExists) {
            throw new RuntimeException("Could not find Email in Records-" + forgotPassword.getEmail());
        }
        String pin = String.valueOf(new Random().nextInt(999999));
        log.error("forgot pin generated - {}"+ pin);
        /* Send Mail to user with pin*/
        sendMail();
        /* Saving Pin & User Information in Forgot Entity Table */
        ForgotEntity forgotEntity = new ForgotEntity();
        forgotEntity.setEmail(forgotPassword.getEmail());
        forgotEntity.setPin(pin);
        forgotPasswordRepository.save(forgotEntity);
        return new AppResponse("6 digit pin is sent successfully to Email");
    }

    private void sendMail() {
        log.error("Sending Mail to user with PIN");
    }

    public AppResponse resetPassword(ResetPassword resetPassword) {
        boolean userExists = appUserRepository.findByEmail(resetPassword.getEmail()).isPresent();
        if (!userExists) {
            throw new RuntimeException("Could not find Email in Records-" + resetPassword.getEmail());
        }
        Optional<AppUser> optionalAppUser = appUserRepository.findByEmail(resetPassword.getEmail());
        AppUser appUser = optionalAppUser.get();
        String encryptPassword = bCryptPasswordEncoder.encode(resetPassword.getNewPassword());
        appUser.setPassword(encryptPassword);
        appUserRepository.save(appUser);
        return new AppResponse("Password is updated Successfully");
    }
}
