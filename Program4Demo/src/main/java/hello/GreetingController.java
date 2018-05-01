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

// 		@GetMapping("/query1")
//     public /*List<String>*/ String query1() {
//
// 				// String sql = "SELECT * FROM aakashrathore.people order by name";
//
//
// 	      // List<String> q1answer =jdbcTemplate.queryForList(sql,String.class);
// 				jdbcTemplate.update('insert into p4t1 values (?)',new Object[]{"name"});
// 				// jdbcTemplate.update(sql,);
//
// 			//	return q1answer;
// return "query1";
//         // jdbcTemplate.update(sql);
//         // return "greeting";
//     }



//works!
// @GetMapping("/query1")
// public String query1(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
// 		model.addAttribute("name", name);
// 		String sql = "insert into aakashrathore.people values (?)";
// 		jdbcTemplate.update(sql, name);
// 		return "query1";
//


//works!
// @GetMapping("/query1")
// public String query1(Model model) {
// 		String sql = "select * from aakashrathore.people";
// 		List<String> q1answer =jdbcTemplate.queryForList(sql,String.class);
// 		model.addAttribute("q1answer", q1answer);
//
// 		// jdbcTemplate.update(sql, name);
// 		return "query1";



		@GetMapping("/query1")
		public String query1(Model model) {
				String sql = "select * from p4t2";


				List<Row> ans = jdbcTemplate.query(sql, new RowMapper<Row>(){

            public Row mapRow(ResultSet rs, int rownum)
                    throws SQLException {
                Row r = new Row(rs.getInt("id"),rs.getString("name"));
                return r;
            }

        });



				    // List<Row> ans =  jdbcTemplate.query(sql,new RowMapper<Row>(){
				    //   @Override
				    //   public Row mapRow(ResultSet rs, int rownumber) throws  SQLException    {
				    //         Row r=new Row((rs.getInt('ID')),(rs.getString('Name')));
				    //         return r;
				    //       }
				    //   });

							ArrayList<Integer> ids = new ArrayList<Integer>();
							ArrayList<String> names = new ArrayList<String>();
							for(int i = 0; i < ans.size(); i++){
								ids.add(ans.get(i).ID);
								names.add(ans.get(i).name);
							}



		model.addAttribute("ans", ans);
		model.addAttribute("ids", ids);
		model.addAttribute("names", names);

				return "query1";
		}//query1

		@GetMapping("/addstudent")
    public String addstudent(@RequestParam(name="sname") String sname, @RequestParam(name="shome") String shome,
		@RequestParam(name="sid") String sid, @RequestParam(name="sphone") String sphone,
		@RequestParam(name="semail") String semail, @RequestParam(name="sgender") String sgender,
		@RequestParam(name="sdob") String sdob, @RequestParam(name="scategory") String scategory,
		@RequestParam(name="smajor") String smajor, @RequestParam(name="sminor") String sminor,
		@RequestParam(name="sadviser") String sadviser, Model model) {


				model.addAttribute("sname", sname);
				model.addAttribute("shome", shome);
        // String sql = "insert into aakashrathore.people values (?)";
        // jdbcTemplate.update(sql, sname);
        return "addstudent";
    }


		@GetMapping("/addstaff")
    public String addstaff(@RequestParam(name="staid") String staid, @RequestParam(name="staname") String staname,
		@RequestParam(name="stabuild") String stabuild, @RequestParam(name="staemail") String staemail,
		@RequestParam(name="stahome") String stahome, @RequestParam(name="stadob") String stadob,
		@RequestParam(name="stagender") String stagender, @RequestParam(name="statitle") String statitle,
		Model model) {

				// model.addAttribute("sname", sname);
				// model.addAttribute("shome", shome);
        // String sql = "insert into aakashrathore.people values (?)";
        // jdbcTemplate.update(sql, sname);
        return "addstudent";
    }

		@GetMapping("/addlease")
    public String addlease(@RequestParam(name="lid") String lid, @RequestParam(name="lroom") String lroom,
		@RequestParam(name="lbuild") String lbuild, Model model) {

				// model.addAttribute("sname", sname);
				// model.addAttribute("shome", shome);
        // String sql = "insert into aakashrathore.people values (?)";
        // jdbcTemplate.update(sql, sname);
        return "addstudent";
    }

		@GetMapping("/updaterent")
    public String updaterent(@RequestParam(name="rroom") String rroom, @RequestParam(name="rbuild") String rbuild,
		@RequestParam(name="rrent") String rrent, Model model) {

				// model.addAttribute("sname", sname);
				// model.addAttribute("shome", shome);
				//UPDATE Customers SET ContactName = 'Alfred Schmidt' WHERE CustomerID = 1 and ;
        // String sql = "insert into aakashrathore.people values (?)";
        // jdbcTemplate.update(sql, sname);
        return "addstudent";
    }

		@GetMapping("/deletestudent")
    public String deletestudent(@RequestParam(name="did") String did,
		Model model) {

				model.addAttribute("did", did);
        // String sql = "insert into aakashrathore.people values (?)";
				//DELETE FROM table_name WHERE condition;
        // jdbcTemplate.update(sql, sname);
        return "deletestudent";
    }

}
