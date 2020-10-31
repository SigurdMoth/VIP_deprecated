package dk.vip.session.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientWrapController {

    private HeadClientWrapHandler clientWrap

    @PostMapping("/session/post")
    public String receiveClientWrap(@RequestBody String request) {
        System.out.println(request);
        return "Test";
    }

    public void setStrategy(HeadClientWrapHandler clientWrapHandler) {
        this.clientWrapHandler = clientWrapHandler;
    }
}
