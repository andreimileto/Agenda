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
public class ListaDeAgenda {

    private Local local;
    private DataHora data;
    private Compromisso compromisso;
    private boolean status;

    public boolean CompromissosAtivos() {
        boolean ok = false;
        if (status) {
            ok = true;
        }
        return ok;
    }

    // public boolean CompromissosDesativados(){
    //   boolean ok = false;
    //  if(!status){
    //    ok = true;
    // }
    //  return ok;
    //  }
    public boolean cancelarCompromisso() {
        boolean ok = false;
        if (status) {
            ok = true;
            status = false;
        }
        return ok;
    }

    public boolean listarCompromissosDeUmPeriodo(int inicio, int fim) {
        boolean ok = false;
        if (inicio<= data.formatarData(data.getDia(), data.getMes(), data.getAno()) && 
                fim >= data.formatarData(data.getDia(), data.getMes(),data.getAno())) {
            ok = true;
        }
        return ok;
    }

    public boolean reativarCompromisso() {
        boolean ok = false;
        if (!status) {
            ok = true;
            status = true;
        }
        return ok;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public DataHora getDataHora() {
        return data;
    }

    public void setDataHora(DataHora dataHora) {
        this.data = dataHora;
    }

    public Compromisso getCompromisso() {
        return compromisso;
    }

    public void setCompromisso(Compromisso compromisso) {
        this.compromisso = compromisso;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
