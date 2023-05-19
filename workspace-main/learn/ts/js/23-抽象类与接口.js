"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Person {
    getAge() {
        return 11;
    }
}
class Male extends Person {
    constructor() {
        super(...arguments);
        this.name = '张三';
    }
    getName() {
        return this.name;
    }
}
let m1 = new Male();
console.log(m1.getName());
console.log(m1.getAge());
class M {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    getName() {
        return this.name;
    }
}
let m = new M('李四', 23);
console.log(m);
m.name = 'x';
