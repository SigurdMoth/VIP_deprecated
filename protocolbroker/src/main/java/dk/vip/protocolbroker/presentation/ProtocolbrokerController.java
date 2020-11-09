package dk.vip.protocolbroker.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtocolbrokerController {

    private IRouteHandler routeHandler;

    @PostMapping("/protocolbroker/handleRoute")
    public String handleRoute(@RequestBody String request) {
        return routeHandler.handleRoute(request);
    }

    @PostMapping("/protocolbroker/publishProtocol")
    public String publishProtocol(@RequestBody String request) {
        return routeHandler.publishProtocol(request);
    }
}
