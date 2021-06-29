package com.projeto.app.controllers;

import java.util.ArrayList;
import java.util.List;
import com.projeto.app.models.gestao.AtividadeEnum;
import com.projeto.app.models.gestao.LocalizacaoEnum;
import com.projeto.app.models.gestao.PisoEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enum")
public class EnumController {

    @GetMapping(value = "Atividade")
    public List<String> findAllAtividade(){
         AtividadeEnum[] list = AtividadeEnum.values();
         List<String> listEnums = new ArrayList<>();
         for (AtividadeEnum atividadeEnum : list) {
             listEnums.add("ID :" + atividadeEnum.getId() + " --> "  + atividadeEnum.getName());
         }
         return listEnums;
    }

    @GetMapping(value = "/Localizacao")
    public List<String> findAllLocalizacao(){
        LocalizacaoEnum[] list = LocalizacaoEnum.values();
        List<String> listEnums = new ArrayList<>();
        for (LocalizacaoEnum localizacaoEnum : list) {
            listEnums.add("ID :" + localizacaoEnum.getId()  + " --> " + localizacaoEnum.getName());
        }
        return listEnums;
   }

   @GetMapping(value = "/Piso")
   public List<String> findAllPiso(){
    PisoEnum[] list = PisoEnum.values();
    List<String> listEnums = new ArrayList<>();
    for (PisoEnum pisoEnum : list) {
        listEnums.add("ID :" + pisoEnum.getId() + " --> " + pisoEnum.getName());
    }
    return listEnums;
}


    
    
}