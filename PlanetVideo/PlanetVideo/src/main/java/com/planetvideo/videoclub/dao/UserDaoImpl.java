package com.planetvideo.videoclub.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import com.planetvideo.videoclub.domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.sql.DataSource;

public class UserDaoImpl implements UsuarioDao {

	private JdbcTemplate jdbcTemplate;
	 
    public UserDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
	@Override
	public void saveOrUpdate(Usuario usuario) {
		// TODO Auto-generated method stub
		 if (usuario.getId() > 0) {
		        // update
		        String sql = "UPDATE usuario SET name=?, email=?, address=?, "
		                    + "telephone=? WHERE usuario_id=?";
		        jdbcTemplate.update(sql, usuario.getUsername(), usuario.getPassword(), usuario.getId());
		    } else {
		        // insert
		        String sql = "INSERT INTO usuario (name, email, address, telephone)"
		                    + " VALUES (?, ?, ?, ?)";
		        jdbcTemplate.update(sql, usuario.getUsername(), usuario.getPassword());
		    }
	}

	@Override
	public void delete(int usuarioid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM usuario WHERE usuario_id=?";
	    jdbcTemplate.update(sql, usuarioid);
	}

	@Override
	public Usuario get(int usuarioid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM usuario WHERE usuario_id=" + usuarioid;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Usuario>() {
	        @Override
	        public Usuario extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Usuario usuario = new Usuario();
	                usuario.setId(rs.getInt("usuario_id"));
	                usuario.setUsername(rs.getString("username"));
	                usuario.setPassword(rs.getString("password"));
	                return usuario;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM usuario";
	    List<Usuario> listusuario = jdbcTemplate.query(sql, new RowMapper<Usuario>() {
	 
	        @Override
	        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Usuario ausuario = new Usuario();
	 
	            ausuario.setId(rs.getInt("usuario_id"));
	            ausuario.setUsername(rs.getString("username"));
	            ausuario.setPassword(rs.getString("password"));
	           
	            return ausuario;
	        }
	 
	    });
	 
	    return listusuario;
	}

}
