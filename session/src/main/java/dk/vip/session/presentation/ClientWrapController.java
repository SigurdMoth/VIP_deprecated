package dk.vip.session.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientWrapController {

    private HeadClientWrapHandler clientWrapHandler;

    @PostMapping("/session/post")
    public String receiveClientWrap(@RequestBody String request) {
        return clientWrapHandler.handleClientWrap(request);
    }

    @Autowired
    public void setStrategy(HeadClientWrapHandler clientWrapHandler) {
        this.clientWrapHandler = clientWrapHandler;
    }
}
