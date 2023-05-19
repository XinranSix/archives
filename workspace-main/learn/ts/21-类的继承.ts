export { }

class Person {
    myName: string

    constructor(name: string) {
        this.myName = name
    }

    getName(): string {
        return this.myName
    }
}

class Male extends Person {
    age: number
    constructor(name: string, age: number) {
        super(name)
        this.age = age
    }

    getName():string {
        return `我叫：${this.myName}`
    }
}

let m = new Male('张三', 17)

console.log(m.getName(), m.age);
