package com.projeto.app.controllers;

import java.util.List;
import java.util.Optional;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(description = "Controle de dados",tags = { "Dados base" })
@CrossOrigin(origins = "*")
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
    @ApiOperation(value = "Lista todas atividades")
    public List<Atividade> findAllAtividade() {
        List<Atividade> list = atividadeR.findAll();
        return list;
    }

    @ApiOperation(value = "Altera atividade pelo id")
    @PutMapping("/atividade/{id}")
    public ResponseEntity<?> alterAtividade(@PathVariable Long id,@RequestBody @Valid AtividadeFORM FORM){
        Optional<Atividade> findById = atividadeR.findById(id);
        if (findById.isPresent()) {
            Atividade atividade = findById.get();
            atividade.setAtividade(enumS.findAtividade(FORM.getIdEnum()));
            atividade.setPorcetagem(FORM.getPorcetagem());
            atividadeR.save(atividade);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Deletar atividade pelo id")
    @DeleteMapping("/atividade/{id}")
    public ResponseEntity<?> deletaAtividade(@PathVariable Long id){
        Optional<Atividade> findById = atividadeR.findById(id);
        if (findById.isPresent()) {
            atividadeR.delete(findById.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PostMapping(value = "/atividade")
    @ApiOperation(value = "Cadastra uma atividade")
    public Atividade addAtividade(@RequestBody @Valid AtividadeFORM FORM, Errors errors) {
        if (errors.hasErrors()) {

        }
        Atividade atividade = FORM.toFORM(atividadeR,enumS);
        return atividade;

    }

    // ------------------ MÉTODOS LOCALIZAÇÃO ------------------

    @GetMapping(value = "/localizacao")
    @ApiOperation(value = "Lista todas localizações")
    public List<Localizacao> findAllLocaliza() {
        List<Localizacao> list = localizaR.findAll();
        return list;
    }

    @ApiOperation(value = "Alterar localização pelo id")
    @PutMapping("/localizacao/{id}")
    public ResponseEntity<?> alterLocaliza(@PathVariable Long id,@RequestBody @Valid LocalizacaoFORM FORM){
        Optional<Localizacao> findById = localizaR.findById(id);
        if (findById.isPresent()) {
            Localizacao localizacao = findById.get();
            localizacao.setLocal(enumS.findLocaliza(FORM.getIdEnum()));
            localizacao.setPercentual(FORM.getPercentual());
            localizaR.save(localizacao);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Deletar localização pelo id")
    @DeleteMapping("/localizacao/{id}")
    public ResponseEntity<?> deletaLocaliza(@PathVariable Long id){
        Optional<Localizacao> findById = localizaR.findById(id);
        if (findById.isPresent()) {
            localizaR.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(value = "/localizacao")
    @ApiOperation(value = "Cadastra uma localização")
    public Localizacao addLocalizacao(@RequestBody @Valid LocalizacaoFORM FORM, Errors errors) {
        if (errors.hasErrors()) {

        }
        Localizacao localiza = FORM.toFORM(localizaR,enumS);
        return localiza;
    }

    // ------------------ MÉTODOS PISO ------------------
    @GetMapping(value = "/piso")
    @ApiOperation(value = "Lista todos pisos")
    public List<Piso> findAllPiso() {
        List<Piso> list = pisoR.findAll();
        return list;
    }

    @ApiOperation(value = "Alterar piso pelo id")
    @PutMapping("/piso/{id}")
    public ResponseEntity<?> alterPiso(@PathVariable Long id,@RequestBody @Valid PisoFORM FORM){
        Optional<Piso> findById = pisoR.findById(id);
        if (findById.isPresent()) {
            Piso piso = findById.get();
            piso.setPiso(enumS.findPiso(FORM.getIdEnum()));
            piso.setPorcentagem(FORM.getPorcentagem());
            pisoR.save(piso);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Deletar piso pelo id")
    @DeleteMapping("/piso/{id}")
    public ResponseEntity<?> deletaPiso(@PathVariable Long id){
        Optional<Piso> findById = pisoR.findById(id);
        if (findById.isPresent()) {
            pisoR.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(value = "/piso")
    @ApiOperation(value = "Cadastra um piso")
    public Piso addLocalizacao(@RequestBody @Valid PisoFORM FORM, Errors errors) {
        if (errors.hasErrors()) {

        }
        Piso piso = FORM.toFORM(pisoR,enumS);
        return piso;
    }

    // ------------------ MÉTODOS ABL ------------------
    @GetMapping(value = "/abl")
    @ApiOperation(value = "Lista todas ABLs")
    public List<Abl> findAllAbl() {
        List<Abl> list = ablR.findAll();
        return list;
    }

    @ApiOperation(value = "Alterar ABL pelo id")
    @PutMapping("/abl/{id}")
    public ResponseEntity<?> alterAbl(@PathVariable Long id,@RequestBody @Valid AblFORM FORM){
        Optional<Abl> findById = ablR.findById(id);
        if (findById.isPresent()) {
            Abl abl = findById.get();
            abl.setPorcento(FORM.getPorcento());
            abl.setValor(FORM.getValor());
            ablR.save(abl);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Deletar ABL pelo id")
    @DeleteMapping("/abl/{id}")
    public ResponseEntity<?> deletaAbl(@PathVariable Long id){
        Optional<Abl> findById = ablR.findById(id);
        if (findById.isPresent()) {
            ablR.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(value = "/abl")
    @ApiOperation(value = "Cadastra uma ABL")
    public Abl addLocalizacao(@RequestBody @Valid AblFORM FORM, Errors errors) {
        if (errors.hasErrors()) {

        }
        Abl abl = FORM.toFORM(ablR);
        return abl;
    }

}