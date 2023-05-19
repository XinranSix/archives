"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
let obj = {
    myName: '张三',
    Person: (name) => { }
};
function Person(name) {
    this.myName = name;
}
obj.Person = Person;
obj.Person('');
window.Person = Person;
window.Person('');
