export { }

abstract class Person {
    abstract name: string;
    abstract getName(): string;
    getAge(): number {
        return 11
    }
}

class Male extends Person {
    name: string = '张三'
    getName(): string {
        return this.name
    }
}

let m1 = new Male()

console.log(m1.getName());
console.log(m1.getAge());

interface PerItf {
    name: string
    age: number
    getName: () => string
}

class M implements PerItf {
    name: string
    age: number
    constructor(name: string, age: number) {
        this.name = name
        this.age = age
    }
    getName() {
        return this.name
    }
}

let m = new M('李四', 23)

console.log(m);

m.name = 'x'