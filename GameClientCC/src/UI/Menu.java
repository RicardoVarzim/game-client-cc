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
import java.util.Date;
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

        out.println();
        while (true) {
            in.nextLine();
            clrScreen();
            out.println("*** Menu Principal ***");
            out.println();
            out.println("1-Login");
            out.println("2-Registar");
            out.println("0-Sair\n");

            out.print("Opção: ");
            try {
                opcao = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                out.println("Intruduza uma opção válida!");
                continue;
            }

            if (opcao > 2 || opcao < 0) {
                out.println("Intruduza uma opção válida!");
                continue;
            }

            switch (opcao) {
                case (0):
                    //com.end();
                    break;
                case (1):
                    login();
                    break;
                case (2):
                    register();
            }
        }
    }

    public void menu2() {
        int opcao;

        out.println();
        while (true) {
            in.nextLine();
            clrScreen();
            out.println("*** Menu Principal ***");
            out.println();
            out.println("1-Criar novo desafio");
            out.println("2-Listar os desafios atuais");
            out.println("3-Entrar num desafio");
            out.println("0-Sair\n");

            out.print("Opção: ");
            try {
                opcao = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                out.println("Intruduza uma opção válida!");
                continue;
            }

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
                    out.println("Intruduza uma opção válida!");
            }
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
        out.println("*** Login ***");
        out.println();
        out.print("\nNickname: ");
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
        out.println("*** Registar ***");
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
        out.println("*** Criar novo desafio ***");
        out.println();
        out.print("Introduza o nome do desafio: ");
        nome = in.nextLine();
        
        out.print("Introduza a data (AAMMDD): ");
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

        out.print("Introduza a hora (HHMMSS): ");
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
        
//        MakeChallenge mkC = new MakeChallenge(nome, data, hora, label);
//        byte[] dados = mkC.generate();
//        dados = com.send(dados);
//        label++;
//
//        try {
//            if (inter.checkMkChallenge(dados)) {
//                out.println("Desafio criado!");
//                desafio = new Desafio();
//                desafio.setNome(nome);
//                try {
//                    desafio.setData(data);
//                    desafio.setHora(hora);
//                    desafio.dateSFtoIF();
//                } catch (Exception ex) {
//                    out.println("FATAL ERROR: Data inválida!");
//                    System.exit(0);
//                }
//                waitForMatch();
//                return;
//            }
//            out.println("Desafio não foi criado!");
//        } catch (UnknownTypeException ex) {
//            out.println("Fatal Eror: UnknownTypeException");
//        } catch (VersionMissmatchException ex) {
//            out.println("Fatal Eror: VersionMissmatchException");
//        }
    }

    private void listChallenge() {
        clrScreen();
        out.println("*** Lista de Desafios ***");
        out.println();

        business.list_challenges();
        
//        ListChallenge lc = new ListChallenge(label);
//        label++;
//        byte[] dados = lc.generate();
//        dados = com.send(dados);
//        ArrayList<Desafio> desafios;
//
//        desafios = inter.checkLstChallenge(dados);
//        if (desafios == null) {
//            return;
//        }
//        for (Desafio d : desafios) {
//            System.out.println("Nome: \"" + d.getNome() + "\"  Data: \"" + d.getData() + "\" Hora: \"" + d.getHora() + "\"");
//        }
    }

    private void acceptChallenge() {
        String nome, data, hora;

        clrScreen();
        out.println("*** Entrar num Desafio ***");
        out.println();
        out.print("Introduza o nome do desafio: ");

        nome = in.nextLine();
        if (nome.length() > 255) {
            out.println("Nome muito grande, não pode exceder 255 carateres!");
            return;
        }
        if (nome.length() < 1) {
            out.print("Nome Inválido!");
            return;
        }

        business.accept_challenge(nome);
//        AcceptChallenge ac = new AcceptChallenge(nome, label);
//        label++;
//        byte[] dados = ac.generate();
//
//        dados = com.send(dados);
//
//        try {
//            String[] dataEhora = inter.checkAcceptChallenge(dados);
//            data = dataEhora[0];
//            hora = dataEhora[1];
//            desafio = new Desafio(nome, data, hora);
//            desafio.dateSFtoIF();
//            out.print("Registado no desafio \"" + nome + "\" com sucesso!");
//            waitForMatch();
//        } catch (UnknownTypeException ex) {
//            out.println("Fatal Eror: UnknownTypeException");
//        } catch (VersionMissmatchException ex) {
//            out.println("Fatal Eror: VersionMissmatchException");
//        } catch (NotOkException ex) {
//        } catch (Exception ex) {
//            out.println("FATAL ERROR: " + ex.getMessage());
//            System.exit(0);
//        }
    }

    private synchronized void waitForMatch() {
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

        if (tempo < 0) {
            out.println("FATAL ERROR: Tempo negativo!");
            System.exit(0);
        }
        try {
            while (tempo > 0) {
                wait(1000);
                tempo -= 1;
                out.println("Tempo de Espera: " + tempo + " segundos...");
            }

        } catch (InterruptedException ex) {
        }

        out.println("Espera Terminou! O jogo vai começar!");

        inDesafio();
    }

    private void inDesafio() {
//        Transmit t;
//        NextPackage np;
//        Group g = new Group();
//        byte[] piece;
//        int i = 2, pergunta = 1;
//        Pergunta p = null;
//
//        while (true) {
//            t = new Transmit(label, pergunta, desafio.getNome());
//            piece = com.send(t.generate());
//            //System.out.println("Tamanho: " + piece.length);
//            g.addPiece(piece);
//            //out.println("Recebido o pacote: 1");
//            while (!g.isComplete()) {
//                np = new NextPackage(i);
//                i++;
//                piece = com.send(np.generatePDU());
//                g.addPiece(piece);
//                //out.println("Recebido o pacote: " + (i - 1));
//            }
//            //np = new NextPackage(i);
//            //com.send(np.generatePDU());
//            out.println("Todos os pacotes foram recebidos.");
//
//            try {
//                p = inter.checkTransmit(g.generate().generatePDU(), desafio, pergunta);
//                if (p == null) {
//                    System.out.println("FATAL ERROR: Pergunta == null");
//                    System.exit(0);
//                }
//            } catch (MissingPieciesException ex) {
//                out.println("FATAL ERROR: Faltam alguns pacotes!");
//                System.exit(0);
//            }
//
//            out.println("Pergunta " + pergunta + "!");
//            out.println(p.getPergunta());
//            out.println("1 - " + p.getResposta(1));
//            out.println("2 - " + p.getResposta(2));
//            out.println("3 - " + p.getResposta(3));
//            in.nextLine();
//
//            pergunta++;
//        }
//
    }

}

