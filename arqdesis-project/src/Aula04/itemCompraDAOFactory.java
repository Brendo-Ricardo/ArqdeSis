package Aula04;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class itemCompraDAOFactory {
public void incluirItemCompra(itemCompraTO to) {
String sqlInsert = "INSERT INTO itemCompra(id, quantidade, ped, comp) VALUES (?, ?, ?,?)";
// usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = ConnectionFactory.obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
stm.setInt(1, to.getId());
stm.setInt(2, to.getQuantidade());
stm.setPedido(3, to.getPed());
stm.setCompra(4, to.getComp());
stm.execute();
} catch (SQLException e) {
e.printStackTrace();
}
}
public void atualizarItemCompra(itemCompraTO to) {
String sqlUpdate = "UPDATE itemCompra SET quantidade=?, ped=?, comp=? WHERE id=?";
// usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = ConnectionFactory.obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
stm.setInt(1, to.getQuantidade());
stm.setPedido(2, to.getPed());
stm.setCompra(3, to.getComp());
stm.setInt(4, to.getId());
stm.execute();
} catch (Exception e) {
e.printStackTrace();
}
}
public void excluirItemCompra(itemCompraTO to) {
String sqlDelete = "DELETE FROM itemCompra WHERE id = ?";
// usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = ConnectionFactory.obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
stm.setInt(1, to.getId());
stm.execute();
} catch (Exception e) {
e.printStackTrace();
}
}
public itemCompraTO carregarItemCompra(int id) {
itemCompraTO to = new itemCompraTO();
String sqlSelect = "SELECT quantidade, ped, comp FROM itemCompra WHERE itemCompra.id = ?";
// usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = ConnectionFactory.obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
stm.setInt(1, id);
try (ResultSet rs = stm.executeQuery();) {
if (rs.next()) {
to.setQuantidade(rs.getInt("Quantidade"));
to.setComp(rs.getCompra("Compra"));
}
} catch (SQLException e) {
e.printStackTrace();
}
} catch (SQLException e1) {
System.out.print(e1.getStackTrace());
}
return to;
}
}