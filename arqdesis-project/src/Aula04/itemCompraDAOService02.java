package Aula04;


public class itemCompraService02 {
itemCompraDAOService01 dao;
public itemCompra() {
dao = new itemCompraDAOService01();
}
public void criarItemCompra(itemCompra to) {
dao.incluirItemCompra(to);
}
public void atualizarItemCompra(itemCompra to) {
dao.atualizarItemCompra(to);
}
public void excluirItemCompra(itemCompra to) {
dao.excluirItemCompra(to);
}
public itemCompra carregarItemCompra(int id) {
15
itemCompra to = dao.carregaritemCompra(id);
return to;
}
@Override
public String toString() {
return "itemCompra [id=" + id + ", quantidade=" + quantidade + ", ped=" + ped + ", comp="+ comp + "]";
}
}