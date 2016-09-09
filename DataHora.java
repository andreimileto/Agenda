/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Date;

/**
 *
 * @author Mileto
 */
public class DataHora {

    private int dia;
    private int mes;
    private int ano;
    private String hora;
    

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
       
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    public static int formatarData(int dia, int mes, int ano){
        String dataFormatada = "";
       
        if(ano < 99){
            dataFormatada = "20"+ano;
        }else{
            dataFormatada = ""+ano;
        }
        if(mes < 10){
            
            dataFormatada = dataFormatada +"0"+mes;
        }else{
            dataFormatada = dataFormatada +""+mes;
        }
        if(dia < 10){
            dataFormatada = dataFormatada+"0"+dia;
            
        }else{
            dataFormatada = dataFormatada+""+dia;
        }
         int result = Integer.parseInt(dataFormatada);
         return result;
    }

    public  boolean validarData(int dia, int mes, int ano) {
        boolean ok = false;
        int[] dmax = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (ano > 0) {
            if (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0)) {
                dmax[1] = 29;
            }
            if (mes >= 1 && mes <= 12) {
                if (dia >= 1 && dia <= dmax[mes - 1]) {
                    ok = true;
                }
            }
        }
        return ok;
    }

}
