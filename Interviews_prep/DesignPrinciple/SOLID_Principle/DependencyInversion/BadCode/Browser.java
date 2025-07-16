package Interviews_prep.DesignPrinciple.SOLID_Principle.DependencyInversion.BadCode;

class UseController{
		private SQLDatabase sqlDatabase;

		public UseController() {
				this.sqlDatabase = new SQLDatabase();
		}
		public void saveUser(String user){
				sqlDatabase.saveUser(user);
		}
}
class SQLDatabase {

		public void saveUser(String user){
				System.out.println("User - "+user+" user saved in sql ");
		}

}

public class Browser {
		public static void main(String[] args) {

				UseController useController = new UseController();
				useController.saveUser("u1");
		}
}
