package dk.vip.client.domain.convert;

import com.google.gson.Gson;

import dk.vip.client.domain.wrap.ClientWrap;

public class ClientWrapConverterJSON implements IClientWrapConverter {

    @Override
    public String convert(ClientWrap clientWrap) {
        Gson gson = new Gson();
        return gson.toJson(clientWrap);
    }

}
