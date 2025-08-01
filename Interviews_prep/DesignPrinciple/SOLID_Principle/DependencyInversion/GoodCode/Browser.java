package Interviews_prep.DesignPrinciple.SOLID_Principle.DependencyInversion.GoodCode;

class UseController{
		private Database database;

		public UseController(Database database) {
				this.database = database;
		}
		public void saveUser(String user){
				database.saveUser(user);
		}
}
interface Database{
		public void saveUser(String user);
}

class SQLDatabase implements Database{

		public void saveUser(String user){
				System.out.println("User - "+user+" user saved in sql ");
		}

}
class MongoDb implements Database{

		public void saveUser(String user){
				System.out.println("User - "+user+" user saved in mongodb ");
		}

}


public class Browser {
		public static void main(String[] args) {

//				Database database = new SQLDatabase();
				UseController useController = new UseController(new SQLDatabase());
				UseController useController1 = new UseController(new MongoDb());
				useController1.saveUser("U2");
				useController.saveUser("u1");
		}
}
