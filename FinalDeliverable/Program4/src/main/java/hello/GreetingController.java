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


@GetMapping("/query3")
public String query3(Model model) {
		String sql = "select student.name,lease.building_num,lease.room_num,invoice.amount_due from student,lease,invoice where lease.student_id = id_num and invoice.lease_num = lease.lease_num and id_num in (select student_id from lease where lease.lease_num in (select lease_num from invoice where date_paid = '-'))";


		List<Row> ans = jdbcTemplate.query(sql, new RowMapper<Row>(){

				public Row mapRow(ResultSet rs, int rownum)
								throws SQLException {
						Row r = new Row(rs.getString("name"),rs.getInt("room_num"),rs.getInt("building_num"),rs.getInt("amount_due"));
						return r;
				}

		});


					ArrayList<Integer> ids = new ArrayList<Integer>();
					ArrayList<Integer> bids = new ArrayList<Integer>();
					ArrayList<Integer> amt = new ArrayList<Integer>();
					ArrayList<String> names = new ArrayList<String>();
					for(int i = 0; i < ans.size(); i++){
						ids.add(ans.get(i).rnum);
						bids.add(ans.get(i).bnum);
						names.add(ans.get(i).name);
						amt.add(ans.get(i).amount);
					}



model.addAttribute("amt", amt);
model.addAttribute("ids", ids);
model.addAttribute("names", names);
model.addAttribute("bids", bids);
sql = "select sum(amount_due) from invoice where date_paid='-'";
List<Integer> rent =jdbcTemplate.queryForList(sql,Integer.class);
model.addAttribute("total", rent.get(0));
		return "query3";
}//query3


@GetMapping("/query4")
public String query4(@RequestParam(name="major") String major, Model model) {
		String sql = "select name from student where major='"+major+"'";
List<String> names =jdbcTemplate.queryForList(sql,String.class);
model.addAttribute("names",names);
model.addAttribute("major",major);
		return "query4";
}//query4

@GetMapping("/query5")
public String query5(Model model) {
		String sql = "select name from adviser where id_num in (select distinct adviser_id from student where student.major = 'Chemistry')";
List<String> names =jdbcTemplate.queryForList(sql,String.class);
model.addAttribute("names",names);

		return "query5";
}//query5


@GetMapping("/query2")
public String query2(Model model) {

		String sql = "select count(category) from student join lease on id_num=student_id "+
   "join room on lease.building_num=room.building_num and lease.room_num=room.room_num "+
   "join building on building.building_num=room.building_num "+
   "where building.type='apartment' and student.category='undergrad'";

List<Integer> rent =jdbcTemplate.queryForList(sql,Integer.class);
model.addAttribute("aptunder", rent.get(0));

sql = "select count(category) from student join lease on id_num=student_id "+
   "join room on lease.building_num=room.building_num and lease.room_num=room.room_num "+
   "join building on building.building_num=room.building_num "+
  "where building.type='res_hall' and student.category='undergrad'";

rent =jdbcTemplate.queryForList(sql,Integer.class);
model.addAttribute("resunder", rent.get(0));

sql = "select count(category) from student join lease on id_num=student_id "+
   "join room on lease.building_num=room.building_num and lease.room_num=room.room_num "+
   "join building on building.building_num=room.building_num "+
   "where building.type='res_hall' and student.category='postgrad'";

rent =jdbcTemplate.queryForList(sql,Integer.class);
model.addAttribute("respost", rent.get(0));

sql = "select count(category) from student join lease on id_num=student_id "+
   "join room on lease.building_num=room.building_num and lease.room_num=room.room_num "+
   "join building on building.building_num=room.building_num "+
   "where building.type='apartment' and student.category='postgrad'";

rent =jdbcTemplate.queryForList(sql,Integer.class);
model.addAttribute("aptpost", rent.get(0));

		return "query2";
}//query1

		@GetMapping("/query1")
		public String query1(Model model) {
				String sql = "select staff.name, phone_num from resHallInfo join staff using (staff_id)";


				List<StrRow> ans = jdbcTemplate.query(sql, new RowMapper<StrRow>(){

            public StrRow mapRow(ResultSet rs, int rownum)
                    throws SQLException {
                StrRow r = new StrRow(rs.getString("name"),rs.getString("phone_num"));
                return r;
            }

        });


							ArrayList<String> ids = new ArrayList<String>();
							ArrayList<String> names = new ArrayList<String>();
							for(int i = 0; i < ans.size(); i++){
								ids.add(ans.get(i).str1);
								names.add(ans.get(i).str2);
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
        String sql = "insert into student values (?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, sid, sname, shome, sphone, semail, sgender, sdob, scategory,
				smajor, sminor, sadviser);
        return "addstudent";
    }


		@GetMapping("/addstaff")
    public String addstaff(@RequestParam(name="staid") String staid, @RequestParam(name="staname") String staname,
		@RequestParam(name="stabuild") String stabuild, @RequestParam(name="staemail") String staemail,
		@RequestParam(name="stahome") String stahome, @RequestParam(name="stadob") String stadob,
		@RequestParam(name="stagender") String stagender, @RequestParam(name="statitle") String statitle,
		Model model) {

			  model.addAttribute("sname", staname);
				String sql = "insert into staff values (?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, staid, stabuild, staname, staemail, stahome, stadob, stagender, statitle);
        return "addstudent";
    }

		@GetMapping("/addlease")
    public String addlease(@RequestParam(name="lid") String lid, @RequestParam(name="lroom") String lroom,
		@RequestParam(name="lbuild") String lbuild, Model model) {

				model.addAttribute("sname", lid);

				//query for monthly rent first
				String sql = "select monthly_rent from room where room_num = "+lroom+" and building_num = "+lbuild;

				List<Integer> rent =jdbcTemplate.queryForList(sql,Integer.class);

				sql = "insert into lease values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, 10, 1, lid, lbuild, lroom, rent.get(0));

				return "addstudent";
    }

		@GetMapping("/updaterent")
    public String updaterent(@RequestParam(name="rroom") String rroom, @RequestParam(name="rbuild") String rbuild,
		@RequestParam(name="rrent") String rrent, Model model) {

        String sql = "UPDATE room SET monthly_rent = "+rrent+" WHERE room_num = "+rroom+" and building_num = "+rbuild;
        jdbcTemplate.update(sql);
        return "updaterent";
    }

		@GetMapping("/deletestudent")
    public String deletestudent(@RequestParam(name="did") String did,
		Model model) {

				model.addAttribute("did", did);
        String sql = "DELETE FROM student WHERE id_num = "+did;
				//delete student along with all the leases
        jdbcTemplate.update(sql);
				sql = "DELETE FROM lease WHERE student_id = "+did;
				jdbcTemplate.update(sql);
        return "deletestudent";
    }

}
