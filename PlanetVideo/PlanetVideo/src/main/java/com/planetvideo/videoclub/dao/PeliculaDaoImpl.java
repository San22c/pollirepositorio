package com.planetvideo.videoclub.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.client.RestTemplate;

import com.planetvideo.videoclub.domain.Pelicula;
import com.planetvideo.videoclub.domain.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

 
import javax.sql.DataSource;

public class PeliculaDaoImpl implements PeliculaDao {

	private JdbcTemplate jdbcTemplate;
	 
    public PeliculaDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 	 

	@Override
	public Pelicula get(String titulo) {
		// TODO Auto-generated method stub
		
		// LLAMADA REST
		RestTemplate restTemplate = new RestTemplate(); 
		
		String sql = "SELECT * FROM pelicula WHERE nombre='" + titulo+"'";
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Pelicula>() {
	        @Override
	        public Pelicula extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Pelicula peli = new Pelicula();
	                
	                peli.setTitle(rs.getString("nombre"));
			        peli.setUrl(rs.getString("url"));
			        peli.setPlot(rs.getString("descripcion"));
			        peli.setYear(rs.getString("año"));
			        peli.setDirector(rs.getString("director"));
			        peli.setActors(rs.getString("reparto"));
			        peli.setPoster(rs.getString("urlportada"));
			        peli.setImdbRating(rs.getString("valoracion"));
			        String url = "http://www.omdbapi.com/?t="+rs.getString("nombre")+"&y=&plot=short&r=json";		  
				    Pelicula peli_REST = restTemplate.getForObject(url, Pelicula.class); 
				    
				    String anio = rs.getString("año");
				    
			        if(rs.getString("descripcion").length()<=1){
			        	peli.setPlot(peli_REST.getPlot());
			        }
			        if(rs.getString("año").length()<=1){
			        	peli.setYear(peli_REST.getYear());
			        }
			        if(rs.getString("director").length()<=1){
			        	peli.setDirector(peli_REST.getDirector());
			        }
			        if(rs.getString("reparto").length()<=1){
			        	peli.setActors(peli_REST.getActors());
			        }
			        if(rs.getString("urlportada").length()<=1){
			        	peli.setPoster(peli_REST.getPoster());
			        }
			        if(rs.getString("valoracion").length()<=1) {
			        	 peli.setImdbRating(peli_REST.getImdbRating());
			        }
	                return peli;
	            }
	 
	            return null;
	        }

	    });
 	}

	@Override
	public List<Pelicula> list() { 
		    return this.jdbcTemplate.query( "select * from pelicula", new PeliculaMapper());
		}

		private static final class PeliculaMapper implements RowMapper<Pelicula> {

		    public Pelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
		        Pelicula peli = new Pelicula();
		        peli.setTitle(rs.getString("nombre"));
		        peli.setUrl(rs.getString("url"));
		        return peli;
		    }
		}

		@Override
		public void save(Pelicula pelicula) {
			// TODO Auto-generated method stub
			 if (pelicula.getIdpelicula()<= 0) {
			       
			        // insert
			        String sql = "INSERT INTO pelicula (nombre, url, descripcion, año, director, reparto, urlportada, valoracion)"
			                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			        jdbcTemplate.update(sql,pelicula.getTitle(),pelicula.getUrl(),pelicula.getPlot(),pelicula.getYear(),pelicula.getDirector(),pelicula.getActors(),pelicula.getPoster(),pelicula.getImdbRating());
			    }
		}

		@Override
		public void edit(Pelicula pelicula) {
			// TODO Auto-generated method stub
 			 if (pelicula.getTitle() != null) {
			        // update
			        String sql = "UPDATE pelicula SET nombre=?, url=?, descripcion=?, año=?, director=?, reparto=?, urlportada=?, valoracion=? "
			                    + " WHERE nombre=?";
			        jdbcTemplate.update(sql,pelicula.getTitle(),pelicula.getUrl(),pelicula.getPlot(),pelicula.getYear(),pelicula.getDirector(),pelicula.getActors(),pelicula.getPoster(),pelicula.getImdbRating(), pelicula.getTitle());
					}
			 }
		

		@Override
		public void delete(String nombre) {
			// TODO Auto-generated method stub
			String sql = "DELETE FROM pelicula WHERE nombre=?";
		    jdbcTemplate.update(sql, nombre);
		}
 
		 
	}



