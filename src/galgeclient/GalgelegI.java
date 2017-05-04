/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeclient;

import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
interface GalgelegI {
    @WebMethod public ArrayList<String> getBrugteBogstaver();
    @WebMethod public String getSynligtOrd();
    @WebMethod public String getOrdet();
    @WebMethod public int getAntalForkerteBogstaver();
    @WebMethod public boolean erSidsteBogstavKorrekt();
    @WebMethod public boolean erSpilletVundet();
    @WebMethod public boolean erSpilletTabt();
    @WebMethod public boolean erSpilletSlut();
    @WebMethod public void nulstil();
    @WebMethod public void opdaterSynligtOrd();
    @WebMethod public void gætBogstav(String bogstav);
    @WebMethod public boolean hentBruger(String brugernavn, String password) throws java.rmi.RemoteException;;
    @WebMethod public String getFornavn();
           
}
