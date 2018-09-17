/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.groupchat.Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.groupchat.Decoder.DecoderMessage;
import org.groupchat.Encoder.MessageEncoder;
import org.groupchat.model.Mensaje;

/**
 *
 * @author HP
 */

//This is our main method of chat

@ServerEndpoint(value="/chat", encoders = {MessageEncoder.class},decoders = {
    DecoderMessage.class})
public class ChatWebsocketServlet {
    private static final List <Session> conectados = new ArrayList<>();
    
    
    //This add a person that want to be add in te session
    @OnOpen
    public void inicio(Session sesion){
        conectados.add(sesion);
    }
    
    //This take out a person from the session
    @OnClose
    public void salir(Session sesion){
        conectados.remove(sesion);
    }
    
    //The massage that one user writes, the others users conected receive it
    @OnMessage
    public void mensaje(Mensaje mensaje) throws IOException, EncodeException{
        for(Session sesion : conectados){
            sesion.getBasicRemote().sendObject(mensaje);
        }
    }

    @OnError
    public void onError(Throwable t) {
    }

}
