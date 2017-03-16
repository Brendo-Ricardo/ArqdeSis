package Aula04;

import java.util.ArrayList;

public class Compra {
private int id;
private int quantidade;
private Pedido ped;
private Compra comp;
public Compra(int id,int quantidade, Pedido ped, Compra comp) {
this.id = id;
this.quantidade = quantidade;
this.ped = ped;
this.comp = comp;
}
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
public Pedido getPed() {
return ped;
}
public void setPed(Pedido ped) {
this.ped = ped;
}
public void criarItemCompra() {
itemCompraDAO dao = new itemCompraDAO();
dao.incluirItemCompra(id, quantidade, ped, comp);
}
public void atualizariTemCompra() {
itemCompraDAO dao = new itemCompraDAO();
dao.atualizarItemCompra(id, quantidade, ped, comp);
}
public void excluirItemCompra() {
itemCompraDAO dao = new itemCompraDAO();
dao.excluirItemCompra(id);
}
public void carregarItemCompra() {
itemCompraDAO dao = new itemCompraDAO;
@SuppressWarnings("rawtypes")
ArrayList dados = dao.carregar(id);
id = (int) dados.get(0);
quantidade = (int) dados.get(1);
ped = (Pedido) dados.get(2);
comp = (Compra) dados.get(3);
}
@Override
public String toString() {
return "itemCompra [id=" + id + ", quantidade=" + quantidade + ", ped=" + ped + ", comp=" + comp]";
}
}

