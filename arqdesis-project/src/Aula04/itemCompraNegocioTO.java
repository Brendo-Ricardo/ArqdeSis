package Aula04;


public class itemCompraNegocioTO {
private int id;
private int quantidade;
private Pedido ped;
private Compra comp;

public ItemCompra(int id, int quantidade,Pedido ped, Compra comp) {
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


public Compra getComp() {
return comp;
}
public void setComp(Compra comp) {
this.comp = comp;
}


public void criarItemCompra() {
ItemCompraDAO dao = new ItemCompraDAO();
ItemCompraTO to = new ItemCompraTO();
to.setId(id);
to.setQuantidade(quantidade);
to.setPed(ped);
to.setComp(comp);
dao.incluir(to);
}
public void atualizarItemCompra() {
ItemCompraDAO dao = new ItemCompraDAO();
ItemCompraTO to = new ItemCompraTO();
to.setId(id);
to.setQuantidade(quantidade);
to.setPed(ped);
to.setComp(comp);
dao.atualizar(to);
}
public void excluirItemCompra() {
ItemCompraDAO dao = new ItemCompraDAO();
ItemCompraTO to = new ItemCompraTO();
to.setId(id);
dao.excluirItemCompra(to);
}
public void carregarItemCompra() {
ItemCompraDAO dao = new ItemCompraDAO();
ItemCompraTO to = dao.carregarItemCompra(id);
quantidade = to.getQuantide();
ped = to.getPed();
comp = to.getComp();
}

@Override
public String toString() {
return "ItemCompra [id=" + id + ", quantidade=" + quantidade + ", ped=" + ped + "]" + comp + " ,comp=";
}
}