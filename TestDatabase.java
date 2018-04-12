
import com.ilyriadz.database.DatabaseManager;
import com.ilyriadz.database.Ucanaccess;
import java.sql.ResultSet;

public class TestDatabase 
{
    public static void main(String[] args)
    {
        DatabaseManager dbm = new Ucanaccess();
        dbm.setConnection("./database.mdb;newDatabaseVersion=V2007");
        
        // create a table
        dbm.create("person", 
              "id counter primary key,"
            + "fname text not null,"
            + "lname text not null");
        
        // get ResultSet of select query
        ResultSet rs = dbm.select("*", "person", "id>=1", "order by id limit 10");
        
        // insert a row on the person table
        dbm.insert("person", "fname, lname", "'ilyes', 'sadaoui'");
        // like select but print the result
        dbm.printTable("*", "person", "id>=1", "limit 10");
        
        // update row(s) of table person
        dbm.update("person", "lname='ilyriadja'", "id=1");
        dbm.printTable("*", "person", "", "");
        
        // delete row(s) from table person
        dbm.delete("person", "id=1");
        dbm.printTable("*", "person", "", "");
        
        // drop person table (drop is drop table statement)
        dbm.drop("person");
    } // end main
} // end class TestDatabase
