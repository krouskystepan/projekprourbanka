package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        Hero heroSnitch = new Hero("Dr. AntiSnič", 450, 25);
        Hero heroCake = new Hero("Mr. Čískýdort", 350, 30);
        Hero heroHulk = new Hero("PaedDr. BSmart Hulk", 500, 45);

        Boss boss1 = new Boss(1, 100, 15);
        Boss boss2 = new Boss(2, 200, 20);
        Boss boss3 = new Boss(3, 350, 15);
        Boss boss4 = new Boss(4, 500, 25);
        Boss boss5 = new Boss(5, 700, 30);

        final int DELAY = 1000;
        int selectedHero = 0;
        int PlayerHP = 0;
        int PlayerDMG = 0;
        double difficulty = 0;
        boolean play = true;

        System.out.println("Vítej ve hře");
        while (play) {
            System.out.println("------------");
            System.out.println("Pro informace o hře zadej 0 a pro spuštění hry 1.");
            int answerInfo = sc.nextInt();
            if (answerInfo == 0) {
                System.out.println("------------ \nDostaneš na výběr z obtížnosstí a postav, ale každá má svoje výhody a nevýhody a tvým úkolem bude \nporazit všechny Bosse a vyhrát hru. GL.");
            } else if (answerInfo == 1) {
                while (selectedHero == 0) {
                    System.out.println("------------");
                    System.out.println("Vyber si postavu:");
                    System.out.println("1. " + heroSnitch);
                    System.out.println("2. " + heroCake);
                    System.out.println("3. " + heroHulk);
                    System.out.print("Tvůj výběr: ");
                    int answer = sc.nextInt();
                    switch (answer) {
                        case 1:
                            System.out.println("Vybral jsi si " + heroSnitch.getName());
                            selectedHero = 1;
                            PlayerHP = heroSnitch.getHp();
                            PlayerDMG = heroSnitch.getAtt();
                            break;
                        case 2:
                            System.out.println("Vybral jsi si " + heroCake.getName());
                            selectedHero = 2;
                            PlayerHP = heroCake.getHp();
                            PlayerDMG = heroCake.getAtt();
                            break;
                        case 3:
                            System.out.println("Vybral jsi si " + heroHulk.getName());
                            selectedHero = 3;
                            PlayerHP = heroHulk.getHp();
                            PlayerDMG = heroHulk.getAtt();
                            break;
                        default:
                            System.out.println("Tato postava neexistuje");
                            break;
                    }
                }
                while (difficulty == 0) {
                    System.out.println("------------");
                    System.out.println("Vyber si obtížnost");
                    System.out.println("1. " + Difficulties.EASY);
                    System.out.println("2. " + Difficulties.NORMAL);
                    System.out.println("3. " + Difficulties.HARD);
                    System.out.print("Tvůj výběr: ");
                    int answer = sc.nextInt();
                    switch (answer) {
                        case 1:
                            System.out.println("Vybral jsi si " + Difficulties.EASY);
                            difficulty = 0.75;
                            break;
                        case 2:
                            System.out.println("Vybral jsi si " + Difficulties.NORMAL);
                            difficulty = 1;
                            break;
                        case 3:
                            System.out.println("Vybral jsi si " + Difficulties.HARD);
                            difficulty = 1.25;
                            break;
                        default:
                            System.out.println("Tahle obtiznost tu neni");
                            break;
                    }
                }

                System.out.println("------------");
                Thread.sleep(DELAY * 2);
                System.out.println("Tvoje postava se vydala do lesíka, kde se ztratila (smutny smajlik)");
                Thread.sleep(DELAY * 2);
                System.out.println("Dlouho jsi z toho byl v depresích, že tvoje postava umře, ale...");
                Thread.sleep(DELAY * 2);
                System.out.println("rozhodl jsi se prozkoumat les, BOHUŽEL ");
                Thread.sleep(DELAY * 2);

                if (boss1.isAlive){
                    System.out.println("------------");
                    System.out.println("Potkal jsi \n" + boss1);
                    System.out.println();
                    Thread.sleep(5000);
                    System.out.println("FIGHT");
                    while (PlayerHP > 0 && boss1.getHp() > 0) {
                        int bossCurDmg = (int)((Math.random() * ((boss1.getAtt() + 5) - (boss1.getAtt() - 5) + 1) + boss1.getAtt() - 5) * difficulty) ;

                        System.out.println("");
                        PlayerHP -= bossCurDmg;
                        System.out.println("Boss ti ubral: " + bossCurDmg);
                        System.out.println("Tvoje zivoty jsou: " + PlayerHP);
                        if (PlayerHP <= 0) {
                            System.out.println("--------------------------------------------------------------");
                            System.out.println("Boss tě zabil a sežral tě slon, který se taky ztratil v lese");
                            System.out.println("--------------------------------------------------------------");
                            break;
                        }
                        Thread.sleep(DELAY);
                        System.out.println("");
                        boss1.setHp(boss1.getHp() - PlayerDMG);
                        System.out.println("Ubral jsi Bossovi: " + PlayerDMG);
                        System.out.println("Bossovi zivoty jsou: " + boss1.getHp());
                        if (boss1.getHp() <= 0) {
                            System.out.println("---------------");
                            System.out.println("Zabil jsi Bosse");
                            System.out.println("Z Bosse jsi získal novou čapku (+50HP)");
                            PlayerHP += 50;
                            Thread.sleep(DELAY);
                            System.out.println("--------------------------------------------------------------------------------------------------");
                            System.out.println("Bohužel cestu z lesíku jsi zatím nenašel, protože jsi totální pepega a nemáš šajn odkud jsi přišel, \ntak jsi udělal 8 otoček, 4 salta a šel jsi dál");
                            System.out.println("--------------------------------------------------------------------------------------------------");
                            Thread.sleep(DELAY);
                            boss1.setAlive(false);
                            break;
                        }
                        Thread.sleep(DELAY);
                    }
                }
                if (boss2.isAlive){
                    System.out.println("Potkal jsi \n" + boss2);
                    System.out.println();
                    Thread.sleep(7500);
                    System.out.println("FIGHT");
                    while (PlayerHP > 0 && boss2.getHp() > 0) {
                        int bossCurDmg = (int)((Math.random() * ((boss2.getAtt() + 5) - (boss2.getAtt() - 5) + 1) + boss2.getAtt() - 5) * difficulty) ;

                        System.out.println("");
                        PlayerHP -= bossCurDmg;
                        System.out.println("Boss ti ubral: " + bossCurDmg);
                        System.out.println("Tvoje zivoty jsou: " + PlayerHP);
                        if (PlayerHP <= 0) {
                            System.out.println("--------------------------------------------------------------------------");
                            System.out.println("Boss tě zabil a nikdo si toho ani nevšiml, protože jsi L a nikdo tě neznal");
                            System.out.println("--------------------------------------------------------------------------");
                            break;
                        }
                        Thread.sleep(DELAY);
                        System.out.println("");
                        boss2.setHp(boss2.getHp() - PlayerDMG);
                        System.out.println("Ubral jsi Bossovi: " + PlayerDMG);
                        System.out.println("Bossovi zivoty jsou: " + boss2.getHp());
                        if (boss2.getHp() <= 0) {
                            System.out.println("---------------");
                            System.out.println("Zabil jsi Bosse");
                            System.out.println("Z Bosse jsi získal nový tričko (+75HP)");
                            PlayerHP += 75;
                            System.out.println("-------------------------------------------------------------------");
                            System.out.println("Po zabití Bosse jsi narazil na cestu, kterou jsi se rozhodl nevydat, \nprotože by to bylo SUS");
                            System.out.println("-------------------------------------------------------------------");
                            boss2.setAlive(false);
                            break;
                        }
                        Thread.sleep(DELAY);
                    }
                }
                if (boss3.isAlive){
                    System.out.println("Potkal jsi \n" + boss3);
                    System.out.println();
                    Thread.sleep(7500);
                    System.out.println("FIGHT");
                    while (PlayerHP > 0 && boss3.getHp() > 0) {
                        int bossCurDmg = (int)((Math.random() * ((boss3.getAtt() + 5) - (boss3.getAtt() - 5) + 1) + boss3.getAtt() - 5) * difficulty) ;

                        System.out.println("");
                        PlayerHP -= bossCurDmg;
                        System.out.println("Boss ti ubral: " + bossCurDmg);
                        System.out.println("Tvoje zivoty jsou: " + PlayerHP);
                        if (PlayerHP <= 0) {
                            System.out.println("------------------------------------------------------------------");
                            System.out.println("Boss tě zabil, ale lidé si na tebe budou pamatovat jako na mentála, \nkterý se ztratil v lese a nic nedokázal");
                            System.out.println("------------------------------------------------------------------");
                            break;
                        }
                        Thread.sleep(DELAY);
                        System.out.println("");
                        boss3.setHp(boss3.getHp() - PlayerDMG);
                        System.out.println("Ubral jsi Bossovi: " + PlayerDMG);
                        System.out.println("Bossovi zivoty jsou: " + boss3.getHp());
                        if (boss3.getHp() <= 0) {
                            System.out.println("---------------");
                            System.out.println("Zabil jsi Bosse");
                            System.out.println("Z Bosse jsi získal novou zbraň (+50ATT)");
                            PlayerDMG += 50;
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("Tentokrát ti už došlo, že by nebylo špatný se vydat po cestě, \nže by mohla vést ven z lesa");
                            System.out.println("-------------------------------------------------------------");
                            boss3.setAlive(false);
                            break;
                        }
                        Thread.sleep(DELAY);
                    }
                }
                if (boss4.isAlive){
                    System.out.println("Potkal jsi \n" + boss4);
                    System.out.println();
                    Thread.sleep(7500);
                    System.out.println("FIGHT");
                    while (PlayerHP > 0 && boss4.getHp() > 0) {
                        int bossCurDmg = (int)((Math.random() * ((boss4.getAtt() + 5) - (boss4.getAtt() - 5) + 1) + boss4.getAtt() - 5) * difficulty) ;

                        System.out.println("");
                        PlayerHP -= bossCurDmg;
                        System.out.println("Boss ti ubral: " + bossCurDmg);
                        System.out.println("Tvoje zivoty jsou: " + PlayerHP);
                        if (PlayerHP <= 0) {
                            System.out.println("------------------------------------------------------------------");
                            System.out.println("Boss tě zabil, ale většina lidí si tě bude pamatovat jako člověka, \nkterý zabil 3. nevinné lidi KEKW");
                            System.out.println("------------------------------------------------------------------");
                            break;
                        }
                        Thread.sleep(DELAY);
                        System.out.println("");
                        boss4.setHp(boss4.getHp() - PlayerDMG);
                        System.out.println("Ubral jsi Bossovi: " + PlayerDMG);
                        System.out.println("Bossovi zivoty jsou: " + boss4.getHp());
                        if (boss4.getHp() <= 0) {
                            System.out.println("---------------");
                            System.out.println("Zabil jsi Bosse");
                            System.out.println("Z Bosse jsi získal legendární brýle (+50HP a +50ATT)");
                            PlayerHP += 50;
                            PlayerDMG += 50;
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("Po zabití Bosse jsi zjistil, že vlastně tenhle lesík dobře znáš, \ntakže jsi se rozhodl vydat zpátky domů");
                            System.out.println("---------------------------------------------------------------");
                            boss4.setAlive(false);
                            break;
                        }
                        Thread.sleep(DELAY);
                    }
                }
                if (boss5.isAlive){
                    System.out.println("Potkal jsi \n" + boss5);
                    System.out.println();
                    Thread.sleep(7500);
                    System.out.println("FIGHT");
                    while (PlayerHP > 0 && boss5.getHp() > 0) {
                        int bossCurDmg = (int)((Math.random() * ((boss5.getAtt() + 5) - (boss5.getAtt() - 5) + 1) + boss5.getAtt() - 5) * difficulty) ;

                        System.out.println("");
                        PlayerHP -= bossCurDmg;
                        System.out.println("Boss ti ubral: " + bossCurDmg);
                        System.out.println("Tvoje zivoty jsou: " + PlayerHP);
                        if (PlayerHP <= 0) {
                            System.out.println("--------------------------------------------------------------------------------------------------");
                            System.out.println("Boss tě zabil, byl jsi ale velie proslavený, protože jsi zabil 4 nevinné lidi a každý tě nenáviděl, \ntakže vlastně GG");
                            System.out.println("--------------------------------------------------------------------------------------------------");
                            break;
                        }
                        Thread.sleep(DELAY);
                        System.out.println("");
                        boss5.setHp(boss5.getHp() - PlayerDMG);
                        System.out.println("Ubral jsi Bossovi: " + PlayerDMG);
                        System.out.println("Bossovi zivoty jsou: " + boss5.getHp());
                        if (boss5.getHp() <= 0) {
                            if (selectedHero == 3) {
                                System.out.println("----------------------------------------------------------------------------------------");
                                System.out.println("Zabil jsi Bosse a chvíli poté jsi vyšel z lesíka, kde na tebe čekalo 31 policejních aut. \nPolicie tě chtěla zatnout, ale jelikož jsi HULK, tak jsi je rozmrdal a šel dom.");
                                System.out.println("----------------------------------------------------------------------------------------");
                            } else {
                                System.out.println("----------------------------------------------------------------------------------------");
                                System.out.println("Zabil jsi Bosse a chvíli poté jsi vyšel z lesíka, kde na tebe čekalo 31 policejních aut. \nPolicie tě zatkla za vraždu 5 nevinných lidí a ty jsi umřel jako močka \nve vězení ve svých 92 letech.");
                                System.out.println("----------------------------------------------------------------------------------------");
                            }
                            boss5.setAlive(false);
                            break;
                        }
                        Thread.sleep(DELAY);
                    }
                }
            } else {
                System.out.println("Tohle není na výběr!");
            }
            if (answerInfo == 1) {
                play = false;
            }
        }
    }
}
