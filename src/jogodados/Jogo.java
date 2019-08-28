/*
 * Códigos gerados para ensino
 */
package jogodados;

import java.util.Scanner;

/**
 *
 * @author Laura Emmanuella <lauraemmanuella at eaj.ufrn.br>
 */
public class Jogo {

    private final Scanner entrada = new Scanner(System.in);

    private final Dado dado1 = new Dado();
    private final Dado dado2 = new Dado();

    private Jogador[] jogadores;

    private int resultado;

    public void inserirJogadores() {
        System.out.println("Quantos jogadores irão participar?");
        int qtd = 0;
        do {
            System.out.println("Maximo 11 jogadores");
            qtd = entrada.nextInt();
        } while (qtd > 11);
        jogadores = new Jogador[qtd];

        for (int i = 0; i < jogadores.length; i++) {
            System.out.println("Jogador " + (i + 1) + " informe seu nome:");
            jogadores[i] = new Jogador(entrada.next());
        }

    }

    public void inserirApostas() {
        int aposta;
        for (Jogador j : jogadores) {
            do {
                System.out.println(j.getNome() + " informe sua aposta:");
                aposta = entrada.nextInt();
            } while (aposta < 2 || aposta > 12);
            
            /*
            TODO aqui teria que verificar se as apostas estao se repetindo
             */
            
            j.setValorAposta(aposta);

            
        }
    }

    public void jogarDados() {
        dado1.setValorFace();
        dado2.setValorFace();
    }

    public void mostrarResultado() {
        resultado = dado1.getValorFace() + dado2.getValorFace();
        System.out.println("Resultado: " + resultado);
    }

    public void mostrarVencedor() {
        boolean ganhou = false;
        for (Jogador j : jogadores) {
            if (resultado == j.getValorAposta()) {
                System.out.println(j.getNome() + " venceu a aposta");
                ganhou = true;
            }
        }
        if(!ganhou){
            System.out.println("O computador ganhou");    
        }
        
    }

}
