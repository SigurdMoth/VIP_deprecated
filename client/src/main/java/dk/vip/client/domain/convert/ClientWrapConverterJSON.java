package dk.vip.client.domain.convert;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import dk.vip.client.domain.wrap.ClientWrap;

@Component
public class ClientWrapConverterJSON implements IClientWrapConverter {

    @Override
    public String convert(ClientWrap clientWrap) {
        Gson gson = new Gson();
        return gson.toJson(clientWrap);
    }

}
