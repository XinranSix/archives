"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Person {
    constructor(name = '默认名称') {
        this.myName = name;
    }
    getName() {
        return this.myName;
    }
}
let p = new Person('张三');
console.log(p);
console.log(p.getName());
let obj = {
    myName: '',
    getName() {
        return '';
    }
};
