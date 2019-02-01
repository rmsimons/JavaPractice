
import java.awt.*;
import java.util.Arrays;

public class Doodle {

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(300, 300);
		Graphics g = panel.getGraphics();

		g.setColor(new Color(61, 202, 169));
		g.fillRect(25, 25, 100, 100);
		g.setColor(Color.BLACK);
		g.drawRect(25, 25, 100, 100);

		g.setColor(new Color(255, 128, 0));
		g.fillRect(25, 175, 200, 50);
		g.setColor(Color.BLACK);
		g.drawRect(25, 175, 200, 50);

		g.setColor(new Color(255, 0, 127));
		g.fillOval(175, 25, 75, 75);
		g.setColor(Color.BLACK);
		g.drawOval(175, 25, 75, 75);

	}

}



char[] tempChar = Arrays.copyOf(strData, strData.length + value);
for (int i = strData.length; i < tempChar.length; i++) {
	tempChar[i] = letter;
}
Arrays.sort(tempChar);
this.strData = tempChar;
for (int i = 0; i < strData.length; i++) {
	numData[strData[i] - 'a'] += 1;
}


// take in a LetterInventory object, return a LetterInventory object which is the sum of other two
// LetterInventory objects
public LetterInventory add(LetterInventory other){
	LetterInventory sum = new LetterInventory("");
	for (int i = 0; i < DEFAULT_CAPACITY; i++)
		sum.elementData[i] = this.elementData[i] + other.elementData[i];
	sum.size = this.size + other.size;
	return sum;
}
// take in a LetterInventory object, return a LetterInventory object of difference of other two
// LetterInventory objects a null LetterInventory object will be returned if any letter's
// difference less than 0
public LetterInventory subtract(LetterInventory other){
	LetterInventory result = new LetterInventory("");
	for (int i = 0; i < DEFAULT_CAPACITY; i++){
		result.elementData[i] = this.elementData[i] - other.elementData[i];
		if (result.elementData[i] < 0)
			return null;
		result.size += result.elementData[i];
	}
	return result;
}
}



