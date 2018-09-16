/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.groupchat.Decoder;

import java.io.IOException;
import java.io.Reader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import org.groupchat.model.Mensaje;

/**
 *
 * @author HP
 */
public class DecoderMessage implements Decoder.TextStream <Mensaje> {

    @Override
    public Mensaje decode(Reader reader) 
            throws DecodeException, IOException {
        Mensaje mensaje = new Mensaje ();
        try(JsonReader jsonReader = Json.createReader(reader)){
            JsonObject json = jsonReader.readObject();
            mensaje.setNickname(json.getString("nickname"));
            mensaje.setMessage(json.getString("message"));
        }
        return mensaje;
    }
    
    @Override
    public void init(EndpointConfig config) {
        
    }

    @Override
    public void destroy() {
       
    }
    
}
