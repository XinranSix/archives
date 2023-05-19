export { }

interface Person {
    name: string,
    age: number
    [idx: number]: number | string
    [idx: string]: number | string
}

type PType = keyof Person
let p1: PType;
p1 = 'age'
p1 = 1

