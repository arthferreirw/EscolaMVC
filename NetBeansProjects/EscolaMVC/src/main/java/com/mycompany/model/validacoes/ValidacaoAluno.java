/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.validacoes;

import com.mycompany.model.classes.Aluno;
import com.mycompany.model.exceptions.AlunoException;

/**
 *
 * @author arthur
 */
public class ValidacaoAluno {
   public Aluno validacao(String cpf, String nome, String idade, String matricula, String anoIngresso) throws AlunoException {
    Aluno a = new Aluno();

    if (cpf.isEmpty())
        throw new AlunoException("Campo 'CPF' não pode estar vazio.");
    a.setCpf(cpf);

    if (nome.isEmpty())
        throw new AlunoException("Campo 'Nome' não pode estar vazio.");
    a.setNome(nome);

    if (idade.isEmpty())
        throw new AlunoException("Campo 'Idade' não pode estar vazio.");

    if (idade.matches("[A-Za-z]*"))
        throw new AlunoException("O campo 'Idade' deve conter apenas números.");

    int valorIdade = Integer.parseInt(idade);
    a.setIdade(valorIdade);

    if (matricula.isEmpty())
        throw new AlunoException("Campo 'Matrícula' não pode estar vazio.");
    a.setMatricula(matricula);

    if (anoIngresso.isEmpty())
        throw new AlunoException("Campo 'Ano de Ingresso' não pode estar vazio.");
    a.setAnoIngresso(anoIngresso);

    return a;
}

    
}
