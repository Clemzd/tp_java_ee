/*
 * Created on 8 oct. 2013 ( Time 22:11:33 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package emn.association.persistence.services;

import java.util.List;
import java.util.Map;

import emn.association.bean.Article ;

/**
 * Basic persistence operations for entity "Article"
 * 
 * This Bean has a basic Primary Key : String
 *
 * @author Telosys Tools Generator
 *
 */
public interface ArticlePersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param article
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Article article) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param code
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(String code) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param article
	 */
	public void insert(Article article) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param code
	 * @return the entity loaded (or null if not found)
	 */
	public Article load(String code) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<Article> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<Article> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<Article> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param article
	 * @return
	 */
	public Article save(Article article) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<Article> search( Map<String, Object> criteria ) ;
}
