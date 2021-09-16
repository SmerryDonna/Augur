package com.cryptoproject.mainClient;

import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cryptoproject.controller.ControllerUIModel;
import com.cryptoproject.graph.InterGraph;
import com.cryptoproject.graph.LogInGraph;
import com.cryptoproject.model.Model;



@SuppressWarnings("unused, FieldCanBeLocal, SpellCheckingInspection")
public class MainClass {
    /**
     * Il metodo Main e' il cuore del gioco, fa partire
     * tutto il modello MVC
     *
     * @param args e' un parametro preimpostato
     */
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() { //invocazione metodi di SWING tramite thread, usando la SWING utility sopra
                Model model = new Model();
                LogInGraph login = new LogInGraph();
                InterGraph interGraph = new InterGraph();
                ControllerUIModel gestoreUI = new ControllerUIModel(interGraph, login, model);
            }
        });
    }
}
