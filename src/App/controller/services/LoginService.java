package App.controller.services;

import App.EmailManager;
import App.controller.EmailLoginResult;
import App.model.EmailAccount;

import javax.mail.*;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class LoginService {
    EmailAccount emailAccount;
    EmailManager emailManager;

    public LoginService(EmailAccount emailAccount, EmailManager emailManager) {
        this.emailAccount = emailAccount;
        this.emailManager = emailManager;
    }

    public EmailLoginResult login(){
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAccount.getAddress(), emailAccount.getPassword().toCharArray());
            }
        };
        try {
            Session session= Session.getInstance(emailAccount.getProperties());
            Store store = session.getStore("imaps");
            store.connect(emailAccount.getProperties().getProperty("incomingHost"),
                    emailAccount.getAddress(),
                    emailAccount.getPassword());
        }catch (NoSuchProviderException e) {
            e.printStackTrace();
            return EmailLoginResult.FAILED_UNEXPECTED;
        } catch (AuthenticationFailedException e){
            e.printStackTrace();
            return EmailLoginResult.FAILED_BY_CREDENTIALS;
        } catch (MessagingException e) {
            e.printStackTrace();
            return EmailLoginResult.FAILED_UNEXPECTED;
        } catch (Exception e){
            e.printStackTrace();
            return EmailLoginResult.FAILED_UNEXPECTED;
        }
        return EmailLoginResult.SUCCES;
    }
}
