package ex6;

import java.util.List;

public class Main {

	public static void main(String[] args) {
	Grid grid = new Grid();
	grid.initializeGrid();
	
	for (int i = 0; i < args.length; i++) {
		StringConverter input = new StringConverter(args[i]);
		List<Integer> firstCoordinate = input.getFirstCoordinate(input.getInput());
		List<Integer> lastCoordinate = input.getLastCoordinate(input.getInput());
		for(int y = firstCoordinate.get(0); y < lastCoordinate.get(0)+1; y++) {
			for (int x = firstCoordinate.get(1); x < lastCoordinate.get(1)+1; x++) {
				grid.changeLightBehaviour(x, y, grid.grid[x][y], args[i]);
			}
		}
	}
	System.out.println(grid.countTurnedOnLights());
	}

}
