/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BusinessEntities.GameBE;
import BusinessEntities.UserBE;
import Core.ClientBusinessLayer;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Ricardo
 */

public class Menu {

    private PrintStream out;
    private Scanner in;
    private ClientBusinessLayer business;

    public Menu(){
        out = System.out;
        in = new Scanner(System.in);
        business = ClientBusinessLayer.getInstance();
    }
    

    public void start() {
        int opcao;


        in.nextLine();
        clrScreen();
        out.println("------------------- Menu Principal -------------------");
        out.println();
        out.println("1-Login");
        out.println("2-Registar");
        out.println("0-Sair\n");

        out.print(": ");
        try {
            opcao = Integer.parseInt(in.nextLine());

            switch (opcao) {
            case (0):
                break;
            case (1):
                login();
                break;
            case (2):
                register();
                break;
            }
        } catch (Exception e) {
            out.println("Intruduza uma opção válida!");
            start();
        }
        
    }

    public void menu2() {
        int opcao;

        out.println();
            in.nextLine();
            clrScreen();
            out.println("------------------- Menu Principal -------------------");
            out.println();
            out.println("1-Novo desafio");
            out.println("2-Listar Desafios");
            out.println("3-Entrar num desafio");
            out.println("0-Sair\n");

            out.print(": ");
            try {
                opcao = Integer.parseInt(in.nextLine());
                switch (opcao) {
                case (0):
                    logout();
                    return;
                case (1):
                    makeChallenge();
                    break;
                case (2):
                    listChallenge();
                    break;
                case (3):
                    acceptChallenge();
                    break;
                default:
                    out.println("Intruduza uma opção válida!");menu2();
                }
            } catch (Exception e) {
                out.println("Intruduza uma opção válida!");
                menu2();
            }

            
        
    }

    public void clrScreen() {
        int i = 0;
        while (i < 25) {
            out.println();
            i++;
        }
    }

    private void login() {
        String name;
        String pass;

        clrScreen();
        out.println("------------------- Login -------------------");
        out.println();
        out.print("\nNome: ");
        name = in.nextLine();
        
        out.print("Password: ");
        pass = in.nextLine();

        UserBE user = new UserBE(name,pass);
        business.login(user);
    }

    private void register() {
        String name;
        String pass;

        clrScreen();
        out.println("------------------- Registar -------------------");
        out.println();
        out.println("Introduza os seus dados:");

        out.print("Nome: ");
        name = in.nextLine();
        
        out.print("Password: ");
        pass = in.nextLine();
        
        UserBE user = new UserBE(name,pass);
        business.register(user);
    }

    private void logout() {
        business.logout();
    }

    private void makeChallenge() {
        String nome;
        String data;
        String hora;
        int ano, mes, dia, hour, min, seg;

        clrScreen();
        out.println("------------------- Criar desafio -------------------");
        out.println();
        out.print("Nome: ");
        nome = in.nextLine();
        
        out.print("Data (AAMMDD): ");
        data = in.nextLine();
        if (data.length() != 6) {
            out.println("Formato inválido!");
            return;
        }

        try {
            Integer.parseInt(data);
            ano = 2000 + Integer.parseInt(data.substring(0, 2));
            mes = Integer.parseInt(data.substring(2, 4));
            dia = Integer.parseInt(data.substring(4));
            if (ano < 2015 || mes < 0 || dia < 0 || mes > 12 || dia > 31) {
                throw new Exception("Parâmetros inválidos!");
            }
        } catch (Exception e) {
            out.println("Carateres inválidos introduzidos!");
            return;
        }

        out.print("Hora (HHMMSS): ");
        hora = in.nextLine();
        if (hora.length() != 6) {
            out.println("Formato inválido!");
            return;
        }
        try {
            Integer.parseInt(hora);
            hour = Integer.parseInt(hora.substring(0, 2));
            min = Integer.parseInt(hora.substring(2, 4));
            seg = Integer.parseInt(hora.substring(4));
            if (hour < 0 || hour > 24 || min < 0 || seg < 0 || min > 60 || seg > 60) {
                throw new Exception("Parâmetros inválidos!");
            }
        } catch (Exception e) {
            out.println("Carateres inválidos introduzidos!");
            return;
        }

        GregorianCalendar gcalendar = new GregorianCalendar(ano+2000, mes, dia, hour, min, seg);
        
        GameBE game = new GameBE(nome, null,gcalendar);
        business.make_challenge(game);
        
    }

    private void listChallenge() {
        clrScreen();
        out.println("------------------- Lista de Desafios -------------------");
        out.println();

        business.list_challenges();
        
    }

    private void acceptChallenge() {
        String nome, data, hora;

        clrScreen();
        out.println("------------------- Entrar num Desafio -------------------");
        out.println();
        out.print("Introduza o nome do desafio: ");

        nome = in.nextLine();
        
        business.accept_challenge(nome);
    }

    public void waitForGame() {
        out.println("À espera que o desafio começe...");

        GameBE game = business.getGame();
        
        int tempo = 0;

        tempo += (356 * 24 * 60 * 60) * (game.getData().get(Calendar.YEAR) - Calendar.getInstance().get(Calendar.YEAR));
        tempo += (30 * 24 * 60 * 60) * (game.getData().get(Calendar.MONTH) + 1 - (Calendar.getInstance().get(Calendar.MONTH) + 1));
        tempo += (24 * 60 * 60) * (game.getData().get(Calendar.DAY_OF_MONTH) - Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        tempo += (60 * 60) * (game.getData().get(Calendar.HOUR_OF_DAY) - Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        tempo += (60) * (game.getData().get(Calendar.MINUTE) - Calendar.getInstance().get(Calendar.MINUTE));
        tempo += game.getData().get(Calendar.SECOND) - Calendar.getInstance().get(Calendar.SECOND);
        out.println("Tempo de Espera: " + tempo + " segundos...");

        try {
            while (tempo > 0) {
                wait(1000);
                tempo -= 1;
                out.println("Tempo de Espera: " + tempo + " segundos...");
            }

        } catch (InterruptedException ex) {
        }

        out.println("O jogo vai começar!");

        inGame();
    }

    private void inGame() {

    }

}

