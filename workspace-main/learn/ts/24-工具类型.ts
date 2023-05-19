export { }

interface PItf {
    name: string,
    age: number,
    height?: number
}

// type Partial<T> = { [P in keyof T]?: T[P] | undefined; }

let obj: Partial<PItf> = {
    name: '',
}

let obj2: Required<PItf> = {
    name: '',
    age: 12,
    height: 180
}