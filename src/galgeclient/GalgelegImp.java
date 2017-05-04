package galgeclient;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;
import sh.surge.galgeleg.wsdl.Exception_Exception;
import sh.surge.galgeleg.wsdl.Galgelogik;
import sh.surge.galgeleg.wsdl.GalgelogikService;

/**
 *
 * @author mohammad
 */
public class GalgelegImp implements GalgelegI {

    @WebServiceRef
    static GalgelogikService service;
    static Galgelogik port;
    
    public GalgelegImp(){
        try{
            service = new GalgelogikService();
            port = service.getPort(Galgelogik.class);
            printSessionInformations();
        }catch(Exception e){
            System.out.println("Forbindelsen mislykkedes");
            e.printStackTrace();
        }
        
        //nulstil();
    }
    
    public void printSessionInformations(){
        try{
            System.out.println("Invoking printSessionInfo operation ...");
            Map requestContext =
                ((BindingProvider) port).getRequestContext();
            requestContext.put(
                BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
            System.out.println("SESSION_MAINTAIN is set all session ids are same");
            System.out.println(port.printSessionInfo());
            System.out.println(port.printSessionInfo());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    @Override
    public ArrayList<String> getBrugteBogstaver() {
        
        return (ArrayList<String>) port.getBrugteBogstaver();
    }

    @Override
    public String getSynligtOrd() {
        String so = port.getSynligtOrd();
        return so;
    }

    @Override
    public String getOrdet() {
        String ordet = port.getOrdet();
        return ordet;
    }

    @Override
    public int getAntalForkerteBogstaver() {
        return port.getAntalForkerteBogstaver();
    }

    @Override
    public boolean erSidsteBogstavKorrekt() {
        return port.erSidsteBogstavKorrekt();
    }

    @Override
    public boolean erSpilletVundet() {
        return port.erSpilletVundet();
    }

    @Override
    public boolean erSpilletTabt() {
        return port.erSpilletTabt();
    }

    @Override
    public boolean erSpilletSlut() {
        return port.erSpilletSlut();
    }

    @Override
    public void nulstil() {
        port.nulstil();
    }

    @Override
    public void opdaterSynligtOrd() {
        port.opdaterSynligtOrd();
    }

    @Override
    public void gætBogstav(String bogstav) {
        port.gætBogstav(bogstav);
    }

    @Override
    public boolean hentBruger(String brugernavn, String password){
        return port.hentBruger(brugernavn, password);
    }

    @Override
    public String getFornavn() {
        return port.getFornavn();
    }
    
}
