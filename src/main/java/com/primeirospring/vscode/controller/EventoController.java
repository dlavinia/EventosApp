package com.primeirospring.vscode.controller;

import com.primeirospring.vscode.models.Convidado;
import com.primeirospring.vscode.models.Evento;
import com.primeirospring.vscode.repository.ConvidadosRepository;
import com.primeirospring.vscode.repository.EventosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * EventoController
 */
@Controller
public class EventoController {

    @Autowired
    private EventosRepository er;

    @Autowired
    private ConvidadosRepository cr;


    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
    public String form() {
        return "evento/formEvento";
    }
    
    @RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
    public String form(Evento evento) {

        er.save(evento);
        return "redirect:/cadastrarEvento";
    }

   @RequestMapping("/eventos")
    public ModelAndView listarEventos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
		Evento evento = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);
        
        Iterable<Convidado> convidados = cr.findByEvento(evento);
        mv.addObject("convidados", convidados);

        return mv;
    }

    @RequestMapping("/deletarEvento")
    public String deletarEvento(long codigo){
        Evento evento = er.findByCodigo(codigo);
        er.delete(evento);

        return "redirect:/eventos";
    }

    @RequestMapping("/deletarConvidado")
    public String deletarConvidado(String rg){
        Convidado convidado = cr.findByRg(rg);
        cr.delete(convidado);

        Evento evento = convidado.getEvento();
        long codigoLong = evento.getCodigo();
        String codigo = ""+ codigoLong;
        return "redirect:/" + codigo;
    }

    @RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("codigo") long codigo, Convidado convidado){
        Evento evento = er.findByCodigo(codigo);
        convidado.setEvento(evento);
        cr.save(convidado);
        return "redirect:/{codigo}";
    }

    /*TESTEEEEEE 01 18:28 BRACH*/
    /*TESTEEEEEE 02 18:34 BRACH*/


}