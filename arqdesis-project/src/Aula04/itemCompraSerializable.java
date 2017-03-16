package Aula04;

//SERVIECE - SERIAZABLE (COD 01)
package arqdesis-project;

import java.io.Serializable;

public class itemCompraSerializable implements Serializable {
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


public String getQuantidade() {
return quantidade;
}
public void setQuantidade(Int quantidade) {
this.quantidade = quantidade;
}


public Pedido getPed() {
return ped;
}
public void setPed(Pedido ped) {
this.ped = ped;
}

public Compra getComp() {
return comp;
}
public void setComp(Compra comp) {
this.comp = comp;
}





}