"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Person {
    constructor(name) {
        this.myName = name;
    }
    getName() {
        return this.myName;
    }
}
class Male extends Person {
    constructor(name, age) {
        super(name);
        this.age = age;
    }
    getName() {
        return `我叫：${this.myName}`;
    }
}
let m = new Male('张三', 17);
console.log(m.getName(), m.age);
