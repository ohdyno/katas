const fizzbuzz = () => {
  return this.foo;
};

class Foo {
  constructor() {
    this._bar = "bar";
    this._baz = "baz";
  }

  bar() {
    return this._bar;
  }

  baz = () => this._baz;
}

const foo = function() {
  return this.bar;
};

function changing() {
  return this.context;
}

const contextA = {
  context: "A",
  changing: changing
};

function contextB() {
  return changing();
}

contextB.context = "B";
contextB.changing = changing;

test("renders learn react link", () => {
  expect(contextA.changing()).toEqual("A");
  expect(contextB()).toEqual("B");

  const foo1 = new Foo();

  const newBar = foo1.bar.bind({
    _bar: "foobar"
  });

  expect(newBar.apply()).toEqual("foobar");

  expect(foo1.bar()).toEqual("bar");

  expect(new Foo().baz.bind({
    _bar: "foobar"
  }).apply()).toEqual("baz");
});

