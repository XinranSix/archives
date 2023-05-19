export { }

class Person {

    public myName: string

    constructor(name: string = '默认名称') {
        this.myName = name
    }
    getName() {
        return this.myName
    }
}

let p = new Person('张三')
console.log(p);
console.log(p.getName())

let obj: Person = {
    myName: '',
    getName(): string {
        return ''
    }
}

