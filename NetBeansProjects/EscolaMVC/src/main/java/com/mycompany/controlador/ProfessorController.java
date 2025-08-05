/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlador;

import com.mycompany.model.classes.Professor;
import com.mycompany.model.dao.IDao;
import com.mycompany.model.exceptions.ProfessorException;
import com.mycompany.model.validacoes.ValidacaoProfessor;
import java.util.List;

/**
 *
 * @author arthur
 */
public class ProfessorController {
    private IDao repositorio;

    public ProfessorController(IDao repositorio) {
        this.repositorio = repositorio;
    }
    
    public void adicionarProfessor(String cpf, String nome, String idade, String sexo) throws ProfessorException {
        ValidacaoProfessor valid = new ValidacaoProfessor();
        Professor novoProfessor = valid.validacao(cpf, nome, idade, sexo);
        
        repositorio.save(novoProfessor);
    }

    public void removerProfessor(String cpf) {
        repositorio.delete(cpf);
    }

    public Professor buscarProfessor(String cpf) {
        return (Professor) repositorio.find(cpf);
    }

    public List<Professor> listarProfessores() {
        return repositorio.findAll();
    }

    public void atualizarProfessor(String cpfAntigo, String cpf, String nome, String idade, String sexo) throws ProfessorException {
        ValidacaoProfessor valid = new ValidacaoProfessor();
        Professor novoP = valid.validacao(cpf, nome, idade, sexo);
        
        repositorio.update(cpfAntigo, novoP);
    }
}
