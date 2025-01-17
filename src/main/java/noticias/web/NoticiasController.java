/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import noticias.domain.Noticia;
import noticias.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author camilo
 */
@Controller
@RequestMapping("/noticias")
public class NoticiasController {
    
    
    
    @Autowired
    private NoticiaService noticiaService;
    
   

    @RequestMapping("/noticiaList.json")
    public @ResponseBody List<Noticia> getNoticiaList(){  
        System.err.println(noticiaService.getAll().size());
        return noticiaService.getAll();
    };

    
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody void addNoticia(@RequestBody Noticia noticia) {
        noticiaService.addNoticia(noticia);
    };
    
    @RequestMapping("/layout")
    public String getPartialPage() {
        
        return "layouts/noticias";
    };
    
    @RequestMapping(value = "/remove",method = RequestMethod.DELETE)
    public @ResponseBody void removeNoticia(@RequestBody  Noticia cod){
        noticiaService.removeNoticia(cod);
    }
}
