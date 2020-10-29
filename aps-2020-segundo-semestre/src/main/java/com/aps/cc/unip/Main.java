package com.aps.cc.unip;

import com.aps.cc.unip.DAO.DaoAuthors;
import com.aps.cc.unip.control.CtrAuthors;
import com.aps.cc.unip.model.Authors;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start");

        // TESTE DE BUSCA
        /*DaoAuthors authorsFunctions = new DaoAuthors();
        Authors authors = (Authors) authorsFunctions.carregarUm(1, Authors.class);

        System.out.println("author: ");
        System.out.println(authors);*/


        //TESTE DE ADD BANCO
        CtrAuthors ctrAuthors;
        Authors authors;

        ctrAuthors = new CtrAuthors();
        authors = new Authors();

        authors.setName("TesteName5");
        authors.setFname("TesteFname5");
        if (ctrAuthors.gravarAuthors(authors) == 1) {
            JOptionPane.showMessageDialog(null, "Autor adicionado");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar este autor!");
        }

        System.out.println("Finish");
    }

}
