export { }

interface NameItf {
    readonly name: string
}

interface AgeItf {
    age?: number
}

interface PersonItf extends NameItf, AgeItf {
    height: number
}

let p: PersonItf = {
    name: '张三',
    age: 18,
    height: 180
}

// p.name = '李四'

interface AItf {
    a: number
}

interface AItf {
    b: string
}

let obj: AItf = {
    a: 1,
    b: 'a'
}