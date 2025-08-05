/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.dao;

import com.mycompany.model.classes.Disciplina;
import com.mycompany.model.files.FilePersistence;
import com.mycompany.model.files.SerializadorJSONDisciplina;
import java.util.List;

/**
 *
 * @author arthur
 */
public class DisciplinaDAOFile implements IDao {
     private SerializadorJSONDisciplina serializador = new SerializadorJSONDisciplina();//Inversao dependencia
    
    private FilePersistence filePersistence = new FilePersistence();
    private String caminhoArquivo;

    public DisciplinaDAOFile(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }


    @Override
    public void delete(String cpf) {
       
        Disciplina disciplinaExcluir = this.find(cpf);
        
        if(disciplinaExcluir != null){
            List<Disciplina> disciplinas = this.findAll();
            disciplinas.remove(disciplinaExcluir);
            
            //mesma rotina para que aprendemos nas aulas de persistencia
            String jsonData = serializador.toFile(disciplinas);
            filePersistence.saveToFile(jsonData, caminhoArquivo);
            System.out.println("Disciplina removida com sucesso do arquivo.");
        }
    }

    @Override
    public Disciplina find(String cod) {
        List<Disciplina> disciplinas = this.findAll();
        
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(cod)){
                return disciplina;
            }      
        }
        return null;
    }
    
    @Override
    public List<Disciplina> findAll() {
        String jsonData = filePersistence.loadFromFile(caminhoArquivo);
        return serializador.fromFile(jsonData);
    }

    @Override
    public void update(String cpf, Object newAluno ) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void save(Object newAluno) {
        Disciplina a = (Disciplina) newAluno;
        List<Disciplina> alunos = findAll();
        alunos.add(a);
        
        //mesma rotina para que aprendemos nas aulas de persistencia
        String jsonData = serializador.toFile(alunos);
        filePersistence.saveToFile(jsonData, caminhoArquivo);
        System.out.println("Disciplina salva com sucesso no arquivo.");
    }
}
