package dk.vip.protocolbroker.proxies;

import com.google.gson.Gson;

import dk.vip.transmit.Transmission;

public class RestProtocolPublisher extends ProtocolPublisher {

    public RestProtocolPublisher(String name, String path) {
        super(name, path);
    }

    @Override
    public void publish() {
        Transmission transmission = new Transmission();
        Gson gson = new Gson();
        transmission.transmit(gson.toJson(this.bundle()), path + "/protocolbroker/publishProtocol");
    }

}
