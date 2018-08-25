package com.eintrusty.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eintrusty.entity.Employee;
public interface EmployeeDao extends CrudRepository<Employee, String>{
	
	@Query("select e From Employee e where e.id=:parameter")
	List<String> findIdByParameter(@Param("parameter")String parameter);
	List<Employee> findByFirstName(String firstName);
    Optional<Employee> findById(String id);
    //List<Article> findByTitleAndCategory(String title, String category);

    //@Query("SELECT a FROM Article a WHERE a.title=:title and a.category=:category")
    //List<Article> fetchArticles(@Param("title") String title, @Param("category") String category);

}
