export { }

type ObjType = {
    myName: string,
    Person: (name: string) => void
}

let obj: ObjType = {
    myName: '张三',
    Person: (name: string): void => { }
}

function Person(this: ObjType | Window, name: string): void {
    this.myName = name
}

obj.Person = Person
obj.Person('')

window.Person = Person
window.Person('')
