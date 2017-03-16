package Aula04;

package arqdesis-project;

public class itemCompraTO {
private int id;
private int quantidade;
private Pedido ped;
private Compra comp;

public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}


public int getQuantidade() {
return quantidade;
}
public void setQuantidade(int quantidade) {
this.quantidade = quantidade;
}

public int getPed() {
return ped;
}

public void setPed(Pedido ped) {
this.ped = ped;
}

public int getComp() {
return comp;
}
public void setComp(Compra comp) {
this.comp = comp;
}






}
