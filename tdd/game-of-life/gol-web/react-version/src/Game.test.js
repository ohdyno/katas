import {  screen } from '@testing-library/react';

class Grid {
  constructor(number, number2) {

  }

  isEmpty() {
    return true;
  }

  addSeed(number, number2) {

  }

  isAlive(number, number2) {
    return true;
  }
}

test('should return blank grid', () => {
  const grid = new Grid(5,5);
  expect(grid.isEmpty()).toBeTruthy();
});

it("should add seed to grid", () => {
  const grid = new Grid(5,5);
   grid.addSeed(1,2);
  expect(grid.isAlive(1,2)).toBeTruthy();
});
