package Book;
//import java.net.URLEncoder;
import java.sql.*;

import sql.Sql;
import sql.sql_book;
import java.util.*;
import sql.sql_author;


import org.apache.struts2.ServletActionContext;
public class book {
	
	 private static String authorname;
	 private static String Title;
	 private String ISBN;
	 private String Publisher;
	 private String PublishDate;
	 private String Price;
	 private String Age;
	 private String Country;
	 private static int rowCount;
	 private String authorid;
	 private String AuthorID="";
	 sql_author author=new sql_author();
	 sql_book bd=new sql_book(); 
	 public List<sql_book> Reportlist=new  ArrayList<sql_book>();
	 int i=0;
	 
	public void setAuthorID(String AuthorID)
	{
		this.AuthorID=AuthorID;
	}
	public String getAuthorID()
	{
		return this.AuthorID;
	}
	
	public void setContentList(List<sql_book> Reportlist)
	{
		this.Reportlist=Reportlist;
	}
	public List<sql_book> getContentlist()
	{
		return this.Reportlist;
	}
	
	
	public void setTitle(String Title)
	{
		this.Title=Title;
	}
	public String getTitle()
	{
		return this.Title;
	}
	
	public void setauthorid(String authorid)
	{
		this.authorid=authorid;
	}
	public String getauthorid()
	{
		return this.authorid;
	}
	
	 public  void setAuthorname(String authorname)
	{
		this.authorname=authorname;
	}
	public String getAuthorname()
	{
		return this.authorname;
	}
	
	
	public void setISBN(String ISBN)
	{
		this.ISBN=ISBN;
	}
	public String getISBN()
	{
		return this.ISBN;
	}
	
	
	public void setPublisher(String Publisher)
	{
		this.Publisher=Publisher;
	}
	public String getPublisher()
	{
		return this.Publisher;
	}
	
	public void setPublishDate(String PublishDate)
	{
		this.PublishDate=PublishDate;
	}
	public String getPublishDate()
	{
		return this.PublishDate;
	}
	
	public void setPrice(String Price)
	{
		this.Price=Price;
	}
	public String getPrice()
	{
		return this.Price;
	}
	
	
	public void setAge(String Age)
	{
		this.Age=Age;
	}
	public String getAge()
	{
		return this.Age;
	}
	
	public void setCountry(String Country)
	{
		this.Country=Country;
	}
	public String getCountry()
	{
		return this.Country;
	}
	
	
	public String execute() throws Exception
	 {
		if(AuthorID.equals(""))//名字查询
		{
			Sql SQL=new Sql();
			String body="select* from Author where Name="+"'"+getAuthorname()+"'";
			ResultSet rs=SQL.executeQuery(body);
			if(rs.next())//作者存在
			{
				String nobody="select* from Book where AuthorID=(select AuthorID from Author where Name="+"'"+getAuthorname()+"'"+")";
	            ResultSet rsn=SQL.executeQuery(nobody);	
				while(rsn.next())
				{
					sql_book bd=new sql_book(); 
		    		   bd.setISbn( rsn.getString(1));
		    		   bd.setTitle(rsn.getString(2));
		    		   bd.setAuthorID(rsn.getString(3));
		    		   bd.setPublisher(rsn.getString(4));
		    		   bd.setPublishDate( rsn.getString(5));
		    		   bd.setPrice( rsn.getString(6));
		    		   Reportlist.add(i,bd);
		    		   i++;
				}
				if(i==0)
				{
					return "veryerror";//有作者但没书
				}
				return "success";//有作者有书
			}
			return "error";//无书无作者
			
		}
		else//作者id进行查询
		{
			
			Sql SQL=new Sql();
			String nobody="select* from Book where AuthorID="+"'"+getAuthorID()+"'";
			ResultSet rsn=SQL.executeQuery(nobody);		
			while(rsn.next())
			{
				
	    		   sql_book bd=new sql_book(); 
	    		   bd.setISbn( rsn.getString(1));
	    		   bd.setTitle(rsn.getString(2));
	    		   bd.setAuthorID(rsn.getString(3));
	    		   bd.setPublisher(rsn.getString(4));
	    		   bd.setPublishDate(rsn.getString(5));
	    		   bd.setPrice( rsn.getString(6));
	    		   Reportlist.add(i,bd);
	    		   i++;
	    	 }
		    if(i!=0)
    	    {
    	    	 return "success";
    	    }
    	    return "veryerror";
		}
	}
	public String Select() throws Exception
	 {
		 Sql SQL=new Sql();
		 
		 setISBN(ServletActionContext.getRequest().getParameter("ISBN"));
		 String sql1 ="select * from Book where ISBN="+getISBN();
         ResultSet rS1 = SQL.executeQuery(sql1);//从author表中获取作者详细信息
		 while(rS1.next())
		 {

	  		   bd.setISbn( rS1.getString(1));
	  		   bd.setTitle(rS1.getString(2));
	  		   bd.setAuthorID(rS1.getString(3));
	  		   bd.setPublisher(rS1.getString(4));
	  		   bd.setPublishDate(rS1.getString(5));
	  		   bd.setPrice(rS1.getString(6));
		 }
		 
		 String sql2 ="select * from Author where AuthorID=( select AuthorID from Book where ISBN="+getISBN()+")";  
		 ResultSet rS2 = SQL.executeQuery(sql2);//从book表中获取图书详细信息
		 while(rS2.next())
		 {
			 author.setAuthorID( rS2.getString(1));
			 author.setName(rS2.getString(2));
			 author.setAge(rS2.getString(3));
			 author.setCountry(rS2.getString(4));
		 }
		   ServletActionContext.getRequest().setAttribute("author", author);
		   ServletActionContext.getRequest().setAttribute("bd", bd);
		  return "success";
		 
    }
	 
    public String delete() throws Exception
	 {
    	 Sql SQL=new Sql();
    	 setAuthorID(ServletActionContext.getRequest().getParameter("AuthorID"));
    	 setISBN(ServletActionContext.getRequest().getParameter("key"));
		 String delete_sql="delete from Book where ISBN="+getISBN();
		 SQL.executeUpdate(delete_sql);
		 return "deletesuccess";
		 
	 }
	 
	public String  addbook() throws Exception
	 {
		
		 Sql SQL=new Sql();
		 String sql="select* from Author where Name="+"'"+getAuthorname()+"'";
		 ResultSet rs = SQL.executeQuery("select* from Author");
		 rowCount=0;
		while(rs.next())
		{
			rowCount++;
		}
		 System.out.println(rowCount);
		 ResultSet rts = SQL.executeQuery(sql);
		 if(rts.next())
		 {
			 String AuthorID;
			 AuthorID=rts.getString(1);
			 String IN_sql="insert into Book values("+getISBN()+","+"'"+Title+"'"+","+AuthorID+","+"'"+getPublisher()+"'"+","+"'"+getPublishDate()+"'"+","+"'"+getPrice()+"'"+")";
			 SQL.executeUpdate(IN_sql);
			 return "Hava_an_author";
		 }
		 //如果往下执行说明没有作者，此时不仅要往book表单中添加新书，还要往author表单中添加新书对应的作者
		 rowCount++;//设置此量为新增作者的authorid
		 String INbook_sql="insert into Book values("+getISBN()+","+"'"+Title+"'"+","+rowCount+","+"'"+getPublisher()+"'"+","+"'"+getPublishDate()+"'"+","+"'"+getPrice()+"'"+")";
		 SQL.executeUpdate(INbook_sql);
		 //String INauthor_sql="insert into author values("+rowCount+","+getAuthorname()+",";
		 return "noauthor";
	 }
	
	public String addauthor() throws Exception
	{
		Sql SQL=new Sql();
		String INauthor_sql="insert into Author values("+rowCount+","+"'"+getAuthorname()+"'"+","+getAge()+","+"'"+getCountry()+"'"+")";
		SQL.executeUpdate(INauthor_sql);
		return "author_add_ok";
	}
	 
	public String select_() throws Exception 
	{
		Sql SQL=new Sql();
		String sk_sql="select* from Book where Title="+"'"+getTitle()+"'";
		ResultSet rs=SQL.executeQuery(sk_sql);
		if(rs.next())
		{
			return "refresh";
		}
		return "no_book";
	}
	
	public String refresh() throws Exception 
	{
		Sql SQL=new Sql();
		String sql="select* from Author where Name="+"'"+getAuthorname()+"'";
		ResultSet rs=SQL.executeQuery(sql);
		if(rs.next())
		{
			setauthorid(rs.getString(1));
		}
		String refresh_sql="update Book set  AuthorID="+getauthorid()+","+"Publisher="+"'"+getPublisher()+"'"+","+"PublishDate="+"'"+getPublishDate()+"'"+","+" Price="+"'"+getPrice()+
				"'"+"where Title="+"'"+getTitle()+"'";
		SQL.executeUpdate(refresh_sql);
		return "refresh_ok";
		
		
		
	}
}
 