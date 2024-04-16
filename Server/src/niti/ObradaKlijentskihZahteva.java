/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiObjekat;
import transfer.ServerskiObjekat;

/**
 *
 * @author stefa
 */
public class ObradaKlijentskihZahteva extends Thread {

    Socket socket;
    boolean kraj = false;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!kraj) {
            KlijentskiObjekat ko = primiZahtev();
            ServerskiObjekat so = new ServerskiObjekat();
            OpstiDomenskiObjekat odo = ko.getParametar();
            switch (ko.getOperacija()) {
                case Operacije.PRIJAVIZAPOSLENOG:
                    so = Kontroler.getInstance().prijaviZaposlenog(odo);
                    break;
                case Operacije.VRATILISTUKLIJENATA:
                    so = Kontroler.getInstance().vratiListuKlijenata(odo);
                    break;
                case Operacije.NADJIKLIJENTE:
                    so = Kontroler.getInstance().nadjiKlijente(odo);
                    break;
                case Operacije.VRATILISTUUSLUGA:
                    so = Kontroler.getInstance().vratiListuUsluga(odo);
                    break;
                case Operacije.NADJIUSLUGE:
                    so = Kontroler.getInstance().nadjiUsluge(odo);
                    break;
                case Operacije.KREIRAJDOKUMENT:
                    so = Kontroler.getInstance().kreirajDokument(odo);
                    break;
                case Operacije.KREIRAJKLIJENTA:
                    so = Kontroler.getInstance().kreirajKlijenta(odo);
                    break;
                case Operacije.KREIRAJUSLUGU:
                    so = Kontroler.getInstance().kreirajUslugu(odo);
                    break;
                case Operacije.ZAPAMTIKLIJENTA:
                    so = Kontroler.getInstance().zapamtiKlijenta(odo);
                    break;
                case Operacije.OBRISIKLIJENTA:
                    so = Kontroler.getInstance().obrisiKlijenta(odo);
                    break;
                case Operacije.ZAPAMTIUSLUGU:
                    so = Kontroler.getInstance().zapamtiUslugu(odo);
                    break;
                case Operacije.OBRISIUSLUGU:
                    so = Kontroler.getInstance().obrisiUslugu(odo);
                    break;
                case Operacije.NADJIDOKUMENTE:
                    so = Kontroler.getInstance().nadjiDokumente(odo);
                    break;
                case Operacije.VRATILISTUSTAVKI:
                    so = Kontroler.getInstance().vratiListuStavki(odo);
                    break;
                case Operacije.ZAPAMTIDOKUMENT:
                    so = Kontroler.getInstance().zapamtiDokument(odo);
                    break;

            }
            posaljiOdgovor(so);
        }
    }

    public void posaljiOdgovor(ServerskiObjekat so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public KlijentskiObjekat primiZahtev() {

        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            return (KlijentskiObjekat) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
