package reformulacaopkmn;

import javax.swing.JOptionPane;

public class ReformulacaoPkmn {
    public static void main(String Args[]) 
    throws InterruptedException {
        System.out.println("Seja bem-vindo(@) ao nosso mundo de mistérios e magias.");
        delay();
        String nome = apresentation();
        opcoes();
        String e = "false";
        do {
            e = escolha();
        } while (e == "false");
        delay();
        System.out.println("O personagem escolhido foi " + e);
        
        principal(e);
    }
    
    public static void delay() 
    throws InterruptedException {
        Thread.sleep(500);
    }
    
    public static String apresentation() 
    throws InterruptedException {
        System.out.println("Eu sou Hargard, sue mentor.");
        delay();
        String nome = JOptionPane.showInputDialog("Primeiramente, caro viajante, me informe seu nome:");
        delay();
        System.out.println("Ok, " + nome + ", vamos começar a sua incrível jornada nesse novo universo.");
        delay();
        System.out.println("Primeiramente, escolha o personagem com o qual você passará o resto de sua batalha.");
        return nome;
    }
    
    public static void opcoes() 
    throws InterruptedException {
        System.out.println("Você tem três opções:");
        delay();
        System.out.println("1 - Azgard");
        delay();
        System.out.println("2 - Cyndra");
        delay();
        System.out.println("3 - Hieron");
        delay();
    }
    
    public static String escolha() 
    throws InterruptedException {
        int personagem = Integer.parseInt(JOptionPane.showInputDialog("Qual sua opção?"));
        switch (personagem) {
            case 1: 
                String v1 = verificacao();
                if (v1 == "true") {
                    return "Azgard";
                } else {
                    return "false";
                }
            case 2:
                String v2 = verificacao();
                if (v2 == "true") {
                    return "Cyndra";
                } else {
                    return "false";
                }
            case 3: 
                String v3 = verificacao();
                if (v3 == "true") {
                    return "Hieron";
                } else {
                    return "false";
                }
            default:
                System.out.println("Selecione uma opção válida.");
                return "false";
        }
    }
    
    public static String verificacao() 
    throws InterruptedException{
        String yon = JOptionPane.showInputDialog("Você tem certeza de sua escolha? [S/n]");
        switch (yon) {
            case "S":
            case "s":
                System.out.println("Personagem escolhido com sucesso.");
            return "true";
            case "N":
            case "n":
                System.out.println("Entendemos sua dúvida.");
                //escolha();
            return "false";
            default:
                System.out.println("Selecione uma opção válida.");
            return "false";
        }
    }
    
    public static String principal(String p) 
    throws InterruptedException {
        int vidaJogador = 450;
        String personagem = p;
        int poderDeCura = 200;
        int atkJ = 100;
        
        int enemyLife = 1000;
        int enemyAttack = 150;
        
        System.out.println("INFORMAÇÕES DO JOGADOR");
        delay();
        System.out.println("-----------x----------");
        delay();
        System.out.println("Personagem escolhido: " + personagem);
        delay();
        System.out.println("Vida do personagem: " + vidaJogador);
        delay();
        System.out.println("Poder de cura: " + poderDeCura);
        delay();
        System.out.println("Poder de Ataque: " + atkJ);
        delay();
        System.out.println("");
        delay();
        System.out.println("INFORMAÇÕES DO INIMIGO");
        delay();
        System.out.println("-----------x----------");
        delay();
        System.out.println("Seu inimigo: Walkyr");
        delay();
        System.out.println("Vida do Inimigo: " + enemyLife);
        delay();
        System.out.println("Ataque do Inimigo: " + enemyAttack);
        delay();
        
        battle(vidaJogador, poderDeCura, atkJ, enemyLife, enemyAttack);
        
        return null;
    }
    
    public static int battle(int vj, int pdc, int atk, int el, int ea) 
    throws InterruptedException {
        System.out.println("[1] Atacar");
        delay();
        System.out.println("[2] Curar");
        delay();
        System.out.println("[3] Fugir");
        delay();
        
        do {
            if (vj > 0) {
                int option = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma das opções"));
                switch (option) {
                    case 1:
                        el -= atk;
                        System.out.println("Você atacou, e agora o inimigo tem " + el + " HP.");
                        delay();
                        vj = atk(vj, ea);
                    break;
                    case 2: 
                        vj += pdc;
                        System.out.println("Você curou-se, e agora você tem " + vj + " HP.");
                        delay();
                        vj = atk(vj, ea);
                    break;
                    case 3:
                        System.out.println("É impossível fugir.");
                        delay();
                        vj = atk(vj, ea);
                    break;
                    default: 
                        System.out.println("Um guerreiro não pode errar em batalha.");
                        delay();
                        vj = atk(vj, ea);
                }
            } else {
                break;
            }
            
        } while (el > 0);
        
        System.out.println("Um bom soldado nunca morre sem arrependimentos.");
        delay();
        System.out.println("Você morreu em batalha.");
        delay();
       
        return 0;
    }
    
    public static int atk(int vj, int ea)
    throws InterruptedException {
        vj -= ea;
        System.out.println("O inimigo atacou, e agora você tem " + vj + " HP.");
        delay();
        
        return vj;
    }
}
