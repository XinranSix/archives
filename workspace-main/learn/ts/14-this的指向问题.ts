export { }

function Person(this: Window, name: string) {
   // this.myName = name
}

window.Person = Person
window.Person('')