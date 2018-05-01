package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@Controller
public class GreetingController {

	@Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        String sql = "insert into aakashrathore.people values (?)";
        jdbcTemplate.update(sql, name);
        return "greeting";
    }

		@GetMapping("/query1")
    public /*List<String>*/ String query1() {

				// String sql = "SELECT * FROM aakashrathore.people order by name";


	      // List<String> q1answer =jdbcTemplate.queryForList(sql,String.class);
				jdbcTemplate.update('insert into p4t1 values (?)',new Object[]{"name"});
				// jdbcTemplate.update(sql,);

			//	return q1answer;
return "query1";
        // jdbcTemplate.update(sql);
        // return "greeting";
    }

}
