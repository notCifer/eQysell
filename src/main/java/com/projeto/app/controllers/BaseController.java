package com.projeto.app.controllers;

import java.util.List;

import javax.validation.Valid;

import com.projeto.app.models.Abl;
import com.projeto.app.models.Atividade;
import com.projeto.app.models.Localizacao;
import com.projeto.app.models.Piso;
import com.projeto.app.models.form.AblFORM;
import com.projeto.app.models.form.AtividadeFORM;
import com.projeto.app.models.form.LocalizacaoFORM;
import com.projeto.app.models.form.PisoFORM;
import com.projeto.app.repositories.AblRepository;
import com.projeto.app.repositories.AtividadeRepository;
import com.projeto.app.repositories.LocalizacaoRepository;
import com.projeto.app.repositories.PisoRepository;
import com.projeto.app.services.EnumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/base")
public class BaseController {

    @Autowired
    private AtividadeRepository atividadeR;
    @Autowired
    private LocalizacaoRepository localizaR;
    @Autowired
    private PisoRepository pisoR;
    @Autowired
    private AblRepository ablR;

    @Autowired
    private EnumService enumS;

    // ------------------ MÉTODOS ATIVIDADE ------------------
    @GetMapping(value = "/atividade")
    public List<Atividade> findAllAtividade() {
        List<Atividade> list = atividadeR.findAll();
        return list;
    }

    @PostMapping(value = "/atividade")
    public Atividade addAtividade(@RequestBody @Valid AtividadeFORM FORM, Errors errors) {
        if (errors.hasErrors()) {

        }
        Atividade atividade = FORM.toFORM(atividadeR,enumS);
        return atividade;

    }

    // ------------------ MÉTODOS LOCALIZAÇÃO ------------------

    @GetMapping(value = "/localizacao")
    public List<Localizacao> findAllLocaliza() {
        List<Localizacao> list = localizaR.findAll();
        return list;
    }

    @PostMapping(value = "/localizacao")
    public Localizacao addLocalizacao(@RequestBody @Valid LocalizacaoFORM FORM, Errors errors) {
        if (errors.hasErrors()) {

        }
        Localizacao localiza = FORM.toFORM(localizaR,enumS);
        return localiza;
    }

    // ------------------ MÉTODOS PISO ------------------
    @GetMapping(value = "/piso")
    public List<Piso> findAllPiso() {
        List<Piso> list = pisoR.findAll();
        return list;
    }

    @PostMapping(value = "/piso")
    public Piso addLocalizacao(@RequestBody @Valid PisoFORM FORM, Errors errors) {
        if (errors.hasErrors()) {

        }
        Piso piso = FORM.toFORM(pisoR,enumS);
        return piso;
    }

    // ------------------ MÉTODOS ABL ------------------
    @GetMapping(value = "/abl")
    public List<Abl> findAllAbl() {
        List<Abl> list = ablR.findAll();
        return list;
    }

    @PostMapping(value = "/abl")
    public Abl addLocalizacao(@RequestBody @Valid AblFORM FORM, Errors errors) {
        if (errors.hasErrors()) {

        }
        Abl abl = FORM.toFORM(ablR);
        return abl;
    }

}