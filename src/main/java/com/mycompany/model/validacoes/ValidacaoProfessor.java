/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.validacoes;

import com.mycompany.model.classes.Professor;
import com.mycompany.model.exceptions.ProfessorException;

/**
 *
 * @author arthur
 */
public class ValidacaoProfessor {
   public Professor validacao(String cpf, String nome, String idade, String sexo) throws ProfessorException {
    Professor p = new Professor();

    if (nome.isEmpty())
        throw new ProfessorException("O campo 'Nome' não pode estar vazio.");
    p.setNome(nome);

    if (idade.isEmpty())
        throw new ProfessorException("O campo 'Idade' não pode estar vazio.");

    if (idade.matches("[A-Za-z]*"))
        throw new ProfessorException("O campo 'Idade' deve conter apenas números.");

    int valorIdade = 0;
    valorIdade = Integer.parseInt(idade);
    p.setIdade(valorIdade);

    if (sexo.isEmpty())
        throw new ProfessorException("O campo 'Sexo' não pode estar vazio.");
    p.setSexo(sexo);

    if (cpf.isEmpty())
        throw new ProfessorException("O campo 'CPF' não pode estar vazio.");
    p.setCpf(cpf);

    return p;
}

}

