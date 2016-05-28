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
		 if (usuario.getIdusuario() > 0) {
		        // update
		        String sql = "UPDATE usuario SET username=?, password=?, admin=?, "
		                    + " WHERE idusuario=?";
		        jdbcTemplate.update(sql, usuario.getUsername(), usuario.getPassword(),usuario.getAdmin(), usuario.getIdusuario());
		    } else {
		        // insert
		        String sql = "INSERT INTO usuario (username, password, admin)"
		                    + " VALUES (?, ?, ?)";
		        jdbcTemplate.update(sql,usuario.getUsername(), usuario.getPassword(), usuario.getAdmin());
		    }
	}

	@Override
	public void delete(int usuarioid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM usuario WHERE idusuario=?";
	    jdbcTemplate.update(sql, usuarioid);
	}

	@Override
	public Usuario get(int usuarioid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM usuario WHERE idusuario=" + usuarioid;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Usuario>() {
	        @Override
	        public Usuario extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Usuario usuario = new Usuario();
	                usuario.setIdusuario(rs.getInt("idusuario"));
	                usuario.setUsername(rs.getString("username"));
	                usuario.setPassword(rs.getString("password"));
	                usuario.setAdmin(rs.getString("admin"));
	                return usuario;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	@Override
	public List<Usuario> list() { 
		    return this.jdbcTemplate.query( "select username, password, admin from usuario", new UsuarioMapper());
		}

		private static final class UsuarioMapper implements RowMapper<Usuario> {

		    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		        Usuario usuario = new Usuario();
		        usuario.setUsername(rs.getString("username"));
		        usuario.setPassword(rs.getString("password"));
		        usuario.setAdmin(rs.getString("admin"));
		        return usuario;
		    }
		}

		@Override
		public boolean login(String username, String password) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			int contador=0; 
			 contador = jdbcTemplate.queryForObject("SELECT Count(*) FROM usuario WHERE username='" + username+"'" + " and password='" + password+"'", int.class);
			 if (contador == 1){
				 return true;
			 } else{return false;}
			 
 		}

		@Override
		public boolean esAdmin(String username) {
			// TODO Auto-generated method stub
			String admin;
			char c;
			admin = jdbcTemplate.queryForObject("select admin from usuario where username = '"+ username+"'", String.class);
			 c= admin.charAt(0);
			if(c == 'S') {return true;}
			else{return false;}
			 
		}

		 
		 
	}


