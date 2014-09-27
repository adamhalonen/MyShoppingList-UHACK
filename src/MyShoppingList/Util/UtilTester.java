package MyShoppingList.Util;

public class UtilTester {

	public static void main(String[] args) {
		Util util = new Util();
		String[] products = {"men's+levi+jeans+30x32","aveeda+men+shampoo","cup"};
		String[][] productInfo = util.getProductInfo(products, "1375");
		
		for(int i = 0 ;i < 3;i++)
		{
			for(int j = 0;j<3;j++)
			{
				System.out.print("");
				System.out.print(productInfo[i][j]+ " ");
			}
			System.out.println();
				
		}

	}

}
