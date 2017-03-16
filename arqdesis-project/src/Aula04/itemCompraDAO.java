package Aula04;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class itemCompraDAO {
static {
try {
Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
throw new RuntimeException(e);
}
}
// Obtém conexão com o banco de dados
public Connection obtemConexao() throws SQLException {
return DriverManager
.getConnection("jdbc:mysql://localhost/tutorial?user=alunos&password=alunos");
}
public void incluirItemCompra(int id, int quantidade, Pedido ped, Compra compra) {
String sqlInsert = "INSERT INTO itemCompra(id, quantidade, ped, compra) VALUES (?, ?, ?, ?)";
// usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
stm.setInt(1, id);
stm.setInt(2, quantidade);
stm.setPedido(3, ped);
stm.setCompra(4, compra);
stm.execute();
} catch (SQLException e) {
e.printStackTrace();
}
}
public void atualizarItemCompra(int id, int quantidade,Pedido ped, Compra compra) {
String sqlUpdate = "UPDATE itemCompra SET id=?, quantidade=?, ped=?, compra=? WHERE itemCompra id=?";
// usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
	stm.setInt(1, id);
	stm.setInt(2, quantidade);
	stm.setPedido(3, ped);
	stm.setCompra(4, compra);
	stm.execute();
} catch (Exception e) {
e.printStackTrace();
}
}
public void excluirUltimoItemById(int id) {
String sqlDelete = "DELETE FROM itemCompra WHERE id = ?";
// usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
stm.setInt(1, id);
stm.execute();
} catch (Exception e) {
e.printStackTrace();
}
}
@SuppressWarnings({ "rawtypes", "unchecked" })
public ArrayList carregar(int id) {
ArrayList retorno = new ArrayList();
String sqlSelect = "SELECT id, quantidade FROM itemCompra WHERE itemCompra.id = ?";
// usando o try with resources do Java 7, que fecha o que abriu
try (Connection conn = obtemConexao();
PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
stm.setInt(1, id);
try (ResultSet rs = stm.executeQuery();) {
if (rs.next()) {
retorno.add(rs.getInt("id"));
retorno.add(rs.getInt("quantidade"));
} else {
retorno.add(null);
retorno.add(null);
}
} catch (SQLException e) {
e.printStackTrace();
}
} catch (SQLException e1) {
System.out.print(e1.getStackTrace());
}
return retorno;
}
}

