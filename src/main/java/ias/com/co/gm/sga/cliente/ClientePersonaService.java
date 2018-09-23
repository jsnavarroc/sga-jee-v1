/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.com.co.gm.sga.cliente;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ias.com.co.gm.sga.domain.Persona;
import ias.com.co.gm.sga.servicio.PersonaServiceRemote;


public class ClientePersonaService {

    public static void main(String[] args) {

        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga--jee/PersonaServiceImpl!ias.com.co.gm.sga.servicio.PersonaServiceRemote");

            List<Persona> personas = personaService.listarPersonas();

            personas.forEach((persona) -> {
                System.out.println(persona);
            });
            System.out.println("\nFin llamada al EJB desde el cliente");
        } catch (NamingException e) {
        }
    }
}