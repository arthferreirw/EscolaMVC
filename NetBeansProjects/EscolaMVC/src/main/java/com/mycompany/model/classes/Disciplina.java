/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author arthur
 */
public class Disciplina {
     private String cod;
    private String nome;
    private String semestre;
    private String horario;
    private List<Professor> LstProfessores;
    private List<Aluno> Lstalunos = new ArrayList<>();

    public Disciplina(String cod, String nome, String semestre, String horario, List<Professor> profM, List<Aluno> alunos) {
        this.cod = cod;
        this.nome = nome;
        this.semestre = semestre;
        this.horario = horario;
        this.LstProfessores = new ArrayList();
        this.Lstalunos = new ArrayList<>();
    }
    
    
    public Disciplina() {
        this.cod = "";
        this.nome = "";
        this.semestre = "";
        this.horario = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<Professor> getProfM() {
        return LstProfessores;
    }

    public void setProfMS(List<Professor> profM) {
        this.LstProfessores = profM;
    }

    public List<Aluno> getAlunos() {
        return Lstalunos;
    }
    
    public void setAluno(Aluno a){
        this.Lstalunos.add(a);
    }
    
    public void setProfM(Professor p){
        this.LstProfessores.add(p);
    }

    public void setAlunos(List<Aluno> alunos) {
        this.Lstalunos = alunos;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.cod);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.semestre);
        hash = 67 * hash + Objects.hashCode(this.horario);
        hash = 67 * hash + Objects.hashCode(this.LstProfessores);
        hash = 67 * hash + Objects.hashCode(this.Lstalunos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.cod, other.cod)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.semestre, other.semestre)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.LstProfessores, other.LstProfessores)) {
            return false;
        }
        return Objects.equals(this.Lstalunos, other.Lstalunos);
    }

    
    
    public void imprimir(){
        System.out.println(toString());          
    }

    @Override
    public String toString() {
        return "{" + "cod=" + cod + ", nome=" + nome + ", semestre=" + semestre + ", horario=" + horario + ", profM=" + LstProfessores + ", alunos=" + Lstalunos + '}';
    }
    
}
