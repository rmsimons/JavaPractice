import java.awt.*;

/*This program generates black w/ blue cross and white tile pairs radially 
 * depending on the location you specify, # of tile pairs, and tile size. 
 * In the main method, call singleRow if you want to generate just one 
 * row or call grid if you want to generate multiple rows. */  

public class CafeWall {
	
	//class constant, changes tile spacing in grid
	public static final int MORTAR = 2;

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(650, 400);
		panel.setBackground(Color.GRAY);
		Graphics g = panel.getGraphics();

		singleRow(g, 0, 0, 4, 20); // x, y, # of tile pairs, tile size)
		singleRow(g, 50, 70, 5, 30);
		grid(g, 10, 150, 4, 25, 0); // x, y, # of tile pairs/rows, tile size, 2nd row offset)
		grid(g, 250, 200, 3, 25, 10);
		grid(g, 425, 180, 5, 20, 10);
		grid(g, 400, 20, 2, 35, 35);

	}

	//generates one row of tile pairs
	public static void singleRow(Graphics g, int x, int y, int tilePairs, int size) {

		for (int i = 0; i < tilePairs; i++) {

			int topLeftBlack = x + i * (2 * size);  //top left black box location algorithm
			int topLeftWhite = topLeftBlack + size; //top left white box location algorithm

			g.setColor(Color.BLACK);
			g.fillRect(topLeftBlack, y, size, size);
			g.setColor(Color.BLUE);
			g.drawLine(topLeftBlack, y, topLeftWhite, y + size);
			g.drawLine(topLeftWhite, y, topLeftBlack, y + size);
			g.setColor(Color.WHITE);
			g.fillRect(topLeftWhite, y, size, size);

		}

	}

	//generates a grid of tile pairs
	public static void grid(Graphics g, int x, int y, int tilePairs, int size, int rowOffset) {

		for (int i = 0; i < tilePairs; i++) {

			int startLocation = y + i * 2 * (size + MORTAR);   //'y' location for next grid row
			int startOffset = startLocation + size + MORTAR;   //'y' location for next grid row w/ offset

			singleRow(g, x, startLocation, tilePairs, size);
			singleRow(g, x + rowOffset, startOffset, tilePairs, size);

		}
	}

}
