/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlador;

import com.mycompany.model.classes.Aluno;
import com.mycompany.model.classes.Disciplina;
import com.mycompany.model.classes.Professor;
import com.mycompany.model.dao.IDao;
import com.mycompany.model.exceptions.AlunoException;
import com.mycompany.model.exceptions.DisciplinaException;
import com.mycompany.model.exceptions.ProfessorException;
import com.mycompany.model.validacoes.ValidacaoAluno;
import com.mycompany.model.validacoes.ValidacaoDisciplina;
import com.mycompany.model.validacoes.ValidacaoProfessor;
import java.util.List;

/**
 *
 * @author arthur
 */
public class DisciplinaController {
    private IDao repositorio;
    
    public DisciplinaController(IDao repositorio){
        this.repositorio = repositorio;
    }
    
    public void adicionarDisciplina(String cod, String nome, String semestre, String horario) throws DisciplinaException {
        ValidacaoDisciplina valid = new ValidacaoDisciplina();
        Disciplina novaDisciplina = valid.validacao(cod, nome, semestre, horario);
        
        repositorio.save(novaDisciplina);
    }
    
    public void addDisciplina(Disciplina d){
        repositorio.save(d);
    }

    public void removerDisciplina(String cod) {
        repositorio.delete(cod);
    }

    public Disciplina buscarDisciplina(String cod) {
        return (Disciplina) repositorio.find(cod);
    }

    public List<Disciplina> listarDisciplinas() {
        return repositorio.findAll();
    }

    public void atualizarDisciplina(String codAntigo, String nome, String semestre, String horario) throws DisciplinaException {
        removerDisciplina(codAntigo);
        adicionarDisciplina(codAntigo, nome, semestre, horario);
    }
    
    public void atualizarDisciplinaA(Disciplina d, String cpf, String nome, String idade, String matricula, String anoIngresso) throws AlunoException {
        removerDisciplina(d.getCod());
        ValidacaoAluno valid = new ValidacaoAluno();
        Aluno novoAluno = valid.validacao(cpf, nome, idade, matricula, anoIngresso);
        if(novoAluno != null){
            d.setAluno(novoAluno);
            addDisciplina(d);
        }else{
            System.out.println("Não achou");
        }
    }
    
    public void atualizarDisciplinaP(Disciplina d, String cpf, String nome, String idade, String sexo) throws ProfessorException {
        removerDisciplina(d.getCod());
        ValidacaoProfessor valid = new ValidacaoProfessor();
        Professor novoP = valid.validacao(cpf, nome, idade, sexo);
        if(novoP != null){
            d.setProfM(novoP);
            addDisciplina(d);
        }else{
            System.out.println("Não achou");
        }
    }
    
}
