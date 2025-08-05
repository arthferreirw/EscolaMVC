package com.mycompany.model.validacoes;

import com.mycompany.model.classes.Disciplina;
import com.mycompany.model.exceptions.DisciplinaException;

public class ValidacaoDisciplina { 

    public Disciplina validacao(String cod, String nome, String semestre, String horario) throws DisciplinaException {
        Disciplina d = new Disciplina();

        // Validação do código
        if (cod.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'Cod'.");
        }
        d.setCod(cod);

        // Validação do nome
        if (nome.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'Nome'.");
        }
        d.setNome(nome);

        // Validação do semestre
        if (semestre.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'Semestre'.");
        }
        d.setSemestre(semestre);

        // Validação do horário
        if (horario.isEmpty()) {
            throw new DisciplinaException("Error - Campo vazio: 'Horario'.");
        }
        d.setHorario(horario);

        return d;
    }
}


