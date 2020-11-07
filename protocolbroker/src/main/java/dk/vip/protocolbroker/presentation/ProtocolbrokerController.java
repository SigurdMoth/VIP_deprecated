package dk.vip.protocolbroker.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtocolbrokerController {

    private IWrapHandler wrapHandler;

    @PostMapping("/protocolbroker/post")
    public String receiveJSON(@RequestBody String request) {
        return wrapHandler.handleWrap(request);
    }
}
