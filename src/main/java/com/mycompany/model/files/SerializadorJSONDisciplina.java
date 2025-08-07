/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.model.classes.Disciplina;
import java.util.List;

/**
 *
 * @author arthur
 */
public class SerializadorJSONDisciplina {
     public String toFile(List<Disciplina> lstdisciplinas) {
        try {
            // Convertendo objeto filme para JSON 
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(lstdisciplinas);

            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Desserializa JSON em formato String para um objeto Filme
    public List<Disciplina> fromFile(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
             
            List<Disciplina> lstdisciplinas = mapper.readValue(jsonString, new TypeReference<List<Disciplina>>() {});
           // GerenciadorProduto produtos = mapper.readValue(jsonString, GerenciadorProduto.class);
            
            return lstdisciplinas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
