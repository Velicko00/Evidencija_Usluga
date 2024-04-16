/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import forme.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author stefa
 */
public class PokreniServer extends Thread {

    ServerskaForma sf;
    ServerSocket ss;

    public PokreniServer(ServerskaForma sf) {
        this.sf = sf;
    }

    public ServerSocket getSs() {
        return ss;
    }

    @Override
    public void run() {
        try {
            ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut");
            sf.serverPokrenut();
            while (!ss.isClosed()) {
                Socket socket = ss.accept();
                System.out.println("Klijent se povezao");
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(socket);
                okz.start();
            }
        } catch (IOException ex) {
            //Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Server je ugasen");
            sf.serverUgasen();
        }
    }

}