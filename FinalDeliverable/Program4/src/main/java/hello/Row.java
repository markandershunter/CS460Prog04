package hello;
public class Row{
	int rnum = -1;
  int bnum = -1;
	String name = null;
  int amount = -1;
  public Row(){

  }
	public Row(String name,int rnum, int bnum){
		this.bnum = bnum;
		this.name = name;
    this.rnum = rnum;
	}

  public Row(String name,int rnum, int bnum, int amount){
		this.bnum = bnum;
		this.name = name;
    this.rnum = rnum;
    this.amount = amount;
	}

}
