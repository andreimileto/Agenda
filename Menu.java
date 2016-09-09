/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author Mileto
 */
public class Menu {

    public void exibir() {

        int menu = 0;
        DataHora vetorDataHora[] = new DataHora[50];
        Compromisso vetorCompromisso[] = new Compromisso[50];
        ListaDeAgenda vetorDeAgenda[] = new ListaDeAgenda[50];
        Local vetorLocal[] = new Local[50];
        int countVetorDataHora = 0;
        int countVetorCompromisso = 0;
        int countVetorListaDeAgenda = 0;
        int countVetorLocal = 0;

        while (menu != 8) {
            menu = Entrada.leiaInt("Menu:\n"
                    + "[1] Cadastrar um novo compromisso\n"
                    + "[2] Cancelar compromisso\n"
                    + "[3] Listar todos os compromissos\n"
                    + "[4] Listar compromissos ativos\n"
                    + "[5] Listar todos compromissos cancelados\n"
                    + "[6] Reativar compromisso cancelado\n"
                    + "[7] Imprimir todos compromissos de um período\n"
                    + "[8] Sair");

            if (menu == 1) {
                ListaDeAgenda listaDeAgenda = new ListaDeAgenda();
                Compromisso compromisso = new Compromisso();
                DataHora dataHora = new DataHora();
                Local local = new Local();

                int diaAux = Entrada.leiaInt("Digite o dia que quer marcar o compromisso");
                int mesAux = Entrada.leiaInt("Digite o mes que quer marcar o compromisso");
                int anoAux = Entrada.leiaInt("Digite o ano que quer marcar o compromisso");

                while (!dataHora.validarData(diaAux, menu, anoAux)) {
                    System.out.println("Data incorreta, digite uma data válida");
                    diaAux = Entrada.leiaInt("Digite o dia que quer marcar o compromisso");
                    mesAux = Entrada.leiaInt("Digite o mes que quer marcar o compromisso");
                    anoAux = Entrada.leiaInt("Digite o ano que quer marcar o compromisso");

                }
                dataHora.setDia(diaAux);
                dataHora.setMes(mesAux);
                dataHora.setAno(anoAux);
                dataHora.setHora(Entrada.leiaString("Digite a hora do compromisso"));

                local.setCidade(Entrada.leiaString("Digite o nome da cidade"));
                local.setNomeDaRua(Entrada.leiaString("Digite o nome da rua"));
                local.setBairro(Entrada.leiaString("Digite o nome do bairro"));
                local.setNumero(Entrada.leiaInt("Digite o número da casa"));
                local.setComplemento(Entrada.leiaString("Digite o complemento"));

                compromisso.setDadosCompromisso(Entrada.leiaString("Digite o compromisso"));

                listaDeAgenda.setDataHora(dataHora);
                listaDeAgenda.setLocal(local);
                listaDeAgenda.setCompromisso(compromisso);
                listaDeAgenda.setStatus(true);

                vetorDataHora[countVetorDataHora] = dataHora;
                vetorCompromisso[countVetorCompromisso] = compromisso;
                vetorLocal[countVetorLocal] = local;
                vetorDeAgenda[countVetorListaDeAgenda] = listaDeAgenda;

                countVetorCompromisso++;
                countVetorDataHora++;
                countVetorListaDeAgenda++;
                countVetorLocal++;
                System.out.println("Compromisso agendado com sucesso!");

            } else if (menu == 2) {

                for (int i = 0; i < countVetorListaDeAgenda; i++) {
                    if (vetorDeAgenda[i].CompromissosAtivos()) {
                        System.out.println("Número   Nome do compromisso \t data e hora do compromisso \t cidade/bairro/rua/numero/complemento");
                        System.out.println((i + 1) + "-" + vetorDeAgenda[i].getCompromisso()
                                .getDadosCompromisso() + "\t"
                                + vetorDeAgenda[i].getDataHora().getDia() + "/"
                                + vetorDeAgenda[i].getDataHora().getMes() + "/"
                                + vetorDeAgenda[i].getDataHora().getAno() + " - "
                                + vetorDeAgenda[i].getDataHora().getHora() + "\t"
                                + vetorDeAgenda[i].getLocal().getCidade() + "-"
                                + vetorDeAgenda[i].getLocal().getBairro() + "-"
                                + vetorDeAgenda[i].getLocal().getNomeDaRua() + "-"
                                + vetorDeAgenda[i].getLocal().getNumero() + "-"
                                + vetorDeAgenda[i].getLocal().getComplemento());
                        System.out.println("\t---------");
                    }
                }
                System.out.println("---\t---\t---\t---\t---");
                int opcao = Entrada.leiaInt("Escolha um dos compromissos que quer cancelar");
                if (opcao > 0 && opcao <= countVetorListaDeAgenda) {
                    if (vetorDeAgenda[opcao - 1].cancelarCompromisso()) {
                        System.out.println("compromisso cancelado com sucesso!");
                        
                    } else {
                        System.out.println("compromisso selecionado inválido");
                    }
                } else {
                    System.out.println("opção inválida");
                }

            } else if (menu == 3) {
                for (int i = 0; i < countVetorListaDeAgenda; i++) {
                    System.out.println("Nome do compromisso \t data e hora do compromisso \t cidade/bairro/rua/numero/complemento");
                    System.out.println(vetorDeAgenda[i].getCompromisso()
                            .getDadosCompromisso() + "\t"
                            + vetorDeAgenda[i].getDataHora().getDia() + "/"
                            + vetorDeAgenda[i].getDataHora().getMes() + "/"
                            + vetorDeAgenda[i].getDataHora().getAno() + " - "
                            + vetorDeAgenda[i].getDataHora().getHora() + "\t"
                            + vetorDeAgenda[i].getLocal().getCidade() + "-"
                            + vetorDeAgenda[i].getLocal().getBairro() + "-"
                            + vetorDeAgenda[i].getLocal().getNomeDaRua() + "-"
                            + vetorDeAgenda[i].getLocal().getNumero() + "-"
                            + vetorDeAgenda[i].getLocal().getComplemento());
                    System.out.println("\t---------");
                }
                System.out.println("---\t---\t---\t---");
            } else if (menu == 4) {
                for (int i = 0; i < countVetorListaDeAgenda; i++) {
                    if (vetorDeAgenda[i].CompromissosAtivos()) {
                        System.out.println("Nome do compromisso \t data e hora do compromisso \t cidade/bairro/rua/numero/complemento");
                        System.out.println(vetorDeAgenda[i].getCompromisso()
                                .getDadosCompromisso() + "\t"
                                + vetorDeAgenda[i].getDataHora().getDia() + "/"
                                + vetorDeAgenda[i].getDataHora().getMes() + "/"
                                + vetorDeAgenda[i].getDataHora().getAno() + " - "
                                + vetorDeAgenda[i].getDataHora().getHora() + "\t"
                                + vetorDeAgenda[i].getLocal().getCidade() + "-"
                                + vetorDeAgenda[i].getLocal().getBairro() + "-"
                                + vetorDeAgenda[i].getLocal().getNomeDaRua() + "-"
                                + vetorDeAgenda[i].getLocal().getNumero() + "-"
                                + vetorDeAgenda[i].getLocal().getComplemento());
                        System.out.println("\t----------");
                    }
                }
                System.out.println("---\t---\t---\t---\t---");
            } else if (menu == 5) {
                for (int i = 0; i < countVetorListaDeAgenda; i++) {
                    if (!vetorDeAgenda[i].CompromissosAtivos()) {
                        System.out.println("Nome do compromisso \t data e hora do compromisso \t cidade/bairro/rua/numero/complemento");
                        System.out.println(vetorDeAgenda[i].getCompromisso()
                                .getDadosCompromisso() + "\t"
                                + vetorDeAgenda[i].getDataHora().getDia() + "/"
                                + vetorDeAgenda[i].getDataHora().getMes() + "/"
                                + vetorDeAgenda[i].getDataHora().getAno() + " - "
                                + vetorDeAgenda[i].getDataHora().getHora() + "\t"
                                + vetorDeAgenda[i].getLocal().getCidade() + "-"
                                + vetorDeAgenda[i].getLocal().getBairro() + "-"
                                + vetorDeAgenda[i].getLocal().getNomeDaRua() + "-"
                                + vetorDeAgenda[i].getLocal().getNumero() + "-"
                                + vetorDeAgenda[i].getLocal().getComplemento());
                        System.out.println("\t---------");
                    }
                }
                System.out.println("---\t---\t---\t---\t---");
            } else if (menu == 6) {

                //   if (opcao > 0) {
                for (int i = 0; i < countVetorListaDeAgenda; i++) {
                    if (!vetorDeAgenda[i].CompromissosAtivos()) {
                        System.out.println("Número   Nome do compromisso \t data e hora do compromisso \t cidade/bairro/rua/numero/complemento");
                        System.out.println((i + 1) + "-" + vetorDeAgenda[i].getCompromisso()
                                .getDadosCompromisso() + "\t"
                                + vetorDeAgenda[i].getDataHora().getDia() + "/"
                                + vetorDeAgenda[i].getDataHora().getMes() + "/"
                                + vetorDeAgenda[i].getDataHora().getAno() + " - "
                                + vetorDeAgenda[i].getDataHora().getHora() + "\t"
                                + vetorDeAgenda[i].getLocal().getCidade() + "-"
                                + vetorDeAgenda[i].getLocal().getBairro() + "-"
                                + vetorDeAgenda[i].getLocal().getNomeDaRua() + "-"
                                + vetorDeAgenda[i].getLocal().getNumero() + "-"
                                + vetorDeAgenda[i].getLocal().getComplemento());
                        System.out.println("\t----------");
                    }
                }
                System.out.println("---\t---\t---\t---");
                int opcao = Entrada.leiaInt("Escolha um dos compromissos que quer reativar");

                if (opcao > 0 && opcao <= countVetorListaDeAgenda) {
                    if (vetorDeAgenda[opcao - 1].reativarCompromisso()) {
                        System.out.println("compromisso reativado com sucesso!");
                    } else {
                        System.out.println("compromisso selecionado inválido");
                    }
                } else {
                    System.out.println("opção inválida");
                }
            } else if (menu == 7) {
                
                int diaI = Entrada.leiaInt("Digite o dia do inicio");
                int mesI = Entrada.leiaInt("Digite o mes de inicio");
                int anoI = Entrada.leiaInt("Digite o ano de inicio");
                int diaF = Entrada.leiaInt("Digite o dia do fim");
                int mesF = Entrada.leiaInt("Digite o mes do fim");
                int anoF = Entrada.leiaInt("Digite o ano de fim");
                int result1 = DataHora.formatarData(diaI, mesI, anoI);
                int result2 = DataHora.formatarData(diaF, mesF, anoF);
                
                for (int i = 0; i < countVetorListaDeAgenda; i++) {
                    if (vetorDeAgenda[i].listarCompromissosDeUmPeriodo(result1, result2)) {
                        System.out.println("Nome do compromisso \t data e hora do compromisso \t cidade/bairro/rua/numero/complemento");
                        System.out.println(vetorDeAgenda[i].getCompromisso()
                                .getDadosCompromisso() + "\t"
                                + vetorDeAgenda[i].getDataHora().getDia() + "/"
                                + vetorDeAgenda[i].getDataHora().getMes() + "/"
                                + vetorDeAgenda[i].getDataHora().getAno() + " - "
                                + vetorDeAgenda[i].getDataHora().getHora() + "\t"
                                + vetorDeAgenda[i].getLocal().getCidade() + "-"
                                + vetorDeAgenda[i].getLocal().getBairro() + "-"
                                + vetorDeAgenda[i].getLocal().getNomeDaRua() + "-"
                                + vetorDeAgenda[i].getLocal().getNumero() + "-"
                                + vetorDeAgenda[i].getLocal().getComplemento());
                        System.out.println("\t---------");
                    }

                }
                System.out.println("---\t---\t---\t---\t");

            } else if (menu == 8) {
                System.exit(0);
            } else {
                System.out.println("opção incorreta! ");
            }

        }

    }

}
