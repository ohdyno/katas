import { Grid } from "./Grid";

/*
Simplest Testing Situations:
- Create empty grid
- Play game with an empty grid
- Add 1 pixel to empty grid and check if it is alive (before playing)
- Play game with 1 seed (pixel) alive
- .....


 */


test('should return blank grid', () => {
  const grid = new Grid(5,5);
  expect(grid.isEmpty()).toBeTruthy();
});

it("should add seed to grid", () => {
  const grid = new Grid(5,5);
   grid.addSeed(1,2);
  expect(grid.isAlive(1,2)).toBeTruthy();
});
