package Aula04;

//Código 02 - Service


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class itemCompraDAOService01 {
static {
try {
Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
throw new RuntimeException(e);
}
}
//Obtém conexão com o banco de dados
public Connection obtemConexao() throws SQLException {
return DriverManager
.getConnection("jdbc:mysql://localhost/tutorial?user=alunos&password=alunos");
}
public void incluir(Cliente to) {
String sqlInsert = "INSERT INTO cliente(id, nome, fone) VALUES (?, ?, ?)";
//usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
stm.setInt(1, to.getId());
stm.setString(2, to.getNome());
stm.setString(3, to.getFone());
stm.execute();
} catch (SQLException e) {
e.printStackTrace();
}
}
public void atualizar(Cliente to) {
String sqlUpdate = "UPDATE cliente SET nome=?, fone=? WHERE id=?";
//usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
stm.setString(1, to.getNome());
stm.setString(2, to.getFone());
stm.setInt(3, to.getId());
stm.execute();
} catch (Exception e) {
e.printStackTrace();
}
}
public void excluir(Cliente to) {
14
String sqlDelete = "DELETE FROM cliente WHERE id = ?";
//usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
stm.setInt(1, to.getId());
stm.execute();
} catch (Exception e) {
e.printStackTrace();
}
}
public itemCompra carregarItemCompra(int id) {
itemCompra to = new itemCompra();
String sqlSelect = "SELECT quantidade, ped FROM itemCompra WHERE itemCompra.id = ?";
//usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
stm.setInt(1, id);
try (ResultSet rs = stm.executeQuery();) {
if (rs.next()) {
to.setQuantidade(rs.getInt("Quantidade"));
to.setPed(rs.getPedido("Pedido"));
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