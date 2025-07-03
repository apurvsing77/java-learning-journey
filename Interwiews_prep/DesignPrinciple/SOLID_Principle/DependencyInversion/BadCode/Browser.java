package Interwiews_prep.DesignPrinciple.SOLID_Principle.DependencyInversion.BadCode;

class UseController{
		private SQLDatavase sqlDatavase;

		public UseController() {
				this.sqlDatavase = new SQLDatavase();
		}
		public void saveUser(String user){
				sqlDatavase.saveUser(user);
		}
}
class SQLDatavase{

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
