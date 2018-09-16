/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.groupchat.Encoder;

import java.io.IOException;
import java.io.Writer;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import org.groupchat.model.Mensaje;

/**
 *
 * @author HP
 */
public class MessageEncoder implements Encoder.TextStream  <Mensaje> {

    //Recieve the message and convert in jason
    @Override
    public void encode(Mensaje arg0, Writer arg1) 
            throws EncodeException, IOException {
        JsonObject json = Json.createObjectBuilder()
                .add("nickname", Mensaje.getNickname())
                .add("message", Mensaje.getMessage())
                .build();
        try (JsonWriter jsonWriter = Json.createWriter(arg1)){ 
            jsonWriter.writeObject(json);
        } 
       
    }

    @Override
    public void init(EndpointConfig config) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
